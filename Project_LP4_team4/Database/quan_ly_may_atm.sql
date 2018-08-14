-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2018 at 11:29 AM
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
-- Database: `quan_ly_may_atm`
--

-- --------------------------------------------------------

--
-- Table structure for table `giao_dich`
--

CREATE TABLE `giao_dich` (
  `maGiaoDich` int(5) NOT NULL,
  `soTK` char(13) COLLATE utf8_unicode_ci NOT NULL,
  `thoiGian` char(30) COLLATE utf8_unicode_ci NOT NULL,
  `soTienThem` char(12) COLLATE utf8_unicode_ci NOT NULL,
  `soTienRut` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `maMayATM` char(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `maKH` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `giao_dich`
--

INSERT INTO `giao_dich` (`maGiaoDich`, `soTK`, `thoiGian`, `soTienThem`, `soTienRut`, `maMayATM`, `maKH`) VALUES
(1, '1111111111112', '2018-08-08 16:22:57', '0', '100000', 'May001', 3),
(2, '1111111111112', '2018-08-08 16:40:34', '0', '50000', 'May001', 3),
(5, '1111111111112', '2018-08-08 20:43:56', '50000', '0', 'Tại ngân hàng', 3),
(6, '1111111111112', '2018-08-08 20:47:52', '0', '100000', 'Tại ngân hàng', 3),
(7, '1111111111112', '2018-08-08 22:41:22', '0', '100000', 'May006', 3),
(8, '1111111111115', '2018-08-10 16:27:16', '0', '600000', 'Tại ngân hàng', 2),
(9, '1111111111115', '2018-08-10 16:27:49', '500000', '0', 'Tại ngân hàng', 2);

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `maKhachHang` int(6) NOT NULL,
  `tenKhachHang` char(30) COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` char(30) COLLATE utf8_unicode_ci NOT NULL,
  `maPhuong` int(3) NOT NULL,
  `soDienThoai` char(12) COLLATE utf8_unicode_ci NOT NULL,
  `email` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `soCMND` char(9) COLLATE utf8_unicode_ci NOT NULL,
  `soTheATM` char(16) COLLATE utf8_unicode_ci NOT NULL,
  `soTienTrongTK` char(14) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`maKhachHang`, `tenKhachHang`, `diaChi`, `maPhuong`, `soDienThoai`, `email`, `soCMND`, `soTheATM`, `soTienTrongTK`) VALUES
(1, 'Văn Mạnh', '5', 1, '01693254563', 'vanmanh@gmail.com', '123456789', '1111111111111113', '97020000'),
(2, 'Trần Duy Luân', '21 Ngô Quyền', 7, '0169695236', 'duyluan1995@gmail.com', '987654321', '1111111111111115', '99500000'),
(3, 'Van An', '2222', 1, '01693254563', 'vanmanh@gmail.com', '111111111', '1111111111111112', '189900000'),
(4, 'Van Nam', '25', 1, '0125412563', 'nam@gmail.com', '125412563', '1111111111111114', '1000000'),
(5, 'Van An', '25', 1, '0125362145', 'naj@hhh.kkk', '215236254', '1111111111111117', '100000'),
(6, 'Van Nha', '214', 1, '0123652589', 'manh@jjj.lll', '251426325', '1111111111111116', '1000000');

-- --------------------------------------------------------

--
-- Table structure for table `may_atm`
--

CREATE TABLE `may_atm` (
  `maMayATM` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `viTri` char(30) COLLATE utf8_unicode_ci NOT NULL,
  `maPhuong` int(3) NOT NULL,
  `tongTien` char(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `may_atm`
--

INSERT INTO `may_atm` (`maMayATM`, `viTri`, `maPhuong`, `tongTien`) VALUES
('May001', '888 Ngô Quyền', 14, '792900000'),
('May002', '69 Trần Hưng Đạo', 43, '896600000'),
('May003', '33 Lê Duẩn', 23, '782000000'),
('May004', '465 Lê Lợi', 13, '500000.0'),
('May005', '12 Phan Tứ', 24, '150000000'),
('May006', '74 Ngô Quyề', 34, '127900000'),
('May007', '67 Hùng Vương', 5, '80000000'),
('May008', '66 Lê Lợi', 1, '762000000'),
('May009', '41 Hai Bà Trưng', 19, '83400000'),
('May010', '86 Ngô Quyền', 29, '800000000'),
('May011', '23', 1, '2000200000'),
('May012', '555', 1, '1000000'),
('May013', '22', 1, '102300000'),
('May014', '55', 1, '1000000'),
('May015', '25', 1, '1200000'),
('May016', '66', 1, '210000'),
('May017', '2', 1, '400000'),
('May018', '25', 1, '400000');

-- --------------------------------------------------------

--
-- Table structure for table `phuong`
--

CREATE TABLE `phuong` (
  `maPhuong` int(3) NOT NULL,
  `maQuan` int(3) NOT NULL,
  `tenPhuong` char(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phuong`
--

INSERT INTO `phuong` (`maPhuong`, `maQuan`, `tenPhuong`) VALUES
(1, 1, 'Hòa An'),
(2, 1, 'Hòa Phát'),
(3, 1, 'Hòa Thọ Đông'),
(4, 1, 'Hòa Thọ Tây'),
(5, 1, 'Hòa Xuân'),
(6, 1, 'Khê Trung'),
(7, 2, 'Bình Hiên'),
(8, 2, 'Bình Thuận'),
(9, 2, 'Hải Châu 1'),
(10, 2, 'Hải Châu 2'),
(11, 2, 'Hòa Cường Bắc'),
(12, 2, 'Hòa Cường Nam'),
(13, 2, 'Hòa Thuận Đông'),
(14, 2, 'Hòa Thuận Tây'),
(15, 2, 'Nam Dương'),
(16, 2, 'Phước Ninh'),
(17, 2, 'Thạch Khang'),
(18, 2, 'Thanh Bình'),
(19, 2, 'Thuận Phước'),
(20, 3, 'Hòa Hiệp Bắc'),
(21, 3, 'Hòa Hiệp Nam'),
(22, 3, 'Hòa Khánh Bắc'),
(23, 3, 'Hòa Khánh Nam'),
(24, 3, 'Hòa Minh'),
(25, 4, 'Hòa Hải'),
(26, 4, 'Hòa Quý'),
(27, 4, 'Khuê Mỹ'),
(28, 4, 'Mỹ An'),
(29, 5, 'An Hải Bắc'),
(30, 5, 'An Hải Đông'),
(31, 5, 'An Hải Tây'),
(32, 5, 'Mân Thái'),
(33, 5, 'Nại Hiên Đông'),
(34, 5, 'Phước Mỹ'),
(35, 5, 'Thọ Quang'),
(36, 6, 'An Khê'),
(37, 6, 'Chính Gián'),
(38, 6, 'Hòa Khê'),
(39, 6, 'Tam Thuận'),
(40, 6, 'Tân Chính'),
(41, 6, 'Thạc Gián'),
(42, 6, 'Thanh Khê Đông'),
(43, 6, 'Thanh Khê Tây'),
(44, 6, 'Vĩnh Trung'),
(45, 6, 'Xuân Hà');

-- --------------------------------------------------------

--
-- Table structure for table `quan`
--

CREATE TABLE `quan` (
  `maQuan` int(3) NOT NULL,
  `tenQuan` char(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `quan`
--

INSERT INTO `quan` (`maQuan`, `tenQuan`) VALUES
(1, 'Cẩm Lệ'),
(2, 'Hải Châu'),
(3, 'Liên Chiểu'),
(4, 'Ngũ Hành Sơn'),
(5, 'Sơn Trà'),
(6, 'Thanh Khê');

-- --------------------------------------------------------

--
-- Table structure for table `the_atm`
--

CREATE TABLE `the_atm` (
  `soTK` char(13) COLLATE utf8_unicode_ci NOT NULL,
  `pass` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `soTheATM` char(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `the_atm`
--

INSERT INTO `the_atm` (`soTK`, `pass`, `soTheATM`) VALUES
('1111111111112', '111111', '1111111111111112'),
('1111111111113', '000000', '1111111111111113'),
('1111111111114', '000000', '1111111111111114'),
('1111111111115', '000000', '1111111111111115'),
('1111111111116', '000000', '1111111111111116'),
('1111111111117', '000000', '1111111111111117'),
('1111111111118', '000000', '1111111111111118'),
('1111111111119', '000000', '1111111111111119'),
('1111111111120', '000000', '1111111111111120'),
('1111111111121', '000000', '1111111111111121'),
('1111111111122', '000000', '1111111111111122'),
('1111111111123', '000000', '1111111111111123'),
('1111111111124', '000000', '1111111111111124'),
('1111111111125', '000000', '1111111111111125');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `giao_dich`
--
ALTER TABLE `giao_dich`
  ADD PRIMARY KEY (`maGiaoDich`),
  ADD KEY `fk_giao_dich_may_atm_maMayATM` (`maMayATM`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`maKhachHang`),
  ADD UNIQUE KEY `soTheATM` (`soTheATM`),
  ADD UNIQUE KEY `soCMND` (`soCMND`),
  ADD KEY `fk_khach_hang_danh_sach_phuong_maPhuong` (`maPhuong`);

--
-- Indexes for table `may_atm`
--
ALTER TABLE `may_atm`
  ADD PRIMARY KEY (`maMayATM`),
  ADD KEY `fk_ma_atm_danh_sach_phuong_maPhuong` (`maPhuong`);

--
-- Indexes for table `phuong`
--
ALTER TABLE `phuong`
  ADD PRIMARY KEY (`maPhuong`),
  ADD KEY `fk_maQuan` (`maQuan`);

--
-- Indexes for table `quan`
--
ALTER TABLE `quan`
  ADD PRIMARY KEY (`maQuan`);

--
-- Indexes for table `the_atm`
--
ALTER TABLE `the_atm`
  ADD PRIMARY KEY (`soTheATM`),
  ADD UNIQUE KEY `soTK` (`soTK`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `giao_dich`
--
ALTER TABLE `giao_dich`
  MODIFY `maGiaoDich` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `maKhachHang` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `phuong`
--
ALTER TABLE `phuong`
  MODIFY `maPhuong` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD CONSTRAINT `fk_khach_hang_danh_sach_phuong_maPhuong` FOREIGN KEY (`maPhuong`) REFERENCES `phuong` (`maPhuong`),
  ADD CONSTRAINT `fk_th_atm_khach_hang_soTK` FOREIGN KEY (`soTheATM`) REFERENCES `the_atm` (`soTheATM`);

--
-- Constraints for table `may_atm`
--
ALTER TABLE `may_atm`
  ADD CONSTRAINT `fk_ma_atm_danh_sach_phuong_maPhuong` FOREIGN KEY (`maPhuong`) REFERENCES `phuong` (`maPhuong`);

--
-- Constraints for table `phuong`
--
ALTER TABLE `phuong`
  ADD CONSTRAINT `fk_maQuan` FOREIGN KEY (`maQuan`) REFERENCES `quan` (`maQuan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
