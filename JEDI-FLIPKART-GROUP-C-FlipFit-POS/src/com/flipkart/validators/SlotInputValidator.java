package com.flipkart.validators;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.flipkart.utils.Helper.parseDate;
import static com.flipkart.utils.Helper.redOutputLn;

/**
 * Validator class for checking the validity of slot input data, such as time format, date format and seat capacity.
 */
public class SlotInputValidator extends Exception {

    /**
     * Constructs a new {@code SlotInputValidator} with the specified detail message.
     * Also prints the message in red.
     *
     * @param msg The detail message.
     */
    public SlotInputValidator(String msg){
        super(msg);
    }

    /**
     * Validates that the provided slot time is in the correct format (HH:mm).
     *
     * @param slotTime The slot time to validate.
     * @throws SlotInputValidator If the time is not in the correct format.
     */
    public static void validateTimeFormat(String slotTime) throws SlotInputValidator  {
        try {
            // Define the expected time format as HH:mm
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            // Try to parse the string as a LocalTime
            LocalTime.parse(slotTime, timeFormatter);
        } catch (DateTimeParseException e) {
            // If parsing fails, the format is incorrect
            throw new SlotInputValidator("Incorrect time format (correct format : HH:mm)");
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
     * Validates that the provided seat capacity is a positive number.
     *
     * @param seatCapacity The seat capacity to validate.
     * @throws SlotInputValidator If the seat capacity is not greater than 0.
     */
    public static void validateSeatCapacity(int seatCapacity) throws SlotInputValidator {
        if(seatCapacity > 0){
            return;
        } else {
            throw new SlotInputValidator("Capacity should be greater than 0");
        }
    }
}
