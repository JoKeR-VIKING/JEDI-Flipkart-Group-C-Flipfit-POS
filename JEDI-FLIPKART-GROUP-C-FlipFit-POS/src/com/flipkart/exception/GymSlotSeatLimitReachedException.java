package com.flipkart.exception;

/**
 * Exception thrown when the seat limit for a gym slot has been reached.
 */
public class GymSlotSeatLimitReachedException extends Exception {

    /**
     * Constructs a new {@code GymSlotSeatLimitReachedException} with {@code null} as its detail message.
     */
    public GymSlotSeatLimitReachedException() {
        super();
    }
}
