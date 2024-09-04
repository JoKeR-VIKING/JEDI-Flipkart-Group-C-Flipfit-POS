package com.flipkart.business;

public class FlipFitAdminService {
    public void approveGymOwner() {

    }

    public void approveGymCentre() {

    }

    public void rejectGymOwner() {

    }

    public void rejectGymCentre() {

    }

    public void viewPendingCenter() {
        System.out.println("viewPendingCenter");
    }

    public void viewPendingOwner() {
        System.out.println("viewPendingOwner");
    }

    public void approveGymRequests(int gymId) {
        System.out.println("approveGymRequests: " + gymId);
    }

    public void approveGymOwnerRequests(int ownerId) {
        System.out.println("approveGymOwnerRequests: " + ownerId);
    }

    public void rejectGymRequests(int gymId) {
        System.out.println("rejectGymRequests: " + gymId);
    }

    public void rejectGymOwnerRequests(int ownerId) {
        System.out.println("rejectGymOwnerRequests: " + ownerId);
    }

    public void removeGym(int gymId) {
        System.out.println("removeGym: " + gymId);
    }

    public void removeGymOwner(int ownerId) {
        System.out.println("removeGymOwner: " + ownerId);
    }

    public void viewAllGymOwners() {
        System.out.println("viewAllGymOwners");
    }

    public void viewGymDetails() {
        System.out.println("viewGymDetails");
    }
}
