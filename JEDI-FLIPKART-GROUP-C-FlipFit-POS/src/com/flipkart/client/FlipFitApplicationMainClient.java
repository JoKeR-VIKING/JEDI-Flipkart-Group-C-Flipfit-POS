package com.flipkart.client;

import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.enums.RoleEnum;
import com.flipkart.utils.FlipFitDAOUtils;

import java.util.Scanner;

import static com.flipkart.utils.FlipfitClientUtils.getChoice;
import static com.flipkart.utils.Helper.*;

public class FlipFitApplicationMainClient {
    public static int TOTAL_OPTIONS = 4;

    static FlipFitCustomerClientMenu flipFitCustomerClientMenu = new FlipFitCustomerClientMenu();
    static FlipFitGymOwnerClientMenu flipFitGymOwnerClientMenu = new FlipFitGymOwnerClientMenu();
    static FlipFitAdminClientMenu flipFitAdminClientMenu = new FlipFitAdminClientMenu();
    static FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();
    static FlipFitCustomerService customerService = new FlipFitCustomerService();
    static FlipFitUserService userService = new FlipFitUserService();

    public static void displayOptions() {
        System.out.println();

        yellowOutputLn("1. Login");
        yellowOutputLn("2. Register");
        yellowOutputLn("3. Change Password");
        redOutputLn("4. Exit");
    }

    public static String authenticateUser(String username, String password) {
        String userId = userService.authenticate(username, password);
        if (userId.equals("-1")) {
            redOutputLn("Invalid username");
            return null;
        } else if (userId.equals("-2")) {
            redOutputLn("Invalid password");
            return null;
        }

        return userId;
    }

    public static void login() {
        Scanner in = new Scanner(System.in);
        boldOutputLn("\n------- LOGIN ------\n");

        System.out.print("Enter your Username: ");
        String username = in.nextLine();

        System.out.print("Enter your Password: ");
        String password = in.nextLine();

        System.out.println();

        yellowOutputLn("1. Gym Owner");
        yellowOutputLn("2. Customer");
        yellowOutputLn("3. Admin");

        int role = getChoice(3);

        String userId = authenticateUser(username, password);
        if (userId == null) return;

        switch (role) {
            case 1 -> flipFitGymOwnerClientMenu.login(userId);
            case 2 -> flipFitCustomerClientMenu.login(userId);
            case 3 -> flipFitAdminClientMenu.login(userId);
            default -> redOutputLn("Invalid choice");
        }
    }

    public static void registerUser() {
        Scanner in = new Scanner(System.in);

        boldOutputLn("\nWelcome to the FlipFit. Please Register yourself Here\n");
        System.out.print("Enter your Username: ");
        String username = in.nextLine();

        String password;
        boolean flag = true;
        do {
            System.out.print("Enter your password: ");
            password = in.nextLine();

            System.out.print("Enter your confirm password: ");
            String confirmUserPassword = in.nextLine();

            if (password.equals(confirmUserPassword)) {
                greenOutputLn("Password matched!");
                flag = false;
            } else {
                redOutputLn("The Passwords did not match. Please check again");
            }
        } while (flag);

        System.out.print("Enter your Name: ");
        String name = in.nextLine();

        System.out.print("Enter your Phone Number: ");
        String phoneNumber = in.nextLine();

        System.out.print("Enter your Address: ");
        String address = in.nextLine();

        System.out.println();

        yellowOutputLn("1. Register as Gym Owner");
        yellowOutputLn("2. Register as Customer");

        int role = getChoice(2);
        RoleEnum roleEnum = RoleEnum.values()[role - 1];

        switch (roleEnum) {
            case GYM_OWNER -> {
                System.out.print("Enter your GST Number: ");
                String ownerGstNum = in.nextLine();

                System.out.print("Enter your PAN Number: ");
                String ownerPanNum = in.nextLine();

                ownerService.createProfile(username, password, name, address, phoneNumber, ownerGstNum, ownerPanNum);

                login();
            }
            case CUSTOMER -> {
                System.out.print("Enter your Age: ");
                int age = in.nextInt();
                in.nextLine();

                System.out.print("Enter your Gender: ");
                String gender = in.nextLine();

                System.out.print("Enter your Weight: ");
                Double weight = in.nextDouble();
                in.nextLine();

                System.out.print("Enter your DOB: ");
                String dob = in.nextLine();

                customerService.createProfile(
                        username, password, name, address, phoneNumber, weight, age, gender, parseDate(dob));

                login();
            }
        }
    }

    public static void changePassword() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your Username: ");
        String username = in.nextLine();

        System.out.print("Enter your old password: ");
        String oldPassword = in.nextLine();

        String userId = authenticateUser(username, oldPassword);
        if (userId == null) return;

        boolean flag = true;
        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();

        do {
            System.out.print("Confirm new password: ");
            String confirmNewPassword = in.nextLine();

            if (newPassword.equals(confirmNewPassword)) {
                greenOutputLn("Password matched!");
                flag = false;
            } else {
                redOutputLn("The Passwords did not match. Please check again");
            }
        } while (flag);

        userService.changePassword(userId, newPassword);
        greenOutputLn("Password changed!");
    }

    public static void main(String[] args) {
        FlipFitDAOUtils.initMockData();

        boldOutputLn("\n-------- Welcome to FlipFit Application --------");

        while (true) {
            displayOptions();

            switch (getChoice(TOTAL_OPTIONS)) {
                case 1 -> login();
                case 2 -> registerUser();
                case 3 -> changePassword();
                case 4 -> {
                    greenOutputLn("Thank you for using FlipFit App");
                    return;
                }
                default -> {
                    redOutputLn("Invalid choice");
                    return;
                }
            }
        }
    }
}
