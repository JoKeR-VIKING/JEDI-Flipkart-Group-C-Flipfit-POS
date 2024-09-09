package com.flipkart.validators;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import static com.flipkart.utils.Helper.redOutputLn;

public class BookSlotInputValidator extends Exception{
    public BookSlotInputValidator(String msg){
        super(msg);
        redOutputLn(msg);
    }

    public static void validateDateFormat(String dateString) throws BookSlotInputValidator {
        try {
            LocalDate.parse(dateString);
//            return true;

        } catch (DateTimeParseException e) {
//            return false;

            throw new BookSlotInputValidator("Invalid date format");
        }
    }

    public static void validateFutureDate(String bookingDate) throws BookSlotInputValidator{
        // Check if bookingDate is after today's date
        LocalDate parsedDate = LocalDate.parse(bookingDate);
        if(parsedDate.isAfter(LocalDate.now())){
            return ;
        }else{
            throw new BookSlotInputValidator("Enter date is older");
        }
//        return bookingDate != null && bookingDate.isAfter(LocalDate.now());

    }

}
