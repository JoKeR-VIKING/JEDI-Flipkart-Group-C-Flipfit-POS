package com.flipkart.enums;

import java.util.Arrays;

public enum SlotBookingStatusEnum {
    CONFIRMED,
    CANCELLED,
    WAITLISTED;

    public static SlotBookingStatusEnum fromName(String name) {
        return Arrays.stream(SlotBookingStatusEnum.values())
                .filter(status -> status.toString().equals(name))
                .findFirst()
                .orElse(null);
    }
}
