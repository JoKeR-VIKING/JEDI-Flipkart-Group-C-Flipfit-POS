package com.flipkart.client;

import java.io.*;
import java.util.*;

public class FlipFitGymOwnerClientMenu {
    Scanner scanner = new Scanner(System.in);

    private void displayGymOwnerMenu() {
        System.out.println("Welcome to FlipFit Owner Menu Page");
        System.out.println("Enter preferred choices:\n1. Add Gym\n2. Remove Gym\n3. View all my registered Gyms \n4. View all Available Slots \n5. Add Slots \n6. Remove Slots \n7. Log Out");
    }

    private void addGym() {
        System.out.println("Enter your gym details ");

        System.out.print("Enter Gym Name: \n");
        String gymName = scanner.nextLine();

        System.out.println("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();
    }

    private void removeGym() {
        System.out.print("Enter ID of Gym to remove: \n");
        int gymId = scanner.nextInt();
    }

    //help
    public void viewRegisteredGymCenters() {
        System.out.println("You are in view Registered Gym centers function\n");
    }

    //help
    public void viewAvailableSlots() {
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        System.out.println("Slots available are as follows:");
    }

    public void addSlot() {
        System.out.println("Enter below details to add a new slot in the Gym:");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Date (DD/MM/YYYY): ");
        String date= scanner.nextLine();
        System.out.print("Enter Start Time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter End Time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter Number of Seats: ");
        int noOfSeats = scanner.nextInt();
    }

    public void removeSlot()
    {
        System.out.println("Enter below details to remove slot from the Gym:");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.print("Enter Slot ID: ");
        int slotId = scanner.nextInt();
    }

    public  void userLogout() {
        System.out.println("Logged out\n");
    }

    public void login(int id) {
        Scanner in = new Scanner(System.in);
        
        int choice = 0;

        while (choice != 7) {
            choice = in.nextInt();
            displayGymOwnerMenu();

            switch (choice) {
                case 1:
                    addGym();
                    break;
                case 2:
                    removeGym();
                    break;
                case 3:
                    viewRegisteredGymCenters();
                    break;
                case 4:
                    viewAvailableSlots();
                    break;
                case 5:
                    addSlot();
                    break;
                case 6:
                    removeSlot();
                    break;
                case 7:
                    userLogout();
                    in.close();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        in.close();
    }
}