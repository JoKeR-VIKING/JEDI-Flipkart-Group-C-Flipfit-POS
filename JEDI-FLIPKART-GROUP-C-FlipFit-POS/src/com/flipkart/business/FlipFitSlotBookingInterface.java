package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;

import java.time.LocalDate;
import java.util.List;

public interface FlipFitSlotBookingInterface {
    public abstract void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId);

    public abstract List<FlipFitSlotBooking> listBookings(String userId);

    public abstract void cancelBooking(String bookingId);
}
