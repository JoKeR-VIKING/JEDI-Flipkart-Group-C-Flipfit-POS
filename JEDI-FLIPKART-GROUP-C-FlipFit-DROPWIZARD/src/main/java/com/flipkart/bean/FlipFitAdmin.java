package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

/**
 * Represents an administrative user in the FlipFit system.
 * This class extends {@link FlipFitUser} and sets the user role to ADMIN.
 */
public class FlipFitAdmin extends FlipFitUser {

    /**
     * Constructs a new FlipFitAdmin instance with the specified details.
     *
     * @param id          the unique identifier for the admin
     * @param username    the username of the admin
     * @param password    the password for the admin account
     * @param name        the name of the admin
     * @param address     the address of the admin
     * @param phoneNumber the phone number of the admin
     */
    public FlipFitAdmin(String id, String username, String password, String name, String address, String phoneNumber) {
        super(id, username, password, name, address, phoneNumber, RoleEnum.ADMIN);
    }
}
