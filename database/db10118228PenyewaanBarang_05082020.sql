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

INSERT INTO cabang VALUES
(1, "Cabang 1", "Jl. Cabang 1.", "087825418390");

INSERT INTO penyewa VALUES
("1234567890123456", "Penyewa 1", "Jl. Penyewa 1.", "087722394860");

INSERT INTO user VALUES
(1, 1, "User 1", "user1", "user123", "Admin", "Jl. User 1.", "08217050905", "2001-01-18");

INSERT INTO barang VALUES
(1, 1, "Barang 1", "Merk 1", 1984, "Jenis 1", 20, 35000),
(2, 1, "Barang 2", "Merk 2", 1999, "Jenis 2", 3, 75000),
(3, 1, "Barang 3", "Merk 3", 2012, "Jenis 3", 80, 7500);

INSERT INTO sewa VALUES
(1, "1234567890123456", 1, 1, "2020-08-07", "2020-08-09", NULL, 290000, NULL);

INSERT INTO detail_sewa VALUES
(1, 1, 2, 140000, NULL, NULL),
(1, 2, 1, 150000, NULL, NULL);