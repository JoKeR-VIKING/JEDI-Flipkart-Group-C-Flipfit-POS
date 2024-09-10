package com.flipkart.client;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.exception.GymSlotSeatLimitReachedException;
import com.flipkart.exception.InvalidBookingException;
import com.flipkart.exception.InvalidSlotException;
import com.flipkart.exception.InvalidUserException;
import com.flipkart.validators.BookSlotInputValidator;
import com.flipkart.validators.CityInputValidator;
import com.flipkart.validators.CustomerInputValidator;
import com.flipkart.validators.PaymentInputValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.flipkart.client.FlipFitApplicationMainClient.flipFitGymOwnerClientMenu;
import static com.flipkart.constants.CityConstants.CITY_LIST;
import static com.flipkart.utils.FlipFitClientUtils.getChoice;
import static com.flipkart.utils.FlipFitTableUtil.printTabular;
import static com.flipkart.utils.Helper.*;

/**
 * Provides the customer menu functionalities for the FlipFit application.
 * This class allows customers to edit their profile, view gyms, book slots, view and cancel bookings.
 */
public class FlipFitCustomerClientMenu {
    private static final int OPTIONS_SIZE = 9;

    private final Scanner in = new Scanner(System.in);
    private final FlipFitCustomerService customerService = new FlipFitCustomerService();
    private final FlipFitSlotBookingService bookingService = new FlipFitSlotBookingService();
    private final FlipFitAdminService adminService = new FlipFitAdminService();
    private final FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();
    private final FlipFitPaymentsService paymentService = new FlipFitPaymentsService();

    /**
     * Displays the options available in the customer menu.
     */
    private static void displayOptions() {
        System.out.println();
        yellowOutputLn("1. View City List");
        yellowOutputLn("2. View Gym Centres by City");
        yellowOutputLn("3. Edit your Profile");
        yellowOutputLn("4. View all Gyms");
        yellowOutputLn("5. View available Slots");
        yellowOutputLn("6. Book your slot");
        yellowOutputLn("7. View your bookings");
        yellowOutputLn("8. Cancel your bookings");
        redOutputLn("9. Exit");
    }

    /**
     * Displays the list of cities.
     */
    private void viewCityList() {
        printTabular(List.of("City"), CITY_LIST.stream().map(List::of).toList());
    }

    /**
     * Displays gym centres in a specified city.
     * Prompts the user to enter a city name and validates it.
     */
    public void viewCentresByCity() {
        String gymCity;
        while(true) {
            try {
                System.out.print("Enter Gym City: ");
                gymCity = in.nextLine();
                CityInputValidator.validateCityName(gymCity);
                break;
            } catch (CityInputValidator e) {
                redOutputLn("Invalid City");
            }
        }

        List<FlipFitCentre> gyms = customerService.getCentreListByCity(gymCity);

        printTabular(
                List.of("Gym ID", "Gym Name", "Gym City", "Gym Address", "Gym Owner ID", "Gym Verified Status"),
                gyms.stream()
                        .map(gym -> List.of(
                                gym.getCentreId(),
                                gym.getCentreName(),
                                gym.getCity(),
                                gym.getCentreAddress(),
                                gym.getGymOwnerId(),
                                gym.getVerified())
                        )
                        .toList()
        );
    }

    /**
     * Allows the customer to edit their profile information.
     *
     * @param userId the ID of the customer whose profile is to be edited
     */
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

        try {
            customerService.editProfile(userId, address, weight, age, gender, parseDate(dob));
        } catch (InvalidUserException e) {
            redOutputLn("Invalid User");
        }
    }

    /**
     * Displays a list of all gyms available in the system.
     */
    public void viewAllGyms() {
        List<FlipFitCentre> gyms = adminService.displayAllRegisteredCentres();

        printTabular(
                List.of("Gym ID", "Gym Name", "Gym City", "Gym Address", "Gym Owner ID", "Gym Verified Status"),
                gyms.stream()
                        .map(gym -> List.of(
                                gym.getCentreId(),
                                gym.getCentreName(),
                                gym.getCity(),
                                gym.getCentreAddress(),
                                gym.getGymOwnerId(),
                                gym.getVerified())
                        )
                        .toList()
        );

        greenOutputLn("All gyms viewed");
    }

    /**
     * Displays available slots for gyms.
     * This method calls the corresponding method from the `flipFitGymOwnerClientMenu`.
     */
    private void viewAvailableSlots() {
        flipFitGymOwnerClientMenu.viewAvailableSlots();
        greenOutputLn("All slots are viewed");
    }

    /**
     * Allows the customer to book a gym slot.
     *
     * @param userId the ID of the customer making the booking
     */
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

        FlipFitCenterSlot slot = ownerService.getSlot(slotId);

        if (slot == null) {
            System.out.println("Slot is full/doesn't exist");
            return;
        }

        // Make payment
        System.out.print("Please proceed with payment of Rs.500: (y/n): ");
        String acceptPayment = in.nextLine();

        if(!acceptPayment.equals("y")) {
            redOutputLn("Booking process cancelled");
            return;
        }

        String cardNumber;
        while(true) {
            try {
                System.out.print("Enter Card Number: ");
                cardNumber = in.nextLine();
                PaymentInputValidator.validateCardNumber(cardNumber);
                break;
            } catch (PaymentInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        String cvv;
        while(true) {
            try {
                System.out.print("Enter Card CVV: ");
                cvv = in.nextLine();
                PaymentInputValidator.validateCVV(cvv);
                break;
            } catch (PaymentInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        String cardExpiry;
        while(true) {
            try {
                System.out.print("Enter Card Expiry Date (MM/yy): ");
                cardExpiry = in.nextLine();
                PaymentInputValidator.isValidExpiryDate(cardExpiry);
                break;
            } catch (PaymentInputValidator e) {
                redOutputLn(e.getMessage());
            }
        }

        FlipFitPayments payment = paymentService.makePayment(userId, 500.00, cardNumber, cvv, parseYearMonth(cardExpiry), LocalDate.now());

        try {
            bookingService.bookSlot(userId, parseDate(bookingDate), slot, payment.getPaymentId());
            greenOutputLn("Payment successful, slot booked!");
        } catch (InvalidSlotException e) {
            redOutputLn("Invalid booking slot");
        } catch (GymSlotSeatLimitReachedException e) {
            redOutputLn("Gym Slot Seat Limit reached");
        }
    }

    /**
     * Displays a list of bookings made by the customer.
     *
     * @param userId the ID of the customer whose bookings are to be viewed
     */
    private void viewBookings(String userId) {
        List<FlipFitSlotBooking> bookings = bookingService.listBookings(userId);

        if (bookings.isEmpty()) {
            redOutputLn("No bookings found for userId: " + userId);
        } else {
            System.out.println("Bookings for userId: " + userId);

            printTabular(
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

    /**
     * Allows the customer to cancel a booking.
     *
     * @param userId the ID of the customer whose booking is to be canceled
     */
    private void cancelCustomerBooking(String userId) {
        List<FlipFitSlotBooking> bookedSlots = bookingService.listBookings(userId);

        printTabular(
                List.of("Booking ID", "Customer ID", "Gym Slot ID", "Booking Date", "Booking TimeSlot", "Payment ID"),
                bookedSlots.stream()
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

        while (true) {
            System.out.print("Choose slot to delete, or 0 to go back: ");
            String bookingId = in.nextLine();
            if (bookingId.equals("0")) return;

            try {
                bookingService.cancelBooking(bookingId);
                greenOutputLn("Booking with ID: " + bookingId + " cancelled!");
            } catch (InvalidBookingException e) {
                redOutputLn("Invalid booking");
            }
        }
    }

    /**
     * Logs out the customer from the application.
     */
    private void logoutUser() {
        redOutputLn("Logged out\n");
    }

    /**
     * Displays the customer menu and processes user choices.
     *
     * @param customerId the ID of the customer using the menu
     */
    public void login(String customerId) {
        blueOutput("\nWelcome to FlipFit Customer Menu Page");

        while (true) {
            displayOptions();
            int choice = getChoice(OPTIONS_SIZE);

            switch (choice) {
                case 1 -> viewCityList();
                case 2 -> viewCentresByCity();
                case 3 -> editProfile(customerId);
                case 4 -> viewAllGyms();
                case 5 -> viewAvailableSlots();
                case 6 -> bookSlot(customerId);
                case 7 -> viewBookings(customerId);
                case 8 -> cancelCustomerBooking(customerId);
                case 9 -> {
                    logoutUser();
                    return;
                }
                default -> redOutputLn("Invalid choice");
            }
        }
    }
}
