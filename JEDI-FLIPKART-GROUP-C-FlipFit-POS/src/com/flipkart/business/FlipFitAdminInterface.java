package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public interface FlipFitAdminInterface {
    void approveOwner(String gymOwnerId);

    void rejectOwner(String gymOwnerId);

    void removeOwner(String ownerId);

    List<FlipFitGymOwner> displayPendingOwners();

    List<FlipFitGymOwner> displayAllOwners();

    void approveGym(String centreId);

    void rejectGym(String centreId);

    void removeGym(String centreId);

    List<FlipFitCentre> displayPendingCentres();

    List<FlipFitCentre> displayAllCentres();
}
