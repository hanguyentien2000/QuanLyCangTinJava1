/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import CustomTable.TableMon;
import Models.LoaiMonAnDTO;
import Models.MonAnDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import SQLConnect.ConnectSQL;
import Store.StoreData;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Admin
 */
public class JpQuanLyMonAn extends javax.swing.JPanel {

    ArrayList<LoaiMonAnDTO> cbbLoai = new ArrayList<>();
    ArrayList<MonAnDTO> listMon = new ArrayList<>();
    ConnectSQL con = new ConnectSQL();
    int selectedRow = -1;
    /**
     * Creates new form JpQuanLyMonAn
     */
    public static JpQuanLyMonAn mon;

    public JpQuanLyMonAn() {
        initComponents();
        StoreData.dsMon = con.GetDsMonAn();
        loadData();
        fillCombo();
        mon = this;
        loadTable();
        cbxNhom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                StoreData.dsMon = con.GetMonAnTheoLoai(cbbLoai.get(cbxNhom.getSelectedIndex()).getMaLoai());
                loadData();
            }
        });
    }

    public void loadData() {
        tblMonAn.setModel(new TableMon());
    }

    public void fillCombo() {
        try {
            cbbLoai = con.GetAllLoaiMonAn();
            DefaultComboBoxModel md = new DefaultComboBoxModel();
            cbxNhom.setModel(md);
            for (int i = 0; i < cbbLoai.size(); i++) {
                cbxNhom.addItem(cbbLoai.get(i).getTenLoai());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không LOAD được combo Loại");
        }
    }

    public void loadTable() {
        if (listMon != null) {
            int somon = 0;
            for (MonAnDTO td : listMon) {
                somon++;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Không có thực đơn !");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonAn = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxNhom = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();

        tblMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMonAn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblMonAn.setSelectionBackground(new java.awt.Color(255, 51, 0));
        tblMonAn.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblMonAn.setShowGrid(false);
        tblMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMonAnMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblMonAn);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("Quản lý món ăn");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tìm");

        txtTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nhóm món:");

        cbxNhom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxNhom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNhomItemStateChanged(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/document_edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/file_delete.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/icon-hoc-nau-an-Huong-nghiep-a-au-2015.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxNhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        DLQL_ThemMonAn td = new DLQL_ThemMonAn();
        td.setLocationRelativeTo(null);
        td.setVisible(true);

    }//GEN-LAST:event_btnThemActionPerformed

    private void cbxNhomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNhomItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxNhomItemStateChanged

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Phải chọn dòng trước khi xoá");
            return;
        } else {
            int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá thông tin này ?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (kq == 0) {
                con.DeleteMon(StoreData.currentMonAn.getMaMon());
                loadData();

            } else {
            }
            selectedRow = -1;
        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Phải chọn món trước khi sửa");
            return;
        } else {
            DLQL_SuaMon td = new DLQL_SuaMon();
            td.setLocationRelativeTo(null);
            td.setVisible(true);
            selectedRow = -1;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        con.TimMon(txtTim.getText());
        selectedRow = -1;
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblMonAnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonAnMousePressed
        // TODO add your handling code here:
        selectedRow = tblMonAn.getSelectedRow();
        StoreData.currentMonAn = StoreData.dsMon.get(selectedRow);
    }//GEN-LAST:event_tblMonAnMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxNhom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMonAn;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
