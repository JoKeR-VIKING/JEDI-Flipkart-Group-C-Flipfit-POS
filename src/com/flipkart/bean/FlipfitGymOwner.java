package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

public class FlipfitGymOwner extends FlipfitUser{
    private String gstNumber;
    private String panCardNumber;
    private String verified;

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

    public String getGstNumber()
    {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber)
    {
        this.gstNumber = gstNumber;
    }

    public RoleEnum getRole() {
        return RoleEnum.GYM_OWNER;
    }
}
