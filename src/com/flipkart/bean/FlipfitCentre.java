package com.flipkart.bean;

public class FlipfitCentre {
    private String centreId;
    private FlipfitCity city;
    private String centreName;
    private FlipfitUser gymOwner;
    private Boolean verified;


    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public FlipfitCity getCity() {
        return city;
    }

    public void setCity(FlipfitCity city) {
        this.city = city;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public FlipfitUser getGymOwner() {
        return gymOwner;
    }

    public void setGymOwner(FlipfitUser gymOwner) {
        this.gymOwner = gymOwner;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
