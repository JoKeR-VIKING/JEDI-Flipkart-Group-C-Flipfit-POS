package com.flipkart.validators;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static com.flipkart.constants.ConsoleConstants.formatter;

/**
 * Custom exception class used for validating slot booking inputs.
 * Extends {@link Exception} to provide specific error messages for validation issues.
 */
public class BookSlotInputValidator extends Exception {

    /**
     * Constructs a new BookSlotInputValidator with the specified detail message.
     *
     * @param msg The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public BookSlotInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates whether a given date string is in the correct format.
     *
     * @param dateString The date string to be validated.
     * @throws BookSlotInputValidator If the date string is not in the correct format.
     */
    public static void validateDateFormat(String dateString) throws BookSlotInputValidator {
        try {
            LocalDate.parse(dateString, formatter);
    public static void validateDateFormat(String dateString) throws BookSlotInputValidator {
        try {
            LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new BookSlotInputValidator("Invalid date format");
        }
    }

    /**
     * Validates whether a given date string represents a future date.
     *
     * @param bookingDate The date string to be validated.
     * @throws BookSlotInputValidator If the date is not in the future or is invalid.
     */
    public static void validateFutureDate(String bookingDate) throws BookSlotInputValidator {
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(bookingDate, formatter);
        } catch (DateTimeParseException e) {
            throw new BookSlotInputValidator("Invalid date format");
        }

        if (parsedDate.isBefore(LocalDate.now())) {
            throw new BookSlotInputValidator("Invalid date entered");
        }
    }
}
