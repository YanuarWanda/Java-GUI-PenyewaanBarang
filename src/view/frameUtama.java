package view;

import helper.bantuan;
import sewa.indexSewa;
import kelola_user.classKelolaUser;
import kelola_user.kelolaUserUtama;

public class frameUtama extends javax.swing.JFrame {
    int id_user = 0;
    int id_cabang = 0;
    String status = "";
    
    public frameUtama(int id_user, int id_cabang, String status) {
        initComponents();
        this.id_user = id_user;
        this.id_cabang = id_cabang;
        this.status = status;
        this.setExtendedState(MAXIMIZED_BOTH);
        
        if (!status.equals("admin")) {
            menuKelolaUser.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuTentang = new javax.swing.JMenuItem();
        menuKeluar = new javax.swing.JMenuItem();
        menuData = new javax.swing.JMenu();
        menuKelolaBarang = new javax.swing.JMenuItem();
        menuKelolaCabang = new javax.swing.JMenuItem();
        menuKelolaPenyewa = new javax.swing.JMenuItem();
        menuKelolaSewa = new javax.swing.JMenuItem();
        menuKelolaUser = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penyewaan Barang");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("Halaman Utama"); // NOI18N
        setSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelUtamaLayout = new javax.swing.GroupLayout(panelUtama);
        panelUtama.setLayout(panelUtamaLayout);
        panelUtamaLayout.setHorizontalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        panelUtamaLayout.setVerticalGroup(
            panelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        menu.setText("Menu");

        menuTentang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuTentang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_info_black_18dp.png"))); // NOI18N
        menuTentang.setText("Tentang Aplikasi");
        menu.add(menuTentang);

        menuKeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_power_settings_new_black_18dp.png"))); // NOI18N
        menuKeluar.setText("Keluar Aplikasi");
        menuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKeluarActionPerformed(evt);
            }
        });
        menu.add(menuKeluar);

        menuBar.add(menu);

        menuData.setText("Data");

        menuKelolaBarang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuKelolaBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_work_black_18dp.png"))); // NOI18N
        menuKelolaBarang.setText("Kelola Barang");
        menuData.add(menuKelolaBarang);

        menuKelolaCabang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuKelolaCabang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_flag_black_18dp.png"))); // NOI18N
        menuKelolaCabang.setText("Kelola Cabang");
        menuData.add(menuKelolaCabang);

        menuKelolaPenyewa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuKelolaPenyewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_face_black_18dp.png"))); // NOI18N
        menuKelolaPenyewa.setText("Kelola Penyewa");
        menuKelolaPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKelolaPenyewaActionPerformed(evt);
            }
        });
        menuData.add(menuKelolaPenyewa);

        menuKelolaSewa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuKelolaSewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_shopping_basket_black_18dp.png"))); // NOI18N
        menuKelolaSewa.setText("Kelola Sewa");
        menuKelolaSewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKelolaSewaActionPerformed(evt);
            }
        });
        menuData.add(menuKelolaSewa);

        menuKelolaUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuKelolaUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/baseline_account_circle_black_18dp.png"))); // NOI18N
        menuKelolaUser.setText("Kelola User");
        menuKelolaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKelolaUserActionPerformed(evt);
            }
        });
        menuData.add(menuKelolaUser);

        menuBar.add(menuData);

        menuLaporan.setText("Laporan");
        menuBar.add(menuLaporan);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUtama)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuKeluarActionPerformed

    private void menuKelolaSewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKelolaSewaActionPerformed
        indexSewa fIndexSewa = new indexSewa(this.id_user, this.id_cabang);
        bantuan.tampil(panelUtama, fIndexSewa, this.getSize());
    }//GEN-LAST:event_menuKelolaSewaActionPerformed

    private void menuKelolaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKelolaUserActionPerformed
        boolean buka = classKelolaUser.get_tampil();
        if(!buka){
            kelolaUserUtama KU = new kelolaUserUtama();
            bantuan.tampil(panelUtama, KU, this.getSize());
            classKelolaUser.set_tampil(true);
        }
    }//GEN-LAST:event_menuKelolaUserActionPerformed

    private void menuKelolaPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKelolaPenyewaActionPerformed
        penyewa fPenyewa = new penyewa();
        bantuan.tampil(panelUtama, fPenyewa, this.getSize());
    }//GEN-LAST:event_menuKelolaPenyewaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuData;
    private javax.swing.JMenuItem menuKelolaBarang;
    private javax.swing.JMenuItem menuKelolaCabang;
    private javax.swing.JMenuItem menuKelolaPenyewa;
    private javax.swing.JMenuItem menuKelolaSewa;
    private javax.swing.JMenuItem menuKelolaUser;
    private javax.swing.JMenuItem menuKeluar;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenuItem menuTentang;
    private javax.swing.JDesktopPane panelUtama;
    // End of variables declaration//GEN-END:variables
}
