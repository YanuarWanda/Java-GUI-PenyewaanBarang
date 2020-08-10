/*
SQLyog Ultimate v12.5.1 (64 bit)
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

/*Data for the table `cabang` */

insert  into `cabang`(`id_cabang`,`nama`,`alamat`,`kontak`) values 
(1,'Cabang 1','Jl. Cabang 1.','087825418390'),
(2,'Cabang 2','Jl. Cabang 2.','087825418391'),
(3,'Cabang 3','Jl. Cabang 3.','0857555764'),
(4,'Cabang 4','Jl. Cabang 4.','0838555299'),
(5,'Cabang 5','Jl. Cabang 5.','0838543265'),
(6,'Cabang 6','Jl. Cabang 6.','0818743255'),
(7,'Cabang 7','Jl. Cabang 7.','0818713256'),
(8,'Cabang 8','Jl. Cabang 8.','0828714266'),
(9,'Cabang 9','Jl. Cabang 9.','0828814267'),
(10,'Cabang 10','Jl. Cabang 10.','0828872867'),
(11,'Cabang 11','Jl. Cabang 11.','0812842869'),
(12,'Cabang 12','Jl. Cabang 12.','0812843869'),
(13,'Cabang 13','Jl. Cabang 13.','0813843862'),
(14,'Cabang 14','Jl. Cabang 14.','0812843863'),
(15,'Cabang 15','Jl. Cabang 15.','0812943864'),
(16,'Cabang 16','Jl. Cabang 16.','0812043865'),
(17,'Cabang 17','Jl. Cabang 17.','0812043966'),
(18,'Cabang 18','Jl. Cabang 18.','0812143967'),
(19,'Cabang 19','Jl. Cabang 19.','0812153967'),
(20,'Cabang 20','Jl. Cabang 20.','0813153977'),
(21,'Cabang 21','Jl. Cabang 21.','0813253978'),
(22,'Cabang 22','Jl. Cabang 22.','0813263977'),
(23,'Cabang 23','Jl. Cabang 23.','0813265987'),
(24,'Cabang 24','Jl. Cabang 24.','0813365987'),
(25,'Cabang 25','Jl. Cabang 25.','0813365997'),
(26,'Cabang 26','Jl. Cabang 26.','0815365999'),
(27,'Cabang 27','Jl. Cabang 27.','0815365100'),
(28,'Cabang 28','Jl. Cabang 28.','0815365101'),
(29,'Cabang 29','Jl. Cabang 29.','0815365102'),
(30,'Cabang 30','Jl. Cabang 30.','0815365103'),
(31,'Cabang 31','Jl. Cabang 31.','0815365104'),
(32,'Cabang 32','Jl. Cabang 32.','0815365105'),
(33,'Cabang 33','Jl. Cabang 33.','0815365106'),
(34,'Cabang 34','Jl. Cabang 34.','0815365107'),
(35,'Cabang 35','Jl. Cabang 35.','0815365108'),
(36,'Cabang 36','Jl. Cabang 36.','0815365109'),
(37,'Cabang 37','Jl. Cabang 37.','0815365110'),
(38,'Cabang 38','Jl. Cabang 38.','0815365111'),
(39,'Cabang 39','Jl. Cabang 39.','0815365112'),
(40,'Cabang 40','Jl. Cabang 40.','0815365113'),
(41,'Cabang 41','Jl. Cabang 41.','0816365101'),
(42,'Cabang 42','Jl. Cabang 42.','0816365109'),
(43,'Cabang 43','Jl. Cabang 43.','0816365103'),
(44,'Cabang 44','Jl. Cabang 44.','0816365104'),
(45,'Cabang 45','Jl. Cabang 45.','0816365105'),
(46,'Cabang 46','Jl. Cabang 46.','0816365106'),
(47,'Cabang 47','Jl. Cabang 47.','0816365107'),
(48,'Cabang 48','Jl. Cabang 48.','0816365108'),
(49,'Cabang 49','Jl. Cabang 49.','0816365109'),
(50,'Cabang 50','Jl. Cabang 50.','0816665555');

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
('002XXX','Estiawan Aslijan','Jl. Baranangsiang','084248483183'),
('008XXX','Patricia Haryanti','Jl. Elang','087332847512'),
('010XXX','Fiki Fauzi','Jl. Sukajadi','089XXXXXXXXX'),
('011XXX','Adi Firmansyah','Jl. Sukajadi','085XXXXXXXXX'),
('019XXX','Umi Puspita','Jl. Elang','082394848512'),
('022XXX','Vira Ayu','Jl. Cibeber','085XXXXXXXXX'),
('023XXX','Elvira Karina','Jl. Cimelati','0823XXXXXXXX'),
('029XXX','Laras Maya','Jl. Elang','083457382192'),
('031XXX','Aditya Muhammad','Jl. Kaum','085XXXXXXXXX'),
('032XXX','Fajar Shidiq','Jl. Kaum ','082312109237'),
('033XXX','Aris Setiawan','Jl. Achmad Yani','084908860506'),
('041XXX','Rara Fitri','Jl. Cibeber','082XXXXXXXXX'),
('042XXX','Fatoni Raihan','Jl. Kaum ','083XXXXXXXXX'),
('065XXX','Pandu Nainggolan','Jl. Nangka','084343923091'),
('077XXX','Najib Uwais','Jl. Kaum','089348586023'),
('081XXX','Balijan Wahyudin','Jl. Wahid Hasyim','089367890909'),
('082XXX','Muhammad Firgantoro','Jl. Baranangsiang','087436557321'),
('088XXX','Latika Melinda','Jl. Nangka','082448582193'),
('089XXX','Kanda Dipa','Jl. Cibeber','083238485123'),
('090XXX','Lurhur Asmuni Ardianto','Jl. Achmad Yani','082681633043'),
('092XXX','Ina Melani','Jl. Wahid Hasyim','093508299885'),
('098XXX','Respati Winarno','Jl. Achmad Yani','089323932391'),
('099XXX','Harsaya Danuja','Jl. Cokroaminoto','081663731928'),
('100XXX','Kajen Siregar','Jl. Cokroaminoto','089132090912'),
('101XXX','Bakiono Tarihoran','Jl. Nangka','082313090912'),
('110XXX','Fitriani Ningsih','Jl. Cimelati','082XXXXXXXXX'),
('123XXX','Dani Hermawan','Jl. Parungkuda','085XXXXXXXXX'),
('190XXX','Marsudi Pardi','Jl. Cibeber','086321838481'),
('200XXX','Putri Ayu Dewi','Jl. Cibeber','085XXXXXXXXX'),
('201XXX','Karina Putri','Jl. Cimelati','089XXXXXXXXX'),
('221XXX','Viska Ayu','Jl. Cibeber','089XXXXXXXXX'),
('230XXX','Taufan Manullang','Jl. Cimelati','082392239323'),
('321XXX','Rani Setiawan','Jl. Parungkuda','089XXXXXXXXX'),
('323XXX','Danu Rohim','Jl. Cibeber','081XXXXXXXXX'),
('330XXX','Omar Pradipta','Jl. Sukajadi','082323847212'),
('421XXX','Vilya Hardi','Jl. Cimelati','085XXXXXXXXX'),
('429XXX','Puti Halimah','Jl. Elang','083293090807'),
('430XXX','Maryadi Elvin','Jl. Wahid Hasyim','087311814589'),
('431XXX','Ayu Dewi','Jl. Benda','082XXXXXXXXX'),
('441XXX','Viska Hardi','Jl. Cimelati','081XXXXXXXXX'),
('442XXX','Fauzi Hidayat','Jl. Benda','089XXXXXXXXX'),
('443XXX','Azalea Ade','Jl. Kaum','084741998422'),
('520XXX','Dewi Sinta','Jl. Benda','082XXXXXXXXX'),
('521XXX','Eri Setiawan','Jl. Parungkuda','081XXXXXXXXX'),
('528XXX','Vero Prasasta','Jl. Parungkuda','087564475874'),
('529XXX','Sinta Susanti','Jl. Benda','081XXXXXXXXX'),
('530XXX','Rizky Firmansyah','Jl. Sukajadi','089XXXXXXXXX'),
('531XXX','Siska Suhaini','Jl. Cibeber','089XXXXXXXXX'),
('554XXX','Hendra Rusman','Jl. Benda','082448583212');

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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id_user`,`id_cabang`,`nama`,`username`,`password`,`status`,`alamat`,`kontak`,`tanggal_lahir`) values 
(1,1,'Kani Permata','kanipest','67c46f01','pegawai','Jr. Baung No. 41, Dumai 73583, JaTeng','088214728124','2000-02-02'),
(2,1,'asep supra','as3','123','admin','Jl. Cempaka','088192745921','2000-01-01'),
(3,2,'udin hilman','oden','thor','admin','Perum Puri 1','089739433022','2000-03-03'),
(4,2,'fajar shidiq','anime','game123','pegawai','Perum SukaBulan','082192834721','2000-04-04'),
(5,3,'Ilham Fauzan','mugi321','onepiece','admin','Perum GACC','088218812338','1999-03-14'),
(6,3,'Agatha Irma','kfr123','pieceone','pegawai','Jl. utara Jember','085912322181','1999-12-18'),
(7,4,'Yanuar Wakanda','mhs123','codelabss','admin','Jl. Bandoeng ','088123123456','2000-05-05'),
(8,4,'Andre Taulani','temansule','00000','pegawai','Jl. Riau, Riau','081214867896','2000-06-06'),
(9,5,'Arvelino rizky','nokomen','komendong','admin','Jl. sendiri, Bandung barat','082947826461','2000-07-07'),
(10,5,'Syifa nabila','if1','apayah','pegawai','Perum SukaBulan','083492876362','2000-08-08'),
(11,6,'audriana kadi','if2','opo','admin','Jl. Afrika Asia','082999888777','2000-09-09'),
(12,6,'firaga','codng','inyahilang','pegawai','Jl. Sewa Jalam','089283745722','2000-10-10'),
(13,7,'D Luffy','mugiwara','rajabajaklaut','admin','Perum East Blue','081112223334','2000-11-12'),
(14,7,'R Zoro','piratehunter','santoriyu','pegawai','Perum East Blue','084455566677','2000-12-11'),
(15,8,'Nami Putri','catbuglar','berry','admin','Jl. Selatan atas','082846462819','1999-01-23'),
(16,8,'Robin endah ','arch','hana','pegawai','Jl Utara bawah','082148372845','1999-02-28'),
(17,9,'Tony Chopper','dokter','rumble','admin','Perum snow','085746464648','1999-04-08'),
(18,9,'Ussop','sniper','headshot','pegawai','Jl. Pembohong','082341276874','1999-06-15'),
(19,10,'brook skele','yohoho','45','admin','Jl. thriller','085123734821','1999-07-07'),
(20,10,'franky shogun','super','robo','pegawai','Perum Water Seven','089741294726','1999-07-09'),
(21,11,'jimbe ace','fish','karate','admin','Jl. Ikan terbang','088296464455','1999-08-02'),
(22,11,'yamato oden','thunder','bangua','pegawai','Jl. Terinspirasi','081228766500','1999-09-17'),
(23,12,'charrot katakuri','rabbit','mochi','admin','Jl. apa','082200480320','1999-10-01'),
(24,12,'perospero marco','doku','phoenix','pegawai','Jl. Baros','088100230230','1999-11-11'),
(25,13,'kaido king','beast','gifter','admin','Jl. Boros','088200909098','2001-02-23'),
(26,13,'alfarizi ','ojek','sangat123','pegawai','Jl. Baros','081234567890','2001-03-30'),
(27,14,'rahmawai ','guru','hebat','admin','Jl. Utama ','089876543210','2001-03-28'),
(28,14,'dean ramadhan ','arsitek','pinter123','pegawai','Jl. ciamis','089123987456','2001-09-17'),
(29,15,'ihsan fauzani','sipil','ngakak123','admin','Jl apa','089263521736','2001-09-17'),
(30,15,'ghassani','uuu333','paja','pegawai','Perum snow','089637465198','1998-12-12'),
(31,16,'aokiji','cold','dingin888','admin','Perum snow','088100338877','1998-09-02'),
(32,16,'sakajuki ','magma','panas999','pegawai','Jl.Gunung','088779953390','1998-01-01'),
(33,17,'asyraf mujaffar','patah','tuangbos','admin','Perum Puri 2','085720098086','1995-05-17'),
(34,17,'raffi najrudin','wan','one','pegawai','Perum Puri 2','085679043218','2001-06-12'),
(35,18,'Kamado Tanjiro','Air ','Water4','admin','Jl. Pemburu','089274563871','2001-12-24'),
(36,18,'Kibutsuji Mujan','Demon','hohoho','pegawai','Jl. Pemburu','089764172834','2002-11-20'),
(37,19,'Amelian Aulia','yuhuu','bauu44','admin','Jl. GACC','082386740443','2000-06-15'),
(38,19,'Putri Febriani','ihh1111','pendekTa4','pegawai','Jl. cisarua','082844767785','2000-03-19'),
(39,20,'Citha ','ini00','mungki11n','admin','Jl. cisarua','082895688855','2000-01-05'),
(40,20,'ghifari kautsar','domba','mbee','pegawai','Perum Bukit Permata','081789986700','1999-07-13'),
(41,21,'Ilham Luffy','n4xtmugiwara','fakt4400','admin','Perum Bukit Permata','088276878443','1999-11-25'),
(42,21,'rizky abe','abe123','655656','pegawai','Jl. Padalarang','088200077353','1999-04-14'),
(43,22,'riffa usep','cupss','555555','admin','Jl. Barca','082547549333','2001-04-27'),
(44,22,'davidson','g4gn','ooo000','pegawai','Perum DiSubang','088133333333','2001-04-26'),
(45,23,'faishal masri','terlupakan','numpain666','admin','Perum Hujan','081986987698','2000-02-20'),
(46,23,'faris rizky','paris','prancis','pegawai','Jl. Rattotuile','085965667676','1999-12-03'),
(47,24,'ikrar nugraha','dota2','gabisa','admin','Jl. Cibiru','081009988800','1999-05-15'),
(48,24,'Nanda Amelia','enol0','qwerty','pegawai','Jl. Cihanjuang','089887642431','1998-10-20'),
(49,25,'Asyifa maulia','huhuhu','uhuhuh','admin','Jl. Elang','088238059053','2000-11-05'),
(50,25,'nurdin top','arduino','uno','pegawai','Jl. Elang','088217600879','2000-01-15');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
