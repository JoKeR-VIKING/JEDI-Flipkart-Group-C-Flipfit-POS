package com.flipkart.bean;

import java.time.LocalDate;

public class FlipFitPayments {
    private String PaymentId;
    private String customerId;
    private Double amount;
    private LocalDate date;
    private String status;

    public FlipFitPayments(String paymentId, String customerId, Double amount, LocalDate date, String status) {
        this.PaymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public String getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(String paymentId) {
        PaymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
