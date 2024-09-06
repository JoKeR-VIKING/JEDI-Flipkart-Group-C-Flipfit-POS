package com.flipkart.dao;

import com.flipkart.bean.FlipFitSlotBooking;

import java.util.Collections;
import java.util.List;

public class FlipFitSlotBookingDAO {

    public static List<FlipFitSlotBooking> bookings = Collections.emptyList();

    public static void add(FlipFitSlotBooking booking) {
        bookings.add(booking);
    }
}
