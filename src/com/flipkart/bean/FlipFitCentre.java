package com.flipkart.bean;

public class FlipFitCentre {
    private String centreId;
    private String centreName;
    private String centreAddress;
    private String gymOwnerId;
    private String verified;

    public FlipFitCentre(String centreId, String centreName, String centreAddress, String gymOwnerId) {
        this.centreId = centreId;
        this.centreName = centreName;
        this.centreAddress = centreAddress;
        this.gymOwnerId = gymOwnerId;
        this.verified = "PENDING";
    }

    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public String getCentreAddress() {
        return centreAddress;
    }

    public void setCentreAddress(String centreAddress) {
        this.centreAddress = centreAddress;
    }

    public String getGymOwner() {
        return gymOwnerId;
    }

    public void setGymOwner(String gymOwner) {
        this.gymOwnerId = gymOwner;
    }

    public String getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(String gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }
}
