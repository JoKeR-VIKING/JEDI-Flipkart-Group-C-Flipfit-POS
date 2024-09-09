package com.flipkart.validators;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BookSlotInputValidator {

    public static boolean validateDateFormat(String dateString) {
        try {
            LocalDate.parse(dateString);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static boolean validateFutureDate(LocalDate bookingDate) {
        // Check if bookingDate is after today's date
        return bookingDate != null && bookingDate.isAfter(LocalDate.now());
    }

}
