package com.flipkart.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SlotInputValidator {
    //seat positive
    //time is in right format

    public static boolean validateTimeFormat(String slotTime) {

        try {
            // Define the expected time format as HH:mm
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:MM");

            // Try to parse the string as a LocalTime
            LocalTime.parse(slotTime, timeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            // If parsing fails, the format is incorrect
            return false;
        }
    }

    public static boolean validateSeatCapacity(int seatCapacity) {
        return seatCapacity > 0;
    }

}
