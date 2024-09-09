package com.flipkart.business;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidGymOwnerException;

import java.util.List;

public interface FlipFitAdminInterface {
    void approveOwner(String gymOwnerId) throws InvalidGymOwnerException;

    void rejectOwner(String gymOwnerId) throws InvalidGymOwnerException;

    void removeOwner(String ownerId) throws InvalidGymOwnerException;

    List<FlipFitGymOwner> displayPendingOwners();

    List<FlipFitGymOwner> displayAllOwners();

    void approveGym(String centreId) throws InvalidGymException;

    void rejectGym(String centreId) throws InvalidGymException;

    void removeGym(String centreId) throws InvalidGymException;

    List<FlipFitCentre> displayPendingCentres();

    List<FlipFitCentre> displayAllCentres();
}
