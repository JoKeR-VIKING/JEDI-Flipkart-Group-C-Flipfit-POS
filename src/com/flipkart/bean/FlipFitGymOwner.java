package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

public class FlipFitGymOwner extends FlipFitUser {
    private String gstNumber;
    private String panCardNumber;
    private Boolean verified;

    public FlipFitGymOwner(String id, String username, String password, String name, Boolean verfied, String address, String phoneNumber, String gstNumber, String panCardNumber) {
        super(id, username, password, name, verfied, address, phoneNumber);
        this.gstNumber = gstNumber;
        this.panCardNumber = panCardNumber;
        this.verified = false;
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

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public RoleEnum getRole() {
        return RoleEnum.GYM_OWNER;
    }
}
