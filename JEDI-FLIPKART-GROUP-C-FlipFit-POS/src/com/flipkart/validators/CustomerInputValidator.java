package com.flipkart.validators;

import java.time.Period;
import java.time.LocalDate;

public class CustomerInputValidator {
    public static boolean validateWeight(int weight) {
        return weight > 0;
    }

    public static boolean validateAge(int age) {
        return age > 0;
    }

    public static boolean validateGender(String gender) {
        return gender.equals("male") || gender.equals("female") || gender.equals("others");
    }

    public static boolean validateDob(LocalDate dob, int age) {
        Period period = Period.between(dob, LocalDate.now());

        return period.getYears() == age;
    }
}
