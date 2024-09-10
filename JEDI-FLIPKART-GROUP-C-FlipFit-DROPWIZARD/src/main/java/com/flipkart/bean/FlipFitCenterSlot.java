package com.flipkart.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * Represents a time slot at a fitness center with details about the slot.
 */
public class FlipFitCenterSlot {
    @NotBlank
    private String slotId;
    @NotBlank
    private String centreId;
    @NotBlank
    private LocalTime startTime;
    @NotNull
    private int seatLimit;
    @NotNull
    private int availableSlots;

    /**
     * Constructs a new FlipFitCenterSlot with the specified details.
     *
     * @param slotId       the unique identifier for the slot
     * @param centreId     the unique identifier for the center
     * @param startTime    the start time of the slot
     * @param seatLimit    the maximum number of seats available in the slot
     */
    public FlipFitCenterSlot(String slotId, String centreId, LocalTime startTime, int seatLimit) {
        this.slotId = slotId;
        this.centreId = centreId;
        this.startTime = startTime;
        this.seatLimit = seatLimit;
    }

    /**
     * Constructs a new FlipFitCenterSlot with the specified details including available slots.
     *
     * @param slotId         the unique identifier for the slot
     * @param centreId       the unique identifier for the center
     * @param startTime      the start time of the slot
     * @param seatLimit      the maximum number of seats available in the slot
     * @param availableSlots the number of seats available for booking
     */
    public FlipFitCenterSlot(String slotId, String centreId, LocalTime startTime, int seatLimit, int availableSlots) {
        this(slotId, centreId, startTime, seatLimit);
        this.availableSlots = availableSlots;
    }

    /**
     * Returns the unique identifier for the slot.
     *
     * @return the slot ID
     */
    public String getSlotId() {
        return slotId;
    }

    /**
     * Sets the unique identifier for the slot.
     *
     * @param slotId the new slot ID
     */
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    /**
     * Returns the unique identifier for the center.
     *
     * @return the center ID
     */
    public String getCentreId() {
        return centreId;
    }

    /**
     * Sets the unique identifier for the center.
     *
     * @param centreId the new center ID
     */
    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    /**
     * Returns the start time of the slot.
     *
     * @return the start time of the slot
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the slot.
     *
     * @param startTime the new start time of the slot
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns the maximum number of seats available in the slot.
     *
     * @return the seat limit
     */
    public int getSeatLimit() {
        return seatLimit;
    }

    /**
     * Sets the maximum number of seats available in the slot.
     *
     * @param seatLimit the new seat limit
     */
    public void setSeatLimit(int seatLimit) {
        this.seatLimit = seatLimit;
    }

    /**
     * Returns the number of seats currently available for booking in the slot.
     *
     * @return the number of available slots
     */
    public int getAvailableSlots() {
        return availableSlots;
    }

    /**
     * Sets the number of seats currently available for booking in the slot.
     *
     * @param availableSlots the new number of available slots
     */
    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }
}
