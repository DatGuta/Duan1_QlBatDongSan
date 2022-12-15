/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.KhachHangDAO;
import com.mycompany.qlbatdongsan.DAO.NguoiDaiDienDAO;
import com.mycompany.qlbatdongsan.DAO.NguoiGioiThieuDAO;
import com.mycompany.qlbatdongsan.DAO.TaiLieuDuAnDAO;
import com.mycompany.qlbatdongsan.utils.MsgBox;
import com.mycompany.qlbatdongsan.Entity.KhachHang;
import com.mycompany.qlbatdongsan.Entity.NguoiDaiDien;
import com.mycompany.qlbatdongsan.Entity.NguoiGioiThieu;
import com.mycompany.qlbatdongsan.Entity.TaiLieuDuAN;
import com.mycompany.qlbatdongsan.utils.XDate;
import com.mycompany.qlbatdongsan.utils.XImage;
import java.awt.Image;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author HO VAN DAT
 */
public class SeeClientFrame extends javax.swing.JFrame {
    JFileChooser jFileChooser=  new JFileChooser();
    TaiLieuDuAnDAO daoImage = new TaiLieuDuAnDAO();
    KhachHang kh;
    KhachHangDAO  dao =new KhachHangDAO();
    
    NguoiDaiDienDAO daoNDD = new NguoiDaiDienDAO();
    NguoiGioiThieuDAO daoNGT = new NguoiGioiThieuDAO();

    /**
     * Creates new form SeeClientsFrame
     */
    public SeeClientFrame(KhachHang entity) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.kh = entity;
        btnChonAnh.setVisible(false);
        btnXong.setVisible(false);
        btnDeleteClient.setVisible(false);
        btnChonNDD.setVisible(false);
        btnChonNGT.setVisible(false);
        lblBackground.setIcon(new ImageIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\imgAvartar\\y-tuong-kien-truc-an-tuong-2021 (6).png").getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_DEFAULT)));
        setForm();
    }

    public void setForm() {
        txtChucVu.setText(kh.getLoai());
        txtDanhXung.setText(kh.getDanhXung());
        txtDiaChiLienLac.setText(kh.getDiaChiLienLac());
        txtDiaChiThuongTru.setText(kh.getDiaChiThuongTru());
        txtEmail.setText(kh.getEmail());
        txtGioiTinh.setText(kh.getGioiTinh() ? "Nữ" : "Nam");
        txtHoVaTenDem.setText(kh.getHoTenDem());
        txtNgaySinh.setText(XDate.toString(kh.getNgaySinh(), "yyyy-MM-dd"));
        txtSDT.setText(String.valueOf(kh.getSdt()));
        txtSoCCCD.setText(kh.getCCCD());
        txtTenKH.setText(kh.getTen());
        TaiLieuDuAN image = daoImage.selectByIdmaKH(kh.getMaKH());
        if (image != null) {
            lblHinhAnh.setIcon(new ImageIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\imgAvartar\\" + image.getHinh() + ".png").getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_DEFAULT)));

        }
        NguoiDaiDien nguoiDaiDien = daoNDD.selectBymaKH(kh.getMaKH()).get(0);
        txtNguoiDaiDien.setText(nguoiDaiDien.getHoTen());
        NguoiGioiThieu nguoiGioiThieu =daoNGT.selectBymaKH(kh.getMaKH()).get(0);
        txtNguoiGioiThieu.setText(nguoiGioiThieu.getHoTen());
        
    }
    
     public void addImage(File file) {
        TaiLieuDuAN image = new TaiLieuDuAN();
        image.setTenTaiLieu("Hình dự án: " + kh.getTen());
        image.setDienGiai("Hình dự án");
        image.setHinh(file.getName());
        image.setMaDA(null);
        image.setMaKH(kh.getMaKH());
        image.setMaSPDA(null);
        image.setNhanVien(null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        image.setNgayCapNhat(XDate.toDate(dtf.format(now), "yyyy-MM-dd"));
        try {
            daoImage.insert(image);
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi lưu hình ảnh");
            e.printStackTrace();
        }
    }

    public void chonAnh() {
        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lblHinhAnh.setIcon(icon);
            lblHinhAnh.setToolTipText(file.getName());
            addImage(file);
        }
    }
       public void updateKhachHang(){
           try {
               dao.update(kh);
               MsgBox.alert(this, "Cập nhật thành công !");
           } catch (Exception e) {
               MsgBox.alert(this, "Cập nhật thất bại");
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

        btnXong = new javax.swing.JButton();
        btnExitProject = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChiLienLac = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoCCCD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JTextField();
        txtDiaChiThuongTru = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDanhXung = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHoVaTenDem = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblHinhAnh = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnEditClient = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNguoiDaiDien = new javax.swing.JTextField();
        txtNguoiGioiThieu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnDeleteClient = new javax.swing.JButton();
        btnChonNDD = new javax.swing.JButton();
        btnChonNGT = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnXong.setText("Xong");
        btnXong.setInheritsPopupMenu(true);
        btnXong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXongActionPerformed(evt);
            }
        });
        getContentPane().add(btnXong, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 923, -1, 33));

        btnExitProject.setText("Thoát xem");
        btnExitProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitProjectActionPerformed(evt);
            }
        });
        getContentPane().add(btnExitProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 923, -1, 33));

        jLabel6.setText("Giới tính");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 276, -1, -1));

        txtDiaChiLienLac.setEnabled(false);
        getContentPane().add(txtDiaChiLienLac, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 539, 468, -1));

        jLabel7.setText("Số CCCD");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 350, -1, -1));

        txtGioiTinh.setEnabled(false);
        getContentPane().add(txtGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 310, 78, -1));

        jLabel8.setText("Địa chỉ  thường trú");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 431, -1, -1));

        txtSoCCCD.setEnabled(false);
        getContentPane().add(txtSoCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 386, 302, -1));

        jLabel9.setText("Địa chỉ  liên lạc");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 505, -1, -1));

        txtChucVu.setEnabled(false);
        getContentPane().add(txtChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 763, 137, -1));

        txtDiaChiThuongTru.setEnabled(false);
        getContentPane().add(txtDiaChiThuongTru, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 465, 468, -1));

        jLabel10.setText("Số điện thoại");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 579, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 29, -1, -1));

        jLabel2.setText("Tên khách hàng");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 110, -1, -1));

        txtTenKH.setEnabled(false);
        getContentPane().add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 144, 148, -1));

        jLabel3.setText("Ngày sinh");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 192, -1, -1));

        jLabel4.setText("Danh xưng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 110, -1, -1));

        txtDanhXung.setEnabled(false);
        getContentPane().add(txtDanhXung, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 144, 148, -1));

        jLabel5.setText("Họ và tên đệm");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 110, -1, -1));

        txtHoVaTenDem.setEnabled(false);
        getContentPane().add(txtHoVaTenDem, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 144, 136, -1));

        txtNgaySinh.setEnabled(false);
        getContentPane().add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 236, 136, -1));

        txtSDT.setEnabled(false);
        getContentPane().add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 613, 136, -1));

        jLabel11.setText("Email");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 653, -1, -1));

        txtEmail.setEnabled(false);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 687, 284, -1));

        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setText("Hình ảnh");
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(lblHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 144, 190, 236));

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });
        getContentPane().add(btnChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 402, -1, -1));

        jLabel12.setText("Chức vụ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 735, -1, -1));

        btnEditClient.setText("Chỉnh sửa");
        btnEditClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClientActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 923, -1, 33));

        jLabel13.setText("Người đại diện");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 806, -1, -1));

        jLabel14.setText("Người giới thiệu");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 806, -1, -1));

        txtNguoiDaiDien.setEnabled(false);
        getContentPane().add(txtNguoiDaiDien, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 840, 220, -1));

        txtNguoiGioiThieu.setEnabled(false);
        getContentPane().add(txtNguoiGioiThieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 840, 220, -1));

        jButton1.setText("Đ/C mức hoa hồng");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 923, -1, 33));

        btnDeleteClient.setText("Xóa");
        btnDeleteClient.setName(""); // NOI18N
        btnDeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClientActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 923, 80, 33));

        btnChonNDD.setText("Chọn");
        getContentPane().add(btnChonNDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 880, -1, -1));

        btnChonNGT.setText("Chọn");
        getContentPane().add(btnChonNGT, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 880, -1, -1));
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXongActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnXongActionPerformed

    private void btnExitProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitProjectActionPerformed
        // TODO add your handling code here:
        if (MsgBox.confirm(this, "Bạn có chắc chắn muốn thoát")) {
            this.dispose();
        }

    }//GEN-LAST:event_btnExitProjectActionPerformed

    private void btnEditClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClientActionPerformed
        // TODO add your handling code here:
        btnChonAnh.setVisible(true);
        btnDeleteClient.setVisible(true);
        btnXong.setVisible(true);
        txtChucVu.setEnabled(true);
        txtDanhXung.setEnabled(true);
        txtDiaChiLienLac.setEnabled(true);
        txtDiaChiThuongTru.setEnabled(true);
        txtEmail.setEnabled(true);
        txtGioiTinh.setEnabled(true);
        txtHoVaTenDem.setEnabled(true);
        txtNgaySinh.setEnabled(true);
        txtSDT.setEnabled(true);
        txtSoCCCD.setEnabled(true);
        txtTenKH.setEnabled(true);
        btnChonNDD.setVisible(true);
        btnChonNGT.setVisible(true);
    }//GEN-LAST:event_btnEditClientActionPerformed

    private void btnDeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClientActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnDeleteClientActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        chonAnh();
    }//GEN-LAST:event_btnChonAnhActionPerformed

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
            java.util.logging.Logger.getLogger(SeeClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeeClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeeClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeeClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnChonNDD;
    private javax.swing.JButton btnChonNGT;
    private javax.swing.JButton btnDeleteClient;
    private javax.swing.JButton btnEditClient;
    private javax.swing.JButton btnExitProject;
    private javax.swing.JButton btnXong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDanhXung;
    private javax.swing.JTextField txtDiaChiLienLac;
    private javax.swing.JTextField txtDiaChiThuongTru;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHoVaTenDem;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNguoiDaiDien;
    private javax.swing.JTextField txtNguoiGioiThieu;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoCCCD;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
