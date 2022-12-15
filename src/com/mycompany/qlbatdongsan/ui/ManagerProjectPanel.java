/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.SanPhamDuAnDAO;
import com.mycompany.qlbatdongsan.DAO.TaiLieuDuAnDAO;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import com.mycompany.qlbatdongsan.Entity.SanPhamDuAn;
import com.mycompany.qlbatdongsan.Entity.TaiLieuDuAN;
import static com.mycompany.qlbatdongsan.ui.ProjectFrame.list;
import com.mycompany.qlbatdongsan.utils.MsgBox;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HO VAN DAT
 */
public class ManagerProjectPanel extends javax.swing.JPanel {

    static QuanLyDuAn da;
    private int row = -1;
    static SanPhamDuAnDAO dao = new SanPhamDuAnDAO();
    static TaiLieuDuAnDAO daoImage = new TaiLieuDuAnDAO();
    static List<SanPhamDuAn> list;
    static DefaultComboBoxModel modelCbo;
    static DefaultTableModel model;

    /**
     * Creates new form ManagerProjectPanel
     */
    public ManagerProjectPanel(QuanLyDuAn entity) {
        initComponents();
        this.da = entity;
        initForm();
    }
    static void initForm(){
        initComBoBoxToa();
        initTableSPProject();
        cboToa.setSelectedIndex(0);
        fillToTableAndLabelImage(String.valueOf(cboToa.getSelectedItem()));
        initComBoBoxTang();
        cboTang.setSelectedIndex(0);
        fillToTableWithTang();
    }
    static void initComBoBoxTang() {
        int index = 0;
        modelCbo = new DefaultComboBoxModel();
        List<Integer> Tang = new ArrayList<>();
        for (SanPhamDuAn sp : list) {
            for (Integer str : Tang) {
                if (sp.getThuocTang() == str) {
                    continue;
                }
                index++;
            }
            if (index == Tang.size()) {
                Tang.add(sp.getThuocTang());
                index = 0;
            }
        }
        for (Integer str : Tang) {
            modelCbo.addElement(str);
        }
        cboTang.setModel(modelCbo);
    }

    static void initComBoBoxToa() {
        int index = 0;
        List<String> Toa = new ArrayList<>();
        modelCbo = new DefaultComboBoxModel();
        list = dao.selectByMaDA(da.getMaDA());
        for (SanPhamDuAn sp : list) {
            for (String str : Toa) {
                if (sp.getToa().equalsIgnoreCase(str)) {
                    continue;
                }
                index++;
            }
            if (index == Toa.size()) {
                Toa.add(sp.getToa());
                index = 0;
            }
        }
        for (String str : Toa) {
            modelCbo.addElement(str);
        }
        cboToa.setModel(modelCbo);
    }

    static void initTableSPProject() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        };
        Object[] column = {"Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Trạng thái", "Đơn vị phân phối"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblSPProject.setModel(model);
    }

    static void fillToTableAndLabelImage(String Toa) {
        TaiLieuDuAN image = daoImage.selectByIdmaToa(da.getMaDA(), "Hình Tòa " + Toa);
        if (image != null) {
            lblImageToa.setIcon(new ImageIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\imgAvartar\\" + image.getHinh()).getImage().getScaledInstance(511, 541, Image.SCALE_DEFAULT)));
        } else {
            lblImageToa.setText("Chưa có hình tòa nhà này!");
        }
        list = dao.selectByMaToa(Toa, da.getMaDA());
        lblTongSanPham.setText("Tổng sản phẩm: " + list.size() + " sản phẩm ");
        int indexKh = 0;
        for (SanPhamDuAn sp : list) {
            if (sp.getChuSoHuu() != null) {
                indexKh++;
            }
        }
        lblSlKhachHang.setText("Sl Khách hàng: " + indexKh + " người");
    }

    static void fillToTableWithTang() {
        model = (DefaultTableModel) tblSPProject.getModel();
        model.setRowCount(0);
        int indexKh = 0;
        int indexSP = 0;
        try {
            for (SanPhamDuAn sp : list) {
                if (sp.getThuocTang() == Integer.parseInt(String.valueOf(cboTang.getSelectedItem()))) {
                    Object[] row = {
                        sp.getMaSPDA(),
                        sp.getTenSP(),
                        sp.getLoaiSP(),
                        sp.getTrangThai(),
                        sp.getDonViPhanPhoi()
                    };
                    model.addRow(row);
                    indexSP++;
                    if (sp.getChuSoHuu() != null) {
                        indexKh++;
                    }
                }
            }
            lblTongSanPhamTang.setText("Tổng sản phẩm: " + indexSP + " sản phẩm ");
            lblSlKhachHangTang.setText("Sl Khách hàng của tầng: " + indexKh + " người");
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn dữ liệu!");
        }
    }
    public void edit(){
        try {
            SanPhamDuAn sp = dao.selectById(String.valueOf(tblSPProject.getValueAt(row, 0)));
            NotesFrame.palAllMain.display(new SeeSPProjectPal(sp));
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy sản phẩm!");
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSPProject = new javax.swing.JTable();
        lblImageToa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboToa = new javax.swing.JComboBox<>();
        lblTongSanPhamTang = new javax.swing.JLabel();
        lblSlKhachHang = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboTang = new javax.swing.JComboBox<>();
        lblSlKhachHangTang = new javax.swing.JLabel();
        lblTongSanPham = new javax.swing.JLabel();
        btnThem = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblThem = new javax.swing.JLabel();
        btnQuayLai = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblQuayLai = new javax.swing.JLabel();
        btnImport = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblImport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("SẢN PHẨM DỰ ÁN");

        tblSPProject.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSPProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPProjectMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSPProjectMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblSPProject);

        lblImageToa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tòa:");

        cboToa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboToa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboToaActionPerformed(evt);
            }
        });

        lblTongSanPhamTang.setForeground(new java.awt.Color(0, 0, 0));
        lblTongSanPhamTang.setText("Tổng sản phẩm: ");

        lblSlKhachHang.setForeground(new java.awt.Color(0, 0, 0));
        lblSlKhachHang.setText("SL Khách hàng:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tầng:");

        cboTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTangActionPerformed(evt);
            }
        });

        lblSlKhachHangTang.setForeground(new java.awt.Color(0, 0, 0));
        lblSlKhachHangTang.setText("SL Khách hàng:");

        lblTongSanPham.setForeground(new java.awt.Color(0, 0, 0));
        lblTongSanPham.setText("Tổng sản phẩm: ");

        btnThem.setBackground(new java.awt.Color(153, 153, 153));
        btnThem.setRoundBottonLeft(40);
        btnThem.setRoundBottonRight(40);
        btnThem.setRoundTopLeft(40);
        btnThem.setRoundTopRight(40);

        lblThem.setBackground(new java.awt.Color(51, 51, 51));
        lblThem.setForeground(new java.awt.Color(0, 0, 0));
        lblThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-plus-math-30.png"))); // NOI18N
        lblThem.setText("Thêm");
        lblThem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThemMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnThemLayout = new javax.swing.GroupLayout(btnThem);
        btnThem.setLayout(btnThemLayout);
        btnThemLayout.setHorizontalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnThemLayout.setVerticalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnQuayLai.setBackground(new java.awt.Color(153, 153, 153));
        btnQuayLai.setRoundBottonLeft(40);
        btnQuayLai.setRoundBottonRight(40);
        btnQuayLai.setRoundTopLeft(40);
        btnQuayLai.setRoundTopRight(40);

        lblQuayLai.setBackground(new java.awt.Color(51, 51, 51));
        lblQuayLai.setForeground(new java.awt.Color(0, 0, 0));
        lblQuayLai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-left-arrow-30.png"))); // NOI18N
        lblQuayLai.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblQuayLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuayLaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuayLaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuayLaiMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnQuayLaiLayout = new javax.swing.GroupLayout(btnQuayLai);
        btnQuayLai.setLayout(btnQuayLaiLayout);
        btnQuayLaiLayout.setHorizontalGroup(
            btnQuayLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnQuayLaiLayout.setVerticalGroup(
            btnQuayLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQuayLaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnImport.setBackground(new java.awt.Color(153, 153, 153));
        btnImport.setRoundBottonLeft(40);
        btnImport.setRoundBottonRight(40);
        btnImport.setRoundTopLeft(40);
        btnImport.setRoundTopRight(40);

        lblImport.setBackground(new java.awt.Color(51, 51, 51));
        lblImport.setForeground(new java.awt.Color(0, 0, 0));
        lblImport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-open-box-30.png"))); // NOI18N
        lblImport.setText("Import");
        lblImport.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblImportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblImportMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnImportLayout = new javax.swing.GroupLayout(btnImport);
        btnImport.setLayout(btnImportLayout);
        btnImportLayout.setHorizontalGroup(
            btnImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImport, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnImportLayout.setVerticalGroup(
            btnImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnImportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImageToa, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboToa, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(lblTongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cboTang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(64, 64, 64)
                                            .addComponent(lblSlKhachHangTang, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblTongSanPhamTang, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSlKhachHangTang)
                                    .addComponent(lblTongSanPhamTang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImageToa, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboToa)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 10, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSPProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPProjectMouseClicked
         // TODO add your handling code here:

    }//GEN-LAST:event_tblSPProjectMouseClicked

    private void tblSPProjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPProjectMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblSPProject.rowAtPoint(evt.getPoint());
            edit();
        }
    }//GEN-LAST:event_tblSPProjectMousePressed

    private void cboToaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboToaActionPerformed
        // TODO add your handling code here:
        try {
            fillToTableAndLabelImage(String.valueOf(cboToa.getSelectedItem()));
            initComBoBoxTang();
            fillToTableWithTang();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cboToaActionPerformed

    private void cboTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTangActionPerformed
        // TODO add your handling code here:
        fillToTableWithTang();
    }//GEN-LAST:event_cboTangActionPerformed

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked
        // TODO add your handling code here:
       AddSPProjectFrame addSPProjectFrame = new AddSPProjectFrame(da);
       addSPProjectFrame.setVisible(true);
    }//GEN-LAST:event_lblThemMouseClicked

    private void lblThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseEntered
        // TODO add your handling code here:
        btnThem.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_lblThemMouseEntered

    private void lblThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseExited
        // TODO add your handling code here:
        btnThem.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_lblThemMouseExited

    private void lblQuayLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayLaiMouseClicked
        // TODO add your handling code here:
        NotesFrame.palAllMain.display(new SeeProjectPanel(da));
    }//GEN-LAST:event_lblQuayLaiMouseClicked

    private void lblQuayLaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayLaiMouseEntered
        // TODO add your handling code here:
         btnQuayLai.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_lblQuayLaiMouseEntered

    private void lblQuayLaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayLaiMouseExited
        // TODO add your handling code here:
         btnQuayLai.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_lblQuayLaiMouseExited

    private void lblImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImportMouseClicked
        // TODO add your handling code here:
        ImPortData imPortData = new ImPortData();
        imPortData.setVisible(true);
    }//GEN-LAST:event_lblImportMouseClicked

    private void lblImportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImportMouseEntered
        // TODO add your handling code here:
         btnImport.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_lblImportMouseEntered

    private void lblImportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImportMouseExited
        // TODO add your handling code here:
          btnImport.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_lblImportMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.qlbatdongsan.utils.PanelRound btnImport;
    private com.mycompany.qlbatdongsan.utils.PanelRound btnQuayLai;
    private com.mycompany.qlbatdongsan.utils.PanelRound btnThem;
    public static javax.swing.JComboBox<String> cboTang;
    public static javax.swing.JComboBox<String> cboToa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lblImageToa;
    private javax.swing.JLabel lblImport;
    private javax.swing.JLabel lblQuayLai;
    private static javax.swing.JLabel lblSlKhachHang;
    private static javax.swing.JLabel lblSlKhachHangTang;
    private javax.swing.JLabel lblThem;
    private static javax.swing.JLabel lblTongSanPham;
    private static javax.swing.JLabel lblTongSanPhamTang;
    private static javax.swing.JTable tblSPProject;
    // End of variables declaration//GEN-END:variables
}
