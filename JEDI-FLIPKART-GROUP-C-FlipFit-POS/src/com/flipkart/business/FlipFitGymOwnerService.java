package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.flipkart.dao.FlipFitCenterSlotDAOImpl.FlipFitCenterSlotDAOInst;
import static com.flipkart.dao.FlipFitGymOwnerDAOImpl.FlipFitGymOwnerDAOInst;
import static com.flipkart.dao.FlipFitCentreDAOImpl.FlipFitCentreDAOInst;
import static com.flipkart.dao.FlipFitCentreSlotDAOImpl.FlipFitCentreSlotInst;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {
    @Override
    public void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) {
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(Helper.generateId(), username, password, name, address, phoneNumber, gstNumber, panCardNumber);
        FlipFitGymOwnerDAOInst.createProfile(gymOwner);
    }

    @Override
    public void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) {
        FlipFitGymOwnerDAOInst.editProfile(gymOwnerId, address, gstNumber, panCardNumber);
    }

    @Override
    public void addGym(String centreName, String centreAddress, String gymOwnerId) {
        FlipFitCentre centre = new FlipFitCentre(Helper.generateId(), centreName, centreAddress, gymOwnerId);
        FlipFitCentreDAOInst.addGym(centre);
    }

    @Override
    public void removeGym(String gymOwnerId, String centreId) {
        FlipFitCentreDAOInst.removeGym(gymOwnerId, centreId);
    }

    @Override
    public List<FlipFitCentre> viewRegisteredGymCenters(String userId) {
        return FlipFitCentreDAOInst.getRegisteredGymCentres(userId);
    }

    @Override
    public void addSlot(String slotId, String centreId, LocalTime startTime, Integer noOfSeats) {
        FlipFitCenterSlot slot = new FlipFitCenterSlot(Helper.generateId(), centreId, startTime, noOfSeats);
        FlipFitCenterSlotDAOInst.addSlot(slot);
    }

    @Override
    public void removeSlot(String slotId) {
        FlipFitCenterSlotDAOInst.deleteSlot(slotId);
    }

    @Override
    public void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) {
    }

    public FlipFitCenterSlot getSlot(String slotId) {
    }

    public FlipFitCenterSlot getSlot(String slotId) {
        return FlipFitCenterSlotDAOInst.getSlotById(slotId);
    }

    @Override
    public List<FlipFitCenterSlot> viewAllSlots(String centreId) {
        return FlipFitCenterSlotDAOInst.getSlotsByGymId(centreId);
    }

    @Override
    public boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress) {
        return FlipFitCentreDAOInst.modifyGym(ownerId, gymId, gymName, gymAddress);
    }

    @Override
    public List<FlipFitCenterSlot> viewAvailableSlots(String gymId, LocalDate date) {
        return FlipFitCenterSlotDAOInst.getSlotsByGymId(gymId);
    }
}
