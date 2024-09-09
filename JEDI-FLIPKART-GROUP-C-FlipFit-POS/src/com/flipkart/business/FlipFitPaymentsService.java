package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;

import java.time.LocalDate;
import java.util.Objects;

import static com.flipkart.dao.FlipFitSlotBookingDAOImpl.FlipFitSlotBookingDAOInst;

/**
 * Service class responsible for managing payment operations.
 * Implements the {@link FlipFitPaymentsInterface} to handle payment creation and verification.
 */
public class FlipFitPaymentsService implements FlipFitPaymentsInterface {

    /**
     * Creates and records a new payment, verifying if the payment amount matches the expected amount.
     *
     * @param paymentId the unique identifier for the payment
     * @param customerId the ID of the customer making the payment
     * @param amountToBeVerified the amount that needs to be verified
     * @param amountPaid the actual amount paid by the customer
     * @param date the date of the payment
     * @return a {@link FlipFitPayments} object representing the created payment record
     */
    @Override
    public FlipFitPayments makePayment(String paymentId, String customerId, Double amountToBeVerified, Double amountPaid, LocalDate date) {
        // Verify if the amount paid matches the amount to be verified
        boolean isVerified = verifyPayments(amountPaid, amountToBeVerified);

        // Create a new FlipFitPayments object with the verification status
        FlipFitPayments payment = new FlipFitPayments(paymentId, customerId, amountPaid, date, isVerified ? "Success" : "Failure");

        // Add the payment record to the database
        FlipFitSlotBookingDAOInst.addPayment(payment);

        // Return the created payment record
        return payment;
    }

    /**
     * Verifies whether the amount paid matches the amount to be verified.
     *
     * @param amountPaid the amount paid by the customer
     * @param amountToBeVerified the amount that needs to be verified
     * @return {@code true} if the amount paid matches the amount to be verified, {@code false} otherwise
     */
    @Override
    public Boolean verifyPayments(Double amountPaid, Double amountToBeVerified) {
        // Use Objects.equals to handle nulls and ensure proper comparison
        return Objects.equals(amountPaid, amountToBeVerified);
    }
}
