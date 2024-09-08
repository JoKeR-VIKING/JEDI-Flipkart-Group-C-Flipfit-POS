package com.flipkart.dao;

import com.flipkart.bean.FlipFitCentre;

import java.util.List;

public interface FlipFitCentreDAOInterface {
    void addGym(FlipFitCentre centre);

    void removeGym(String ownerId, String centreId);

    boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress);

    List<FlipFitCentre> getRegisteredGymCentres(String ownerId);
}
