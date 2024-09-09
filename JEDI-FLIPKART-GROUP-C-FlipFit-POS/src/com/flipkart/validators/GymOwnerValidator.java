package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator class for checking the validity of gym owner details such as GST number and PAN card number.
 */
public class GymOwnerValidator extends Exception {

    /**
     * Constructs a new {@code GymOwnerValidator} with the specified detail message.
     *
     * @param msg The detail message.
     */
    public GymOwnerValidator(String msg) {
        super(msg);
    }

    /**
     * Validates the provided GST number using the specified PAN card number.
     *
     * @param panCardNumber The PAN card number used as part of the GST number validation.
     * @param gstNumber The GST number to validate.
     * @throws GymOwnerValidator If the GST number does not match the expected format.
     */
    public static void validateGstNumber(String panCardNumber, String gstNumber) throws GymOwnerValidator {
        Pattern pattern = Pattern.compile("^\\d{2}" + Pattern.quote(panCardNumber) + "[A-Z\\d]Z[A-Z\\d]$");
        Matcher matcher = pattern.matcher(gstNumber);

        if (matcher.find())
            return;

        throw new GymOwnerValidator("Invalid GST number");
    }

    /**
     * Validates the provided PAN card number.
     *
     * @param panCardNumber The PAN card number to validate.
     * @throws GymOwnerValidator If the PAN card number does not match the expected format.
     */
    public static void validatePanCardNumber(String panCardNumber) throws GymOwnerValidator {
        Pattern pattern = Pattern.compile("^[A-Z]{5}\\d{4}[A-Z]$");
        Matcher matcher = pattern.matcher(panCardNumber);

        if (matcher.find())
            return;

        throw new GymOwnerValidator("Invalid PAN number");
    }
}
