-- phpMyAdmin SQL Dump
-- version 4.8.0.1
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
-- Database: `quan_ly_thu_vien`
--

-- --------------------------------------------------------

--
-- Table structure for table `loai_sach`
--

CREATE TABLE `loai_sach` (
  `ma_loai_sach` tinyint(2) NOT NULL,
  `loai_sach` char(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loai_sach`
--

INSERT INTO `loai_sach` (`ma_loai_sach`, `loai_sach`) VALUES
(1, 'Truyện tranh'),
(2, 'Tiểu thuyết'),
(3, 'Sách tham khảo'),
(4, 'Báo');

-- --------------------------------------------------------

--
-- Table structure for table `quan_ly_sach`
--

CREATE TABLE `quan_ly_sach` (
  `ma_sach` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_sach` char(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gia_tien` int(9) NOT NULL,
  `gia_tien_muon` int(7) NOT NULL,
  `so_luong` tinyint(3) NOT NULL,
  `so_luong_con_lai` tinyint(3) NOT NULL,
  `ma_loai_sach` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `quan_ly_sach`
--

INSERT INTO `quan_ly_sach` (`ma_sach`, `ten_sach`, `gia_tien`, `gia_tien_muon`, `so_luong`, `so_luong_con_lai`, `ma_loai_sach`) VALUES
('A1', 'Do-re-mon', 25000, 2000, 20, 15, 1),
('A2', 'Conan', 28000, 2800, 40, 15, 1),
('B1', 'Tam sinh tam thế', 200000, 10000, 10, 7, 2),
('C1', 'Giải toán 12', 35000, 3000, 30, 25, 3),
('D1', 'Báo thiếu nhi', 5000, 500, 50, 23, 4);

-- --------------------------------------------------------

--
-- Table structure for table `thanh_vien`
--

CREATE TABLE `thanh_vien` (
  `so_the` int(4) NOT NULL,
  `ten_nguoi_doc` char(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gia_tien_coc` int(9) NOT NULL,
  `dia_chi` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `so_dien_thoai` char(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `so_cmnd` char(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `thanh_vien`
--

INSERT INTO `thanh_vien` (`so_the`, `ten_nguoi_doc`, `gia_tien_coc`, `dia_chi`, `so_dien_thoai`, `so_cmnd`) VALUES
(1, 'Nguyễn Văn A', 200000, 'Gia Lai', '0987654321', '231082864'),
(2, 'Nguyễn Thị S', 205000, 'Quảng Nam', '0987654321', '243082864'),
(3, 'Nguyễn Văn C', 250000, 'Đà Nẵng', '09876532321', '2310822264'),
(4, 'Nguyễn Văn D', 300000, 'Hà Nội', '0987652221', '2312242864');

-- --------------------------------------------------------

--
-- Table structure for table `tra_muon_sach`
--

CREATE TABLE `tra_muon_sach` (
  `so_the` int(4) NOT NULL,
  `ma_sach` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `thoi_gian_muon` date NOT NULL,
  `han_thoi_gian_tra` date NOT NULL,
  `thoi_gian_tra` char(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_loai_sach` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tra_muon_sach`
--

INSERT INTO `tra_muon_sach` (`so_the`, `ma_sach`, `thoi_gian_muon`, `han_thoi_gian_tra`, `thoi_gian_tra`, `ma_loai_sach`) VALUES
(1, 'A2', '2018-02-12', '2018-03-10', '2018/3/7', 1),
(2, 'A1', '2017-07-20', '2017-10-10', 'chưa trả', 1),
(3, 'C1', '2018-02-14', '2018-06-01', '2018/4/14', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tt_vi_pham`
--

CREATE TABLE `tt_vi_pham` (
  `so_the` int(4) NOT NULL,
  `vi_pham` char(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_sach` char(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_loai_sach` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tt_vi_pham`
--

INSERT INTO `tt_vi_pham` (`so_the`, `vi_pham`, `ma_sach`, `ma_loai_sach`) VALUES
(2, 'làm mất', 'A1', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `loai_sach`
--
ALTER TABLE `loai_sach`
  ADD PRIMARY KEY (`ma_loai_sach`);

--
-- Indexes for table `quan_ly_sach`
--
ALTER TABLE `quan_ly_sach`
  ADD PRIMARY KEY (`ma_sach`),
  ADD KEY `fk_quan_quan_ly_sach_loai_sach` (`ma_loai_sach`);

--
-- Indexes for table `thanh_vien`
--
ALTER TABLE `thanh_vien`
  ADD PRIMARY KEY (`so_the`);

--
-- Indexes for table `tra_muon_sach`
--
ALTER TABLE `tra_muon_sach`
  ADD PRIMARY KEY (`so_the`),
  ADD KEY `fk_nguoi_doc_quan_ly_sach` (`ma_sach`);

--
-- Indexes for table `tt_vi_pham`
--
ALTER TABLE `tt_vi_pham`
  ADD PRIMARY KEY (`so_the`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `thanh_vien`
--
ALTER TABLE `thanh_vien`
  MODIFY `so_the` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `quan_ly_sach`
--
ALTER TABLE `quan_ly_sach`
  ADD CONSTRAINT `fk_quan_quan_ly_sach_loai_sach` FOREIGN KEY (`ma_loai_sach`) REFERENCES `loai_sach` (`ma_loai_sach`);

--
-- Constraints for table `tra_muon_sach`
--
ALTER TABLE `tra_muon_sach`
  ADD CONSTRAINT `fk_nguoi_doc_quan_ly_sach` FOREIGN KEY (`ma_sach`) REFERENCES `quan_ly_sach` (`ma_sach`),
  ADD CONSTRAINT `fk_nguoi_doc_thanh_vien` FOREIGN KEY (`so_the`) REFERENCES `thanh_vien` (`so_the`);

--
-- Constraints for table `tt_vi_pham`
--
ALTER TABLE `tt_vi_pham`
  ADD CONSTRAINT `fk_TT_vi_pham_thanh_vien` FOREIGN KEY (`so_the`) REFERENCES `thanh_vien` (`so_the`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
