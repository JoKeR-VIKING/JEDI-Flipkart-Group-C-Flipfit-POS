package com.flipkart.bean;

import java.time.LocalTime;

public class FlipFitCenterSlot {
    private String slotId;
    private String centreId;
    private LocalTime startTime;
    private int seatLimit;

    public FlipFitCenterSlot(String slotId, String centreId, LocalTime startTime, int seatLimit) {
        this.slotId = slotId;
        this.centreId = centreId;
        this.startTime = startTime;
        this.seatLimit = seatLimit;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getSeatLimit() {
        return seatLimit;
    }

    public void setSeatLimit(int seatLimit) {
        this.seatLimit = seatLimit;
    }
}
