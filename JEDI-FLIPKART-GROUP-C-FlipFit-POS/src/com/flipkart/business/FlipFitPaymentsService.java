package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.dao.FlipFitSlotBookingDAO;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.util.Objects;

public class FlipFitPaymentsService implements FlipFitPaymentsInterface{
    @Override
    public FlipFitPayments makePayment(String paymentId, String customerId, Double amountToBeVerified, Double amountPaid, LocalDate date) {
        boolean isVerified = verifyPayments(amountPaid,amountToBeVerified);
        FlipFitPayments payment = new FlipFitPayments(paymentId, customerId, amountPaid, date, isVerified ? "Success" : "Failure");
        FlipFitSlotBookingDAO.addPayment(payment);

        return payment;
    }
    public Boolean verifyPayments(Double amountPaid, Double amountToBeVerified) {
        return Objects.equals(amountPaid, amountToBeVerified);
    }
}
