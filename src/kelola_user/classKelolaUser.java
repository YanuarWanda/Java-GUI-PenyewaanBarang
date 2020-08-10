/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelola_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ilham
 */
public class classKelolaUser {
    private static boolean tampil = false;
    private static String cari = "";
    
    public static void set_tampil(boolean val){
        tampil = val;
    }
    public static boolean get_tampil(){
        return tampil;
    }
    
    public static void set_cari(String val){
        cari = "%"+val+"%";
    }
    public static String get_cari(){
        return cari;
    }
}
