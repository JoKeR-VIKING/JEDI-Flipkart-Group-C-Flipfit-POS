package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;

import java.util.ArrayList;
import java.util.List;

public interface FlipFitSlotBookingDAOInterface {
    void addBooking(FlipFitSlotBooking booking);

    void addPayment(FlipFitPayments payment) ;

    void removeBooking(String bookingId);

    List<FlipFitSlotBooking> listBookings(String userId) ;
}
