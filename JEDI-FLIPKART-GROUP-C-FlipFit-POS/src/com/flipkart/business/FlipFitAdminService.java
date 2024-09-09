package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.InvalidGymOwnerException;

import java.util.List;

import static com.flipkart.dao.FlipFitAdminDAOImpl.FlipFitAdminDAOInst;

public class FlipFitAdminService implements FlipFitAdminInterface {
    @Override
    public void approveOwner(String gymOwnerId) throws InvalidGymOwnerException {
        FlipFitAdminDAOInst.approveOwner(gymOwnerId);
    }

    @Override
    public void rejectOwner(String gymOwnerId) {
        FlipFitAdminDAOInst.rejectOwner(gymOwnerId);
    }

    @Override
    public List<FlipFitGymOwner> displayPendingOwners() {
        return FlipFitAdminDAOInst.getPendingOwners();
    }

    @Override
    public List<FlipFitGymOwner> displayAllOwners() {
        return FlipFitAdminDAOInst.getAllOwners();
    }

    @Override
    public void approveGym(String centreId) {
        FlipFitAdminDAOInst.approveGym(centreId);
    }

    @Override
    public void rejectGym(String centreId) {
        FlipFitAdminDAOInst.rejectGym(centreId);
    }

    @Override
    public void removeGym(String centreId) {
        FlipFitAdminDAOInst.removeGym(centreId);
    }

    @Override
    public void removeOwner(String ownerId) {
        FlipFitAdminDAOInst.removeOwner(ownerId);
    }

    @Override
    public List<FlipFitCentre> displayPendingCentres() {
        return FlipFitAdminDAOInst.getPendingCentres();
    }

    @Override
    public List<FlipFitCentre> displayAllCentres() {
        return FlipFitAdminDAOInst.getAllCentres();
    }
}
