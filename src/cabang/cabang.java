
package cabang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN 10
 */
public class cabang {
    private boolean koneksiAwal = false;
    private String nama;
    private String alamat;
    private String kontak;
    private int id;
    
    public cabang(int id, String nama, String alamat, String kontak) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.kontak = kontak;
    }
    
    public cabang(String nama, String alamat, String kontak) {
        this.nama = nama;
        this.alamat = alamat;
        this.kontak = kontak;
    }
    
    public cabang(int id) {
        this.id = id;
    }
   
    
    //public static void set_tampil(boolean val){
    //    tampil = val;
    //}
    //public static boolean get_tampil(){
    //    return tampil;
    //}
    
    //public static void set_tampilPilihan(boolean val){
    //    tampilPilihan = val;
    //}
    
    //public static boolean get_tampilPilihan(){
    //    return tampilPilihan;
    //}
    
    public int get_id() {
        return id;
    }
    
    public String get_nama() {
        return nama;
    }
    
    public String get_alamat() {
        return alamat;
    }
    
    public String get_kontak() {
        return kontak;
    }
}
