package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.utils.FlipFitTableUtil;
import com.flipkart.utils.Helper;
import com.flipkart.validators.BookSlotInputValidator;
import com.flipkart.validators.CustomerInputValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.client.FlipFitApplicationMainClient.flipFitGymOwnerClientMenu;
import static com.flipkart.utils.FlipFitClientUtils.getChoice;
import static com.flipkart.utils.Helper.*;

public class FlipFitCustomerClientMenu {
    static int OPTIONS_SIZE = 7;

    Scanner in = new Scanner(System.in);
    FlipFitCustomerService customerService = new FlipFitCustomerService();
    FlipFitSlotBookingService bookingService = new FlipFitSlotBookingService();
    FlipFitAdminService adminService = new FlipFitAdminService();
    FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();
    FlipFitPaymentsService paymentService = new FlipFitPaymentsService();

    private static void displayOptions() {
        System.out.println();

        yellowOutputLn("1. Edit your Profile");
        yellowOutputLn("2. View all Gyms");
        yellowOutputLn("3. View available Slots");
        yellowOutputLn("4. Book your slot");
        yellowOutputLn("5. View your bookings");
        yellowOutputLn("6. Cancel your bookings");
        redOutputLn("7. Exit");
    }

    private void editProfile(String userId) {
        System.out.print("Enter your address: ");
        String address = in.nextLine();

        int age;

        while (true) {
            try {
                System.out.print("Enter your Age: ");
                age = in.nextInt();
                in.nextLine();

                CustomerInputValidator.validateAge(age);
                break;
            } catch (CustomerInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        String gender;

        while (true) {
            try {
                System.out.print("Enter your Gender: ");
                gender = in.nextLine();

                CustomerInputValidator.validateGender(gender);
                break;
            } catch (CustomerInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        double weight;

        while (true) {
            try {
                System.out.print("Enter your Weight: ");
                weight = in.nextDouble();
                in.nextLine();

                CustomerInputValidator.validateWeight(weight);
                break;
            } catch (CustomerInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        String dob;

        while (true) {
            try {
                System.out.print("Enter your DOB (dd-mm-yyyy): ");
                dob = in.nextLine();

                CustomerInputValidator.validateDob(dob, age);
                break;
            } catch (CustomerInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        customerService.editProfile(userId, address, weight, age, gender, parseDate(dob));
    }

    public void viewAllGyms() {
        List<FlipFitCentre> gyms = adminService.displayAllCentres();

        FlipFitTableUtil.printTabular(
                List.of("Gym ID", "Gym Name", "Gym Address", "Gym Owner ID", "Gym Verified Status"),
                gyms.stream()
                        .map(gym -> List.of(
                                gym.getCentreId(),
                                gym.getCentreName(),
                                gym.getCentreAddress(),
                                gym.getGymOwnerId(),
                                gym.getVerified())
                        )
                        .toList()
        );

        greenOutputLn("All gyms viewed");
    }

    private void viewAvailableSlots() {
        flipFitGymOwnerClientMenu.viewAvailableSlots();

        greenOutputLn("All slots are viewed");
    }

    private void bookSlot(String userId) {
        String bookingDate;
        while (true) {
            try {
                System.out.print("Enter Booking Date (dd-mm-yyyy): ");
                bookingDate = in.nextLine();
                BookSlotInputValidator.validateDateFormat(bookingDate);
                BookSlotInputValidator.validateFutureDate(bookingDate);
                break;
            } catch (BookSlotInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        System.out.print("Enter slot ID: ");
        String slotId = in.nextLine();

        // get slot if exists
        FlipFitCenterSlot slot = ownerService.getSlot(slotId);

        if (slot == null) {
            System.out.println("slot is full/doesn't exist");
            return;
        }

        // make payment
        System.out.print("Make payment of Rs.500: ");
        Double paymentAmount = in.nextDouble();
        in.nextLine();

        FlipFitPayments payment = paymentService.makePayment(Helper.generateId(), userId, 500.00, paymentAmount, LocalDate.now());

        bookingService.bookSlot(userId, parseDate(bookingDate), slot, payment.getPaymentId());
        System.out.println("Payment successful, slot booked!");
    }

    private void viewBookings(String userId) {
        List<FlipFitSlotBooking> bookings = bookingService.listBookings(userId);

        if (bookings.isEmpty()) {
            redOutputLn("No bookings found for userId: " + userId);
        } else {
            System.out.println("Bookings for userId: " + userId);

            FlipFitTableUtil.printTabular(
                    List.of("Booking ID", "Customer ID", "Gym Slot ID", "Booking Date", "Booking TimeSlot", "Payment ID"),
                    bookings.stream()
                            .map(booking -> List.of(
                                    booking.getBookingId(),
                                    booking.getUserId(),
                                    booking.getCenterSlot(),
                                    booking.getBookingDate().toString(),
                                    booking.getSlotDate().toString(),
                                    booking.getPaymentId())
                            )
                            .toList()
            );
        }
    }

    private void cancelCustomerBooking(String userId) {
        List<FlipFitSlotBooking> bookedSlots = bookingService.listBookings(userId);

        for (FlipFitSlotBooking bookedSlot : bookedSlots) {
            System.out.println(bookedSlot.getBookingId());
        }

        while (true) {
            System.out.print("Choose slot to delete, or 0 to go back: ");
            String bookingId = in.nextLine();
            if (bookingId.equals("0")) return;

            bookingService.cancelBooking(bookingId);
            greenOutputLn("Booking with ID: " + bookingId + " cancelled!");
        }
    }

    private void logoutUser() {
        redOutputLn("Logged out\n");
    }

    public void login(String customerId) {
        blueOutput("\nWelcome to FlipFit Customer Menu Page");

        while (true) {
            displayOptions();
            int choice = getChoice(OPTIONS_SIZE);

            switch (choice) {
                case 1 -> editProfile(customerId);
                case 2 -> viewAllGyms();
                case 3 -> viewAvailableSlots();
                case 4 -> bookSlot(customerId);
                case 5 -> viewBookings(customerId);
                case 6 -> cancelCustomerBooking(customerId);
                case 7 -> {
                    logoutUser();
                    return;
                }
            }
        }
    }
}
