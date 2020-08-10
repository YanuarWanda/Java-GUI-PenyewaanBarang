package sewa;

import barang.barangController;
import helper.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class sewaController {
    barangController bc = new barangController();
    
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
                    rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getFloat(8), 
                    rs.getFloat(9))
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
    public void tambahSewa(sewa sewa, ArrayList<detailSewa> barangSewaan, long lamaSewa) {
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO sewa "
                    + "(no_ktp, id_user, id_cabang, tanggal_peminjaman, "
                    + "peminjaman_sampai, total) VALUES("
                    + "'" + sewa.getNoKTPPenyewa() + "', " + sewa.getIdPegawai()
                    + ", " + sewa.getIdCabang() + ", '" + sewa.getTanggalPeminjaman()
                    + "', '" + sewa.getPeminjamanSampai() + "', '" + sewa.getTotal()
                    + "');";
            if (stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                int idSewa = 0;
                ResultSet key = stmt.getGeneratedKeys();
                if (key.next()) {
                    idSewa = key.getInt(1);
                }
                for (detailSewa ds: barangSewaan) {
                    sql = "INSERT INTO detail_sewa (id_sewa, id_barang, jumlah, "
                            + "total) VALUES (" + idSewa + ", " + 
                            ds.getIdBarang()+ ", " + ds.getJumlah() + ", " + 
                            ds.hitungTotal(lamaSewa) + ");";
                    stmt.executeUpdate(sql);
                    bc.updateStok(ds.getIdBarang(), ds.getBarang().getStok() - ds.getJumlah());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah sewa, karena: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
        }
    }
    public void hapusSewa(int idSewa) {
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM sewa WHERE id_sewa = " + idSewa + ";";
            stmt.executeUpdate(sql);
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
        }
    }
    public ArrayList<sewa> cariSewa(String namaPenyewa) {
        ArrayList<sewa> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM sewa JOIN penyewa USING(no_ktp) WHERE nama LIKE '%" + namaPenyewa + "%';";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                list.add(new sewa(
                        rs.getInt(2), rs.getString(1), rs.getInt(3), rs.getInt(4),
                        rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getFloat(8),
                        rs.getFloat(9)
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return list;
        }
    }
}
