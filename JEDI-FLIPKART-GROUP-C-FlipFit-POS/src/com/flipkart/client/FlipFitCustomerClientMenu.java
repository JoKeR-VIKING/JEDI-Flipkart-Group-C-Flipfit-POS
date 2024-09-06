package com.flipkart.client;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.business.*;
import com.flipkart.utils.Helper;
import com.flipkart.utils.FlipFitTableUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import static com.flipkart.dao.FlipFitGymOwnerDAO.FlipFitGymOwnerDAOInst;
import static com.flipkart.utils.FlipfitClientUtils.getChoice;
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
        System.out.print("Enter your name: ");
        String name = in.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = in.nextLine();

        System.out.print("Enter your address: ");
        String address = in.nextLine();

        System.out.print("Enter your Age: ");
        int age = in.nextInt();
        in.nextLine();

        System.out.print("Enter your Gender: ");
        String gender = in.nextLine();

        System.out.print("Enter your Weight: ");
        Double weight = in.nextDouble(); in.nextLine();

        System.out.print("Enter your DOB (dd-mm-yyyy): ");
        String dob = in.nextLine();

        customerService.editProfile(userId, address, name, phoneNumber, weight, age, gender, parseDate(dob));
    }

    private void viewAllGyms() {
        List<FlipFitCentre> gyms = adminService.displayAllCentres();

        FlipFitTableUtil.printTabular(
                List.of("Gym ID", "Gym Name", "Gym Address"),
                gyms.stream()
                        .map(gym -> List.of(gym.getCentreId(),
                                gym.getCentreName(),
                                gym.getCentreAddress())
                        )
                        .toList()
        );

        greenOutputLn("All gyms viewed");
    }

    private void viewAvailableSlots() {
        System.out.print("Enter the id of the gym for which you want to view the available slots: ");
        String gymId = in.nextLine();

        System.out.print("Enter the date of the slot: ");
        String date = in.nextLine();

        List<FlipFitCenterSlot> slots = ownerService.viewAvailableSlots(gymId, parseDate(date));
        for (FlipFitCenterSlot slot : slots) {
            System.out.println();
            System.out.println("Slot ID: " + slot.getSlotId());
            System.out.println("Slot Center ID: " + slot.getCentreId());
            System.out.println("Slot Start Time: " + slot.getStartTime());
            System.out.println("Slot Seat Limit: " + slot.getSeatLimit());
        }

        greenOutputLn("All slots are viewed");
    }

    private void bookSlot(String userId) {
        System.out.print("Enter Booking Date (dd-mm-yyyy): ");
        String bookingDate = in.nextLine();

        System.out.print("Enter slot ID: ");
        String slotId = in.nextLine();

        // get slot if exists
        FlipFitCenterSlot slot = ownerService.getSlot(slotId);

        if(slot == null) {
            System.out.println("slot is full/doesn't exist");
            return;
        }

        // make payment
        System.out.print("Make payment of Rs.500: ");
        Double paymentAmount = in.nextDouble();

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
            for (FlipFitSlotBooking booking : bookings) {
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("Customer ID: " + booking.getUserId());
                System.out.println("Gym ID: " + booking.getCenterSlot());
                System.out.println("Booking Date: " + booking.getBookingDate());
                System.out.println("Booking TimeSlot: " + booking.getSlotDate());
                System.out.println("=================================");
            }
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
