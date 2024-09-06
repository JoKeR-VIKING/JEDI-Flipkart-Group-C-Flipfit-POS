package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.dao.FlipFitGymOwnerDAO;
import com.flipkart.utils.Helper;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {
    @Override
    public void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) {
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(Helper.generateId(), username, password, name, address, phoneNumber, gstNumber, panCardNumber);
        FlipFitGymOwnerDAO.createProfile(gymOwner);
    }

    @Override
    public void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) {
        FlipFitGymOwnerDAO.editProfile(gymOwnerId, address, gstNumber, panCardNumber);
    }

    @Override
    public void addGym(String centreName, String centreAddress, String gymOwnerId) {
        FlipFitCentre centre = new FlipFitCentre(Helper.generateId(), centreName, centreAddress, gymOwnerId);
        FlipFitGymOwnerDAO.addGym(centre);
    }

    @Override
    public void removeGym(String centreId) {
        FlipFitGymOwnerDAO.removeGym(centreId);
    }

    @Override
    public List<FlipFitCentre> viewRegisteredGymCenters(String userId) {
        return FlipFitGymOwnerDAO.getRegisteredGymCentres(userId);
    }

    @Override
    public void addSlot(String slotId, String centreId, LocalTime startTime, Integer noOfSeats) {
        FlipFitCenterSlot slot = new FlipFitCenterSlot(Helper.generateId(), centreId, startTime, noOfSeats);
        FlipFitGymOwnerDAO.addSlot(slot);
    }

    @Override
    public void removeSlot(String slotId) {
        FlipFitGymOwnerDAO.deleteSlot(slotId);
    }

    @Override
    public void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) {
        FlipFitGymOwnerDAO.updateSlot(slotId, startTime, noOfSeats);
    }

    @Override
    public List<FlipFitSlotBooking> viewAllSlots(String centreId) {
        return new ArrayList<>();
    }

    @Override
    public List<FlipFitSlotBooking> viewAllAvailableSlots(String centreId) {
        return new ArrayList<>();
    }
}
