package com.flipkart.bean;

import java.time.LocalTime;

public class FlipFitCenterSlot {
    private String id;
    private FlipFitCentre centre;
    private LocalTime startTime;
    private LocalTime endTime;
    private int seatLimit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FlipFitCentre getCentre() {
        return centre;
    }

    public void setCentre(FlipFitCentre centre) {
        this.centre = centre;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getSeatLimit() {
        return seatLimit;
    }

    public void setSeatLimit(int seatLimit) {
        this.seatLimit = seatLimit;
    }
}
