package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidPasswordException;
import com.flipkart.exception.InvalidUserException;

/**
 * Interface for user-related operations in the FlipFit system.
 * Provides methods for user authentication and password management.
 */
public interface FlipFitUserInterface {

    /**
     * Authenticates a user based on their username and password.
     *
     * @param username the username of the user attempting to authenticate
     * @param password the password of the user attempting to authenticate
     * @return a {@link FlipFitUser} object if the authentication is successful
     * @throws InvalidPasswordException if the provided password is incorrect
     * @throws InvalidUserException if the username does not exist or the user cannot be authenticated
     */
    FlipFitUser authenticate(String username, String password)
            throws InvalidPasswordException, InvalidUserException;

    /**
     * Changes the password for a user.
     *
     * @param userId the ID of the user whose password is to be changed
     * @param password the new password for the user
     * @throws InvalidUserException if the user ID is invalid or the user cannot be found
     */
    void changePassword(String userId, String password) throws InvalidUserException;
}
