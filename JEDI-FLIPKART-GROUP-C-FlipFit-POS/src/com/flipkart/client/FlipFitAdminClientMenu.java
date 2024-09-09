package com.flipkart.client;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidGymOwnerException;
import com.flipkart.utils.FlipFitTableUtil;
import com.flipkart.utils.FlipFitClientUtils;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.client.FlipFitApplicationMainClient.flipFitCustomerClientMenu;
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

        FlipFitTableUtil.printTabular(
                List.of("Centre ID", "Centre Name", "Centre Address", "Centre Owner ID"),
                centres.stream()
                        .map(center -> List.of(
                                center.getCentreId(),
                                center.getCentreName(),
                                center.getCentreAddress(),
                                center.getGymOwnerId())
                        )
                        .toList()
        );
    }

    public void viewPendingOwner() {
        List<FlipFitGymOwner> owners = adminService.displayPendingOwners();

        FlipFitTableUtil.printTabular(
                List.of("Owner ID", "Owner Name", "Owner Address", "Owner GST"),
                owners.stream()
                        .map(owner -> List.of(
                                owner.getUserId(),
                                owner.getName(),
                                owner.getAddress(),
                                owner.getGstNumber())
                        )
                        .toList()
        );
    }

    public void approveCentre(String gymId) {
        try {
            adminService.approveGym(gymId);
        } catch(InvalidGymException e){
            redOutputLn("Invalid Gym ID");
        }
    }

    public void approveOwner(String ownerId) {
        try {
            adminService.approveOwner(ownerId);
        } catch (InvalidGymOwnerException e) {
            redOutputLn("Invalid Gym Owner ID");
        }
    }

    public void rejectCentre(String gymId) {
        try {
            adminService.rejectGym(gymId);
        } catch (InvalidGymException e){
            redOutputLn("Invalid Gym Owner Id");
        }
    }

    public void rejectOwner(String ownerId) {
        try {
            adminService.rejectOwner(ownerId);
        } catch (InvalidGymOwnerException e) {
            redOutputLn("Invalid Gym Owner ID");
        }
    }

    public void removeCentre(String GymId) {
        try {
            adminService.removeGym(GymId);
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym Owner Id");
        }
    }

    public void removeOwner(String ownerId) {
        try {
            adminService.removeOwner(ownerId);
        } catch (InvalidGymOwnerException e){
            redOutputLn("Invalid gym Owner ID");
        }
    }

    public void viewAllGymOwners() {
        List<FlipFitGymOwner> allOwners = adminService.displayAllOwners();

        FlipFitTableUtil.printTabular(
                List.of("Owner ID", "Owner Name", "Owner Address", "Owner GST", "Verification Status"),
                allOwners.stream()
                        .map(owner -> List.of(
                                owner.getUserId(),
                                owner.getName(),
                                owner.getAddress(),
                                owner.getGstNumber(),
                                owner.getVerified())
                        )
                        .toList()
        );
    }

    private void viewAllGyms() {
        flipFitCustomerClientMenu.viewAllGyms();
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

            int choice = FlipFitClientUtils.getChoice(OPTIONS_SIZE);

            switch (choice) {
                case 1 -> viewPendingCentre();
                case 2 -> viewPendingOwner();
                case 3 -> approveCentre(takeGymIdInput());
                case 4 -> approveOwner(takeGymOwnerId());
                case 5 -> rejectCentre(takeGymIdInput());
                case 6 -> rejectOwner(takeGymOwnerId());
                case 7 -> viewAllGymOwners();
                case 8 -> viewAllGyms();
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