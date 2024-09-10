package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

import javax.validation.constraints.NotBlank;

/**
 * Represents a user in the FlipFit system.
 * This class contains details such as user ID, username, password, name, address, phone number, and role.
 */
public class FlipFitUser {
    @NotBlank
    private String userId;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private RoleEnum role;

    /**
     * Constructs a new FlipFitUser with the specified details.
     *
     * @param userId       the unique identifier for the user
     * @param username     the username of the user
     * @param password     the password for the user account
     * @param name         the name of the user
     * @param address      the address of the user
     * @param phoneNumber  the phone number of the user
     * @param role         the role of the user (e.g., ADMIN, CUSTOMER, GYM_OWNER)
     */
    public FlipFitUser(String userId, String username, String password, String name, String address, String phoneNumber, RoleEnum role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    /**
     * Returns the unique identifier for the user.
     *
     * @return the user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param userId the new user ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password for the user account.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user account.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the address of the user.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the user.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the phone number of the user.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the role of the user.
     * The role is an enumeration value from {@link RoleEnum}.
     *
     * @return the role
     */
    public RoleEnum getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the new role
     */
    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
