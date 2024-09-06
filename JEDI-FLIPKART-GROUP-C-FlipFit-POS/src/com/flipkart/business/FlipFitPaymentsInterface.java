package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;

import java.time.LocalDate;

public interface FlipFitPaymentsInterface {
    FlipFitPayments makePayment(String paymentId, String customerId, Double amountToBeVerified, Double amountPaid, LocalDate date);

    Boolean verifyPayments(Double amountPaid, Double amountToBeVerified);
}
