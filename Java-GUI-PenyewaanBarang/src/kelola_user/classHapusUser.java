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
public class classHapusUser {
    private static final String user = "root";
    private static final String pwd = "";
    private static final String host = "localhost";
    private static final String db = "db10118228penyewaanbarang";
    private static String urlValue = "";
    
    private static int id_user = 0;

    
    public static void set_id(int id){
        id_user = id;
    }
    public static int get_id(){
        return id_user;
    }
  
    public static boolean hapus_user(){
        boolean berhasil = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
            Connection conn = DriverManager.getConnection(urlValue);
            
            PreparedStatement pStatement = null;
            String sql1 = "update user set username='',password='',status='deleted' where id_user = ?";
            
            pStatement = conn.prepareStatement(sql1);
            pStatement.setInt(1, id_user);
            
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
