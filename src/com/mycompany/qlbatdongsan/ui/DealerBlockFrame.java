/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.SanGiaoDichDAO;
import com.mycompany.qlbatdongsan.Entity.SanGiaoDich;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HO VAN DAT
 */
public class DealerBlockFrame extends javax.swing.JPanel {
    SanGiaoDichDAO daoSGD = new SanGiaoDichDAO();
    private int row = -1;
    DefaultTableModel model;

    /**
     * Creates new form DealerBlockFrame
     */
    public DealerBlockFrame() {
        initComponents();
        initTableSanGiaoDich();
        initTableSanPhamBan_ChoThue();
        initTableSanPhamDuAn();
    }

    private void initTableSanGiaoDich() {
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        };
        Object[] column = {"Sàn giao dịch", "Khóa", "Điện thoại", "Fax", "Địa chỉ", "Người liên hệ", "Chức vụ", "Điện thoại NLH", "Nhân viên quản lý"
            + "Nhân viên tạo", "Ngày tạo"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblSanGiaoDich.setModel(model);
    }

    private void initTableSanPhamDuAn() {
        model = new DefaultTableModel();
        Object[] column = {"STT", "Kí hiệu", "Trạng thái", "Dự án", "Khu", "Phân khu", "Tầng", "Mã lô/Số nhà", "DTXD", "Đơn giá XD", "Thành tiền", "DT đất", "Đơn giá", "Thành tiền", "Nhân viên"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblSPDuAn.setModel(model);
    }

    private void initTableSanPhamBan_ChoThue() {
        model = new DefaultTableModel();
        Object[] column = {"STT", "Kí hiệu", "Khách hàng", "Điện thoại", "Nhu cầu", "Lọa BĐS", "Khu vực", "Địa chỉ", "Rộng", "Dài", "Diện tích", "Đơn giá", "Tổng giá trị", "Giá gốc"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblSanPhamB_CT.setModel(model);
    }

    public void edit() {
        SanGiaoDich SGD = daoSGD.selectById(Integer.parseInt(tblSanGiaoDich.getValueAt(row, 0).toString()));
        SeeDealerBlockFrame seeDealerBlockFrame = new  SeeDealerBlockFrame(SGD);
        seeDealerBlockFrame.setVisible(true);
    }

    public static void Search(String str) {
        if (str.length() > 0) {
            if (tblSanGiaoDich!=null) {
                DefaultTableModel model = (DefaultTableModel) tblSanGiaoDich.getModel();
                TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
                tblSanGiaoDich.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(str));
            }else{
               return;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanGiaoDich = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSPDuAn = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamB_CT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });

        tblSanGiaoDich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSanGiaoDich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanGiaoDichMousePressed(evt);
            }
        });
        tblSanGiaoDich.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblSanGiaoDichInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanGiaoDich);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhân viên", jPanel1);

        tblSPDuAn.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblSPDuAn);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm dự án", jPanel2);

        tblSanPhamB_CT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblSanPhamB_CT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm (bán, cho thuê)", jPanel3);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("KHỐI ĐẠI LÝ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(552, 552, 552)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addGap(120, 120, 120)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDealerBlockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDealerBlockMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddDealerBlockMouseClicked

    private void btnAddDealerBlockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDealerBlockMouseEntered
        // TODO add your handling code here:
//        btnAddDealerBlock.setBounds(btnAddDealerBlock.getX() - 5, btnAddDealerBlock.getY() - 5, btnAddDealerBlock.getWidth() + 10, btnAddDealerBlock.getHeight() + 10);
//        lblAddDealerBlock.setBounds(lblAddDealerBlock.getX(), lblAddDealerBlock.getY(), lblAddDealerBlock.getWidth() + 10, lblAddDealerBlock.getHeight() + 10);
    }//GEN-LAST:event_btnAddDealerBlockMouseEntered

    private void btnAddDealerBlockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddDealerBlockMouseExited
        // TODO add your handling code here:
//        btnAddDealerBlock.setBounds(btnAddDealerBlock.getX() + 5, btnAddDealerBlock.getY() + 5, btnAddDealerBlock.getWidth() - 10, btnAddDealerBlock.getHeight() - 10);
//        lblAddDealerBlock.setBounds(lblAddDealerBlock.getX(), lblAddDealerBlock.getY(), lblAddDealerBlock.getWidth() - 10, lblAddDealerBlock.getHeight() - 10);
    }//GEN-LAST:event_btnAddDealerBlockMouseExited

    private void tblSanGiaoDichMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanGiaoDichMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblSanGiaoDich.rowAtPoint(evt.getPoint());
            edit();
        }
    }//GEN-LAST:event_tblSanGiaoDichMousePressed

    private void tblSanGiaoDichInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblSanGiaoDichInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanGiaoDichInputMethodTextChanged

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorRemoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblSPDuAn;
    private static javax.swing.JTable tblSanGiaoDich;
    private javax.swing.JTable tblSanPhamB_CT;
    // End of variables declaration//GEN-END:variables
}
