package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.enums.SlotBookingStatusEnum;
import com.flipkart.exception.GymSlotSeatLimitReachedException;
import com.flipkart.exception.InvalidBookingException;
import com.flipkart.exception.InvalidSlotException;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.util.List;

import static com.flipkart.dao.FlipFitSlotBookingDAOImpl.FlipFitSlotBookingDAOInst;

/**
 * Service class for managing slot bookings in the FlipFit system.
 * Implements the {@link FlipFitSlotBookingInterface} to handle operations related to slot bookings.
 */
public class FlipFitSlotBookingService implements FlipFitSlotBookingInterface {

    /**
     * Books a slot for a user on a specified date.
     * Creates a new {@link FlipFitSlotBooking} and stores it in the system.
     *
     * @param userId the ID of the user making the booking
     * @param bookingDate the date on which the booking is made
     * @param slot the slot to be booked
     * @param paymentId the ID of the payment associated with the booking
     * @throws GymSlotSeatLimitReachedException if the slot has reached its seat limit
     * @throws InvalidSlotException if the provided slot is invalid
     */
    @Override
    public void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId) throws GymSlotSeatLimitReachedException, InvalidSlotException {
        FlipFitSlotBooking booking = new FlipFitSlotBooking(
                Helper.generateId(),
                userId,
                slot.getSlotId(),
                bookingDate,
                LocalDate.now(),
                SlotBookingStatusEnum.CONFIRMED,
                paymentId
        );

        FlipFitSlotBookingDAOInst.removePreviousBooking(userId, booking.getSlotDate());
        FlipFitSlotBookingDAOInst.addBooking(booking);
    }

    /**
     * Cancels a specific booking.
     * Removes the booking identified by the given booking ID from the system.
     *
     * @param bookingId the ID of the booking to be canceled
     * @throws InvalidBookingException if the booking ID is invalid or the booking cannot be canceled
     */
    @Override
    public void cancelBooking(String bookingId) throws InvalidBookingException {
        FlipFitSlotBookingDAOInst.removeBooking(bookingId);
    }

    /**
     * Retrieves a list of bookings made by a user.
     *
     * @param userId the ID of the user whose bookings are to be retrieved
     * @return a list of {@link FlipFitSlotBooking} objects representing the user's bookings
     */
    @Override
    public List<FlipFitSlotBooking> listBookings(String userId) {
        return FlipFitSlotBookingDAOInst.listBookingsByUserId(userId);
    }
}
