package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

/**
 * Represents a gym owner in the FlipFit system.
 * This class extends {@link FlipFitUser} and includes additional details specific to gym owners.
 */
public class FlipFitGymOwner extends FlipFitUser {

    private String gstNumber;
    private String panCardNumber;
    private String verified;

    /**
     * Constructs a new FlipFitGymOwner with the specified details.
     * The verification status is set to "PENDING" by default.
     *
     * @param id              the unique identifier for the gym owner
     * @param username        the username of the gym owner
     * @param password        the password for the gym owner account
     * @param name            the name of the gym owner
     * @param address         the address of the gym owner
     * @param phoneNumber     the phone number of the gym owner
     * @param gstNumber       the GST number of the gym owner
     * @param panCardNumber   the PAN card number of the gym owner
     */
    public FlipFitGymOwner(String id, String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) {
        super(id, username, password, name, address, phoneNumber, RoleEnum.GYM_OWNER);
        this.gstNumber = gstNumber;
        this.panCardNumber = panCardNumber;
        this.verified = "PENDING";
    }

    /**
     * Constructs a new FlipFitGymOwner with the specified details, including verification status.
     *
     * @param id              the unique identifier for the gym owner
     * @param username        the username of the gym owner
     * @param password        the password for the gym owner account
     * @param name            the name of the gym owner
     * @param address         the address of the gym owner
     * @param phoneNumber     the phone number of the gym owner
     * @param gstNumber       the GST number of the gym owner
     * @param panCardNumber   the PAN card number of the gym owner
     * @param verified        the verification status of the gym owner
     */
    public FlipFitGymOwner(String id, String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber, String verified) {
        this(id, username, password, name, address, phoneNumber, gstNumber, panCardNumber);
        this.verified = verified;
    }

    /**
     * Returns the GST number of the gym owner.
     *
     * @return the GST number
     */
    public String getGstNumber() {
        return gstNumber;
    }

    /**
     * Sets the GST number of the gym owner.
     *
     * @param gstNumber the new GST number
     */
    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    /**
     * Returns the PAN card number of the gym owner.
     *
     * @return the PAN card number
     */
    public String getPanCardNumber() {
        return panCardNumber;
    }

    /**
     * Sets the PAN card number of the gym owner.
     *
     * @param panCardNumber the new PAN card number
     */
    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    /**
     * Returns the verification status of the gym owner.
     *
     * @return the verification status
     */
    public String getVerified() {
        return verified;
    }

    /**
     * Sets the verification status of the gym owner.
     *
     * @param verified the new verification status
     */
    public void setVerified(String verified) {
        this.verified = verified;
    }
}
