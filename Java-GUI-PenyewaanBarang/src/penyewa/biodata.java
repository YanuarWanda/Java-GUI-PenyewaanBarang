package penyewa;

public class biodata {
    protected String nama;
    protected String alamat;
    protected String kontak;

    public biodata(String nama, String alamat, String kontak) {
        this.nama = nama;
        this.alamat = alamat;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
}
