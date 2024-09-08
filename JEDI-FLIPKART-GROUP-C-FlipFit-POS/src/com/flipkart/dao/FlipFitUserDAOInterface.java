package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

import java.sql.PreparedStatement;

import static com.flipkart.constants.SQLQueryConstants.UPDATE_USER_ADDRESS;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public interface FlipFitUserDAOInterface {
    void add(FlipFitUser user);

    void updatePassword(String userId, String password);

    void updateAddress(String gymOwnerId, String address);

    FlipFitUser findByUsername(String username);
}
