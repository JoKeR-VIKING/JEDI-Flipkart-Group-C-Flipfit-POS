package com.flipkart.utils;

import com.flipkart.exception.InvalidUserException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing MySQL database connections and operations.
 */
public class FlipFitMySQL {

    /**
     * Singleton instance of the {@code FlipFitMySQL} class.
     */
    public static final FlipFitMySQL flipFitSchema = new FlipFitMySQL();

    /**
     * JDBC driver class name for MySQL.
     */
    public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * Database connection URL.
     */
    public static final String CONNECTION_URL = FlipFitProperties.getProperty("db.url");

    /**
     * Database username.
     */
    public static final String USERNAME = FlipFitProperties.getProperty("db.user");

    /**
     * Database password.
     */
    public static final String PASSWORD = FlipFitProperties.getProperty("db.password");

    /**
     * Private constructor to initialize the MySQL driver.
     * This constructor is called when the singleton instance is created.
     */
    FlipFitMySQL() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes a database operation defined by the {@code ConnectionHandler} callback.
     *
     * @param <T> The type of result returned by the operation.
     * @param executor The callback that defines the database operation to be performed.
     * @return The result of the database operation, or {@code null} if an exception occurs.
     */
    public <T> T execute(ConnectionHandler<T> executor) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD)) {
            return executor.run(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Functional interface for handling database operations.
     *
     * @param <T> The type of result returned by the operation.
     */
    public interface ConnectionHandler<T> {
        /**
         * Executes the database operation using the provided {@code Connection}.
         *
         * @param connection The database connection to use for the operation.
         * @return The result of the operation.
         * @throws SQLException If a database access error occurs.
         */
        T run(Connection connection) throws SQLException, InvalidUserException;
    }
}
