package sewa;

import penyewa.penyewaController;
import penyewa.penyewa;
import java.sql.Date;

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

    public sewa(int id, String noKTPPenyewa, int idPegawai, int idCabang, Date tanggalPeminjaman, Date peminjamanSampai, Date tanggalPengembalian, float total) {
        this.id = id;
        this.noKTPPenyewa = noKTPPenyewa;
        this.idPegawai = idPegawai;
        this.idCabang = idCabang;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.peminjamanSampai = peminjamanSampai;
        this.tanggalPengembalian = tanggalPengembalian;
        this.total = total;
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
}
