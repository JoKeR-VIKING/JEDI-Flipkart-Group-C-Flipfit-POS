package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;

public interface FlipFitUserDAOInterface {
    void add(FlipFitUser user) throws ExistingUserException;

    void updatePassword(String userId, String password) throws InvalidUserException;

    void updateAddress(String gymOwnerId, String address) throws InvalidUserException;

    FlipFitUser findByUsername(String username);
}
