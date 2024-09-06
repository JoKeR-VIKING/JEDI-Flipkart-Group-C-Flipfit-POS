package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipFitAdminInterface {
    public abstract void approveOwner(String gymOwnerId);

    public abstract void rejectOwner(String gymOwnerId);

    public abstract List<FlipFitGymOwner> displayPendingOwners();

    public abstract List<FlipFitGymOwner> displayAllOwners();

    public abstract void approveGym(String centreId);

    public abstract void rejectGym(String centreId);

    public abstract void removeGym(String centreId);

    public abstract List<FlipFitCentre> displayPendingCentres();

    public abstract List<FlipFitCentre> displayAllCentres();
}
