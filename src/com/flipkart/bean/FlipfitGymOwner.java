package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

public class FlipfitGymOwner extends FlipfitUser{
    private String gstNumber;

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public RoleEnum getRole() {
        return RoleEnum.GYM_OWNER;
    }
}
