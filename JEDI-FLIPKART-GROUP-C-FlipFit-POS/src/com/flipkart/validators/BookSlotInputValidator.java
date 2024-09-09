package com.flipkart.validators;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Validator class for checking the validity of booking slot inputs.
 */
public class BookSlotInputValidator extends Exception {

    /**
     * Constructs a new {@code BookSlotInputValidator} with the specified detail message.
     *
     * @param msg The detail message.
     */
    public BookSlotInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates that the provided date string is in the correct format.
     *
     * @param dateString The date string to validate.
     * @throws BookSlotInputValidator If the date string is not in a valid format.
     */
    public static void validateDateFormat(String dateString) throws BookSlotInputValidator {
        try {
            LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new BookSlotInputValidator("Invalid date format");
        }
    }

    /**
     * Validates that the provided date is a future date.
     *
     * @param bookingDate The date string to validate.
     * @throws BookSlotInputValidator If the date is not in the future.
     */
    public static void validateFutureDate(String bookingDate) throws BookSlotInputValidator {
        LocalDate parsedDate = LocalDate.parse(bookingDate);
        if (!parsedDate.isAfter(LocalDate.now())) {
            throw new BookSlotInputValidator("Enter date is older");
        }
    }
}
