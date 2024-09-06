package com.flipkart.client;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.enums.RoleEnum;
import com.flipkart.exception.InvalidPasswordException;
import com.flipkart.utils.FlipFitDAOUtils;

import javax.management.relation.Role;
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

    public static FlipFitUser authenticateUser(String username, String password) {
        try {
            FlipFitUser user = userService.authenticate(username, password);

            if(user == null) {
                redOutputLn("Invalid username");
                return null;
            }

            return user;
        } catch (InvalidPasswordException e) {
            redOutputLn("Invalid password");
            return null;
        }
    }

    public static void login() {
        Scanner in = new Scanner(System.in);
        boldOutputLn("\n------- LOGIN ------\n");

        System.out.print("Enter your Username: ");
        String username = in.nextLine();

        System.out.print("Enter your Password: ");
        String password = in.nextLine();

        FlipFitUser user = authenticateUser(username, password);
        if (user == null) return;

        switch (user.getRole()) {
            case GYM_OWNER -> flipFitGymOwnerClientMenu.login(user.getUserId());
            case CUSTOMER -> flipFitCustomerClientMenu.login(user.getUserId());
            case ADMIN -> flipFitAdminClientMenu.login(user.getUserId());
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

        FlipFitUser user = authenticateUser(username, oldPassword);
        if (user == null) return;

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

        userService.changePassword(user.getUserId(), newPassword);
        greenOutputLn("Password changed!");
    }

    public static void main(String[] args) {
        // TODO: remove
//        FlipFitDAOUtils.initMockData();

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
