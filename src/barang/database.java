/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class database {
    private String driver = "com.mysql.jdbc.Driver";
    private String url ="jdbc:mysql://localost/db10118228PenyewaanBarang";
    private String user ="root";
    private String pass="powerlogicA23";

    public ArrayList <barang> tampilSemuaBarang(){
    ArrayList<barang> list = new ArrayList<barang>();
    Connection conn=null;
    Statement stmt = null;
    try{
        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,pass);
        stmt = conn.createStatement();
        String sql;
        sql="select * from barang";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            list.add(new barang(rs.getInt("id_barang"), rs.getInt("id_cabang"),
                    rs.getString("nama"), rs.getString("merk"), rs.getInt("tahun"), rs.getString("jenis"),
                rs.getInt("stok"),rs.getFloat("harga_sewa")));
        }
        rs.close();
        }
    catch (Exception e){
        System.out.println("Error : "+e.getMessage());
    }
    finally{
        try
        {
            stmt.close();
        }
        catch(Exception e){}
            try{
                conn.close();
            }
            catch(Exception e){}
    }
    return list;
    }
    
    
    public void tambahBarang(barang b){
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql = "insert into barang values ('"+b.getId()+"','"
                    +b.getIdCabang()+"','"+b.getNama()+"','"+b.getMerk()+"','"
                    +b.getTahun()+"','"+b.getJenis()+"','"+b.getStok()+"','"
                    +b.getHargaSewa()+"')";
            stmt.executeQuery(sql);
        }
        catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch(Exception e){}
        }
    }
}
