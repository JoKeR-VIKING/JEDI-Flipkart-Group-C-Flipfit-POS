package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

public interface FlipFitUserDAOInterface {
    void add(FlipFitUser user);

    void updatePassword(String userId, String password);

    FlipFitUser findByUsername(String username);
}
