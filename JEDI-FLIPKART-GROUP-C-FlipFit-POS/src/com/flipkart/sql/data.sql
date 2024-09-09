-- Insert Users
INSERT INTO `FlipFitUser` (`userId`, `username`, `password`, `name`, `address`, `phoneNumber`, `role`) VALUES
-- Admin Users
('admin1', 'adminuser1', 'adminpass1', 'Admin One', '123 Admin Rd', '1111111111', 2),
('admin2', 'adminuser2', 'adminpass2', 'Admin Two', '456 Admin Rd', '1111111112', 2),

-- Gym Owner Users
('owner1', 'owneruser1', 'ownerpass1', 'Owner One', '789 Owner Rd', '1111111113', 0),
('owner2', 'owneruser2', 'ownerpass2', 'Owner Two', '101 Owner Rd', '1111111114', 0),
('owner3', 'owneruser3', 'ownerpass3', 'Owner Three', '102 Owner Rd', '1111111115', 0),
('owner4', 'owneruser4', 'ownerpass4', 'Owner Four', '103 Owner Rd', '1111111116', 0),
('owner5', 'owneruser5', 'ownerpass5', 'Owner Five', '104 Owner Rd', '1111111117', 0),

-- Customer Users
('cust1', 'custuser1', 'custpass1', 'Customer One', '789 Customer Rd', '1111111118', 1),
('cust2', 'custuser2', 'custpass2', 'Customer Two', '101 Customer Rd', '1111111119', 1),
('cust3', 'custuser3', 'custpass3', 'Customer Three', '102 Customer Rd', '1111111120', 1),
('cust4', 'custuser4', 'custpass4', 'Customer Four', '103 Customer Rd', '1111111121', 1),
('cust5', 'custuser5', 'custpass5', 'Customer Five', '104 Customer Rd', '1111111122', 1);

-- Insert Gym Owners
INSERT INTO `FlipFitGymOwner` (`ownerId`, `gstNumber`, `panCardNumber`, `verified`) VALUES
('owner1', 'GST123456789', 'PAN00001', 'APPROVED'),
('owner2', 'GST987654321', 'PAN00002', 'REJECTED'),
('owner3', 'GST234567890', 'PAN00003', 'PENDING'),
('owner4', 'GST345678901', 'PAN00004', 'APPROVED'),
('owner5', 'GST456789012', 'PAN00005', 'PENDING');

-- Insert Admins
INSERT INTO `FlipFitAdmin` (`userId`) VALUES
('admin1'),
('admin2');



-- Insert Customers
INSERT INTO `FlipFitCustomer` (`weight`, `age`, `gender`, `dob`, `customerId`) VALUES
(70.0, 25, 'Male', '1999-05-15 00:00:00', 'cust1'),
(65.0, 30, 'Female', '1994-11-20 00:00:00', 'cust2'),
(80.0, 22, 'Male', '2002-03-30 00:00:00', 'cust3'),
(55.0, 28, 'Female', '1996-07-22 00:00:00', 'cust4'),
(90.0, 35, 'Male', '1988-12-12 00:00:00', 'cust5');

-- Insert Gym Centers with `city` set to 'Bangalore'
INSERT INTO `FlipFitCentre` (`centreId`, `centreName`, `centreAddress`, `gymOwnerId`, `verified`, `city`) VALUES
-- Centers for owner1
('centre1', 'Fit Gym A', '123 Fit St', 'owner1', 'APPROVED', 'Bangalore'),
('centre6', 'Fit Gym F', '103 Fit St', 'owner1', 'APPROVED', 'Bangalore'),

-- Centers for owner2
('centre2', 'Fit Gym B', '456 Fit St', 'owner2', 'REJECTED', 'Bangalore'),
('centre7', 'Fit Gym G', '104 Fit St', 'owner2', 'REJECTED', 'Bangalore'),

-- Centers for owner3
('centre3', 'Fit Gym C', '789 Fit St', 'owner3', 'PENDING', 'Bangalore'),
('centre8', 'Fit Gym H', '105 Fit St', 'owner3', 'PENDING', 'Bangalore'),

-- Centers for owner4
('centre4', 'Fit Gym D', '101 Fit St', 'owner4', 'APPROVED', 'Bangalore'),
('centre9', 'Fit Gym I', '106 Fit St', 'owner4', 'APPROVED', 'Bangalore'),

-- Centers for owner5
('centre5', 'Fit Gym E', '102 Fit St', 'owner5', 'PENDING', 'Bangalore'),
('centre10', 'Fit Gym J', '107 Fit St', 'owner5', 'PENDING', 'Bangalore');

-- Insert Slots
INSERT INTO `FlipFitCenterSlot` (`slotId`, `centreId`, `startTime`, `seatLimit`) VALUES
-- Slots for centre1
('slot1', 'centre1', '08:00:00', 3),
('slot2', 'centre1', '10:00:00', 4),
('slot3', 'centre1', '12:00:00', 5),

-- Slots for centre2
('slot4', 'centre2', '09:00:00', 4),
('slot5', 'centre2', '11:00:00', 3),
('slot6', 'centre2', '13:00:00', 5),

-- Slots for centre3
('slot7', 'centre3', '07:00:00', 5),
('slot8', 'centre3', '09:00:00', 3),
('slot9', 'centre3', '11:00:00', 4),

-- Slots for centre4
('slot10', 'centre4', '08:00:00', 4),
('slot11', 'centre4', '10:00:00', 3),
('slot12', 'centre4', '12:00:00', 5),

-- Slots for centre5
('slot13', 'centre5', '09:00:00', 5),
('slot14', 'centre5', '11:00:00', 4),
('slot15', 'centre5', '13:00:00', 3),

-- Slots for centre6
('slot16', 'centre6', '07:00:00', 4),
('slot17', 'centre6', '09:00:00', 3),
('slot18', 'centre6', '11:00:00', 5),

-- Slots for centre7
('slot19', 'centre7', '08:00:00', 3),
('slot20', 'centre7', '10:00:00', 4),
('slot21', 'centre7', '12:00:00', 3),

-- Slots for centre8
('slot22', 'centre8', '09:00:00', 4),
('slot23', 'centre8', '11:00:00', 5),
('slot24', 'centre8', '13:00:00', 3),

-- Slots for centre9
('slot25', 'centre9', '07:00:00', 5),
('slot26', 'centre9', '09:00:00', 4),
('slot27', 'centre9', '11:00:00', 3),

-- Slots for centre10
('slot28', 'centre10', '08:00:00', 4),
('slot29', 'centre10', '10:00:00', 3),
('slot30', 'centre10', '12:00:00', 5);

-- Insert Payments with card details
INSERT INTO `FlipFitPayments` (`paymentId`, `customerId`, `amount`, `date`, `cardNumber`, `cvv`, `cardExpiry`, `status`) VALUES
-- Payments for booking1 to booking5 (slot1 and slot2 at centre1)
('payment1', 'cust1', 100.00, '2024-09-01 10:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment2', 'cust2', 100.00, '2024-09-02 11:00:00', '4222222222222222', '456', '11/24', 'Completed'),
('payment3', 'cust3', 100.00, '2024-09-01 12:00:00', '4333333333333333', '789', '10/23', 'Completed'),
('payment4', 'cust4', 100.00, '2024-09-02 13:00:00', '4444444444444444', '012', '09/22', 'Completed'),
('payment5', 'cust5', 100.00, '2024-09-03 14:00:00', '5555555555555555', '345', '08/21', 'Completed'),

-- Payments for booking6 to booking8 (slot3 at centre1)
('payment6', 'cust1', 100.00, '2024-09-01 16:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment7', 'cust2', 100.00, '2024-09-02 17:00:00', '4222222222222222', '456', '11/24', 'Completed'),
('payment8', 'cust3', 100.00, '2024-09-03 18:00:00', '4333333333333333', '789', '10/23', 'Completed'),

-- Payments for booking9 to booking10 (slot4 at centre2)
('payment9', 'cust4', 100.00, '2024-09-01 19:00:00', '4444444444444444', '012', '09/22', 'Completed'),
('payment10', 'cust5', 100.00, '2024-09-02 20:00:00', '5555555555555555', '345', '08/21', 'Completed'),

-- Payments for booking11 to booking12 (slot5 at centre2)
('payment11', 'cust1', 100.00, '2024-09-01 21:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment12', 'cust2', 100.00, '2024-09-02 22:00:00', '4222222222222222', '456', '11/24', 'Completed'),

-- Payments for booking13 to booking14 (slot6 at centre2)
('payment13', 'cust3', 100.00, '2024-09-01 23:00:00', '4333333333333333', '789', '10/23', 'Completed'),
('payment14', 'cust4', 100.00, '2024-09-02 01:00:00', '4444444444444444', '012', '09/22', 'Completed'),

-- Payments for booking15 to booking16 (slot7 at centre3)
('payment15', 'cust1', 100.00, '2024-09-01 22:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment16', 'cust2', 100.00, '2024-09-02 23:00:00', '4222222222222222', '456', '11/24', 'Completed'),

-- Payments for booking17 to booking18 (slot8 at centre3)
('payment17', 'cust3', 100.00, '2024-09-01 00:00:00', '4333333333333333', '789', '10/23', 'Completed'),
('payment18', 'cust4', 100.00, '2024-09-02 01:00:00', '4444444444444444', '012', '09/22', 'Completed'),

-- Payments for booking19 to booking20 (slot9 at centre3)
('payment19', 'cust5', 100.00, '2024-09-01 02:00:00', '5555555555555555', '345', '08/21', 'Completed'),
('payment20', 'cust1', 100.00, '2024-09-02 03:00:00', '4111111111111111', '123', '12/25', 'Completed'),

-- Payments for booking21 to booking22 (slot10 at centre4)
('payment21', 'cust2', 100.00, '2024-09-01 04:00:00', '4222222222222222', '456', '11/24', 'Completed'),
('payment22', 'cust3', 100.00, '2024-09-02 05:00:00', '4333333333333333', '789', '10/23', 'Completed'),

-- Payments for booking23 to booking24 (slot11 at centre4)
('payment23', 'cust4', 100.00, '2024-09-01 06:00:00', '4444444444444444', '012', '09/22', 'Completed'),
('payment24', 'cust5', 100.00, '2024-09-02 07:00:00', '5555555555555555', '345', '08/21', 'Completed'),

-- Payments for booking25 to booking26 (slot12 at centre4)
('payment25', 'cust1', 100.00, '2024-09-01 08:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment26', 'cust2', 100.00, '2024-09-02 09:00:00', '4222222222222222', '456', '11/24', 'Completed'),

-- Payments for booking27 to booking28 (slot13 at centre5)
('payment27', 'cust3', 100.00, '2024-09-01 10:00:00', '4333333333333333', '789', '10/23', 'Completed'),
('payment28', 'cust4', 100.00, '2024-09-02 11:00:00', '4444444444444444', '012', '09/22', 'Completed'),

-- Payments for booking29 to booking30 (slot14 at centre5)
('payment29', 'cust5', 100.00, '2024-09-01 12:00:00', '5555555555555555', '345', '08/21', 'Completed'),
('payment30', 'cust1', 100.00, '2024-09-02 13:00:00', '4111111111111111', '123', '12/25', 'Completed'),

-- Payments for booking31 to booking32 (slot15 at centre5)
('payment31', 'cust2', 100.00, '2024-09-01 14:00:00', '4222222222222222', '456', '11/24', 'Completed'),
('payment32', 'cust3', 100.00, '2024-09-02 15:00:00', '4333333333333333', '789', '10/23', 'Completed'),

-- Payments for booking33 to booking34 (slot16 at centre6)
('payment33', 'cust4', 100.00, '2024-09-01 16:00:00', '4444444444444444', '012', '09/22', 'Completed'),
('payment34', 'cust5', 100.00, '2024-09-02 17:00:00', '5555555555555555', '345', '08/21', 'Completed'),

-- Payments for booking35 to booking36 (slot17 at centre6)
('payment35', 'cust1', 100.00, '2024-09-01 18:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment36', 'cust2', 100.00, '2024-09-02 19:00:00', '4222222222222222', '456', '11/24', 'Completed'),

-- Payments for booking37 to booking38 (slot18 at centre6)
('payment37', 'cust3', 100.00, '2024-09-01 20:00:00', '4333333333333333', '789', '10/23', 'Completed'),
('payment38', 'cust4', 100.00, '2024-09-02 21:00:00', '4444444444444444', '012', '09/22', 'Completed'),

-- Payments for booking39 to booking40 (slot19 at centre7)
('payment39', 'cust5', 100.00, '2024-09-01 22:00:00', '5555555555555555', '345', '08/21', 'Completed'),
('payment40', 'cust1', 100.00, '2024-09-02 23:00:00', '4111111111111111', '123', '12/25', 'Completed'),

-- Payments for booking41 to booking42 (slot20 at centre7)
('payment41', 'cust2', 100.00, '2024-09-01 00:00:00', '4222222222222222', '456', '11/24', 'Completed'),
('payment42', 'cust3', 100.00, '2024-09-02 01:00:00', '4333333333333333', '789', '10/23', 'Completed'),

-- Payments for booking43 to booking44 (slot21 at centre7)
('payment43', 'cust4', 100.00, '2024-09-01 02:00:00', '4444444444444444', '012', '09/22', 'Completed'),
('payment44', 'cust5', 100.00, '2024-09-02 03:00:00', '5555555555555555', '345', '08/21', 'Completed'),

-- Payments for booking45 to booking46 (slot22 at centre8)
('payment45', 'cust1', 100.00, '2024-09-01 04:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment46', 'cust2', 100.00, '2024-09-02 05:00:00', '4222222222222222', '456', '11/24', 'Completed'),

-- Payments for booking47 to booking48 (slot23 at centre8)
('payment47', 'cust3', 100.00, '2024-09-01 06:00:00', '4333333333333333', '789', '10/23', 'Completed'),
('payment48', 'cust4', 100.00, '2024-09-02 07:00:00', '4444444444444444', '012', '09/22', 'Completed'),

-- Payments for booking49 to booking50 (slot24 at centre8)
('payment49', 'cust5', 100.00, '2024-09-01 08:00:00', '5555555555555555', '345', '08/21', 'Completed'),
('payment50', 'cust1', 100.00, '2024-09-02 09:00:00', '4111111111111111', '123', '12/25', 'Completed'),

-- Payments for booking51 to booking52 (slot25 at centre9)
('payment51', 'cust2', 100.00, '2024-09-01 10:00:00', '4222222222222222', '456', '11/24', 'Completed'),
('payment52', 'cust3', 100.00, '2024-09-02 11:00:00', '4333333333333333', '789', '10/23', 'Completed'),

-- Payments for booking53 to booking54 (slot26 at centre9)
('payment53', 'cust4', 100.00, '2024-09-01 12:00:00', '4444444444444444', '012', '09/22', 'Completed'),
('payment54', 'cust5', 100.00, '2024-09-02 13:00:00', '5555555555555555', '345', '08/21', 'Completed'),

-- Payments for booking55 to booking56 (slot27 at centre9)
('payment55', 'cust1', 100.00, '2024-09-01 14:00:00', '4111111111111111', '123', '12/25', 'Completed'),
('payment56', 'cust2', 100.00, '2024-09-02 15:00:00', '4222222222222222', '456', '11/24', 'Completed'),

-- Payments for booking57 to booking58 (slot28 at centre10)
('payment57', 'cust3', 100.00, '2024-09-01 16:00:00', '4333333333333333', '789', '10/23', 'Completed'),
('payment58', 'cust4', 100.00, '2024-09-02 17:00:00', '4444444444444444', '012', '09/22', 'Completed'),

-- Payments for booking59 to booking60 (slot29 at centre10)
('payment59', 'cust5', 100.00, '2024-09-01 18:00:00', '5555555555555555', '345', '08/21', 'Completed'),
('payment60', 'cust1', 100.00, '2024-09-02 19:00:00', '4111111111111111', '123', '12/25', 'Completed'),

-- Payments for booking61 to booking62 (slot30 at centre10)
('payment61', 'cust2', 100.00, '2024-09-01 20:00:00', '4222222222222222', '456', '11/24', 'Completed'),
('payment62', 'cust3', 100.00, '2024-09-02 21:00:00', '4333333333333333', '789', '10/23', 'Completed');




-- Insert Bookings
INSERT INTO `FlipFitSlotBooking` (`bookingId`, `userId`, `centreSlotId`, `slotDate`, `bookingDate`, `status`, `paymentId`) VALUES
-- Bookings for slot1 (centre1)
('booking1', 'cust1', 'slot1', '2024-09-08 08:00:00', '2024-09-01 10:00:00', '0', 'payment1'),
('booking2', 'cust2', 'slot1', '2024-09-09 08:00:00', '2024-09-02 11:00:00', '0', 'payment2'),

-- Bookings for slot2 (centre1)
('booking3', 'cust3', 'slot2', '2024-09-08 10:00:00', '2024-09-01 12:00:00', '0', 'payment3'),
('booking4', 'cust4', 'slot2', '2024-09-09 10:00:00', '2024-09-02 13:00:00', '0', 'payment4'),
('booking5', 'cust5', 'slot2', '2024-09-10 10:00:00', '2024-09-03 14:00:00', '1', 'payment5'),

-- Bookings for slot3 (centre1)
('booking6', 'cust1', 'slot3', '2024-09-08 12:00:00', '2024-09-01 16:00:00', '0', 'payment6'),
('booking7', 'cust2', 'slot3', '2024-09-09 12:00:00', '2024-09-02 17:00:00', '0', 'payment7'),
('booking8', 'cust3', 'slot3', '2024-09-10 12:00:00', '2024-09-03 18:00:00', '1', 'payment8'),

-- Bookings for slot4 (centre2)
('booking9', 'cust4', 'slot4', '2024-09-08 09:00:00', '2024-09-01 19:00:00', '0', 'payment9'),
('booking10', 'cust5', 'slot4', '2024-09-09 09:00:00', '2024-09-02 20:00:00', '0', 'payment10'),

-- Bookings for slot5 (centre2)
('booking11', 'cust1', 'slot5', '2024-09-08 11:00:00', '2024-09-01 21:00:00', '0', 'payment11'),
('booking12', 'cust2', 'slot5', '2024-09-09 11:00:00', '2024-09-02 22:00:00', '1', 'payment12'),

-- Bookings for slot6 (centre2)
('booking13', 'cust3', 'slot6', '2024-09-08 13:00:00', '2024-09-01 23:00:00', '0', 'payment13'),
('booking14', 'cust4', 'slot6', '2024-09-09 13:00:00', '2024-09-02 01:00:00', '0', 'payment14'),

-- Bookings for slot7 (centre3)
('booking15', 'cust1', 'slot7', '2024-09-08 07:00:00', '2024-09-01 22:00:00', '0', 'payment15'),
('booking16', 'cust2', 'slot7', '2024-09-09 07:00:00', '2024-09-02 23:00:00', '0', 'payment16'),

-- Bookings for slot8 (centre3)
('booking17', 'cust3', 'slot8', '2024-09-08 09:00:00', '2024-09-01 00:00:00', '0', 'payment17'),
('booking18', 'cust4', 'slot8', '2024-09-09 09:00:00', '2024-09-02 01:00:00', '1', 'payment18'),

-- Bookings for slot9 (centre3)
('booking19', 'cust5', 'slot9', '2024-09-08 11:00:00', '2024-09-01 02:00:00', '0', 'payment19'),
('booking20', 'cust1', 'slot9', '2024-09-09 11:00:00', '2024-09-02 03:00:00', '0', 'payment20'),

-- Bookings for slot10 (centre4)
('booking21', 'cust2', 'slot10', '2024-09-08 08:00:00', '2024-09-01 04:00:00', '0', 'payment21'),
('booking22', 'cust3', 'slot10', '2024-09-09 08:00:00', '2024-09-02 05:00:00', '1', 'payment22'),

-- Bookings for slot11 (centre4)
('booking23', 'cust4', 'slot11', '2024-09-08 10:00:00', '2024-09-01 06:00:00', '0', 'payment23'),
('booking24', 'cust5', 'slot11', '2024-09-09 10:00:00', '2024-09-02 07:00:00', '0', 'payment24'),

-- Bookings for slot12 (centre4)
('booking25', 'cust1', 'slot12', '2024-09-08 12:00:00', '2024-09-01 08:00:00', '0', 'payment25'),
('booking26', 'cust2', 'slot12', '2024-09-09 12:00:00', '2024-09-02 09:00:00', '0', 'payment26'),

-- Bookings for slot13 (centre5)
('booking27', 'cust3', 'slot13', '2024-09-08 09:00:00', '2024-09-01 10:00:00', '0', 'payment27'),
('booking28', 'cust4', 'slot13', '2024-09-09 09:00:00', '2024-09-02 11:00:00', '1', 'payment28'),

-- Bookings for slot14 (centre5)
('booking29', 'cust5', 'slot14', '2024-09-08 11:00:00', '2024-09-01 12:00:00', '0', 'payment29'),
('booking30', 'cust1', 'slot14', '2024-09-09 11:00:00', '2024-09-02 13:00:00', '0', 'payment30'),

-- Bookings for slot15 (centre5)
('booking31', 'cust2', 'slot15', '2024-09-08 13:00:00', '2024-09-01 14:00:00', '0', 'payment31'),
('booking32', 'cust3', 'slot15', '2024-09-09 13:00:00', '2024-09-02 15:00:00', '1', 'payment32'),

-- Bookings for slot16 (centre6)
('booking33', 'cust4', 'slot16', '2024-09-08 07:00:00', '2024-09-01 16:00:00', '0', 'payment33'),
('booking34', 'cust5', 'slot16', '2024-09-09 07:00:00', '2024-09-02 17:00:00', '0', 'payment34'),

-- Bookings for slot17 (centre6)
('booking35', 'cust1', 'slot17', '2024-09-08 09:00:00', '2024-09-01 18:00:00', '0', 'payment35'),
('booking36', 'cust2', 'slot17', '2024-09-09 09:00:00', '2024-09-02 19:00:00', '1', 'payment36'),

-- Bookings for slot18 (centre6)
('booking37', 'cust3', 'slot18', '2024-09-08 11:00:00', '2024-09-01 20:00:00', '0', 'payment37'),
('booking38', 'cust4', 'slot18', '2024-09-09 11:00:00', '2024-09-02 21:00:00', '0', 'payment38'),

-- Bookings for slot19 (centre7)
('booking39', 'cust5', 'slot19', '2024-09-08 08:00:00', '2024-09-01 22:00:00', '0', 'payment39'),
('booking40', 'cust1', 'slot19', '2024-09-09 08:00:00', '2024-09-02 23:00:00', '0', 'payment40'),

-- Bookings for slot20 (centre7)
('booking41', 'cust2', 'slot20', '2024-09-08 10:00:00', '2024-09-01 00:00:00', '0', 'payment41'),
('booking42', 'cust3', 'slot20', '2024-09-09 10:00:00', '2024-09-02 01:00:00', '1', 'payment42'),

-- Bookings for slot21 (centre7)
('booking43', 'cust4', 'slot21', '2024-09-08 12:00:00', '2024-09-01 02:00:00', '0', 'payment43'),
('booking44', 'cust5', 'slot21', '2024-09-09 12:00:00', '2024-09-02 03:00:00', '1', 'payment44'),

-- Bookings for slot22 (centre8)
('booking45', 'cust1', 'slot22', '2024-09-08 09:00:00', '2024-09-01 04:00:00', '0', 'payment45'),
('booking46', 'cust2', 'slot22', '2024-09-09 09:00:00', '2024-09-02 05:00:00', '0', 'payment46'),

-- Bookings for slot23 (centre8)
('booking47', 'cust3', 'slot23', '2024-09-08 11:00:00', '2024-09-01 06:00:00', '0', 'payment47'),
('booking48', 'cust4', 'slot23', '2024-09-09 11:00:00', '2024-09-02 07:00:00', '1', 'payment48'),

-- Bookings for slot24 (centre8)
('booking49', 'cust5', 'slot24', '2024-09-08 13:00:00', '2024-09-01 08:00:00', '0', 'payment49'),
('booking50', 'cust1', 'slot24', '2024-09-09 13:00:00', '2024-09-02 09:00:00', '1', 'payment50'),

-- Bookings for slot25 (centre9)
('booking51', 'cust2', 'slot25', '2024-09-08 07:00:00', '2024-09-01 10:00:00', '0', 'payment51'),
('booking52', 'cust3', 'slot25', '2024-09-09 07:00:00', '2024-09-02 11:00:00', '0', 'payment52'),

-- Bookings for slot26 (centre9)
('booking53', 'cust4', 'slot26', '2024-09-08 09:00:00', '2024-09-01 12:00:00', '0', 'payment53'),
('booking54', 'cust5', 'slot26', '2024-09-09 09:00:00', '2024-09-02 13:00:00', '1', 'payment54'),

-- Bookings for slot27 (centre9)
('booking55', 'cust1', 'slot27', '2024-09-08 11:00:00', '2024-09-01 14:00:00', '0', 'payment55'),
('booking56', 'cust2', 'slot27', '2024-09-09 11:00:00', '2024-09-02 15:00:00', '0', 'payment56'),

-- Bookings for slot28 (centre10)
('booking57', 'cust3', 'slot28', '2024-09-08 08:00:00', '2024-09-01 16:00:00', '0', 'payment57'),
('booking58', 'cust4', 'slot28', '2024-09-09 08:00:00', '2024-09-02 17:00:00', '0', 'payment58'),

-- Bookings for slot29 (centre10)
('booking59', 'cust5', 'slot29', '2024-09-08 10:00:00', '2024-09-01 18:00:00', '0', 'payment59'),
('booking60', 'cust1', 'slot29', '2024-09-09 10:00:00', '2024-09-02 19:00:00', '1', 'payment60'),

-- Bookings for slot30 (centre10)
('booking61', 'cust2', 'slot30', '2024-09-08 12:00:00', '2024-09-01 20:00:00', '0', 'payment61'),
('booking62', 'cust3', 'slot30', '2024-09-09 12:00:00', '2024-09-02 21:00:00', '1', 'payment62');

