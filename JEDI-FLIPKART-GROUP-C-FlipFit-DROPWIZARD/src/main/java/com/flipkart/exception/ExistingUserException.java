package com.flipkart.exception;

/**
 * Exception thrown when an attempt is made to create or register a user that already exists in the system.
 */
public class ExistingUserException extends Exception {

    /**
     * Constructs a new {@code ExistingUserException} with {@code null} as its detail message.
     */
    public ExistingUserException() {
        super();
    }
}
