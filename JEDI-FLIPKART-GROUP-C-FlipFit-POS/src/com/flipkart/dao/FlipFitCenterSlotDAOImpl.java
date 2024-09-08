package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenterSlot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constants.SQLQueryConstants.*;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitCenterSlotDAOImpl implements FlipFitCenterSlotDAOInterface {

    public static final FlipFitCenterSlotDAOInterface FlipFitCenterSlotDAOInst = new FlipFitCenterSlotDAOImpl();

    @Override
    public void addSlot(FlipFitCenterSlot slot) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_GYM_SLOT);
            stmt.setString(1, slot.getSlotId());
            stmt.setString(2, slot.getCentreId());
            stmt.setTime(3, Time.valueOf(slot.getStartTime()));
            stmt.setInt(4, slot.getSeatLimit());

            return stmt.executeUpdate();
        });
    }

    @Override
    public void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_GYM_SLOT);
            stmt.setString(1, slotId);
            stmt.setObject(2, startTime);
            stmt.setInt(2, noOfSeats);

            return stmt.executeUpdate();
        });
    }

    @Override
    public List<FlipFitCenterSlot> getSlotsByGymId(String gymId) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(GET_GYM_SLOTS_BY_GYM_ID);
            stmt.setString(1, gymId);

            List<FlipFitCenterSlot> slots = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                slots.add(
                        new FlipFitCenterSlot(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getTime(3).toLocalTime(),
                                rs.getInt(4)
                        )
                );
            }

            return slots;
        });
    }

    @Override
    public FlipFitCenterSlot getSlotById(String slotId) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(GET_GYM_SLOT_BY_ID);
            stmt.setString(1, slotId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new FlipFitCenterSlot(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getTime(3).toLocalTime(),
                        rs.getInt(4)
                );
            }

            return null;
        });
    }

    @Override
    public void deleteSlot(String slotId) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(DELETE_GYM_SLOT);
            stmt.setString(1, slotId);
            return stmt.executeUpdate();
        });
    }
}
