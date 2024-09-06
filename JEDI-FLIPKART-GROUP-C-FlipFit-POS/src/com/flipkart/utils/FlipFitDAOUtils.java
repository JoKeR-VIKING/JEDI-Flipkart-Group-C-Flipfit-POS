package com.flipkart.utils;

import com.flipkart.bean.*;
import com.flipkart.enums.SlotBookingStatusEnum;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static com.flipkart.dao.FlipFitAdminDAO.FlipFitAdminDAOInst;
import static com.flipkart.dao.FlipFitCustomerDAO.FlipFitCustomerDAOInst;
import static com.flipkart.dao.FlipFitGymOwnerDAO.FlipFitGymOwnerDAOInst;
import static com.flipkart.dao.FlipFitSlotBookingDAO.FlipFitSlotBookingDAOInst;

public class FlipFitDAOUtils {
    public static void initMockData() {
        // FlipFitCustomerDAO
        FlipFitCustomer customer1 = new FlipFitCustomer(Helper.generateId(), "user1", "password1", "John Doe", "123 Main St", "1234567890", 75.0, 30, "Male", LocalDate.of(1994, 1, 1));
        FlipFitCustomer customer2 = new FlipFitCustomer(Helper.generateId(), "user2", "password2", "Jane Smith", "456 Elm St", "9876543210", 60.0, 25, "Female", LocalDate.of(1999, 5, 15));
        FlipFitCustomer customer3 = new FlipFitCustomer(Helper.generateId(), "user3", "password3", "David Lee", "789 Oak St", "5555555555", 80.0, 35, "Male", LocalDate.of(1989, 10, 20));
        FlipFitCustomer customer4 = new FlipFitCustomer(Helper.generateId(), "user4", "password4", "Emily Brown", "101 Pine St", "4444444444", 70.0, 28, "Female", LocalDate.of(1996, 3, 5));
        FlipFitCustomer customer5 = new FlipFitCustomer(Helper.generateId(), "user5", "password5", "Alex Johnson", "202 Maple St", "3333333333", 72.0, 32, "Male", LocalDate.of(1992, 7, 18));

        FlipFitCustomerDAOInst.createProfile(customer1);
        FlipFitCustomerDAOInst.createProfile(customer2);
        FlipFitCustomerDAOInst.createProfile(customer3);
        FlipFitCustomerDAOInst.createProfile(customer4);
        FlipFitCustomerDAOInst.createProfile(customer5);

        // FlipFitGymOwnerDAO
        FlipFitGymOwner owner1 = new FlipFitGymOwner("1", "owner1", "password1", "John Smith", "123 Main St", "1234567890", "GST123456789", "PAN123456789");
        FlipFitGymOwner owner2 = new FlipFitGymOwner("2", "owner2", "password2", "Jane Doe", "456 Elm St", "9876543210", "GST234567890", "PAN234567890");
        FlipFitGymOwner owner3 = new FlipFitGymOwner("3", "owner3", "password3", "David Lee", "789 Oak St", "5555555555", "GST345678901", "PAN345678901");
        FlipFitGymOwner owner4 = new FlipFitGymOwner("4", "owner4", "password4", "Emily Brown", "101 Pine St", "4444444444", "GST456789012", "PAN456789012");
        FlipFitGymOwner owner5 = new FlipFitGymOwner("5", "owner5", "password5", "Alex Johnson", "202 Maple St", "3333333333", "GST567890123", "PAN567890123");

        FlipFitGymOwnerDAOInst.createProfile(owner1);
        FlipFitGymOwnerDAOInst.createProfile(owner2);
        FlipFitGymOwnerDAOInst.createProfile(owner3);
        FlipFitGymOwnerDAOInst.createProfile(owner4);
        FlipFitGymOwnerDAOInst.createProfile(owner5);

        FlipFitCentre centre1 = new FlipFitCentre("1", "FlipFit Centre 1", "123 Main St", "1", "APPROVED");
        FlipFitCentre centre2 = new FlipFitCentre("2", "FlipFit Centre 2", "456 Elm St", "2", "PENDING");
        FlipFitCentre centre3 = new FlipFitCentre("3", "FlipFit Centre 3", "789 Oak St", "3", "APPROVED");
        FlipFitCentre centre4 = new FlipFitCentre("4", "FlipFit Centre 4", "101 Pine St", "4", "APPROVED");
        FlipFitCentre centre5 = new FlipFitCentre("5", "FlipFit Centre 5", "202 Maple St", "5", "REJECTED");

        FlipFitGymOwnerDAOInst.addGym(centre1);
        FlipFitGymOwnerDAOInst.addGym(centre2);
        FlipFitGymOwnerDAOInst.addGym(centre3);
        FlipFitGymOwnerDAOInst.addGym(centre4);
        FlipFitGymOwnerDAOInst.addGym(centre5);

        FlipFitCenterSlot slot1 = new FlipFitCenterSlot("1", "1", LocalTime.of(9, 0), 10);
        FlipFitCenterSlot slot2 = new FlipFitCenterSlot("2", "1", LocalTime.of(10, 0), 15);
        FlipFitCenterSlot slot3 = new FlipFitCenterSlot("3", "2", LocalTime.of(11, 0), 8);
        FlipFitCenterSlot slot4 = new FlipFitCenterSlot("4", "2", LocalTime.of(12, 0), 12);
        FlipFitCenterSlot slot5 = new FlipFitCenterSlot("5", "3", LocalTime.of(13, 0), 10);

        FlipFitGymOwnerDAOInst.addSlot(slot1);
        FlipFitGymOwnerDAOInst.addSlot(slot2);
        FlipFitGymOwnerDAOInst.addSlot(slot3);
        FlipFitGymOwnerDAOInst.addSlot(slot4);
        FlipFitGymOwnerDAOInst.addSlot(slot5);

        // FlipFitSlotBookingDAO
        FlipFitAdmin admin1 = new FlipFitAdmin("admin1", "admin1", "password1", "Admin User", "Admin Address", "9999999999");
        FlipFitAdminDAOInst.add(admin1);

        // FlipFitSlotBookingDAO
        FlipFitPayments payment1 = new FlipFitPayments("1", "1", 100.0, LocalDate.now(), "Success");
        FlipFitPayments payment2 = new FlipFitPayments("2", "2", 80.0, LocalDate.now(), "Success");
        FlipFitPayments payment3 = new FlipFitPayments("3", "3", 90.0, LocalDate.now(), "Success");
        FlipFitPayments payment4 = new FlipFitPayments("4", "4", 75.0, LocalDate.now(), "Success");
        FlipFitPayments payment5 = new FlipFitPayments("5", "5", 120.0, LocalDate.now(), "Success");

        FlipFitSlotBookingDAOInst.addPayment(payment1);
        FlipFitSlotBookingDAOInst.addPayment(payment2);
        FlipFitSlotBookingDAOInst.addPayment(payment3);
        FlipFitSlotBookingDAOInst.addPayment(payment4);
        FlipFitSlotBookingDAOInst.addPayment(payment5);

        FlipFitSlotBooking booking1 = new FlipFitSlotBooking("1", "1", slot1.getSlotId(), LocalDate.now(), new Date(), SlotBookingStatusEnum.CONFIRMED, payment1.getPaymentId());
        FlipFitSlotBooking booking2 = new FlipFitSlotBooking("2", "2", slot2.getSlotId(), LocalDate.now(), new Date(), SlotBookingStatusEnum.CONFIRMED, payment2.getPaymentId());
        FlipFitSlotBooking booking3 = new FlipFitSlotBooking("3", "3", slot3.getSlotId(), LocalDate.now(), new Date(), SlotBookingStatusEnum.CONFIRMED, payment3.getPaymentId());
        FlipFitSlotBooking booking4 = new FlipFitSlotBooking("4", "4", slot4.getSlotId(), LocalDate.now(), new Date(), SlotBookingStatusEnum.CONFIRMED, payment4.getPaymentId());
        FlipFitSlotBooking booking5 = new FlipFitSlotBooking("5", "5", slot5.getSlotId(), LocalDate.now(), new Date(), SlotBookingStatusEnum.CONFIRMED, payment5.getPaymentId());

        FlipFitSlotBookingDAOInst.addBooking(booking1);
        FlipFitSlotBookingDAOInst.addBooking(booking2);
        FlipFitSlotBookingDAOInst.addBooking(booking3);
        FlipFitSlotBookingDAOInst.addBooking(booking4);
        FlipFitSlotBookingDAOInst.addBooking(booking5);
    }
}
