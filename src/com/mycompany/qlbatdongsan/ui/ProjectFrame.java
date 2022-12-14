/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.QuanLyDuAnDAO;
import com.mycompany.qlbatdongsan.DAO.TaiLieuDuAnDAO;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import com.mycompany.qlbatdongsan.Entity.TaiLieuDuAN;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HO VAN DAT
 */
public class ProjectFrame extends javax.swing.JPanel {

    DefaultTableModel model;
    static QuanLyDuAnDAO daoDA = new QuanLyDuAnDAO();
    TaiLieuDuAnDAO daoImage = new TaiLieuDuAnDAO();
    int row = 0;
    static List<QuanLyDuAn> list = daoDA.selectAll();

    public ProjectFrame() {
        initComponents();
        initTableProject();
        fillTableDA();
        if (!list.isEmpty()) {
            tblProject.setRowSelectionInterval(0, 0);
            lblTieuDeImage.setText("DỰ ÁN " + list.get(row).getTenDA().toUpperCase());
            SeeImageProject(list.get(row).getMaDA());
        }
    }

    public void initTableProject() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int j) {
                return false;
            }
        };
        Object[] column = {"Mã dự án", "Tên dự án", "Vị trí", "Tổng diện tích", "Tổng DT sàn", "Tổng DT căn hộ", "Tổng DT khu thương mại", "Mật độ", "Tổng vốn DT", "Chủ đầu tư"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblProject.setModel(model);
    }

    static void fillTableDA() {
        DefaultTableModel model = (DefaultTableModel) tblProject.getModel();
        model.setRowCount(0);
        try {
            for (QuanLyDuAn da : list) {
                Object[] row = {
                    da.getMaDA(),
                    da.getTenDA(),
                    da.getDiaChi(),
                    da.getTongDienTich(),
                    da.getTongDienTichSan(),
                    da.getTongDienTichCanHo(),
                    da.getTongdienTichKhuThuongMai(),
                    da.getMatDo(),
                    da.getTongVonDauTu(),
                    da.getChuDauTu()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn dữ liệu!");
        }
    }

    void SeeImageProject(String maDA) {
        List<TaiLieuDuAN> image = daoImage.selectByIdmaDA(maDA);
        if (image != null) {
            lblImageProject.setIcon(new ImageIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\imgAvartar\\" + image.get(row).getHinh()).getImage().getScaledInstance(471, 579, Image.SCALE_DEFAULT)));
        } else {
            lblImageProject.setText("Chưa có hình ảnh!");
            lblImageProject.setIcon(null);
        }
    }

    void edit() {
        QuanLyDuAn da = daoDA.selectById(tblProject.getValueAt(row, 0).toString());
        NotesFrame.palAllMain.display(new SeeProjectPanel(da));

    }

    public static void Search(String str) {
        if (str.length() > 0) {
            if (tblProject != null) {
                DefaultTableModel model = (DefaultTableModel) tblProject.getModel();
                TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
                tblProject.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(str));
            } else {
                return;
            }
        }
        if (str.length() == 0) {
            fillTableDA();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProject = new javax.swing.JTable();
        btnAddProject = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblAddProject = new javax.swing.JLabel();
        lblImageProject = new javax.swing.JLabel();
        lblTieuDeImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("DỰ ÁN");

        tblProject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProjectMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProjectMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblProject);

        btnAddProject.setBackground(new java.awt.Color(204, 204, 204));
        btnAddProject.setRoundBottonLeft(30);
        btnAddProject.setRoundBottonRight(30);
        btnAddProject.setRoundTopLeft(30);
        btnAddProject.setRoundTopRight(30);

        lblAddProject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-add-new-64.png"))); // NOI18N
        lblAddProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddProjectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddProjectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddProjectMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnAddProjectLayout = new javax.swing.GroupLayout(btnAddProject);
        btnAddProject.setLayout(btnAddProjectLayout);
        btnAddProjectLayout.setHorizontalGroup(
            btnAddProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddProjectLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblAddProject)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        btnAddProjectLayout.setVerticalGroup(
            btnAddProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE)
        );

        lblImageProject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageProject.setText("Chọn dự án để xem hình ảnh");
        lblImageProject.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTieuDeImage.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        lblTieuDeImage.setForeground(new java.awt.Color(51, 51, 51));
        lblTieuDeImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDeImage.setText("DỰ ÁN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImageProject, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lblTieuDeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImageProject, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTieuDeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblProjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProjectMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tblProjectMousePressed

    private void tblProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProjectMouseClicked

        if (evt.getClickCount() == 2) {
            this.row = tblProject.rowAtPoint(evt.getPoint());
            edit();
        }
        if (evt.getClickCount() == 1) {
            this.row = tblProject.rowAtPoint(evt.getPoint());
            lblTieuDeImage.setText("DỰ ÁN " + list.get(row).getTenDA().toUpperCase());
            SeeImageProject(list.get(row).getMaDA());

        }

    }//GEN-LAST:event_tblProjectMouseClicked

    private void btnAddProjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAddProjectMouseEntered

    private void btnAddProjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAddProjectMouseExited

    private void btnAddProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddProjectMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAddProjectMouseClicked

    private void lblAddProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddProjectMouseClicked
        // TODO add your handling code here:
        AddProjectFrame addProjectFrame = new AddProjectFrame();
        addProjectFrame.setVisible(true);
    }//GEN-LAST:event_lblAddProjectMouseClicked

    private void lblAddProjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddProjectMouseEntered
        // TODO add your handling code here:
        btnAddProject.setBackground(new Color(255, 255, 255));
        btnAddProject.setBounds(btnAddProject.getX() - 5, btnAddProject.getY() - 5, btnAddProject.getWidth() + 10, btnAddProject.getHeight() + 10);
        lblAddProject.setBounds(lblAddProject.getX(), lblAddProject.getY(), lblAddProject.getWidth() + 10, lblAddProject.getHeight() + 10);
    }//GEN-LAST:event_lblAddProjectMouseEntered

    private void lblAddProjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddProjectMouseExited
        // TODO add your handling code here:

        btnAddProject.setBackground(new Color(204, 204, 204));
        btnAddProject.setBounds(btnAddProject.getX() + 5, btnAddProject.getY() + 5, btnAddProject.getWidth() - 10, btnAddProject.getHeight() - 10);
        lblAddProject.setBounds(lblAddProject.getX(), lblAddProject.getY(), lblAddProject.getWidth() - 10, lblAddProject.getHeight() - 10);
    }//GEN-LAST:event_lblAddProjectMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.qlbatdongsan.utils.PanelRound btnAddProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddProject;
    private javax.swing.JLabel lblImageProject;
    private javax.swing.JLabel lblTieuDeImage;
    private static javax.swing.JTable tblProject;
    // End of variables declaration//GEN-END:variables
}
