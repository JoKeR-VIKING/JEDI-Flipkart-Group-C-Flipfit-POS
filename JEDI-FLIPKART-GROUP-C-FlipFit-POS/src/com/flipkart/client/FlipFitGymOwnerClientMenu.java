package com.flipkart.client;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.utils.FlipFitTableUtil;

import java.util.*;

import static com.flipkart.utils.FlipfitClientUtils.getChoice;
import static com.flipkart.utils.Helper.*;

public class FlipFitGymOwnerClientMenu {
    public static int TOTAL_OPTIONS = 12;

    Scanner scanner = new Scanner(System.in);
    FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();

    public static void displayOptions() {
        System.out.println();

        yellowOutputLn("1. Add Gym");
        yellowOutputLn("2. Edit Gym");
        yellowOutputLn("3. Remove Gym");
        yellowOutputLn("4. View Gyms");

        yellowOutputLn("5. Add new Slot");
        yellowOutputLn("6. Remove Slot");
        yellowOutputLn("7. Edit Slot");
        yellowOutputLn("8. View All Slots");
        yellowOutputLn("9. View All Available Slots");
        yellowOutputLn("10. View all Bookings");

        yellowOutputLn("11. Edit Profile");
        redOutputLn("12. Log Out");
    }

    private void addGym(String userId) {
        blueOutputLn("Enter your gym details");

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();

        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        ownerService.addGym(gymName, gymAddress, userId);
    }

    private void modifyGym() {
        System.out.print("Enter ID of Gym to modify: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();

        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        // TODO
        // ownerService.modifyGym(gymId, gymName, gymAddress);
    }

    private void removeGym() {
        System.out.print("Enter ID of Gym to remove: ");
        String gymId = scanner.nextLine();

        ownerService.removeGym(gymId);
    }

    public void viewGyms(String userId) {
        List<FlipFitCentre> centres = ownerService.viewRegisteredGymCenters(userId);

        System.out.println();

        FlipFitTableUtil.printTabular(
                List.of("Gym ID", "Gym Name", "Gym Address"),
                centres.stream()
                        .map(centre -> List.of(centre.getGymOwnerId(),
                                centre.getCentreName(),
                                centre.getCentreAddress()))
                        .toList()
        );
    }

    public void addSlot() {
        boldOutputLn("Enter below details to add a new slot in the Gym");

        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        System.out.print("Enter Start Time (HH:MM): ");
        String startTime = scanner.nextLine();

        System.out.print("Enter Number of Seats: ");
        int noOfSeats = scanner.nextInt();
        scanner.nextLine();

        ownerService.addSlot(gymId, date, parseHourMinute(startTime), noOfSeats);
    }

    public void removeSlot() {
        boldOutputLn("Enter below details to remove slot from the Gym");

        System.out.print("Enter Slot ID: ");
        String slotId = scanner.nextLine();

        ownerService.removeSlot(slotId);
    }

    public void editSlot() {
        System.out.print("Enter Slot ID: ");
        String slotId = scanner.nextLine();

        System.out.println("Enter Details for updation");
        String details = scanner.nextLine();

        // TODO
        // ownerService.updateSlot(gymId, slotId, details);
    }

    public void viewAllSlots() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.println("Gym Slots:");

        List<FlipFitCenterSlot> slots = ownerService.viewAllSlots(gymId);

        FlipFitTableUtil.printTabular(
                List.of("Slot ID", "Slot Center ID", "Slot Start Time", "Slot Seat Limit"),
                slots.stream()
                        .map(slot -> List.of(slot.getSlotId(),
                                slot.getCentreId(),
                                slot.getStartTime().toString(),
                                String.valueOf(slot.getSeatLimit())))
                        .toList()
        );
    }

    public void viewAvailableSlots() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        greenOutputLn("Slots available are as follows:");

        // TODO
        // ownerService.viewAllAvailableSlots(gymId, date);
    }

    public void viewAllBookings() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        greenOutputLn("Slots available are as follows:");

        // TODO
        // ownerService.viewAllBookedSlots();
    }

    public void editProfile(String userId) {
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter GST: ");
        String gst = scanner.nextLine();

        System.out.print("Enter PAN: ");
        String pan = scanner.nextLine();

        ownerService.editProfile(userId, address, gst, pan);
    }

    public void userLogout() {
        redOutputLn("Logged out");
    }

    public void login(String userId) {
        boldOutputLn("\nWelcome to FlipFit Owner Menu Page");

        while (true) {
            displayOptions();

            int choice = getChoice(TOTAL_OPTIONS);
            switch (choice) {
                case 1 -> addGym(userId);
                case 2 -> modifyGym();
                case 3 -> removeGym();
                case 4 -> viewGyms(userId);

                case 5 -> addSlot();
                case 6 -> removeSlot();
                case 7 -> editSlot();
                case 8 -> viewAllSlots();
                case 9 -> viewAvailableSlots();
                case 10 -> viewAllBookings();

                case 11 -> editProfile(userId);
                case 12 -> {
                    userLogout();
                    return;
                }

                default -> {
                    System.out.println("Invalid choice");
                    return;
                }
            }
        }
    }
}