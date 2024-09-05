package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymOwner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipFitCustomerDAO {
    public static List<FlipFitCustomer> customers = Collections.emptyList();

    static {
        refreshCustomers();
    }

    public static void refreshCustomers() {
        customers = FlipFitUserDAO.USERS.stream()
                .filter(user -> (user instanceof FlipFitCustomer))
                .map(user -> (FlipFitCustomer) user)
                .toList();
    }

    public static void add(FlipFitCustomer customer) {
        FlipFitUserDAO.add(customer);
        refreshCustomers();
    }

    public static void createProfile(FlipFitCustomer customer) {
        add(customer);
    }

    public static void editProfile(String customerId, String name, String phone, String address, Double weight, Integer age, String gender, LocalDate dob) {
        for (FlipFitCustomer customer : customers) {
            if (!customer.getUserId().equals(customerId))
                continue;

            customer.setName(name);
            customer.setPhoneNumber(phone);
            customer.setAddress(address);
            customer.setWeight(weight);
            customer.setAge(age);
            customer.setGender(gender);
            customer.setDob(dob);
            break;
        }
    }
}
