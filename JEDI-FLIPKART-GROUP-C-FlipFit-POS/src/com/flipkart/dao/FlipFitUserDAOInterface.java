package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

public interface FlipFitUserDAOInterface {
    public void add(FlipFitUser user);
    public void updatePassword(String userId, String password);
    public FlipFitUser findByUsername(String username);
}
