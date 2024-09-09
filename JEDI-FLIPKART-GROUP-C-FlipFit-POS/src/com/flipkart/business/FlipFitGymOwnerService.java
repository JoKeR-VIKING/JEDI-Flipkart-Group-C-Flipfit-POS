package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.*;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.flipkart.dao.FlipFitCenterSlotDAOImpl.FlipFitCenterSlotDAOInst;
import static com.flipkart.dao.FlipFitGymOwnerDAOImpl.FlipFitGymOwnerDAOInst;
import static com.flipkart.dao.FlipFitCentreDAOImpl.FlipFitCentreDAOInst;
import static com.flipkart.dao.FlipFitSlotBookingDAOImpl.FlipFitSlotBookingDAOInst;

/**
 * Provides business logic for gym owner operations including managing gym profiles, gyms, slots, and bookings.
 */
public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {

    /**
     * Creates a new gym owner profile.
     *
     * @param username         The username for the gym owner.
     * @param password         The password for the gym owner.
     * @param name             The name of the gym owner.
     * @param address          The address of the gym owner.
     * @param phoneNumber      The phone number of the gym owner.
     * @param gstNumber        The GST number of the gym owner.
     * @param panCardNumber    The PAN card number of the gym owner.
     * @throws ExistingUserException If a user with the same username already exists.
     */
    @Override
    public void createProfile(String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) throws ExistingUserException {
        FlipFitGymOwner gymOwner = new FlipFitGymOwner(Helper.generateId(), username, password, name, address, phoneNumber, gstNumber, panCardNumber);
        FlipFitGymOwnerDAOInst.createProfile(gymOwner);
    }

    /**
     * Edits the profile of an existing gym owner.
     *
     * @param gymOwnerId       The ID of the gym owner.
     * @param address          The new address of the gym owner.
     * @param gstNumber        The new GST number of the gym owner.
     * @param panCardNumber    The new PAN card number of the gym owner.
     * @throws InvalidUserException If the gym owner ID is invalid.
     */
    @Override
    public void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) throws InvalidUserException {
        FlipFitGymOwnerDAOInst.editProfile(gymOwnerId, address, gstNumber, panCardNumber);
    }

    /**
     * Adds a new gym to the system.
     *
     * @param centreCity       The city where the new gym is located.
     * @param centreName       The name of the new gym.
     * @param centreAddress    The address of the new gym.
     * @param gymOwnerId       The ID of the gym owner.
     */
    @Override
    public void addGym(String centreCity, String centreName, String centreAddress, String gymOwnerId) {
        FlipFitCentre centre = new FlipFitCentre(Helper.generateId(), centreName, centreAddress, gymOwnerId, centreCity);
        FlipFitCentreDAOInst.addGym(centre);
    }

    /**
     * Removes an existing gym from the system.
     *
     * @param gymOwnerId       The ID of the gym owner.
     * @param centreId         The ID of the gym to be removed.
     * @throws UnauthorizedGymOwnerException If the gym owner is not authorized to remove the gym.
     */
    @Override
    public void removeGym(String gymOwnerId, String centreId) throws UnauthorizedGymOwnerException {
        FlipFitCentreDAOInst.removeGym(gymOwnerId, centreId);
    }

    @Override
    public List<FlipFitCentre> viewAllGymCentres(String userId) {
        return FlipFitCentreDAOInst.getAllGymCentres(userId);
    }

    /**
     * Retrieves all gyms registered under a specific gym owner.
     *
     * @param userId The ID of the gym owner.
     * @return A list of gyms registered under the specified gym owner.
     */
    @Override
    public List<FlipFitCentre> viewRegisteredGymCenters(String userId) {
        return FlipFitCentreDAOInst.getRegisteredGymCentres(userId);
    }

    /**
     * Adds a new slot to a specified gym.
     *
     * @param centreId         The ID of the gym.
     * @param startTime        The start time of the slot.
     * @param noOfSeats        The number of seats available in the slot.
     * @throws GymSlotAlreadyExistsException If a slot with the same start time already exists for the gym.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public void addSlot(String centreId, LocalTime startTime, Integer noOfSeats) throws GymSlotAlreadyExistsException, InvalidGymException {
        FlipFitCenterSlot slot = new FlipFitCenterSlot(Helper.generateId(), centreId, startTime, noOfSeats);
        FlipFitCenterSlotDAOInst.addSlot(slot);
    }

    /**
     * Removes an existing slot from the system.
     *
     * @param slotId The ID of the slot to be removed.
     * @throws InvalidSlotException If the slot ID is invalid.
     */
    @Override
    public void removeSlot(String slotId) throws InvalidSlotException {
        FlipFitCenterSlotDAOInst.deleteSlot(slotId);
    }

    /**
     * Updates the details of an existing slot.
     *
     * @param slotId        The ID of the slot to be updated.
     * @param startTime     The new start time of the slot.
     * @param noOfSeats     The new number of seats available in the slot.
     * @throws InvalidSlotException If the slot ID is invalid.
     */
    @Override
    public void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) throws InvalidSlotException {
        FlipFitCenterSlotDAOInst.updateSlot(slotId, startTime, noOfSeats);
    }

    /**
     * Retrieves details of a specific slot.
     *
     * @param slotId The ID of the slot.
     * @return The slot details.
     */
    public FlipFitCenterSlot getSlot(String slotId) {
        return FlipFitCenterSlotDAOInst.getSlotById(slotId);
    }

    /**
     * Retrieves all slots for a specific gym.
     *
     * @param centreId The ID of the gym.
     * @return A list of slots available in the specified gym.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public List<FlipFitCenterSlot> viewAllSlots(String centreId) throws InvalidGymException {
        return FlipFitCenterSlotDAOInst.getSlotsByGymId(centreId);
    }

    /**
     * Modifies the details of an existing gym.
     *
     * @param ownerId      The ID of the gym owner.
     * @param gymId        The ID of the gym to be modified.
     * @param city         The new city of the gym.
     * @param gymName      The new name of the gym.
     * @param gymAddress   The new address of the gym.
     * @return true if the modification was successful, false otherwise.
     * @throws UnauthorizedGymOwnerException If the gym owner is not authorized to modify the gym.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public boolean modifyGym(String ownerId, String gymId, String city, String gymName, String gymAddress) throws UnauthorizedGymOwnerException, InvalidGymException {
        return FlipFitCentreDAOInst.modifyGym(ownerId, gymId, city, gymName, gymAddress);
    }

    /**
     * Retrieves all available slots for a specific gym on a given date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which to retrieve available slots.
     * @return A list of available slots for the specified gym on the given date.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public List<FlipFitCenterSlot> viewAvailableSlots(String gymId, LocalDate date) throws InvalidGymException {
        return FlipFitCenterSlotDAOInst.getAvailableSlots(gymId, date);
    }

    /**
     * Retrieves all bookings for a specific gym on a given date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which to retrieve bookings.
     * @return A list of bookings for the specified gym on the given date.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public List<FlipFitSlotBooking> viewAllBookingsByGymIdAndDate(String gymId, LocalDate date) throws InvalidGymException {
        return FlipFitSlotBookingDAOInst.getAllBookingsByGymIdAndDate(gymId, date);
    }

    /**
     * Retrieves a list of gyms located in a specific city and owned by a specific owner.
     *
     * @param city     The city in which to retrieve the gyms.
     * @param ownerId  The ID of the gym owner.
     * @return A list of gyms located in the specified city and owned by the specified owner.
     */
    @Override
    public List<FlipFitCentre> getGymListByCityAndOwner(String city, String ownerId) {
        return FlipFitCentreDAOInst.getGymListByCityAndOwner(city, ownerId);
    }
}
