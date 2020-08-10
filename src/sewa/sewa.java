package sewa;

import barang.barang;
import penyewa.penyewa;
import user.user;
import cabang.cabang;
import barang.barangController;
import penyewa.penyewaController;
import user.userController;
import cabang.cabangController;
import java.util.Date;
import java.util.ArrayList;

public class sewa {
    private int id;
    private String noKTPPenyewa;
    private int idPegawai;
    private int idCabang;
    private Date tanggalPeminjaman;
    private Date peminjamanSampai;
    private Date tanggalPengembalian;
    private float total;
    private float denda;

    public sewa(int id, String noKTPPenyewa, int idPegawai, int idCabang, Date tanggalPeminjaman, Date peminjamanSampai, Date tanggalPengembalian, float total, float denda) {
        this.id = id;
        this.noKTPPenyewa = noKTPPenyewa;
        this.idPegawai = idPegawai;
        this.idCabang = idCabang;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.peminjamanSampai = peminjamanSampai;
        this.tanggalPengembalian = tanggalPengembalian;
        this.total = total;
        this.denda = denda;
    }

    public int getId() {
        return id;
    }

    public String getNoKTPPenyewa() {
        return noKTPPenyewa;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public int getIdCabang() {
        return idCabang;
    }

    public Date getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public Date getPeminjamanSampai() {
        return peminjamanSampai;
    }

    public Date getTanggalPengembalian() {
        return tanggalPengembalian;
    }
    
    // TODO: Hitung total dari harga_sewa detail sewa
    public float getTotal() {
        return total;
    }

    // TODO: Hitung denda dari denda detail_sewa
    public float getDenda() {
        return denda;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoKTPPenyewa(String noKTPPenyewa) {
        this.noKTPPenyewa = noKTPPenyewa;
    }

    public void setPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }

    public void setCabang(int idCabang) {
        this.idCabang = idCabang;
    }

    public void setTanggalPeminjaman(Date tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public void setPeminjamanSampai(Date peminjamanSampai) {
        this.peminjamanSampai = peminjamanSampai;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDenda(float denda) {
        this.denda = denda;
    }
    
    public penyewa getPenyewa() {
        penyewaController pc = new penyewaController();
        return pc.getPenyewa(this.noKTPPenyewa);
    }
    
    public ArrayList<barang> getSemuaBarang() {
        barangController bc = new barangController();
        return bc.getBarangBySewa(this.id);
    }
    
    public ArrayList<detailSewa> getSemuaDetailSewa() {
        sewaController sc = new sewaController();
        return sc.getDetailSewa(this.id);
    }
    
    public user getPegawai() {
        userController uc = new userController();
        return uc.getUser(this.idPegawai);
    }
    
    public cabang getCabang() {
        cabangController cc = new cabangController();
        return cc.getCabang(this.idCabang);
    }
}
