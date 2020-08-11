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

insert  into `barang`(`id_barang`,`id_cabang`,`nama`,`merk`,`tahun`,`jenis`,`stok`,`harga_sewa`) values 
(1,1,'Kamera Canon 100D','Canon',2014,'Photography',20,1000000),
(2,1,'Kamera Canon 1200D','Canon',2019,'Photography',3,890000),
(3,2,'Kamera Canon 600D','Canon',2018,'Photography',12,944000),
(4,2,'Kamera Canon 1300D','Canon',2020,'Photography',8,1700000),
(5,3,'Kamera Canon 700D','Canon',2018,'Photography',4,988000),
(6,3,'Kamera Fujifilm X-A20','Fujifilm',2020,'Photography',18,750000),
(7,4,'Kamera Fujifilm X-T10','Fujifilm',2020,'Photography',30,135000),
(8,4,'Kamera Fujifilm Instax Mi','Fujifilm',2020,'Photography',8,2075000),
(9,5,'Kamera Fujifilm XT100','Fujifilm',2019,'Photography',10,1500000),
(10,5,'Kamera Fujifilm Instax Mi','Fujifilm',2015,'Photography',22,835000),
(11,6,'Vacuum Cleaner','Panasonic',2015,'Elektronik',21,1750000),
(12,6,'Vacuum Cleaner','Panasonic',2012,'Elektronik',80,697500),
(13,7,'Vacuum Cleaner','Oxone',2017,'Elektronik',20,1350000),
(14,7,'Vacuum Cleaner','Xiaomi',2017,'Elektronik',13,1750000),
(15,8,'Vacuum Cleaner','Xiaomi',2020,'Elektronik',20,776500),
(16,9,'Printer HP Deskjet 3775','HP',2015,'Elektronik',20,135000),
(17,10,'Printer HP Deskjet 1112','HP',2010,'Elektronik',11,100500),
(18,10,'Printer Hp Laserjet M102A','HP',2017,'Elektronik',28,375000),
(19,11,'Printer Canon Pixma G3000','Canon',2018,'Elektronik',20,2350000),
(20,12,'Printer Canon Pixma TS307','Canon',2018,'Elektronik',13,2750000),
(21,13,'Projector Infocus IN118HD','Infocus',2020,'Elektronik',9,175000),
(22,14,'Projector Epson EB-X400 X','Epson',2015,'Elektronik',14,1050000),
(23,15,'Projector Epson EH-TW650','Epson',2019,'Elektronik',23,2075000),
(24,16,'Projector ASUS Zenbeam S2','Asus',2016,'Elektronik',18,2099000),
(25,17,'Projector ASUS P1','Asus',2015,'Elektronik',15,305000),
(26,18,'Tenda Eiger Riding Explor','Eiger',2017,'Outdoor',13,775000),
(27,19,'Tenda  Consina Magnum 5','Consina',2018,'Outdoor',23,675000),
(28,20,'Tenda Coleman Sundome 6P','Coleman',2018,'Outdoor',20,835000),
(29,21,'Tenda Bestway Monodome Pa','Monodome',2018,'Outdoor',13,575000),
(30,21,'Tenda Chanodug FX 8950 pr','Chanodug',2018,'Outdoor',8,755000),
(31,22,'Tas Carrier Eiger Eliptic','Eiger',2018,'Outdoor',12,85000),
(32,22,'Tas Carrier Quechua Forcl','Quechua',2018,'Outdoor',10,75000),
(33,23,'Tas Carrier Consina Alpin','Consina',2019,'Outdoor',9,75600),
(34,23,'Tas Carrier Rei Carrier T','Rei',2019,'Outdoor',8,76000),
(35,24,'Tas Carrier Palazzo 36169','Palazo',2019,'Outdoor',13,74000),
(36,24,'Tas Carrier Avtech Galoa ','Avtech',2020,'Outdoor',14,79000),
(37,24,'Lampu Phillips','Phillips',2020,'Elektronik',20,25000),
(38,25,'Lampu Shinyoku','Shinyoku',2018,'Elektronik',23,25000),
(39,26,'Lampu Osram','Osram',2017,'Elektronik',19,25000),
(40,27,'Lampu Kawachi','Kawachi',2015,'Elektronik',20,25000),
(41,27,'Lampu Nexus','Nexus',2015,'Elektronik',13,25000),
(42,28,'Lampu Stark','Stark',2015,'Elektronik',24,25000),
(43,28,'Go Pro Hero4','Go Pro',2016,'Photography',13,635000),
(44,29,'Go Pro Hero7','Go Pro',2017,'Photography',14,705000),
(45,29,'Go Pro Hero3+','Go Pro',2016,'Photography',15,607500),
(46,30,'Go Pro Her08','Go Pro',2020,'Photography',16,625000),
(47,30,'Cam Recorder Sony HDR-PJ4','Sony',2019,'Photography',10,1075000),
(48,31,'Cam Recorder Sony HXR-MC2','Sony',2016,'Photography',11,1725000),
(49,31,'Cam Recorder Panasonic HC','Panasonic',2017,'Photography',12,999000),
(50,32,'Cam Recorder Panasonic HD','Panasonic',2017,'Photography',13,1200000);

insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('1','001XXX','2','1','2020-08-11','2020-08-12','2020-08-12','890000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('2','002XXX','2','1','2020-09-01','2020-09-03','2020-09-04','2005000','5000');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('3','008XXX','2','1','2020-08-17','2020-08-19','2020-08-19','2000000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('4','010XXX','2','1','2020-08-26','2020-08-28','2020-08-28','2780000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('5','011XXX','2','1','2020-09-15','2020-09-17','2020-09-17','2000000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('6','019XXX','3','2','2020-08-11','2020-08-12','2020-08-12','944000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('7','022XXX','3','2','2020-08-20','2020-08-21','2020-08-21','1700000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('8','023XXX','6','3','2020-08-11','2020-08-12','2020-08-12','988000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('9','029XXX','6','3','2020-08-11','2020-08-12','2020-08-12','750000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('10','031XXX','7','4','2020-08-11','2020-08-12','2020-08-12','135000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('11','032XXX','7','4','2020-10-01','2020-10-03',NULL,'4150000',NULL);
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('12','033XXX','9','5','2020-08-11','2020-08-12','2020-08-12','1500000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('13','041XXX','11','6','2020-08-11','2020-08-13','2020-08-13','3500000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('14','554XXX','13','7','2020-08-11','2020-08-12','2020-08-12','1350000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('15','531XXX','15','8','2020-08-11','2020-08-12','2020-08-12','776500','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('16','530XXX','17','9','2020-10-13','2020-10-15',NULL,'270000',NULL);
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('17','529XXX','17','9','2020-11-01','2020-11-04',NULL,'810000',NULL);
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('18','421XXX','19','10','2020-08-11','2020-08-12','2020-08-12','100500','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('19','230XXX','19','10','2020-08-11','2020-08-12','2020-08-12','375000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('20','442XXX','21','11','2020-08-11','2020-08-12','2020-08-12','2350000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('21','081XXX','23','12','2020-08-11','2020-08-12','2020-08-12','2750000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('22','077XXX','25','13','2020-08-11','2020-08-12','2020-08-12','175000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('23','088XXX','27','14','2020-08-11','2020-08-12','2020-08-12','1050000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('24','089XXX','29','15','2020-08-11','2020-08-12','2020-08-12','2075000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('25','099XXX','31','16','2020-08-11','2020-08-12','2020-08-12','2099000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('26','323XXX','31','16','2020-08-11','2020-08-13','2020-08-13','4198000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('27','200XXX','33','17','2020-08-11','2020-08-12','2020-08-12','305000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('28','099XXX','36','18','2020-08-11','2020-08-12','2020-08-12','775000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('29','092XXX','39','20','2020-08-11','2020-08-12','2020-08-12','835000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('30','431XXX','42','21','2020-08-11','2020-08-12','2020-08-12','575000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('31','098XXX','42','21','2020-08-11','2020-08-12','2020-08-12','755000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('32','041XXX','42','21','2020-08-11','2020-08-12','2020-08-12','575000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('33','101XXX','42','21','2020-09-01','2020-09-02',NULL,'575000',NULL);
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('34','100XXX','42','21','2020-08-11','2020-08-12','2020-08-12','755000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('35','090XXX','44','22','2020-08-11','2020-08-12','2020-08-14','265000','10000');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('36','082XXX','44','22','2020-08-11','2020-08-12','2020-08-12','150000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('37','323XXX','44','22','2020-08-11','2020-08-13','2020-08-14','685000','5000');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('38','081XXX','44','22','2020-08-11','2020-08-12','2020-08-12','85000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('39','221XXX','44','22','2020-08-11','2020-08-12','2020-08-12','75000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('40','429XXX','44','22','2020-08-11','2020-08-12','2020-08-12','85000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('41','089XXX','46','23','2020-08-11','2020-08-13','2020-08-13','151200','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('42','008XXX','46','23','2020-08-11','2020-08-13','2020-08-13','152000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('43','001XXX','46','23','2020-08-11','2020-08-12','2020-08-12','75600','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('44','010XXX','46','23','2020-08-11','2020-08-13','2020-08-13','151200','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('45','092XXX','46','23','2020-08-11','2020-08-12','2020-08-12','75600','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('46','123XXX','47','24','2020-08-11','2020-08-13','2020-08-13','100000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('47','321XXX','47','24','2020-08-11','2020-08-12','2020-08-12','50000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('48','011XXX','47','24','2020-08-11','2020-08-12','2020-08-12','74000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('49','042XXX','47','24','2020-08-11','2020-08-13','2020-08-13','158000','0');
insert into `sewa` (`id_sewa`, `no_ktp`, `id_user`, `id_cabang`, `tanggal_peminjaman`, `peminjaman_sampai`, `tanggal_pengembalian`, `total`, `denda`) values('50','098XXX','47','24','2020-08-11','2020-08-12','2020-08-12','74000','0');

insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('1','2','1','890000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('2','1','1','2000000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('3','1','1','2000000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('4','2','1','1780000','1000000','Rusak');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('5','1','1','2000000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('6','3','1','944000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('7','4','1','1700000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('8','5','1','988000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('9','6','1','750000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('10','7','1','135000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('11','8','1','4150000',NULL,NULL);
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('12','9','1','1500000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('13','11','1','3500000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('14','13','1','1350000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('15','15','1','776500','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('16','16','1','270000',NULL,NULL);
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('17','16','2','810000',NULL,NULL);
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('18','17','1','100500','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('19','18','1','375000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('20','19','1','2350000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('21','20','1','2750000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('22','21','1','175000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('23','22','1','1050000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('24','23','1','2075000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('25','24','1','2099000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('26','24','1','4198000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('27','25','1','305000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('28','26','1','775000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('29','28','1','835000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('30','29','1','575000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('31','30','1','755000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('32','29','1','575000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('33','29','1','575000',NULL,NULL);
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('34','30','1','755000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('35','31','3','255000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('36','32','1','75000','75000','Hilang');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('37','31','4','680000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('38','31','1','85000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('39','32','1','75000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('40','31','1','85000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('41','33','1','151200','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('42','34','1','152000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('43','33','1','75600','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('44','33','1','151200','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('45','33','1','75600','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('46','37','2','100000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('47','37','2','50000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('48','35','1','74000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('49','36','1','158000','0','');
insert into `detail_sewa` (`id_sewa`, `id_barang`, `jumlah`, `total`, `denda`, `keterangan_denda`) values('50','35','1','74000','0','');