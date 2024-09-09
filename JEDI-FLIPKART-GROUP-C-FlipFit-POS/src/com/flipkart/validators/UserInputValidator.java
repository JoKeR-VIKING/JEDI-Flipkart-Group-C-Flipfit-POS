package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator class for checking the validity of user input data.
 */
public class UserInputValidator extends Exception {

    /**
     * Constructs a new {@code UserInputValidator} with the specified detail message.
     *
     * @param msg The detail message.
     */
    public UserInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates that the provided phone number is in the correct format (exactly 10 digits).
     *
     * @param phoneNumber The phone number to validate.
     * @throws UserInputValidator If the phone number does not match the expected format.
     */
    public static void validatePhoneNumber(String phoneNumber) throws UserInputValidator {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.find())
            return;

        throw new UserInputValidator("Invalid phone number");
    }
}
