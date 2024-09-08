package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

public class FlipFitGymOwner extends FlipFitUser {
    private String gstNumber;
    private String panCardNumber;
    private String verified;

    public FlipFitGymOwner(String id, String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber) {
        super(id, username, password, name, address, phoneNumber, RoleEnum.GYM_OWNER);
        this.gstNumber = gstNumber;
        this.panCardNumber = panCardNumber;
        this.verified = "PENDING";
    }

    public FlipFitGymOwner(String id, String username, String password, String name, String address, String phoneNumber, String gstNumber, String panCardNumber, String verified) {
        this(id, username, password, name, address, phoneNumber, gstNumber, panCardNumber);
        this.verified = verified;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }
}