/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.1.38-MariaDB : Database - db10118228penyewaanbarang
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db10118228penyewaanbarang` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db10118228penyewaanbarang`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `id_barang` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_cabang` int(11) unsigned NOT NULL,
  `nama` varchar(25) NOT NULL,
  `merk` varchar(25) NOT NULL,
  `tahun` year(4) NOT NULL,
  `jenis` varchar(15) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga_sewa` float NOT NULL,
  PRIMARY KEY (`id_barang`),
  KEY `id_cabang` (`id_cabang`),
  CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_cabang`) REFERENCES `cabang` (`id_cabang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

/*Table structure for table `cabang` */

DROP TABLE IF EXISTS `cabang`;

CREATE TABLE `cabang` (
  `id_cabang` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(80) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  PRIMARY KEY (`id_cabang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cabang` */

/*Table structure for table `detail_sewa` */

DROP TABLE IF EXISTS `detail_sewa`;

CREATE TABLE `detail_sewa` (
  `id_sewa` int(11) unsigned NOT NULL,
  `id_barang` int(11) unsigned NOT NULL,
  `jumlah` int(11) NOT NULL,
  `total` float DEFAULT NULL,
  `denda` float DEFAULT NULL,
  `keterangan_denda` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_sewa`,`id_barang`),
  KEY `id_barang` (`id_barang`),
  CONSTRAINT `detail_sewa_ibfk_1` FOREIGN KEY (`id_sewa`) REFERENCES `sewa` (`id_sewa`),
  CONSTRAINT `detail_sewa_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detail_sewa` */

/*Table structure for table `penyewa` */

DROP TABLE IF EXISTS `penyewa`;

CREATE TABLE `penyewa` (
  `no_ktp` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(80) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  PRIMARY KEY (`no_ktp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `penyewa` */

insert  into `penyewa`(`no_ktp`,`nama`,`alamat`,`kontak`) values 
('001XXX','Ade Irma','Jl. Sukajadi','087XXXXXXXXX'),
('010XXX','Fiki Fauzi','Jl. Sukajadi','089XXXXXXXXX'),
('011XXX','Adi Firmansyah','Jl. Sukajadi','085XXXXXXXXX'),
('022XXX','Vira Ayu','Jl. Cibeber','085XXXXXXXXX'),
('023XXX','Elvira Karina','Jl. Cimelati','0823XXXXXXXX'),
('031XXX','Aditya Muhammad','Jl. Kaum','085XXXXXXXXX'),
('032XXX','Maulana Fajar Shidiq','Jl. Kaum ','082312109237'),
('041XXX','Rara Fitri','Jl. Cibeber','082XXXXXXXXX'),
('042XXX','Fatoni Raihan','Jl. Kaum ','083XXXXXXXXX'),
('110XXX','Fitriani Ningsih','Jl. Cimelati','082XXXXXXXXX'),
('123XXX','Dani Hermawan','Jl. Parungkuda','085XXXXXXXXX'),
('200XXX','Putri Ayu Dewi','Jl. Cibeber','085XXXXXXXXX'),
('201XXX','Karina Putri','Jl. Cimelati','089XXXXXXXXX'),
('221XXX','Viska Ayu','Jl. Cibeber','089XXXXXXXXX'),
('321XXX','Rani Setiawan','Jl. Parungkuda','089XXXXXXXXX'),
('323XXX','Danu Rohim','Jl. Cibeber','081XXXXXXXXX'),
('421XXX','Vilya Hardi','Jl. Cimelati','085XXXXXXXXX'),
('431XXX','Ayu Dewi','Jl. Benda','082XXXXXXXXX'),
('441XXX','Viska Hardi','Jl. Cimelati','081XXXXXXXXX'),
('442XXX','Fauzi Hidayat','Jl. Benda','089XXXXXXXXX'),
('520XXX','Dewi Sinta','Jl. Benda','082XXXXXXXXX'),
('521XXX','Eri Setiawan','Jl. Parungkuda','081XXXXXXXXX'),
('529XXX','Sinta Susanti','Jl. Benda','081XXXXXXXXX'),
('530XXX','Rizky Firmansyah','Jl. Sukajadi','089XXXXXXXXX'),
('531XXX','Siska Suhaini','Jl. Cibeber','089XXXXXXXXX');

/*Table structure for table `sewa` */

DROP TABLE IF EXISTS `sewa`;

CREATE TABLE `sewa` (
  `id_sewa` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `no_ktp` varchar(20) NOT NULL,
  `id_user` int(11) unsigned NOT NULL,
  `id_cabang` int(11) unsigned NOT NULL,
  `tanggal_peminjaman` date NOT NULL,
  `peminjaman_sampai` date NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `total` float DEFAULT NULL,
  `denda` float DEFAULT NULL,
  PRIMARY KEY (`id_sewa`),
  KEY `no_ktp` (`no_ktp`),
  KEY `id_user` (`id_user`),
  KEY `id_cabang` (`id_cabang`),
  CONSTRAINT `sewa_ibfk_1` FOREIGN KEY (`no_ktp`) REFERENCES `penyewa` (`no_ktp`),
  CONSTRAINT `sewa_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  CONSTRAINT `sewa_ibfk_3` FOREIGN KEY (`id_cabang`) REFERENCES `cabang` (`id_cabang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sewa` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id_user` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_cabang` int(11) unsigned NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `alamat` varchar(80) NOT NULL,
  `kontak` varchar(13) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_cabang` (`id_cabang`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_cabang`) REFERENCES `cabang` (`id_cabang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
