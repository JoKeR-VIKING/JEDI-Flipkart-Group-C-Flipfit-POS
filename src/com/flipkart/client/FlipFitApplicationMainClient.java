package com.flipkart.client;

import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.enums.RoleEnum;

import java.util.Scanner;

import static com.flipkart.utils.FlipfitClientUtils.getChoice;

public class FlipFitApplicationMainClient {
    public static int TOTAL_OPTIONS = 5;

    static FlipfitCustomerClientMenu flipFitCustomerClientMenu = new FlipfitCustomerClientMenu();
    static FlipFitGymOwnerClientMenu flipFitGymOwnerClientMenu = new FlipFitGymOwnerClientMenu();
    static FlipfitAdminClientMenu flipFitAdminClientMenu = new FlipfitAdminClientMenu();
    static FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();
    static FlipFitCustomerService customerService =new FlipFitCustomerService();

    public static void displayOptions() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Register as Customer");
        System.out.println("4. Register as Gym Owner");
        System.out.println("5. Exit");
    }

    public static void login() {
        Scanner in = new Scanner(System.in);
        System.out.println("------- LOGIN ------");

        System.out.print("Enter your Username: ");
        String email = in.next();

        System.out.println("Enter your Password: ");
        String password = in.next();

        System.out.println("1. Gym Owner");
        System.out.println("2. Customer");
        System.out.println("3. Admin");

        System.out.print("Logging as: ");
        int role = in.nextInt();

        System.out.println("Enter your ID: ");
        int userId = in.nextInt();

        switch (role) {
            case 1 -> flipFitGymOwnerClientMenu.login(userId);
            case 2 -> flipFitCustomerClientMenu.login(userId);
            case 3 -> flipFitAdminClientMenu.login(userId);
            default -> System.out.println("Invalid role choice");
        }
    }

    public static void registerUser() {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the FlipFit. Please Register yourself Here");
        System.out.print("Enter your Username: ");
        String username = in.next();

        String password;
        boolean flag = true;
        do {
            System.out.print("Enter your password: ");
            password = in.next();

            System.out.print("Enter your confirm password: ");
            String confirmUserPassword = in.next();

            if (password.equals(confirmUserPassword)) {
                System.out.print("Password matched!");
                flag = false;
            } else {
                System.out.println("The Passwords did not match. Please check again");
            }
        } while (flag);

        System.out.println("Enter your Name: ");
        String name = in.next();

        System.out.println("Enter your Phone Number: ");
        String phoneNumber = in.next();

        System.out.println("Enter your Address: ");
        String address = in.next();

        System.out.println("1. Register as Gym Owner");
        System.out.println("2. Register as Customer");
        System.out.println("3. Register as Admin");

        int role = in.nextInt();
        RoleEnum roleEnum = RoleEnum.values()[role-1];

        switch (roleEnum) {
            case GYM_OWNER -> {
                System.out.println("Enter your GST Number: ");
                String ownerGstNum = in.nextLine();
                System.out.println("Enter your PAN Number: ");
                String ownerPanNum = in.nextLine();

                login();
            }
            case CUSTOMER -> {
                System.out.println("Enter your Age: ");
                int age = in.nextInt();

                System.out.println("Enter your Gender: ");
                String gender = in.nextLine();

                System.out.println("Enter your Weight: ");
                int weight = in.nextInt();

                System.out.println("Enter your address: ");
                String customerAddress = in.nextLine();

                login();
            }
            case ADMIN -> login();
        }
    }

    public static void changePassword() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your Username: ");
        String email = in.next();

        System.out.print("Enter your old password: ");
        String oldPassword = in.next();

        System.out.print("Enter your id: ");
        int userId = in.nextInt();

        boolean flag = true;
        System.out.println("Enter new password: ");
        String newPassword = in.next();

        do {
            System.out.println("Confirm new password: ");
            String confirmNewPassword = in.next();
            if (newPassword.equals(confirmNewPassword)) {
                System.out.println("Password matched!");
                flag = false;
            } else {
                System.out.println("The Passwords did not match. Please check again");
            }
        } while (flag);

        customerService.editProfile(userId, newPassword);
    }

    public static void main(String[] args) {
        System.out.println("-------- Welcome to FlipFit Application --------");
        displayOptions();

        while (true) {
            switch (getChoice(TOTAL_OPTIONS)) {
                case 1 -> login();
                case 2 -> registerUser();
                case 3 -> changePassword();
                case 4 -> {
                    System.out.println("Thank you for using FlipFit App");
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
