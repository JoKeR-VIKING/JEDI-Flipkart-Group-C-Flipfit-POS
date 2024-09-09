package com.flipkart.client;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.exception.*;
import com.flipkart.utils.FlipFitTableUtil;
import com.flipkart.validators.CityInputValidator;
import com.flipkart.validators.GymOwnerValidator;
import com.flipkart.validators.SlotInputValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.utils.FlipFitClientUtils.getChoice;
import static com.flipkart.utils.Helper.*;

/**
 * Provides the menu and functionality for gym owners to manage gyms, slots, and profile information.
 */
public class FlipFitGymOwnerClientMenu {
    public static final int TOTAL_OPTIONS = 13;

    private Scanner scanner = new Scanner(System.in);
    private FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();

    /**
     * Displays the menu options available to the gym owner.
     */
    public static void displayOptions() {
        System.out.println();

        yellowOutputLn("1. Add Gym");
        yellowOutputLn("2. Edit Gym");
        yellowOutputLn("3. Remove Gym");
        yellowOutputLn("4. View Gyms");
        yellowOutputLn("5. View Gyms by City");

        yellowOutputLn("6. Add new Slot");
        yellowOutputLn("7. Remove Slot");
        yellowOutputLn("8. Edit Slot");
        yellowOutputLn("9. View All Slots");
        yellowOutputLn("10. View All Available Slots");
        yellowOutputLn("11. View all Bookings");

        yellowOutputLn("12. Edit Profile");
        redOutputLn("13. Log Out");
    }

    /**
     * Adds a new gym to the system.
     *
     * @param userId The ID of the gym owner.
     */
    private void addGym(String userId) {
        blueOutputLn("Enter your gym details");

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();

        String gymCity;
        while (true) {
            try {
                System.out.print("Enter Gym City: ");
                gymCity = scanner.nextLine();
                CityInputValidator.validateCityName(gymCity);
                break;
            } catch (CityInputValidator e) {
                redOutputLn("Invalid City");
            }
        }

        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        ownerService.addGym(gymCity, gymName, gymAddress, userId);
    }

    /**
     * Modifies the details of an existing gym.
     *
     * @param userId The ID of the gym owner.
     */
    private void modifyGym(String userId) {
        System.out.print("Enter ID of Gym to modify: ");
        String gymId = scanner.nextLine();

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();

        String gymCity;
        while (true) {
            try {
                System.out.print("Enter Gym City: ");
                gymCity = scanner.nextLine();
                CityInputValidator.validateCityName(gymCity);
                break;
            } catch (CityInputValidator e) {
                redOutputLn("Invalid City");
            }
        }

        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        try {
            boolean isSuccessful = ownerService.modifyGym(userId, gymId, gymCity, gymName, gymAddress);
            if (isSuccessful) {
                System.out.println("Gym data modified successfully.");
            } else {
                System.out.println("Gym not found, enter correct gym id.");
            }
        } catch (UnauthorizedGymOwnerException e) {
            redOutputLn("Unauthorized access to this gym centre for this gym owner");
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Removes an existing gym from the system.
     *
     * @param ownerId The ID of the gym owner.
     */
    private void removeGym(String ownerId) {
        System.out.print("Enter ID of Gym to remove: ");
        String gymId = scanner.nextLine();

        try {
            ownerService.removeGym(ownerId, gymId);
        } catch (UnauthorizedGymOwnerException e) {
            redOutputLn("Unauthorized access to this gym centre for this gym owner");
        }
    }

    /**
     * Displays all gyms registered under the specified gym owner.
     *
     * @param userId The ID of the gym owner.
     */
    public void viewGyms(String userId) {
        List<FlipFitCentre> centres = ownerService.viewRegisteredGymCenters(userId);

        System.out.println();

        FlipFitTableUtil.printTabular(
                List.of("Gym ID", "Gym Name", "Gym City", "Gym Address", "Gym Owner ID", "Verification Status"),
                centres.stream()
                        .map(centre -> List.of(
                                centre.getCentreId(),
                                centre.getCentreName(),
                                centre.getCity(),
                                centre.getCentreAddress(),
                                centre.getGymOwnerId(),
                                centre.getVerified())
                        )
                        .toList()
        );
    }

    /**
     * Displays all gyms in a specified city registered under the specified gym owner.
     *
     * @param userId The ID of the gym owner.
     */
    public void viewGymsByCity(String userId) {
        String gymCity;
        while (true) {
            try {
                System.out.print("Enter Gym City: ");
                gymCity = scanner.nextLine();
                CityInputValidator.validateCityName(gymCity);
                break;
            } catch (CityInputValidator e) {
                redOutputLn("Invalid City");
            }
        }

        List<FlipFitCentre> centres = ownerService.getGymListByCityAndOwner(gymCity, userId);

        FlipFitTableUtil.printTabular(
                List.of("Gym ID", "Gym Name", "Gym City", "Gym Address", "Gym Owner ID", "Verification Status"),
                centres.stream()
                        .map(centre -> List.of(
                                centre.getCentreId(),
                                centre.getCentreName(),
                                centre.getCity(),
                                centre.getCentreAddress(),
                                centre.getGymOwnerId(),
                                centre.getVerified())
                        )
                        .toList()
        );
    }

    /**
     * Adds a new slot to a specified gym.
     */
    public void addSlot() {
        boldOutputLn("Enter below details to add a new slot in the Gym");

        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        String startTime;
        while (true) {
            try {
                System.out.print("Enter Start Time (HH:MM): ");
                startTime = scanner.nextLine();
                SlotInputValidator.validateTimeFormat(startTime);
                break;
            } catch (SlotInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        int noOfSeats;
        while (true) {
            try {
                System.out.print("Enter Number of Seats: ");
                noOfSeats = scanner.nextInt();
                scanner.nextLine();
                SlotInputValidator.validateSeatCapacity(noOfSeats);
                break;
            } catch (SlotInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        try {
            ownerService.addSlot(gymId, parseHourMinute(startTime), noOfSeats);
        } catch (GymSlotAlreadyExistsException e) {
            redOutputLn("Gym Slot Already Exists");
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Removes an existing slot from the system.
     */
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

    /**
     * Edits the details of an existing slot.
     */
    public void editSlot() {
        System.out.print("Enter Slot ID: ");
        String slotId = scanner.nextLine();

        String startTime;
        while (true) {
            try {
                System.out.print("Enter Start Time (HH:MM): ");
                startTime = scanner.nextLine();
                SlotInputValidator.validateTimeFormat(startTime);
                break;
            } catch (SlotInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        int noOfSeats;
        scanner.nextLine();

        while (true) {
            try {
                System.out.print("Enter Number of Seats: ");
                noOfSeats = scanner.nextInt();
                scanner.nextLine();
                SlotInputValidator.validateSeatCapacity(noOfSeats);
                break;
            } catch (SlotInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        try {
            ownerService.updateSlot(slotId, parseHourMinute(startTime), noOfSeats);
            System.out.println("Slot details updated!");
        } catch (InvalidSlotException e) {
            redOutputLn("Invalid slot Exception");
        }
    }

    /**
     * Displays all slots for a specified gym.
     */
    public void viewAllSlots() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        try {
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
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Displays all available slots for a specified gym on a given date.
     */
    public void viewAvailableSlots() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        String date;
        while (true) {
            try {
                System.out.print("Enter Date (dd-mm-yyyy): ");
                date = scanner.nextLine();
                SlotInputValidator.validateDateFormat(date);
                break;
            } catch (SlotInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        try {
            if (parseDate(date).isBefore(LocalDate.now()))
                yellowOutputLn("Note: you are viewing slots for an old date");
            greenOutputLn("Slots available are as follows:");

            List<FlipFitCenterSlot> slots = ownerService.viewAvailableSlots(gymId, parseDate(date));

            FlipFitTableUtil.printTabular(
                    List.of("Slot ID", "Slot Center ID", "Slot Start Time", "Slot Seat Limit", "Available Seats"),
                    slots.stream()
                            .map(slot -> List.of(
                                    slot.getSlotId(),
                                    slot.getCentreId(),
                                    slot.getStartTime().toString(),
                                    String.valueOf(slot.getSeatLimit()),
                                    String.valueOf(slot.getAvailableSlots()))
                            )
                            .toList()
            );
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Displays all bookings for a specified gym on a given date.
     */
    public void viewAllBookings() {
        System.out.print("Enter Gym ID: ");
        String gymId = scanner.nextLine();

        String date;
        while (true) {
            try {
                System.out.print("Enter Date (dd-mm-yyyy): ");
                date = scanner.nextLine();
                SlotInputValidator.validateDateFormat(date);
                break;
            } catch (SlotInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        try {
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
        } catch (InvalidGymException e) {
            redOutputLn("Invalid Gym ID");
        }
    }

    /**
     * Edits the profile information of the gym owner.
     *
     * @param userId The ID of the gym owner.
     */
    public void editProfile(String userId) {
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        String pan;
        while (true) {
            try {
                System.out.print("Enter PAN: ");
                pan = scanner.nextLine();

                GymOwnerValidator.validatePanCardNumber(pan);
                break;
            } catch (GymOwnerValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        String gst;
        while (true) {
            try {
                System.out.print("Enter your GST Number: ");
                gst = scanner.nextLine();

                GymOwnerValidator.validateGstNumber(pan, gst);
                break;
            } catch (GymOwnerValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        try {
            ownerService.editProfile(userId, address, gst, pan);
        } catch (InvalidUserException e) {
            redOutputLn("Invalid user");
        }
    }

    /**
     * Logs out the gym owner from the system.
     */
    public void userLogout() {
        redOutputLn("Logged out");
    }

    /**
     * Handles the login process and displays the menu options to the gym owner.
     *
     * @param userId The ID of the gym owner.
     */
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
                case 5 -> viewGymsByCity(userId);

                case 6 -> addSlot();
                case 7 -> removeSlot();
                case 8 -> editSlot();
                case 9 -> viewAllSlots();
                case 10 -> viewAvailableSlots();
                case 11 -> viewAllBookings();

                case 12 -> editProfile(userId);
                case 13 -> {
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
