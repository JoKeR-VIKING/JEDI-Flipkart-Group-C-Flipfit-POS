package com.flipkart.dao;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.UnauthorizedGymOwnerException;

import java.util.List;

/**
 * Interface for operations related to gym centres in the FlipFit system.
 * Provides methods for gym owners to manage their gym centres.
 */
public interface FlipFitCentreDAOInterface {

    /**
     * Retrieves a gym centre by its ID.
     *
     * @param gymId The ID of the gym centre to retrieve.
     * @return The {@link FlipFitCentre} object representing the gym centre, or null if not found.
     */
    FlipFitCentre getGymById(String gymId);

    /**
     * Adds a new gym centre to the system.
     *
     * @param centre The {@link FlipFitCentre} object representing the gym centre to be added.
     */
    void addGym(FlipFitCentre centre);

    /**
     * Removes a gym centre from the system.
     *
     * @param ownerId The ID of the gym owner requesting the removal.
     * @param centreId The ID of the gym centre to be removed.
     * @throws UnauthorizedGymOwnerException If the owner is not authorized to remove the gym.
     */
    void removeGym(String ownerId, String centreId) throws UnauthorizedGymOwnerException;

    /**
     * Modifies the details of an existing gym centre.
     *
     * @param ownerId The ID of the gym owner requesting the modification.
     * @param gymId The ID of the gym centre to be modified.
     * @param gymName The new name of the gym centre.
     * @param gymAddress The new address of the gym centre.
     * @return true if the modification was successful, false otherwise.
     * @throws UnauthorizedGymOwnerException If the owner is not authorized to modify the gym centre.
     * @throws InvalidGymException If the provided gym ID is invalid or not found.
     */
    boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress)
            throws UnauthorizedGymOwnerException, InvalidGymException;

    /**
     * Retrieves the list of gym centres registered by a specific gym owner.
     *
     * @param ownerId The ID of the gym owner.
     * @return A List of {@link FlipFitCentre} objects representing the gym centres registered by the owner.
     */
    List<FlipFitCentre> getRegisteredGymCentres(String ownerId);
}
