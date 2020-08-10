package user;

import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class userController {
    public user getUser(int id) {
        user u = null;
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE id_user = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                u = new user(
                    rs.getInt("id_user"), rs.getString("username"), rs.getDate("tanggal_lahir"), 
                    rs.getString("status"), rs.getString("nama"), rs.getString("alamat"), 
                    rs.getString("kontak")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return u;
        }
    }
}
