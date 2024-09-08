package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

import static com.flipkart.dao.FlipFitAdminDAOImpl.FlipFitAdminDAOInst;
import static com.flipkart.dao.FlipFitGymOwnerDAOImpl.FlipFitGymOwnerDAOInst;

public class FlipFitAdminService implements FlipFitAdminInterface {
    @Override
    public void approveOwner(String gymOwnerId) {
        FlipFitAdminDAOInst.approveOwner(gymOwnerId);
    }

    @Override
    public void rejectOwner(String gymOwnerId) {
        FlipFitAdminDAOInst.rejectOwner(gymOwnerId);
    }

    public void viewGymDetails() {
        for (FlipFitCentre centre : FlipFitGymOwnerDAOInst.Gyms) {
            System.out.println("Centre ID: " + centre.getCentreId());
            System.out.println("Centre Name: " + centre.getCentreName());
            System.out.println("Centre Address: " + centre.getCentreAddress());
            System.out.println("Centre Owner: " + centre.getGymOwner());
        }
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
    public List<FlipFitCentre> displayPendingCentres() {
        return FlipFitAdminDAOInst.getPendingCentres();
    }

    @Override
    public List<FlipFitCentre> displayAllCentres() {
        return FlipFitAdminDAOInst.getAllCentres();
    }
}
