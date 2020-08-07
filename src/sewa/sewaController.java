package sewa;

import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class sewaController {
    public ArrayList<sewa> tampilSemuaSewa() {
        ArrayList<sewa> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM sewa";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                list.add(new sewa(
                    rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), 
                    rs.getDate(5), rs.getDate(6), rs.getDate(7))
                );
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
