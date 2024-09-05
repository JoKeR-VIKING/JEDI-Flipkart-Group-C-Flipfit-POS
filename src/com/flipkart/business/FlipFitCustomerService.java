package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.dao.FlipFitCustomerDAO;
import com.flipkart.utils.Helper;

import java.time.LocalDate;

public class FlipFitCustomerService implements FlipFitCustomerInterface {
    @Override
    public void createProfile(String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob) {
        FlipFitCustomer customer = new FlipFitCustomer(Helper.generateId(), username, password, name, address, phoneNumber, weight, age, gender, dob);
        FlipFitCustomerDAO.createProfile(customer);
    }

    @Override
    public void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) {
        FlipFitCustomerDAO.editProfile(customerId, address, weight, age, gender, dob);
    }
}
