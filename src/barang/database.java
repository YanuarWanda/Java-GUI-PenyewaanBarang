/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class database {
    private String driver = "com.mysql.jdbc.Driver";
    private String url ="jdbc:mysql://localhost/db10118228penyewaanbarang";
    private String user ="root";
    private String pass="";

    public ArrayList <barang> tampilSemuaBarang(){
    ArrayList<barang> list = new ArrayList<barang>();
    Connection conn=null;
    Statement stmt = null;
    try{
        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,pass);
        stmt = conn.createStatement();
        String sql="select * from barang;"; 
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
            stmt.executeUpdate(sql);
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
    
    public void hapusBarang(int id){
        Connection conn=null;
        Statement stmt=null;
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="delete from barang where id_barang='"+id+"';";
            stmt.executeUpdate(sql);
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
    
    public void updateBarang(barang b)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql ="Update barang set id_cabang = '"+b.getIdCabang()+"',"
            +"nama = '"+b.getNama()+"',"
            +"merk = '"+b.getMerk()+"',"
            +"tahun = '"+b.getTahun()+"',"
            +"jenis = '"+b.getJenis()+"',"
            +"stok = '"+b.getStok()+"',"
            +"harga_sewa = '"+b.getHargaSewa()+"' where id_barang = '"+b.getId()+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
        finally{
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
    
    public barang pillihBarang(int id)
    {
        barang b = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="select * from barang where id_barang='"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                b = new barang(rs.getInt("id_barang"), rs.getInt("id_cabang"),
                    rs.getString("nama"), rs.getString("merk"), rs.getInt("tahun"), rs.getString("jenis"),
                rs.getInt("stok"),rs.getFloat("harga_sewa"));
            }
            else
                b=null;
            rs.close();
        }
        catch(Exception e){
            System.out.print("Error : "+e.getMessage());
        }
        finally{
           try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch(Exception e){} 
        }
        return b;
    }
    
    public ArrayList<barang> cariBarang(String katakunci){
        ArrayList<barang> listbarang = new ArrayList<barang>();
        Connection conn=null;
        Statement stmt=null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="Select * from barang where nama like '%"+katakunci+"%'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                listbarang.add(new barang(rs.getInt("id_barang"), rs.getInt("id_cabang"),
                    rs.getString("nama"), rs.getString("merk"), rs.getInt("tahun"), rs.getString("jenis"),
                rs.getInt("stok"),rs.getFloat("harga_sewa")));
            }
            rs.close();
        }
        catch(Exception e){
            System.out.print("Error : "+e.getMessage());
        }
        finally{
           try
            {
                stmt.close();
            }catch(Exception e){}
            try
            {
                conn.close();
            }catch(Exception e){} 
        }
        return listbarang;
    }
}
