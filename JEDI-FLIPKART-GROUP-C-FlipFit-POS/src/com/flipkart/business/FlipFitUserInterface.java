package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidPasswordException;

public interface FlipFitUserInterface {

    FlipFitUser authenticate(String username, String password) throws InvalidPasswordException;

    void changePassword(String userId, String password);
}
