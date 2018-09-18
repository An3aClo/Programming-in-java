CREATE DATABASE `student` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `bookings` (
  `ReferenceNumber` int(11) NOT NULL,
  `BookingDate` date NOT NULL,
  `ISBNNumber` varchar(45) NOT NULL,
  `BookTitle` varchar(100) NOT NULL,
  `StudentName` varchar(45) NOT NULL,
  `StudentSurname` varchar(45) NOT NULL,
  `StudentNumber` varchar(45) NOT NULL,
  `ReturnDate` date NOT NULL,
  PRIMARY KEY (`ReferenceNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `books` (
  `ISBNNumber` varchar(45) NOT NULL,
  `BookTitle` varchar(100) NOT NULL,
  `Author` varchar(45) NOT NULL,
  `Year` int(4) NOT NULL,
  `Edition` int(3) NOT NULL,
  `Category` varchar(45) NOT NULL,
  `Publiser` varchar(45) NOT NULL,
  `NumberOfCopiesText` int(4) DEFAULT NULL,
  PRIMARY KEY (`ISBNNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `student` (
  `StudentNumber` varchar(10) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `StudentName` varchar(45) NOT NULL,
  `StudentSurname` varchar(45) NOT NULL,
  `CellNumber` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  PRIMARY KEY (`StudentNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `student`.`bookings`
(`ReferenceNumber`,
`BookingDate`,
`ISBNNumber`,
`BookTitle`,
`StudentName`,
`StudentSurname`,
`StudentNumber`,
`ReturnDate`)