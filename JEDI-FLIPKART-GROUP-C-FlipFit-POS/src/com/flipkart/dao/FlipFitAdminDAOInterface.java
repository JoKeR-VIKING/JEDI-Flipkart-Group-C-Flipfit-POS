package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.InvalidGymOwnerException;

import java.util.List;

public interface FlipFitAdminDAOInterface {
    void add(FlipFitAdmin admin);

    void approveOwner(String gymOwnerId) throws InvalidGymOwnerException;

    void rejectOwner(String gymOwnerId);

    void removeOwner(String ownerId);

    List<FlipFitGymOwner> getPendingOwners();

    List<FlipFitGymOwner> getAllOwners();

    void approveGym(String centreId);

    void rejectGym(String centreId);

    void removeGym(String centreId);

    List<FlipFitCentre> getPendingCentres();

    List<FlipFitCentre> getAllCentres();
}
