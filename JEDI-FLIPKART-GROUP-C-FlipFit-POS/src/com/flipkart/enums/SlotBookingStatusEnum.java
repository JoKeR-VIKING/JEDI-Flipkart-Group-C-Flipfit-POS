package com.flipkart.enums;

import java.util.Arrays;

/**
 * Enumeration representing the status of a slot booking.
 */
public enum SlotBookingStatusEnum {
    /**
     * Indicates that the slot booking is confirmed.
     */
    CONFIRMED,

    /**
     * Indicates that the slot booking is cancelled.
     */
    CANCELLED,

    /**
     * Indicates that the slot booking is waitlisted.
     */
    WAITLISTED;

    /**
     * Retrieves the {@code SlotBookingStatusEnum} corresponding to the specified name.
     *
     * @param name The name of the status to retrieve.
     * @return The {@code SlotBookingStatusEnum} that matches the provided name, or {@code null} if no match is found.
     */
    public static SlotBookingStatusEnum fromName(String name) {
        return Arrays.stream(SlotBookingStatusEnum.values())
                .filter(status -> status.toString().equals(name))
                .findFirst()
                .orElse(null);
    }
}
