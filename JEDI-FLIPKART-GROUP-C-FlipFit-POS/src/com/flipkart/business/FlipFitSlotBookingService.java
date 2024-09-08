package com.flipkart.business;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.enums.SlotBookingStatusEnum;
import com.flipkart.utils.Helper;

import java.time.LocalDate;
import java.util.List;

import static com.flipkart.dao.FlipFitSlotBookingDAOImpl.FlipFitSlotBookingDAOInst;

public class FlipFitSlotBookingService implements FlipFitSlotBookingInterface {
    @Override
    public void bookSlot(String userId, LocalDate bookingDate, FlipFitCenterSlot slot, String paymentId) {
        FlipFitSlotBooking booking = new FlipFitSlotBooking(Helper.generateId(), userId, slot.getSlotId(), bookingDate, LocalDate.now(), SlotBookingStatusEnum.CONFIRMED, paymentId);
        FlipFitSlotBookingDAOInst.addBooking(booking);
    }

    @Override
    public void cancelBooking(String bookingId) {
        FlipFitSlotBookingDAOInst.removeBooking(bookingId);
    }

    @Override
    public List<FlipFitSlotBooking> listBookings(String userId) {
        return FlipFitSlotBookingDAOInst.listBookingsByUserId(userId);
    }
}
