package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidGymOwnerException;

import java.util.List;

public interface FlipFitAdminDAOInterface {
    void add(FlipFitAdmin admin) throws ExistingUserException;

    void approveOwner(String gymOwnerId) throws InvalidGymOwnerException;

    void rejectOwner(String gymOwnerId) throws InvalidGymOwnerException;

    void removeOwner(String ownerId) throws InvalidGymOwnerException;

    List<FlipFitGymOwner> getPendingOwners();

    List<FlipFitGymOwner> getAllOwners();

    void approveGym(String centreId) throws InvalidGymException;

    void rejectGym(String centreId) throws InvalidGymException;

    void removeGym(String centreId) throws InvalidGymException;

    List<FlipFitCentre> getPendingCentres();

    List<FlipFitCentre> getAllCentres();
}
