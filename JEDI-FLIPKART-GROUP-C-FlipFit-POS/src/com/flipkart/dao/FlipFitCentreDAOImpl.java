package com.flipkart.dao;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.UnauthorizedGymOwnerException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constants.SQLQueryConstants.*;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitCentreDAOImpl implements FlipFitCentreDAOInterface {
    public static FlipFitCentreDAOInterface FlipFitCentreDAOInst = new FlipFitCentreDAOImpl();

    @Override
    public FlipFitCentre getGymById(String gymId) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_GYM_BY_ID);
            stmt.setString(1, gymId);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return new FlipFitCentre(
                        rs.getString("centreId"),
                        rs.getString("centreName"),
                        rs.getString("centreAddress"),
                        rs.getString("gymOwnerId"),
                        rs.getString("verified")
                );
            }

            return null;
        });
    }

    @Override
    public void addGym(FlipFitCentre centre) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_GYM);
            stmt.setString(1, centre.getCentreId());
            stmt.setString(2, centre.getCentreName());
            stmt.setString(3, centre.getCentreAddress());
            stmt.setString(4, centre.getGymOwnerId());
            stmt.setString(5, centre.getVerified());

            return stmt.executeUpdate();
        });
    }

    @Override
    public void removeGym(String ownerId, String centreId) throws UnauthorizedGymOwnerException {
        int rowsAffected = flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(DELETE_GYM_WITH_OWNER);
            stmt.setString(1, centreId);
            stmt.setString(2, ownerId);

            return stmt.executeUpdate();
        });
        if(rowsAffected == 0){
            throw new UnauthorizedGymOwnerException();
        }
    }

    @Override
    public boolean modifyGym(String ownerId, String gymId, String gymName, String gymAddress) throws UnauthorizedGymOwnerException, InvalidGymException {
        if(FlipFitCentreDAOInst.getGymById(gymId) == null) {
            throw new InvalidGymException();
        }

        int result = flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_GYM);
            stmt.setString(1, gymName);
            stmt.setString(2, gymAddress);
            stmt.setString(3, ownerId);
            stmt.setString(4, gymId);

            return stmt.executeUpdate();
        });
        if(result == 0){
            throw new UnauthorizedGymOwnerException();
        }
        return result > 0;
    }

    @Override
    public List<FlipFitCentre> getRegisteredGymCentres(String ownerId) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_REGISTERED_GYMS);
            stmt.setString(1, ownerId);

            ResultSet rs = stmt.executeQuery();
            List<FlipFitCentre> centres = new ArrayList<>();

            while (rs.next()) {
                FlipFitCentre centre = new FlipFitCentre(
                        rs.getString("centreId"),
                        rs.getString("centreName"),
                        rs.getString("centreAddress"),
                        rs.getString("gymOwnerId"),
                        rs.getString("verified")
                );

                centres.add(centre);
            }

            return centres;
        });
    }
}
