package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.util.Objects;

public class FlipFitPaymentsService implements FlipFitPaymentsInterface{


    @Override
    public void makePayment(String paymentId, String customerId, Double amountToBeVerified, Double amountPaid, LocalDate date, String status) {
        FlipFitPayments payment = new FlipFitPayments(Helper.generateId(), customerId, amountPaid, date, status);
        status = verifyPayments(amountPaid,amountToBeVerified).toString();
    }
    public Boolean verifyPayments(Double amountPaid, Double amountToBeVerified) {
        return Objects.equals(amountPaid, amountToBeVerified);
    }
}
