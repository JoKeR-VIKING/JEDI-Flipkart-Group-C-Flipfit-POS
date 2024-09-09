package com.flipkart.dao;

import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.exception.GymSlotAlreadyExistsException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FlipFitCenterSlotDAOInterface {

    FlipFitCenterSlot findSlotByCentreAndStartTime(String centreId, LocalTime startTime);

    void addSlot(FlipFitCenterSlot slot) throws GymSlotAlreadyExistsException;

    void updateSlot(String slotId, LocalTime startTime, Integer noOfSeats);

    List<FlipFitCenterSlot> getSlotsByGymId(String gymId);

    FlipFitCenterSlot getSlotById(String slotId);

    void deleteSlot(String slotId) ;

    List<FlipFitCenterSlot> getAvailableSlots(String gymId, LocalDate date);
}
