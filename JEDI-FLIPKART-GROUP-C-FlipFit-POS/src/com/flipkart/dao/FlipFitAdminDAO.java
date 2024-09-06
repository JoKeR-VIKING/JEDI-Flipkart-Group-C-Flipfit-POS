package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlipFitAdminDAO {
    public static List<FlipFitAdmin> admins = Collections.emptyList();

    static {
        refreshAdmins();
    }

    public static void refreshAdmins() {
        admins = FlipFitUserDAO.USERS.stream()
                .filter(user -> (user instanceof FlipFitAdmin))
                .map(user -> (FlipFitAdmin) user)
                .toList();
    }

    public static void add(FlipFitAdmin admin) {
        FlipFitUserDAO.add(admin);
        refreshAdmins();
    }

    public static void approveOwner(String gymOwnerId) {
        for (FlipFitGymOwner owner : FlipFitGymOwnerDAO.GymOwners) {
            if (!owner.getUserId().equals(gymOwnerId))
                continue;

            owner.setVerified("APPROVED");
            break;
        }
    }

    public static void rejectOwner(String gymOwnerId) {
        for (FlipFitGymOwner owner : FlipFitGymOwnerDAO.GymOwners) {
            if (!owner.getUserId().equals(gymOwnerId))
                continue;

            owner.setVerified("REJECTED");
            break;
        }
    }

    public static List<FlipFitGymOwner> getPendingOwners() {
        FlipFitGymOwnerDAO.GymOwners = FlipFitGymOwnerDAO.GymOwners.stream()
                .filter(owner -> owner.getVerified().equals("PENDING"))
                .collect(Collectors.toList());

        return FlipFitGymOwnerDAO.GymOwners;
    }

    public static List<FlipFitGymOwner> getAllOwners() {
        return FlipFitGymOwnerDAO.GymOwners;
    }

    public static void approveGym(String centreId) {
        for (FlipFitCentre centre : FlipFitGymOwnerDAO.Gyms) {
            if (!centre.getCentreId().equals(centreId))
                continue;

            centre.setVerified("APPROVED");
            break;
        }
    }

    public static void rejectGym(String centreId) {
        for (FlipFitCentre centre : FlipFitGymOwnerDAO.Gyms) {
            if (!centre.getCentreId().equals(centreId))
                continue;

            centre.setVerified("REJECTED");
            break;
        }
    }

    public static void removeGym(String centreId) {
        FlipFitGymOwnerDAO.Gyms.removeIf(centre -> centre.getCentreId().equals(centreId));
    }

    public static List<FlipFitCentre> getPendingCentres() {
        FlipFitGymOwnerDAO.Gyms = FlipFitGymOwnerDAO.Gyms.stream()
                .filter(centre -> centre.getVerified().equals("PENDING"))
                .toList();

        return FlipFitGymOwnerDAO.Gyms;
    }

    public static List<FlipFitCentre> getAllCentres() {
        return FlipFitGymOwnerDAO.Gyms;
    }
}
