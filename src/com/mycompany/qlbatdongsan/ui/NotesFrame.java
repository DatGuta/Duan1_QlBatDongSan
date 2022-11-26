/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.google.gson.Gson;
import com.mycompany.qlbatdongsan.DAO.HopDongDAO;
import com.mycompany.qlbatdongsan.DAO.KhachHangDAO;
import com.mycompany.qlbatdongsan.DAO.NhanVienDAO;
import com.mycompany.qlbatdongsan.DAO.PhieuDAO;
import com.mycompany.qlbatdongsan.DAO.QuanLyDuAnDAO;
import com.mycompany.qlbatdongsan.DAO.SanGiaoDichDAO;
import com.mycompany.qlbatdongsan.utils.Auth;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import  com.mycompany.qlbatdongsan.Entity.KhachHang;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import com.mycompany.qlbatdongsan.Entity.SanGiaoDich;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HO VAN DAT
 */
public class NotesFrame extends javax.swing.JPanel {

    private int indexFrame = 6;
    QuanLyDuAnDAO daoDA = new QuanLyDuAnDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    SanGiaoDichDAO daoSGD = new SanGiaoDichDAO();
    NhanVienDAO daoNV = new NhanVienDAO();
    HopDongDAO daoHD =new HopDongDAO();
    PhieuDAO daoP = new PhieuDAO();
    String data = "";
    /**
     * Creates new form NotesFrame
     */
    public NotesFrame() {
        initComponents();
        initForm();
    }


    public void initForm() {
        if (Auth.isManager()) {
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/project.256x243.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/dashboard.256x256.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/nhanvien.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/user.256x256.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-accounting-30.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/currency-dollar.256x256.png")));
        } else {
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/project.256x243.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/nhanvien.png")));
            navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-accounting-30.png")));
        }
        showTabNotesQL();
        navigationBar1.addEvent(new EventNavigationBar() {
            @Override
            public void beforeSelected(int index) {
                System.out.println(index);
                indexFrame = index;
                if (Auth.isManager()) {
                    showTabNotesQL();
                } else {
                    showTabNotesNV();
                }
            }

            @Override
            public void afterSelected(int index) {

            }
        });
    }

    private void showTabNotesQL() {
        switch (indexFrame) {
            case 0:
                palAllMain.display(new ProjectFrame());
                
                break;
            case 1:
                palAllMain.display(new DealerBlockFrame());

                break;
            case 2:
                palAllMain.display(new ClientsFrame());

                break;
            case 3:
                palAllMain.display(new StaffFrame());

                break;
            case 4:
                palAllMain.display(new MajorFrame());

                break;
            case 5:
                palAllMain.display(new DebtFrame());

                break;
            case 6:
                palAllMain.display(new GreetFrame());

                break;
            default:
                throw new AssertionError();
        }
    }

    private void showTabNotesNV() {
        switch (indexFrame) {
            case 0:
                palAllMain.display(new ProjectFrame());
                break;
            case 1:
                palAllMain.display(new ClientsFrame());
               break;
            case 2:
                palAllMain.display(new MajorFrame());
                break;
            case 6:
                palAllMain.display(new GreetFrame());
                break;
            default:
                throw new AssertionError();
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

        panelRound1 = new com.mycompany.qlbatdongsan.utils.PanelRound();
        panelRound2 = new com.mycompany.qlbatdongsan.utils.PanelRound();
        navigationBar1 = new com.mycompany.qlbatdongsan.utils.NavigationBar();
        panelRound3 = new com.mycompany.qlbatdongsan.utils.PanelRound();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        palAllMain = new com.mycompany.qlbatdongsan.utils.PanelTransaction();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1340, 867));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottonLeft(30);
        panelRound1.setRoundBottonRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        navigationBar1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout navigationBar1Layout = new javax.swing.GroupLayout(navigationBar1);
        navigationBar1.setLayout(navigationBar1Layout);
        navigationBar1Layout.setHorizontalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        navigationBar1Layout.setVerticalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        panelRound3.setRoundBottonLeft(60);
        panelRound3.setRoundBottonRight(60);
        panelRound3.setRoundTopLeft(60);
        panelRound3.setRoundTopRight(60);

        txtSearch.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Nhập thông tin bạn muốn tìm");
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/search.256x256.png"))); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(navigationBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(navigationBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(palAllMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palAllMain, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here
    }//GEN-LAST:event_formComponentShown

    private void panelRound2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseExited
        // TODO add your handling code here:
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-mouse-40.png")).getImage(), new Point(0, 0), "Custom cursor");
        setCursor(cursor);
    }//GEN-LAST:event_panelRound2MouseExited

    private void panelRound2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseEntered
        // TODO add your handling code here:
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-text-cursor-24.png")).getImage(), new Point(0, 0), "Custom cursor");
        setCursor(cursor);
    }//GEN-LAST:event_panelRound2MouseEntered

    private void panelRound2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelRound2MouseClicked

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        // TODO add your handling code here:
        txtSearch.setText(null);
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        ProjectFrame.Search(txtSearch.getText());
        DealerBlockFrame.Search(txtSearch.getText());
        ClientsFrame.Search(txtSearch.getText());
        StaffFrame.Search(txtSearch.getText());
        MajorFrame.Search(txtSearch.getText());       
    }//GEN-LAST:event_txtSearchKeyReleased
   



 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private com.mycompany.qlbatdongsan.utils.NavigationBar navigationBar1;
    private com.mycompany.qlbatdongsan.utils.PanelTransaction palAllMain;
    private com.mycompany.qlbatdongsan.utils.PanelRound panelRound1;
    private com.mycompany.qlbatdongsan.utils.PanelRound panelRound2;
    private com.mycompany.qlbatdongsan.utils.PanelRound panelRound3;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
