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
    FOREIGN KEY (id_sewa) REFERENCES sewa(id_sewa),
    FOREIGN KEY (id_barang) REFERENCES barang(id_barang)
);