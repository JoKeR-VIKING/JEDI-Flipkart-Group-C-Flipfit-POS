package com.flipkart.validators;

import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CustomerInputValidator extends Exception {
    public CustomerInputValidator(String msg) {
        super(msg);
    }

    public static void validateWeight(double weight) throws CustomerInputValidator {
        if (weight > 0)
            return;

        throw new CustomerInputValidator("Invalid weight");
    }

    public static void validateAge(int age) throws CustomerInputValidator {
        if (age > 0)
            return;

        throw new CustomerInputValidator("Invalid age");
    }

    public static void validateGender(String gender) throws CustomerInputValidator {
        if (gender.equals("male") || gender.equals("female") || gender.equals("others"))
            return;

        throw new CustomerInputValidator("Invalid gender");
    }

    public static void validateDob(String dob, int age) throws CustomerInputValidator {
        LocalDate dateOfBirth;

        try {
            dateOfBirth = LocalDate.parse(dob);
        } catch (DateTimeParseException e) {
            throw new CustomerInputValidator(e.getMessage());
        }

        Period period = Period.between(dateOfBirth, LocalDate.now());

        if (period.getYears() == age)
            return;

        throw new CustomerInputValidator("Date of birth does not match age");
    }
}
