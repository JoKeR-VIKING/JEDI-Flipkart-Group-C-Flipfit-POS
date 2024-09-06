package com.flipkart.client;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.dao.FlipFitGymOwnerDAO;
import com.flipkart.utils.FlipfitClientUtils;

import java.util.List;
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
        List<FlipFitCentre> centres = adminService.displayPendingCentres();

        for (FlipFitCentre centre : centres) {
            System.out.println("Centre ID: " + centre.getCentreId());
            System.out.println("Centre Name: " + centre.getCentreName());
            System.out.println("Centre Address: " + centre.getCentreAddress());
            System.out.println("Centre Owner: " + centre.getGymOwner());
        }
    }

    public void viewPendingOwner() {
        List<FlipFitGymOwner> owners = adminService.displayPendingOwners();

        for (FlipFitGymOwner owner : owners) {
            System.out.println("Owner ID: " + owner.getUserId());
            System.out.println("Owner Name: " + owner.getName());
            System.out.println("Owner Address: " + owner.getAddress());
            System.out.println("Owner GST: " + owner.getGstNumber());
        }
    }

    public void approveCentre(String gymId) {
        adminService.approveGym(gymId);
    }

    public void approveOwner(String ownerId) {
        adminService.approveOwner(ownerId);
    }

    public void rejectCentre(String gymId) {
        adminService.rejectGym(gymId);
    }

    public void rejectOwner(String ownerId) {
        adminService.rejectOwner(ownerId);
    }

    public void removeCentre(String GymId) {
        adminService.removeGym(GymId);
    }

    public void removeOwner(String ownerId) {
        adminService.rejectOwner(ownerId);
    }

    public void viewAllGymOwners() {

        List<FlipFitGymOwner> allOwners = adminService.displayAllOwners();
        for(FlipFitGymOwner owner : allOwners) {
            System.out.println("Owner ID: " + owner.getUserId());
            System.out.println("Owner Name: " + owner.getName());
            System.out.println("Owner Address: " + owner.getAddress());
            System.out.println("Owner GST: " + owner.getGstNumber());
            System.out.println("Owner verification status: " + owner.getVerified());
        }
    }

    public void viewGymDetails() {
        adminService.viewGymDetails();
    }

    public void userLogout() {
        redOutputLn("Logged out");
    }

    public String takeGymIdInput() {
        System.out.print("Select Gym Id: ");
        return in.nextLine();
    }

    public String takeGymOwnerId() {
        System.out.print("Select Gym Owner Id: ");
        return in.nextLine();
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