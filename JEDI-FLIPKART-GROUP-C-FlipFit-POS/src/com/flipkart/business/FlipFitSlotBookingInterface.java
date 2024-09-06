package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;

import java.time.LocalDate;
import java.util.List;

public interface FlipFitSlotBookingInterface {
    void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId);

    List<FlipFitSlotBooking> listBookings(String userId);

    void cancelBooking(String bookingId);
}
