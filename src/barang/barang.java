package barang;

public class barang {
    private int id;
    private int idCabang;
    private String nama;
    private String merk;
    private int tahun;
    private String jenis;
    private int stok;
    private float hargaSewa;

    public barang(int id, int idCabang, String nama, String merk, int tahun, String jenis, int stok, float hargaSewa) {
        this.id = id;
        this.idCabang = idCabang;
        this.nama = nama;
        this.merk = merk;
        this.tahun = tahun;
        this.jenis = jenis;
        this.stok = stok;
        this.hargaSewa = hargaSewa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public float getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(float hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    @Override
    public String toString() {
        return this.nama; 
    }
}
