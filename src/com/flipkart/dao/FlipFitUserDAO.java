package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;

import java.util.List;
import java.util.ArrayList;

public class FlipFitUserDAO {
    public static List<FlipFitUser> USERS = new ArrayList<>();

    public static FlipFitUser findByUsername(String username) {
        return USERS.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public static void updatePassword(String userId, String password) {
        USERS.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .ifPresent(user -> user.setPassword(password));
    }

    public static void add(FlipFitUser user) {
        USERS.add(user);
    }
}
