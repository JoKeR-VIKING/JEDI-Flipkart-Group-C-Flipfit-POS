package com.flipkart.constants;

public class SQLQueryConstants {

    public static final String SELECT_USER_BY_USERNAME = "SELECT * FROM FlipFitUser WHERE username = ?";
    public static final String UPDATE_USER_PASSWORD_BY_USERID = "UPDATE FlipFitUser SET password = ? WHERE userId = ?";
    public static final String INSERT_USER = "INSERT INTO FlipFitUser VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_GYM_OWNER = "INSERT INTO FlipFitGymOwner VALUES (?, ?, ?, ?)";
}
