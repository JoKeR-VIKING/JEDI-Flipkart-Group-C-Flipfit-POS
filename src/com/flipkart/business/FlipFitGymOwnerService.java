package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;

import java.util.List;
import java.util.ArrayList;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface {
    public List<FlipFitCentre> gymCentres = new ArrayList<>();
    public List<FlipFitCenterSlot> slots = new ArrayList<>();

    @Override
    public void addGym(String centreId, String centreName, String centreAddress, String id) {
        FlipFitCentre flipFitCentre = new FlipFitCentre(centreId, centreName, centreAddress, id);
        gymCentres.add(flipFitCentre);
    }

    @Override
    public void removeGym(String centreId) {
        gymCentres.removeIf(centre -> centre.getCentreId().equals(centreId));
    }

    @Override
    public void viewRegisteredGymCenters() {
        for (FlipFitCentre centre : gymCentres) {
            System.out.printf("Centre Id: %s\nCentre Name: %s\nCentre Address: %s\nVerified: %b\n", centre.getCentreId(), centre.getCentreName(), centre.getCentreAddress(), centre.getVerified());
        }
    }

    @Override
    public void addSlot(Integer gymId, String date, String startTime, String endTime, Integer noOfSeats) {

    }

    @Override
    public void removeSlot(Integer gymId, Integer slotId) {

    }

    @Override
    public void updateSlot(Integer gymId, Integer slotId, String details) {

    }

    @Override
    public void viewSlots() {

    }
}
