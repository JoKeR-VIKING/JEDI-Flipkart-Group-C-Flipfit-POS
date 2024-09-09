package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidUserException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.flipkart.constants.SQLQueryConstants.*;
import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitGymOwnerDAOImpl implements FlipFitGymOwnerDAOInterface {
    public static FlipFitGymOwnerDAOInterface FlipFitGymOwnerDAOInst = new FlipFitGymOwnerDAOImpl();

    @Override
    public void createProfile(FlipFitGymOwner gymOwner) throws ExistingUserException {
        FlipFitUserDAOInst.add(gymOwner);

        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_GYM_OWNER);
            stmt.setString(1, gymOwner.getUserId());
            stmt.setString(2, gymOwner.getGstNumber());
            stmt.setString(3, gymOwner.getPanCardNumber());
            stmt.setString(4, gymOwner.getVerified());

            return stmt.executeUpdate();
        });
    }

    @Override
    public void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber) throws InvalidUserException {
        FlipFitUserDAOInst.updateAddress(gymOwnerId, address);

        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_GYM_OWNER);
            stmt.setString(1, gstNumber);
            stmt.setString(2, panCardNumber);
            stmt.setString(3, gymOwnerId);

            return stmt.executeUpdate();
        });
    }

    @Override
    public boolean checkApproval(String userId) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_GYM_OWNER_BY_ID);
            stmt.setString(1, userId);

            ResultSet rs = stmt.executeQuery();
            rs.next();

            return rs.getString("verified").equals("APPROVED");
        });
    }
}