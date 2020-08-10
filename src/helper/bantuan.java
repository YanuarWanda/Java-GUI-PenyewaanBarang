package helper;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class bantuan {
    public static void tampil(JDesktopPane panelUtama, JInternalFrame frame, Dimension layarUtama) {
        panelUtama.repaint();
        
        // sizescreen
        Dimension layarMahasiswa = frame.getSize();
        
        // simpan posisi frame di tengah layar utama
        frame.setLocation(
            layarUtama.width / 2 - layarMahasiswa.width / 2,
            layarUtama.height / 2 - layarMahasiswa.height / 2
        );
        
        panelUtama.add(frame);
        frame.setVisible(true);
    }
    
    public static long bandingkanHari(Date dari, Date sampai) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dari;
        Date date2 = sampai;
        
        try {
            date1 = sdf.parse(new SimpleDateFormat("yyyy-MM-dd").format(dari));
            date2 = sdf.parse(new SimpleDateFormat("yyyy-MM-dd").format(sampai));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
        long d = date1.getTime() / (24 * 60 * 60 * 1000);
        long s = date2.getTime() / (24 * 60 * 60 * 1000);
        return s - d;
    }
    
    public static Date besok(Date sekarang) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(sdf.parse(new SimpleDateFormat("yyyy-MM-dd").format(sekarang)));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
    
    public static String formatRupiah(float angka) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
 
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
 
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(angka);
    }
}
