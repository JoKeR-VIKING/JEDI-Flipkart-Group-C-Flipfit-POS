package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidPasswordException;
import com.flipkart.exception.InvalidUserException;

public interface FlipFitUserInterface {

    FlipFitUser authenticate(String username, String password) throws InvalidPasswordException, InvalidUserException;

    void changePassword(String userId, String password) throws InvalidUserException;
}
