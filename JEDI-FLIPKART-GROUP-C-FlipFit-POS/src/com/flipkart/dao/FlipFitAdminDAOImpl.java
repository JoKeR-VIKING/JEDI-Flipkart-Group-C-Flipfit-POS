package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constants.SQLQueryConstants.*;
import static com.flipkart.dao.FlipFitUserDAOImpl.FlipFitUserDAOInst;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitAdminDAOImpl implements FlipFitAdminDAOInterface {
    public static FlipFitAdminDAOImpl FlipFitAdminDAOInst = new FlipFitAdminDAOImpl();

    @Override
    public void add(FlipFitAdmin admin) {
        FlipFitUserDAOInst.add(admin);
    }

    @Override
    public void approveOwner(String gymOwnerId) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_OWNER_VERIFICATION);
            stmt.setString(1, "APPROVED");
            stmt.setString(2, gymOwnerId);

            return stmt.executeUpdate();
        });
    }

    @Override
    public void rejectOwner(String gymOwnerId) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_OWNER_VERIFICATION);
            stmt.setString(1, "REJECTED");
            stmt.setString(2, gymOwnerId);

            return stmt.executeUpdate();
        });
    }

    @Override
    public List<FlipFitGymOwner> getPendingOwners() {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_PENDING_OWNERS);

            ResultSet rs = stmt.executeQuery();
            List<FlipFitGymOwner> pendingOwners = new ArrayList<>();

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner(
                        rs.getString("ownerId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("gstNumber"),
                        rs.getString("panCardNumber")
                );

                pendingOwners.add(owner);
            }

            return pendingOwners;
        });
    }

    @Override
    public List<FlipFitGymOwner> getAllOwners() {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_OWNERS);

            ResultSet rs = stmt.executeQuery();
            List<FlipFitGymOwner> allOwners = new ArrayList<>();

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner(
                        rs.getString("ownerId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("gstNumber"),
                        rs.getString("panCardNumber"),
                        rs.getString("verified")
                );

                allOwners.add(owner);
            }

            return allOwners;
        });
    }

    @Override
    public void approveGym(String centreId) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_GYM_VERIFICATION);
            stmt.setString(1, "APPROVED");
            stmt.setString(2, centreId);

            return stmt.executeUpdate();
        });
    }

    @Override
    public void rejectGym(String centreId) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_GYM_VERIFICATION);
            stmt.setString(1, "REJECTED");
            stmt.setString(2, centreId);

            return stmt.executeUpdate();
        });
    }

    @Override
    public void removeGym(String centreId) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(DELETE_GYM);
            stmt.setString(1, centreId);

            return stmt.executeUpdate();
        });
    }

    @Override
    public List<FlipFitCentre> getPendingCentres() {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_PENDING_GYMS);

            ResultSet rs = stmt.executeQuery();
            List<FlipFitCentre> centres = new ArrayList<>();

            while (rs.next()) {
                FlipFitCentre centre = new FlipFitCentre(
                        rs.getString("centreId"),
                        rs.getString("centreName"),
                        rs.getString("centreAddress"),
                        rs.getString("centreId")
                );

                centres.add(centre);
            }

            return centres;
        });
    }

    @Override
    public List<FlipFitCentre> getAllCentres() {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_GYMS);

            ResultSet rs = stmt.executeQuery();
            List<FlipFitCentre> centres = new ArrayList<>();

            while (rs.next()) {
                FlipFitCentre centre = new FlipFitCentre(
                        rs.getString("centreId"),
                        rs.getString("centreName"),
                        rs.getString("centreAddress"),
                        rs.getString("centreId"),
                        rs.getString("verified")
                );

                centres.add(centre);
            }

            return centres;
        });
    }
}
