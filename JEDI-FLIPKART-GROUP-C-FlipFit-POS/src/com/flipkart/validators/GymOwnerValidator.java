package com.flipkart.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GymOwnerValidator extends Exception {
    public GymOwnerValidator(String msg) {
        super(msg);
    }

    public static void validateGstNumber(String panCardNumber, String gstNumber) throws GymOwnerValidator {
        Pattern pattern = Pattern.compile("^\\d{2}" + Pattern.quote(panCardNumber) + "[A-Z\\d]Z[A-Z\\d]$");
        Matcher matcher = pattern.matcher(gstNumber);

        if (matcher.find())
            return;

        throw new GymOwnerValidator("Invalid gst number");
    }

    public static void validatePanCardNumber(String panCardNumber) throws GymOwnerValidator {
        Pattern pattern = Pattern.compile("^[A-Z]{5}\\d{4}[A-Z]$");
        Matcher matcher = pattern.matcher(panCardNumber);

        if (matcher.find())
            return;

        throw new GymOwnerValidator("Invalid pan number");
    }
}
