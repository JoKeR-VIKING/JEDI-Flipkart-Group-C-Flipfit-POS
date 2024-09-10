package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Custom exception class used for validating user input details.
 * Extends {@link Exception} to provide specific error messages for validation issues.
 */
public class UserInputValidator extends Exception {

    /**
     * Constructs a new UserInputValidator with the specified detail message.
     *
     * @param msg The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public UserInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates whether a given phone number is in the correct format (10 digits).
     *
     * @param phoneNumber The phone number to be validated.
     * @throws UserInputValidator If the phone number does not match the expected format.
     */
    public static void validatePhoneNumber(String phoneNumber) throws UserInputValidator {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.find()) {
            return;
        }
        throw new UserInputValidator("Invalid phone number");
    }
}
