package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

import javax.management.relation.Role;

public class FlipfitAdmin extends FlipfitUser{

    public RoleEnum getRole() {
        return RoleEnum.ADMIN;
    }
}
