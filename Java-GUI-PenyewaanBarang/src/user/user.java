package user;

import java.sql.Date;
import penyewa.biodata;

public class user extends biodata {
    private int id;
    private String username;
    private Date tanggalLahir;
    private String status;

    public user(int id, String username, Date tanggalLahir, String status, String nama, String alamat, String kontak) {
        super(nama, alamat, kontak);
        this.id = id;
        this.username = username;
        this.tanggalLahir = tanggalLahir;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
