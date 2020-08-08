package sewa;

import barang.barang;
import barang.barangController;

public class detailSewa {
    private int idSewa;
    private int idBarang;
    private int jumlah;
    private float total;
    private float denda;
    private String keteranganDenda;

    public detailSewa(int idSewa, int idBarang, int jumlah, float total, float denda, String keteranganDenda) {
        this.idSewa = idSewa;
        this.idBarang = idBarang;
        this.jumlah = jumlah;
        this.total = total;
        this.denda = denda;
        this.keteranganDenda = keteranganDenda;
    }

    public int getIdSewa() {
        return idSewa;
    }

    public void setIdSewa(int idSewa) {
        this.idSewa = idSewa;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getDenda() {
        return denda;
    }

    public void setDenda(float denda) {
        this.denda = denda;
    }

    public String getKeteranganDenda() {
        return keteranganDenda;
    }

    public void setKeteranganDenda(String keteranganDenda) {
        this.keteranganDenda = keteranganDenda;
    }
    
    public barang getBarang() {
        barangController bc = new barangController();
        return bc.getBarang(this.idBarang);
    }
    
    public float hitungTotal(long lamaSewa) {
        return lamaSewa * this.jumlah * this.getBarang().getHargaSewa();
    }
}
