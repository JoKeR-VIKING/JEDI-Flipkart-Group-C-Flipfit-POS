package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitPayments;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.dao.FlipFitSlotBookingDAO;
import com.flipkart.enums.SlotBookingStatusEnum;
import com.flipkart.utils.Helper;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class FlipFitSlotBookingService implements  FlipFitSlotBookingInterface {
    @Override
    public void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId) {
        FlipFitSlotBooking booking = new FlipFitSlotBooking(Helper.generateId(), userId, slot.getSlotId(), bookingDate, Date.from(Instant.now()), SlotBookingStatusEnum.CONFIRMED, paymentId);
        FlipFitSlotBookingDAO.addBooking(booking);
    }

    @Override
    public void cancelBooking(String bookingId) {
        FlipFitSlotBookingDAO.removeBooking(bookingId);
    }

    @Override
    public List<FlipFitSlotBooking> listBookings(String userId) {
        return FlipFitSlotBookingDAO.listBookings(userId);
    }

    public void makePayment(FlipFitPayments payment) {
        FlipFitSlotBookingDAO.addPayment(payment);
    }
}
