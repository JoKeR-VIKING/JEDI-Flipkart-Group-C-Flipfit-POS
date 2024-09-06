package com.flipkart.dao;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.enums.RoleEnum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constants.SQLQueryConstants.*;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitUserDAOImpl implements FlipFitUserDAOInterface {
    public static FlipFitUserDAOImpl FlipFitUserDAOInst = new FlipFitUserDAOImpl();

    // TODO: remove this after completing gym owner and customer and admin
    public List<FlipFitUser> USERS = new ArrayList<>();

    public FlipFitUser findByUsername(String username) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_USERNAME);
            stmt.setString(1, username);

            ResultSet data = stmt.executeQuery();
            if (data.next()) {
                return new FlipFitUser(
                        data.getString(1),
                        data.getString(2),
                        data.getString(3),
                        data.getString(4),
                        data.getString(5),
                        data.getString(6),
                        RoleEnum.fromValue(data.getInt(7))
                );
            }

            return null;
        });
    }

    public void updatePassword(String userId, String password) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_USER_PASSWORD_BY_USERID);
            stmt.setString(1, password);
            stmt.setString(2, userId);
            return stmt.executeUpdate();
        });
    }

    public void add(FlipFitUser user) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_USER);
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getName());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getPhoneNumber());
            stmt.setInt(7, user.getRole().ordinal());

            return stmt.executeUpdate();
        });
    }
}
