package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipFitGymOwnerInterface {
    void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) throws ExistingUserException;

    void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) throws InvalidUserException;

    void addGym(String centreName, String centreAddress, String gymOwnerId);

    void removeGym(String gymOwnerId, String centreId) throws UnauthorizedGymOwnerException;

    boolean modifyGym(String gymOwnerId, String centreId, String gymName, String gymAddress) throws UnauthorizedGymOwnerException;

    List<FlipFitCentre> viewRegisteredGymCenters(String userId);

    void addSlot(String centreId, LocalTime startTime, Integer noOfSeats) throws GymSlotAlreadyExistsException;

    void removeSlot(String slotId) throws InvalidSlotException;

    void updateSlot(String centreId, LocalTime startTime, Integer noOfSeats) throws InvalidSlotException;

    List<FlipFitCenterSlot> viewAllSlots(String centreId);

    List<FlipFitCenterSlot> viewAvailableSlots(String gymId, LocalDate date);

    List<FlipFitSlotBooking> viewAllBookingsByGymIdAndDate(String gymId, LocalDate date);
}
