package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;

import java.time.LocalDate;

/**
 * Interface for FlipFit Customer Data Access Object (DAO) operations.
 * Provides methods to manage customer profiles.
 */
public interface FlipFitCustomerDAOInterface {

    /**
     * Creates a new customer profile in the system.
     *
     * @param customer The FlipFitCustomer object representing the customer to be added.
     * @throws ExistingUserException If a customer with the same ID or details already exists.
     */
    void createProfile(FlipFitCustomer customer) throws ExistingUserException;

    /**
     * Edits an existing customer profile in the system.
     *
     * @param customerId The ID of the customer whose profile is to be updated.
     * @param address The new address of the customer.
     * @param weight The new weight of the customer.
     * @param age The new age of the customer.
     * @param gender The new gender of the customer.
     * @param dob The new date of birth of the customer.
     * @throws InvalidUserException If the customer ID is invalid or the user is not found.
     */
    void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) throws InvalidUserException;
}
