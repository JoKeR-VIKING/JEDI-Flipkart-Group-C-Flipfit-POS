package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.GymSlotSeatLimitReachedException;
import com.flipkart.exception.InvalidBookingException;
import com.flipkart.exception.InvalidSlotException;

import java.time.LocalDate;
import java.util.List;

public interface FlipFitSlotBookingDAOInterface {

    int getBookingCountBySlotId(String slotId) throws InvalidSlotException;

    void addBooking(FlipFitSlotBooking booking) throws InvalidSlotException, GymSlotSeatLimitReachedException;

    boolean addPayment(FlipFitPayments payment) ;

    void removeBooking(String bookingId) throws InvalidBookingException;

    List<FlipFitSlotBooking> listBookingsByUserId(String userId) ;

    List<FlipFitSlotBooking> getAllBookingsByGymIdAndDate(String gymId, LocalDate date);
}
