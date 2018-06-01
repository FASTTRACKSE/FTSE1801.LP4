-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2018 at 11:10 AM
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
-- Database: `quanlynhatruong`
--

-- --------------------------------------------------------

--
-- Table structure for table `dsdiem`
--

CREATE TABLE `dsdiem` (
  `MaSV` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaMH` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `Diem` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dsdiem`
--

INSERT INTO `dsdiem` (`MaSV`, `MaMH`, `Diem`) VALUES
('SV001', '18MHD1', 7.5),
('SV002', '18MHKT1', 6),
('SV003', '18MHXD1', 8.5);

-- --------------------------------------------------------

--
-- Table structure for table `dskhoa`
--

CREATE TABLE `dskhoa` (
  `MaKhoa` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKhoa` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dskhoa`
--

INSERT INTO `dskhoa` (`MaKhoa`, `TenKhoa`) VALUES
('k01', 'Điện'),
('k02', 'Xây dựng'),
('k03', 'Kiến trúc');

-- --------------------------------------------------------

--
-- Table structure for table `dslophoc`
--

CREATE TABLE `dslophoc` (
  `MaLH` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSV` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenLH` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dslophoc`
--

INSERT INTO `dslophoc` (`MaLH`, `MaSV`, `TenLH`) VALUES
('18CDD1', 'SV002', 'Lớp điện'),
('18CDKT1', 'SV001', 'Lớp kiến trúc'),
('18CDXD1', 'SV003', 'Lớp xây dựng');

-- --------------------------------------------------------

--
-- Table structure for table `dsmonhoc`
--

CREATE TABLE `dsmonhoc` (
  `MaMH` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenMH` char(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dsmonhoc`
--

INSERT INTO `dsmonhoc` (`MaMH`, `TenMH`) VALUES
('18MHD1', 'Điện dân dụng'),
('18MHKT1', 'Kiến trúc'),
('18MHXD1', 'Xây dựng');

-- --------------------------------------------------------

--
-- Table structure for table `dssv`
--

CREATE TABLE `dssv` (
  `MaSV` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenSV` char(30) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `QueQuan` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `MaKhoa` char(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dssv`
--

INSERT INTO `dssv` (`MaSV`, `TenSV`, `NgaySinh`, `GioiTinh`, `QueQuan`, `DiaChi`, `MaKhoa`) VALUES
('SV001', 'Trần Văn Sang', '1993-04-21', 'Nam', 'Đà Nẵng', '276 Tôn Đức Thắng, Liên Chiểu', 'k03'),
('SV002', 'Phạm Thị Hoa', '1997-09-05', 'Nữ', 'Đà Nẵng', '203 Đồng Kè, Liên Chiểu', 'k01'),
('SV003', 'Văn Đức Sơn', '1994-06-10', 'Nam', 'Đà Nẵng', 'Tổ  46A, Hòa Khánh Bắc, Liên Chiểu', 'k02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dsdiem`
--
ALTER TABLE `dsdiem`
  ADD KEY `fk_dsdiem_dssv` (`MaSV`),
  ADD KEY `fk_dsdiem_dsmonhoc` (`MaMH`);

--
-- Indexes for table `dskhoa`
--
ALTER TABLE `dskhoa`
  ADD PRIMARY KEY (`MaKhoa`);

--
-- Indexes for table `dslophoc`
--
ALTER TABLE `dslophoc`
  ADD PRIMARY KEY (`MaLH`),
  ADD KEY `fk_dslophoc_dssv` (`MaSV`);

--
-- Indexes for table `dsmonhoc`
--
ALTER TABLE `dsmonhoc`
  ADD PRIMARY KEY (`MaMH`);

--
-- Indexes for table `dssv`
--
ALTER TABLE `dssv`
  ADD PRIMARY KEY (`MaSV`),
  ADD KEY `fk_dssv_khoa` (`MaKhoa`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dsdiem`
--
ALTER TABLE `dsdiem`
  ADD CONSTRAINT `fk_dsdiem_dsmonhoc` FOREIGN KEY (`MaMH`) REFERENCES `dsmonhoc` (`MaMH`),
  ADD CONSTRAINT `fk_dsdiem_dssv` FOREIGN KEY (`MaSV`) REFERENCES `dssv` (`MaSV`);

--
-- Constraints for table `dslophoc`
--
ALTER TABLE `dslophoc`
  ADD CONSTRAINT `fk_dslophoc_dssv` FOREIGN KEY (`MaSV`) REFERENCES `dssv` (`MaSV`);

--
-- Constraints for table `dssv`
--
ALTER TABLE `dssv`
  ADD CONSTRAINT `fk_dssv_khoa` FOREIGN KEY (`MaKhoa`) REFERENCES `dskhoa` (`MaKhoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
