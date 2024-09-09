package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidUserException;

public interface FlipFitUserDAOInterface {
    void add(FlipFitUser user);

    void updatePassword(String userId, String password) throws InvalidUserException;

    void updateAddress(String gymOwnerId, String address);

    FlipFitUser findByUsername(String username);
}
