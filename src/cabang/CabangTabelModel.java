
package cabang;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CabangTabelModel extends AbstractTableModel {
    private ArrayList<cabang> data;
    private final String[] namaField ={"ID", "Nama", "Alamat", "Kontak"};
    
    public void setData(ArrayList<cabang> data) {
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
        cabang cbg = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return cbg.get_id();
            case 1: return cbg.get_nama();
            case 2: return cbg.get_alamat();
            case 3: return cbg.get_kontak();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return namaField[column];
    }
}