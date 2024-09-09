package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;

/**
 * Interface for FlipFit Gym Owner Data Access Object (DAO) operations.
 * Provides methods to manage gym owner profiles.
 */
public interface FlipFitGymOwnerDAOInterface {

    /**
     * Creates a new gym owner profile in the system.
     *
     * @param gymOwner The FlipFitGymOwner object representing the gym owner to be added.
     * @throws ExistingUserException If a gym owner with the same ID or details already exists.
     */
    void createProfile(FlipFitGymOwner gymOwner) throws ExistingUserException;

    /**
     * Edits an existing gym owner profile in the system.
     *
     * @param gymOwnerId The ID of the gym owner whose profile is to be updated.
     * @param address The new address of the gym owner.
     * @param gstNumber The new GST number of the gym owner.
     * @param panCardNumber The new PAN card number of the gym owner.
     * @throws InvalidUserException If the gym owner ID is invalid or the user is not found.
     */
    void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) throws InvalidUserException;

    /**
     * Checks approval status for gym owner.
     *
     * @param userId The ID of the gym owner whose profile is to be checked.
     */
    boolean checkApproval(String userId);
}
