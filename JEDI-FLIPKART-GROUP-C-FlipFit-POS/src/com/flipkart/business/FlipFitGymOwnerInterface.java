package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;

import java.time.LocalTime;
import java.util.List;

public interface FlipFitGymOwnerInterface {
    void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber);

    void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber);

    void addGym(String centreName, String centreAddress, String gymOwnerId);

    void removeGym(String removeGym, String centreId);

    List<FlipFitCentre> viewRegisteredGymCenters(String userId);

    void addSlot(String slotId, String centreId, LocalTime startTime, Integer noOfSeats);

    void removeSlot(String slotId);

    void updateSlot(String centreId, LocalTime startTime, Integer noOfSeats);

    List<FlipFitCenterSlot> viewAllSlots(String centreId);

}
