package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Interface defining the operations that can be performed by a gym owner in the FlipFit system.
 * This includes managing gym profiles, adding or modifying gyms, managing slots, and viewing bookings.
 */
public interface FlipFitGymOwnerInterface {

    /**
     * Creates a new gym owner profile.
     *
     * @param username the username for the new gym owner
     * @param password the password for the new gym owner
     * @param name the name of the new gym owner
     * @param address the address of the new gym owner
     * @param phoneNumber the phone number of the new gym owner
     * @param gstNumber the GST number of the new gym owner
     * @param panCardNumber the PAN card number of the new gym owner
     * @throws ExistingUserException if a user with the same username already exists
     */
    void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) throws ExistingUserException;

    /**
     * Edits an existing gym owner profile.
     *
     * @param gymOwnerId the unique identifier of the gym owner whose profile is to be edited
     * @param address the updated address of the gym owner
     * @param gstNumber the updated GST number of the gym owner
     * @param panCardNumber the updated PAN card number of the gym owner
     * @throws InvalidUserException if the gym owner ID is invalid or if the operation fails
     */
    void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) throws InvalidUserException;

    /**
     * Adds a new gym to the system.
     *
     * @param centreName the name of the new gym
     * @param centreAddress the address of the new gym
     * @param gymOwnerId the ID of the gym owner adding the gym
     */
    void addGym(String centreName, String centreAddress, String gymOwnerId);

    /**
     * Removes an existing gym from the system.
     *
     * @param gymOwnerId the ID of the gym owner requesting the removal
     * @param centreId the ID of the gym to be removed
     * @throws UnauthorizedGymOwnerException if the gym owner is not authorized to remove the gym
     */
    void removeGym(String gymOwnerId, String centreId) throws UnauthorizedGymOwnerException;

    /**
     * Modifies the details of an existing gym.
     *
     * @param gymOwnerId the ID of the gym owner requesting the modification
     * @param centreId the ID of the gym to be modified
     * @param gymName the new name for the gym
     * @param gymAddress the new address for the gym
     * @return true if the modification is successful, false otherwise
     * @throws UnauthorizedGymOwnerException if the gym owner is not authorized to modify the gym
     */
    boolean modifyGym(String gymOwnerId, String centreId, String gymName, String gymAddress) throws UnauthorizedGymOwnerException;

    /**
     * Views all registered gym centers for a given user.
     *
     * @param userId the ID of the user whose gym centers are to be viewed
     * @return a list of registered gym centers
     */
    List<FlipFitCentre> viewRegisteredGymCenters(String userId);

    /**
     * Adds a new slot to a gym.
     *
     * @param centreId the ID of the gym where the slot is to be added
     * @param startTime the start time of the new slot
     * @param noOfSeats the number of seats available in the new slot
     * @throws GymSlotAlreadyExistsException if a slot with the same start time already exists in the gym
     */
    void addSlot(String centreId, LocalTime startTime, Integer noOfSeats) throws GymSlotAlreadyExistsException;

    /**
     * Removes an existing slot from a gym.
     *
     * @param slotId the ID of the slot to be removed
     * @throws InvalidSlotException if the slot ID is invalid or if the operation fails
     */
    void removeSlot(String slotId) throws InvalidSlotException;

    /**
     * Updates the details of an existing slot.
     *
     * @param centreId the ID of the gym where the slot is located
     * @param startTime the new start time for the slot
     * @param noOfSeats the new number of seats for the slot
     * @throws InvalidSlotException if the slot is invalid or if the operation fails
     */
    void updateSlot(String centreId, LocalTime startTime, Integer noOfSeats) throws InvalidSlotException;

    /**
     * Views all slots for a given gym center.
     *
     * @param centreId the ID of the gym center whose slots are to be viewed
     * @return a list of all slots for the specified gym center
     */
    List<FlipFitCenterSlot> viewAllSlots(String centreId);

    /**
     * Views available slots for a given gym on a specific date.
     *
     * @param gymId the ID of the gym whose slots are to be viewed
     * @param date the date for which available slots are to be viewed
     * @return a list of available slots for the specified gym on the specified date
     */
    List<FlipFitCenterSlot> viewAvailableSlots(String gymId, LocalDate date);

    /**
     * Views all bookings for a given gym on a specific date.
     *
     * @param gymId the ID of the gym whose bookings are to be viewed
     * @param date the date for which bookings are to be viewed
     * @return a list of all bookings for the specified gym on the specified date
     */
    List<FlipFitSlotBooking> viewAllBookingsByGymIdAndDate(String gymId, LocalDate date);
}
