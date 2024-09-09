package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator extends Exception {
    public UserInputValidator(String msg) {
        super(msg);
    }

    public static void validatePhoneNumber(String phoneNumber) throws UserInputValidator {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.find())
            return;

        throw new UserInputValidator("Invalid phone number");
    }
}
