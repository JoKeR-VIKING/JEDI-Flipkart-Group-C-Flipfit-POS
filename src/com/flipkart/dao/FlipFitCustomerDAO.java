package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlipFitCustomerDAO {
    public static List<FlipFitCustomer> customers = new ArrayList<>();

    public static void createProfile(FlipFitCustomer customer) {
        customers.add(customer);
    }

    public static void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) {
        for (FlipFitCustomer customer : customers) {
            if (!customer.getUserId().equals(customerId))
                continue;

            customer.setAddress(address);
            customer.setWeight(weight);
            customer.setAge(age);
            customer.setGender(gender);
            customer.setDob(dob);
            break;
        }
    }
}
