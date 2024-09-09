package com.flipkart.business;

import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;

import java.time.LocalDate;

/**
 * Interface defining the operations that can be performed by a customer in the FlipFit system.
 * This includes creating and editing customer profiles.
 */
public interface FlipFitCustomerInterface {

    /**
     * Creates a new customer profile.
     *
     * @param username the username for the new customer
     * @param password the password for the new customer
     * @param name the name of the new customer
     * @param address the address of the new customer
     * @param phoneNumber the phone number of the new customer
     * @param weight the weight of the new customer
     * @param age the age of the new customer
     * @param gender the gender of the new customer
     * @param dob the date of birth of the new customer
     * @throws ExistingUserException if a user with the same username already exists
     */
    void createProfile(String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob) throws ExistingUserException;

    /**
     * Edits an existing customer profile.
     *
     * @param customerId the unique identifier of the customer whose profile is to be edited
     * @param address the updated address of the customer
     * @param weight the updated weight of the customer
     * @param age the updated age of the customer
     * @param gender the updated gender of the customer
     * @param dob the updated date of birth of the customer
     * @throws InvalidUserException if the customer ID is invalid or if the operation fails
     */
    void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) throws InvalidUserException;
}
