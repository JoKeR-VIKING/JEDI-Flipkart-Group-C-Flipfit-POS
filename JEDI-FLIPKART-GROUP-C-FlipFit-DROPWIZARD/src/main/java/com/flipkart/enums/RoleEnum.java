package com.flipkart.enums;

/**
 * Enumeration representing the different roles in the system.
 */
public enum RoleEnum {
    /**
     * Represents a gym owner.
     */
    GYM_OWNER,

    /**
     * Represents a customer.
     */
    CUSTOMER,

    /**
     * Represents an admin.
     */
    ADMIN;

    /**
     * Retrieves the {@code RoleEnum} corresponding to the specified integer value.
     *
     * @param value The integer value representing the role.
     * @return The {@code RoleEnum} corresponding to the provided value.
     * @throws ArrayIndexOutOfBoundsException If the value is out of bounds of the {@code RoleEnum} values.
     */
    public static RoleEnum fromValue(int value) {
        return RoleEnum.values()[value];
    }
}
