package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;

import java.time.LocalDate;

import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public interface FlipFitCustomerDAOInterface {
    void refreshCustomers();

    void add(FlipFitCustomer customer) ;
    void createProfile(FlipFitCustomer customer);

    void editProfile(String customerId, String name, String phone, String address, Double weight, Integer age, String gender, LocalDate dob) ;

}
