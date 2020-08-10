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
public class classEditUser {
    private static final String user = "root";
    private static final String pwd = "";
    private static final String host = "localhost";
    private static final String db = "db10118228penyewaanbarang";
    private static String urlValue = "";
    
    private static int id_user = 0;
    private static int id_cabang = 0;
    private static String username = "";
    private static String password = "";
    private static String nama = "";
    private static String alamat = "";
    private static String date = "";
    private static String kontak = "";
    private static String cabang = "";
    private static String status = "";
    
    public static void set_username(String str){
        username = str;
    }
    public static void set_password(String str){
        password = str;
    }
    public static void set_nama(String str){
        nama = str;
    }
    public static void set_alamat(String str){
        alamat= str;
    }
    public static void set_date(String str){
        date= str;
    }
    public static void set_kontak(String str){
        kontak= str;
    }
    public static void set_cabang(String str){
        cabang= str;
    }
    public static void set_status(String str){
        status= str;
    }
    
    public static void set_id(int id){
        id_user = id;
    }
    
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
    public static int get_id(){
        return id_user;
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
    
    public static boolean cek_username(){
        boolean berhasil = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            String sql1 = "select * from user where username = ?";
            
            pStatement = conn.prepareStatement(sql1);
            pStatement.setString(1, username);
            ResultSet rs = pStatement.executeQuery();
            
            while (rs.next()) {
                berhasil = false;
            }            

            pStatement.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal, " + e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JDBC Driver tidak ditemukan");
        }
        return berhasil;
    }
    
    public static boolean set_idcabang(){
        boolean berhasil = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            String sql1 = "select * from cabang where nama = ?";
            
            pStatement = conn.prepareStatement(sql1);
            pStatement.setString(1, cabang);
            ResultSet rs = pStatement.executeQuery();
            
            while (rs.next()) {
                id_cabang = rs.getInt("id_cabang");
                berhasil = true;
            }            

            pStatement.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal, " + e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JDBC Driver tidak ditemukan");
        }
        return berhasil;
    }
    
    public static boolean update_user(){
        boolean berhasil = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            String sql1 = "update user set id_cabang=?,nama=?,username=?,password=?,status=?,alamat=?,kontak=?,tanggal_lahir=? where id_user = ?";
            
            pStatement = conn.prepareStatement(sql1);
            JOptionPane.showMessageDialog(null, id_cabang);
            pStatement.setInt(1, id_cabang);
            pStatement.setString(2, nama);
            pStatement.setString(3, username);
            pStatement.setString(4, password);
            pStatement.setString(5, status  );
            pStatement.setString(6, alamat);
            pStatement.setString(7,kontak);
            pStatement.setString(8,date);
            pStatement.setInt(9, id_user);
            
            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                berhasil = true;
            }       

            pStatement.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal, " + e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JDBC Driver tidak ditemukan");
        }
        return berhasil;
    }
}
