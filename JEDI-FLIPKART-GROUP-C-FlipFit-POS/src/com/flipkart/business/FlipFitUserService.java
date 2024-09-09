package com.flipkart.business;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.exception.InvalidPasswordException;
import com.flipkart.exception.InvalidUserException;

import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;

/**
 * Service class for user-related operations in the FlipFit system.
 * Implements the {@link FlipFitUserInterface} interface to provide methods for user authentication
 * and password management.
 */
public class FlipFitUserService implements FlipFitUserInterface {

    /**
     * Authenticates a user based on their username and password.
     *
     * @param username the username of the user attempting to authenticate
     * @param password the password of the user attempting to authenticate
     * @return a {@link FlipFitUser} object if the authentication is successful
     * @throws InvalidUserException if the username does not exist or the user cannot be found
     * @throws InvalidPasswordException if the provided password is incorrect
     */
    @Override
    public FlipFitUser authenticate(String username, String password)
            throws InvalidPasswordException, InvalidUserException {
        FlipFitUser user = FlipFitUserDAOInst.findByUsername(username);

        if (user == null) {
            throw new InvalidUserException();
        }
        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }

        return user;
    }

    public boolean userExists(String username) {
        return FlipFitUserDAOInst.findByUsername(username) != null;
    }

    /**
     * Changes the password for a user.
     *
     * @param userId the ID of the user whose password is to be changed
     * @param password the new password for the user
     * @throws InvalidUserException if the user ID is invalid or the user cannot be found
     */
    @Override
    public void changePassword(String userId, String password) throws InvalidUserException {
        FlipFitUserDAOInst.updatePassword(userId, password);
    }
}
