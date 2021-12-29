-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2021 at 02:26 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email`, `pass`) VALUES
('rahul@gmail.com', 'rahul123');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `cname` varchar(255) NOT NULL,
  `branch` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`cname`, `branch`) VALUES
('TCS', 'CSE'),
('TCS', 'IT'),
('Amazone', 'CSE'),
('Amazone', 'IT'),
('Infosays', 'CSE'),
('Infosays', 'IT'),
('Infosays', 'ECE'),
('Infosays', 'EE'),
('Infosays', 'CE'),
('Infosays', 'ME');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `cname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pkg` int(11) NOT NULL,
  `agg` int(11) NOT NULL,
  `backlog` int(11) NOT NULL,
  `loc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`cname`, `email`, `pkg`, `agg`, `backlog`, `loc`) VALUES
('TCS', 'tcs@gmail.com', 7, 67, 1, 'Banglore'),
('Amazone', 'amz@gmail.com', 10, 70, 0, 'Mumbai'),
('Infosays', 'info@gmail.com', 4, 65, 2, 'Banglore');

-- --------------------------------------------------------

--
-- Table structure for table `mgmt`
--

CREATE TABLE `mgmt` (
  `student_id` varchar(255) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `father_name` varchar(255) NOT NULL,
  `mother_name` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `branch` varchar(255) NOT NULL,
  `10th` int(11) NOT NULL,
  `12th` int(11) NOT NULL,
  `btech_agg` int(11) NOT NULL,
  `nob` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mgmt`
--

INSERT INTO `mgmt` (`student_id`, `student_name`, `father_name`, `mother_name`, `email_id`, `phone`, `gender`, `branch`, `10th`, `12th`, `btech_agg`, `nob`) VALUES
('ecbit01', 'Ajay Singh', 'Bhavar Singh', 'Sima Kanwar', 'ajaysingh23@gmail.com', '8976354276', 'Male', 'IT', 76, 70, 65, 1),
('ecbcs01', 'Ajay Nai', 'Pream Nai', 'Sima Devi', 'ajaynai@gmail.com', '8934562756', 'Male', 'CSE', 76, 70, 68, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sn` int(11) NOT NULL,
  `sname` varchar(255) NOT NULL,
  `avgr` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sn`, `sname`, `avgr`) VALUES
(1, 'RAHUL', 70),
(2, 'Raaj', 74),
(3, 'anil', 72),
(4, 'rHUP', 67);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
