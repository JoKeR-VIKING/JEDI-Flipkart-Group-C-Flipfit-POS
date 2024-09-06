package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.flipkart.dao.FlipFitGymOwnerDAO.FlipFitGymOwnerDAOInst;
import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public class FlipFitAdminDAO {
    public static FlipFitAdminDAO FlipFitAdminDAOInst = new FlipFitAdminDAO();
    public List<FlipFitAdmin> admins = Collections.emptyList();

    static {
        refreshAdmins();
    }

    public static void refreshAdmins() {
        FlipFitAdminDAOInst.admins = FlipFitUserDAOInst.USERS.stream()
                .filter(user -> (user instanceof FlipFitAdmin))
                .map(user -> (FlipFitAdmin) user)
                .toList();
    }

    public void add(FlipFitAdmin admin) {
        FlipFitUserDAOInst.add(admin);
        refreshAdmins();
    }

    public void approveOwner(String gymOwnerId) {
        for (FlipFitGymOwner owner : FlipFitGymOwnerDAOInst.GymOwners) {
            if (!owner.getUserId().equals(gymOwnerId))
                continue;

            owner.setVerified("APPROVED");
            break;
        }
    }

    public void rejectOwner(String gymOwnerId) {
        for (FlipFitGymOwner owner : FlipFitGymOwnerDAOInst.GymOwners) {
            if (!owner.getUserId().equals(gymOwnerId))
                continue;

            owner.setVerified("REJECTED");
            break;
        }
    }

    public List<FlipFitGymOwner> getPendingOwners() {
        FlipFitGymOwnerDAOInst.GymOwners = FlipFitGymOwnerDAOInst.GymOwners.stream()
                .filter(owner -> owner.getVerified().equals("PENDING"))
                .collect(Collectors.toList());

        return FlipFitGymOwnerDAOInst.GymOwners;
    }

    public List<FlipFitGymOwner> getAllOwners() {
        return FlipFitGymOwnerDAOInst.GymOwners;
    }

    public void approveGym(String centreId) {
        for (FlipFitCentre centre : FlipFitGymOwnerDAOInst.Gyms) {
            if (!centre.getCentreId().equals(centreId))
                continue;

            centre.setVerified("APPROVED");
            break;
        }
    }

    public void rejectGym(String centreId) {
        for (FlipFitCentre centre : FlipFitGymOwnerDAOInst.Gyms) {
            if (!centre.getCentreId().equals(centreId))
                continue;

            centre.setVerified("REJECTED");
            break;
        }
    }

    public void removeGym(String centreId) {
        FlipFitGymOwnerDAOInst.Gyms.removeIf(centre -> centre.getCentreId().equals(centreId));
    }

    public List<FlipFitCentre> getPendingCentres() {
        FlipFitGymOwnerDAOInst.Gyms = FlipFitGymOwnerDAOInst.Gyms.stream()
                .filter(centre -> centre.getVerified().equals("PENDING"))
                .toList();

        return FlipFitGymOwnerDAOInst.Gyms;
    }

    public List<FlipFitCentre> getAllCentres() {
        return FlipFitGymOwnerDAOInst.Gyms;
    }
}
