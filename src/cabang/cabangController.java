package cabang;

import helper.koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
                c = new cabang(rs.getInt("id_cabang"), rs.getString("nama"), 
                        rs.getString("alamat"), rs.getString("kontak"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return c;
        }
    }
    
    public ArrayList<cabang> tampilcabang() {
        ArrayList<cabang> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM cabang";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                list.add(new cabang(
                    rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4))
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
    
    public void tambah(String nama, String alamat, String kontak) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/db10118228penyewaanbarang", "root", 
                    "");
            Statement st = conn.createStatement();
            PreparedStatement pStatement = null;

            String sql = "INSERT INTO `cabang`(`nama`,`alamat`,`kontak`)" + "VALUES(?,?,?);";

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, nama);
            pStatement.setString(2, alamat);
            pStatement.setString(3, kontak);
            int intBaris = pStatement.executeUpdate();
            if (intBaris > 0) {
                JOptionPane.showMessageDialog(null, "Penambahan data berhasil");

            } else {
                JOptionPane.showMessageDialog(null, "Penambahan data gagal");
            }
            pStatement.close();

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal, " + e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JDBC Driver tidak ditemukan");
        }
    }
    
    public void hapus(int id) {
        Connection conn = koneksi.getConnection();
        
        try {
            Statement st = conn.createStatement();
            String sql = "DELETE FROM cabang WHERE id_cabang = "+id;
            st.executeUpdate(sql);
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
        }
    }
    
    public ArrayList<cabang> cari(String nama) {
        ArrayList<cabang> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM cabang WHERE nama LIKE '%"+nama+"%';";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                list.add(new cabang(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4))
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return list;
        }
    }
    
    
    public void update(int id, String nama, String alamat, String kontak) {
        Connection conn = koneksi.getConnection();
        
        try {
            Statement st = conn.createStatement();
            PreparedStatement pStatement = null;
            String sql = "UPDATE `cabang` SET `nama` = ?, `alamat` = ?, `kontak` = ? WHERE `id_cabang` = ?";
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, nama);
            pStatement.setString(2, alamat);
            pStatement.setString(3, kontak);
            pStatement.setInt(4, id);
            if (pStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil menyimpan perubahan");
            }
            else{
                JOptionPane.showMessageDialog(null, "Gagal menyimpan perubahan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
        }
    }
}
