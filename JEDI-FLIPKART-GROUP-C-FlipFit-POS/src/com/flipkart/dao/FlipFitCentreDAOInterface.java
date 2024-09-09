package com.flipkart.dao;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.UnauthorizedGymOwnerException;

import java.util.List;

/**
 * Interface for operations related to gym centres in the FlipFit system.
 * Provides methods for managing gym centres, including adding, removing, and modifying gym details.
 */
public interface FlipFitCentreDAOInterface {

    /**
     * Retrieves a gym centre by its ID.
     *
     * @param gymId The ID of the gym centre to retrieve.
     * @return The {@link FlipFitCentre} object representing the gym centre, or null if no gym centre is found with the given ID.
     */
    FlipFitCentre getGymById(String gymId);

    /**
     * Retrieves a list of gym centres located in a specific city.
     *
     * @param city The city where the gym centres are located.
     * @return A list of {@link FlipFitCentre} objects representing the gym centres in the specified city.
     */
    List<FlipFitCentre> getGymListByCity(String city);

    /**
     * Retrieves a list of gym centres located in a specific city and registered under a specific gym owner.
     *
     * @param city The city where the gym centres are located.
     * @param ownerId The ID of the gym owner whose gym centres are to be retrieved.
     * @return A list of {@link FlipFitCentre} objects representing the gym centres in the specified city and registered under the specified owner.
     */
    List<FlipFitCentre> getGymListByCityAndOwner(String city, String ownerId);

    /**
     * Adds a new gym centre to the system.
     *
     * @param centre The {@link FlipFitCentre} object representing the gym centre to be added.
     */
    void addGym(FlipFitCentre centre);

    /**
     * Removes a gym centre from the system.
     *
     * @param ownerId The ID of the gym owner requesting the removal of the gym centre.
     * @param centreId The ID of the gym centre to be removed.
     * @throws UnauthorizedGymOwnerException If the gym owner is not authorized to remove the gym centre.
     */
    void removeGym(String ownerId, String centreId) throws UnauthorizedGymOwnerException;

    /**
     * Modifies the details of an existing gym centre.
     *
     * @param ownerId The ID of the gym owner requesting the modification.
     * @param gymId The ID of the gym centre to be modified.
     * @param gymCity The new city of the gym centre.
     * @param gymName The new name of the gym centre.
     * @param gymAddress The new address of the gym centre.
     * @return true if the modification was successful, false otherwise.
     * @throws UnauthorizedGymOwnerException If the gym owner is not authorized to modify the gym centre.
     * @throws InvalidGymException If the provided gym ID is invalid or not found.
     */
    boolean modifyGym(String ownerId, String gymId, String gymCity, String gymName, String gymAddress)
            throws UnauthorizedGymOwnerException, InvalidGymException;

    /**
     * Retrieves a list of gym centres registered by a specific gym owner.
     *
     * @param ownerId The ID of the gym owner whose registered gym centres are to be retrieved.
     * @return A list of {@link FlipFitCentre} objects representing the gym centres registered by the specified owner.
     */
    List<FlipFitCentre> getRegisteredGymCentres(String ownerId);
}
