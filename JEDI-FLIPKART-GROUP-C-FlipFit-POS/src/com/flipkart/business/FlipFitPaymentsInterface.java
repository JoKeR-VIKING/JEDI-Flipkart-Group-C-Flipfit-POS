package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;

import java.time.LocalDate;

/**
 * Interface for handling payment-related operations within the FlipFit system.
 * Provides methods for making and verifying payments.
 */
public interface FlipFitPaymentsInterface {

    /**
     * Processes a payment and creates a payment record.
     *
     * @param paymentId the unique identifier for the payment
     * @param customerId the ID of the customer making the payment
     * @param amountToBeVerified the amount that needs to be verified
     * @param amountPaid the actual amount paid by the customer
     * @param date the date of the payment
     * @return a {@link FlipFitPayments} object representing the payment record
     */
    FlipFitPayments makePayment(String paymentId, String customerId, Double amountToBeVerified, Double amountPaid, LocalDate date);

    /**
     * Verifies whether the payment amount is correct based on the amount to be verified.
     *
     * @param amountPaid the amount paid by the customer
     * @param amountToBeVerified the amount that needs to be verified
     * @return {@code true} if the amount paid matches the amount to be verified, {@code false} otherwise
     */
    Boolean verifyPayments(Double amountPaid, Double amountToBeVerified);
}
