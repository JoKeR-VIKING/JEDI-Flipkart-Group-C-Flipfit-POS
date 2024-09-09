package com.flipkart.validators;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.flipkart.utils.Helper.redOutputLn;

public class SlotInputValidator extends Exception {
    public SlotInputValidator(String msg){
        super(msg);
        redOutputLn(msg);
    }

    //seat positive
    //time is in right format


    public static void validateTimeFormat(String slotTime) throws SlotInputValidator  {
        try {
            // Define the expected time format as HH:mm
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:MM");

            // Try to parse the string as a LocalTime
            LocalTime.parse(slotTime, timeFormatter);
            return ;
        } catch (DateTimeParseException e) {
            // If parsing fails, the format is incorrect
            throw new SlotInputValidator("Incorrect time format (correct format : HH:MM");
        }
    }

    public static void validateSeatCapacity(int seatCapacity) throws SlotInputValidator {

        if(seatCapacity>0){
            return;
        }
        else{
            throw new SlotInputValidator("Capacity should be greater than 0");
        }
    }

}
