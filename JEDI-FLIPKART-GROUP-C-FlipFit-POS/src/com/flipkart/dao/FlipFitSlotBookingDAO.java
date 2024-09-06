package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipFitSlotBookingDAO {
    public static List<FlipFitSlotBooking> bookings = new ArrayList<FlipFitSlotBooking>();
    public static List<FlipFitPayments> payments = new ArrayList<FlipFitPayments>();

    public static void addBooking(FlipFitSlotBooking booking) {
        bookings.add(booking);
    }
    public static void addPayment(FlipFitPayments payment) {
        if (payment.getStatus().equals("Success")) {
            payments.add(payment);
        }
    }

    public static void removeBooking(String bookingId) {
        bookings.removeIf(booking -> booking.getBookingId().equals(bookingId));
    }

    public static List<FlipFitSlotBooking> listBookings(String userId) {
        List<FlipFitSlotBooking> filteredBookings = new ArrayList<FlipFitSlotBooking>();
        for (FlipFitSlotBooking booking: bookings) {
            if (booking.getUserId().equals(userId)) {
                filteredBookings.add(booking);
            }
        }
        return filteredBookings;
    }
}
