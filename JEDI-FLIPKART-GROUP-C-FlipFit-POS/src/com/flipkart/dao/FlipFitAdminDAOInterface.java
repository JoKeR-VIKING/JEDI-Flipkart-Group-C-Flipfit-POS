package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipFitAdminDAOInterface {
    public abstract void add(FlipFitAdmin admin);

    public abstract void approveOwner(String gymOwnerId);

    public abstract void rejectOwner(String gymOwnerId);

    public abstract List<FlipFitGymOwner> getPendingOwners();

    public abstract List<FlipFitGymOwner> getAllOwners();

    public abstract void approveGym(String centreId);

    public abstract void rejectGym(String centreId);

    public abstract void removeGym(String centreId);

    public abstract List<FlipFitCentre> getPendingCentres();

    public abstract List<FlipFitCentre> getAllCentres();
}
