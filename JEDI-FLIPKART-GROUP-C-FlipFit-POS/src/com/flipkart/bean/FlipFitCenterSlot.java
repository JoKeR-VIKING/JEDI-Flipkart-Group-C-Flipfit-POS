package com.flipkart.bean;

import java.time.LocalTime;

/**
 * Represents a time slot at a fitness center with details about the slot.
 */
public class FlipFitCenterSlot {

    private String slotId;
    private String centreId;
    private LocalTime startTime;
    private int seatLimit;

    /**
     * Constructs a new FlipFitCenterSlot with the specified details.
     *
     * @param slotId    the unique identifier for the slot
     * @param centreId  the unique identifier for the center
     * @param startTime the start time of the slot
     * @param seatLimit the maximum number of seats available in the slot
     */
    public FlipFitCenterSlot(String slotId, String centreId, LocalTime startTime, int seatLimit) {
        this.slotId = slotId;
        this.centreId = centreId;
        this.startTime = startTime;
        this.seatLimit = seatLimit;
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
     * @return the start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the slot.
     *
     * @param startTime the new start time
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
}
