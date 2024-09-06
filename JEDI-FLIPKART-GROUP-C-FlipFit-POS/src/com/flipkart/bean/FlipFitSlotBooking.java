package com.flipkart.bean;

import com.flipkart.enums.SlotBookingStatusEnum;

import java.time.LocalDate;
import java.util.Date;

public class FlipFitSlotBooking {
    private String bookingId;
    private String userId;
    private FlipFitCenterSlot centerSlot;
    private LocalDate slotDate;
    private Date bookingDate;
    private SlotBookingStatusEnum status;


    private String paymentId;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String id) {
        this.bookingId = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public FlipFitCenterSlot getCenterSlot() {
        return centerSlot;
    }

    public void setCenterSlot(FlipFitCenterSlot centerSlot) {
        this.centerSlot = centerSlot;
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

    public void bookSlot() {
        // interact with DAO to let customers block slots
    }

    public void cancelSlot() {
        // interact with DAO to let customers cancel their slot booking
    }
}
