package penyewa;

public class penyewa extends biodata {
    private String noKTP;

    public penyewa(String noKTP, String nama, String alamat, String kontak) {
        super(nama, alamat, kontak);
        this.noKTP = noKTP;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    @Override
    public String toString() {
        return this.nama;
    }
}
