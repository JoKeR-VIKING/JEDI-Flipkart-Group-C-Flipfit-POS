package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitCustomer;

import java.time.LocalDate;
import java.util.*;

public class FlipFitCustomerService {

    List<FlipFitCustomer> customers = new ArrayList<FlipFitCustomer>();
    List<FlipFitCenterSlot> allSlots = new ArrayList<FlipFitCenterSlot>();
    Map<String, ArrayList<String>> customerSlotsMap = new HashMap<String, ArrayList<String>>();

    public void createDummyData() {

    }

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
        List<FlipFitCenterSlot> mySlots = new ArrayList<FlipFitCenterSlot>();

        for(String slotId: customerSlotsMap.get(Integer.toString(customerId))) {
            for(FlipFitCenterSlot slot: allSlots) {
                if (slot.getId().equals(slotId)) {
                    mySlots.add(slot);
                }
            }
        }
        return mySlots;
    }

    public void bookSlot(FlipFitCenterSlot slot) {
        allSlots.add(slot);
    }

    public void cancelSlot(int slotId) {
        int slotIndex = -1;
        for(int i=0; i<allSlots.size(); i++) {
            if (allSlots.get(i).getId().equals(Integer.toString(slotId))) {
                slotIndex = i;
                break;
            }
        }
        if (slotIndex == -1) return;
        allSlots.remove(slotIndex);
    }

    public void viewCityList() {
        System.out.println("\n1. Delhi \n2. Bangalore \n3. Hydrabad");
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
}
