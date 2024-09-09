package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;

/**
 * Interface for FlipFit User Data Access Object (DAO) operations.
 * Provides methods to manage user details, including adding users, updating passwords, and retrieving users.
 */
public interface FlipFitUserDAOInterface {

    /**
     * Adds a new user to the system.
     *
     * @param user The FlipFitUser object representing the user to be added.
     * @throws ExistingUserException If a user with the same username or details already exists.
     */
    void add(FlipFitUser user) throws ExistingUserException;

    /**
     * Updates the password for an existing user.
     *
     * @param userId The ID of the user whose password is to be updated.
     * @param password The new password for the user.
     * @throws InvalidUserException If the user ID is invalid or the user is not found.
     */
    void updatePassword(String userId, String password) throws InvalidUserException;

    /**
     * Updates the address for a gym owner.
     *
     * @param gymOwnerId The ID of the gym owner whose address is to be updated.
     * @param address The new address for the gym owner.
     * @throws InvalidUserException If the gym owner ID is invalid or the user is not found.
     */
    void updateAddress(String gymOwnerId, String address) throws InvalidUserException;

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to be retrieved.
     * @return The FlipFitUser object representing the user if found, otherwise null.
     */
    FlipFitUser findByUsername(String username);
}
