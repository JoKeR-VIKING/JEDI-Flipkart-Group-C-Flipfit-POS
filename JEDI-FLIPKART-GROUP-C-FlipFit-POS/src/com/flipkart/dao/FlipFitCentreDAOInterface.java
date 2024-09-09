package com.flipkart.dao;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.exception.UnauthorizedGymOwnerException;

import java.util.List;

/**
 * Interface for FlipFit Centre Data Access Object (DAO) operations.
 * Provides methods for gym owners to manage their gym centres.
 */
public interface FlipFitCentreDAOInterface {

    /**
     * Adds a new gym centre to the system.
     *
     * @param centre The FlipFitCentre object representing the gym centre to be added.
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
     * @param gymId The ID of the gym to be modified.
     * @param gymName The new name of the gym.
     * @param gymAddress The new address of the gym.
     * @return true if the modification was successful, false otherwise.
     * @throws UnauthorizedGymOwnerException If the owner is not authorized to modify the gym.
     */
    boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress) throws UnauthorizedGymOwnerException;

    /**
     * Retrieves the list of gym centres registered by a specific gym owner.
     *
     * @param ownerId The ID of the gym owner.
     * @return A List of FlipFitCentre objects representing the registered gym centres.
     */
    List<FlipFitCentre> getRegisteredGymCentres(String ownerId);
}
