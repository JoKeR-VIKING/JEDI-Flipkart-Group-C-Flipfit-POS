package com.flipkart.client;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitSlotBookingService;
import com.flipkart.utils.FlipfitClientUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.flipkart.utils.FlipfitClientUtils.getChoice;

public class FlipfitCustomerClientMenu {
    Scanner in = new Scanner(System.in);
    FlipFitCustomerService customerService = new FlipFitCustomerService();
    FlipFitSlotBookingService bookingService = new FlipFitSlotBookingService();

    private static void displayOptions() {
        System.out.println("1. Edit your Profile");
        System.out.println("2. View all Gyms");
        System.out.println("3. View available Slots");
        System.out.println("4. Book your slot");
        System.out.println("5. View your bookings");
        System.out.println("6. Cancel your bookings");
        System.out.println("7. Exit");
    }

    private void editProfile(int userId) {
        String temp = in.nextLine();
        System.out.print("Enter your name: ");

        String name = in.nextLine();
        System.out.print("Enter your phone number: ");

        String phoneNumber = in.nextLine();
        System.out.print("Enter your address: ");

        String address = in.nextLine();

        customerService.editProfile(String.valueOf(userId), name, phoneNumber, address);
    }

    private void viewAllGyms() {
        List<FlipFitCentre> gyms = customerService.viewGyms();
        for (FlipFitCentre gym : gyms) {
            System.out.println("Gym Id: " + gym.getCentreId());
            System.out.println("Gym: " + gym.getCentreName());
            // TODO
//            System.out.println("Location: " + gym.get());
        }
        System.out.println("All gyms viewed");
    }

    private void viewBookedSlots(int id, FlipFitCustomerService customerService) {
        List<FlipFitCenterSlot> bookedSlots = customerService.getBookedSlots(id);
        for (FlipFitCenterSlot bookedSlot : bookedSlots) {

            System.out.println(bookedSlot.getId());
        }
    }

    private void viewAvailableSlots() {
        System.out.println("Enter the id of the gym for which you want to view the available slots");
        int gymId = in.nextInt();
        in.nextLine();
        System.out.println("Enter the date of the slot");
        String date = in.nextLine();

        HashMap<String, Integer> AvailableSlots = customerService.viewAvailableSlots(gymId, date);
        // Print the available slots
        for (Map.Entry<String, Integer> entry : AvailableSlots.entrySet()) {
            System.out.println("Slot Time: " + entry.getKey() + ", Available Slots: " + entry.getValue());
        }

        System.out.println("All slots are viewed");
    }

    private void bookSlot() {
        System.out.println("Enter gym id");
        int gymBookingId = in.nextInt();
        in.nextLine();

        System.out.println("Enter booking date");
        String bookingDate = in.nextLine();

        System.out.println("Enter booking time slot");
        String bookingTimeSlot = in.nextLine();
    }

    private void viewBookings() {
//        List<FlipfitSlotBooking> bookings = bookingService.viewBookings(userId);
//
//        if (bookings.isEmpty()) {
//            System.out.println("No bookings found for userId: " + userId);
//        } else {
//            System.out.println("Bookings for userId: " + userId);
//            for (Booking booking : bookings) {
//                System.out.println("Booking ID: " + booking.getBookingId());
//                System.out.println("Customer ID: " + booking.getCustomerId());
//                System.out.println("Gym ID: " + booking.getGymId());
//                System.out.println("Transaction ID: " + booking.getTransactionId());
//                System.out.println("Booking Date: " + booking.getBookingDate());
//                System.out.println("Booking TimeSlot: " + booking.getBookingTimeSlot());
//                System.out.println("Booking Type: " + booking.getBookingType());
//                System.out.println("Booking Amount: " + booking.getBookingAmount());
//                System.out.println("=================================");
//            }
//        }
    }

    private void cancelCustomerBooking(int id) {
        List<FlipFitCenterSlot> bookedSlots = customerService.getBookedSlots(id);

        for (FlipFitCenterSlot bookedSlot : bookedSlots) {
            System.out.println(bookedSlot.getId());
        }

        while (true) {
            System.out.println("Choose slot to delete, or 0 to go back");
            int choice = FlipfitClientUtils.getChoice(bookedSlots.size());
            if (choice == 0) return;

            customerService.cancelSlot(choice);
            System.out.println("Slot" + choice + "deleted!");
        }
    }

    private void newSlotBooking(int id, FlipFitCustomerService customerService) {
        Scanner in = new Scanner(System.in);

        System.out.println("Select city: ");
        int cityIndex = in.nextInt();

        System.out.println("Select date: ");
        int dateIndex = in.nextInt();

        System.out.println("Select slot: ");
        int slotIndex = in.nextInt();

        System.out.println("Slot booked!");
    }

    private void logoutUser() {
        System.out.println("Logged out\n");
    }

    public void login(int customerId) {
        System.out.println("Welcome to FlipFit Customer Menu Page");

        while (true) {
            displayOptions();
            int choice = getChoice(4);

            switch (choice) {
                case 1 -> editProfile(customerId);
                case 2 -> viewAllGyms();
                case 3 -> viewAvailableSlots();
                case 4 -> bookSlot();
                case 5 -> viewBookings();
                case 6 -> cancelCustomerBooking(customerId);
                case 7 -> logoutUser();
            }
        }
    }
}
