package com.flipkart.bean;

/**
 * Represents a fitness center with details such as its ID, name, address, gym owner ID, and verification status.
 */
public class FlipFitCentre {

    private String centreId;
    private String centreName;
    private String centreAddress;
    private String gymOwnerId;
    private String verified;

    /**
     * Constructs a new FlipFitCentre with the specified details.
     * The verification status is set to "PENDING" by default.
     *
     * @param centreId        the unique identifier for the center
     * @param centreName      the name of the center
     * @param centreAddress   the address of the center
     * @param gymOwnerId      the unique identifier for the gym owner
     */
    public FlipFitCentre(String centreId, String centreName, String centreAddress, String gymOwnerId) {
        this.centreId = centreId;
        this.centreName = centreName;
        this.centreAddress = centreAddress;
        this.gymOwnerId = gymOwnerId;
        this.verified = "PENDING";
    }

    /**
     * Constructs a new FlipFitCentre with the specified details, including verification status.
     *
     * @param centreId        the unique identifier for the center
     * @param centreName      the name of the center
     * @param centreAddress   the address of the center
     * @param gymOwnerId      the unique identifier for the gym owner
     * @param verified        the verification status of the center
     */
    public FlipFitCentre(String centreId, String centreName, String centreAddress, String gymOwnerId, String verified) {
        this(centreId, centreName, centreAddress, gymOwnerId);
        this.verified = verified;
    }

    /**
     * Returns the unique identifier for the center.
     *
     * @return the center ID
     */
    public String getCentreId() {
        return centreId;
    }

    /**
     * Sets the unique identifier for the center.
     *
     * @param centreId the new center ID
     */
    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    /**
     * Returns the name of the center.
     *
     * @return the center name
     */
    public String getCentreName() {
        return centreName;
    }

    /**
     * Sets the name of the center.
     *
     * @param centreName the new center name
     */
    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    /**
     * Returns the address of the center.
     *
     * @return the center address
     */
    public String getCentreAddress() {
        return centreAddress;
    }

    /**
     * Sets the address of the center.
     *
     * @param centreAddress the new center address
     */
    public void setCentreAddress(String centreAddress) {
        this.centreAddress = centreAddress;
    }

    /**
     * Returns the unique identifier for the gym owner.
     *
     * @return the gym owner ID
     */
    public String getGymOwnerId() {
        return gymOwnerId;
    }

    /**
     * Sets the unique identifier for the gym owner.
     *
     * @param gymOwnerId the new gym owner ID
     */
    public void setGymOwnerId(String gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    /**
     * Returns the verification status of the center.
     *
     * @return the verification status
     */
    public String getVerified() {
        return verified;
    }

    /**
     * Sets the verification status of the center.
     *
     * @param verified the new verification status
     */
    public void setVerified(String verified) {
        this.verified = verified;
    }
}
