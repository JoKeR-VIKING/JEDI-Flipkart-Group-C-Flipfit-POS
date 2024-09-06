package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public class FlipFitCustomerDAO {
    public static FlipFitCustomerDAO FlipFitCustomerDAOInst = new FlipFitCustomerDAO();
    public List<FlipFitCustomer> customers = Collections.emptyList();

    static {
        refreshCustomers();
    }

    public static void refreshCustomers() {
        FlipFitCustomerDAOInst.customers = FlipFitUserDAOInst.USERS.stream()
                .filter(user -> (user instanceof FlipFitCustomer))
                .map(user -> (FlipFitCustomer) user)
                .toList();
    }

    public void add(FlipFitCustomer customer) {
        FlipFitUserDAOInst.add(customer);
        refreshCustomers();
    }

    public void createProfile(FlipFitCustomer customer) {
        add(customer);
    }

    public void editProfile(String customerId, String name, String phone, String address, Double weight, Integer age, String gender, LocalDate dob) {
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
