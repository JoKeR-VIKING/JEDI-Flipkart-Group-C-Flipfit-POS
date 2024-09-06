package com.flipkart.bean;

import com.flipkart.enums.SlotBookingStatusEnum;

import java.time.LocalDate;
import java.util.Date;

public class FlipFitSlotBooking {
    private String bookingId;
    private String userId;
    private String centerSlotId;
    private LocalDate slotDate;
    private Date bookingDate;
    private SlotBookingStatusEnum status;
    private String paymentId;

    public FlipFitSlotBooking(String bookingId, String userId, String centerSlotId, LocalDate slotDate, Date bookingDate, SlotBookingStatusEnum status, String paymentId) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.centerSlotId = centerSlotId;
        this.slotDate = slotDate;
        this.bookingDate = bookingDate;
        this.status = status;
        this.paymentId = paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(int id) {
        this.bookingId = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCenterSlot() {
        return centerSlotId;
    }

    public void setCenterSlot(String centerSlot) {
        this.centerSlotId = centerSlot;
    }

    public LocalDate getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(LocalDate slotDate) {
        this.slotDate = slotDate;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public SlotBookingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SlotBookingStatusEnum status) {
        this.status = status;
    }

    public String getPaymentId() { return paymentId; }

    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
}
