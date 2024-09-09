package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;

import java.time.LocalDate;

public interface FlipFitCustomerDAOInterface {
    void createProfile(FlipFitCustomer customer) throws ExistingUserException;

    void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) throws InvalidUserException;
}
