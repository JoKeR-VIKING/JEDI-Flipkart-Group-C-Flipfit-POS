package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Interface for managing payments in the FlipFit system.
 * Provides methods to handle payment transactions.
 */
public interface FlipFitPaymentsInterface {

    /**
     * Processes a payment and creates a payment record.
     *
     * @param customerId  the unique identifier of the customer making the payment
     * @param amountPaid  the amount of money being paid
     * @param cardNumber  the credit/debit card number used for the payment
     * @param cvv         the CVV code of the card used for the payment
     * @param cardExpiry  the expiry date of the card used for the payment
     * @param date        the date on which the payment is made
     * @return            a {@link FlipFitPayments} object representing the payment record
     */
    FlipFitPayments makePayment(String customerId, Double amountPaid, String cardNumber, String cvv, YearMonth cardExpiry, LocalDate date);
}
