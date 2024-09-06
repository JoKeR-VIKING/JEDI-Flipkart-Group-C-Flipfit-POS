package com.flipkart.business;

import java.time.LocalDate;

public interface FlipFitPaymentsInterface {
    public void makePayment(String paymentId, String customerId, Double amountToBeVerified, Double amountPaid, LocalDate date, String status);
}
