package com.flipkart.validators;

import java.time.Period;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static com.flipkart.constants.ConsoleConstants.formatter;

/**
 * Custom exception class used for validating customer inputs.
 * Extends {@link Exception} to provide specific error messages for validation issues.
 */
public class CustomerInputValidator extends Exception {

    /**
     * Constructs a new CustomerInputValidator with the specified detail message.
     *
     * @param msg The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public CustomerInputValidator(String msg) {
        super(msg);
    }

    /**
     * Validates that the provided weight is a positive number.
     *
     * @param weight The weight to be validated.
     * @throws CustomerInputValidator If the weight is less than or equal to zero.
     */
    public static void validateWeight(double weight) throws CustomerInputValidator {
        if (weight > 0) {
            return;
        }
        throw new CustomerInputValidator("Invalid weight");
    }

    /**
     * Validates that the provided age is a positive integer.
     *
     * @param age The age to be validated.
     * @throws CustomerInputValidator If the age is less than or equal to zero.
     */
    public static void validateAge(int age) throws CustomerInputValidator {
        if (age > 0) {
            return;
        }
        throw new CustomerInputValidator("Invalid age");
    }

    /**
     * Validates that the provided gender is one of the allowed values: "male", "female", or "others".
     *
     * @param gender The gender to be validated.
     * @throws CustomerInputValidator If the gender is not one of the allowed values.
     */
    public static void validateGender(String gender) throws CustomerInputValidator {
        if (gender.equals("male") || gender.equals("female") || gender.equals("others")) {
            return;
        }
        throw new CustomerInputValidator("Invalid gender");
    }

    /**
     * Validates that the provided date of birth matches the provided age.
     *
     * @param dob The date of birth to be validated.
     * @param age The expected age based on the date of birth.
     * @throws CustomerInputValidator If the date of birth does not match the provided age or is invalid.
     */
    public static void validateDob(String dob, int age) throws CustomerInputValidator {
        LocalDate dateOfBirth;

        try {
            dateOfBirth = LocalDate.parse(dob, formatter);
        } catch (DateTimeParseException e) {
            throw new CustomerInputValidator("Invalid date format: " + e.getMessage());
        }

        Period period = Period.between(dateOfBirth, LocalDate.now());

        if (period.getYears() == age) {
            return;
        }

        throw new CustomerInputValidator("Date of birth does not match age");
    }
}
