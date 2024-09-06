package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.enums.SlotBookingStatusEnum;
import com.flipkart.utils.Helper;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import static com.flipkart.dao.FlipFitSlotBookingDAO.FlipFitSlotBookingDAOInst;

public class FlipFitSlotBookingService implements  FlipFitSlotBookingInterface {
    @Override
    public void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId) {
        FlipFitSlotBooking booking = new FlipFitSlotBooking(Helper.generateId(), userId, slot.getSlotId(), bookingDate, Date.from(Instant.now()), SlotBookingStatusEnum.CONFIRMED, paymentId);
        FlipFitSlotBookingDAOInst.addBooking(booking);
    }

    @Override
    public void cancelBooking(String bookingId) {
        FlipFitSlotBookingDAOInst.removeBooking(bookingId);
    }

    @Override
    public List<FlipFitSlotBooking> listBookings(String userId) {
        return FlipFitSlotBookingDAOInst.listBookings(userId);
    }
}
