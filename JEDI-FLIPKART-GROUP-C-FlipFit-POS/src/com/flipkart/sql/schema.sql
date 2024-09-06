CREATE TABLE `FlipFitUser` (
                               `userId` varchar(50) NOT NULL,
                               `username` varchar(45) NOT NULL,
                               `password` varchar(45) NOT NULL,
                               `name` varchar(90) NOT NULL,
                               `address` varchar(90) NOT NULL,
                               `phoneNumber` varchar(10) NOT NULL,
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
                                   CONSTRAINT `customerId` FOREIGN KEY (`customerId`) REFERENCES `FlipFitUser` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFItGymOwner` (
                                   `ownerId` varchar(50) NOT NULL,
                                   `gstNumber` varchar(90) NOT NULL,
                                   `panCardNumber` varchar(45) NOT NULL,
                                   `verified` varchar(20) NOT NULL,
                                   PRIMARY KEY (`ownerId`),
                                   CONSTRAINT `ownerId` FOREIGN KEY (`ownerId`) REFERENCES `FlipFitUser` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitAdmin` (
                                `userId` varchar(50) NOT NULL,
                                PRIMARY KEY (`userId`),
                                CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `FlipFitUser` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitCentre` (
                                 `centreId` varchar(50) NOT NULL,
                                 `centreName` varchar(90) NOT NULL,
                                 `centreAddress` varchar(90) NOT NULL,
                                 `gymOwnerId` varchar(50) NOT NULL,
                                 `verified` varchar(20) NOT NULL,
                                 PRIMARY KEY (`centreId`),
                                 FOREIGN KEY (`gymOwnerId`) REFERENCES `FlipFItGymOwner` (`ownerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitCenterSlot` (
                                     `slotId` varchar(50) NOT NULL,
                                     `centreId` varchar(50) NOT NULL,
                                     `startTime` datetime NOT NULL,
                                     `seatLimit` int NOT NULL,
                                     PRIMARY KEY (`slotId`),
                                     FOREIGN KEY (`centreId`) REFERENCES `FlipFitCentre` (`centreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `FlipFitPayments` (
                                   `paymentId` varchar(50) NOT NULL,
                                   `customerId` varchar(50) NOT NULL,
                                   `amount` double NOT NULL,
                                   `date` datetime NOT NULL,
                                   `status` varchar(45) NOT NULL,
                                   PRIMARY KEY (`paymentId`),
                                   FOREIGN KEY (`customerId`) REFERENCES `FlipFitUser` (`userId`)
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
                                      FOREIGN KEY (`userId`) REFERENCES `FlipFitUser` (`userId`),
                                      FOREIGN KEY (`centreSlotId`) REFERENCES `FlipFitCentre` (`centreId`),
                                      FOREIGN KEY (`paymentId`) REFERENCES `FlipFitPayments` (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

