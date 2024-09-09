package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.ExistingUserException;

public interface FlipFitUserDAOInterface {
    void add(FlipFitUser user) throws ExistingUserException;

    void updatePassword(String userId, String password);

    void updateAddress(String gymOwnerId, String address);

    FlipFitUser findByUsername(String username);
}
