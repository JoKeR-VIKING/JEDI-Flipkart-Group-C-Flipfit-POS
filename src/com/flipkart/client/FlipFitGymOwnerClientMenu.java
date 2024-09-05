package com.flipkart.client;

import com.flipkart.business.FlipFitGymOwnerService;

import java.util.*;

import static com.flipkart.utils.FlipfitClientUtils.getChoice;

public class FlipFitGymOwnerClientMenu {
    public static int TOTAL_OPTIONS = 12;

    Scanner scanner = new Scanner(System.in);
    FlipFitGymOwnerService flipFitGymOwnerService = new FlipFitGymOwnerService();

    public static void displayOptions() {
        System.out.println("1. Add Gym");
        System.out.println("2. Edit Gym");
        System.out.println("3. Remove Gym");
        System.out.println("4. View Gyms");

        System.out.println("5. Add new Slot");
        System.out.println("6. Remove Slot");
        System.out.println("7. Edit Slot");
        System.out.println("8. View All Slots");
        System.out.println("9. View All Available Slots");
        System.out.println("10. View all Bookings");

        System.out.println("11. Edit Profile");
        System.out.println("12. Log Out");
    }

    private void addGym(int userId) {
        System.out.println("Enter your gym details");

        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();

        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        flipFitGymOwnerService.addGym(gymId, gymName, gymAddress, String.valueOf(userId));
    }

    private void modifyGym() {
        System.out.print("Enter ID of Gym to modify: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();

        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        // TODO
        // flipFitGymOwnerService.removeGym(gymId, gymName, gymAddress);
    }

    private void removeGym() {
        System.out.print("Enter ID of Gym to remove: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();
    }

    public void viewGyms() {
        System.out.println("You are in view Registered Gym centers function\n");

        flipFitGymOwnerService.viewRegisteredGymCenters();
    }

    public void addSlot() {
        System.out.println("Enter below details to add a new slot in the Gym:");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Date (DD/MM/YYYY): ");
        String date = scanner.nextLine();

        System.out.print("Enter Start Time (HH:MM): ");
        String startTime = scanner.nextLine();

        System.out.print("Enter End Time (HH:MM): ");
        String endTime = scanner.nextLine();

        System.out.print("Enter Number of Seats: ");
        int noOfSeats = scanner.nextInt();

        flipFitGymOwnerService.addSlot(gymId, date, startTime, endTime, noOfSeats);
    }

    public void removeSlot() {
        System.out.println("Enter below details to remove slot from the Gym:");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.print("Enter Slot ID: ");
        int slotId = scanner.nextInt();

        flipFitGymOwnerService.removeSlot(gymId, slotId);
    }

    public void editSlot() {
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.print("Enter Slot ID: ");
        int slotId = scanner.nextInt();
        System.out.println("Enter Details for updation");
        String details = scanner.nextLine();

        flipFitGymOwnerService.updateSlot(gymId, slotId, details);
    }

    public void viewAllSlots() {
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Gym Slots:");

        // TODO
        flipFitGymOwnerService.viewSlots();
    }

    public void viewAvailableSlots() {
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        System.out.println("Slots available are as follows:");

        flipFitGymOwnerService.viewSlots();
    }

    public void viewAllBookings() {
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        System.out.println("Slots available are as follows:");

        flipFitGymOwnerService.viewSlots();
    }

    public void editProfile() {
        // TODO
    }

    public void userLogout() {
        System.out.println("Logged out");
    }

    public void login(int userId) {
        System.out.println("\nWelcome to FlipFit Owner Menu Page");

        while (true) {
            displayOptions();

            int choice = getChoice(TOTAL_OPTIONS);
            switch (choice) {
                case 1 -> addGym(userId);
                case 2 -> modifyGym();
                case 3 -> removeGym();
                case 4 -> viewGyms();

                case 5 -> addSlot();
                case 6 -> removeSlot();
                case 7 -> editSlot();
                case 8 -> viewAllSlots();
                case 9 -> viewAvailableSlots();
                case 10 -> viewAllBookings();

                case 11 -> editProfile();
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