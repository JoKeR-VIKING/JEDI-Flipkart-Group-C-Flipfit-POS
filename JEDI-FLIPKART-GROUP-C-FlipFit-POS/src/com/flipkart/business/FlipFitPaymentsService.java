package com.flipkart.business;

import com.flipkart.bean.FlipFitPayments;

import java.time.LocalDate;
import java.util.Objects;

import static com.flipkart.dao.FlipFitSlotBookingDAOImpl.FlipFitSlotBookingDAOInst;

public class FlipFitPaymentsService implements FlipFitPaymentsInterface {
    @Override
    public FlipFitPayments makePayment(String paymentId, String customerId, Double amountToBeVerified, Double amountPaid, LocalDate date) {
        boolean isVerified = verifyPayments(amountPaid, amountToBeVerified);
        FlipFitPayments payment = new FlipFitPayments(paymentId, customerId, amountPaid, date, isVerified ? "Success" : "Failure");
        FlipFitSlotBookingDAOInst.addPayment(payment);

        return payment;
    }

    public Boolean verifyPayments(Double amountPaid, Double amountToBeVerified) {
        return Objects.equals(amountPaid, amountToBeVerified);
    }
}
