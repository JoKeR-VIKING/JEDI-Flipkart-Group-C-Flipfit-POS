package com.flipkart.validators;

import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Validator class for checking the validity of customer input data.
 */
public class CustomerInputValidator extends Exception {

    /**
     * Constructs a new {@code CustomerInputValidator} with the specified detail message.
     *
     * @param msg The detail message.
     */
    public CustomerInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates that the provided weight is a positive value.
     *
     * @param weight The weight to validate.
     * @throws CustomerInputValidator If the weight is not positive.
     */
    public static void validateWeight(double weight) throws CustomerInputValidator {
        if (weight > 0)
            return;

        throw new CustomerInputValidator("Invalid weight");
    }

    /**
     * Validates that the provided age is a positive value.
     *
     * @param age The age to validate.
     * @throws CustomerInputValidator If the age is not positive.
     */
    public static void validateAge(int age) throws CustomerInputValidator {
        if (age > 0)
            return;

        throw new CustomerInputValidator("Invalid age");
    }

    /**
     * Validates that the provided gender is one of the accepted values: "male", "female", or "others".
     *
     * @param gender The gender to validate.
     * @throws CustomerInputValidator If the gender is not one of the accepted values.
     */
    public static void validateGender(String gender) throws CustomerInputValidator {
        if (gender.equals("male") || gender.equals("female") || gender.equals("others"))
            return;

        throw new CustomerInputValidator("Invalid gender");
    }

    /**
     * Validates that the provided date of birth matches the provided age.
     *
     * @param dob The date of birth to validate, in the format "yyyy-MM-dd".
     * @param age The age to validate against.
     * @throws CustomerInputValidator If the date of birth does not match the provided age.
     */
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
