package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.utils.Helper;

import java.time.LocalDate;

import static com.flipkart.dao.FlipFitCustomerDAOImpl.FlipFitCustomerDAOInst;

public class FlipFitCustomerService implements FlipFitCustomerInterface {
    @Override
    public void createProfile(String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob) throws ExistingUserException {
        FlipFitCustomer customer = new FlipFitCustomer(Helper.generateId(), username, password, name, address, phoneNumber, weight, age, gender, dob);
        FlipFitCustomerDAOInst.createProfile(customer);
    }

    @Override
    public void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) {
        FlipFitCustomerDAOInst.editProfile(customerId, address, weight, age, gender, dob);
    }
}

