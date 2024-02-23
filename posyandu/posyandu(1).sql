-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Agu 2021 pada 10.04
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posyandu`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_balita`
--

CREATE TABLE `tb_balita` (
  `no_registrasi` varchar(10) NOT NULL DEFAULT '',
  `nama_balita` varchar(25) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `umur` int(50) DEFAULT NULL,
  `jenis_kelamin` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_balita`
--

INSERT INTO `tb_balita` (`no_registrasi`, `nama_balita`, `tgl`, `umur`, `jenis_kelamin`) VALUES
('B0001', 'dennys', '2021-08-03', 1, 'Laki-laki'),
('B0002', 'bita', '2021-08-05', 1, 'perempuan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_gizi`
--

CREATE TABLE `tb_gizi` (
  `kode_gizi` varchar(50) NOT NULL,
  `kode_kegiatan` varchar(50) NOT NULL,
  `nama_kegiatan` varchar(50) NOT NULL,
  `no_regis` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_gizi`
--

INSERT INTO `tb_gizi` (`kode_gizi`, `kode_kegiatan`, `nama_kegiatan`, `no_regis`, `nama`, `status`) VALUES
('G0001', 'K0001', 'marpuah', 'B0001', 'dennys', 'baik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_ibu`
--

CREATE TABLE `tb_ibu` (
  `kode_ibu` varchar(20) NOT NULL DEFAULT '',
  `nama_ibu` varchar(20) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `umur` int(2) NOT NULL,
  `no_tlp` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_ibu`
--

INSERT INTO `tb_ibu` (`kode_ibu`, `nama_ibu`, `tanggal_lahir`, `alamat`, `umur`, `no_tlp`) VALUES
('I0001', 'marpuah', '2021-08-06', 'depok', 25, '0231231231'),
('I0002', 'jenny', '2021-08-02', 'depok', 20, '0312132131'),
('I0003', 'gina', '2021-08-03', 'depok lama', 42, '031231131');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kegiatan`
--

CREATE TABLE `tb_kegiatan` (
  `kodeibu` varchar(15) NOT NULL,
  `nama_ibu` varchar(20) DEFAULT NULL,
  `kode_kegiatan` varchar(20) NOT NULL,
  `judul` varchar(50) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `penanggung_jawab` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_kegiatan`
--

INSERT INTO `tb_kegiatan` (`kodeibu`, `nama_ibu`, `kode_kegiatan`, `judul`, `tgl`, `penanggung_jawab`) VALUES
('I0001', 'marpuah', 'K0001', 'CEK GIZI', '2021-08-26', 'bidan A'),
('I0002', 'jenny', 'K0002', 'PENIMBANGAN', '2021-08-25', 'Bidan B');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `id` int(5) NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`id`, `username`, `password`) VALUES
(2, 'admin', 'admin123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_penimbangan`
--

CREATE TABLE `tb_penimbangan` (
  `kode_penimbangan` varchar(50) NOT NULL,
  `kode_regis` varchar(50) NOT NULL,
  `kode_kegiatan` varchar(50) NOT NULL,
  `nama_ibu` varchar(50) NOT NULL,
  `nama_balita` varchar(50) NOT NULL,
  `bulan` varchar(50) NOT NULL,
  `berat` int(50) NOT NULL,
  `tinggi` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_penimbangan`
--

INSERT INTO `tb_penimbangan` (`kode_penimbangan`, `kode_regis`, `kode_kegiatan`, `nama_ibu`, `nama_balita`, `bulan`, `berat`, `tinggi`) VALUES
('T0001', 'B0001', 'K0001', 'marpuah', 'dennys', '1', 20, 23);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_balita`
--
ALTER TABLE `tb_balita`
  ADD PRIMARY KEY (`no_registrasi`);

--
-- Indeks untuk tabel `tb_gizi`
--
ALTER TABLE `tb_gizi`
  ADD PRIMARY KEY (`kode_gizi`),
  ADD UNIQUE KEY `no_regis` (`no_regis`),
  ADD KEY `kode_kegiatan` (`kode_kegiatan`) USING BTREE;

--
-- Indeks untuk tabel `tb_ibu`
--
ALTER TABLE `tb_ibu`
  ADD PRIMARY KEY (`kode_ibu`);

--
-- Indeks untuk tabel `tb_kegiatan`
--
ALTER TABLE `tb_kegiatan`
  ADD PRIMARY KEY (`kode_kegiatan`),
  ADD KEY `kodeibu` (`kodeibu`) USING BTREE;

--
-- Indeks untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_penimbangan`
--
ALTER TABLE `tb_penimbangan`
  ADD PRIMARY KEY (`kode_penimbangan`),
  ADD KEY `kode_regis` (`kode_regis`,`kode_kegiatan`) USING BTREE;

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
