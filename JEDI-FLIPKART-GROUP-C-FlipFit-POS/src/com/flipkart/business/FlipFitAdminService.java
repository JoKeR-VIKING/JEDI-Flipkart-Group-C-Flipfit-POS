package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipFitAdminDAO;

import java.util.List;

public class FlipFitAdminService implements FlipFitAdminInterface {
    @Override
    public void approveOwner(String gymOwnerId) {
        FlipFitAdminDAO.approveOwner(gymOwnerId);
    }

    @Override
    public void rejectOwner(String gymOwnerId) {
        FlipFitAdminDAO.rejectOwner(gymOwnerId);
    }

    @Override
    public List<FlipFitGymOwner> displayPendingOwners() {
        return FlipFitAdminDAO.getPendingOwners();
    }

    @Override
    public List<FlipFitGymOwner> displayAllOwners() {
        return FlipFitAdminDAO.getAllOwners();
    }

    @Override
    public void approveGym(String centreId) {
        FlipFitAdminDAO.approveGym(centreId);
    }

    @Override
    public void rejectGym(String centreId) {
        FlipFitAdminDAO.rejectGym(centreId);
    }

    @Override
    public void removeGym(String centreId) {
        FlipFitAdminDAO.removeGym(centreId);
    }

    @Override
    public List<FlipFitCentre> displayPendingCentres() {
        return FlipFitAdminDAO.getPendingCentres();
    }

    @Override
    public List<FlipFitCentre> displayAllCentres() {
        return FlipFitAdminDAO.getAllCentres();
    }
}
