package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitCentre;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FlipFitGymOwnerDAO {
    public static List<FlipFitGymOwner> GymOwners = new ArrayList<>();
    public static List<FlipFitCentre> Gyms = new ArrayList<>();

    public static void createProfile(FlipFitGymOwner gymOwner) {
        GymOwners.add(gymOwner);
    }

    public static void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) {
        for (FlipFitGymOwner gymOwner : GymOwners) {
            if (!gymOwner.getUserId().equals(gymOwnerId))
                continue;

            gymOwner.setAddress(address);
            gymOwner.setGstNumber(gstNumber);
            gymOwner.setPanCardNumber(panCardNumber);
            break;
        }
    }

    public static void addGym(FlipFitCentre centre) {
        Gyms.add(centre);
    }

    public static void removeGym(String centreId) {
        Gyms.removeIf(centre -> centre.getCentreId().equals(centreId));
    }

    public static List<FlipFitCentre> getRegisteredGymCentres() {
        return Gyms.stream()
            .filter(centre -> centre.getVerified().equals("APPROVED"))
            .toList();
    }
}