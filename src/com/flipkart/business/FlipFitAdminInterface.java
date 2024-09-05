package com.flipkart.business;

public interface FlipFitAdminInterface {
    public abstract void viewPendingCenter();

    public abstract void viewPendingOwner();

    public abstract void approveGymRequests(int gymId);

    public abstract void approveGymOwnerRequests(int ownerId);

    public abstract void rejectGymRequests(int gymId);

    public abstract void rejectGymOwnerRequests(int ownerId);

    public abstract void removeGym(int gymId);

    public abstract void removeGymOwner(int ownerId);

    public abstract void viewAllGymOwners();

    public abstract void viewGymDetails();
}
