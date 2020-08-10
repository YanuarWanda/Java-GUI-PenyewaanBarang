/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

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
public class class_login {
    private String user = "root";
    private String pwd = "";
    private String host = "localhost";
    private String db = "db10118228penyewaanbarang";
    private String urlValue = "";
    private String status = "";
    private int id_user = 0;
    private int id_cabang = 0;
    
    public String get_status(){
        return status;
    }
    public int get_id_user(){
        return id_user;
    }
    public int get_id_cabang(){
        return id_cabang;
    }
    
    public boolean validasi_login(String username, String password){
        boolean berhasil = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            String sql1 = "select * from user where username = ? and status != 'deleted'";
            
            pStatement = conn.prepareStatement(sql1);
            pStatement.setString(1, username);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                    id_user = rs.getInt("id_user");
                    id_cabang = rs.getInt("id_cabang");
                    status = rs.getString("status");
                    berhasil = true;
                }
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
