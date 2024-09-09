package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {
    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }
}
