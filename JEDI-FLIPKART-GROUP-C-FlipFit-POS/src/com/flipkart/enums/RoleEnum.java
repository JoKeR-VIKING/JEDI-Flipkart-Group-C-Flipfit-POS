package com.flipkart.enums;

public enum RoleEnum {
    GYM_OWNER,
    CUSTOMER,
    ADMIN;

    public static RoleEnum fromValue(int value) {
        return RoleEnum.values()[value];
    }
}
