/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.NhanVienDAO;
import com.mycompany.qlbatdongsan.DAO.QuanLyDuAnDAO;
import com.mycompany.qlbatdongsan.DAO.SanGiaoDichDAO;
import com.mycompany.qlbatdongsan.DAO.SanPhamDuAnDAO;
import com.mycompany.qlbatdongsan.Entity.NhanVien;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import com.mycompany.qlbatdongsan.Entity.SanGiaoDich;
import com.mycompany.qlbatdongsan.Entity.SanPhamDuAn;
import com.mycompany.qlbatdongsan.utils.MsgBox;
import com.mycompany.qlbatdongsan.utils.XDate;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HO VAN DAT
 */
public class DealerBlockFrame extends javax.swing.JPanel {

    SanGiaoDichDAO daoSGD = new SanGiaoDichDAO();
    SanPhamDuAnDAO daoSPDA = new SanPhamDuAnDAO();
    QuanLyDuAnDAO daoDA = new QuanLyDuAnDAO();
    NhanVienDAO daoNV = new NhanVienDAO();
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
        initTableNhanVien();
        fillToTableSanGiaoDich();
    }

    private void initTableSanGiaoDich() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        };

        Object[] column = {"Sàn giao dịch", "Tên sàn giao dịch", "Điện thoại", "Địa chỉ", "Nhân viên quản lý", "Người tạo", "Ngày tạo"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblSanGiaoDich.setModel(model);
    }

    private void initTableSanPhamDuAn() {
        model = new DefaultTableModel();
        Object[] column = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Tên dự án", "Địa chỉ", "Diện tích", "Loại dự án", "Ngày đăng", "Trạng thái"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblSPDuAn.setModel(model);
    }

    public void edit() {
        SanGiaoDich SGD = daoSGD.selectById(Integer.parseInt(tblSanGiaoDich.getValueAt(row, 0).toString()));
        SeeDealerBlockFrame seeDealerBlockFrame = new SeeDealerBlockFrame(SGD);
        seeDealerBlockFrame.setVisible(true);
    }

    public static void Search(String str) {
        if (str.length() > 0) {
            if (tblSanGiaoDich != null) {
                DefaultTableModel model = (DefaultTableModel) tblSanGiaoDich.getModel();
                TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
                tblSanGiaoDich.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(str));
            } else {
                return;
            }
        }
    }

    private void fillToTableSanGiaoDich() {
        DefaultTableModel model = (DefaultTableModel) tblSanGiaoDich.getModel();
        model.setRowCount(0);
        try {
            List<SanGiaoDich> list = daoSGD.selectAll();
            for (SanGiaoDich sgd : list) {
                Object[] row = {
                    sgd.getMaSGD(),
                    sgd.getSanGiaoDich(),
                    sgd.getSdt(),
                    sgd.getDiaChi(),
                    sgd.getNvQuanLy(),
                    sgd.getNvTao(),
                    XDate.toString(sgd.getNgayTao(), "dd/mm/yyyy"),};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void initTableSanPhamBan_ChoThue() {
        model = new DefaultTableModel();
        Object[] column = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Tên dự án", "Địa chỉ", "Diện tích", "Loại dự án", "Ngày đăng", "Trạng thái"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblSanPhamB_CT.setModel(model);
    }

    private void fillToTableSanPhamDuAN() {
        int Stt = 1;
        DefaultTableModel model = (DefaultTableModel) tblSPDuAn.getModel();
        model.setRowCount(0);
        try {
            if (row == -1) {
                return;
            }
            List<SanPhamDuAn> list = daoSPDA.selectByMaSGD(String.valueOf(tblSanGiaoDich.getValueAt(row, 0)));
            for (SanPhamDuAn spda : list) {
                QuanLyDuAn da = daoDA.selectById(spda.getMaDA());
                Object[] row = {
                    Stt,
                    spda.getMaSPDA(),
                    spda.getTenSP(),
                    da.getTenDA(),
                    spda.getGia(),
                    spda.getDienTich(),
                    spda.getLoaiSP(),
                    spda.getChuSoHuu(),
                    spda.getTrangThai()
                };
                model.addRow(row);
                Stt++;
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void fillToTableSanPhamDuAnBan_ChoThe() {
        int Stt = 1;
        DefaultTableModel model = (DefaultTableModel) tblSanPhamB_CT.getModel();
        model.setRowCount(0);
        try {
            if (row == -1) {
                return;
            }
            List<SanPhamDuAn> list = daoSPDA.selectByMaSGD(String.valueOf(tblSanGiaoDich.getValueAt(row, 0)));
            for (SanPhamDuAn spda : list) {
                if (spda.getTrangThai().equalsIgnoreCase("Đang Cho Thuê") || spda.getTrangThai().equalsIgnoreCase("Đang Bán")) {
                    QuanLyDuAn da = daoDA.selectById(spda.getMaDA());
                    Object[] row = {
                        Stt,
                        spda.getMaSPDA(),
                        spda.getTenSP(),
                        da.getTenDA(),
                        spda.getGia(),
                        spda.getDienTich(),
                        spda.getLoaiSP(),
                        spda.getChuSoHuu(),
                        spda.getTrangThai()
                    };
                    model.addRow(row);
                    Stt++;
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void initTableNhanVien() {
        model = new DefaultTableModel();
        Object[] column = {"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Số nội bộ", "Chức danh", "Giới tính"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblNhanVien.setModel(model);
    }

    private void fillToTableNhanVien() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            if (row == -1) {
                return;
            }
            List<NhanVien> list = daoNV.selectBymaSGD(String.valueOf(tblSanGiaoDich.getValueAt(row, 0)));
            for (NhanVien nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getNgaySinh(),
                    nv.getSoNoiBo(),
                    nv.getChucDanh(),
                    nv.getGioiTinh() ? "Nữ" : "Nam"
                };
                model.addRow(row);

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
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
        btnAddDealerBlock = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblAddDealerBlock = new javax.swing.JLabel();

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanGiaoDichMouseClicked(evt);
            }
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

        btnAddDealerBlock.setRoundBottonLeft(30);
        btnAddDealerBlock.setRoundBottonRight(30);
        btnAddDealerBlock.setRoundTopLeft(30);
        btnAddDealerBlock.setRoundTopRight(30);

        lblAddDealerBlock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddDealerBlock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-add-new-64.png"))); // NOI18N
        lblAddDealerBlock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddDealerBlockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddDealerBlockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddDealerBlockMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnAddDealerBlockLayout = new javax.swing.GroupLayout(btnAddDealerBlock);
        btnAddDealerBlock.setLayout(btnAddDealerBlockLayout);
        btnAddDealerBlockLayout.setHorizontalGroup(
            btnAddDealerBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAddDealerBlock, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        btnAddDealerBlockLayout.setVerticalGroup(
            btnAddDealerBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAddDealerBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE)
        );

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
            .addGroup(layout.createSequentialGroup()
                .addGap(553, 553, 553)
                .addComponent(btnAddDealerBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(btnAddDealerBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
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

    private void lblAddDealerBlockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddDealerBlockMouseClicked
        // TODO add your handling code here:
        AddDealerBlockFrame addDealerBlockFrame = new AddDealerBlockFrame();
        addDealerBlockFrame.setVisible(true);
    }//GEN-LAST:event_lblAddDealerBlockMouseClicked

    private void lblAddDealerBlockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddDealerBlockMouseEntered
        // TODO add your handling code here:
        btnAddDealerBlock.setBounds(btnAddDealerBlock.getX() - 5, btnAddDealerBlock.getY() - 5, btnAddDealerBlock.getWidth() + 10, btnAddDealerBlock.getHeight() + 10);
        lblAddDealerBlock.setBounds(lblAddDealerBlock.getX(), lblAddDealerBlock.getY(), lblAddDealerBlock.getWidth() + 10, lblAddDealerBlock.getHeight() + 10);
    }//GEN-LAST:event_lblAddDealerBlockMouseEntered

    private void lblAddDealerBlockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddDealerBlockMouseExited
        // TODO add your handling code here:
        btnAddDealerBlock.setBounds(btnAddDealerBlock.getX() + 5, btnAddDealerBlock.getY() + 5, btnAddDealerBlock.getWidth() - 10, btnAddDealerBlock.getHeight() - 10);
        lblAddDealerBlock.setBounds(lblAddDealerBlock.getX(), lblAddDealerBlock.getY(), lblAddDealerBlock.getWidth() - 10, lblAddDealerBlock.getHeight() - 10);
    }//GEN-LAST:event_lblAddDealerBlockMouseExited

    private void tblSanGiaoDichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanGiaoDichMouseClicked
        // TODO add your handling code here:
        this.row = tblSanGiaoDich.rowAtPoint(evt.getPoint());
        fillToTableSanPhamDuAN();
        fillToTableSanPhamDuAnBan_ChoThe();
        fillToTableNhanVien();
    }//GEN-LAST:event_tblSanGiaoDichMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.qlbatdongsan.utils.PanelRound btnAddDealerBlock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddDealerBlock;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblSPDuAn;
    private static javax.swing.JTable tblSanGiaoDich;
    private javax.swing.JTable tblSanPhamB_CT;
    // End of variables declaration//GEN-END:variables
}
