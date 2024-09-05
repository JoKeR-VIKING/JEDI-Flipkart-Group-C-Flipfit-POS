package com.flipkart.business;

import com.flipkart.bean.FlipfitCenterSlot;
import com.flipkart.bean.FlipfitCentre;
import com.flipkart.bean.FlipfitCustomer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class FlipFitCustomerService {

    List<FlipfitCustomer> customers = new ArrayList<FlipfitCustomer>();

    public String getName(int customerId) {
        // select name from customer where id = customerid
        for(FlipfitCustomer customer:customers) {
            if (customer.getId().equals(Integer.toString(customerId))) {
                return customer.getName();
            }
        }
        return "error";
    }

    public FlipfitCustomer getProfile(int customerId) {
        // select * from customer where id = customerid;
        for(FlipfitCustomer customer:customers) {
            if (customer.getId().equals(Integer.toString(customerId))) {
                return customer;
            }
        }
        return null;
    }

    public List<FlipfitCenterSlot> getBookedSlots(int customerId) {
        // TODO
        return null;
    }

    public void bookSlot() {

    }

    public void cancelSlot(int slotId) {

    }

    public HashMap<String, Integer> viewSlots(int centerId, String date) {
        return null;
    }

    public void viewCityList() {

    }

    public void viewCentreListByCityAndDate(String city, LocalDate date) {

    }

    public void createProfile(String name, String phone, int age, String gender, Double weight, String address, String email, String password, LocalDate dob) {
        Random random = new Random();
        customers.add(new FlipfitCustomer(
                Integer.toString(random.nextInt(10000)),
                password,
                name,
                phone,
                address,
                weight,
                age,
                gender,
                dob
                )
        );
    }

    public void editProfile(int customerId, String newPassword) {
        for(FlipfitCustomer customer:customers) {
            if (customer.getId().equals(Integer.toString(customerId))) {
                customer.setPassword(newPassword);
                return;
            }
        }
        System.out.println("Customer id incorrect");
    }

    public List<FlipfitCentre> viewGyms() {
        return null;
    }
}
