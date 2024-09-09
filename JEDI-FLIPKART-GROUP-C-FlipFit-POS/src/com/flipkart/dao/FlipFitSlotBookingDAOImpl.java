package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.enums.SlotBookingStatusEnum;
import com.flipkart.exception.GymSlotSeatLimitReachedException;
import com.flipkart.exception.InvalidBookingException;
import com.flipkart.exception.InvalidSlotException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.constants.SQLQueryConstants.*;
import static com.flipkart.dao.FlipFitCenterSlotDAOImpl.FlipFitCenterSlotDAOInst;
import static com.flipkart.utils.FlipFitMySQL.flipFitSchema;

public class FlipFitSlotBookingDAOImpl implements FlipFitSlotBookingDAOInterface {
    public static FlipFitSlotBookingDAOInterface FlipFitSlotBookingDAOInst = new FlipFitSlotBookingDAOImpl();

    @Override
    public int getBookingCountBySlotId(String slotId) throws InvalidSlotException {
        int bookings = flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_SLOT_BOOKINGS_COUNT_BY_SLOT_ID);
            stmt.setString(1, slotId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return -1;
        });

        if (bookings == -1) {
            throw new InvalidSlotException();
        }

        return bookings;
    }

    @Override
    public void addBooking(FlipFitSlotBooking booking) throws InvalidSlotException, GymSlotSeatLimitReachedException {
        int bookingCount = getBookingCountBySlotId(booking.getCenterSlot());

        if (bookingCount >= FlipFitCenterSlotDAOInst.findSlotBySlotId(booking.getCenterSlot()).getSeatLimit()) {
            throw new GymSlotSeatLimitReachedException();
        }

        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_SLOT_BOOKING);
            stmt.setString(1, booking.getBookingId());
            stmt.setString(2, booking.getUserId());
            stmt.setString(3, booking.getCenterSlot());
            stmt.setDate(4, Date.valueOf(booking.getSlotDate()));
            stmt.setDate(5, Date.valueOf(booking.getBookingDate()));
            stmt.setString(6, booking.getStatus().name());
            stmt.setString(7, booking.getPaymentId());

            return stmt.executeUpdate();
        });
    }

    @Override
    public boolean addPayment(FlipFitPayments payment) {
        if (!"Success".equals(payment.getStatus())) return false;

        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(INSERT_PAYMENT);
            stmt.setString(1, payment.getPaymentId());
            stmt.setString(2, payment.getCustomerId());
            stmt.setDouble(3, payment.getAmount());
            stmt.setDate(4, Date.valueOf(payment.getDate()));
            stmt.setString(5, payment.getCardNumber());
            stmt.setString(6, payment.getCvv());
            stmt.setString(7, payment.getCardExpiry().toString());
            stmt.setString(8, payment.getStatus());

            return stmt.executeUpdate();
        });

        return true;
    }

    @Override
    public void removeBooking(String bookingId) throws InvalidBookingException {
        int rowsAffected = flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(DELETE_SLOT_BOOKING);
            stmt.setString(1, bookingId);

            return stmt.executeUpdate();
        });

        if (rowsAffected == 0) {
            throw new InvalidBookingException();
        }
    }

    @Override
    public void removePreviousBooking(String userId, LocalDate slotDate) {
        flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(DELETE_PREVIOUS_SLOT_BOOKING);
            stmt.setString(1, userId);
            stmt.setDate(2, Date.valueOf(slotDate));

            return stmt.executeUpdate();
        });
    }

    @Override
    public List<FlipFitSlotBooking> listBookingsByUserId(String userId) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_SLOT_BOOKING_BY_USER_ID);
            stmt.setString(1, userId);

            ResultSet rs = stmt.executeQuery();
            List<FlipFitSlotBooking> bookings = new ArrayList<>();

            while (rs.next()) {
                bookings.add(
                        new FlipFitSlotBooking(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDate(4).toLocalDate(),
                                rs.getDate(5).toLocalDate(),
                                SlotBookingStatusEnum.fromName(rs.getString(6)),
                                rs.getString(7)
                        )
                );
            }

            return bookings;
        });
    }

    @Override
    public List<FlipFitSlotBooking> getAllBookingsByGymIdAndDate(String gymId, LocalDate date) {
        return flipFitSchema.execute(conn -> {
            PreparedStatement stmt = conn.prepareStatement(SELECT_SLOT_BOOKINGS_BY_GYM_ID_AND_DATE);
            stmt.setString(1, gymId);
            stmt.setDate(2, Date.valueOf(date));

            ResultSet rs = stmt.executeQuery();
            List<FlipFitSlotBooking> bookings = new ArrayList<>();

            while (rs.next()) {
                bookings.add(new FlipFitSlotBooking(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate(),
                        rs.getDate(5).toLocalDate(),
                        SlotBookingStatusEnum.fromName(rs.getString(6)),
                        rs.getString(7)
                ));
            }

            return bookings;
        });
    }
}
