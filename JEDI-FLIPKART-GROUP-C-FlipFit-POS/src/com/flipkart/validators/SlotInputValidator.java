package com.flipkart.validators;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.flipkart.utils.Helper.parseDate;

/**
 * Custom exception class used for validating slot input details.
 * Extends {@link Exception} to provide specific error messages for validation issues.
 */
public class SlotInputValidator extends Exception {

    /**
     * Constructs a new SlotInputValidator with the specified detail message.
     *
     * @param msg The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public SlotInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates whether a given slot time is in the correct format ("HH:mm").
     *
     * @param slotTime The slot time to be validated.
     * @throws SlotInputValidator If the slot time is not in the correct format.
     */
    public static void validateTimeFormat(String slotTime) throws SlotInputValidator {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(slotTime, formatter);
        } catch (DateTimeParseException e) {
            throw new SlotInputValidator("Invalid slot time format");
        }
    }

    /**
     * Validates the date format of a given date string.
     *
     * @param date the date string to validate
     * @throws SlotInputValidator if the date format is incorrect
     */
    public static void validateDateFormat(String date) throws SlotInputValidator {
        try {
            // Attempt to parse the date using the defined format
            parseDate(date);
        } catch (DateTimeParseException e) {
            // If parsing fails, the format is incorrect
            throw new SlotInputValidator("Incorrect date format (correct format : dd-MM-yyyy)");
        }
    }

    /**
     * Validates that the seat capacity is greater than zero.
     *
     * @param seatCapacity The seat capacity to be validated.
     * @throws SlotInputValidator If the seat capacity is less than or equal to zero.
     */
    public static void validateSeatCapacity(int seatCapacity) throws SlotInputValidator {
        if (seatCapacity > 0) {
            return;
        }
        throw new SlotInputValidator("Slot seats should be greater than zero");
    }
}
