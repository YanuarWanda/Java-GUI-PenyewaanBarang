package sewa;

import cabang.cabang;
import helper.bantuan;
import java.util.ArrayList;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JRException;
import penyewa.penyewa;

public class formLihatSewa extends javax.swing.JDialog {
    sewa s = null;
    sewaController sc = new sewaController();
    indexSewa indexFrame = null;
    
    public formLihatSewa(java.awt.Frame parent, boolean modal, sewa s, indexSewa index) {
        super(parent, modal);
        initComponents();
        this.s = s;
        this.indexFrame = index;
        
        // Isi data
        txtNoSewa.setText(String.valueOf(s.getId()));
        
        txtNamaPegawai.setText(s.getPegawai().getNama());
        
        cabang c = s.getCabang();
        txtNamaCabang.setText(c.getNama());
        txtAlamatCabang.setText(c.getAlamat());
        txtKontakCabang.setText(c.getKontak());
        
        penyewa p = s.getPenyewa();
        txtNamaPenyewa.setText(p.getNama());
        txtNoKTPPenyewa.setText(p.getNoKTP());
        txtAlamatPenyewa.setText(p.getAlamat());
        txtKontakPenyewa.setText(p.getKontak());
        
        ArrayList<detailSewa> dsList = s.getSemuaDetailSewa();
        
        txtTanggalPeminjaman.setText(String.valueOf(s.getTanggalPeminjaman()) + " - " + String.valueOf(s.getPeminjamanSampai()));
        if (s.getTanggalPengembalian() != null) {
            txtTanggalPengembalian.setText(String.valueOf(s.getTanggalPengembalian()));
            txtDendaTelat.setText("Denda telat (" + String.valueOf(bantuan.bandingkanHari(s.getPeminjamanSampai(), s.getTanggalPengembalian())) + " hari x " + dsList.size() + " barang)");
        } else {
            txtDendaTelat.setText("Denda telat");
            
        }
        
        fillBarang(dsList, txtBarang1, txtHargaBarang1, txtKetDendaBarang1, txtHargaDendaBarang1, 1);
        fillBarang(dsList, txtBarang2, txtHargaBarang2, txtKetDendaBarang2, txtHargaDendaBarang2, 2);
        fillBarang(dsList, txtBarang3, txtHargaBarang3, txtKetDendaBarang3, txtHargaDendaBarang3, 3);
        
        txtHargaDendaTelat.setText(bantuan.formatRupiah(s.getDenda()));
        
        txtTotal.setText(bantuan.formatRupiah(s.getTotal()));
    }
    
    private void fillBarang(ArrayList<detailSewa> dsList, JLabel txtBarang, JLabel txtHargaBarang, JLabel txtKetDenda, JLabel txtHargaDenda, int n) {
        txtKetDenda.setText("");
        txtHargaDenda.setText("");
        
        if (dsList.size() < n) {
            txtBarang.setText("");
            txtHargaBarang.setText("");
            return;
        };
        
        detailSewa ds = dsList.get(n - 1);
        txtBarang.setText(ds.getBarang().getNama() + " (" + String.valueOf(ds.getJumlah()) + ")");
        txtHargaBarang.setText(bantuan.formatRupiah(ds.getTotal()));
        
        if (ds.getKeteranganDenda() != null) {
            txtKetDenda.setText(ds.getKeteranganDenda());
            txtHargaDenda.setText(bantuan.formatRupiah(ds.getDenda()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNoKTPPenyewa = new javax.swing.JLabel();
        txtBarang1 = new javax.swing.JLabel();
        txtHargaBarang1 = new javax.swing.JLabel();
        txtKetDendaBarang1 = new javax.swing.JLabel();
        txtHargaDendaBarang1 = new javax.swing.JLabel();
        txtBarang2 = new javax.swing.JLabel();
        txtHargaBarang2 = new javax.swing.JLabel();
        txtHargaDendaBarang2 = new javax.swing.JLabel();
        txtKetDendaBarang2 = new javax.swing.JLabel();
        txtBarang3 = new javax.swing.JLabel();
        txtHargaBarang3 = new javax.swing.JLabel();
        txtHargaDendaBarang3 = new javax.swing.JLabel();
        txtKetDendaBarang3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtDendaTelat = new javax.swing.JLabel();
        txtHargaDendaTelat = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTanggalPeminjaman = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTanggalPengembalian = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtAlamatPenyewa = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtKontakPenyewa = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        txtNamaPenyewa = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtNoSewa = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtNamaPegawai = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtNamaCabang = new javax.swing.JLabel();
        txtAlamatCabang = new javax.swing.JLabel();
        txtKontakCabang = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnPrint = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lihat Sewa");

        jLabel1.setText("No KTP");

        txtNoKTPPenyewa.setText("noKTPPenyewa");

        txtBarang1.setText("namaBarang1 (x)");
        txtBarang1.setMinimumSize(new java.awt.Dimension(0, 60));

        txtHargaBarang1.setText("Rp. x");
        txtHargaBarang1.setMinimumSize(new java.awt.Dimension(0, 60));

        txtKetDendaBarang1.setText("keteranganDendaBarang1");
        txtKetDendaBarang1.setMinimumSize(new java.awt.Dimension(0, 60));

        txtHargaDendaBarang1.setText("Rp. x");
        txtHargaDendaBarang1.setMinimumSize(new java.awt.Dimension(0, 60));

        txtBarang2.setText("namaBarang2 (x)");
        txtBarang2.setMinimumSize(new java.awt.Dimension(0, 60));

        txtHargaBarang2.setText("Rp. x");
        txtHargaBarang2.setMinimumSize(new java.awt.Dimension(0, 60));

        txtHargaDendaBarang2.setText("Rp. x");
        txtHargaDendaBarang2.setMinimumSize(new java.awt.Dimension(0, 60));

        txtKetDendaBarang2.setText("keteranganDendaBarang2");
        txtKetDendaBarang2.setMinimumSize(new java.awt.Dimension(0, 60));

        txtBarang3.setText("namaBarang3 (x)");
        txtBarang3.setMinimumSize(new java.awt.Dimension(0, 60));

        txtHargaBarang3.setText("Rp. x");
        txtHargaBarang3.setMinimumSize(new java.awt.Dimension(0, 60));

        txtHargaDendaBarang3.setText("Rp. x");
        txtHargaDendaBarang3.setMinimumSize(new java.awt.Dimension(0, 60));

        txtKetDendaBarang3.setText("keteranganDendaBarang3");
        txtKetDendaBarang3.setMinimumSize(new java.awt.Dimension(0, 60));

        jLabel18.setText("Total");

        txtTotal.setText("Rp. x");

        txtDendaTelat.setText("Denda telat (x hari x x barang)");
        txtDendaTelat.setMinimumSize(new java.awt.Dimension(0, 60));

        txtHargaDendaTelat.setText("Rp. x");
        txtHargaDendaTelat.setMinimumSize(new java.awt.Dimension(0, 60));

        jLabel21.setText("Tanggal peminjaman");

        txtTanggalPeminjaman.setText("yyyy-MM-dd - yyyy-MM-dd");

        jLabel23.setText("Tanggal pengembalian");

        txtTanggalPengembalian.setText("-");

        jLabel25.setText("Alamat");

        txtAlamatPenyewa.setText("alamatPenyewa");

        jLabel27.setText("Kontak");

        txtKontakPenyewa.setText("kontakPenyewa");

        jLabel29.setText("Atas Nama");

        txtNamaPenyewa.setText("namaPenyewa");

        jLabel31.setText("No Sewa");

        txtNoSewa.setText("noSewa");

        jLabel33.setText("Pegawai");

        txtNamaPegawai.setText("namaPegawai");

        jLabel35.setText("Cabang");

        txtNamaCabang.setText("namaCabang");

        txtAlamatCabang.setText("alamatCabang");

        txtKontakCabang.setText("kontakCabang");

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_print_black_18dp.png"))); // NOI18N
        btnPrint.setText("Cetak");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKontakCabang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAlamatCabang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNoSewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaCabang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBarang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKetDendaBarang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHargaBarang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHargaDendaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBarang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKetDendaBarang2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHargaBarang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHargaDendaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBarang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKetDendaBarang3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHargaBarang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHargaDendaBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtDendaTelat, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHargaDendaTelat, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoKTPPenyewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTanggalPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTanggalPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAlamatPenyewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKontakPenyewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaPenyewa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrint))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtNoSewa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtNamaPegawai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtNamaCabang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlamatCabang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKontakCabang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtNamaPenyewa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoKTPPenyewa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtAlamatPenyewa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtKontakPenyewa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTanggalPeminjaman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTanggalPengembalian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKetDendaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaDendaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKetDendaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaDendaBarang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKetDendaBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaDendaBarang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDendaTelat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaDendaTelat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            sc.cetakSewa(this.s);
            this.dispose();
        } catch (JRException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel txtAlamatCabang;
    private javax.swing.JLabel txtAlamatPenyewa;
    private javax.swing.JLabel txtBarang1;
    private javax.swing.JLabel txtBarang2;
    private javax.swing.JLabel txtBarang3;
    private javax.swing.JLabel txtDendaTelat;
    private javax.swing.JLabel txtHargaBarang1;
    private javax.swing.JLabel txtHargaBarang2;
    private javax.swing.JLabel txtHargaBarang3;
    private javax.swing.JLabel txtHargaDendaBarang1;
    private javax.swing.JLabel txtHargaDendaBarang2;
    private javax.swing.JLabel txtHargaDendaBarang3;
    private javax.swing.JLabel txtHargaDendaTelat;
    private javax.swing.JLabel txtKetDendaBarang1;
    private javax.swing.JLabel txtKetDendaBarang2;
    private javax.swing.JLabel txtKetDendaBarang3;
    private javax.swing.JLabel txtKontakCabang;
    private javax.swing.JLabel txtKontakPenyewa;
    private javax.swing.JLabel txtNamaCabang;
    private javax.swing.JLabel txtNamaPegawai;
    private javax.swing.JLabel txtNamaPenyewa;
    private javax.swing.JLabel txtNoKTPPenyewa;
    private javax.swing.JLabel txtNoSewa;
    private javax.swing.JLabel txtTanggalPeminjaman;
    private javax.swing.JLabel txtTanggalPengembalian;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
