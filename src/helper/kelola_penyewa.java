package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class kelola_penyewa {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String no_ktp, nama, alamat, kontak;
    
    public void tambah()throws SQLException{
       con = koneksi.getConnection();
       sql="insert into penyewa(no_ktp, nama, alamat, kontak)value(?,?,?,?)";
       pst= con.prepareStatement(sql);
       pst.setString(1, no_ktp);
       pst.setString(2, nama);
       pst.setString(3, alamat);
       pst.setString(4, kontak);
       pst.execute();
       pst.close();
    }
    
    public void edit()throws SQLException{
       con = koneksi.getConnection();
       sql="update penyewa set nama=?, alamat=?, kontak=? where no_ktp=?";
       pst= con.prepareStatement(sql);
       pst.setString(1, nama);
       pst.setString(2, alamat);
       pst.setString(3, kontak);
       pst.setString(4, no_ktp);
       pst.executeUpdate();
       pst.close();
    }
    public void delete()throws SQLException{
       con = koneksi.getConnection();
       sql = "delete from penyewa where no_ktp=?";
       try{
        pst= con.prepareStatement(sql);
        pst.setString(1, no_ktp);
        pst.execute();
       }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
       }
    }
}
