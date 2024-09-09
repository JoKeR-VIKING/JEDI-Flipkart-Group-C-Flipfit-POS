package com.flipkart.exception;

/**
 * Exception thrown when an unauthorized action is attempted by a gym owner.
 */
public class UnauthorizedGymOwnerException extends Exception {

    /**
     * Constructs a new {@code UnauthorizedGymOwnerException} with {@code null} as its detail message.
     */
    public UnauthorizedGymOwnerException() {
        super();
    }
}
