/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.SanPhamDuAnDAO;
import com.mycompany.qlbatdongsan.Entity.SanPhamDuAn;
import com.mycompany.qlbatdongsan.utils.MsgBox;
import com.mycompany.qlbatdongsan.utils.XImage;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HO VAN DAT
 */
public class ImPortData extends javax.swing.JFrame {

    SanPhamDuAnDAO dao = new SanPhamDuAnDAO();

    /**
     * Creates new form ImPortData
     */
    public ImPortData() {
        initComponents();
        setTitle("HE THONG QUAN LY BẤT ĐỘNG SẢN DVPTP");
        setIconImage(XImage.getAppIcon());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void imPortData() {
        DefaultTableModel model = (DefaultTableModel) tblSPDuAn.getModel();
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\files";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select Excel File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);

                    XSSFCell MaSPDA = excelRow.getCell(0);
                    XSSFCell maDA = excelRow.getCell(1);
                    XSSFCell tenSanPham = excelRow.getCell(2);
                    XSSFCell dienTich = excelRow.getCell(3);
                    XSSFCell PhongBepKhach = excelRow.getCell(4);
                    XSSFCell PhongNgu = excelRow.getCell(5);
                    XSSFCell WC = excelRow.getCell(6);
                    XSSFCell Gia = excelRow.getCell(7);
                    XSSFCell LoaiSp = excelRow.getCell(8);
                    XSSFCell TrangThai = excelRow.getCell(9);
                    XSSFCell TienNghi = excelRow.getCell(10);
                    XSSFCell ChuSoHuu = excelRow.getCell(11);
                    XSSFCell TGSoHuu = excelRow.getCell(12);
                    XSSFCell SoTang = excelRow.getCell(13);
                    XSSFCell ThuocTang = excelRow.getCell(14);
                    XSSFCell DonViPhanPhoi = excelRow.getCell(15);
                    XSSFCell Toa = excelRow.getCell(16);

                    model.addRow(new Object[]{MaSPDA, maDA, tenSanPham, dienTich, PhongBepKhach, PhongNgu, WC, Gia, LoaiSp, TrangThai, TienNghi, ChuSoHuu, TGSoHuu, SoTang, ThuocTang, DonViPhanPhoi, Toa});
                }
                JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
    }

    public void add() {
        try {

            for (int i = 0; i < tblSPDuAn.getRowCount(); i++) {
                SanPhamDuAn sp = new SanPhamDuAn();
                sp.setMaSPDA(String.valueOf(tblSPDuAn.getValueAt(i, 0)));
                sp.setMaDA(String.valueOf(tblSPDuAn.getValueAt(i, 1)));
                sp.setTenSP(String.valueOf(tblSPDuAn.getValueAt(i, 2)));
                sp.setDienTich((double) Double.parseDouble(String.valueOf(tblSPDuAn.getValueAt(i, 3))));
                sp.setPhongBepKhach((int) Float.parseFloat(String.valueOf(tblSPDuAn.getValueAt(i, 4))));
                sp.setPhongNgu((int) Float.parseFloat(String.valueOf(tblSPDuAn.getValueAt(i, 5))));
                sp.setWC((int) Float.parseFloat(String.valueOf(tblSPDuAn.getValueAt(i, 6))));
                sp.setGia((int) Float.parseFloat(String.valueOf(tblSPDuAn.getValueAt(i, 7))));
                sp.setLoaiSP(String.valueOf(tblSPDuAn.getValueAt(i, 8)));
                sp.setTrangThai(String.valueOf(tblSPDuAn.getValueAt(i, 9)));
                sp.setTienNghi(String.valueOf(tblSPDuAn.getValueAt(i, 10)));
                sp.setChuSoHuu(String.valueOf(tblSPDuAn.getValueAt(i, 11)));
                sp.setTgSoHuu(String.valueOf(tblSPDuAn.getValueAt(i, 12)));
                if (tblSPDuAn.getValueAt(i, 13)!=null) {
                    sp.setSoTang((int) Float.parseFloat(String.valueOf(tblSPDuAn.getValueAt(i, 13))));
                }
                
                if (tblSPDuAn.getValueAt(i, 14)!=null) {
                    sp.setThuocTang((int) Float.parseFloat(String.valueOf(tblSPDuAn.getValueAt(i, 14))));
                }
                sp.setDonViPhanPhoi((int) Float.parseFloat(String.valueOf(tblSPDuAn.getValueAt(i, 15))));
                sp.setToa(String.valueOf(tblSPDuAn.getValueAt(i, 16)));

                dao.insert(sp);
            }
            MsgBox.alert(this, "Import san phẩm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Đã xãy ra lỗi khi thêm sản phẩm!");
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
        tblSPDuAn = new javax.swing.JTable();
        btnThem = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblThem = new javax.swing.JLabel();
        btnHoanTat = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblHoanTat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSPDuAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Mã dự án", "Tên sản phẩm", "Diện tích", "Sp Phòng Bếp và Khách", "SL Phòng ngủ", "SL phòng WC", "Giá", "Loại sản phẩm", "Trạng thái", "Tiện nghi", "Chủ sở hữu", "TG sở hữu", "Số tầng", "Thuộc tầng", "ĐV phân phối", "Tòa"
            }
        ));
        jScrollPane1.setViewportView(tblSPDuAn);

        btnThem.setBackground(new java.awt.Color(153, 153, 153));
        btnThem.setRoundBottonLeft(40);
        btnThem.setRoundBottonRight(40);
        btnThem.setRoundTopLeft(40);
        btnThem.setRoundTopRight(40);

        lblThem.setBackground(new java.awt.Color(51, 51, 51));
        lblThem.setForeground(new java.awt.Color(0, 0, 0));
        lblThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-favorite-database-24.png"))); // NOI18N
        lblThem.setText("Import");
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

        btnHoanTat.setBackground(new java.awt.Color(153, 153, 153));
        btnHoanTat.setRoundBottonLeft(40);
        btnHoanTat.setRoundBottonRight(40);
        btnHoanTat.setRoundTopLeft(40);
        btnHoanTat.setRoundTopRight(40);

        lblHoanTat.setBackground(new java.awt.Color(51, 51, 51));
        lblHoanTat.setForeground(new java.awt.Color(0, 0, 0));
        lblHoanTat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoanTat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-plus-math-30.png"))); // NOI18N
        lblHoanTat.setText("Thêm");
        lblHoanTat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblHoanTat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoanTatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHoanTatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHoanTatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnHoanTatLayout = new javax.swing.GroupLayout(btnHoanTat);
        btnHoanTat.setLayout(btnHoanTatLayout);
        btnHoanTatLayout.setHorizontalGroup(
            btnHoanTatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHoanTat, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnHoanTatLayout.setVerticalGroup(
            btnHoanTatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHoanTatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoanTat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1303, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHoanTat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHoanTat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked
        // TODO add your handling code here:
        imPortData();
    }//GEN-LAST:event_lblThemMouseClicked

    private void lblThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseEntered
        // TODO add your handling code here:
        btnThem.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_lblThemMouseEntered

    private void lblThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseExited
        // TODO add your handling code here:
        btnThem.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblThemMouseExited

    private void lblHoanTatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoanTatMouseClicked
        // TODO add your handling code here:
        add();
        this.dispose();
        ManagerProjectPanel.initForm();
    }//GEN-LAST:event_lblHoanTatMouseClicked

    private void lblHoanTatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoanTatMouseEntered
        // TODO add your handling code here:
        btnHoanTat.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_lblHoanTatMouseEntered

    private void lblHoanTatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoanTatMouseExited
        // TODO add your handling code here:
        btnHoanTat.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblHoanTatMouseExited

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
            java.util.logging.Logger.getLogger(ImPortData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImPortData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImPortData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImPortData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImPortData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.qlbatdongsan.utils.PanelRound btnHoanTat;
    private com.mycompany.qlbatdongsan.utils.PanelRound btnThem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoanTat;
    private javax.swing.JLabel lblThem;
    private javax.swing.JTable tblSPDuAn;
    // End of variables declaration//GEN-END:variables
}
