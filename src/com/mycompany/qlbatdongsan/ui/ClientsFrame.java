/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.KhachHangDAO;
import com.mycompany.qlbatdongsan.Entity.NhanVien;
import com.mycompany.qlbatdongsan.Entity.KhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HO VAN DAT
 */
public class ClientsFrame extends javax.swing.JPanel {

    private int row = -1;
    DefaultTableModel model;
    DefaultTableModel model1;
    KhachHangDAO daoKH = new KhachHangDAO();

    /**
     * Creates new form ClientsFrame
     */
    public ClientsFrame() {
        initComponents();
        initKhachHangCN();
        initKhachHangDN();
        initLSGiaoDich();
        initLSLamViec();
        initLSThucHien();
        initNguoiDaiDien();
        initNguoiGioiThieu();
        fillToTableKhachHang();
    }

    private void initKhachHangCN() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        };
        Object[] column = {"STT", "Xưng", "Họ và tên đệm", "Tên", "Ngày sinh", "Di động", "Số CCCD", "Địa chỉ liên lạc", "Địa chỉ thường trú", "Email", "Mã thuế TNCN"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblKhachHangCN.setModel(model);
    }

    private void initKhachHangDN() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        };
        Object[] column = {"STT", "Xưng", "Họ và tên đệm", "Tên", "Ngày sinh", "Di động", "Số CCCD", "Địa chỉ liên lạc", "Địa chỉ thường trú", "Email", "Mã thuế TNCN", "Chức vụ"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblKhachHangDN.setModel(model);
    }

    private void initLSThucHien() {
        model = new DefaultTableModel();
        Object[] column = {"STT", "Ngày cập nhật", "Diễn giải", "Nhân viên Kiến Á", "Nhân viên Sàn", "Sàn giao dịch"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblLSThucHien.setModel(model);
    }

    private void initLSLamViec() {
        model = new DefaultTableModel();
        Object[] column = {"STT", "Tiêu đề", "Người thực hiện", "Địa điểm", "Diễn giải", "Ngày bắt đầu", "Ngày kết thúc"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblLSLamViec.setModel(model);
    }

    private void initLSGiaoDich() {
        model = new DefaultTableModel();
        Object[] column = {"Ngày GD", "Số GD", "Loại GD", "Mã BĐS", "Diện tích", "Thành tiền", "Diễn giải", "Nhân viên", "Sàn giao dịch"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblLSGiaoDich.setModel(model);
    }

    private void initNguoiDaiDien() {
        model = new DefaultTableModel();
        Object[] column = {"Họ và tên", "Điện thoại cố định", "Điện thoại di động", "Email", "Địa chỉ liên lạc", " Địa chỉ thường trú"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblNguoiDaiDien.setModel(model);
    }

    private void initNguoiGioiThieu() {
        model = new DefaultTableModel();
        Object[] column = {"Họ và tên", "Điện thoại cố định", "Điện thoại di động", "Email", "Địa chỉ liên lạc", " Địa chỉ thường trú", "Hoa hồng"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblNguoiGioiThieu.setModel(model);
    }

    public void fillToTableKhachHang() {
        model = (DefaultTableModel) tblKhachHangDN.getModel();
        model1 = (DefaultTableModel) tblKhachHangCN.getModel();

        model.setRowCount(0);
        try {
            List<KhachHang> list = daoKH.selectAll();
            for (KhachHang kh : list) {
                if (kh.getLoai() != null) {
                    Object[] row = {
                        kh.getSTT(),
                        kh.getDanhXung(),
                        kh.getHoTenDem(),
                        kh.getTen(),
                        kh.getNgaySinh(),
                        kh.getSdt(),
                        kh.getCCCD(),
                        kh.getDiaChiLienLac(),
                        kh.getDiaChiThuongTru(),
                        kh.getEmail(),
                        kh.getMaThue(),
                        kh.getLoai()
                    };
                    model.addRow(row);
                } else {
                    Object[] row = {
                        kh.getSTT(),
                        kh.getDanhXung(),
                        kh.getHoTenDem(),
                        kh.getTen(),
                        kh.getNgaySinh(),
                        kh.getSdt(),
                        kh.getCCCD(),
                        kh.getDiaChiLienLac(),
                        kh.getDiaChiThuongTru(),
                        kh.getEmail(),
                        kh.getMaThue(),};
                    model1.addRow(row);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void edit() {
        KhachHang kh = daoKH.selectById(tblKhachHangDN.getValueAt(row, 0).toString());
        SeeClientsFrame seeClientsFrame = new SeeClientsFrame(kh);

    }

    public static void Search(String str) {
        if (str.length() > 0) {
            if (tblKhachHangDN != null) {
                DefaultTableModel model = (DefaultTableModel) tblKhachHangCN.getModel();
                TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
                tblKhachHangCN.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(str));
            } else {
                return;
            }
            //Table DN và CN
            if (tblKhachHangCN != null) {
                DefaultTableModel model1 = (DefaultTableModel) tblKhachHangDN.getModel();
                TableRowSorter<DefaultTableModel> trs1 = new TableRowSorter<>(model1);
                tblKhachHangDN.setRowSorter(trs1);
                trs1.setRowFilter(RowFilter.regexFilter(str));
            } else {
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

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLSThucHien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLSLamViec = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLSGiaoDich = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNguoiDaiDien = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblNguoiGioiThieu = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhachHangCN = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblKhachHangDN = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblAddClients = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblLSThucHien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblLSThucHien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1333, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("LS thực hiện", jPanel1);

        tblLSLamViec.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblLSLamViec);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("LS làm việc", jPanel2);

        tblLSGiaoDich.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblLSGiaoDich);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("LS giao dịch", jPanel3);

        tblNguoiDaiDien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblNguoiDaiDien);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Người đại diện", jPanel4);

        tblNguoiGioiThieu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tblNguoiGioiThieu);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Người giới thiệu", jPanel5);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Nhân viên quản lý", jPanel6);

        tblKhachHangCN.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHangCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhachHangCNMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tblKhachHangCN);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cá nhân ", jPanel7);

        tblKhachHangDN.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHangDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhachHangDNMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tblKhachHangDN);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh nghiệp", jPanel8);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("KHÁCH HÀNG");

        lblAddClients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-add-new-64.png"))); // NOI18N
        lblAddClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddClientsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddClientsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddClientsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(559, 559, 559)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabs)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAddClients, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)
                        .addGap(146, 146, 146)
                        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAddClients)
                        .addGap(184, 184, 184))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangDNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangDNMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblKhachHangDN.rowAtPoint(evt.getPoint());
            edit();
        }
    }//GEN-LAST:event_tblKhachHangDNMousePressed

    private void tblKhachHangCNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangCNMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblKhachHangDN.rowAtPoint(evt.getPoint());
            edit();
        }
    }//GEN-LAST:event_tblKhachHangCNMousePressed

    private void lblAddClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddClientsMouseClicked
        // TODO add your handling code here:
        AddProjectFrame addProjectFrame = new AddProjectFrame();
        addProjectFrame.setVisible(true);
    }//GEN-LAST:event_lblAddClientsMouseClicked

    private void lblAddClientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddClientsMouseEntered
        // TODO add your handling code here:
//        btnAddClients.setBounds(btnAddClients.getX() - 5, btnAddClients.getY() - 5, btnAddClients.getWidth() + 10, btnAddClients.getHeight() + 10);
//        lblAddClients.setBounds(lblAddClients.getX(), lblAddClients.getY(), lblAddClients.getWidth() + 10, lblAddClients.getHeight() + 10);
    }//GEN-LAST:event_lblAddClientsMouseEntered

    private void lblAddClientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddClientsMouseExited
        // TODO add your handling code here:
//        btnAddClients.setBounds(btnAddClients.getX() + 5, btnAddClients.getY() + 5, btnAddClients.getWidth() - 10, btnAddClients.getHeight() - 10);
//        lblAddClients.setBounds(lblAddClients.getX(), lblAddClients.getY(), lblAddClients.getWidth() - 10, lblAddClients.getHeight() - 10);
    }//GEN-LAST:event_lblAddClientsMouseExited

    private void btnAddClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddProjectMouseClicked

    private void btnAddClientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAddProjectMouseEntered

    private void btnAddClientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnAddProjectMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable7;
    private javax.swing.JLabel lblAddClients;
    private javax.swing.JTabbedPane tabs;
    private static javax.swing.JTable tblKhachHangCN;
    private static javax.swing.JTable tblKhachHangDN;
    private javax.swing.JTable tblLSGiaoDich;
    private javax.swing.JTable tblLSLamViec;
    private javax.swing.JTable tblLSThucHien;
    private javax.swing.JTable tblNguoiDaiDien;
    private javax.swing.JTable tblNguoiGioiThieu;
    // End of variables declaration//GEN-END:variables
}
