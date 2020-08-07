package penyewa;

import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class penyewaController {
    public penyewa getPenyewa(String noKTP) {
        penyewa p = null;
        Connection conn = koneksi.getConnection();
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM penyewa;";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                p = new penyewa(
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4)
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return p;
        }
    }
}
