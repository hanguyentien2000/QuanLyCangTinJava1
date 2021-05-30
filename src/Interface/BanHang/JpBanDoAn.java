    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BanHang;

import Models.BanDTO;
import SQLConnect.ConnectSQL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public final class JpBanDoAn extends javax.swing.JPanel {
    ConnectSQL con = new ConnectSQL();
    ArrayList<BanDTO> arrBan;
    
    int MaBan;
    public static JpBanDoAn bh = new JpBanDoAn();
    public JpBanDoAn() {
        initComponents();
        bh = this;
        FillBan();
        btnTrong.setBackground(Color.decode("#8080ff"));
        btnDangPhucVu.setBackground(Color.decode("#66ff66"));
    }
   
    public void ThuGon(){
        jPanel2.removeAll();
        jPanel2.updateUI();        
    }
    
    public void FillBan(){
        arrBan = con.GetAllBan(0);
        if(arrBan != null){
            jpBan.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for(int i = 0; i < arrBan.size(); i++){
                //Button Bàn
                btn[i] = new JButton();
                btn[i].setName(String.valueOf(arrBan.get(i).GetMaBan()));
                String[] mb = arrBan.get(i).GetTenBan().split(" "); 
                btn[i].setText(mb[1]);
                btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/ico-Table.png")));
                Border thickBorder = new LineBorder(Color.WHITE,8);
                btn[i].setBorder(thickBorder);
                btn[i].setBackground(Color.decode("#8080ff"));
                btn[i].setFont(new java.awt.Font("Tahoma", 1, 10)); 
                btn[i].setForeground(new java.awt.Color(51, 51, 51));
                
                if(arrBan.get(i).GetTrangThai().equals("Đang phục vụ")){
                    btn[i].setBackground(Color.decode("#66ff66"));
                }
                    
                btn[i].setPreferredSize(new Dimension(90, 70));
                btn[i].addMouseListener(new MouseAdapter() {
                    
                        ///In ra Trạng Thái, Tên Bàn của bàn được chọn
                        @Override
                        public void mousePressed(MouseEvent e) {
                            JpGoiDo goimon;
                            arrBan = con.GetAllBan(Integer.parseInt(e.getComponent().getName()));
                            if(arrBan != null){                            
                                goimon = new JpGoiDo(arrBan.get(0).GetTrangThai(),arrBan.get(0).GetTenBan(),arrBan.get(0).GetMaBan());
                                jPanel2.removeAll();
                                jPanel2.add(goimon);
                                jPanel2.updateUI();
                            }
                        }                    
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();
            }
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpBan = new javax.swing.JPanel();
        btnDangPhucVu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnTrong = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(Color.decode("#e6e6e6"));
        setPreferredSize(new java.awt.Dimension(1280, 519));

        jPanel2.setBackground(Color.decode("#e6e6e6"));
        jPanel2.setPreferredSize(new java.awt.Dimension(580, 519));
        jPanel2.setLayout(new java.awt.BorderLayout(200, 300));

        jLabel1.setMaximumSize(new java.awt.Dimension(580, 519));
        jLabel1.setMinimumSize(new java.awt.Dimension(580, 519));
        jLabel1.setPreferredSize(new java.awt.Dimension(580, 519));
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(Color.decode("#e6e6e6"));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));

        jpBan.setBackground(Color.decode("#e6e6e6"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Free");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Serving");

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Images/info.png"))); // NOI18N
        jLabel6.setText("Chất lượng đặt lên hàng đầu!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(btnDangPhucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTrong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDangPhucVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangPhucVu;
    private javax.swing.JButton btnTrong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpBan;
    // End of variables declaration//GEN-END:variables
}
