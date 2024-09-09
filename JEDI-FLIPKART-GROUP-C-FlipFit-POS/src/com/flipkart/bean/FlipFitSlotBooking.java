package com.flipkart.bean;

import com.flipkart.enums.SlotBookingStatusEnum;

import java.time.LocalDate;

/**
 * Represents a slot booking in the FlipFit system.
 * This class contains details such as booking ID, user ID, center slot ID, slot date, booking date, status, and payment ID.
 */
public class FlipFitSlotBooking {

    private String bookingId;
    private String userId;
    private String centerSlotId;
    private LocalDate slotDate;
    private LocalDate bookingDate;
    private SlotBookingStatusEnum status;
    private String paymentId;

    /**
     * Constructs a new FlipFitSlotBooking with the specified details.
     *
     * @param bookingId     the unique identifier for the booking
     * @param userId        the unique identifier for the user making the booking
     * @param centerSlotId  the unique identifier for the center slot being booked
     * @param slotDate      the date of the slot being booked
     * @param bookingDate   the date when the booking was made
     * @param status        the status of the booking (e.g., "CONFIRMED", "CANCELLED")
     * @param paymentId     the unique identifier for the payment associated with the booking
     */
    public FlipFitSlotBooking(String bookingId, String userId, String centerSlotId, LocalDate slotDate, LocalDate bookingDate, SlotBookingStatusEnum status, String paymentId) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.centerSlotId = centerSlotId;
        this.slotDate = slotDate;
        this.bookingDate = bookingDate;
        this.status = status;
        this.paymentId = paymentId;
    }

    /**
     * Returns the unique identifier for the booking.
     *
     * @return the booking ID
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Sets the unique identifier for the booking.
     *
     * @param id the new booking ID
     */
    public void setBookingId(String id) {
        this.bookingId = id;
    }

    /**
     * Returns the unique identifier for the user making the booking.
     *
     * @return the user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user making the booking.
     *
     * @param userId the new user ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns the unique identifier for the center slot being booked.
     *
     * @return the center slot ID
     */
    public String getCenterSlot() {
        return centerSlotId;
    }

    /**
     * Sets the unique identifier for the center slot being booked.
     *
     * @param centerSlot the new center slot ID
     */
    public void setCenterSlot(String centerSlot) {
        this.centerSlotId = centerSlot;
    }

    /**
     * Returns the date of the slot being booked.
     *
     * @return the slot date
     */
    public LocalDate getSlotDate() {
        return slotDate;
    }

    /**
     * Sets the date of the slot being booked.
     *
     * @param slotDate the new slot date
     */
    public void setSlotDate(LocalDate slotDate) {
        this.slotDate = slotDate;
    }

    /**
     * Returns the date when the booking was made.
     *
     * @return the booking date
     */
    public LocalDate getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the date when the booking was made.
     *
     * @param bookingDate the new booking date
     */
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * Returns the status of the booking.
     * The status can be an enumeration value from {@link SlotBookingStatusEnum}.
     *
     * @return the booking status
     */
    public SlotBookingStatusEnum getStatus() {
        return status;
    }

    /**
     * Sets the status of the booking.
     *
     * @param status the new booking status
     */
    public void setStatus(SlotBookingStatusEnum status) {
        this.status = status;
    }

    /**
     * Returns the unique identifier for the payment associated with the booking.
     *
     * @return the payment ID
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the unique identifier for the payment associated with the booking.
     *
     * @param paymentId the new payment ID
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}
