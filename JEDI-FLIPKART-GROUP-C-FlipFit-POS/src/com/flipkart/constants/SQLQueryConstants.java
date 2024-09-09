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
    public static final String UPDATE_CUSTOMER = "UPDATE FlipFitCustomer SET weight = ?, age = ?, gender = ?, dob = ? WHERE customerId = ?";

    public static final String INSERT_GYM_OWNER = "INSERT INTO FlipFitGymOwner VALUES (?, ?, ?, ?)";
    public static final String UPDATE_GYM_OWNER = "UPDATE FlipFitGymOwner SET gstNumber = ?, panCardNumber = ? WHERE ownerId = ?";
    public static final String DELETE_GYM_OWNER = "DELETE FROM FlipFitGymOwner WHERE ownerId = ?";

    public static final String INSERT_GYM = "INSERT INTO FlipFitCentre VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_GYM = "UPDATE FlipFitCentre SET centreName = ?, centreAddress = ? WHERE gymOwnerId = ? AND centreId = ?";
    public static final String DELETE_GYM_WITH_OWNER = "DELETE FROM FlipFitCentre WHERE centreId = ? AND gymOwnerId = ?";
    public static final String SELECT_REGISTERED_GYMS = "SELECT * FROM FlipFitCentre WHERE gymOwnerId = ?";

    public static final String INSERT_GYM_SLOT = "INSERT INTO FlipFitCenterSlot VALUES(?, ?, ?, ?)";
    public static final String UPDATE_GYM_SLOT = "UPDATE FlipFitCenterSlot SET startTime = ?, seatLimit = ? WHERE slotId = ?";
    public static final String GET_GYM_SLOTS_BY_GYM_ID = "SELECT * FROM FlipFitCenterSlot WHERE centreId = ?";
    public static final String GET_GYM_SLOT_BY_ID = "SELECT * FROM FlipFitCenterSlot WHERE slotId = ?";
    public static final String DELETE_GYM_SLOT = "DELETE FROM FlipFitCenterSlot WHERE slotId = ?";
    public static final String SELECT_AVAILABLE_GYM_SLOTS = "SELECT * FROM FlipFitCenterSlot s WHERE s.centreId = ? AND s.seatLimit > (SELECT COUNT(*) FROM FlipFitSlotBooking b WHERE b.centreSlotId = s.slotId AND b.slotDate = ?)";
    public static final String SELECT_SLOT_BY_CENTER_AND_START_TIME = "SELECT * FROM FlipFitCenterSlot WHERE centreId = ? AND startTime = ?";

    public static final String INSERT_SLOT_BOOKING = "INSERT INTO FlipFitSlotBooking VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_SLOT_BOOKING = "DELETE FROM FlipFitSlotBooking WHERE bookingId = ?";
    public static final String SELECT_SLOT_BOOKING_BY_USER_ID = "SELECT * FROM FlipFitSlotBooking WHERE userId = ?";
    public static final String SELECT_SLOT_BOOKINGS_BY_GYM_ID_AND_DATE = "SELECT b.* FROM FlipFitSlotBooking b JOIN FlipFitCenterSlot s ON b.centreSlotId = s.slotId WHERE s.centreId = ? AND b.slotDate = ?";

    public static final String INSERT_PAYMENT = "INSERT INTO FlipFitPayments VALUES (?, ?, ?, ?, ?)";
}