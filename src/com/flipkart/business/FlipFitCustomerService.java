package com.flipkart.business;

import com.flipkart.bean.FlipfitCenterSlot;
import com.flipkart.bean.FlipfitCustomer;

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

    public void bookSlot() {

    }

    public void cancelSlot(int slotId) {

    }

    public void viewSlots() {

    }

    public void viewCityList() {

    }

    public void viewCentreListByCityAndDate() {

    }
}
