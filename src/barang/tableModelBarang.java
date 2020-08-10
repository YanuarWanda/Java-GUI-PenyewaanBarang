/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barang;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class tableModelBarang extends AbstractTableModel{
    private ArrayList<barang> data;
    private String[] namaField={"Id Barang","Id Cabang","Nama Barang","Merk Barang","Tahun Produksi","Jenis Barang","Stok","Harga Sewa"};

    public void setData(ArrayList<barang> dt){
        this.data=dt;
    }
    
    public int getColumnCount(){
        return namaField.length;
    }
    
    public int getRowCount(){
        return data.size();
    }
    
    public String getColumnName(int column){
        return namaField[column];
    }
    
    public Object getValueAt(int baris,int kolom){
        barang b = data.get(baris);
        switch(kolom){
            case 0 : return b.getId(); 
            case 1 : return b.getIdCabang();
            case 2 : return b.getNama();
            case 3 : return b.getMerk();
            case 4 : return b.getTahun();
            case 5 : return b.getJenis();
            case 6 : return b.getJenis();
            case 7 : return b.getHargaSewa();
            default : return null;
        }
    }
}
