package cabang;

import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class cabangController {
    public cabang getCabang(int idCabang) {
        cabang c = null;
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM cabang WHERE id_cabang = " + idCabang;
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                c = new cabang(rs.getInt("id_cabang"), rs.getString("nama"), rs.getString("alamat"), rs.getString("kontak"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return c;
        }
    }
}
