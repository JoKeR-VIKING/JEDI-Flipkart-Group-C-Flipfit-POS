package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidGymOwnerException;

import java.util.List;

import static com.flipkart.dao.FlipFitAdminDAOImpl.FlipFitAdminDAOInst;

/**
 * Provides business logic for administrative tasks including approving or rejecting gym owners and gyms,
 * and managing gym and owner data.
 */
public class FlipFitAdminService implements FlipFitAdminInterface {

    /**
     * Approves a gym owner.
     *
     * @param gymOwnerId The ID of the gym owner to be approved.
     * @throws InvalidGymOwnerException If the gym owner ID is invalid.
     */
    @Override
    public void approveOwner(String gymOwnerId) throws InvalidGymOwnerException {
        FlipFitAdminDAOInst.approveOwner(gymOwnerId);
    }

    /**
     * Rejects a gym owner.
     *
     * @param gymOwnerId The ID of the gym owner to be rejected.
     * @throws InvalidGymOwnerException If the gym owner ID is invalid.
     */
    @Override
    public void rejectOwner(String gymOwnerId) throws InvalidGymOwnerException {
        FlipFitAdminDAOInst.rejectOwner(gymOwnerId);
    }

    /**
     * Retrieves a list of all pending gym owners.
     *
     * @return A list of gym owners whose approval is pending.
     */
    @Override
    public List<FlipFitGymOwner> displayPendingOwners() {
        return FlipFitAdminDAOInst.getPendingOwners();
    }

    /**
     * Retrieves a list of all gym owners.
     *
     * @return A list of all gym owners.
     */
    @Override
    public List<FlipFitGymOwner> displayAllOwners() {
        return FlipFitAdminDAOInst.getAllOwners();
    }

    /**
     * Approves a gym.
     *
     * @param centreId The ID of the gym to be approved.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public void approveGym(String centreId) throws InvalidGymException {
        FlipFitAdminDAOInst.approveGym(centreId);
    }

    /**
     * Rejects a gym.
     *
     * @param centreId The ID of the gym to be rejected.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public void rejectGym(String centreId) throws InvalidGymException {
        FlipFitAdminDAOInst.rejectGym(centreId);
    }

    /**
     * Removes a gym.
     *
     * @param centreId The ID of the gym to be removed.
     * @throws InvalidGymException If the gym ID is invalid.
     */
    @Override
    public void removeGym(String centreId) throws InvalidGymException {
        FlipFitAdminDAOInst.removeGym(centreId);
    }

    /**
     * Removes a gym owner.
     *
     * @param ownerId The ID of the gym owner to be removed.
     * @throws InvalidGymOwnerException If the gym owner ID is invalid.
     */
    @Override
    public void removeOwner(String ownerId) throws InvalidGymOwnerException {
        FlipFitAdminDAOInst.removeOwner(ownerId);
    }

    /**
     * Retrieves a list of all pending gyms.
     *
     * @return A list of gyms whose approval is pending.
     */
    @Override
    public List<FlipFitCentre> displayPendingCentres() {
        return FlipFitAdminDAOInst.getPendingCentres();
    }

    /**
     * Retrieves a list of all gyms.
     *
     * @return A list of all gyms.
     */
    @Override
    public List<FlipFitCentre> displayAllCentres() {
        return FlipFitAdminDAOInst.getAllCentres();
    }
}
