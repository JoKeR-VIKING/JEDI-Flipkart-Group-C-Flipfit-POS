package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GymOwnerValidator {
    public static boolean validateGstNumber(String panCardNumber, String gstNumber) {
        Pattern pattern = Pattern.compile("^\\d{2}" + Pattern.quote(panCardNumber) + "[A-Z\\d]Z[A-Z\\d]$");
        Matcher matcher = pattern.matcher(gstNumber);

        return matcher.find();
    }

    public static boolean validatePanCardNumber(String panCardNumber) {
        Pattern pattern = Pattern.compile("^[A-Z]{5}\\d{4}[A-Z]$");
        Matcher matcher = pattern.matcher(panCardNumber);

        return matcher.find();
    }
}
