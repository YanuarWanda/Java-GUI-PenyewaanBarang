package sewa;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class sewaTabelModel extends AbstractTableModel {
    private ArrayList<sewa> data;
    private final String[] namaField ={"ID", "No", "Penyewa", "Tanggal Peminjaman", "Peminjaman Sampai", "Tanggal Pengembalian"};
    
    public void setData(ArrayList<sewa> data) {
        this.data = data;
    }
    @Override
    public int getColumnCount() {
        return namaField.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        sewa s = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getId();
            case 1: return rowIndex + 1;
            case 2: return s.getPenyewa().getNama();
            case 3: return s.getTanggalPeminjaman();
            case 4: return s.getPeminjamanSampai();
            case 5: return s.getTanggalPengembalian();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return namaField[column];
    }
}
