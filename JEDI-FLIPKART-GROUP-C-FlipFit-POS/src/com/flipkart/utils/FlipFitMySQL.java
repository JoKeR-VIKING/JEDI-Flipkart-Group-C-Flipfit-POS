package com.flipkart.utils;

import java.sql.*;

public class FlipFitMySQL {

    public static final FlipFitMySQL flipFitSchema = new FlipFitMySQL();

    public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String CONNECTION_URL = FlipFitProperties.getProperty("db.url");
    public static final String USERNAME = FlipFitProperties.getProperty("db.user");
    public static final String PASSWORD = FlipFitProperties.getProperty("db.password");

    FlipFitMySQL() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> T execute(ConnectionHandler<T> executor) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            return executor.run(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public interface ConnectionHandler<T> {
        T run(Connection connection) throws SQLException;
    }
}
