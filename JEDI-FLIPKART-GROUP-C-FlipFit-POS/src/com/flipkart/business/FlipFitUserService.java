package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidPasswordException;
import com.flipkart.exception.InvalidUserException;

import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

public class FlipFitUserService implements FlipFitUserInterface {
    public FlipFitUser authenticate(String username, String password) throws InvalidPasswordException, InvalidUserException {
        FlipFitUser user = FlipFitUserDAOInst.findByUsername(username);

        if (user == null) throw new InvalidUserException();
        if (!user.getPassword().equals(password)) throw new InvalidPasswordException();

        return user;
    }

    public void changePassword(String userId, String password) throws InvalidUserException {
        FlipFitUserDAOInst.updatePassword(userId, password);
    }
}
