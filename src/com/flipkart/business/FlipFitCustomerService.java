package com.flipkart.business;

import com.flipkart.bean.FlipfitCenterSlot;
import com.flipkart.bean.FlipfitCentre;
import com.flipkart.bean.FlipfitCustomer;

import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerService {
    public String getName(int customerId) {
        return "customer name";
    }

    public FlipfitCustomer getProfile(int customerId) {
        FlipfitCustomer customer = new FlipfitCustomer();
        return customer;
    }

    public FlipfitCenterSlot[] getBookedSlots(int customerId) {
        FlipfitCenterSlot[] bookedSlots = {};
        // use join query to get booked slots - https://stackoverflow.com/a/17371729
        return bookedSlots;
    }

    public void createProfile(int userId, String name, String phoneNumber, String address) {
        System.out.println("Profile Details are added!");
    }

    public void editProfile(int userId, String name, String phoneNumber, String address){
        //add exception if user is not found
        System.out.println("Customer details are updated!");
    }

    public HashMap<String, Integer> viewSlots(int centerId, String date) {

    }

    public List<FlipfitCentre> viewGyms() {
//        return
    }
}
