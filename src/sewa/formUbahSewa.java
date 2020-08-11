package sewa;

import penyewa.penyewa;
import penyewa.penyewaController;
import barang.barang;
import barang.barangController;
import helper.bantuan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class formUbahSewa extends javax.swing.JDialog {
    sewa s = null;
    indexSewa indexFrame = null;
    
    barangController bc = new barangController();
    penyewaController pc = new penyewaController();
    sewaController sc = new sewaController();
    
    public formUbahSewa(java.awt.Frame parent, boolean modal, sewa s, indexSewa index) {
        super(parent, modal);
        initComponents();
        this.s = s;
        this.indexFrame = index;
        
        // Isi combo-box
        fillPenyewa();
        fillBarang();
        fillJumlahBarang();
        fillSisanya();
    }
    
    public void fillPenyewa() {
        ArrayList<penyewa> daftarPenyewa = pc.tampilSemuaPenyewa();
        
        cbPenyewa.addItem("Belum pilih");
        
        for (penyewa p: daftarPenyewa) {
            cbPenyewa.addItem(p);
            if (p.getNoKTP().equals(s.getPenyewa().getNoKTP())) {
                cbPenyewa.setSelectedItem(p);
            }
        }
    }
    public void fillBarang() {
        ArrayList<barang> daftarBarang = bc.tampilSemuaBarang(false, indexFrame.id_cabang);
        ArrayList<barang> barangSewaan = bc.getBarangBySewa(s.getId());
        
        cbBarang1.addItem("Belum pilih");
        cbBarang2.addItem("Belum pilih");
        cbBarang3.addItem("Belum pilih");
        
        for (barang b: daftarBarang) {
            cbBarang1.addItem(b);
            cbBarang2.addItem(b);
            cbBarang3.addItem(b);
        }
        
        for (barang bS: barangSewaan) {
            if (cbBarang1.getSelectedItem() == "Belum pilih") {
                checkSelectedBarang(daftarBarang, bS, cbBarang1);
            } else if (cbBarang2.getSelectedItem() == "Belum pilih") {
                checkSelectedBarang(daftarBarang, bS, cbBarang2);
            } else if (cbBarang3.getSelectedItem() == "Belum pilih") {
                checkSelectedBarang(daftarBarang, bS, cbBarang3);
            }
        }
    }
    public void checkSelectedBarang(ArrayList<barang> daftarBarang, 
            barang barangSewaan, JComboBox cb) {
        for (barang b: daftarBarang) {
            if (barangSewaan.getId() == b.getId()) {
                cb.setSelectedItem(b);
                return;
            }
        }
    }
    public void fillJumlahBarang() {
        checkJumlahBarang(cbBarang1, spinnerJumlahBarang1);
        checkJumlahBarang(cbBarang2, spinnerJumlahBarang2);
        checkJumlahBarang(cbBarang3, spinnerJumlahBarang3);
    }
    public void checkJumlahBarang(JComboBox cbBarang, JSpinner spinner) {
        if (cbBarang.getSelectedItem() == "Belum pilih") return ;
        
        ArrayList<detailSewa> list = sc.getDetailSewa(s.getId());
        barang b = (barang) cbBarang.getSelectedItem();
        
        for (detailSewa ds: list) {
            if (b.getId() == ds.getIdBarang()) {
                spinner.setValue((Object) ds.getJumlah());
            }
        }
    }
    public void fillSisanya() {
        dpDari.setDate(s.getTanggalPeminjaman());
        dpSampai.setDate(s.getPeminjamanSampai());
        txtTotal.setText(String.valueOf(s.getTotal()));
    }
    public void updateTotal() {
        float totalBarang1 = 0, totalBarang2 = 0, totalBarang3 = 0;
        
        // Periksa waktu penyewaan
        Date sewaDari = dpDari.getDate();
        Date sewaSampai = dpSampai.getDate();
        
        if (sewaDari != null && sewaSampai != null) {
            long lamaSewa = bantuan.bandingkanHari(sewaDari, sewaSampai);
            
            if (lamaSewa > 0) {
                // Periksa barang 1
                if (cbBarang1.getSelectedItem() != "Belum pilih") {
                    barang barang1 = (barang) cbBarang1.getSelectedItem();
                    int jumlah1 = (int) spinnerJumlahBarang1.getValue();
                    totalBarang1 = lamaSewa * barang1.getHargaSewa() * jumlah1;
                }
                // Periksa barang 2
                if (cbBarang2.getSelectedItem() != "Belum pilih") {
                    barang barang2 = (barang) cbBarang2.getSelectedItem();
                    int jumlah2 = (int) spinnerJumlahBarang2.getValue();
                    totalBarang2 = lamaSewa * barang2.getHargaSewa() * jumlah2;
                }

                // Periksa barang 3
                if (cbBarang3.getSelectedItem() != "Belum pilih") {
                    barang barang3 = (barang) cbBarang3.getSelectedItem();
                    int jumlah3 = (int) spinnerJumlahBarang3.getValue();
                    totalBarang3 = lamaSewa * barang3.getHargaSewa() * jumlah3;
                }

                // Jumlahkan total harga
                float total = totalBarang1 + totalBarang2 + totalBarang3;
                txtTotal.setText(String.valueOf(total));
            } else {
                txtTotal.setText("");
            }
        } else {
            txtTotal.setText("");
        }
    }
    public void reset() {
        cbPenyewa.setSelectedIndex(0);
        cbBarang1.setSelectedIndex(0);
        spinnerJumlahBarang1.setValue((Object) 1);
        spinnerJumlahBarang1.setEnabled(false);
        cbBarang2.setSelectedIndex(0);
        spinnerJumlahBarang2.setValue((Object) 1);
        spinnerJumlahBarang2.setEnabled(false);
        cbBarang3.setSelectedIndex(0);
        spinnerJumlahBarang3.setValue((Object) 1);
        spinnerJumlahBarang3.setEnabled(false);
        
        txtIdPenyewa.setText("");
        txtIdBarang1.setText("");
        txtIdBarang2.setText("");
        txtIdBarang3.setText("");
        
        dpDari.setDate(new Date());
        dpSampai.setCalendar(null);
        txtTotal.setText("");
    }

    public void validasiJumlahBarang(JComboBox cbBarang, JSpinner spinner) {
        if (cbBarang.getSelectedItem() == "Belum pilih") return;
        
        barang b = (barang) cbBarang.getSelectedItem();

        int jumlahBarang = (int) spinner.getValue();
        int jumlahBarangLama = b.getDetailSewaBySewa(s.getId()).getJumlah();
        int stok = b.getStok();

        if (jumlahBarang > 0) {
            if (jumlahBarang <= stok + jumlahBarangLama) {
                updateTotal();
            } else {
                spinner.setValue((Object) (stok + jumlahBarangLama));
            }
        } else {
            spinner.setValue((Object) 1);
        }
    }
    public void validasiBarang(JComboBox cbBarang, JSpinner spinner, JTextField txtIdBarang) {
        if (cbBarang.getSelectedItem() != "Belum pilih") {
            barang b = (barang)cbBarang.getSelectedItem();
            txtIdBarang.setText(String.valueOf(b.getId()));
            spinner.setEnabled(true);
        } else {
            spinner.setEnabled(false);
        }
        
        updateTotal();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdPenyewa = new javax.swing.JTextField();
        txtIdBarang1 = new javax.swing.JTextField();
        txtIdBarang2 = new javax.swing.JTextField();
        txtIdBarang3 = new javax.swing.JTextField();
        cbPenyewa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbBarang1 = new javax.swing.JComboBox();
        spinnerJumlahBarang1 = new javax.swing.JSpinner();
        cbBarang2 = new javax.swing.JComboBox();
        spinnerJumlahBarang2 = new javax.swing.JSpinner();
        cbBarang3 = new javax.swing.JComboBox();
        spinnerJumlahBarang3 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        dpDari = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dpSampai = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Ubah Sewa");

        cbPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPenyewaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Penyewa:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Barang yang disewa:");

        cbBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBarang1ActionPerformed(evt);
            }
        });

        spinnerJumlahBarang1.setEnabled(false);
        spinnerJumlahBarang1.setValue((Object) 1);
        spinnerJumlahBarang1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerJumlahBarang1StateChanged(evt);
            }
        });

        cbBarang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBarang2ActionPerformed(evt);
            }
        });

        spinnerJumlahBarang2.setEnabled(false);
        spinnerJumlahBarang2.setValue((Object) 1);
        spinnerJumlahBarang2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerJumlahBarang2StateChanged(evt);
            }
        });

        cbBarang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBarang3ActionPerformed(evt);
            }
        });

        spinnerJumlahBarang3.setEnabled(false);
        spinnerJumlahBarang3.setValue((Object) 1);
        spinnerJumlahBarang3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerJumlahBarang3StateChanged(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Waktu Penyewaan");

        dpDari.setDate(new Date());
        dpDari.setDateFormatString("yyyy-MM-dd");
        dpDari.setMaxSelectableDate(new java.util.Date(253370743282000L));
        dpDari.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dpDariPropertyChange(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Dari:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Sampai: ");

        dpSampai.setDateFormatString("yyyy-MM-dd");
        dpSampai.setMaxSelectableDate(new java.util.Date(253370743282000L));
        dpSampai.setMinSelectableDate(bantuan.besok(dpDari.getDate()));
        dpSampai.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dpSampaiPropertyChange(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Total: Rp.");

        txtTotal.setEnabled(false);

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_save_black_18dp.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_refresh_black_18dp.png"))); // NOI18N
        btnRefresh.setText("Reset");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerJumlahBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerJumlahBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerJumlahBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbPenyewa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpDari, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbPenyewa)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbBarang1)
                        .addComponent(spinnerJumlahBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBarang2)
                    .addComponent(spinnerJumlahBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBarang3)
                    .addComponent(spinnerJumlahBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpDari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnRefresh))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPenyewaActionPerformed
        if (cbPenyewa.getSelectedItem() != "Belum pilih") {
            penyewa p = (penyewa) cbPenyewa.getSelectedItem();
            txtIdPenyewa.setText(p.getNoKTP());
        }
    }//GEN-LAST:event_cbPenyewaActionPerformed

    private void cbBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBarang1ActionPerformed
        validasiBarang(cbBarang1, spinnerJumlahBarang1, txtIdBarang1);
    }//GEN-LAST:event_cbBarang1ActionPerformed

    private void spinnerJumlahBarang1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerJumlahBarang1StateChanged
        validasiJumlahBarang(cbBarang1, spinnerJumlahBarang1);
    }//GEN-LAST:event_spinnerJumlahBarang1StateChanged

    private void cbBarang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBarang2ActionPerformed
        validasiBarang(cbBarang2, spinnerJumlahBarang2, txtIdBarang2);
    }//GEN-LAST:event_cbBarang2ActionPerformed

    private void spinnerJumlahBarang2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerJumlahBarang2StateChanged
        validasiJumlahBarang(cbBarang2, spinnerJumlahBarang2);
    }//GEN-LAST:event_spinnerJumlahBarang2StateChanged

    private void cbBarang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBarang3ActionPerformed
        validasiBarang(cbBarang3, spinnerJumlahBarang3, txtIdBarang3);
    }//GEN-LAST:event_cbBarang3ActionPerformed

    private void spinnerJumlahBarang3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerJumlahBarang3StateChanged
        validasiJumlahBarang(cbBarang3, spinnerJumlahBarang3);
    }//GEN-LAST:event_spinnerJumlahBarang3StateChanged

    private void dpDariPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dpDariPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            dpSampai.setMinSelectableDate(bantuan.besok(dpDari.getDate()));
            updateTotal();
        }
    }//GEN-LAST:event_dpDariPropertyChange

    private void dpSampaiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dpSampaiPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            updateTotal();
        }
    }//GEN-LAST:event_dpSampaiPropertyChange

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (cbPenyewa.getSelectedItem() == "Belum pilih") {
            JOptionPane.showMessageDialog(null, "Anda belum memilih penyewa");
            return;
        }
        
        if (cbBarang1.getSelectedItem() == "Belum pilih" && cbBarang2.getSelectedItem() == "Belum pilih" && cbBarang3.getSelectedItem() == "Belum pilih") {
            JOptionPane.showMessageDialog(null, "Anda belum memilih satu pun barang yang akan disewa");
            return;
        }
        
        if (dpSampai.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Anda belum memilih batas tanggal peminjaman");
            return;
        }
        
        if (bantuan.bandingkanHari(dpDari.getDate(), dpSampai.getDate()) < 1) {
            JOptionPane.showMessageDialog(null, "Tanggal peminjaman sampai tidak valid");
            return;
        }
        
        sewa s = new sewa(
            this.s.getId(), txtIdPenyewa.getText(), indexFrame.id_user, indexFrame.id_cabang,
            java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dpDari.getDate())),
            java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dpSampai.getDate())),
            null, Float.valueOf(txtTotal.getText()), 0.0f
        );
        ArrayList<detailSewa> ds = new ArrayList<>();

        if (cbBarang1.getSelectedItem() != "Belum pilih") {
            ds.add(new detailSewa(0, Integer.valueOf(txtIdBarang1.getText()), (int) spinnerJumlahBarang1.getValue(), 0.0f, 0.0f, null));
        }
        if (cbBarang2.getSelectedItem() != "Belum pilih") {
            ds.add(new detailSewa(0, Integer.valueOf(txtIdBarang2.getText()), (int) spinnerJumlahBarang2.getValue(), 0.0f, 0.0f, null));
        }
        if (cbBarang3.getSelectedItem() != "Belum pilih") {
            ds.add(new detailSewa(0, Integer.valueOf(txtIdBarang3.getText()), (int) spinnerJumlahBarang3.getValue(), 0.0f, 0.0f, null));
        }

        if (ds.size() > 0) {
            sc.updateSewa(s, ds, bantuan.bandingkanHari(dpDari.getDate(), dpSampai.getDate()));

            reset();
            this.dispose();
            indexFrame.refresh();

            JOptionPane.showMessageDialog(null, "Data sewa berhasil diubah.");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        reset();
    }//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cbBarang1;
    private javax.swing.JComboBox cbBarang2;
    private javax.swing.JComboBox cbBarang3;
    private javax.swing.JComboBox cbPenyewa;
    private com.toedter.calendar.JDateChooser dpDari;
    private com.toedter.calendar.JDateChooser dpSampai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spinnerJumlahBarang1;
    private javax.swing.JSpinner spinnerJumlahBarang2;
    private javax.swing.JSpinner spinnerJumlahBarang3;
    private javax.swing.JTextField txtIdBarang1;
    private javax.swing.JTextField txtIdBarang2;
    private javax.swing.JTextField txtIdBarang3;
    private javax.swing.JTextField txtIdPenyewa;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
