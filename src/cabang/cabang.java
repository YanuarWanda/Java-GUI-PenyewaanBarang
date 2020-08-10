package cabang;

import penyewa.biodata;

public class cabang extends biodata {
    private int id;

    public cabang(int id, String nama, String alamat, String kontak) {
        super(nama, alamat, kontak);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
