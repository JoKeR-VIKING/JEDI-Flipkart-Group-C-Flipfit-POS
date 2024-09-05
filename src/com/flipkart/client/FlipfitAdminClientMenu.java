package com.flipkart.client;

import com.flipkart.business.FlipFitAdminService;
import com.flipkart.utils.FlipfitClientUtils;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.utils.FlipfitClientUtils.getOptionsWithId;

public class FlipfitAdminClientMenu {

    private static final List<String> OPTION_LIST = List.of(
            "View all Pending Gym Centre requests",
            "View all Pending Gym Owner requests",
            "Approve Gym Centre request",
            "Approve Gym Owner request",
            "Reject Gym Centre request",
            "Reject Gym Owner request",
            "View all Gym Owners",
            "View all Gym Centres",
            "Remove Gym Centre",
            "Remove Gym Owner",
            "Log Out"
    );

    private static final String OPTIONS = getOptionsWithId(OPTION_LIST);

    FlipFitAdminService adminService = new FlipFitAdminService();

    public void displayOptions() {
        System.out.println(OPTIONS);
    }

    public void viewPendingCentre() {
        adminService.viewPendingCenter();
    }

    public void viewPendingOwner() {
        adminService.viewPendingOwner();
    }

    public void approveCentre(int gymId) {
        adminService.approveGymRequests(gymId);
    }

    public void approveOwner(int ownerId) {
        adminService.approveGymOwnerRequests(ownerId);
    }

    public void rejectCentre(int gymId) {
        adminService.rejectGymRequests(gymId);
    }

    public void rejectOwner(int ownerId) {
        adminService.rejectGymOwnerRequests(ownerId);
    }

    public void removeCentre(int GymId) {
        adminService.removeGym(GymId);
    }

    public void removeOwner(int ownerId) {
        adminService.removeGymOwner(ownerId);
    }

    public void viewAllGymOwners() {
        adminService.viewAllGymOwners();
    }

    public void viewGymDetails() {
        adminService.viewGymDetails();
    }

    public void userLogout() {
        System.out.println("Logged out");
    }

    public int takeGymIdInput(Scanner in) {
        System.out.print("Select Gym Id: ");
        return in.nextInt();
    }

    public int takeGymOwnerId(Scanner in) {
        System.out.print("Select Gym Owner Id: ");
        return in.nextInt();
    }

    public void login(int userId) {
        System.out.println("-------- Welcome to FlipFit Admin Menu Page --------");

        Scanner in = new Scanner(System.in);

        while (true) {
            displayOptions();

            int choice = FlipfitClientUtils.getChoice(OPTION_LIST.size());

            switch (choice) {
                case 1 -> viewPendingCentre();
                case 2 -> viewPendingOwner();
                case 3 -> approveCentre(takeGymIdInput(in));
                case 4 -> approveOwner(takeGymOwnerId(in));
                case 5 -> rejectCentre(takeGymIdInput(in));
                case 6 -> rejectOwner(takeGymOwnerId(in));
                case 7 -> viewAllGymOwners();
                case 8 -> viewGymDetails();
                case 9 -> removeCentre(takeGymIdInput(in));
                case 10 -> removeOwner(takeGymOwnerId(in));
                case 11 -> {
                    userLogout();
                    in.close();
                    return;
                }
            }
        }
    }
}