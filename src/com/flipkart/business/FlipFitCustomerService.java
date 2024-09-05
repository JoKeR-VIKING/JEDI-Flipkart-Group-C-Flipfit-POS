package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitCustomer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class FlipFitCustomerService {

    List<FlipFitCustomer> customers = new ArrayList<FlipFitCustomer>();
    List<FlipFitCenterSlot> allSlots = new ArrayList<FlipFitCenterSlot>();
    Map<String, ArrayList<String>> customerSlotsMap = new HashMap<String, ArrayList<String>>();

    public void createDummyData() {
        customers.add(new FlipFitCustomer("10000", "shashank", "shashank", "Shashank", "gurgaon", "9876543210", 50.00, 30, "male", LocalDate.now()));
        customers.add(new FlipFitCustomer("10001", "pratham", "pratham", "Pratham", "delhi", "9876543211", 50.00, 31, "male", LocalDate.now()));
        customers.add(new FlipFitCustomer("10002", "sanjana", "sanjana", "Sanjana", "hydrabad", "9876543212", 50.00, 32, "female", LocalDate.now()));
        customers.add(new FlipFitCustomer("10003", "aman", "aman", "Aman", "gujarat", "9876543213", 50.00, 30, "male", LocalDate.now()));
        customers.add(new FlipFitCustomer("10004", "luckshya", "luckshya", "Luckshya", "chennai", "9876543214", 50.00, 28, "male", LocalDate.now()));
        customers.add(new FlipFitCustomer("10005", "shreya", "shreya", "Shreya", "uttar pradesh", "9876543215", 50.00, 30, "female", LocalDate.now()));

        allSlots.add(new FlipFitCenterSlot("4500", "78", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4501", "78", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4502", "79", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4503", "79", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4504", "79", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4505", "80", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4506", "81", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4507", "81", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4508", "83", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4509", "84", LocalTime.now(), 30));
        allSlots.add(new FlipFitCenterSlot("4510", "84", LocalTime.now(), 30));

        customerSlotsMap.put("10000", new ArrayList<>() {{ add("4500");add("4501");add("4502"); }});
        customerSlotsMap.put("10001", new ArrayList<>() {{ add("4503"); }});
        customerSlotsMap.put("10002", new ArrayList<>() {{ add("4504");add("4505"); }});
        customerSlotsMap.put("10003", new ArrayList<>() {{ add("4506");add("4507"); }});
        customerSlotsMap.put("10004", new ArrayList<>() {{ add("4508");}});
        customerSlotsMap.put("10005", new ArrayList<>() {{ add("4509");add("4510"); }});
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

    public void editProfile(String userId, String name, String phoneNumber, String address) {

    }
}
