package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.exception.GymSlotSeatLimitReachedException;
import com.flipkart.exception.InvalidBookingException;
import com.flipkart.exception.InvalidSlotException;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface for managing slot bookings in the FlipFit system.
 * Provides methods for booking, listing, and canceling slot bookings.
 */
public interface FlipFitSlotBookingInterface {

    /**
     * Books a slot for a user on a specified date.
     *
     * @param userId the ID of the user making the booking
     * @param bookingDate the date on which the booking is made
     * @param slot the slot to be booked
     * @param paymentId the ID of the payment associated with the booking
     * @throws GymSlotSeatLimitReachedException if the slot has reached its seat limit
     * @throws InvalidSlotException if the provided slot is invalid
     */
    void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId)
            throws GymSlotSeatLimitReachedException, InvalidSlotException;

    /**
     * Retrieves a list of bookings made by a user.
     *
     * @param userId the ID of the user whose bookings are to be retrieved
     * @return a list of {@link FlipFitSlotBooking} objects representing the user's bookings
     */
    List<FlipFitSlotBooking> listBookings(String userId);

    /**
     * Cancels a specific booking.
     *
     * @param bookingId the ID of the booking to be canceled
     * @throws InvalidBookingException if the booking ID is invalid or the booking cannot be canceled
     */
    void cancelBooking(String bookingId) throws InvalidBookingException;
}
