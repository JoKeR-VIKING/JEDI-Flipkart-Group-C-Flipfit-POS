package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidPasswordException;

import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public class FlipFitUserService implements FlipFitUserInterface {
    public FlipFitUser authenticate(String username, String password) throws InvalidPasswordException {
        FlipFitUser user = FlipFitUserDAOInst.findByUsername(username);

        if (user == null) return null;
        if (!user.getPassword().equals(password)) throw new InvalidPasswordException();

        return user;
    }

    public void changePassword(String userId, String password) {
        FlipFitUserDAOInst.updatePassword(userId, password);
    }
}
