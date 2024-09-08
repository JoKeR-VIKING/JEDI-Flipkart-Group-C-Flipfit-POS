package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;

import java.time.LocalDate;

public interface FlipFitCustomerDAOInterface {
    void createProfile(FlipFitCustomer customer);

    void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob);
}
