CREATE TABLE `FlipFitUser` (
                               `userId` varchar(50) NOT NULL,
                               `username` varchar(45) NOT NULL,
                               `password` varchar(45) NOT NULL,
                               `name` varchar(90) NOT NULL,
                               `address` varchar(90) NOT NULL,
                               `phoneNumber` varchar(10) NOT NULL,
                               `role` int NOT NULL,
                               PRIMARY KEY (`userId`),
                               UNIQUE (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitCustomer` (
                                   `weight` double NOT NULL,
                                   `age` int NOT NULL,
                                   `gender` varchar(10) NOT NULL,
                                   `dob` datetime NOT NULL,
                                   `customerId` varchar(45) NOT NULL,
                                   PRIMARY KEY (`customerId`),
                                   FOREIGN KEY (`customerId`) REFERENCES `FlipFitUser` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitGymOwner` (
                                   `ownerId` varchar(50) NOT NULL,
                                   `gstNumber` varchar(90) NOT NULL,
                                   `panCardNumber` varchar(45) NOT NULL,
                                   `verified` varchar(20) NOT NULL,
                                   PRIMARY KEY (`ownerId`),
                                   FOREIGN KEY (`ownerId`) REFERENCES `FlipFitUser` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitAdmin` (
                                `userId` varchar(50) NOT NULL,
                                PRIMARY KEY (`userId`),
                                FOREIGN KEY (`userId`) REFERENCES `FlipFitUser` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitCentre` (
                                 `centreId` varchar(50) NOT NULL,
                                 `centreName` varchar(90) NOT NULL,
                                 `centreAddress` varchar(90) NOT NULL,
                                 `gymOwnerId` varchar(50) NOT NULL,
                                 `verified` varchar(20) NOT NULL,
                                 PRIMARY KEY (`centreId`),
                                 FOREIGN KEY (`gymOwnerId`) REFERENCES `FlipFItGymOwner` (`ownerId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitCenterSlot` (
                                     `slotId` varchar(50) NOT NULL,
                                     `centreId` varchar(50) NOT NULL,
                                     `startTime` time NOT NULL,
                                     `seatLimit` int NOT NULL,
                                     PRIMARY KEY (`slotId`),
                                     FOREIGN KEY (`centreId`) REFERENCES `FlipFitCentre` (`centreId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitPayments` (
                                   `paymentId` varchar(50) NOT NULL,
                                   `customerId` varchar(50) NOT NULL,
                                   `amount` double NOT NULL,
                                   `date` datetime NOT NULL,
                                   `cardNumber` varchar(50) NOT NULL,
                                   `cvv` varchar(50),
                                   `cardExpiry` varchar(50),
                                   `status` varchar(45) NOT NULL,
                                   PRIMARY KEY (`paymentId`),
                                   FOREIGN KEY (`customerId`) REFERENCES `FlipFitUser` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitSlotBooking` (
                                      `bookingId` varchar(50) NOT NULL,
                                      `userId` varchar(50) NOT NULL,
                                      `centreSlotId` varchar(50) NOT NULL,
                                      `slotDate` datetime NOT NULL,
                                      `bookingDate` datetime NOT NULL,
                                      `status` varchar(20) NOT NULL,
                                      `paymentId` varchar(50) NOT NULL,
                                      PRIMARY KEY (`bookingId`),
                                      FOREIGN KEY (`userId`) REFERENCES `FlipFitUser` (`userId`) ON DELETE CASCADE,
                                      FOREIGN KEY (`centreSlotId`) REFERENCES `FlipFitCenterSlot` (`slotId`) ON DELETE CASCADE,
                                      FOREIGN KEY (`paymentId`) REFERENCES `FlipFitPayments` (`paymentId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

