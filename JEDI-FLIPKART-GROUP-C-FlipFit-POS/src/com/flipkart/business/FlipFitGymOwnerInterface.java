package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.GymSlotAlreadyExistsException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipFitGymOwnerInterface {
    void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) throws ExistingUserException;

    void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber);

    void addGym(String centreName, String centreAddress, String gymOwnerId);

    void removeGym(String gymOwnerId, String centreId);

    boolean modifyGym(String gymOwnerId, String centreId, String gymName, String gymAddress);

    List<FlipFitCentre> viewRegisteredGymCenters(String userId);

    void addSlot(String centreId, LocalTime startTime, Integer noOfSeats) throws GymSlotAlreadyExistsException;

    void removeSlot(String slotId);

    void updateSlot(String centreId, LocalTime startTime, Integer noOfSeats);

    List<FlipFitCenterSlot> viewAllSlots(String centreId);

    List<FlipFitCenterSlot> viewAvailableSlots(String gymId, LocalDate date);

    List<FlipFitSlotBooking> viewAllBookingsByGymIdAndDate(String gymId, LocalDate date);
}
