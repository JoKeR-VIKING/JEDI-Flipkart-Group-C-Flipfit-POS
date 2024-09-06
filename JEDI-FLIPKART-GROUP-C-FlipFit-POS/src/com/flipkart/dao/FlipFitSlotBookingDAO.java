package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;
import java.util.ArrayList;
import java.util.List;

public class FlipFitSlotBookingDAO {
    public static FlipFitSlotBookingDAO FlipFitSlotBookingDAOInst = new FlipFitSlotBookingDAO();

    public List<FlipFitSlotBooking> bookings = new ArrayList<FlipFitSlotBooking>();
    public List<FlipFitPayments> payments = new ArrayList<FlipFitPayments>();

    public void addBooking(FlipFitSlotBooking booking) {
        bookings.add(booking);
    }
    public void addPayment(FlipFitPayments payment) {
        if (payment.getStatus().equals("Success")) {
            payments.add(payment);
        }
    }

    public void removeBooking(String bookingId) {
        bookings.removeIf(booking -> booking.getBookingId().equals(bookingId));
    }

    public List<FlipFitSlotBooking> listBookings(String userId) {
        List<FlipFitSlotBooking> filteredBookings = new ArrayList<FlipFitSlotBooking>();
        for (FlipFitSlotBooking booking: bookings) {
            if (booking.getUserId().equals(userId)) {
                filteredBookings.add(booking);
            }
        }
        return filteredBookings;
    }
}
