package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitSlotBooking;

import java.util.List;
import java.time.LocalTime;

public interface FlipFitGymOwnerInterface {
    public void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber);

    public void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber);

    public void addGym(String centreName, String centreAddress, String gymOwnerId);

    public void removeGym(String centreId);

    public List<FlipFitCentre> viewRegisteredGymCenters();

    public void addSlot(String slotId, String centreId, LocalTime startTime, Integer noOfSeats);

    public void removeSlot(String slotId);

    public void updateSlot(String centreId, LocalTime startTime, Integer noOfSeats);

    public List<FlipFitCenterSlot> viewAllSlots(String centreId);

    public List<FlipFitSlotBooking> viewAllAvailableSlots(String centreId);
}
