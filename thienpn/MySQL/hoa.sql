-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2018 at 11:56 AM
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
-- Database: `hoa`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id_login` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id_login`, `name`, `matkhau`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `pm_kieuhoa`
--

CREATE TABLE `pm_kieuhoa` (
  `id` int(11) NOT NULL,
  `loai_hoa` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `pm_kieuhoa`
--

INSERT INTO `pm_kieuhoa` (`id`, `loai_hoa`) VALUES
(1, 'khai trương'),
(2, 'sinh nhật'),
(3, 'ngày cưới'),
(4, 'kỷ niệm'),
(5, 'tình yêu'),
(6, 'hoa bán'),
(7, 'hoa chia buồn'),
(8, 'hoa hạnh phúc');

-- --------------------------------------------------------

--
-- Table structure for table `shophoa`
--

CREATE TABLE `shophoa` (
  `id_hoa` int(11) NOT NULL,
  `ma_hoa` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `ten_hoa` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mota_hoa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanh_hoa` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `giaban_hoa` bigint(20) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `shophoa`
--

INSERT INTO `shophoa` (`id_hoa`, `ma_hoa`, `ten_hoa`, `mota_hoa`, `hinhanh_hoa`, `giaban_hoa`, `id`) VALUES
(1, 'SP-01', 'hoa thủy tiên', 'mô tả hoa thủy tiên', 'thuytien.j', 100000, 2),
(2, 'SP-02', 'hoa violet', 'mô tả hoa violet', 'violet.jpg', 120000, 1),
(3, 'SP-03', 'hoa lyly', 'mô tả hoa lyly', 'lyly.jpg', 130000, 3),
(4, 'SP-04', 'hoa lài', 'mô tả hoa lài', 'hoalai.jpg', 110000, 6),
(5, 'SP-05', 'hoa phong lan', 'mô tả hoa phong lan', 'phonglan.j', 140000, 6),
(6, 'SP-06', 'hoa cúc ', 'mô tả hoa cúc', 'cuc.jpg', 100000, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`);

--
-- Indexes for table `pm_kieuhoa`
--
ALTER TABLE `pm_kieuhoa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shophoa`
--
ALTER TABLE `shophoa`
  ADD PRIMARY KEY (`id_hoa`),
  ADD KEY `fk_shophoa_pm_kieuhoa` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id_login` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pm_kieuhoa`
--
ALTER TABLE `pm_kieuhoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `shophoa`
--
ALTER TABLE `shophoa`
  MODIFY `id_hoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `shophoa`
--
ALTER TABLE `shophoa`
  ADD CONSTRAINT `fk_shophoa_pm_kieuhoa` FOREIGN KEY (`id`) REFERENCES `pm_kieuhoa` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
