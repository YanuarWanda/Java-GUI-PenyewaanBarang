/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelola_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ilham
 */
public class classBacaUser {
    private static final String user = "root";
    private static final String pwd = "";
    private static final String host = "localhost";
    private static final String db = "db10118228penyewaanbarang";
    private static String urlValue = "";
    
    private static String username = "";
    private static String password = "";
    private static String nama = "";
    private static String alamat = "";
    private static String date = "";
    private static String kontak = "";
    private static String cabang = "";
    private static String status = "";
    
    public static String get_username(){
        return username;
    }
    public static String get_password(){
        return password;
    }
    public static String get_nama(){
        return nama;
    }
    public static String get_alamat(){
        return alamat;
    }
    public static String get_date(){
        return date;
    }
    public static String get_kontak(){
        return kontak;
    }
    public static String get_cabang(){
        return cabang;
    }
    public static String get_status(){
        return status;
    }
    
    public static int get_tgl(){
        int val = 0;
        String tgl = "";
        if(date.charAt(8) != '0'){
            tgl += date.charAt(8);
        }
        tgl += date.charAt(9);
        val = Integer.valueOf(tgl);
        return val;
    }
    public static int get_bln(){
        int val = 0;
        String tgl = "";
        if(date.charAt(5) != '0'){
            tgl += date.charAt(5);
        }
        tgl += date.charAt(6);
        val = Integer.valueOf(tgl);
        return val;
    }
    public static int get_thn(){
        int val = 0;
        String tgl = "";
        tgl += date.charAt(0);
        tgl += date.charAt(1);
        tgl += date.charAt(2);
        tgl += date.charAt(3);
        val = Integer.valueOf(tgl);
        return val;
    }
    
    
    
    
    public static void baca_data(int id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            String sql1 = "select * from user inner join cabang on user.id_cabang = cabang.id_cabang where id_user = ?";
            
            pStatement = conn.prepareStatement(sql1);
            pStatement.setInt(1, id);
            ResultSet rs = pStatement.executeQuery();
            
            username = "";
            password = "";
            nama = "";
            alamat = "";
            kontak = "";
            status = "";
            date = "";
            cabang = "";
            
            while (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("password");
                nama = rs.getString("user.nama");
                alamat = rs.getString("user.alamat");
                kontak = rs.getString("user.kontak");
                status = rs.getString("status");
                date = rs.getString("tanggal_lahir");
                cabang = rs.getString("cabang.nama");
            }            

            pStatement.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal, " + e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JDBC Driver tidak ditemukan");
        }
    }
    
    public static String atur_alamat(){
        int length = alamat.length();
        String alamat_baru = "";
        if(length > 40){
            String alamat1 = "";
            String alamat2 = "";
            for(int i = 0; i < length;i++){
                if(i<40){
                    alamat1 += alamat.charAt(i);
                }else{
                    alamat2 += alamat.charAt(i);
                }
            }
            alamat_baru = "<html>"+alamat1+"<br>"+alamat2+"</html>";
        }else{
            alamat_baru = alamat;
        }
        return alamat_baru;
    }
}
