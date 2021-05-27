/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Thongke;

import CustomTable.TableChamCong;
import Models.ChamCongDTO;
import Models.LoaiNhanVienDTO;
import Models.NhanVienDTO;
import SQLConnect.ConnectSQL;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class JpThongKeLuong extends javax.swing.JPanel {
    ArrayList<ChamCongDTO> listCC = new ArrayList<>();
    ArrayList<NhanVienDTO> listNV = new ArrayList<>();
    ConnectSQL con = new ConnectSQL();
    int selectedRow = -1;
    int luongCB = 0;
    String s1;
    String s2;
    String maNV;
    String loaiNV;
    /**
     * 
     */
    /**
     * 
     */

    public void loadCombo() {
        try{
            listNV = con.GetAllNhanVien();
            if (listNV.size()==0) {
                throw new Exception("KHÔNG có mã nhân viên nào !!!");
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            cbxMaNV.setModel(model);
            for(int i=0; i<listNV.size(); i++){
                if(!listNV.get(i).getMaNV().trim().equals("BOSS")){
                cbxMaNV.addItem(listNV.get(i).getMaNV());}
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void tinhLuong(){
        try{
        int soBuoi = 0;
        int tongLuong = 0;
        Date d1 = dateChooser1.getSelectedDate().getTime();
        Date d2 = dateChooser2.getSelectedDate().getTime();
        s1 = String.format("%1$tY-%1$tm-%1$td", d1);
        s2 = String.format("%1$tY-%1$tm-%1$td", d2);
        
        if(d1.after(d2)){
            throw new Exception("Ngày bắt đầu phải nhỏ hơn Ngày kết thúc");
        }
        ArrayList<ChamCongDTO> listByDate = con.GetChamCongByDate(maNV, s1, s2);
        if(listByDate.size() == 0){
            throw new Exception("Không có ngày làm trong khoảng này");
        }
        else{
            for(int i=0; i<listByDate.size(); i++){
                soBuoi ++;
            }
        }
        lbNgayCong.setText(Integer.toString(soBuoi));
        tongLuong = soBuoi * luongCB;
        lbLuongTong.setText(Integer.toString(tongLuong));
        
        ArrayList<ChamCongDTO> listCCByMaNV = con.GetChamCongByDate(maNV, s1, s2);
        tblLuong.setModel(new TableChamCong(listCCByMaNV));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void thanhToanHetLuong(){
        try{
        int soBuoi = 0;
        int tongLuong = 0;
        ArrayList<ChamCongDTO> listCCByMaNV = con.GetChamCongByID(maNV);
        if(listCCByMaNV.size() == 0){
            throw new Exception("Không còn ngày công nào của nhân viên " + maNV);
        }
        else{
            for(int i=0; i<listCCByMaNV.size(); i++){
                soBuoi ++;
            }
        }
        lbNgayCong.setText(Integer.toString(soBuoi));
        tongLuong = soBuoi * luongCB;
        lbLuongTong.setText(Integer.toString(tongLuong));
        tblLuong.setModel(new TableChamCong(listCCByMaNV));
        int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn thanh toán lương của nhân viên này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (kq == 0) {
                con.DeleteChamCongByMaNV(maNV);
                loadCombo();
                JOptionPane.showMessageDialog(null, "Thanh toán thành công");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public JpThongKeLuong() {
        initComponents();
        loadCombo();
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
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLuong = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxMaNV = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dateChooser1 = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        dateChooser2 = new datechooser.beans.DateChooserCombo();
        lbNgayCong = new javax.swing.JLabel();
        lbLuongCoBan = new javax.swing.JLabel();
        lbLuongTong = new javax.swing.JLabel();
        btnTinhLuong1 = new javax.swing.JButton();
        btnThanhToanHetLuong = new javax.swing.JButton();

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("Quản lý lương nhân viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        tblLuong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLuong);

        jLabel1.setText("Mã NV:");

        jLabel2.setText("Lương tổng:");

        jLabel3.setText("Ngày Công:");

        jLabel4.setText("Lương cơ bản:");

        jLabel5.setText("Thời gian làm việc:");

        cbxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxMaNV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMaNVItemStateChanged(evt);
            }
        });

        jLabel6.setText("Từ ngày:");

        dateChooser1.setCalendarBackground(new java.awt.Color(133, 140, 148));
        dateChooser1.setCalendarPreferredSize(new java.awt.Dimension(350, 300));
        dateChooser1.setLocale(new java.util.Locale("vi", "VN", ""));
        dateChooser1.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
        dateChooser1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        jLabel7.setText("Đến ngày:");

        dateChooser2.setCalendarBackground(new java.awt.Color(133, 140, 148));
        dateChooser2.setCalendarPreferredSize(new java.awt.Dimension(350, 300));
        dateChooser2.setLocale(new java.util.Locale("vi", "VN", ""));
        dateChooser2.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
        dateChooser2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        lbNgayCong.setText("...");

        lbLuongCoBan.setText("...");

        lbLuongTong.setText("...");

        btnTinhLuong1.setText("Tính lương");
        btnTinhLuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuong1ActionPerformed(evt);
            }
        });

        btnThanhToanHetLuong.setText("Thanh toán hết lương");
        btnThanhToanHetLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanHetLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayCong)
                            .addComponent(lbLuongCoBan)
                            .addComponent(lbLuongTong)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTinhLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhToanHetLuong)
                        .addGap(62, 62, 62)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayCong))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLuongCoBan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(lbLuongTong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(dateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThanhToanHetLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTinhLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(212, 212, 212))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(133, 133, 133))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMaNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMaNVItemStateChanged
        // TODO add your handling code here:
        maNV = cbxMaNV.getSelectedItem().toString();
        for(int i=0; i<listNV.size(); i++){
            if(listNV.get(i).getMaNV().trim().equals(maNV.trim())){
                luongCB = listNV.get(i).getLuongCoBan();
            }
        }
        lbLuongCoBan.setText(Integer.toString(luongCB));
        ArrayList<ChamCongDTO> listbymanv = con.GetChamCongByID(maNV);
        tblLuong.setModel(new TableChamCong(listbymanv));
    }//GEN-LAST:event_cbxMaNVItemStateChanged

    private void btnTinhLuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuong1ActionPerformed
        // TODO add your handling code here:
        tinhLuong();
    }//GEN-LAST:event_btnTinhLuong1ActionPerformed

    private void btnThanhToanHetLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanHetLuongActionPerformed
        thanhToanHetLuong();
    }//GEN-LAST:event_btnThanhToanHetLuongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToanHetLuong;
    private javax.swing.JButton btnTinhLuong1;
    private javax.swing.JComboBox<String> cbxMaNV;
    private datechooser.beans.DateChooserCombo dateChooser1;
    private datechooser.beans.DateChooserCombo dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLuongCoBan;
    private javax.swing.JLabel lbLuongTong;
    private javax.swing.JLabel lbNgayCong;
    private javax.swing.JTable tblLuong;
    // End of variables declaration//GEN-END:variables
}
