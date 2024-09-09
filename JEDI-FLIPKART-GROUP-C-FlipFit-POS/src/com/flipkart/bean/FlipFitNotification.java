package com.flipkart.bean;

/**
 * Represents a notification in the FlipFit system.
 * This class contains details such as notification ID, user ID, and the message.
 */
public class FlipFitNotification {

    private String id;
    private String userId;
    private String message;

    /**
     * Returns the unique identifier for the notification.
     *
     * @return the notification ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the notification.
     *
     * @param id the new notification ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the unique identifier for the user associated with the notification.
     *
     * @return the user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user associated with the notification.
     *
     * @param userId the new user ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns the message content of the notification.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the notification.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
