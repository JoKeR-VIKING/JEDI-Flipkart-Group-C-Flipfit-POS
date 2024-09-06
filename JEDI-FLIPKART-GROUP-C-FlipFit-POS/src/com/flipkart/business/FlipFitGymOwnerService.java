package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.utils.Helper;
import java.time.LocalTime;
import java.util.List;

import static com.flipkart.dao.FlipFitGymOwnerDAO.FlipFitGymOwnerDAOInst;

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
        FlipFitGymOwnerDAOInst.addGym(centre);
    }

    @Override
    public void removeGym(String centreId) {
        FlipFitGymOwnerDAOInst.removeGym(centreId);
    }

    @Override
    public List<FlipFitCentre> viewRegisteredGymCenters(String userId) {
        return FlipFitGymOwnerDAOInst.getRegisteredGymCentres(userId);
    }

    @Override
    public void addSlot(String slotId, String centreId, LocalTime startTime, Integer noOfSeats) {
        FlipFitCenterSlot slot = new FlipFitCenterSlot(Helper.generateId(), centreId, startTime, noOfSeats);
        FlipFitGymOwnerDAOInst.addSlot(slot);
    }

    @Override
    public void removeSlot(String slotId) {
        FlipFitGymOwnerDAOInst.deleteSlot(slotId);
    }

    @Override
    public void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) {
        FlipFitGymOwnerDAOInst.updateSlot(slotId, startTime, noOfSeats);
    }

    public FlipFitCenterSlot getSlot(String slotId) {
        return FlipFitGymOwnerDAOInst.getSlotById(slotId);
    }

    @Override
    public List<FlipFitCenterSlot> viewAllSlots(String centreId) {
        return FlipFitGymOwnerDAOInst.getSlotsByGymId(centreId);
    }
}
