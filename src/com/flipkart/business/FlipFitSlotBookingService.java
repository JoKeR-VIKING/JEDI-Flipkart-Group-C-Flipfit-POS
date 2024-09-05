package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class FlipFitSlotBookingService implements  FlipFitSlotBookingInterface {
    @Override
    public void bookSlot(String userId, String centerId, LocalDate bookingDate, FlipFitCenterSlot slot) {

    }

    @Override
    public void cancelBooking(String bookingId) {

    }

    @Override
    public List<FlipFitSlotBooking> listBookings(String userId) {
        return new ArrayList<>();
    }
}
