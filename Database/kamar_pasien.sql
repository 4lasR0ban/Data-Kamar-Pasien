-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2022 at 05:01 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kamar_pasien`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_kamar`
--

CREATE TABLE `data_kamar` (
  `id` int(5) NOT NULL,
  `kode_pasien` varchar(25) NOT NULL,
  `nama_pasien` varchar(255) NOT NULL,
  `kamar` varchar(255) NOT NULL,
  `last_update` datetime NOT NULL,
  `user_update` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_kamar`
--

INSERT INTO `data_kamar` (`id`, `kode_pasien`, `nama_pasien`, `kamar`, `last_update`, `user_update`) VALUES
(2, '002', 'Ujang', 'Kelinci1', '2022-04-27 09:25:38', 1),
(3, '003', 'Joko', 'Kijang1', '2022-04-27 09:26:04', 1),
(5, '001', 'Asep', 'Rusa1', '2022-04-29 13:18:19', 1),
(6, '004', 'Lucy', 'Gajah1', '2022-04-30 21:50:14', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_kamar`
--
ALTER TABLE `data_kamar`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_kamar`
--
ALTER TABLE `data_kamar`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
