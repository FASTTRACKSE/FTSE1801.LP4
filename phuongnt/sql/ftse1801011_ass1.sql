-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2018 at 10:59 AM
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
-- Database: `ftse1801011_ass1`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaKH` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayLap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `TenKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ngaysinh` date NOT NULL,
  `GioiTinh` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `SoDT` char(12) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `TenNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `SoDT` char(12) COLLATE utf8_unicode_ci NOT NULL,
  `PhongBan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ChucVU` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieudatmua`
--

CREATE TABLE `phieudatmua` (
  `MaPhieuDat` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `MaKH` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayLap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenSP` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Hangsx` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien`
--

CREATE TABLE `sinhvien` (
  `id` tinyint(10) NOT NULL,
  `ten` char(20) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` bit(1) NOT NULL,
  `dienthoai` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `phieudatmua`
--
ALTER TABLE `phieudatmua`
  ADD PRIMARY KEY (`MaPhieuDat`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`);

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
