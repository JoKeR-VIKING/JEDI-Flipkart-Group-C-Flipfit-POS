package com.flipkart.bean;

import java.time.LocalTime;

public class FlipfitCenterSlot {
    private String id;
    private FlipfitCentre centre;
    private LocalTime startTime;
    private LocalTime endTime;
    private int seatLimit;

    public FlipfitCenterSlot(String _id, FlipfitCentre _centre, LocalTime _startTime, LocalTime _endTime, int _seatLimit) {
        id = _id;
        centre = _centre;
        startTime = _startTime;
        endTime = _endTime;
        seatLimit = _seatLimit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FlipfitCentre getCentre() {
        return centre;
    }

    public void setCentre(FlipfitCentre centre) {
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
