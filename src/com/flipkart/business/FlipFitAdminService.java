package com.flipkart.business;

public class FlipFitAdminService implements FlipFitAdminInterface {
    @Override
    public void viewPendingCenter() {
        System.out.println("viewPendingCenter");
    }

    @Override
    public void viewPendingOwner() {
        System.out.println("viewPendingOwner");
    }

    @Override
    public void approveGymRequests(int gymId) {
        System.out.println("approveGymRequests: " + gymId);
    }

    @Override
    public void approveGymOwnerRequests(int ownerId) {
        System.out.println("approveGymOwnerRequests: " + ownerId);
    }

    @Override
    public void rejectGymRequests(int gymId) {
        System.out.println("rejectGymRequests: " + gymId);
    }

    @Override
    public void rejectGymOwnerRequests(int ownerId) {
        System.out.println("rejectGymOwnerRequests: " + ownerId);
    }

    @Override
    public void removeGym(int gymId) {
        System.out.println("removeGym: " + gymId);
    }

    @Override
    public void removeGymOwner(int ownerId) {
        System.out.println("removeGymOwner: " + ownerId);
    }

    @Override
    public void viewAllGymOwners() {
        System.out.println("viewAllGymOwners");
    }

    @Override
    public void viewGymDetails() {
        System.out.println("viewGymDetails");
    }
}
