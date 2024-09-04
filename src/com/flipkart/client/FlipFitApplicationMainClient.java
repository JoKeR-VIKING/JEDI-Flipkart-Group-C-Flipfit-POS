package com.flipkart.client;

import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitGymOwnerService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class FlipFitApplicationMainClient {
    public static void login() {
        Scanner in = new Scanner(System.in);
        System.out.println("------- Login ------ ");
        System.out.println("Enter your Email: ");
        String email = in.next();
        System.out.println("Enter your Password: ");
        String password = in.next();
        System.out.println("Enter your role: \n1. Gym Owner\n2. Customer\n3. Admin");
        int role = in.nextInt();

        System.out.println("Enter your id: ");
        int userId = in.nextInt();

        if(userId<=0) return;
        if(role == 1) {
            FlipFitGymOwnerClientMenu flipFitGymOwnerClientMenu= new FlipFitGymOwnerClientMenu();
            flipFitGymOwnerClientMenu.login(userId);
        } else if(role == 2) {

            FlipfitCustomerClientMenu flipFitCustomerClientMenu =new FlipfitCustomerClientMenu();
            flipFitCustomerClientMenu.flipfitCustomerPage(userId);

        } else if(role == 3) {
            FlipfitAdminClientMenu flipFitAdminClientMenu= new FlipfitAdminClientMenu();
            flipFitAdminClientMenu.handle(userId);
        }  else {
            System.out.println("Invalid role choice");
        }
    }

    public static void registerUser() {
        FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();
        FlipFitCustomerService customerService =new FlipFitCustomerService();

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the FlipFit. Please Register yourself Here");
        System.out.println("Enter your Email: ");
        String email = in.next();
        String password;
        boolean flag = true;
        do{
            System.out.println("Enter your password: ");
            password = in.next();
            System.out.println("Enter your confirm password: ");
            String confirmUserPassword = in.next();
            if(password.equals(confirmUserPassword)) {
                System.out.println("Password matched!");
                flag = false;
            }
            else{
                System.out.println("The Passwords did not match. Please check again");
            }
        }while(flag);
        System.out.println("Enter 1 to register as Gym Owner \nEnter 2 to register as Customer");
        int role = in.nextInt();
        if(role == 1){
            System.out.println("Enter your Name: ");
            String ownerName = in.next();
            System.out.println("Enter your Phone Number: ");
            String ownerPhone = in.next();
            System.out.println("Enter your Address: ");
            String ownerAddress = in.next();
            System.out.println("Enter your GST Number: ");
            String ownerGstNum = in.next();
            System.out.println("Enter your PAN Number: ");
            String ownerPanNum = in.next();
            login();
        } else if(role == 2) {
            System.out.println("Enter your Name: ");
            String customerName = in.next();
            System.out.println("Enter your Phone Number: ");
            String customerPhone = in.next();
            System.out.println("Enter your Age: ");
            int age = Integer.parseInt(in.next());
            System.out.println("Enter your Gender: ");
            String gender = in.next();
            System.out.println("Enter your Weight: ");
            int weight = Integer.parseInt(in.next());
            System.out.println("Enter your address: ");
            String customerAddress = in.next();
            login();
        }
    }


    public static void changePassword() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your Email: ");
        String email = in.next();
        System.out.println("Enter your role: \n1. Gym Owner\n2. Customer\n3. Admin");
        int role = in.nextInt();
        String oldpassword;
        System.out.println("Enter your old password: ");
        oldpassword = in.next();
        System.out.println("Enter your id: ");
        int userId = in.nextInt();
        if (userId <= 0) return;
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
    }

    public static void main(String[] args){

        System.out.println("--------Welcome to FlipFit Application--------");
        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        System.out.println("-----------------------------------------------");
        System.out.println("Date : " +localDate);
        System.out.println("Time : " +localTime);
        System.out.println("-----------------------------------------------");
        System.out.println("Enter preferred choices: \n1. Login\n2. Register \n3. Change Password\n4. Exit");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                login();
                break;
            case 2:
                registerUser();
                break;
            case 3:
                changePassword();
                break;
            case 4:
                System.out.println("Thank you for using FlipFit App");
                in.close();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}
