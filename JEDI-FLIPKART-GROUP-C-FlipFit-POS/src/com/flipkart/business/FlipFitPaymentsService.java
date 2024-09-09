package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.time.YearMonth;

import static com.flipkart.dao.FlipFitSlotBookingDAOImpl.FlipFitSlotBookingDAOInst;

/**
 * Service class for handling payment operations in the FlipFit system.
 * Implements the {@link FlipFitPaymentsInterface} to manage payment transactions.
 */
public class FlipFitPaymentsService implements FlipFitPaymentsInterface {

    /**
     * Processes a payment by creating a payment record and adding it to the database.
     *
     * @param customerId  the unique identifier of the customer making the payment
     * @param amountPaid  the amount of money being paid
     * @param cardNumber  the credit/debit card number used for the payment
     * @param cvv         the CVV code of the card used for the payment
     * @param cardExpiry  the expiry date of the card used for the payment
     * @param date        the date on which the payment is made
     * @return            a {@link FlipFitPayments} object representing the payment record
     */
    @Override
    public FlipFitPayments makePayment(String customerId, Double amountPaid, String cardNumber, String cvv, YearMonth cardExpiry, LocalDate date) {
        // Create a new payment record with a generated payment ID
        FlipFitPayments payment = new FlipFitPayments(Helper.generateId(), customerId, amountPaid, date, cardNumber, cvv, cardExpiry, "Success");

        // Add the payment record to the database
        FlipFitSlotBookingDAOInst.addPayment(payment);

        // Return the created payment record
        return payment;
    }
}
