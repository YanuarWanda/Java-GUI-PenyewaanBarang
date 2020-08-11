package sewa;

import helper.bantuan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class formPengembalianSewa extends javax.swing.JDialog {
    sewa s = null;
    indexSewa indexFrame = null;
    int DENDA_PER_BARANG = 5000;
    
    sewaController sc = new sewaController();
    
    public formPengembalianSewa(java.awt.Frame parent, boolean modal, sewa s, 
            indexSewa index) {
        super(parent, modal);
        initComponents();
        this.s = s;
        this.indexFrame = index;
        
        dpPengembalian.setMinSelectableDate(s.getTanggalPeminjaman());
        
        if (s.getTanggalPengembalian() != null) {
            dpPengembalian.setDate(s.getTanggalPengembalian());
            txtDendaTelat.setText(String.valueOf(s.getDenda()));
        }
        
        fillBarang(1, panelBarang1, txtBarang1, ketDenda1, denda1, idBarang1);
        fillBarang(2, panelBarang2, txtBarang2, ketDenda2, denda2, idBarang2);
        fillBarang(3, panelBarang3, txtBarang3, ketDenda3, denda3, idBarang3);
    }
    
    private void fillBarang(int n, JPanel panel, JLabel txtBarang, 
            JTextField ketDenda, JTextField denda, JLabel idBarang) {
        ArrayList<detailSewa> dsList = s.getSemuaDetailSewa();
        
        if (dsList.size() < n) {
            panel.setVisible(false);
            return;
        };
        
        detailSewa ds = dsList.get(n - 1);
        txtBarang.setText(ds.getBarang().getNama() + " (" + ds.getJumlah() + ")");
        idBarang.setText(String.valueOf(ds.getIdBarang()));
        
        if (ds.getKeteranganDenda() != null) {
            ketDenda.setText(ds.getKeteranganDenda());
            denda.setText(String.valueOf(ds.getDenda()));
        }
    }

    private void checkDetailSewa(detailSewa ds, JLabel idBarang, 
            JTextField ketDenda, JTextField denda) {
        if (idBarang.getText().length() > 0) {
            if (ds.getIdBarang() == Integer.valueOf(idBarang.getText())) {
                ds.setKeteranganDenda(ketDenda.getText());

                if (denda.getText().length() <= 0) {
                    ds.setDenda(0);
                } else {
                    ds.setDenda(Float.valueOf(denda.getText()));
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idBarang1 = new javax.swing.JLabel();
        idBarang2 = new javax.swing.JLabel();
        idBarang3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dpPengembalian = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtDendaTelat = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelBarang1 = new javax.swing.JPanel();
        txtBarang1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ketDenda1 = new javax.swing.JTextField();
        denda1 = new javax.swing.JTextField();
        panelBarang2 = new javax.swing.JPanel();
        ketDenda2 = new javax.swing.JTextField();
        denda2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBarang2 = new javax.swing.JLabel();
        panelBarang3 = new javax.swing.JPanel();
        ketDenda3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBarang3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        denda3 = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Pengembalian Sewa");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Tanggal Pengembalian:");

        dpPengembalian.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dpPengembalianPropertyChange(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Denda Telat:");

        txtDendaTelat.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        txtBarang1.setText("Barang 1 (x)");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Denda:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Keterangan Denda:");

        javax.swing.GroupLayout panelBarang1Layout = new javax.swing.GroupLayout(panelBarang1);
        panelBarang1.setLayout(panelBarang1Layout);
        panelBarang1Layout.setHorizontalGroup(
            panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ketDenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(denda1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelBarang1Layout.setVerticalGroup(
            panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarang1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ketDenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(denda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Denda:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Keterangan Denda:");

        txtBarang2.setText("Barang 2 (x)");

        javax.swing.GroupLayout panelBarang2Layout = new javax.swing.GroupLayout(panelBarang2);
        panelBarang2.setLayout(panelBarang2Layout);
        panelBarang2Layout.setHorizontalGroup(
            panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang2Layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ketDenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(denda2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelBarang2Layout.setVerticalGroup(
            panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarang2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ketDenda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(denda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Denda:");

        txtBarang3.setText("Barang 3 (x)");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Keterangan Denda:");

        javax.swing.GroupLayout panelBarang3Layout = new javax.swing.GroupLayout(panelBarang3);
        panelBarang3.setLayout(panelBarang3Layout);
        panelBarang3Layout.setHorizontalGroup(
            panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarang3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ketDenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(denda3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelBarang3Layout.setVerticalGroup(
            panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarang3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarang3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ketDenda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBarang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(denda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_save_black_18dp.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("Rp.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDendaTelat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpan))
                    .addComponent(panelBarang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBarang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBarang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dpPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(txtDendaTelat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBarang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBarang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBarang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (dpPengembalian.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Anda belum mengisi tanggal pengembalian");
            return;
        }
        
        s.setTanggalPengembalian(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dpPengembalian.getDate())));
        s.setDenda(Float.valueOf(txtDendaTelat.getText()));
        
        float totalDenda = s.getDenda();
        
        ArrayList<detailSewa> dsList = s.getSemuaDetailSewa();
        for (detailSewa ds: dsList) {
            checkDetailSewa(ds, idBarang1, ketDenda1, denda1);
            checkDetailSewa(ds, idBarang2, ketDenda2, denda2);
            checkDetailSewa(ds, idBarang3, ketDenda3, denda3);
        }
        
        for (detailSewa ds: dsList) {
            totalDenda += ds.getDenda();
        }
        
        s.setTotal(s.getTotal() + totalDenda);
        
        sc.pengembalian(s, dsList);
        indexFrame.refresh();
        this.dispose();
        
        JOptionPane.showMessageDialog(null, "Data sewa berhasil ditambahkan.");
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void dpPengembalianPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dpPengembalianPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            long dendaTelat = bantuan.bandingkanHari(s.getPeminjamanSampai(), dpPengembalian.getDate());
            int jumlahBarang = s.getSemuaDetailSewa().size();
            
            System.out.println("Telat: " + dendaTelat + " hari \n");
            
            if (dendaTelat > 0) {
                long total = dendaTelat * jumlahBarang * DENDA_PER_BARANG;
                txtDendaTelat.setText(String.valueOf(total));
            } else {
                txtDendaTelat.setText("0");
            }
        }
    }//GEN-LAST:event_dpPengembalianPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextField denda1;
    private javax.swing.JTextField denda2;
    private javax.swing.JTextField denda3;
    private com.toedter.calendar.JDateChooser dpPengembalian;
    private javax.swing.JLabel idBarang1;
    private javax.swing.JLabel idBarang2;
    private javax.swing.JLabel idBarang3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField ketDenda1;
    private javax.swing.JTextField ketDenda2;
    private javax.swing.JTextField ketDenda3;
    private javax.swing.JPanel panelBarang1;
    private javax.swing.JPanel panelBarang2;
    private javax.swing.JPanel panelBarang3;
    private javax.swing.JLabel txtBarang1;
    private javax.swing.JLabel txtBarang2;
    private javax.swing.JLabel txtBarang3;
    private javax.swing.JLabel txtDendaTelat;
    // End of variables declaration//GEN-END:variables
}
