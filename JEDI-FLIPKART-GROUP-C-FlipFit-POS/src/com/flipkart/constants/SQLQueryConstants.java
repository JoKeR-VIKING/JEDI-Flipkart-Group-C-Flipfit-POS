package com.flipkart.constants;

public class SQLQueryConstants {
    public static final String SELECT_USER_BY_USERNAME = "SELECT * FROM FlipFitUser WHERE username = ?";
    public static final String UPDATE_USER_PASSWORD_BY_USERID = "UPDATE FlipFitUser SET password = ? WHERE userId = ?";
    public static final String INSERT_USER = "INSERT INTO FlipFitUser VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER_ADDRESS = "UPDATE FlipFitUser SET address = ? WHERE userId = ?";

    public static final String UPDATE_OWNER_VERIFICATION = "UPDATE FlipFitGymOwner SET verified = ? WHERE ownerId = ?";
    public static final String SELECT_ALL_OWNERS = "SELECT * FROM FlipFitGymOwner gymOwner INNER JOIN FlipFitUser user ON gymOwner.ownerId = user.userId";
    public static final String SELECT_PENDING_OWNERS = "SELECT * FROM FlipFitGymOwner gymOwner INNER JOIN FlipFitUser user ON gymOwner.ownerId = user.userId WHERE gymOwner.verified = 'PENDING'";
    public static final String UPDATE_GYM_VERIFICATION = "UPDATE FlipFitCentre SET verified = ? WHERE centreId = ?";
    public static final String DELETE_GYM = "DELETE FROM FlipFitCentre WHERE centreId = ?";
    public static final String SELECT_PENDING_GYMS = "SELECT * FROM FlipFitCentre WHERE verified = 'PENDING'";
    public static final String SELECT_ALL_GYMS = "SELECT * FROM FlipFitCentre";

    public static final String INSERT_CUSTOMER = "INSERT INTO FlipFitCustomer VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_CUSTOMER = "UPDATE INTO FlipFitCustomer SET weight = ?, age = ?, gender = ?, dob = ? WHERE customerId = ?";

    public static final String INSERT_GYM_OWNER = "INSERT INTO FlipFitGymOwner VALUES (?, ?, ?, ?)";
    public static final String UPDATE_GYM_OWNER = "UPDATE FlipFitGymOwner SET gstNumber = ?, panCardNumber = ? WHERE ownerId = ?";

    public static final String INSERT_GYM = "INSERT INTO FlipFitCentre VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_GYM = "UPDATE FlipFitCentre SET centreName = ? AND centreAddress = ? WHERE ownerId = ? AND centreId = ?";
    public static final String DELETE_GYM_WITH_OWNER = "DELETE FROM FlipFitCentre WHERE centreId = ? AND ownerId = ?";
    public static final String SELECT_REGISTERED_GYMS = "SELECT * FROM FlipFitCentre WHERE ownerId = ? AND verified = 'APPROVED'";

    public static final String INSERT_GYM_SLOT = "INSERT INTO FlipFitCenterSlot VALUES(?, ?, ?, ?)";
    public static final String UPDATE_GYM_SLOT = "UPDATE FlipFitCenterSlot SET slotId = ?, startTime = ?, seatLimit = ?";
    public static final String GET_GYM_SLOTS_BY_GYM_ID = "SELECT * FROM FlipFitCenterSlot WHERE centreId = ?";
    public static final String GET_GYM_SLOT_BY_ID = "SELECT * FROM FlipFitCenterSlot WHERE slotId = ?";
    public static final String DELETE_GYM_SLOT = "DELETE FROM FlipFitCenterSlot WHERE slotId = ?";

    public static final String INSERT_SLOT_BOOKING = "INSERT INTO FlipFitSlotBooking VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_SLOT_BOOKING = "DELETE FROM FlipFitSlotBooking WHERE bookingId = ?";
    public static final String SELECT_SLOT_BOOKING_BY_USER_ID = "SELECT * FROM FlipFitSlotBooking WHERE userId = ?";

    public static final String INSERT_PAYMENT = "INSERT INTO FlipFitPayments VALUES (?, ?, ?, ?, ?)";
}