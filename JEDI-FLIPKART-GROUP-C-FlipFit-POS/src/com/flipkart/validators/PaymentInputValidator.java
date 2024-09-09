package com.flipkart.validators;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.flipkart.utils.Helper.redOutputLn;

public class PaymentInputValidator extends Exception{
    public PaymentInputValidator(String msg){
        super(msg);
        redOutputLn(msg);
    }

    public static void isValidCardNumber(String cardNumber) throws PaymentInputValidator{
        if(cardNumber != null && cardNumber.matches("\\d{16}")){
            return;
        }else{
            throw new PaymentInputValidator("Please check your card number");
        }
    }


    public static void isValidCVV(String cvv) throws PaymentInputValidator{
        if(cvv != null && cvv.matches("\\d{3,4}")){
            return ;
        }
        else{
            throw new PaymentInputValidator("Please check your CVV");
        }
    }

    public static boolean isValidExpiryDate(String expiryDate) throws PaymentInputValidator {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth expiry = YearMonth.parse(expiryDate, formatter);


            if (expiry.isAfter(YearMonth.now())) {
                return true;
            } else {
                throw new PaymentInputValidator("Card expiry date is in the past.");
            }
        } catch (DateTimeParseException e) {
            throw new PaymentInputValidator("Invalid expiry date format. Please use MM/yy.");
        }
    }
}
