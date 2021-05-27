/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BanHang;

import Models.BanDTO;
import Models.ChiTietHoaDonDTO;
import Models.HoaDonDTO;
import Models.MonAnDTO;
import SQLConnect.ConnectSQL;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ThangIKCU
 */
public class DLSoLuong extends javax.swing.JDialog {

    ConnectSQL con = new ConnectSQL();
    int sl = 0;
    ArrayList<MonAnDTO> arrThucDon;
    public String Ghichu, TenBan;
    public int Maban, Mamon;
    ChiTietHoaDonDTO cthd;
    public Timestamp gioden = new Timestamp(System.currentTimeMillis());

    /**
     * Creates new form NewJDialog
     */
    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     * @param MaMon
     * @param MaBan
     */
    public DLSoLuong( int MaMon, String Tenban, int MaBan) {

        initComponents();
        Mamon = MaMon;
        TenBan = Tenban;
        Maban = MaBan;
        Fill();
        cthd = con.GetDsChiTiet(MaMon, MaBan);
        if (cthd != null) {
            txtSoLuong.setText(String.valueOf(cthd.getSoLuong()));
            txtGhiChu.setText(cthd.getGhiChu());
        }
    }

    private void Fill() {
        arrThucDon = con.GetMonAnById(Mamon);
        txtSoLuong.setText("1");
        lblban.setText(TenBan + " ");
        lblTenMon.setText(arrThucDon.get(0).getTenMon());
        try {
            HoaDonDTO hd = con.GetHDbyMaBan(Maban);
        }
        catch(NullPointerException e){}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTenMon = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        btnCong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblban = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(140, 140, 6));
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        lblTenMon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTenMon.setForeground(new java.awt.Color(51, 0, 0));
        lblTenMon.setText("Cà phê sữa");

        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnTru.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });

        btnCong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Số lượng:");

        lblban.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblban.setForeground(new java.awt.Color(0, 51, 0));
        lblban.setText("Bàn1");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ghi Chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblban)
                                .addGap(42, 42, 42)
                                .addComponent(lblTenMon))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnTru, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCong)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblban)
                    .addComponent(lblTenMon))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTru, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        try {
            sl = Integer.parseInt(txtSoLuong.getText());
            if (sl < 30) {
                sl++;
                txtSoLuong.setText(String.valueOf(sl));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Quantity");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCongActionPerformed

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        try {
            sl = Integer.parseInt(txtSoLuong.getText());
            if (sl != 1 && sl != 0) {
                sl--;
                txtSoLuong.setText(String.valueOf(sl));
            }
        } catch (Exception e) {
            txtSoLuong.setText("1");
        }

    }//GEN-LAST:event_btnTruActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        String ghichu = txtGhiChu.getText();
        HoaDonDTO hd = new HoaDonDTO();
        try {
            if (con.GetMaHD(Maban) == 0) { 
                hd = new HoaDonDTO();
                hd.setMaBan(Maban);
                hd.setTongTien(0);
                hd.setTrangThai(false);
                int insertHd = con.InsertHoaDon(hd, gioden);
            } else {
                //Lấy ra những bàn có trạng thái bằng 0
                hd = con.GetHDbyMaBan(Maban);
                //Cập nhật lại những hoá đơn đó với trạng thái mới
                con.UpdateHD(hd);
            }
            if (cthd != null) {
//                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
                cthd.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                cthd.setGhiChu(txtGhiChu.getText());
                cthd.setMaChiTietHD(cthd.getMaChiTietHD());
                int updateCTHD = con.UpdateChiTietHD(cthd);
            }
            if (cthd == null) {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaHoaDon(con.GetMaHD(Maban));
                cthd.setMaMon(Mamon);
                cthd.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                cthd.setGhiChu(txtGhiChu.getText());
                int insertCTHD = con.InsertChiTietHD(cthd);
            }
            BanDTO b = new BanDTO();
            b.SetTrangThai("Đang phục vụ");
            b.SetTenBan(TenBan);
            b.SetMaBan(Maban);
            int updateban = con.UpdateBan(b);

            JpBanDoAn.bh.FillBan();
            JpBanDoAn.bh.updateUI();
            JpGoiDo.Goimon.fillDsMon(con.GetMaHD(Maban));
            JpGoiDo.Goimon.updateUI();

            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        try {
            sl = Integer.parseInt(txtSoLuong.getText());
            if (txtSoLuong.getText().equals("0") || sl > 30) {
                txtSoLuong.setText("1");
            }
        } catch (NumberFormatException ex) {
            txtSoLuong.setText("1");
        }
         
    }//GEN-LAST:event_txtSoLuongKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTenMon;
    private javax.swing.JLabel lblban;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
