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

/**
 * Client-side menu for FlipFit Admin operations.
 * This class handles user interactions for managing gym centres and gym owners,
 * including viewing, approving, rejecting, and removing records.
 */
public class FlipFitAdminClientMenu {

    private static final int OPTIONS_SIZE = 11;

    private final Scanner in = new Scanner(System.in);
    private final FlipFitAdminService adminService = new FlipFitAdminService();

    /**
     * Displays the menu options for the FlipFit Admin client.
     */
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

    /**
     * Displays a list of pending gym centre requests.
     */
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

    /**
     * Displays a list of pending gym owner requests.
     */
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

    /**
     * Approves a gym centre request.
     *
     * @param gymId the ID of the gym centre to approve
     */
    public void approveCentre(String gymId) {
        try {
            adminService.approveGym(gymId);
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Approves a gym owner request.
     *
     * @param ownerId the ID of the gym owner to approve
     */
    public void approveOwner(String ownerId) {
        try {
            adminService.approveOwner(ownerId);
        } catch (InvalidGymOwnerException e) {
            redOutputLn("Invalid Gym Owner ID");
        }
    }

    /**
     * Rejects a gym centre request.
     *
     * @param gymId the ID of the gym centre to reject
     */
    public void rejectCentre(String gymId) {
        try {
            adminService.rejectGym(gymId);
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Rejects a gym owner request.
     *
     * @param ownerId the ID of the gym owner to reject
     */
    public void rejectOwner(String ownerId) {
        try {
            adminService.rejectOwner(ownerId);
        } catch (InvalidGymOwnerException e) {
            redOutputLn("Invalid Gym Owner ID");
        }
    }

    /**
     * Removes a gym centre.
     *
     * @param gymId the ID of the gym centre to remove
     */
    public void removeCentre(String gymId) {
        try {
            adminService.removeGym(gymId);
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Removes a gym owner.
     *
     * @param ownerId the ID of the gym owner to remove
     */
    public void removeOwner(String ownerId) {
        try {
            adminService.removeOwner(ownerId);
        } catch (InvalidGymOwnerException e) {
            redOutputLn("Invalid Gym Owner ID");
        }
    }

    /**
     * Displays a list of all gym owners.
     */
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

    /**
     * Displays a list of all gym centres.
     */
    private void viewAllGyms() {
        flipFitCustomerClientMenu.viewAllGyms();
    }

    /**
     * Logs out the current user.
     */
    public void userLogout() {
        redOutputLn("Logged out");
    }

    /**
     * Prompts the user to input a gym centre ID.
     *
     * @return the entered gym centre ID
     */
    public String takeGymIdInput() {
        System.out.print("Select Gym Id: ");
        return in.nextLine();
    }

    /**
     * Prompts the user to input a gym owner ID.
     *
     * @return the entered gym owner ID
     */
    public String takeGymOwnerId() {
        System.out.print("Select Gym Owner Id: ");
        return in.nextLine();
    }

    /**
     * Starts the admin menu and handles user interactions.
     *
     * @param userId the ID of the currently logged-in user
     */
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
