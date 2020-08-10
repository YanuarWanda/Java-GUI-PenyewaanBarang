DROP DATABASE IF EXISTS db10118228PenyewaanBarang;
CREATE DATABASE db10118228PenyewaanBarang;
USE db10118228PenyewaanBarang;

CREATE TABLE cabang (
    id_cabang INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(30) NOT NULL,
    alamat VARCHAR(80) NOT NULL,
    kontak VARCHAR(13) NOT NULL
);

CREATE TABLE user (
    id_user INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    id_cabang INT(11) UNSIGNED NOT NULL,
    nama VARCHAR(30) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    alamat VARCHAR(80) NOT NULL,
    kontak VARCHAR(13) NOT NULL,
    tanggal_lahir DATE NOT NULL,
    FOREIGN KEY (id_cabang) REFERENCES cabang(id_cabang)
);

CREATE TABLE penyewa (
    no_ktp VARCHAR(20) PRIMARY KEY,
    nama VARCHAR(30) NOT NULL,
    alamat VARCHAR(80) NOT NULL,
    kontak VARCHAR(13) NOT NULL
);

CREATE TABLE barang (
    id_barang INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    id_cabang INT(11) UNSIGNED NOT NULL,
    nama VARCHAR(25) NOT NULL,
    merk VARCHAR(25) NOT NULL,
    tahun YEAR NOT NULL,
    jenis VARCHAR(15) NOT NULL,
    stok INT(11) NOT NULL,
    harga_sewa FLOAT NOT NULL,
    FOREIGN KEY (id_cabang) REFERENCES cabang(id_cabang)
);

CREATE TABLE sewa (
    id_sewa INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    no_ktp VARCHAR(20) NOT NULL,
    id_user INT(11) UNSIGNED NOT NULL,
    id_cabang INT(11) UNSIGNED NOT NULL,
    tanggal_peminjaman DATE NOT NULL,
    peminjaman_sampai DATE NOT NULL,
    tanggal_pengembalian DATE,
    total FLOAT,
    denda FLOAT,
    FOREIGN KEY (no_ktp) REFERENCES penyewa(no_ktp),
    FOREIGN KEY (id_user) REFERENCES user(id_user),
    FOREIGN KEY (id_cabang) REFERENCES cabang(id_cabang)
);

CREATE TABLE detail_sewa (
    id_sewa INT(11) UNSIGNED,
    id_barang INT(11) UNSIGNED,
    jumlah INT(11) NOT NULL,
    total FLOAT,
    denda FLOAT,
    keterangan_denda VARCHAR(50),
    PRIMARY KEY (id_sewa, id_barang),
    FOREIGN KEY (id_sewa) REFERENCES sewa(id_sewa) ON DELETE CASCADE,
    FOREIGN KEY (id_barang) REFERENCES barang(id_barang)
);

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

INSERT INTO user VALUES 
(1, 1, "User 1", "user1", "user123", "admin", "Jl. User 1.", "08217050905", "2001-01-18"),
(2, 1, "User 2", "user2", "user123", "pegawai", "Jl. User 2.", "08217050906", "2001-01-19"),
(3, 2, "User 3", "user3", "user123", "admin", "Jl. User 3.", "08217050907", "2001-01-20");

INSERT INTO barang VALUES
(1, 1, "Barang 1", "Merk 1", 1984, "Jenis 1", 20, 35000),
(2, 1, "Barang 2", "Merk 2", 1999, "Jenis 2", 3, 75000),
(3, 1, "Barang 3", "Merk 3", 2012, "Jenis 3", 80, 7500);

INSERT INTO sewa VALUES
(1, "001XXX", 1, 1, "2020-08-07", "2020-08-09", NULL, 290000, NULL);

INSERT INTO detail_sewa VALUES
(1, 1, 2, 140000, NULL, NULL),
(1, 2, 1, 150000, NULL, NULL);
