-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2023 at 09:44 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nestopia`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `BookingID` int(11) NOT NULL,
  `CheckinDate` date NOT NULL,
  `CheckoutDate` date NOT NULL,
  `RentalPrice` decimal(10,2) NOT NULL,
  `TotalRevenue` decimal(10,2) GENERATED ALWAYS AS ((to_days(`CheckoutDate`) - to_days(`CheckinDate`)) * `RentalPrice`) STORED,
  `ClientID` int(11) DEFAULT NULL,
  `PropertyName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`BookingID`, `CheckinDate`, `CheckoutDate`, `RentalPrice`, `ClientID`, `PropertyName`) VALUES
(1, '2023-10-01', '2023-10-25', 100.00, NULL, ''),
(2, '2023-10-02', '2023-10-26', 120.00, NULL, ''),
(3, '2023-10-03', '2023-10-27', 150.00, NULL, ''),
(4, '2023-10-04', '2023-10-28', 200.00, NULL, ''),
(5, '2023-10-03', '2023-10-08', 112.00, NULL, ''),
(6, '2023-10-01', '2023-10-25', 100.00, 15, ''),
(7, '2023-10-01', '2023-10-02', 11.00, NULL, ''),
(8, '2023-10-01', '2023-10-11', 11.00, NULL, ''),
(9, '2023-10-11', '2023-10-12', 11.00, NULL, ''),
(10, '2023-10-02', '2023-10-20', 12.00, NULL, ''),
(11, '2023-10-02', '2023-10-20', 12.00, NULL, ''),
(12, '2023-10-11', '2023-10-21', 12.00, NULL, ''),
(13, '2023-11-01', '2023-11-11', 12.00, NULL, ''),
(14, '2023-11-01', '2023-11-12', 12.00, NULL, ''),
(15, '2023-10-01', '2023-10-01', 11.00, 82, ''),
(20, '2023-10-03', '2023-10-10', 12.00, 86, ''),
(21, '2023-10-19', '2023-10-19', 12.00, 87, ''),
(22, '2022-12-01', '2022-12-01', 10.00, 88, ''),
(23, '2023-10-11', '2023-12-13', 10.00, 89, ''),
(28, '2023-01-01', '2023-01-10', 150.00, 88, 'Xeon'),
(31, '2023-01-01', '2023-01-11', 10.00, 91, 'RE'),
(32, '2023-01-01', '2023-01-11', 11.00, 92, 'yep'),
(33, '2023-01-01', '2023-01-12', 10.00, 93, 'RE'),
(34, '2023-11-10', '2023-11-20', 10.00, 95, 'INDO'),
(35, '2023-01-12', '2023-01-13', 10.00, 96, 'RE'),
(36, '2023-11-19', '2023-11-20', 10.00, 97, 'yep'),
(37, '2023-10-11', '2023-10-12', 20.00, 98, 'Property X');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `ClientID` int(11) NOT NULL,
  `ClientName` varchar(50) NOT NULL,
  `ContactPhone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`ClientID`, `ClientName`, `ContactPhone`) VALUES
(8, 'Ali ', '03084991998'),
(12, 'Ahmed', '2344567123'),
(14, 'Ali', '04567876543'),
(15, 'nadeem', '98765432100'),
(17, 'khaisar', '0906845892'),
(19, 'dv', 'v12134`5'),
(20, 'carl', '3040506070'),
(37, 'Zeeshan', '0324897889'),
(38, 'ALi', '0325919760138'),
(42, 'wer', '124352461357'),
(65, 'sADF', 'ADM'),
(66, 'EFWV', '1345'),
(68, 'shfanv', ' nmzx'),
(71, ' dvnsv', 'avda'),
(76, 'zeeshan', '030854991998'),
(79, 'zeeshab', '098876543'),
(80, 'derst', '12345678889'),
(81, 'as', 'as'),
(82, 'xeeshan', '096543'),
(85, 'khaiar', '12345676'),
(86, 'saud', '13245367'),
(87, 'zee', '123435356'),
(88, 'Zeeshan', '098756555'),
(89, 'ahsan', '1234567888'),
(91, 'ali', '123457898'),
(92, 'ali', '0987654'),
(93, 'naeem', '123'),
(94, 'noor', '123457'),
(95, 'noorre', '132425367'),
(96, 'nouren', '134567'),
(97, 'dsf', '1456789'),
(98, 'adan', '1234567');

-- --------------------------------------------------------

--
-- Table structure for table `properties`
--

CREATE TABLE `properties` (
  `PropertyID` int(11) NOT NULL,
  `PropertyName` varchar(100) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `NumOfRooms` int(11) DEFAULT NULL,
  `RentalPrice` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `properties`
--

INSERT INTO `properties` (`PropertyID`, `PropertyName`, `Address`, `NumOfRooms`, `RentalPrice`) VALUES
(1, 'Property X', '123 Main Street, City A', 3, 150.00),
(32, 'RE', 'WERTYU', NULL, 12.00),
(33, 'INDO', '13245U8EFIS', NULL, 123.00),
(34, 'yep', '12253asfnaj', NULL, 122.00);

-- --------------------------------------------------------

--
-- Table structure for table `useraccounts`
--

CREATE TABLE `useraccounts` (
  `UserID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `useraccounts`
--

INSERT INTO `useraccounts` (`UserID`, `Username`, `Password`) VALUES
(1, 'john_doe', 'password123'),
(2, 'jane_smith', 'securePassword!23'),
(9, 'zeeshan', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`BookingID`),
  ADD KEY `fk_ClientID` (`ClientID`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`ClientID`),
  ADD UNIQUE KEY `ContactPhone` (`ContactPhone`);

--
-- Indexes for table `properties`
--
ALTER TABLE `properties`
  ADD PRIMARY KEY (`PropertyID`);

--
-- Indexes for table `useraccounts`
--
ALTER TABLE `useraccounts`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `BookingID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `ClientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT for table `properties`
--
ALTER TABLE `properties`
  MODIFY `PropertyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `useraccounts`
--
ALTER TABLE `useraccounts`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `fk_ClientID` FOREIGN KEY (`ClientID`) REFERENCES `clients` (`ClientID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
