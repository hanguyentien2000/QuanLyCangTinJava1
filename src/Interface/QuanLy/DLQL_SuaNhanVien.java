/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import Models.LoaiNhanVienDTO;
import Models.NhanVienDTO;
import SQLConnect.ConnectSQL;
import Store.StoreData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DLQL_SuaNhanVien extends javax.swing.JDialog {

    ConnectSQL con = new ConnectSQL();
    ArrayList<LoaiNhanVienDTO> cbbLoaiNV = new ArrayList<>();

    /**
     * Creates new form DLQL_SuaNhanVien
     */
    public DLQL_SuaNhanVien() {
        initComponents();
        ButtonGroup btn = new ButtonGroup();
        btn.add(rdNu);
        btn.add(rdNam);
        try {
            cbbLoaiNV = con.GetAllLoaiNV();
            DefaultComboBoxModel md = new DefaultComboBoxModel();
            cbxLoai.setModel(md);
            for (int i = 0; i < cbbLoaiNV.size(); i++) {
                cbxLoai.addItem(cbbLoaiNV.get(i).getTenLoaiNV());
            }
            cbxLoai.setSelectedItem(con.GetLoaiNVById(StoreData.currentNhanVien.getMaLoaiNV()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        txtHoTen.setText(StoreData.currentNhanVien.getHoTen());
        txtSDT.setText(Integer.toString(StoreData.currentNhanVien.getsDT()));
        txtDiaChi.setText(StoreData.currentNhanVien.getDiaChi());
        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(StoreData.currentNhanVien.getNgaySinh()));
            dateNgaysinh.setSelectedDate(cal);
        }
        catch(Exception ex){
            
        }
        txtLuongCoBan.setText(Integer.toString(StoreData.currentNhanVien.getLuongCoBan()));
        if (StoreData.currentNhanVien.getGioitinh().equals("Nam")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtLuongCoBan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblten = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        rdNu = new javax.swing.JRadioButton();
        cbxLoai = new javax.swing.JComboBox<>();
        dateNgaysinh = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txtLuongCoBan.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Họ Tên:");

        lblten.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblten.setForeground(new java.awt.Color(51, 0, 51));
        lblten.setText("Sửa nhân viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("SDT:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ngày Sinh:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Chức vụ:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHuy.setText("Huỷ Bỏ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Lương cơ bản:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Giới tính");

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

        cbxLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLoaiItemStateChanged(evt);
            }
        });

        dateNgaysinh.setCalendarBackground(new java.awt.Color(133, 140, 148));
        dateNgaysinh.setCalendarPreferredSize(new java.awt.Dimension(350, 300));
        dateNgaysinh.setLocale(new java.util.Locale("vi", "VN", ""));
        dateNgaysinh.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
        dateNgaysinh.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(67, 67, 67)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdNam)
                                                .addGap(27, 27, 27)
                                                .addComponent(rdNu))
                                            .addComponent(dateNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblten)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblten, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdNam)
                    .addComponent(rdNu)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        try {
            if (txtHoTen.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Họ tên không được để trống !");
                return;
            }
            if (txtSDT.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "SDT không được để trống !");
                return;
            }
            if (txtDiaChi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
                return;
            }
          
            if (!rdNam.isSelected() && !rdNu.isSelected()) {
                JOptionPane.showMessageDialog(null, "Chưa chọn giới tính");
                return;
            }
            NhanVienDTO nv = new NhanVienDTO();
            nv.setMaNV(StoreData.currentNhanVien.getMaNV());
            nv.setHoTen(txtHoTen.getText());
            nv.setsDT(Integer.parseInt(txtSDT.getText()));
            nv.setDiaChi(txtDiaChi.getText());

            Calendar cd = dateNgaysinh.getSelectedDate();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String ngay = df.format(cd.getTime());
            nv.setNgaySinh(ngay);
            nv.setLuongCoBan(Integer.parseInt(txtLuongCoBan.getText()));
            int MaLoai = cbbLoaiNV.get(cbxLoai.getSelectedIndex()).getMaLoaiNV();
            nv.setMaLoaiNV(MaLoai);
//            nv.setTrangThai(cbxStatus.getSelectedIndex() == 0);
            if (rdNam.isSelected()) {
                nv.setGioitinh("Nam");
            }
            if (rdNu.isSelected()) {
                nv.setGioitinh("Nữ");
            }
            con.UpdateNhanVien(nv);
            StoreData.dsNV = con.GetAllNhanVien();
            JpQuanLyNhanVien.nv.loadData();
            JpQuanLyNhanVien.nv.updateUI();
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Số điện thoại sai định dạng!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại");
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void cbxLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLoaiItemStateChanged
        // TODO add your handling code here:
        if (cbxLoai.getSelectedIndex() == 0) {
            txtLuongCoBan.setText("22000");
        }
        if (cbxLoai.getSelectedIndex() == 1) {
            txtLuongCoBan.setText("16000");
        }
        if (cbxLoai.getSelectedIndex() == 2) {
            txtLuongCoBan.setText("15000");
        }
    }//GEN-LAST:event_cbxLoaiItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DLQL_SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLQL_SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLQL_SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLQL_SuaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLQL_SuaNhanVien dialog = new DLQL_SuaNhanVien();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxLoai;
    private datechooser.beans.DateChooserCombo dateNgaysinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblten;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuongCoBan;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
