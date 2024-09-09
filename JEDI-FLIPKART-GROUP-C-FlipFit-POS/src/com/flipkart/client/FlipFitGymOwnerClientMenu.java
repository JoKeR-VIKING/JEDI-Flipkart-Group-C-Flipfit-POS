package com.flipkart.client;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.exception.GymSlotAlreadyExistsException;
import com.flipkart.exception.InvalidSlotException;
import com.flipkart.exception.UnauthorizedGymOwnerException;
import com.flipkart.utils.FlipFitTableUtil;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.utils.FlipFitClientUtils.getChoice;
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

    private void modifyGym(String userId) {
        System.out.print("Enter ID of Gym to modify: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();

        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        try {
            boolean isSuccessful = ownerService.modifyGym(userId, gymId, gymName, gymAddress);
            if (isSuccessful) {
                System.out.println("Gym data modified successfully.");
            } else {
                System.out.println("Gym not found, enter correct gym id.");
            }
        } catch (UnauthorizedGymOwnerException e){
            redOutputLn("Unauthorized access to this gym centre for this gym owner");
        }
    }

    private void removeGym(String ownerId) {
        System.out.print("Enter ID of Gym to remove: ");
        String gymId = scanner.nextLine();

        try {
            ownerService.removeGym(ownerId, gymId);
        } catch (UnauthorizedGymOwnerException e){
            redOutputLn("Unauthorized access to this gym centre for this gym owner");
        }
    }

    public void viewGyms(String userId) {
        List<FlipFitCentre> centres = ownerService.viewRegisteredGymCenters(userId);

        System.out.println();

        FlipFitTableUtil.printTabular(
                List.of("Gym ID", "Gym Name", "Gym Address", "Gym Owner ID", "Verification Status"),
                centres.stream()
                        .map(centre -> List.of(
                                centre.getCentreId(),
                                centre.getCentreName(),
                                centre.getCentreAddress(),
                                centre.getGymOwnerId(),
                                centre.getVerified())
                        )
                        .toList()
        );
    }

    public void addSlot() {
        boldOutputLn("Enter below details to add a new slot in the Gym");

        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Start Time (HH:MM): ");
        String startTime = scanner.nextLine();

        System.out.print("Enter Number of Seats: ");
        int noOfSeats = scanner.nextInt();
        scanner.nextLine();

        try {
            ownerService.addSlot(gymId, parseHourMinute(startTime), noOfSeats);
        } catch (GymSlotAlreadyExistsException e) {
            redOutputLn("Gym Slot Already Exists");
        }
    }

    public void removeSlot() {
        boldOutputLn("Enter below details to remove slot from the Gym");

        System.out.print("Enter Slot ID: ");
        String slotId = scanner.nextLine();
        try {
            ownerService.removeSlot(slotId);
        } catch (InvalidSlotException e) {
            redOutputLn("Invalid slot");
        }

    }

    public void editSlot() {
        System.out.print("Enter Slot ID: ");
        String slotId = scanner.nextLine();

        System.out.print("Enter start time: ");
        String startTime = scanner.nextLine();

        System.out.print("Enter no of seats: ");
        int noOfSeats = scanner.nextInt();
        scanner.nextLine();

        try {
            ownerService.updateSlot(slotId, parseHourMinute(startTime), noOfSeats);
            System.out.println("Slot details updated!");
        } catch (InvalidSlotException e) {
            redOutputLn("Invalid slot Exception");
        }
    }

    public void viewAllSlots() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.println("Gym Slots: ");

        List<FlipFitCenterSlot> slots = ownerService.viewAllSlots(gymId);

        FlipFitTableUtil.printTabular(
                List.of("Slot ID", "Slot Center ID", "Slot Start Time", "Slot Seat Limit"),
                slots.stream()
                        .map(slot -> List.of(
                                slot.getSlotId(),
                                slot.getCentreId(),
                                slot.getStartTime().toString(),
                                String.valueOf(slot.getSeatLimit()))
                        )
                        .toList()
        );
    }

    public void viewAvailableSlots() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        greenOutputLn("Slots available are as follows:");

        List<FlipFitCenterSlot> slots = ownerService.viewAvailableSlots(gymId, parseDate(date));

        FlipFitTableUtil.printTabular(
                List.of("Slot ID", "Slot Center ID", "Slot Start Time", "Slot Seat Limit"),
                slots.stream()
                        .map(slot -> List.of(
                                slot.getSlotId(),
                                slot.getCentreId(),
                                slot.getStartTime().toString(),
                                String.valueOf(slot.getSeatLimit()))
                        )
                        .toList()
        );
    }

    //TODO: wrong?
    public void viewAllBookings() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        greenOutputLn("Slot Bookings are as follows:");

        List<FlipFitSlotBooking> bookings = ownerService.viewAllBookingsByGymIdAndDate(gymId, parseDate(date));

        FlipFitTableUtil.printTabular(
                List.of("Booking ID", "User ID", "Center Slot ID", "Slot Date", "Booked on", "Payment ID", "Status"),
                bookings.stream()
                        .map(booking -> List.of(
                                booking.getBookingId(),
                                booking.getUserId(),
                                booking.getCenterSlot(),
                                booking.getSlotDate().toString(),
                                booking.getBookingDate().toString(),
                                booking.getPaymentId(),
                                booking.getStatus().name())
                        )
                        .toList()
        );
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
                case 2 -> modifyGym(userId);
                case 3 -> removeGym(userId);
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