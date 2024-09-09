package com.flipkart.exception;

/**
 * Exception thrown when an attempt is made to create a gym slot that already exists in the system.
 */
public class GymSlotAlreadyExistsException extends Exception {

    /**
     * Constructs a new {@code GymSlotAlreadyExistsException} with {@code null} as its detail message.
     */
    public GymSlotAlreadyExistsException() {
        super();
    }
}
