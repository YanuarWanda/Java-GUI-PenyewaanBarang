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
            String sql = "SELECT * FROM sewa ORDER BY id_sewa DESC";
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
    public ArrayList<sewa> tampilSemuaSewa(int idCabang) {
        ArrayList<sewa> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM sewa WHERE id_cabang = " + idCabang + " ORDER BY id_sewa DESC;";
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
    public sewa pilihSewa(int idSewa) {
        sewa s = null;
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM sewa JOIN penyewa USING(no_ktp) WHERE id_sewa = " + idSewa + ";";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                s = new sewa(rs.getInt(2), rs.getString(1), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getFloat(8), rs.getFloat(9));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return s;
        }
    }
    public void updateSewa(sewa sewa, ArrayList<detailSewa> barangSewaan, long lamaSewa) {
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE sewa SET no_ktp = '" + sewa.getNoKTPPenyewa() + "', tanggal_peminjaman = '" + sewa.getTanggalPeminjaman() + "', peminjaman_sampai = '" + sewa.getPeminjamanSampai() + "', total = " + sewa.getTotal() + ";";
            stmt.executeUpdate(sql);
            
            // Hapus detail sewa
            for (detailSewa ds: getDetailSewa(sewa.getId())) {
                sql = "DELETE FROM detail_sewa WHERE id_sewa = " + ds.getIdSewa() + " AND id_barang = " + ds.getIdBarang() + ";";
                stmt.executeUpdate(sql);
                bc.updateStok(ds.getIdBarang(), ds.getBarang().getStok() + ds.getJumlah());
            }
            
            for (detailSewa ds: barangSewaan) {
                sql = "INSERT INTO detail_sewa (id_sewa, id_barang, jumlah, "
                    + "total) VALUES (" + sewa.getId() + ", " + 
                    ds.getIdBarang()+ ", " + ds.getJumlah() + ", " + 
                    ds.hitungTotal(lamaSewa) + ");";
                stmt.executeUpdate(sql);
                bc.updateStok(ds.getIdBarang(), ds.getBarang().getStok() - ds.getJumlah());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
        }
    }
    public ArrayList<detailSewa> getDetailSewa(int idSewa) {
        ArrayList<detailSewa> list = new ArrayList<>();
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM detail_sewa WHERE id_sewa = " + idSewa + ";";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                list.add(new detailSewa(
                    rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5), rs.getString(6)
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return list;
        }
    }
    public detailSewa pilihSatuDetailSewa(int idBarang, int idSewa) {
        detailSewa ds = null;
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM detail_sewa WHERE id_barang = " + idBarang + " AND id_sewa = " + idSewa + ";";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                ds = new detailSewa(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5), rs.getString(6));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
            return ds;
        }
    }
    public void pengembalian(sewa s, ArrayList<detailSewa> dsList) {
        Connection conn = koneksi.getConnection();
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE sewa SET "
                    + "tanggal_pengembalian = '" + s.getTanggalPengembalian() + "',"
                    + "denda = " + s.getDenda() + ", total = " + s.getTotal() 
                    + " WHERE id_sewa = " + s.getId() + ";";
            stmt.executeUpdate(sql);
            
            for (detailSewa ds: dsList) {
                sql = "UPDATE detail_sewa SET denda = " + ds.getDenda() + ", "
                        + "keterangan_denda = '" + ds.getKeteranganDenda() + "'"
                        + " WHERE id_sewa = " + s.getId() + " AND id_barang = "
                        + ds.getIdBarang() + ";";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            koneksi.closeConnection(conn);
        }
    }
}
