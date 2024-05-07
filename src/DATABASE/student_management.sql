-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2024 at 09:11 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_management`
--

-- --------------------------------------------------------
CREATE DATABASE IF NOT EXISTS student_management;
USE student_management;

--
-- Table structure for table `chitietdiem`
--

CREATE TABLE `chitietdiem` (
  `HocSinhid` varchar(5) NOT NULL,
  `MonHocid` varchar(11) NOT NULL,
  `HocKyid` int(11) NOT NULL,
  `HeSoid` int(11) NOT NULL,
  `Diem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitietdiem`
--

INSERT INTO `chitietdiem` (`HocSinhid`, `MonHocid`, `HocKyid`, `HeSoid`, `Diem`) VALUES
('2061', 'ANH', 1, 1, 9),
('2061', 'ANH', 1, 2, 10),
('2061', 'ANH', 1, 3, 7),
('2061', 'ANH', 2, 1, 10),
('2061', 'ANH', 2, 2, 9),
('2061', 'ANH', 2, 3, 10),
('2061', 'HOA', 1, 1, 5),
('2061', 'HOA', 1, 2, 9),
('2061', 'HOA', 1, 3, 10),
('2061', 'HOA', 2, 1, 9),
('2061', 'HOA', 2, 2, 7),
('2061', 'HOA', 2, 3, 8),
('2061', 'LY', 1, 1, 7),
('2061', 'LY', 1, 2, 6),
('2061', 'LY', 1, 3, 5),
('2061', 'LY', 2, 1, 10),
('2061', 'LY', 2, 2, 10),
('2061', 'LY', 2, 3, 10),
('2061', 'TOAN', 1, 1, 6),
('2061', 'TOAN', 1, 2, 9),
('2061', 'TOAN', 1, 3, 9),
('2061', 'TOAN', 2, 1, 7),
('2061', 'TOAN', 2, 2, 5),
('2061', 'TOAN', 2, 3, 9),
('HS10', 'ANH', 1, 1, 9),
('HS10', 'ANH', 1, 2, 8),
('HS10', 'ANH', 1, 3, 7),
('HS10', 'ANH', 2, 1, 7),
('HS10', 'ANH', 2, 2, 8),
('HS10', 'ANH', 2, 3, 9),
('HS10', 'HOA', 1, 1, 9),
('HS10', 'HOA', 1, 2, 8),
('HS10', 'HOA', 1, 3, 7),
('HS10', 'HOA', 2, 1, 9),
('HS10', 'HOA', 2, 2, 8),
('HS10', 'HOA', 2, 3, 8),
('HS10', 'LY', 1, 1, 9),
('HS10', 'LY', 1, 2, 8),
('HS10', 'LY', 1, 3, 7),
('HS10', 'LY', 2, 1, 7),
('HS10', 'LY', 2, 2, 8),
('HS10', 'LY', 2, 3, 9),
('HS10', 'TOAN', 1, 1, 9),
('HS10', 'TOAN', 1, 2, 8),
('HS10', 'TOAN', 1, 3, 7),
('HS10', 'TOAN', 2, 1, 9),
('HS10', 'TOAN', 2, 2, 8),
('HS10', 'TOAN', 2, 3, 7),
('HS11', 'ANH', 1, 1, 9),
('HS11', 'ANH', 1, 2, 9),
('HS11', 'ANH', 1, 3, 8),
('HS11', 'ANH', 2, 1, 7),
('HS11', 'ANH', 2, 2, 7),
('HS11', 'ANH', 2, 3, 7),
('HS11', 'HOA', 1, 1, 8),
('HS11', 'HOA', 1, 2, 7),
('HS11', 'HOA', 1, 3, 9),
('HS11', 'HOA', 2, 1, 7),
('HS11', 'HOA', 2, 2, 7),
('HS11', 'HOA', 2, 3, 7),
('HS11', 'LY', 1, 1, 5),
('HS11', 'LY', 1, 2, 9),
('HS11', 'LY', 1, 3, 9),
('HS11', 'LY', 2, 1, 7),
('HS11', 'LY', 2, 2, 7),
('HS11', 'LY', 2, 3, 7),
('HS11', 'TOAN', 1, 1, 9),
('HS11', 'TOAN', 1, 2, 10),
('HS11', 'TOAN', 1, 3, 6),
('HS11', 'TOAN', 2, 1, 7),
('HS11', 'TOAN', 2, 2, 7),
('HS11', 'TOAN', 2, 3, 7),
('HS12', 'ANH', 1, 1, 9),
('HS12', 'ANH', 1, 2, 9),
('HS12', 'ANH', 1, 3, 9),
('HS12', 'ANH', 2, 1, 10),
('HS12', 'ANH', 2, 2, 10),
('HS12', 'ANH', 2, 3, 10),
('HS12', 'HOA', 1, 1, 7),
('HS12', 'HOA', 1, 2, 8),
('HS12', 'HOA', 1, 3, 9),
('HS12', 'HOA', 2, 1, 10),
('HS12', 'HOA', 2, 2, 10),
('HS12', 'HOA', 2, 3, 10),
('HS12', 'LY', 1, 1, 10),
('HS12', 'LY', 1, 2, 5),
('HS12', 'LY', 1, 3, 10),
('HS12', 'LY', 2, 1, 10),
('HS12', 'LY', 2, 2, 10),
('HS12', 'LY', 2, 3, 10),
('HS12', 'TOAN', 1, 1, 8),
('HS12', 'TOAN', 1, 2, 7),
('HS12', 'TOAN', 1, 3, 9),
('HS12', 'TOAN', 2, 1, 10),
('HS12', 'TOAN', 2, 2, 9),
('HS12', 'TOAN', 2, 3, 10),
('HS13', 'ANH', 1, 1, 10),
('HS13', 'ANH', 1, 2, 9),
('HS13', 'ANH', 1, 3, 9),
('HS13', 'ANH', 2, 1, 9),
('HS13', 'ANH', 2, 2, 9),
('HS13', 'ANH', 2, 3, 9),
('HS13', 'HOA', 1, 1, 8),
('HS13', 'HOA', 1, 2, 9),
('HS13', 'HOA', 1, 3, 7),
('HS13', 'HOA', 2, 1, 8),
('HS13', 'HOA', 2, 2, 8),
('HS13', 'HOA', 2, 3, 8),
('HS13', 'LY', 1, 1, 5),
('HS13', 'LY', 1, 2, 4),
('HS13', 'LY', 1, 3, 9),
('HS13', 'LY', 2, 1, 7),
('HS13', 'LY', 2, 2, 7),
('HS13', 'LY', 2, 3, 7),
('HS13', 'TOAN', 1, 1, 10),
('HS13', 'TOAN', 1, 2, 9),
('HS13', 'TOAN', 1, 3, 8),
('HS13', 'TOAN', 2, 1, 6),
('HS13', 'TOAN', 2, 2, 6),
('HS13', 'TOAN', 2, 3, 6),
('HS14', 'ANH', 1, 1, 7),
('HS14', 'ANH', 1, 2, 8),
('HS14', 'ANH', 1, 3, 7),
('HS14', 'ANH', 2, 1, 9),
('HS14', 'ANH', 2, 2, 7),
('HS14', 'ANH', 2, 3, 10),
('HS14', 'HOA', 1, 1, 9),
('HS14', 'HOA', 1, 2, 8),
('HS14', 'HOA', 1, 3, 10),
('HS14', 'HOA', 2, 1, 9),
('HS14', 'HOA', 2, 2, 7),
('HS14', 'HOA', 2, 3, 8),
('HS14', 'LY', 1, 1, 9),
('HS14', 'LY', 1, 2, 7),
('HS14', 'LY', 1, 3, 10),
('HS14', 'LY', 2, 1, 9),
('HS14', 'LY', 2, 2, 7),
('HS14', 'LY', 2, 3, 8),
('HS14', 'TOAN', 1, 1, 9),
('HS14', 'TOAN', 1, 2, 10),
('HS14', 'TOAN', 1, 3, 8),
('HS14', 'TOAN', 2, 1, 7),
('HS14', 'TOAN', 2, 2, 8),
('HS14', 'TOAN', 2, 3, 6),
('HS15', 'ANH', 1, 1, 10),
('HS15', 'ANH', 1, 2, 8),
('HS15', 'ANH', 1, 3, 9),
('HS15', 'ANH', 2, 1, 7),
('HS15', 'ANH', 2, 2, 7),
('HS15', 'ANH', 2, 3, 7),
('HS15', 'HOA', 1, 1, 8),
('HS15', 'HOA', 1, 2, 7),
('HS15', 'HOA', 1, 3, 9),
('HS15', 'HOA', 2, 1, 8),
('HS15', 'HOA', 2, 2, 7),
('HS15', 'HOA', 2, 3, 5),
('HS15', 'LY', 1, 1, 6),
('HS15', 'LY', 1, 2, 9),
('HS15', 'LY', 1, 3, 10),
('HS15', 'LY', 2, 1, 7),
('HS15', 'LY', 2, 2, 6),
('HS15', 'LY', 2, 3, 7),
('HS15', 'TOAN', 1, 1, 9),
('HS15', 'TOAN', 1, 2, 8),
('HS15', 'TOAN', 1, 3, 10),
('HS15', 'TOAN', 2, 1, 9),
('HS15', 'TOAN', 2, 2, 9),
('HS15', 'TOAN', 2, 3, 7),
('HS16', 'ANH', 1, 1, 7),
('HS16', 'ANH', 1, 2, 7),
('HS16', 'ANH', 1, 3, 7),
('HS16', 'ANH', 2, 1, 7),
('HS16', 'ANH', 2, 2, 7),
('HS16', 'ANH', 2, 3, 6),
('HS16', 'HOA', 1, 1, 5),
('HS16', 'HOA', 1, 2, 8),
('HS16', 'HOA', 1, 3, 7),
('HS16', 'HOA', 2, 1, 8),
('HS16', 'HOA', 2, 2, 5),
('HS16', 'HOA', 2, 3, 7),
('HS16', 'LY', 1, 1, 7),
('HS16', 'LY', 1, 2, 8),
('HS16', 'LY', 1, 3, 8),
('HS16', 'LY', 2, 1, 3),
('HS16', 'LY', 2, 2, 8),
('HS16', 'LY', 2, 3, 6),
('HS16', 'TOAN', 1, 1, 8),
('HS16', 'TOAN', 1, 2, 9),
('HS16', 'TOAN', 1, 3, 8),
('HS16', 'TOAN', 2, 1, 5),
('HS16', 'TOAN', 2, 2, 7),
('HS16', 'TOAN', 2, 3, 5),
('HS17', 'ANH', 1, 1, 8),
('HS17', 'ANH', 1, 2, 9),
('HS17', 'ANH', 1, 3, 8),
('HS17', 'ANH', 2, 1, 9),
('HS17', 'ANH', 2, 2, 7),
('HS17', 'ANH', 2, 3, 9),
('HS17', 'HOA', 1, 1, 7),
('HS17', 'HOA', 1, 2, 9),
('HS17', 'HOA', 1, 3, 7),
('HS17', 'HOA', 2, 1, 9),
('HS17', 'HOA', 2, 2, 7),
('HS17', 'HOA', 2, 3, 6),
('HS17', 'LY', 1, 1, 7),
('HS17', 'LY', 1, 2, 6),
('HS17', 'LY', 1, 3, 9),
('HS17', 'LY', 2, 1, 9),
('HS17', 'LY', 2, 2, 7),
('HS17', 'LY', 2, 3, 9),
('HS17', 'TOAN', 1, 1, 8),
('HS17', 'TOAN', 1, 2, 7),
('HS17', 'TOAN', 1, 3, 9),
('HS17', 'TOAN', 2, 1, 9),
('HS17', 'TOAN', 2, 2, 6),
('HS17', 'TOAN', 2, 3, 8),
('HS18', 'ANH', 1, 1, 9),
('HS18', 'ANH', 1, 2, 8),
('HS18', 'ANH', 1, 3, 9),
('HS18', 'ANH', 2, 1, 6),
('HS18', 'ANH', 2, 2, 8),
('HS18', 'ANH', 2, 3, 8),
('HS18', 'HOA', 1, 1, 8),
('HS18', 'HOA', 1, 2, 8),
('HS18', 'HOA', 1, 3, 9),
('HS18', 'HOA', 2, 1, 6),
('HS18', 'HOA', 2, 2, 7),
('HS18', 'HOA', 2, 3, 8),
('HS18', 'LY', 1, 1, 9),
('HS18', 'LY', 1, 2, 8),
('HS18', 'LY', 1, 3, 9),
('HS18', 'LY', 2, 1, 6),
('HS18', 'LY', 2, 2, 5),
('HS18', 'LY', 2, 3, 8),
('HS18', 'TOAN', 1, 1, 8),
('HS18', 'TOAN', 1, 2, 9),
('HS18', 'TOAN', 1, 3, 8),
('HS18', 'TOAN', 2, 1, 8),
('HS18', 'TOAN', 2, 2, 9),
('HS18', 'TOAN', 2, 3, 7),
('HS19', 'ANH', 1, 1, 7),
('HS19', 'ANH', 1, 2, 7),
('HS19', 'ANH', 1, 3, 7),
('HS19', 'ANH', 2, 1, 7),
('HS19', 'ANH', 2, 2, 7),
('HS19', 'ANH', 2, 3, 7),
('HS19', 'HOA', 1, 1, 7),
('HS19', 'HOA', 1, 2, 7),
('HS19', 'HOA', 1, 3, 7),
('HS19', 'HOA', 2, 1, 7),
('HS19', 'HOA', 2, 2, 7),
('HS19', 'HOA', 2, 3, 7),
('HS19', 'LY', 1, 1, 7),
('HS19', 'LY', 1, 2, 7),
('HS19', 'LY', 1, 3, 7),
('HS19', 'LY', 2, 1, 7),
('HS19', 'LY', 2, 2, 7),
('HS19', 'LY', 2, 3, 7),
('HS19', 'TOAN', 1, 1, 7),
('HS19', 'TOAN', 1, 2, 7),
('HS19', 'TOAN', 1, 3, 7),
('HS19', 'TOAN', 2, 1, 7),
('HS19', 'TOAN', 2, 2, 7),
('HS19', 'TOAN', 2, 3, 7),
('HS2', 'ANH', 1, 1, 8),
('HS2', 'ANH', 1, 2, 9),
('HS2', 'ANH', 1, 3, 8),
('HS2', 'ANH', 2, 1, 5),
('HS2', 'ANH', 2, 2, 8),
('HS2', 'ANH', 2, 3, 9),
('HS2', 'HOA', 1, 1, 8),
('HS2', 'HOA', 1, 2, 7),
('HS2', 'HOA', 1, 3, 9),
('HS2', 'HOA', 2, 1, 8),
('HS2', 'HOA', 2, 2, 7),
('HS2', 'HOA', 2, 3, 6),
('HS2', 'LY', 1, 1, 10),
('HS2', 'LY', 1, 2, 9),
('HS2', 'LY', 1, 3, 9),
('HS2', 'LY', 2, 1, 5),
('HS2', 'LY', 2, 2, 4),
('HS2', 'LY', 2, 3, 10),
('HS2', 'TOAN', 1, 1, 8),
('HS2', 'TOAN', 1, 2, 9),
('HS2', 'TOAN', 1, 3, 9),
('HS2', 'TOAN', 2, 1, 9),
('HS2', 'TOAN', 2, 2, 10),
('HS2', 'TOAN', 2, 3, 6),
('HS20', 'ANH', 1, 1, 8),
('HS20', 'ANH', 1, 2, 8),
('HS20', 'ANH', 1, 3, 8),
('HS20', 'ANH', 2, 1, 8),
('HS20', 'ANH', 2, 2, 8),
('HS20', 'ANH', 2, 3, 8),
('HS20', 'HOA', 1, 1, 8),
('HS20', 'HOA', 1, 2, 8),
('HS20', 'HOA', 1, 3, 8),
('HS20', 'HOA', 2, 1, 8),
('HS20', 'HOA', 2, 2, 8),
('HS20', 'HOA', 2, 3, 8),
('HS20', 'LY', 1, 1, 8),
('HS20', 'LY', 1, 2, 8),
('HS20', 'LY', 1, 3, 8),
('HS20', 'LY', 2, 1, 8),
('HS20', 'LY', 2, 2, 8),
('HS20', 'LY', 2, 3, 8),
('HS20', 'TOAN', 1, 1, 8),
('HS20', 'TOAN', 1, 2, 8),
('HS20', 'TOAN', 1, 3, 8),
('HS20', 'TOAN', 2, 1, 8),
('HS20', 'TOAN', 2, 2, 8),
('HS20', 'TOAN', 2, 3, 8),
('HS3', 'ANH', 1, 1, 9),
('HS3', 'ANH', 1, 2, 8),
('HS3', 'ANH', 1, 3, 9),
('HS3', 'ANH', 2, 1, 5),
('HS3', 'ANH', 2, 2, 6),
('HS3', 'ANH', 2, 3, 5),
('HS3', 'HOA', 1, 1, 9),
('HS3', 'HOA', 1, 2, 7),
('HS3', 'HOA', 1, 3, 9),
('HS3', 'HOA', 2, 1, 6),
('HS3', 'HOA', 2, 2, 8),
('HS3', 'HOA', 2, 3, 9),
('HS3', 'LY', 1, 1, 9),
('HS3', 'LY', 1, 2, 8),
('HS3', 'LY', 1, 3, 6),
('HS3', 'LY', 2, 1, 10),
('HS3', 'LY', 2, 2, 10),
('HS3', 'LY', 2, 3, 10),
('HS3', 'TOAN', 1, 1, 7),
('HS3', 'TOAN', 1, 2, 8),
('HS3', 'TOAN', 1, 3, 9),
('HS3', 'TOAN', 2, 1, 10),
('HS3', 'TOAN', 2, 2, 8),
('HS3', 'TOAN', 2, 3, 7),
('HS4', 'ANH', 1, 1, 10),
('HS4', 'ANH', 1, 2, 9),
('HS4', 'ANH', 1, 3, 9),
('HS4', 'ANH', 2, 1, 10),
('HS4', 'ANH', 2, 2, 8),
('HS4', 'ANH', 2, 3, 9),
('HS4', 'HOA', 1, 1, 6),
('HS4', 'HOA', 1, 2, 8),
('HS4', 'HOA', 1, 3, 8),
('HS4', 'HOA', 2, 1, 10),
('HS4', 'HOA', 2, 2, 9),
('HS4', 'HOA', 2, 3, 8),
('HS4', 'LY', 1, 1, 6),
('HS4', 'LY', 1, 2, 3),
('HS4', 'LY', 1, 3, 10),
('HS4', 'LY', 2, 1, 9),
('HS4', 'LY', 2, 2, 8),
('HS4', 'LY', 2, 3, 9),
('HS4', 'TOAN', 1, 1, 8),
('HS4', 'TOAN', 1, 2, 10),
('HS4', 'TOAN', 1, 3, 9),
('HS4', 'TOAN', 2, 1, 9),
('HS4', 'TOAN', 2, 2, 6),
('HS4', 'TOAN', 2, 3, 10),
('HS5', 'ANH', 1, 1, 6),
('HS5', 'ANH', 1, 2, 8),
('HS5', 'ANH', 1, 3, 8),
('HS5', 'ANH', 2, 1, 9),
('HS5', 'ANH', 2, 2, 9),
('HS5', 'ANH', 2, 3, 9),
('HS5', 'HOA', 1, 1, 7),
('HS5', 'HOA', 1, 2, 5),
('HS5', 'HOA', 1, 3, 5),
('HS5', 'HOA', 2, 1, 9),
('HS5', 'HOA', 2, 2, 9),
('HS5', 'HOA', 2, 3, 9),
('HS5', 'LY', 1, 1, 9),
('HS5', 'LY', 1, 2, 8),
('HS5', 'LY', 1, 3, 6),
('HS5', 'LY', 2, 1, 9),
('HS5', 'LY', 2, 2, 9),
('HS5', 'LY', 2, 3, 9),
('HS5', 'TOAN', 1, 1, 9),
('HS5', 'TOAN', 1, 2, 8),
('HS5', 'TOAN', 1, 3, 10),
('HS5', 'TOAN', 2, 1, 9),
('HS5', 'TOAN', 2, 2, 9),
('HS5', 'TOAN', 2, 3, 9),
('HS6', 'ANH', 1, 1, 8),
('HS6', 'ANH', 1, 2, 8),
('HS6', 'ANH', 1, 3, 8),
('HS6', 'ANH', 2, 1, 7),
('HS6', 'ANH', 2, 2, 7),
('HS6', 'ANH', 2, 3, 7),
('HS6', 'HOA', 1, 1, 8),
('HS6', 'HOA', 1, 2, 8),
('HS6', 'HOA', 1, 3, 8),
('HS6', 'HOA', 2, 1, 7),
('HS6', 'HOA', 2, 2, 7),
('HS6', 'HOA', 2, 3, 7),
('HS6', 'LY', 1, 1, 8),
('HS6', 'LY', 1, 2, 8),
('HS6', 'LY', 1, 3, 8),
('HS6', 'LY', 2, 1, 7),
('HS6', 'LY', 2, 2, 7),
('HS6', 'LY', 2, 3, 7),
('HS6', 'TOAN', 1, 1, 8),
('HS6', 'TOAN', 1, 2, 8),
('HS6', 'TOAN', 1, 3, 8),
('HS6', 'TOAN', 2, 1, 7),
('HS6', 'TOAN', 2, 2, 7),
('HS6', 'TOAN', 2, 3, 7),
('HS7', 'ANH', 1, 1, 6),
('HS7', 'ANH', 1, 2, 6),
('HS7', 'ANH', 1, 3, 6),
('HS7', 'ANH', 2, 1, 8),
('HS7', 'ANH', 2, 2, 8),
('HS7', 'ANH', 2, 3, 8),
('HS7', 'HOA', 1, 1, 6),
('HS7', 'HOA', 1, 2, 6),
('HS7', 'HOA', 1, 3, 6),
('HS7', 'HOA', 2, 1, 8),
('HS7', 'HOA', 2, 2, 8),
('HS7', 'HOA', 2, 3, 8),
('HS7', 'LY', 1, 1, 6),
('HS7', 'LY', 1, 2, 6),
('HS7', 'LY', 1, 3, 6),
('HS7', 'LY', 2, 1, 8),
('HS7', 'LY', 2, 2, 8),
('HS7', 'LY', 2, 3, 8),
('HS7', 'TOAN', 1, 1, 6),
('HS7', 'TOAN', 1, 2, 6),
('HS7', 'TOAN', 1, 3, 6),
('HS7', 'TOAN', 2, 1, 8),
('HS7', 'TOAN', 2, 2, 8),
('HS7', 'TOAN', 2, 3, 8),
('HS8', 'ANH', 1, 1, 10),
('HS8', 'ANH', 1, 2, 10),
('HS8', 'ANH', 1, 3, 10),
('HS8', 'ANH', 2, 1, 10),
('HS8', 'ANH', 2, 2, 10),
('HS8', 'ANH', 2, 3, 10),
('HS8', 'HOA', 1, 1, 10),
('HS8', 'HOA', 1, 2, 10),
('HS8', 'HOA', 1, 3, 10),
('HS8', 'HOA', 2, 1, 10),
('HS8', 'HOA', 2, 2, 10),
('HS8', 'HOA', 2, 3, 10),
('HS8', 'LY', 1, 1, 10),
('HS8', 'LY', 1, 2, 10),
('HS8', 'LY', 1, 3, 10),
('HS8', 'LY', 2, 1, 10),
('HS8', 'LY', 2, 2, 10),
('HS8', 'LY', 2, 3, 10),
('HS8', 'TOAN', 1, 1, 10),
('HS8', 'TOAN', 1, 2, 10),
('HS8', 'TOAN', 1, 3, 10),
('HS8', 'TOAN', 2, 1, 10),
('HS8', 'TOAN', 2, 2, 10),
('HS8', 'TOAN', 2, 3, 10),
('HS9', 'ANH', 1, 1, 6),
('HS9', 'ANH', 1, 2, 5),
('HS9', 'ANH', 1, 3, 5),
('HS9', 'ANH', 2, 1, 7),
('HS9', 'ANH', 2, 2, 8),
('HS9', 'ANH', 2, 3, 9),
('HS9', 'HOA', 1, 1, 4),
('HS9', 'HOA', 1, 2, 10),
('HS9', 'HOA', 1, 3, 7),
('HS9', 'HOA', 2, 1, 7),
('HS9', 'HOA', 2, 2, 8),
('HS9', 'HOA', 2, 3, 9),
('HS9', 'LY', 1, 1, 7),
('HS9', 'LY', 1, 2, 6),
('HS9', 'LY', 1, 3, 5),
('HS9', 'LY', 2, 1, 7),
('HS9', 'LY', 2, 2, 8),
('HS9', 'LY', 2, 3, 9),
('HS9', 'TOAN', 1, 1, 5),
('HS9', 'TOAN', 1, 2, 8),
('HS9', 'TOAN', 1, 3, 9),
('HS9', 'TOAN', 2, 1, 7),
('HS9', 'TOAN', 2, 2, 8),
('HS9', 'TOAN', 2, 3, 9);

-- --------------------------------------------------------

--
-- Table structure for table `diemtbhocky`
--

CREATE TABLE `diemtbhocky` (
  `HocSinhid` varchar(5) NOT NULL,
  `HocKyid` int(11) NOT NULL,
  `DiemTrungBinh` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `diemtbhocky`
--

INSERT INTO `diemtbhocky` (`HocSinhid`, `HocKyid`, `DiemTrungBinh`) VALUES
('HS1', 1, 7.83),
('HS1', 2, 7.95),
('HS10', 1, 7.67),
('HS10', 2, 8),
('HS11', 1, 7.1),
('HS11', 2, 7),
('HS12', 1, 8.46),
('HS12', 2, 9.95),
('HS13', 1, 8.1),
('HS13', 2, 7.5),
('HS14', 1, 8.52),
('HS14', 2, 7.83),
('HS15', 1, 8.8),
('HS15', 2, 6.95),
('HS16', 1, 7.5),
('HS16', 2, 6.2),
('HS17', 1, 7.96),
('HS17', 2, 7.75),
('HS18', 1, 8.54),
('HS18', 2, 7.375),
('HS19', 1, 7),
('HS19', 2, 7),
('HS2', 1, 8.625),
('HS2', 2, 7.42),
('HS20', 1, 8),
('HS20', 2, 8),
('HS3', 1, 8.125),
('HS3', 2, 7.83),
('HS4', 1, 8.25),
('HS4', 2, 8.67),
('HS5', 1, 7.33),
('HS5', 2, 9),
('HS6', 1, 8),
('HS6', 2, 7),
('HS7', 1, 6),
('HS7', 2, 8),
('HS8', 1, 10),
('HS8', 2, 10),
('HS9', 1, 6.58),
('HS9', 2, 8.3);

-- --------------------------------------------------------

--
-- Table structure for table `giaovien`
--

CREATE TABLE `giaovien` (
  `GiaoVienid` varchar(5) NOT NULL DEFAULT 'GV',
  `TenGiaoVien` varchar(50) NOT NULL,
  `GioiTinh` varchar(5) NOT NULL,
  `NamSinh` varchar(10) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `DienThoai` varchar(11) NOT NULL DEFAULT '',
  `IMG` text DEFAULT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `giaovien`
--

INSERT INTO `giaovien` (`GiaoVienid`, `TenGiaoVien`, `GioiTinh`, `NamSinh`, `DiaChi`, `DienThoai`, `IMG`, `enable`) VALUES
('GV1', 'Nguyễn Quốc Liêm', 'nam', '28/07/1997', '455/40 An Dương Vương', '0982134576', NULL, 1),
('GV2', 'Phạm Thị Loan', 'nữ', '13/12/1989', 'Phường 2, Gò Vấp', '0831054319', NULL, 1),
('GV3', 'Huỳnh Văn Hiền', 'nam', '11/06/1985', 'Trảng Bàng', '0957461238', NULL, 1),
('GV4', 'Trương Công Hùng', 'nam', '22/03/1991', 'Tân Châu Tây Ninh', '0754218514', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hocky`
--

CREATE TABLE `hocky` (
  `HocKyid` int(11) NOT NULL,
  `TenHocKy` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hocky`
--

INSERT INTO `hocky` (`HocKyid`, `TenHocKy`) VALUES
(1, 'Học Kỳ 1'),
(2, 'Học Kỳ 2');

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh`
--

CREATE TABLE `hocsinh` (
  `HocSinhid` varchar(5) NOT NULL DEFAULT 'HS',
  `HoVaTen` varchar(50) NOT NULL,
  `GioiTinh` varchar(50) NOT NULL,
  `NgaySinh` varchar(50) NOT NULL,
  `DienThoai` varchar(11) DEFAULT '0',
  `DiaChi` text NOT NULL,
  `HocPhi` varchar(20) NOT NULL DEFAULT 'Chưa thanh toán',
  `IMG` text DEFAULT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hocsinh`
--

INSERT INTO `hocsinh` (`HocSinhid`, `HoVaTen`, `GioiTinh`, `NgaySinh`, `DienThoai`, `DiaChi`, `HocPhi`, `IMG`, `enable`) VALUES
('HS1', 'Trương Anh Đào', 'Nữ', '12/3/2006', '0987654321', '123/4 Lê Lợi, Phường 7, Quận 1, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS10', 'Nguyễn Thị Ngọc Trinh', 'Nữ', '25/11/2007', '0987654321', '678/90 Nguyễn Tri Phương, Phường 11, Quận 5, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS11', 'Lê Thị Ánh Tuyết', 'Nữ', '7/8/2007', '0965432198', '345/67 Lê Lợi, Phường 12, Quận 10, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS12', 'Trần Văn Minh', 'Nam', '3/4/2007', '0912345678', '890/12 Nguyễn Văn Cừ, Phường 9, Quận Bình Thạnh, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS13', ' Phạm Văn Hưng', 'Nam', '16/9/2007', '0909876543', '456/78 Phan Xích Long, Phường 6, Quận Phú Nhuận, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS14', 'Đỗ Thị Ngọc Lan', 'Nữ', '29/6/2007', '0987654321', '123/45 Đặng Thùy Trâm, Phường 8, Quận 4, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS15', 'Bùi Văn Hùng', 'Nam', '8/11/2007', '0976543210', ' 789/32 Hồng Hà, Phường 15, Quận 10, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS16', 'Nguyễn Thị Thu Hà', 'Nữ', '20/3/2007', '0932109876', '567/89 Lê Văn Sỹ, Phường 14, Quận 3, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS17', 'Trần Văn Đức', 'Nam', '12/12/2007', '0943216789', '345/67 Nguyễn Văn Linh, Phường Tân Thuận Tây, Quận 7, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS18', 'Lê Thị Mai Anh', ' Nữ', '5/6/2008', '0909876543', '234/56 Võ Văn Tần, Phường 1, Quận 10, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS19', 'Nguyễn Văn Nam', 'Nam', '18/9/2008', '0976543210', '567/89 Phan Chu Trinh, Phường 2, Quận Bình Thạnh, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS2', 'Lê Văn Nam', 'Nam', '5/6/2006', '0901234567', '456/78 Điện Biên Phủ, Phường 5, Quận 3, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS20', 'Phạm Thị Hồng', 'Nữ', '20/7/2008', '0943216789', '678/90 Nguyễn Văn Quá, Phường Tân Hưng, Quận 8, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS21', 'Trần Văn Tuấn', 'Nam', '11/4/2008', '0932109876', '890/12 Bình Long, Phường 3, Quận Gò Vấp, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS22', 'Lý Thị Minh Khai', 'Nữ', ' 25/10/2008', '0923456789', '345/67 Lê Hồng Phong, Phường 4, Quận Tân Bình, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS23', ' Nguyễn Văn Thắng', 'Nam', '8/11/2008', '0912345678', '456/78 Điện Biên Phủ, Phường 5, Quận 11, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS24', 'Phan Thị Ngọc Trâm', 'Nữ', '14/2/2008', '0987654321', '789/32 Lê Lợi, Phường 6, Quận 9, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS25', ' Hoàng Văn Hưng', 'Nam', '30/6/2008', '0954321098', '890/12 Phạm Ngọc Thạch, Phường 7, Quận 12, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS26', 'Đặng Văn Hoàng', 'Nam', '27/12/2008', '0965432198', '123/45 Trần Hưng Đạo, Phường 8, Quận 4, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS27', 'Trần Thị Hằng', 'Nữ', '3/5/2008', '0912345678', '456/78 Nguyễn Văn Quá, Phường 10, Quận Tân Bình, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS3', 'Trần Thị Mai', 'Nữ', '20/9/2006', '0978123456', '789/10 Nguyễn Huệ, Phường 2, Quận 10, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS4', 'Hoàng Văn Tuấn', 'Nam', '15/12/2006', '0865432198', '321/54 Trần Hưng Đạo, Phường 9, Quận 5, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS5', 'Nguyễn Thị Lan', 'Nữ', '8/4/2006', '0912345678', '987/65 Đường số 10, Phường 8, Quận 7, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS6', 'Lý Văn Hưng', 'Nam', '23/10/2006', '0854321098', '456/32 Lý Thường Kiệt, Phường 6, Quận 11, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS7', 'Trần Văn Hòa', 'Nam', '17/7/2006', '0932109876', '789/32 Nguyễn Thị Minh Khai, Phường 3, Quận 1, TP.HCM,', 'Chưa thanh toán', NULL, 1),
('HS8', ' Phan Thị Hằng', 'Nữ', '30/5/2006', '0945671234', '567/89 Trần Não, Phường Bình An, Quận 2, TP.HCM', 'Chưa thanh toán', NULL, 1),
('HS9', 'Võ Văn Đức', 'Nam', ' 10/2/2007', '0978965432', '234/56 Cách Mạng Tháng 8, Phường 10, Quận 3, TP.HCM', 'Chưa thanh toán', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `kqhocsinhcanam`
--

CREATE TABLE `kqhocsinhcanam` (
  `HocSinhid` varchar(5) NOT NULL,
  `NamHocid` varchar(50) NOT NULL,
  `HocLuc` varchar(50) NOT NULL,
  `HanhKiem` varchar(10) NOT NULL DEFAULT 'Tốt',
  `Diemtb` float NOT NULL,
  `KetQua` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kqhocsinhcanam`
--

INSERT INTO `kqhocsinhcanam` (`HocSinhid`, `NamHocid`, `HocLuc`, `HanhKiem`, `Diemtb`, `KetQua`) VALUES
('HS1', 'giapthin', 'Khá', 'Tốt', 7.91, 'Lên Lớp'),
('HS10', 'giapthin', 'Khá', 'Tốt', 7.89, 'Lên Lớp'),
('HS11', 'giapthin', 'Khá', 'Tốt', 7, 'Lên Lớp'),
('HS12', 'giapthin', 'Khá', 'Tốt', 9.45, 'Lên Lớp'),
('HS13', 'giapthin', 'Khá', 'Tốt', 7.7, 'Lên Lớp'),
('HS14', 'giapthin', 'Giỏi', 'Tốt', 8.06, 'Lên Lớp'),
('HS15', 'giapthin', 'Khá', 'Tốt', 7.5, 'Lên Lớp'),
('HS16', 'giapthin', 'Khá', 'Tốt', 6.6, 'Lên Lớp'),
('HS17', 'giapthin', 'Khá', 'Tốt', 7.82, 'Lên Lớp'),
('HS18', 'giapthin', 'Khá', 'Tốt', 7.76, 'Lên Lớp'),
('HS19', 'giapthin', 'Khá', 'Tốt', 7, 'Lên Lớp'),
('HS2', 'giapthin', 'Khá', 'Tốt', 7.8, 'Lên Lớp'),
('HS20', 'giapthin', 'Giỏi', 'Tốt', 8, 'Lên Lớp'),
('HS3', 'giapthin', 'Khá', 'Tốt', 7.9, 'Lên Lớp'),
('HS4', 'giapthin', 'Giỏi', 'Tốt', 8.53, 'Lên Lớp'),
('HS5', 'giapthin', 'Giỏi', 'Tốt', 8.4, 'Lên Lớp'),
('HS6', 'giapthin', 'Khá', 'Tốt', 7.3, 'Lên Lớp'),
('HS7', 'giapthin', 'Khá', 'Tốt', 7.3, 'Lên Lớp'),
('HS8', 'giapthin', 'Giỏi', 'Tốt', 10, 'Lên Lớp'),
('HS9', 'giapthin', 'Khá', 'Tốt', 7.72, 'Lên Lớp');

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE `lop` (
  `Lopid` int(11) NOT NULL,
  `TenLop` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`Lopid`, `TenLop`) VALUES
(10, '10A1'),
(11, '11A1'),
(12, '12A1');

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE `monhoc` (
  `MonHocid` varchar(11) NOT NULL,
  `TenMonHoc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`MonHocid`, `TenMonHoc`) VALUES
('ANH', 'Anh Văn'),
('HOA', 'Hóa Học'),
('LY', 'Vật Lý'),
('TOAN', 'Toán');

-- --------------------------------------------------------

--
-- Table structure for table `namhoc`
--

CREATE TABLE `namhoc` (
  `NamHocid` varchar(50) NOT NULL,
  `NamBatDau` int(50) NOT NULL,
  `NamKetThuc` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `namhoc`
--

INSERT INTO `namhoc` (`NamHocid`, `NamBatDau`, `NamKetThuc`) VALUES
('giapthin', 2024, 2025);

-- --------------------------------------------------------

--
-- Table structure for table `phancong`
--

CREATE TABLE `phancong` (
  `GiaoVienid` varchar(5) NOT NULL DEFAULT 'GV',
  `Lopid` int(11) NOT NULL,
  `MonHocid` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phancong`
--

INSERT INTO `phancong` (`GiaoVienid`, `Lopid`, `MonHocid`) VALUES
('GV1', 10, 'TOAN'),
('GV1', 11, 'TOAN'),
('GV1', 12, 'TOAN'),
('GV2', 10, 'LY'),
('GV2', 11, 'LY'),
('GV2', 12, 'LY'),
('GV3', 10, 'HOA'),
('GV3', 11, 'HOA'),
('GV3', 12, 'HOA'),
('GV4', 10, 'ANH'),
('GV4', 11, 'ANH'),
('GV4', 12, 'ANH');

-- --------------------------------------------------------

--
-- Table structure for table `phanlop`
--

CREATE TABLE `phanlop` (
  `HocSinhid` varchar(5) NOT NULL,
  `Lopid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phanlop`
--

INSERT INTO `phanlop` (`HocSinhid`, `Lopid`) VALUES
('HS1', 12),
('HS10', 11),
('HS11', 11),
('HS12', 11),
('HS13', 11),
('HS14', 11),
('HS15', 11),
('HS16', 11),
('HS17', 11),
('HS18', 10),
('HS19', 10),
('HS2', 12),
('HS20', 10),
('HS21', 10),
('HS22', 10),
('HS23', 10),
('HS24', 10),
('HS25', 10),
('HS26', 10),
('HS27', 10),
('HS3', 12),
('HS4', 12),
('HS5', 12),
('HS6', 12),
('HS7', 12),
('HS8', 12),
('HS9', 11);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `role`, `enable`) VALUES
('admin', 'admin', 'admin', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdiem`
--
ALTER TABLE `chitietdiem`
  ADD PRIMARY KEY (`HocSinhid`,`MonHocid`,`HocKyid`,`HeSoid`) USING BTREE;

--
-- Indexes for table `diemtbhocky`
--
ALTER TABLE `diemtbhocky`
  ADD PRIMARY KEY (`HocSinhid`,`HocKyid`);

--
-- Indexes for table `giaovien`
--
ALTER TABLE `giaovien`
  ADD PRIMARY KEY (`GiaoVienid`);

--
-- Indexes for table `hocky`
--
ALTER TABLE `hocky`
  ADD PRIMARY KEY (`HocKyid`);

--
-- Indexes for table `hocsinh`
--
ALTER TABLE `hocsinh`
  ADD PRIMARY KEY (`HocSinhid`);

--
-- Indexes for table `kqhocsinhcanam`
--
ALTER TABLE `kqhocsinhcanam`
  ADD PRIMARY KEY (`HocSinhid`,`NamHocid`);

--
-- Indexes for table `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`Lopid`);

--
-- Indexes for table `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`MonHocid`);

--
-- Indexes for table `namhoc`
--
ALTER TABLE `namhoc`
  ADD PRIMARY KEY (`NamHocid`);

--
-- Indexes for table `phancong`
--
ALTER TABLE `phancong`
  ADD PRIMARY KEY (`GiaoVienid`,`Lopid`,`MonHocid`);

--
-- Indexes for table `phanlop`
--
ALTER TABLE `phanlop`
  ADD PRIMARY KEY (`HocSinhid`,`Lopid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;