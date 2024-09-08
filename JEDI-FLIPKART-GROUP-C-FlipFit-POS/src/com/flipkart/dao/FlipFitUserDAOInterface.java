package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

public interface FlipFitUserDAOInterface {
    void add(FlipFitUser user);

    void updatePassword(String userId, String password);

    void updateAddress(String gymOwnerId, String address);

    FlipFitUser findByUsername(String username);
}
