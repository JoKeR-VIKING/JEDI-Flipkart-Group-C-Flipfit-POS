package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.GymSlotSeatLimitReachedException;
import com.flipkart.exception.InvalidBookingException;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidSlotException;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface for operations related to slot bookings and payments in the FlipFit system.
 * Provides methods to manage slot bookings and payments for gym centres.
 */
public interface FlipFitSlotBookingDAOInterface {

    /**
     * Retrieves the number of bookings for a specific slot.
     *
     * @param slotId The ID of the slot to check.
     * @return The number of bookings for the specified slot.
     * @throws InvalidSlotException If the slot ID is invalid or not found.
     */
    int getBookingCountBySlotId(String slotId) throws InvalidSlotException;

    /**
     * Adds a new booking to the system.
     *
     * @param booking The {@link FlipFitSlotBooking} object representing the booking to be added.
     * @throws InvalidSlotException If the slot ID is invalid or not found.
     * @throws GymSlotSeatLimitReachedException If the slot has reached its maximum seat limit.
     */
    void addBooking(FlipFitSlotBooking booking) throws InvalidSlotException, GymSlotSeatLimitReachedException;

    /**
     * Adds a payment record for a booking.
     *
     * @param payment The {@link FlipFitPayments} object representing the payment to be added.
     * @return true if the payment is added successfully, false otherwise.
     */
    boolean addPayment(FlipFitPayments payment);

    /**
     * Removes an existing booking from the system.
     *
     * @param bookingId The ID of the booking to be removed.
     * @throws InvalidBookingException If the booking ID is invalid or not found.
     */
    void removeBooking(String bookingId) throws InvalidBookingException;

    /**
     * Removes an existing booking for the same date by same user.
     *
     * @param userId The ID of the customer.
     * @param bookingDate The date of booked slot.
     */
    void removePreviousBooking(String userId, LocalDate bookingDate);

    /**
     * Lists all bookings made by a specific user.
     *
     * @param userId The ID of the user whose bookings are to be listed.
     * @return A List of {@link FlipFitSlotBooking} objects representing the user's bookings.
     */
    List<FlipFitSlotBooking> listBookingsByUserId(String userId);

    /**
     * Retrieves all bookings for a specific gym on a particular date.
     *
     * @param gymId The ID of the gym whose bookings are to be retrieved.
     * @param date  The date on which to retrieve the bookings.
     * @return A List of {@link FlipFitSlotBooking} objects representing the bookings for the gym on the specified date.
     * @throws InvalidGymException If the gym ID is invalid or not found.
     */
    List<FlipFitSlotBooking> getAllBookingsByGymIdAndDate(String gymId, LocalDate date) throws InvalidGymException;
}
