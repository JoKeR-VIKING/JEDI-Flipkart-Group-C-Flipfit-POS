package com.flipkart.validators;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Custom exception class used for validating payment input details.
 * Extends {@link Exception} to provide specific error messages for validation issues.
 */
public class PaymentInputValidator extends Exception {

    /**
     * Constructs a new PaymentInputValidator with the specified detail message.
     *
     * @param msg The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public PaymentInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates the format of a card number.
     *
     * @param cardNumber The card number to be validated.
     * @throws PaymentInputValidator If the card number does not match the expected format (16 digits).
     */
    public static void validateCardNumber(String cardNumber) throws PaymentInputValidator {
        if (cardNumber.matches("\\d{16}")) {
            return;
        }
        throw new PaymentInputValidator("Invalid card number");
    }

    /**
     * Validates the format of a CVV (Card Verification Value).
     *
     * @param cvv The CVV to be validated.
     * @throws PaymentInputValidator If the CVV does not match the expected format (3 or 4 digits).
     */
    public static void validateCVV(String cvv) throws PaymentInputValidator {
        if (cvv.matches("\\d{3,4}")) {
            return;
        }
        throw new PaymentInputValidator("Invalid CVV");
    }

    /**
     * Validates the expiry date of a card.
     *
     * @param expiryDate The expiry date to be validated in the format "MM/yy".
     * @throws PaymentInputValidator If the expiry date is invalid, not in the future, or in an incorrect format.
     */
    public static void isValidExpiryDate(String expiryDate) throws PaymentInputValidator {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth expiry = YearMonth.parse(expiryDate, formatter);

            if (expiry.isAfter(YearMonth.now())) {
                return;
            }

            throw new PaymentInputValidator("Your card is expired");
        } catch (DateTimeParseException e) {
            throw new PaymentInputValidator("Invalid expiry date format");
        }
    }
}
