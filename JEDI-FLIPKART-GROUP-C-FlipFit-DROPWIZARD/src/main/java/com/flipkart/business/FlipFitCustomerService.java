package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.util.List;

import static com.flipkart.dao.FlipFitCentreDAOImpl.FlipFitCentreDAOInst;
import static com.flipkart.dao.FlipFitCustomerDAOImpl.FlipFitCustomerDAOInst;

/**
 * Service class implementing the {@link FlipFitCustomerInterface}.
 * This class provides the business logic for managing customer profiles, including creating and editing profiles.
 */
public class FlipFitCustomerService implements FlipFitCustomerInterface {

    /**
     * Creates a new customer profile.
     * Generates a unique ID for the new customer and delegates the creation to the data access object.
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
    @Override
    public void createProfile(String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob) throws ExistingUserException {
        FlipFitCustomer customer = new FlipFitCustomer(Helper.generateId(), username, password, name, address, phoneNumber, weight, age, gender, dob);
        FlipFitCustomerDAOInst.createProfile(customer);
    }

    /**
     * Edits an existing customer profile.
     * Delegates the update request to the data access object.
     *
     * @param customerId the unique identifier of the customer whose profile is to be edited
     * @param address the updated address of the customer
     * @param weight the updated weight of the customer
     * @param age the updated age of the customer
     * @param gender the updated gender of the customer
     * @param dob the updated date of birth of the customer
     * @throws InvalidUserException if the customer ID is invalid or if the operation fails
     */
    @Override
    public void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) throws InvalidUserException {
        FlipFitCustomerDAOInst.editProfile(customerId, address, weight, age, gender, dob);
    }

    /**
     * Retrieves a list of gym centers located in a specific city.
     * Delegates the request to the data access object.
     *
     * @param city the city for which to retrieve the list of gym centers
     * @return a List of FlipFitCentre objects representing gym centers in the specified city
     */
    @Override
    public List<FlipFitCentre> getCentreListByCity(String city) {
        return FlipFitCentreDAOInst.getGymListByCity(city);
    }
}
