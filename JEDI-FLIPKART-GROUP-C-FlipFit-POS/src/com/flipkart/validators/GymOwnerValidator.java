package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Custom exception class used for validating gym owner details.
 * Extends {@link Exception} to provide specific error messages for validation issues.
 */
public class GymOwnerValidator extends Exception {

    /**
     * Constructs a new GymOwnerValidator with the specified detail message.
     *
     * @param msg The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public GymOwnerValidator(String msg) {
        super(msg);
    }

    /**
     * Validates the format of a GST number based on a given PAN card number.
     *
     * @param panCardNumber The PAN card number to be used in the GST number validation.
     * @param gstNumber The GST number to be validated.
     * @throws GymOwnerValidator If the GST number does not match the expected format.
     */
    public static void validateGstNumber(String panCardNumber, String gstNumber) throws GymOwnerValidator {
        // Pattern to match GST number format, incorporating PAN card number
        Pattern pattern = Pattern.compile("^\\d{2}" + Pattern.quote(panCardNumber) + "[A-Z\\d]Z[A-Z\\d]$");
        Matcher matcher = pattern.matcher(gstNumber);

        if (matcher.find()) {
            return;
        }

        throw new GymOwnerValidator("Invalid GST number");
    }

    /**
     * Validates the format of a PAN card number.
     *
     * @param panCardNumber The PAN card number to be validated.
     * @throws GymOwnerValidator If the PAN card number does not match the expected format.
     */
    public static void validatePanCardNumber(String panCardNumber) throws GymOwnerValidator {
        Pattern pattern = Pattern.compile("^[A-Z]{5}\\d{4}[A-Z]$");
        Matcher matcher = pattern.matcher(panCardNumber);

        if (matcher.find()) {
            return;
        }

        throw new GymOwnerValidator("Invalid PAN card number");
    }
}
