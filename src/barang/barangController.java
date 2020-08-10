package barang;

import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class barangController {
    public barang getBarang(int idBarang) {
        barang b = null;
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM barang WHERE id_barang = " + idBarang + ";";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                b = new barang(rs.getInt(1), rs.getInt(2), rs.getString(3), 
                rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), 
                rs.getFloat(8));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return b;
        }
    }
    public ArrayList<barang> tampilSemuaBarang() {
        ArrayList<barang> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM barang";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                list.add(new barang(
                    rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                    rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getFloat(8)
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
    public ArrayList<barang> tampilSemuaBarang(boolean adaStok) {
        ArrayList<barang> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM barang WHERE stok > 0";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                list.add(new barang(
                    rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                    rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getFloat(8)
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
    public void updateStok(int idBarang, int stok) {
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE barang SET stok = " + stok + " WHERE id_barang = " + idBarang + ";";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
        }
    }
}
