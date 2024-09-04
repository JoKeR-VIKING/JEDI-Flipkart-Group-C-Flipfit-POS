package com.flipkart.client;

import com.flipkart.bean.FlipfitCenterSlot;
import com.flipkart.bean.FlipfitCustomer;
import com.flipkart.business.FlipFitCustomerService;

import java.util.Scanner;

public class FlipfitCustomerClientMenu {
    public void viewProfile(int id, FlipFitCustomerService customerService)
    {
        FlipfitCustomer customer = customerService.getProfile(id);
        System.out.println("Age: " + customer.getAge());
        System.out.println("weight: " + customer.getWeight());
        System.out.println("DOB: " + customer.getDob());
        System.out.println("Gender: " + customer.getGender());
        System.out.println("Phone no: " + customer.getPhoneNumber());
        System.out.println("Address: " + customer.getAddress());
    }

    public void handleCustomerBookings(int id, FlipFitCustomerService customerService)
    {
        while(true) {
            System.out.println(
                    "\n1. View bookings" +
                    "\n2. Delete booking" +
                    "\n3. back"
            );

            int choice = getChoice(3);
            switch(choice) {
                case 1:
                    viewBookedSlots(id, customerService);
                    break;
                case 2:
                    cancelCustomerBooking(id, customerService);
                    break;
                case 3:
                    return;
            }
        }
    }

    public void viewBookedSlots(int id, FlipFitCustomerService customerService) {
        FlipfitCenterSlot[] bookedSlots = customerService.getBookedSlots(id);
        for (FlipfitCenterSlot bookedSlot : bookedSlots) {
            System.out.println(bookedSlot.getId());
        }
    }

    public void cancelCustomerBooking(int id, FlipFitCustomerService customerService)
    {
        FlipfitCenterSlot[] bookedSlots = customerService.getBookedSlots(id);
        for (FlipfitCenterSlot bookedSlot : bookedSlots) {
            System.out.println(bookedSlot.getId());
        }

        while(true) {
            System.out.println("Choose slot to delete, or 0 to go back");
            int choice = getChoice(bookedSlots.length);
            if (choice == 0) return;

            customerService.cancelSlot(choice);
            System.out.println("Slot"+ choice +"deleted!");
        }
    }

    public void newSlotBooking(int id, FlipFitCustomerService customerService) {
        Scanner in = new Scanner(System.in);

        System.out.println("Select city: ");
        int cityIndex = in.nextInt();

        System.out.println("Select date: ");
        int dateIndex = in.nextInt();

        System.out.println("Select slot: ");
        int slotIndex = in.nextInt();

        System.out.println("Slot booked!");
    }

    public void logoutUser()
    {
        System.out.println("Logged out\n");
    }

    public int getChoice(int size) {
        Scanner in = new Scanner(System.in);
        int choice;
        try {
            choice = in.nextInt();
            if (choice < 0 || choice > size)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("incorrect input, try again: ");
            return getChoice(size);
        }
        in.close();
        return choice;
    }

    public void flipfitCustomerPage(int customerId){
        Scanner in = new Scanner(System.in);

        FlipFitCustomerService customerService = new FlipFitCustomerService();
        String customerName = customerService.getName(customerId);

        while(true) {
            System.out.println(
                    "Hi " + customerName +", what do you want to do? " +
                    "\n1. My Profile " +
                    "\n2. Handle booking" +
                    "\n3. Book a slot " +
                    "\n4. Log out"
            );

            int choice = getChoice(4);
            switch(choice) {
                case 1:
                    viewProfile(customerId, customerService);
                    break;
                case 2:
                    handleCustomerBookings(customerId, customerService);
                    break;
                case 3:
                    newSlotBooking(customerId, customerService);
                    break;
                case 4:
                    logoutUser();
                    in.close();
                    return;
            }
        }
    }
}
