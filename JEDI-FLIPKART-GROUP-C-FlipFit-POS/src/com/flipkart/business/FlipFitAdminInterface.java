package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidGymOwnerException;

import java.util.List;

/**
 * Interface defining the operations that an admin can perform in the FlipFit system.
 * This includes approving, rejecting, and removing gym owners and centres, as well as displaying their information.
 */
public interface FlipFitAdminInterface {

    /**
     * Approves a gym owner based on their unique identifier.
     *
     * @param gymOwnerId the unique identifier of the gym owner to be approved
     * @throws InvalidGymOwnerException if the gym owner ID is invalid or if the operation fails
     */
    void approveOwner(String gymOwnerId) throws InvalidGymOwnerException;

    /**
     * Rejects a gym owner based on their unique identifier.
     *
     * @param gymOwnerId the unique identifier of the gym owner to be rejected
     * @throws InvalidGymOwnerException if the gym owner ID is invalid or if the operation fails
     */
    void rejectOwner(String gymOwnerId) throws InvalidGymOwnerException;

    /**
     * Removes a gym owner from the system based on their unique identifier.
     *
     * @param ownerId the unique identifier of the gym owner to be removed
     * @throws InvalidGymOwnerException if the gym owner ID is invalid or if the operation fails
     */
    void removeOwner(String ownerId) throws InvalidGymOwnerException;

    /**
     * Displays a list of gym owners whose approval is pending.
     *
     * @return a list of pending gym owners
     */
    List<FlipFitGymOwner> displayPendingOwners();

    /**
     * Displays a list of all gym owners.
     *
     * @return a list of all gym owners
     */
    List<FlipFitGymOwner> displayAllOwners();

    /**
     * Approves a gym centre based on its unique identifier.
     *
     * @param centreId the unique identifier of the gym centre to be approved
     * @throws InvalidGymException if the gym centre ID is invalid or if the operation fails
     */
    void approveGym(String centreId) throws InvalidGymException;

    /**
     * Rejects a gym centre based on its unique identifier.
     *
     * @param centreId the unique identifier of the gym centre to be rejected
     * @throws InvalidGymException if the gym centre ID is invalid or if the operation fails
     */
    void rejectGym(String centreId) throws InvalidGymException;

    /**
     * Removes a gym centre from the system based on its unique identifier.
     *
     * @param centreId the unique identifier of the gym centre to be removed
     * @throws InvalidGymException if the gym centre ID is invalid or if the operation fails
     */
    void removeGym(String centreId) throws InvalidGymException;

    /**
     * Displays a list of gym centres whose approval is pending.
     *
     * @return a list of pending gym centres
     */
    List<FlipFitCentre> displayPendingCentres();

    /**
     * Displays a list of all gym centres.
     *
     * @return a list of all gym centres
     */
    List<FlipFitCentre> displayAllCentres();
}
