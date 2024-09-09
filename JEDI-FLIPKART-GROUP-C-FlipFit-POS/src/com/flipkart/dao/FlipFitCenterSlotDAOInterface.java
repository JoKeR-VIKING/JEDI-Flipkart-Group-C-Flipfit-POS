package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.exception.GymSlotAlreadyExistsException;
import com.flipkart.exception.InvalidSlotException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Interface for FlipFit Center Slot Data Access Object (DAO) operations.
 * Provides methods to handle slot-related functionalities for gym centres.
 */
public interface FlipFitCenterSlotDAOInterface {

    /**
     * Finds a slot by its unique slot ID.
     *
     * @param slotId The unique ID of the slot to be retrieved.
     * @return The FlipFitCenterSlot object if found, otherwise null.
     */
    FlipFitCenterSlot findSlotBySlotId(String slotId);

    /**
     * Finds a slot by gym centre ID and its start time.
     *
     * @param centreId The ID of the gym centre where the slot exists.
     * @param startTime The start time of the slot to be found.
     * @return The FlipFitCenterSlot object if found, otherwise null.
     */
    FlipFitCenterSlot findSlotByCentreAndStartTime(String centreId, LocalTime startTime);

    /**
     * Adds a new slot to the system.
     *
     * @param slot The FlipFitCenterSlot object representing the slot to be added.
     * @throws GymSlotAlreadyExistsException If a slot with the same details already exists.
     */
    void addSlot(FlipFitCenterSlot slot) throws GymSlotAlreadyExistsException;

    /**
     * Updates an existing slot in the system.
     *
     * @param slotId The unique ID of the slot to be updated.
     * @param startTime The new start time for the slot.
     * @param noOfSeats The new number of seats available for the slot.
     * @throws InvalidSlotException If the slot ID is invalid or not found.
     */
    void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) throws InvalidSlotException;

    /**
     * Retrieves all slots for a specific gym based on the gym ID.
     *
     * @param gymId The unique ID of the gym to retrieve slots for.
     * @return A List of FlipFitCenterSlot objects representing the slots available for the gym.
     */
    List<FlipFitCenterSlot> getSlotsByGymId(String gymId);

    /**
     * Retrieves a specific slot by its unique ID.
     *
     * @param slotId The unique ID of the slot to be retrieved.
     * @return The FlipFitCenterSlot object if found, otherwise null.
     */
    FlipFitCenterSlot getSlotById(String slotId);

    /**
     * Deletes a slot from the system.
     *
     * @param slotId The unique ID of the slot to be deleted.
     * @throws InvalidSlotException If the slot ID is invalid or not found.
     */
    void deleteSlot(String slotId) throws InvalidSlotException;

    /**
     * Retrieves all available slots for a specific gym on a particular date.
     *
     * @param gymId The unique ID of the gym to retrieve available slots for.
     * @param date The date on which to retrieve available slots.
     * @return A List of FlipFitCenterSlot objects representing available slots for the gym on the specified date.
     */
    List<FlipFitCenterSlot> getAvailableSlots(String gymId, LocalDate date);
}
