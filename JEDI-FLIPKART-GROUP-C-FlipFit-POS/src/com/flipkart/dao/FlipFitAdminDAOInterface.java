package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidGymOwnerException;

import java.util.List;

/**
 * Interface for FlipFit Admin Data Access Object (DAO) operations.
 * Provides methods to handle admin functionalities related to gym owners and centres.
 */
public interface FlipFitAdminDAOInterface {

    /**
     * Adds a new FlipFit admin to the system.
     *
     * @param admin The FlipFitAdmin object representing the admin to be added.
     * @throws ExistingUserException If the admin already exists in the system.
     */
    void add(FlipFitAdmin admin) throws ExistingUserException;

    /**
     * Approves a pending gym owner in the system.
     *
     * @param gymOwnerId The ID of the gym owner to be approved.
     * @throws InvalidGymOwnerException If the gym owner ID is invalid or not found.
     */
    void approveOwner(String gymOwnerId) throws InvalidGymOwnerException;

    /**
     * Rejects a pending gym owner in the system.
     *
     * @param gymOwnerId The ID of the gym owner to be rejected.
     * @throws InvalidGymOwnerException If the gym owner ID is invalid or not found.
     */
    void rejectOwner(String gymOwnerId) throws InvalidGymOwnerException;

    /**
     * Removes a gym owner from the system.
     *
     * @param ownerId The ID of the gym owner to be removed.
     * @throws InvalidGymOwnerException If the gym owner ID is invalid or not found.
     */
    void removeOwner(String ownerId) throws InvalidGymOwnerException;

    /**
     * Retrieves a list of gym owners that are pending approval.
     *
     * @return A List of FlipFitGymOwner objects representing pending gym owners.
     */
    List<FlipFitGymOwner> getPendingOwners();

    /**
     * Retrieves a list of all gym owners in the system.
     *
     * @return A List of FlipFitGymOwner objects representing all gym owners.
     */
    List<FlipFitGymOwner> getAllOwners();

    /**
     * Approves a pending gym centre in the system.
     *
     * @param centreId The ID of the gym centre to be approved.
     * @throws InvalidGymException If the gym centre ID is invalid or not found.
     */
    void approveGym(String centreId) throws InvalidGymException;

    /**
     * Rejects a pending gym centre in the system.
     *
     * @param centreId The ID of the gym centre to be rejected.
     * @throws InvalidGymException If the gym centre ID is invalid or not found.
     */
    void rejectGym(String centreId) throws InvalidGymException;

    /**
     * Removes a gym centre from the system.
     *
     * @param centreId The ID of the gym centre to be removed.
     * @throws InvalidGymException If the gym centre ID is invalid or not found.
     */
    void removeGym(String centreId) throws InvalidGymException;

    /**
     * Retrieves a list of gym centres that are pending approval.
     *
     * @return A List of FlipFitCentre objects representing pending gym centres.
     */
    List<FlipFitCentre> getPendingCentres();

    /**
     * Retrieves a list of all gym centres in the system.
     *
     * @return A List of FlipFitCentre objects representing all gym centres.
     */
    List<FlipFitCentre> getAllCentres();
}
