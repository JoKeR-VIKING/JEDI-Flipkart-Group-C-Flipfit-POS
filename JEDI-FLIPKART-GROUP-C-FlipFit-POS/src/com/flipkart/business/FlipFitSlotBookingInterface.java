package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.GymSlotSeatLimitReachedException;
import com.flipkart.exception.InvalidBookingException;
import com.flipkart.exception.InvalidSlotException;

import java.time.LocalDate;
import java.util.List;

public interface FlipFitSlotBookingInterface {
    void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId) throws GymSlotSeatLimitReachedException, InvalidSlotException;

    List<FlipFitSlotBooking> listBookings(String userId);

    void cancelBooking(String bookingId) throws InvalidBookingException;
}
