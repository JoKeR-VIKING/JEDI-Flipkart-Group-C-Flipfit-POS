package com.flipkart.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Represents a payment transaction in the FlipFit system.
 */
public class FlipFitPayments {
    @NotNull
    private String paymentId;
    @NotNull
    private String customerId;
    @NotNull
    private Double amount;
    @NotBlank
    private LocalDate date;
    @NotBlank
    private String cardNumber;
    @NotBlank
    private String cvv;
    @NotNull
    private YearMonth cardExpiry;
    @NotBlank
    private String status;

    /**
     * Constructs a new FlipFitPayments instance.
     *
     * @param paymentId     the unique identifier for the payment
     * @param customerId    the identifier of the customer making the payment
     * @param amount        the amount of the payment
     * @param date          the date of the payment
     * @param cardNumber    the card number used for the payment
     * @param cvv           the CVV of the card used for the payment
     * @param cardExpiry    the expiry date of the card used for the payment
     * @param status        the status of the payment (e.g., "completed", "pending")
     */
    public FlipFitPayments(String paymentId, String customerId, Double amount, LocalDate date, String cardNumber, String cvv, YearMonth cardExpiry, String status) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardExpiry = cardExpiry;
        this.status = status;
    }

    /**
     * Returns the payment ID.
     *
     * @return the payment ID
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment ID.
     *
     * @param paymentId the payment ID to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Returns the customer ID.
     *
     * @return the customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId the customer ID to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Returns the amount of the payment.
     *
     * @return the amount of the payment
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the payment.
     *
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Returns the date of the payment.
     *
     * @return the date of the payment
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the payment.
     *
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the status of the payment.
     *
     * @return the status of the payment
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the payment.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the card number used for the payment.
     *
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number used for the payment.
     *
     * @param cardNumber the card number to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Returns the CVV of the card used for the payment.
     *
     * @return the CVV of the card
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Sets the CVV of the card used for the payment.
     *
     * @param cvv the CVV to set
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * Returns the expiry date of the card used for the payment.
     *
     * @return the card expiry date
     */
    public YearMonth getCardExpiry() {
        return cardExpiry;
    }

    /**
     * Sets the expiry date of the card used for the payment.
     *
     * @param cardExpiry the card expiry date to set
     */
    public void setCardExpiry(YearMonth cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

}
