package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

import java.util.List;
import java.util.ArrayList;

public class FlipFitUserDAOImpl implements FlipFitUserDAOInterface {
    public static FlipFitUserDAOImpl FlipFitUserDAOInst = new FlipFitUserDAOImpl();

    public List<FlipFitUser> USERS = new ArrayList<>();

    public FlipFitUser findByUsername(String username) {
        return USERS.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public void updatePassword(String userId, String password) {
        USERS.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .ifPresent(user -> user.setPassword(password));
    }

    public void add(FlipFitUser user) {
        USERS.add(user);
    }
}
