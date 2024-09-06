package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

public class FlipFitAdmin extends FlipFitUser {
    public FlipFitAdmin(String id, String username, String password, String name, String address, String phoneNumber) {
        super(id, username, password, name, address, phoneNumber, RoleEnum.ADMIN);
    }
}
