package com.flipkart.client;

import java.io.*;
import java.util.*;

public class FlipFitGymOwnerClientMenu {
    Scanner scanner = new Scanner(System.in);

    private void displayGymOwnerMenu() {
        System.out.println("Welcome to FlipFit Owner Menu Page");
        System.out.println("Enter preferred choices:\n1. Add Gym\n2. Remove Gym\n3. View all my registered Gyms \n4. View all Available Slots \n5. Add Slots \n6. Remove Slots \n7. Log Out");
    }

    private void addGym(int gymOwnerId) {
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
    public void viewRegisteredGymCenters(int userId) {
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

    public static void login(int id){
        FlipFitGymOwnerClientMenu menu = new FlipFitGymOwnerClientMenu();
        Scanner in = new Scanner(System.in);

        menu.displayGymOwnerMenu();

        int choice = 0;

        while (choice != 8) {
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    menu.addGym(id);
                    break;
                case 2:
                    menu.removeGym();
                    break;
                case 3:
                    menu.viewRegisteredGymCenters(id);
                    break;
                case 4:
                    menu.viewAvailableSlots();
                    break;
                case 5:
                    menu.addSlot();
                    break;
                case 6:
                    menu.removeSlot();
                    break;
                case 7:
                    menu.userLogout();
                    in.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Press 1 to go back to 'Gym Owner Menu Page' OR any other key to 'Log Out'");

            int newChoice = in.nextInt();

            if (newChoice == 1)
                menu.displayGymOwnerMenu();
            else
                break;
        }

        in.close();
    }
}