package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

public class FlipfitAdmin extends FlipfitUser{

    public RoleEnum getRole() {
        return RoleEnum.ADMIN;
    }
}
