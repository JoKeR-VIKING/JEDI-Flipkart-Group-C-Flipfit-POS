package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;
import java.util.stream.Collectors;

import static com.flipkart.dao.FlipFitGymOwnerDAO.FlipFitGymOwnerDAOInst;
import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public interface FlipFitAdminDAOInterface {
    void refreshAdmins() ;

    void add(FlipFitAdmin admin) ;

    void approveOwner(String gymOwnerId);

    void rejectOwner(String gymOwnerId);

    List<FlipFitGymOwner> getPendingOwners();

    List<FlipFitGymOwner> getAllOwners();

    void approveGym(String centreId);

    void rejectGym(String centreId) ;

    void removeGym(String centreId) ;

    List<FlipFitCentre> getPendingCentres() ;

    List<FlipFitCentre> getAllCentres();
}
