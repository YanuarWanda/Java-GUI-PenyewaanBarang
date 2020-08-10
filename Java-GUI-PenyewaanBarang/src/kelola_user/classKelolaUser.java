/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelola_user;

/**
 *
 * @author ilham
 */
public class classKelolaUser {

    
    private static boolean tampil = false;
    private static boolean tampilPilihan= false;
    private static String cari = "";
    private static int id_tabel = 0;
    
    public static void set_tampil(boolean val){
        tampil = val;
    }
    public static boolean get_tampil(){
        return tampil;
    }
    
    public static void set_tampilPilihan(boolean val){
        tampilPilihan = val;
    }
    
    public static boolean get_tampilPilihan(){
        return tampilPilihan;
    }
    
    public static void set_cari(String val){
        cari = "%"+val+"%";
    }
    
    public static String get_cari(){
        return cari;
    }
    
    public static void set_idTabel(int id){
        id_tabel = id;
    }
    
    public static int get_idTabel(){
        return id_tabel;
    }
}
