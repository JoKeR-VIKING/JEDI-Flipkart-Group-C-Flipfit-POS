package com.flipkart.dao;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.exception.UnauthorizedGymOwnerException;

import java.util.List;

public interface FlipFitCentreDAOInterface {
    void addGym(FlipFitCentre centre);

    void removeGym(String ownerId, String centreId) throws UnauthorizedGymOwnerException;

    boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress) throws UnauthorizedGymOwnerException;

    List<FlipFitCentre> getRegisteredGymCentres(String ownerId);
}
