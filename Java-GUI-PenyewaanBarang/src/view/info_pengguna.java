/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author ilham
 */
public class info_pengguna {
    private static int id_pengguna = 0;
    private static int id_cabang = 0;
    private static String status = "";
    
    public static void set_pengguna(int id){
        id_pengguna = id;
    }
    public static void set_cabang(int id){
        id_cabang = id;
    }
    
    public static void set_status(String str){
        status = str;
    }
    
    public static int get_pengguna(){
        return id_pengguna;
    }
    public static int get_cabang(){
        return id_cabang;
    }
    public static String get_status(){
        return status;
    }
    
}
