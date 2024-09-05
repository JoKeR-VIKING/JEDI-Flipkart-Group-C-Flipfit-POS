package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitCentre;

import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FlipFitGymOwnerDAO {
    public static List<FlipFitGymOwner> GymOwners = new ArrayList<>();
    public static List<FlipFitCentre> Gyms = new ArrayList<>();

    public static List<FlipFitCenterSlot> slots = new ArrayList<>();

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

    public static void addSlot(FlipFitCenterSlot slot) {
        slots.add(slot);
    }

    public static void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) {
        for(int i=0; i<slots.size(); i++) {
            if (slots.get(i).getSlotId().equals(slotId)) {
                slots.get(i).setStartTime(startTime);
                slots.get(i).setSeatLimit(noOfSeats);
            }
        }
    }

    public static void deleteSlot(String slotId) {
        slots.removeIf(slot -> slot.getSlotId().equals(slotId));
    }
}