package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.dao.FlipFitUserDAO;

public class FlipFitUserService {

    public String authenticate(String username, String password) {
        FlipFitUser user = FlipFitUserDAO.findByUsername(username);

        if(user == null) return "-1";
        if(!user.getPassword().equals(password)) return "-2";

        return user.getUserId();
    }

    public void changePassword(String userId, String pasword) {
        FlipFitUserDAO.updatePassword(userId, pasword);
    }
}
