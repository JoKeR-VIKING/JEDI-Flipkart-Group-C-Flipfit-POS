package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitCustomer;

import java.time.LocalDate;
import java.util.*;

public class FlipFitCustomerService {

    List<FlipFitCustomer> customers = new ArrayList<FlipFitCustomer>();

    public String getName(int customerId) {
        // select name from customer where id = customerid
        for(FlipFitCustomer customer:customers) {
            if (customer.getId().equals(Integer.toString(customerId))) {
                return customer.getName();
            }
        }
        return "error";
    }

    public FlipFitCustomer getProfile(int customerId) {
        // select * from customer where id = customerid;
        for(FlipFitCustomer customer:customers) {
            if (customer.getId().equals(Integer.toString(customerId))) {
                return customer;
            }
        }
        return null;
    }

    public List<FlipFitCenterSlot> getBookedSlots(int customerId) {
        List<FlipFitCenterSlot> bookedSlots = new ArrayList<>();
        // use join query to get booked slots - https://stackoverflow.com/a/17371729
        return bookedSlots;
    }

    public void bookSlot() {

    }

    public void cancelSlot(int slotId) {

    }

    public void viewCityList() {

    }

    public void viewCentreListByCityAndDate(String city, LocalDate date) {

    }

    public void createProfile(String name, String phone, int age, String gender, Double weight, String address, String email, String password, LocalDate dob) {
        Random random = new Random();
        customers.add(new FlipFitCustomer(
                Integer.toString(random.nextInt(10000)),
                email,
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
        for(FlipFitCustomer customer:customers) {
            if (customer.getId().equals(Integer.toString(customerId))) {
                customer.setPassword(newPassword);
                return;
            }
        }
        System.out.println("Customer id incorrect");
    }

    public List<FlipFitCentre> viewGyms() {
        return null;
    }

    public void editProfile(String userId, String name, String phoneNumber, String address) {

    }
}
