package com.flipkart.bean;

import java.time.LocalDate;

/**
 * Represents a payment record in the FlipFit system.
 * This class contains details such as payment ID, customer ID, amount, date, and status.
 */
public class FlipFitPayments {

    private String PaymentId;
    private String customerId;
    private Double amount;
    private LocalDate date;
    private String status;

    /**
     * Constructs a new FlipFitPayments instance with the specified details.
     *
     * @param paymentId  the unique identifier for the payment
     * @param customerId the unique identifier for the customer making the payment
     * @param amount     the amount of the payment
     * @param date       the date the payment was made
     * @param status     the status of the payment (e.g., "COMPLETED", "PENDING")
     */
    public FlipFitPayments(String paymentId, String customerId, Double amount, LocalDate date, String status) {
        this.PaymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    /**
     * Returns the unique identifier for the payment.
     *
     * @return the payment ID
     */
    public String getPaymentId() {
        return PaymentId;
    }

    /**
     * Sets the unique identifier for the payment.
     *
     * @param paymentId the new payment ID
     */
    public void setPaymentId(String paymentId) {
        this.PaymentId = paymentId;
    }

    /**
     * Returns the unique identifier for the customer associated with the payment.
     *
     * @return the customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the unique identifier for the customer associated with the payment.
     *
     * @param customerId the new customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Returns the amount of the payment.
     *
     * @return the payment amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the payment.
     *
     * @param amount the new payment amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Returns the date the payment was made.
     *
     * @return the payment date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date the payment was made.
     *
     * @param date the new payment date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the status of the payment.
     * The status could be "COMPLETED", "PENDING", or other relevant statuses.
     *
     * @return the payment status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the payment.
     *
     * @param status the new payment status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
