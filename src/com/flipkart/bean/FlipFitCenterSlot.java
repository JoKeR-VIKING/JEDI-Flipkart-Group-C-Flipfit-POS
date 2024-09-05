package com.flipkart.bean;

import java.time.LocalTime;

public class FlipFitCenterSlot {
    private String id;
    private String centreId;
    private LocalTime startTime;
    private int seatLimit;

    public FlipFitCenterSlot(String _id, String _centre, LocalTime _startTime, int _seatLimit) {
        id = _id;
        centreId = _centre;
        startTime = _startTime;
        seatLimit = _seatLimit;
    }
    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
