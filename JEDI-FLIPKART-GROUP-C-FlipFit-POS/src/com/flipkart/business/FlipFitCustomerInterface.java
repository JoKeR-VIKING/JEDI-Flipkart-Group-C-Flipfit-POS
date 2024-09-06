package com.flipkart.business;

import java.time.LocalDate;

public interface FlipFitCustomerInterface {
    void createProfile(String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob);

    void editProfile(String customerId, String name, String phone, String address, Double weight, Integer age, String gender, LocalDate dob);
}
