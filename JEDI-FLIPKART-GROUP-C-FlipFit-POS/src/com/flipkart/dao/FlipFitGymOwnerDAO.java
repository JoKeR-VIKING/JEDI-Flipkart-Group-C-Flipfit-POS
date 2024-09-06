package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.flipkart.constants.SQLQueryConstants.INSERT_GYM_OWNER;
import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitGymOwnerDAO {
    public static FlipFitGymOwnerDAO FlipFitGymOwnerDAOInst = new FlipFitGymOwnerDAO();

    // TODO: remove after sql impl
    static {
        refreshGymOwners();
    }

    // TODO: remove after sql impl
    public List<FlipFitGymOwner> GymOwners = Collections.emptyList();

    // TODO: make FlipFitCentre dao and remove this
    public List<FlipFitCentre> Gyms = new ArrayList<>();

    // TODO: make FlipFitCenterSlot dao and remove this
    public List<FlipFitCenterSlot> slots = new ArrayList<>();

    // TODO: remove after sql impl
    public static void refreshGymOwners() {
        FlipFitGymOwnerDAOInst.GymOwners = FlipFitUserDAOInst.USERS.stream()
                .filter(user -> (user instanceof FlipFitGymOwner))
                .map(user -> (FlipFitGymOwner) user)
                .toList();
    }

    public void add(FlipFitGymOwner gymOwner) {
        FlipFitUserDAOInst.add(gymOwner);

        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_GYM_OWNER);
            stmt.setString(1, gymOwner.getUserId());
            stmt.setString(2, gymOwner.getGstNumber());
            stmt.setString(3, gymOwner.getPanCardNumber());
            stmt.setString(4, gymOwner.getVerified());

            return stmt.executeUpdate();
        });
    }

    public void createProfile(FlipFitGymOwner gymOwner) {
        add(gymOwner);
    }

    // TODO: sql
    public void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) {
        for (FlipFitGymOwner gymOwner : GymOwners) {
            if (!gymOwner.getUserId().equals(gymOwnerId))
                continue;

            gymOwner.setAddress(address);
            gymOwner.setGstNumber(gstNumber);
            gymOwner.setPanCardNumber(panCardNumber);
            break;
        }
    }

    // TODO: should be in FlipFitCentreDAO
    public void addGym(FlipFitCentre centre) {
        Gyms.add(centre);
    }

    // TODO: should be in FlipFitCentreDAO
    public void removeGym(String ownerId, String centreId) {
        Gyms.removeIf(centre -> centre.getCentreId().equals(centreId) && centre.getGymOwnerId().equals(ownerId));
    }

    // TODO: should be in FlipFitCentreDAO
    public List<FlipFitCentre> getRegisteredGymCentres(String userId) {
        return Gyms.stream()
                .filter(centre -> centre.getVerified().equals("APPROVED"))
                .filter(center -> center.getGymOwnerId().equals(userId))
                .toList();
    }

    // TODO: should be in FlipFitCenterSlotDAO
    public void addSlot(FlipFitCenterSlot slot) {
        slots.add(slot);
    }

    // TODO: should be in FlipFitCenterSlotDAO
    public void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) {
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).getSlotId().equals(slotId)) {
                slots.get(i).setStartTime(startTime);
                slots.get(i).setSeatLimit(noOfSeats);
            }
        }
    }

    // TODO: should be in FlipFitCenterSlotDAO
    public List<FlipFitCenterSlot> getSlotsByGymId(String gymId) {
        return slots.stream()
                .filter(slot -> slot.getCentreId().equals(gymId))
                .toList();
    }

    // TODO: should be in FlipFitCenterSlotDAO
    public FlipFitCenterSlot getSlotById(String slotId) {
        return slots.stream()
                .filter(slot -> slot.getSlotId().equals(slotId))
                .toList().get(0);
    }

    // TODO: should be in FlipFitCenterSlotDAO
    public void deleteSlot(String slotId) {
        slots.removeIf(slot -> slot.getSlotId().equals(slotId));
    }

    // TODO: should be in FlipFitCentreDAO
    public boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress) {
        for (int i = 0; i < Gyms.size(); i++) {
            if (Gyms.get(i).getCentreId().equals(gymId) && Gyms.get(i).getGymOwnerId().equals(ownerId)) {
                Gyms.get(i).setCentreName(gymName);
                Gyms.get(i).setCentreAddress(gymAddress);
                return true;
            }
        }
        return false;
    }
}