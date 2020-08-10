package penyewa;

import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class penyewaController {
    public penyewa getPenyewa(String noKTP) {
        penyewa p = null;
        Connection conn = koneksi.getConnection();
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM penyewa where no_ktp = '" + noKTP + "';";
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
    public ArrayList<penyewa> tampilSemuaPenyewa() {
        ArrayList<penyewa> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM penyewa";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                list.add(new penyewa(
                    rs.getString(1), rs.getString(2), rs.getString(3), 
                    rs.getString(4)
                ));
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return list;
        }
    }
}
