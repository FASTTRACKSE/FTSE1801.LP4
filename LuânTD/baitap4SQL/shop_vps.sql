-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2018 at 11:07 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop_vps`
--

-- --------------------------------------------------------

--
-- Table structure for table `don_hang`
--

CREATE TABLE `don_hang` (
  `maDH` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `maKH` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `maSP` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sluong` int(3) NOT NULL,
  `ngaym` date NOT NULL,
  `ngayhh` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `don_hang`
--

INSERT INTO `don_hang` (`maDH`, `maKH`, `maSP`, `sluong`, `ngaym`, `ngayhh`) VALUES
('DH01', 'KH01', 'SP02', 2, '2018-05-01', '2018-07-01'),
('DH02', 'KH02', 'SP01', 10, '2018-05-17', '2018-07-17'),
('DH03', 'KH03', 'SP04', 2, '2018-06-11', '2018-07-11'),
('DH04', 'KH04', 'SP01', 20, '2018-06-21', '2018-08-21');

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `maKH` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenKH` char(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaysinh` date NOT NULL,
  `maTinh` char(3) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`maKH`, `tenKH`, `ngaysinh`, `maTinh`) VALUES
('KH01', 'Nguyễn văn A', '1990-05-10', '56'),
('KH02', 'Nguyễn văn B', '1992-12-02', '40'),
('KH03', 'Nguyễn văn C', '1991-06-19', '56'),
('KH04', 'Nguyễn văn D', '1995-09-13', '18');

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `maSP` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenSP` char(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cpu` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ram` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ssd` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hdh` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sluong` int(3) NOT NULL,
  `gia` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`maSP`, `tenSP`, `cpu`, `ram`, `ssd`, `hdh`, `sluong`, `gia`) VALUES
('SP01', 'VPS SSD1', '1 Core', '2BG', '15GB', 'Windows/linux', 1, 99000),
('SP02', 'VPS SSD2', '2 Core', '4BG', '30GB', 'Windows/linux', 1, 199000),
('SP03', 'VPS SCAN SSH', '2 Core', '4BG', '30GB', 'Windows/linux', 1, 249000),
('SP04', 'SERVER', '4 Core', '8BG', '500GB', 'Windows/linux/window', 1, 1990000);

-- --------------------------------------------------------

--
-- Table structure for table `tinh_vn`
--

CREATE TABLE `tinh_vn` (
  `maTinh` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenTinh` char(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tinh_vn`
--

INSERT INTO `tinh_vn` (`maTinh`, `tenTinh`) VALUES
('1', 'An Giang'),
('18', 'Hà Nội'),
('2', 'Bà Rịa-Vũng Tàu'),
('24', 'Hồ Chí Minh'),
('40', 'Quảng Nam'),
('56', 'Đà Nẵng');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `don_hang`
--
ALTER TABLE `don_hang`
  ADD PRIMARY KEY (`maDH`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`maKH`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`maSP`);

--
-- Indexes for table `tinh_vn`
--
ALTER TABLE `tinh_vn`
  ADD PRIMARY KEY (`maTinh`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
