package com.flipkart.business;

import com.flipkart.exception.ExistingUserException;

import java.time.LocalDate;

public interface FlipFitCustomerInterface {
    void createProfile(String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob) throws ExistingUserException;

    void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob);
}
