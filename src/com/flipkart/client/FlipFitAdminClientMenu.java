package com.flipkart.client;

import com.flipkart.business.FlipFitAdminService;
import com.flipkart.utils.FlipfitClientUtils;

import java.util.Scanner;

import static com.flipkart.utils.Helper.*;

public class FlipFitAdminClientMenu {

    private static final int OPTIONS_SIZE = 11;

    Scanner in = new Scanner(System.in);
    FlipFitAdminService adminService = new FlipFitAdminService();

    public void displayOptions() {
        System.out.println();

        yellowOutputLn("1. View all Pending Gym Centre requests");
        yellowOutputLn("2. View all Pending Gym Owner requests");
        yellowOutputLn("3. Approve Gym Centre request");
        yellowOutputLn("4. Approve Gym Owner request");
        yellowOutputLn("5. Reject Gym Centre request");
        yellowOutputLn("6. Reject Gym Owner request");
        yellowOutputLn("7. View all Gym Owners");
        yellowOutputLn("8. View all Gym Centres");
        yellowOutputLn("9. Remove Gym Centre");
        yellowOutputLn("10. Remove Gym Owner");
        redOutputLn("11. Log Out");
    }

    public void viewPendingCentre() {
        //adminService.viewPendingCenter();
    }

    public void viewPendingOwner() {
        //adminService.viewPendingOwner();
    }

    public void approveCentre(int gymId) {
        //adminService.approveGymRequests(gymId);
    }

    public void approveOwner(int ownerId) {
        //adminService.approveGymOwnerRequests(ownerId);
    }

    public void rejectCentre(int gymId) {
        //adminService.rejectGymRequests(gymId);
    }

    public void rejectOwner(int ownerId) {
        //adminService.rejectGymOwnerRequests(ownerId);
    }

    public void removeCentre(int GymId) {
        //adminService.removeGym(GymId);
    }

    public void removeOwner(int ownerId) {
        //adminService.removeGymOwner(ownerId);
    }

    public void viewAllGymOwners() {
        //adminService.viewAllGymOwners();
    }

    public void viewGymDetails() {
        //adminService.viewGymDetails();
    }

    public void userLogout() {
        redOutputLn("Logged out");
    }

    public int takeGymIdInput() {
        System.out.print("Select Gym Id: ");
        int gymId = in.nextInt();
        in.nextLine();

        return gymId;
    }

    public int takeGymOwnerId() {
        System.out.print("Select Gym Owner Id: ");
        int userId = in.nextInt();
        in.nextLine();

        return userId;
    }

    public void login(String userId) {
        boldOutputLn("\n-------- Welcome to FlipFit Admin Menu Page --------");

        while (true) {
            displayOptions();

            int choice = FlipfitClientUtils.getChoice(OPTIONS_SIZE);

            switch (choice) {
                case 1 -> viewPendingCentre();
                case 2 -> viewPendingOwner();
                case 3 -> approveCentre(takeGymIdInput());
                case 4 -> approveOwner(takeGymOwnerId());
                case 5 -> rejectCentre(takeGymIdInput());
                case 6 -> rejectOwner(takeGymOwnerId());
                case 7 -> viewAllGymOwners();
                case 8 -> viewGymDetails();
                case 9 -> removeCentre(takeGymIdInput());
                case 10 -> removeOwner(takeGymOwnerId());
                case 11 -> {
                    userLogout();
                    return;
                }
            }
        }
    }
}