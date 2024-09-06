package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipFitAdminDAO;
import com.flipkart.dao.FlipFitGymOwnerDAO;

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

    public void viewGymDetails() {
        for (FlipFitCentre centre: FlipFitGymOwnerDAO.Gyms) {
            System.out.println("Centre ID: " + centre.getCentreId());
            System.out.println("Centre Name: " + centre.getCentreName());
            System.out.println("Centre Address: " + centre.getCentreAddress());
            System.out.println("Centre Owner: " + centre.getGymOwner());
        }
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
