package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.exception.ExistingUserException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import static com.flipkart.constants.SQLQueryConstants.*;
import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface {
    public static FlipFitCustomerDAOInterface FlipFitCustomerDAOInst = new FlipFitCustomerDAOImpl();

    @Override
    public void createProfile(FlipFitCustomer customer) throws ExistingUserException {
        FlipFitUserDAOInst.add(customer);

        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_CUSTOMER);
            stmt.setDouble(1, customer.getWeight());
            stmt.setInt(2, customer.getAge());
            stmt.setString(3, customer.getGender());
            stmt.setDate(4, Date.valueOf(customer.getDob()));
            stmt.setString(5, customer.getUserId());

            return stmt.executeUpdate();
        });
    }

    @Override
    public void editProfile(String customerId, String address, Double weight, Integer age, String gender, LocalDate dob) {
        FlipFitUserDAOInst.updateAddress(customerId, address);

        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_CUSTOMER);
            stmt.setDouble(1, weight);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setDate(4, Date.valueOf(dob));
            stmt.setString(5, customerId);

            return stmt.executeUpdate();
        });
    }
}
