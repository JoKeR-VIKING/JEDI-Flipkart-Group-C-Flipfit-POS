package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitCentre;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public class FlipFitGymOwnerDAO {
    public static FlipFitGymOwnerDAO FlipFitGymOwnerDAOInst = new FlipFitGymOwnerDAO();

    public List<FlipFitGymOwner> GymOwners = Collections.emptyList();
    public List<FlipFitCentre> Gyms = new ArrayList<>();
    public List<FlipFitCenterSlot> slots = new ArrayList<>();

    static {
        refreshGymOwners();
    }

    public static void refreshGymOwners() {
        FlipFitGymOwnerDAOInst.GymOwners = FlipFitUserDAOInst.USERS.stream()
                .filter(user -> (user instanceof FlipFitGymOwner))
                .map(user -> (FlipFitGymOwner) user)
                .toList();
    }

    public void add(FlipFitGymOwner gymOwner) {
        FlipFitUserDAOInst.add(gymOwner);
        refreshGymOwners();
    }

    public void createProfile(FlipFitGymOwner gymOwner) {
        add(gymOwner);
    }

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

    public void addGym(FlipFitCentre centre) {
        Gyms.add(centre);
    }

    public void removeGym(String ownerId, String centreId) {
        Gyms.removeIf(centre -> centre.getCentreId().equals(centreId) && centre.getGymOwnerId().equals(ownerId));
    }

    public List<FlipFitCentre> getRegisteredGymCentres(String userId) {
        return Gyms.stream()
            .filter(centre -> centre.getVerified().equals("APPROVED"))
            .filter(center -> center.getGymOwnerId().equals(userId))
            .toList();
    }

    public void addSlot(FlipFitCenterSlot slot) {
        slots.add(slot);
    }

    public void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) {
        for(int i=0; i<slots.size(); i++) {
            if (slots.get(i).getSlotId().equals(slotId)) {
                slots.get(i).setStartTime(startTime);
                slots.get(i).setSeatLimit(noOfSeats);
            }
        }
    }

    public List<FlipFitCenterSlot> getSlotsByGymId(String gymId) {
        return slots.stream()
                .filter(slot -> slot.getCentreId().equals(gymId))
                .toList();
    }

    public FlipFitCenterSlot getSlotById(String slotId) {
        return slots.stream()
                .filter(slot -> slot.getSlotId().equals(slotId))
                .toList().get(0);
    }

    public void deleteSlot(String slotId) {
        slots.removeIf(slot -> slot.getSlotId().equals(slotId));
    }

    public boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress) {
        for(int i=0; i<Gyms.size(); i++) {
            if (Gyms.get(i).getCentreId().equals(gymId) && Gyms.get(i).getGymOwnerId().equals(ownerId)) {
                Gyms.get(i).setCentreName(gymName);
                Gyms.get(i).setCentreAddress(gymAddress);
                return true;
            }
        }
        return false;
    }
}