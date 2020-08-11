package sewa;

import barang.barangController;
import javax.swing.JOptionPane;
import view.frameUtama;
import view.info_pengguna;

public class indexSewa extends javax.swing.JInternalFrame {
    frameUtama fUtama = null;
    int id_user = 0;
    int id_cabang = 0;
    
    sewaController sc = new sewaController();
    barangController bc = new barangController();
    sewaTabelModel tabelModel = new sewaTabelModel();
    
    public indexSewa(frameUtama fUtama, int id_user, int id_cabang) {
        initComponents();
        this.fUtama = fUtama;
        this.id_user = id_user;
        this.id_cabang = id_cabang;
        tampilSewa();
    }
    
    public void tampilSewa() {
        tabelModel.setData(sc.tampilSemuaSewa(info_pengguna.get_cabang()));
        tSewa.setModel(tabelModel);
        
        // Mengatur lebar kolom
        tSewa.getColumnModel().getColumn(0).setMinWidth(0);
        tSewa.getColumnModel().getColumn(0).setMaxWidth(0);
        tSewa.getColumnModel().getColumn(1).setMaxWidth(30);
    }
    
    public void refresh() {
        tabelModel.setData(sc.tampilSemuaSewa(info_pengguna.get_cabang()));
        tabelModel.fireTableDataChanged();
        tSewa.changeSelection(0, 0, false, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tSewa = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnLihat = new javax.swing.JButton();
        btnPengembalian = new javax.swing.JButton();

        setClosable(true);
        setTitle("Pengolahan Data Sewa");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tSewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tSewa);
        if (tSewa.getColumnModel().getColumnCount() > 0) {
            tSewa.getColumnModel().getColumn(0).setResizable(false);
            tSewa.getColumnModel().getColumn(1).setResizable(false);
            tSewa.getColumnModel().getColumn(2).setResizable(false);
            tSewa.getColumnModel().getColumn(3).setResizable(false);
            tSewa.getColumnModel().getColumn(4).setResizable(false);
        }

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_add_circle_black_18dp.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTambah.setMaximumSize(new java.awt.Dimension(100, 0));
        btnTambah.setMinimumSize(new java.awt.Dimension(75, 23));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_edit_black_18dp.png"))); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUbah.setMaximumSize(new java.awt.Dimension(100, 0));
        btnUbah.setMinimumSize(new java.awt.Dimension(75, 23));
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_delete_black_18dp.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHapus.setMaximumSize(new java.awt.Dimension(100, 0));
        btnHapus.setMinimumSize(new java.awt.Dimension(75, 23));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_refresh_black_18dp.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setMaximumSize(new java.awt.Dimension(100, 0));
        btnRefresh.setMinimumSize(new java.awt.Dimension(75, 23));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_search_black_18dp.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCari.setMaximumSize(new java.awt.Dimension(100, 0));
        btnCari.setMinimumSize(new java.awt.Dimension(75, 23));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnLihat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_note_black_18dp.png"))); // NOI18N
        btnLihat.setText("Lihat");
        btnLihat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLihat.setMaximumSize(new java.awt.Dimension(100, 0));
        btnLihat.setMinimumSize(new java.awt.Dimension(75, 23));
        btnLihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatActionPerformed(evt);
            }
        });

        btnPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_swap_horiz_black_18dp.png"))); // NOI18N
        btnPengembalian.setText("Pengembalian");
        btnPengembalian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPengembalian.setMaximumSize(new java.awt.Dimension(100, 0));
        btnPengembalian.setMinimumSize(new java.awt.Dimension(75, 23));
        btnPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPengembalian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLihat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        formTambahSewa fTambahSewa = new formTambahSewa(null, true, this.id_user, this.id_cabang, this);
        fTambahSewa.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            Object[] pilihan = {"Ya", "Tidak"};
            int jawaban = JOptionPane.showOptionDialog(null, "Anda yakin akan menghapus data sewa ini?", "Peringatan", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, pilihan, pilihan[0]);

            if (jawaban == 0) {
                sewa s = sc.pilihSewa((int) tSewa.getValueAt(tSewa.getSelectedRow(), 0));
                
                for(detailSewa ds: s.getSemuaDetailSewa()) {
                    bc.updateStok(ds.getIdBarang(), ds.getBarang().getStok() + ds.getJumlah());
                }
                
                sc.hapusSewa(s.getId());
                
                refresh();
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        tabelModel.setData(sc.cariSewa(txtCari.getText()));
        tabelModel.fireTableDataChanged();
        tSewa.changeSelection(0, 0, false, false);
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        try {
            formUbahSewa fUbahSewa = new formUbahSewa(null, true, sc.pilihSewa((int) tSewa.getValueAt(tSewa.getSelectedRow(), 0)), this);
            fUbahSewa.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnLihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatActionPerformed
        try {
            sewa s = sc.pilihSewa((int) tSewa.getValueAt(tSewa.getSelectedRow(), 0));
            formLihatSewa fLihatSewa = new formLihatSewa(null, true, s, this);
            fLihatSewa.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnLihatActionPerformed

    private void btnPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengembalianActionPerformed
        try {
            sewa s = sc.pilihSewa((int) tSewa.getValueAt(tSewa.getSelectedRow(), 0));
            formPengembalianSewa fPengembalianSewa = new formPengembalianSewa(null, true, s, this);
            fPengembalianSewa.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnPengembalianActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        this.fUtama.tampilSewa = false;
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLihat;
    private javax.swing.JButton btnPengembalian;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tSewa;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
