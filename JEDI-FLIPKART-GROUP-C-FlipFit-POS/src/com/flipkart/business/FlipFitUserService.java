package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public class FlipFitUserService {
    public String authenticate(String username, String password) {
        FlipFitUser user = FlipFitUserDAOInst.findByUsername(username);

        if(user == null) return "-1";
        if(!user.getPassword().equals(password)) return "-2";

        return user.getUserId();
    }

    public void changePassword(String userId, String pasword) {
        FlipFitUserDAOInst.updatePassword(userId, pasword);
    }
}
