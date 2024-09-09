package com.flipkart.constants;

/**
 * Contains SQL query constants used throughout the FlipFit application.
 * These queries are used for various operations on the database, such as
 * retrieving, inserting, updating, and deleting data.
 */
public class SQLQueryConstants {

    /**
     * SQL query to select a user by username.
     */
    public static final String SELECT_USER_BY_USERNAME = "SELECT * FROM FlipFitUser WHERE username = ?";

    /**
     * SQL query to update a user's password by userId.
     */
    public static final String UPDATE_USER_PASSWORD_BY_USERID = "UPDATE FlipFitUser SET password = ? WHERE userId = ?";

    /**
     * SQL query to insert a new user into the FlipFitUser table.
     */
    public static final String INSERT_USER = "INSERT INTO FlipFitUser VALUES (?, ?, ?, ?, ?, ?, ?)";

    /**
     * SQL query to update a user's address by userId.
     */
    public static final String UPDATE_USER_ADDRESS = "UPDATE FlipFitUser SET address = ? WHERE userId = ?";

    /**
     * SQL query to update the verification status of a gym owner.
     */
    public static final String UPDATE_OWNER_VERIFICATION = "UPDATE FlipFitGymOwner SET verified = ? WHERE ownerId = ?";

    /**
     * SQL query to select all gym owners.
     */
    public static final String SELECT_ALL_OWNERS = "SELECT * FROM FlipFitGymOwner gymOwner INNER JOIN FlipFitUser user ON gymOwner.ownerId = user.userId";

    /**
     * SQL query to select pending gym owners.
     */
    public static final String SELECT_PENDING_OWNERS = "SELECT * FROM FlipFitGymOwner gymOwner INNER JOIN FlipFitUser user ON gymOwner.ownerId = user.userId WHERE gymOwner.verified = 'PENDING'";

    /**
     * SQL query to update the verification status of a gym.
     */
    public static final String UPDATE_GYM_VERIFICATION = "UPDATE FlipFitCentre SET verified = ? WHERE centreId = ?";

    /**
     * SQL query to delete a gym by centreId.
     */
    public static final String DELETE_GYM = "DELETE FROM FlipFitCentre WHERE centreId = ?";

    /**
     * SQL query to select pending gyms.
     */
    public static final String SELECT_PENDING_GYMS = "SELECT * FROM FlipFitCentre WHERE verified = 'PENDING'";

    /**
     * SQL query to select all registered gyms.
     */
    public static final String SELECT_ALL_REGISTERED_GYMS = "SELECT * FROM FlipFitCentre WHERE verified = 'APPROVED'";

    /**
     * SQL query to select all gyms.
     */
    public static final String SELECT_ALL_GYMS = "SELECT * FROM FlipFitCentre";

    /**
     * SQL query to insert a new customer into the FlipFitCustomer table.
     */
    public static final String INSERT_CUSTOMER = "INSERT INTO FlipFitCustomer VALUES (?, ?, ?, ?, ?)";

    /**
     * SQL query to update a customer's details.
     */
    public static final String UPDATE_CUSTOMER = "UPDATE FlipFitCustomer SET weight = ?, age = ?, gender = ?, dob = ? WHERE customerId = ?";

    /**
     * SQL query to insert a new gym owner into the FlipFitGymOwner table.
     */
    public static final String INSERT_GYM_OWNER = "INSERT INTO FlipFitGymOwner VALUES (?, ?, ?, ?)";

    /**
     * SQL query to update a gym owner's GST number and PAN card number.
     */
    public static final String UPDATE_GYM_OWNER = "UPDATE FlipFitGymOwner SET gstNumber = ?, panCardNumber = ? WHERE ownerId = ?";

    /**
     * SQL query to delete a gym owner by ownerId.
     */
    public static final String DELETE_GYM_OWNER = "DELETE FROM FlipFitUser WHERE userId = ?";

    /**
     * SQL query to get gym owner by ownerId.
     */
    public static final String SELECT_GYM_OWNER_BY_ID = "SELECT * FROM FlipFitGymOwner WHERE ownerId = ?";

    /**
     * SQL query to insert a new gym into the FlipFitCentre table.
     */
    public static final String INSERT_GYM = "INSERT INTO FlipFitCentre VALUES (?, ?, ?, ?, ?, ?)";

    /**
     * SQL query to update a gym's details.
     */
    public static final String UPDATE_GYM = "UPDATE FlipFitCentre SET centreName = ?, centreAddress = ?, city = ? WHERE gymOwnerId = ? AND centreId = ?";

    /**
     * SQL query to delete a gym by centreId and gymOwnerId.
     */
    public static final String DELETE_GYM_WITH_OWNER = "DELETE FROM FlipFitCentre WHERE centreId = ? AND gymOwnerId = ?";

    /**
     * SQL query to select gyms registered to a specific gym owner.
     */
    public static final String SELECT_ALL_GYMS_WITH_OWNER = "SELECT * FROM FlipFitCentre WHERE gymOwnerId = ?";

    /**
     * SQL query to select gyms registered to a specific gym owner.
     */
    public static final String SELECT_REGISTERED_GYMS = "SELECT * FROM FlipFitCentre WHERE gymOwnerId = ? AND verified = 'APPROVED'";

    /**
     * SQL query to select a gym by centreId.
     */
    public static final String SELECT_GYM_BY_ID = "SELECT * FROM FlipFitCentre WHERE centreId = ?";

    /**
     * SQL query to select a gym by centreId.
     */
    public static final String SELECT_GYMS_BY_CITY = "SELECT * FROM FlipFitCentre WHERE city = ? AND verified = 'APPROVED'";

    /**
     * SQL query to select a gym by centreId and gymOwnerId
     */
    public static final String SELECT_GYMS_BY_CITY_AND_OWNER = "SELECT * FROM FlipFitCentre WHERE city = ? AND gymOwnerId = ?";

    /**
     * SQL query to insert a new gym slot into the FlipFitCenterSlot table.
     */
    public static final String INSERT_GYM_SLOT = "INSERT INTO FlipFitCenterSlot VALUES(?, ?, ?, ?)";

    /**
     * SQL query to update a gym slot's start time and seat limit.
     */
    public static final String UPDATE_GYM_SLOT = "UPDATE FlipFitCenterSlot SET startTime = ?, seatLimit = ? WHERE slotId = ?";

    /**
     * SQL query to get all gym slots by gym centreId.
     */
    public static final String GET_GYM_SLOTS_BY_GYM_ID = "SELECT * FROM FlipFitCenterSlot WHERE centreId = ?";

    /**
     * SQL query to get a gym slot by slotId.
     */
    public static final String GET_GYM_SLOT_BY_ID = "SELECT * FROM FlipFitCenterSlot WHERE slotId = ?";

    /**
     * SQL query to delete a gym slot by slotId.
     */
    public static final String DELETE_GYM_SLOT = "DELETE FROM FlipFitCenterSlot WHERE slotId = ?";

    /**
     * SQL query to select available gym slots based on seat limit and bookings.
     */
    public static final String SELECT_AVAILABLE_GYM_SLOTS = "SELECT * FROM FlipFitCenterSlot s WHERE s.centreId = ? AND s.seatLimit > (SELECT COUNT(*) FROM FlipFitSlotBooking b WHERE b.centreSlotId = s.slotId AND b.slotDate = ?)";

    /**
     * SQL query to select available gym slots with available seats based on bookings.
     */
    public static final String SELECT_AVAILABLE_GYM_SLOTS_WITH_AVAIL_SEATS = "SELECT s.*, s.seatLimit - COALESCE(COUNT(b.bookingId), 0) as availableSeats FROM FlipFitCenterSlot s LEFT JOIN FlipFitSlotBooking b ON b.centreSlotId = s.slotId AND b.slotDate = ? WHERE s.centreId = ? GROUP BY s.slotId HAVING COALESCE(COUNT(b.bookingId), 0) < s.seatLimit";

    /**
     * SQL query to select a gym slot by centreId and startTime.
     */
    public static final String SELECT_SLOT_BY_CENTER_AND_START_TIME = "SELECT * FROM FlipFitCenterSlot WHERE centreId = ? AND startTime = ?";

    /**
     * SQL query to select a gym slot by slotId.
     */
    public static final String SELECT_SLOT_BY_ID = "SELECT * FROM FlipFitCenterSlot WHERE slotId = ?";

    /**
     * SQL query to insert a new slot booking into the FlipFitSlotBooking table.
     */
    public static final String INSERT_SLOT_BOOKING = "INSERT INTO FlipFitSlotBooking VALUES (?, ?, ?, ?, ?, ?, ?)";

    /**
     * SQL query to delete a slot booking by bookingId.
     */
    public static final String DELETE_SLOT_BOOKING = "DELETE FROM FlipFitSlotBooking WHERE bookingId = ?";

    /**
     * SQL Query to delete previous booking by userId and slotDate.
     */
    public static final String DELETE_PREVIOUS_SLOT_BOOKING = "DELETE FROM FlipFitSlotBooking WHERE userId = ? AND slotDate = ?";

    /**
     * SQL query to select slot bookings by userId.
     */
    public static final String SELECT_SLOT_BOOKING_BY_USER_ID = "SELECT * FROM FlipFitSlotBooking WHERE userId = ?";

    /**
     * SQL query to select slot bookings by gymId and date.
     */
    public static final String SELECT_SLOT_BOOKINGS_BY_GYM_ID_AND_DATE = "SELECT b.* FROM FlipFitSlotBooking b JOIN FlipFitCenterSlot s ON b.centreSlotId = s.slotId WHERE s.centreId = ? AND b.slotDate = ?";

    /**
     * SQL query to count slot bookings by slotId.
     */
    public static final String SELECT_SLOT_BOOKINGS_COUNT_BY_SLOT_ID = "SELECT COUNT(*) FROM FlipFitSlotBooking WHERE centreSlotId = ? AND slotDate = ?";

    /**
     * SQL query to count slot bookings by gymId and date.
     */
    public static final String SELECT_SLOT_BOOKINGS_COUNT_BY_GYM_ID_AND_DATE = "SELECT COUNT(*) FROM FlipFitSlotBooking b JOIN FlipFitCenterSlot s ON b.centreSlotId = s.slotId WHERE s.centreId = ? AND b.slotDate = ?";

    /**
     * SQL query to insert a payment record into the FlipFitPayments table.
     */
    public static final String INSERT_PAYMENT = "INSERT INTO FlipFitPayments VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
}
