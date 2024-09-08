package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;

import java.util.List;

public interface FlipFitSlotBookingDAOInterface {
    void addBooking(FlipFitSlotBooking booking);

    boolean addPayment(FlipFitPayments payment) ;

    void removeBooking(String bookingId);

    List<FlipFitSlotBooking> listBookingsByUserId(String userId) ;
}
