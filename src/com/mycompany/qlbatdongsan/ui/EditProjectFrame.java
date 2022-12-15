/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.QuanLyDuAnDAO;
import com.mycompany.qlbatdongsan.DAO.TaiLieuDuAnDAO;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import com.mycompany.qlbatdongsan.Entity.TaiLieuDuAN;
import com.mycompany.qlbatdongsan.utils.MsgBox;
import com.mycompany.qlbatdongsan.utils.XDate;
import com.mycompany.qlbatdongsan.utils.XImage;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author HO VAN DAT
 */
public class EditProjectFrame extends javax.swing.JFrame {

    JFileChooser jFileChooser = new JFileChooser();
    TaiLieuDuAnDAO daoImage = new TaiLieuDuAnDAO();
    QuanLyDuAnDAO dao = new QuanLyDuAnDAO();
    QuanLyDuAn da;
    private int indexImage;
    File file;
    private String Toa;

    public EditProjectFrame(QuanLyDuAn entity) {
        initComponents();
        this.da = entity;
        initForm();

    }

    public void initForm() {
        setForm(da);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        if (ImageProject() != null) {
            indexImage = ImageProject().size() - 1;
            SeeImageProject();

        } else if (indexImage == 1) {
            btnNext.setEnabled(false);
            btnPrevious.setEnabled(false);
        } else {
            indexImage = -1;
            btnNext.setVisible(false);
            btnPrevious.setVisible(false);
        }
        if (indexImage == -1) {
            btnXoaHinh.setVisible(false);
        }
    }

    public List<TaiLieuDuAN> ImageProject() {
        List<TaiLieuDuAN> list = daoImage.selectByIdmaDA(da.getMaDA());
        if (list == null) {
            return null;
        }
        return list;
    }

    public void SeeImageProject() {
        for (int i = 0; i < ImageProject().size(); i++) {
            if (i == indexImage) {
                lblImageDa.setIcon(new ImageIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\imgAvartar\\" + ImageProject().get(i).getHinh()).getImage().getScaledInstance(lblImageDa.getWidth(), lblImageDa.getHeight(), Image.SCALE_DEFAULT)));
            }
        }
    }

    public void Next() {
        if (indexImage == ImageProject().size() - 1) {
            indexImage = 0;
        } else {
            indexImage++;
        }
        SeeImageProject();
    }

    public void Previous() {
        if (indexImage == 0) {
            indexImage = ImageProject().size() - 1;
        } else {
            indexImage--;
        }
        SeeImageProject();
    }

    public void setForm(QuanLyDuAn da) {
        if (da.getMaDA() != null) {
            txtMaDA.setText(da.getMaDA());
        } else {
            txtMaDA.setText("");
        }

        if (da.getBanGiao() != null) {
            txtThoiGianBanGiao.setText(da.getMaDA());
        } else {
            txtThoiGianBanGiao.setText("");
        }

        if (da.getChuDauTu() != null) {
            txtChuDauTu.setText(da.getChuDauTu());
        } else {
            txtChuDauTu.setText("");
        }

        if (da.getDiaChi() != null) {
            txaDiaChi.setText(da.getDiaChi());
        } else {
            txaDiaChi.setText("");
        }

        if (da.getDonViTuVanKT() != null) {
            txtDonViTVKiThuat.setText(da.getDonViTuVanKT());
        } else {
            txtDonViTVKiThuat.setText("");
        }

        if (da.getHoanThien() != null) {
            txtThoiGianHoanThien.setText(da.getHoanThien());
        } else {
            txtThoiGianHoanThien.setText("");
        }

        if (da.getKhoiCong() != null) {
            txtThoiGianKhoiCong.setText(da.getKhoiCong());
        } else {
            txtThoiGianKhoiCong.setText("");
        }

        if (da.getKienTrucThietKe() != null) {
            txtKienTrucThietKe.setText(da.getKienTrucThietKe());
        } else {
            txtKienTrucThietKe.setText("");
        }

        if (da.getLoaiHinhSP() != null) {
            txtLoaiHinhSanPham.setText(da.getLoaiHinhSP());
        } else {
            txtLoaiHinhSanPham.setText("");
        }

        if (da.getMaNVPhuTrach() != null) {
            txtNVPhuTrach.setText(da.getMaNVPhuTrach());
        } else {
            txtNVPhuTrach.setText("");
        }

        try {
            txtMatDo.setText(String.valueOf(da.getMatDo()));
        } catch (Exception e) {
            txtMatDo.setText("");
            e.printStackTrace();
        }

        if (da.getPhapLy() != null) {
            txtPhapLy.setText(da.getPhapLy());
        } else {
            txtPhapLy.setText("");
        }

        if (da.getQuyMo() != null) {
            txtQuyMo.setText(da.getQuyMo());
        } else {
            txtQuyMo.setText("");
        }

        if (da.getSoLuongSanPham() != null) {
            txtSoLuongSanPham.setText(da.getSoLuongSanPham());
        } else {
            txtSoLuongSanPham.setText("");
        }

        if (da.getTenDA() != null) {
            txtTenDa.setText(da.getTenDA());
        } else {
            txtTenDa.setText("");
        }

        try {
            txtTongDienTich.setText(String.valueOf(da.getTongDienTich()));
        } catch (Exception e) {
            e.printStackTrace();
            txtTongDienTich.setText("");
        }

        try {
            txtTongVonDauTu.setText(String.valueOf(da.getTongVonDauTu()));
        } catch (Exception e) {
            e.printStackTrace();
            txtTongVonDauTu.setText("");
        }

        try {
            txtTongDienTichSan.setText(String.valueOf(da.getTongDienTichSan()));

        } catch (Exception e) {
            e.printStackTrace();
            txtTongDienTichSan.setText("");
        }

        try {
            txtDienTichKhuCanHo.setText(String.valueOf(da.getTongDienTichCanHo()));
        } catch (Exception e) {
            e.printStackTrace();
            txtDienTichKhuCanHo.setText("");
        }

        try {
            txtDienTichKhuThuongMai.setText(String.valueOf(da.getTongdienTichKhuThuongMai()));
        } catch (Exception e) {
            e.printStackTrace();
            txtDienTichKhuThuongMai.setText("");
        }
    }

    public void addImage(File file, String tenTaiLieu) {
        TaiLieuDuAN image = new TaiLieuDuAN();
        image.setTenTaiLieu(tenTaiLieu);
        image.setDienGiai("Hình dự án");
        image.setHinh(file.getName());
        image.setMaDA(da.getMaDA());
        image.setMaKH(null);
        image.setMaSPDA(null);
        image.setNhanVien(da.getMaNVPhuTrach());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        image.setNgayCapNhat(XDate.toDate(dtf.format(now), "yyyy-MM-dd"));
        try {
            daoImage.insert(image);
            ImageProject();
            indexImage = ImageProject().size() - 1;
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi lưu hình ảnh");
            MsgBox.alert(this, "Vui lòng chọn hình cần lưu và nhập Tên tòa nhà nếu có~!");
            e.printStackTrace();
        }
    }

    public void chonAnh() {
        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lblImageDa.setIcon(icon);
            lblImageDa.setToolTipText(file.getName());
        }
    }

    public void RemoveImage() {
        if (MsgBox.confirm(this, "Bạn có chắc chắn muốn xóa bức hình này!")) {
            try {
                daoImage.delete(ImageProject().get(indexImage).getKyHieu());
                MsgBox.alert(this, "Xóa thành công hình ảnh!");
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi khi xóa hình ảnh");
                e.printStackTrace();
            }
        }
    }

    public QuanLyDuAn getForm() {
        QuanLyDuAn daUpdate = new QuanLyDuAn();
        daUpdate.setBanGiao(txtThoiGianBanGiao.getText());
        daUpdate.setChuDauTu(txtChuDauTu.getText());
        daUpdate.setDiaChi(txaDiaChi.getText());
        daUpdate.setDonViTuVanKT(txtDonViTVKiThuat.getText());
        daUpdate.setHoanThien(txtThoiGianHoanThien.getText());
        daUpdate.setKhoiCong(txtThoiGianKhoiCong.getText());
        daUpdate.setKienTrucThietKe(txtKienTrucThietKe.getText());
        daUpdate.setLoaiHinhSP(txtLoaiHinhSanPham.getText());
        daUpdate.setMaDA(txtMaDA.getText());
        daUpdate.setMaNVPhuTrach(txtNVPhuTrach.getText());
        daUpdate.setMatDo(Double.parseDouble(txtMatDo.getText()));
        daUpdate.setNgayDang(da.getNgayDang());
        daUpdate.setPhapLy(txtPhapLy.getText());
        daUpdate.setQuyMo(txtQuyMo.getText());
        daUpdate.setSoLuongSanPham(txtSoLuongSanPham.getText());
        daUpdate.setTenDA(txtTenDa.getText());
        daUpdate.setTieuChuanBanGiao(txtTieuChuanBanGiao.getText());
        daUpdate.setTongDienTich(Double.parseDouble(txtTongDienTich.getText()));
        daUpdate.setTongDienTichCanHo(Double.parseDouble(txtDienTichKhuCanHo.getText()));
        daUpdate.setTongDienTichSan(Double.parseDouble(txtTongDienTichSan.getText()));
        daUpdate.setTongVonDauTu(Double.parseDouble(txtTongVonDauTu.getText()));
        daUpdate.setTongdienTichKhuThuongMai(Double.parseDouble(txtDienTichKhuThuongMai.getText()));
        return daUpdate;
    }

    public void UpdateDUAn() {
        try {
            dao.update(getForm());
            MsgBox.alert(this, "Cập nhật thành công dự án!");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }
    public void clearForm() {
        txtChuDauTu.setText("");
        txtDienTichKhuCanHo.setText("");
        txtDienTichKhuThuongMai.setText("");
        txtDonViTVKiThuat.setText("");
        txtKienTrucThietKe.setText("");
        txtLoaiHinhSanPham.setText("");
        txtMatDo.setText("");
        txtNVPhuTrach.setText("");
        txtPhapLy.setText("");
        txtQuyMo.setText("");
        txtSoLuongSanPham.setText("");
        txtTenDa.setText("");
        txtThoiGianBanGiao.setText("");
        txtThoiGianHoanThien.setText("");
        txtThoiGianKhoiCong.setText("");
       txtTieuChuanBanGiao.setText("");
       txtTongDienTich.setText("");
       txtTongVonDauTu.setText("");
       txtTongDienTichSan.setText("");  
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
        txaDiaChi = new javax.swing.JTextArea();
        lblImageDa = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JLabel();
        txtTongDienTich = new com.mycompany.qlbatdongsan.utils.TextField();
        txtMaDA = new com.mycompany.qlbatdongsan.utils.TextField();
        txtTenDa = new com.mycompany.qlbatdongsan.utils.TextField();
        txtDienTichKhuCanHo = new com.mycompany.qlbatdongsan.utils.TextField();
        txtTongDienTichSan = new com.mycompany.qlbatdongsan.utils.TextField();
        txtMatDo = new com.mycompany.qlbatdongsan.utils.TextField();
        txtDienTichKhuThuongMai = new com.mycompany.qlbatdongsan.utils.TextField();
        txtPhapLy = new com.mycompany.qlbatdongsan.utils.TextField();
        txtTongVonDauTu = new com.mycompany.qlbatdongsan.utils.TextField();
        txtTieuChuanBanGiao = new com.mycompany.qlbatdongsan.utils.TextField();
        txtKienTrucThietKe = new com.mycompany.qlbatdongsan.utils.TextField();
        txtDonViTVKiThuat = new com.mycompany.qlbatdongsan.utils.TextField();
        txtQuyMo = new com.mycompany.qlbatdongsan.utils.TextField();
        txtThoiGianKhoiCong = new com.mycompany.qlbatdongsan.utils.TextField();
        txtThoiGianHoanThien = new com.mycompany.qlbatdongsan.utils.TextField();
        txtThoiGianBanGiao = new com.mycompany.qlbatdongsan.utils.TextField();
        txtNVPhuTrach = new com.mycompany.qlbatdongsan.utils.TextField();
        txtChuDauTu = new com.mycompany.qlbatdongsan.utils.TextField();
        txtLoaiHinhSanPham = new com.mycompany.qlbatdongsan.utils.TextField();
        txtSoLuongSanPham = new com.mycompany.qlbatdongsan.utils.TextField();
        btnClear = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblClear = new javax.swing.JLabel();
        btnHuy = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblHuy = new javax.swing.JLabel();
        btnHoanTat = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblHoanTat = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThemHinh = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblThemHinh = new javax.swing.JLabel();
        btnXoaHinh = new com.mycompany.qlbatdongsan.utils.PanelRound();
        lblXoaHinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CHỈNH SỬA DỰ ÁN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 20, -1, -1));

        txaDiaChi.setBackground(new java.awt.Color(255, 255, 255));
        txaDiaChi.setColumns(20);
        txaDiaChi.setRows(5);
        txaDiaChi.setText("\n");
        txaDiaChi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Địa chỉ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        txaDiaChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txaDiaChiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txaDiaChi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 596, 383, 50));

        lblImageDa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageDa.setText("Hình ảnh");
        lblImageDa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hình ảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        getContentPane().add(lblImageDa, new org.netbeans.lib.awtextra.AbsoluteConstraints(872, 88, 380, 260));

        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-next-page-64.png"))); // NOI18N
        btnNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNextMouseExited(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 361, 68, -1));

        btnPrevious.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnPrevious.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-back-to-64.png"))); // NOI18N
        btnPrevious.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPreviousMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPreviousMouseExited(evt);
            }
        });
        getContentPane().add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(876, 361, 68, -1));

        txtTongDienTich.setBackground(new java.awt.Color(255, 255, 255));
        txtTongDienTich.setForeground(new java.awt.Color(0, 0, 0));
        txtTongDienTich.setLabelText("Tổng diện tích");
        txtTongDienTich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongDienTichActionPerformed(evt);
            }
        });
        getContentPane().add(txtTongDienTich, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 383, 40));

        txtMaDA.setBackground(new java.awt.Color(255, 255, 255));
        txtMaDA.setForeground(new java.awt.Color(255, 0, 0));
        txtMaDA.setEnabled(false);
        txtMaDA.setLabelText("Mã dự án");
        txtMaDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDAActionPerformed(evt);
            }
        });
        getContentPane().add(txtMaDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 383, 40));

        txtTenDa.setBackground(new java.awt.Color(255, 255, 255));
        txtTenDa.setForeground(new java.awt.Color(0, 0, 0));
        txtTenDa.setLabelText("Tên dự án");
        txtTenDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDaActionPerformed(evt);
            }
        });
        getContentPane().add(txtTenDa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 383, 40));

        txtDienTichKhuCanHo.setBackground(new java.awt.Color(255, 255, 255));
        txtDienTichKhuCanHo.setForeground(new java.awt.Color(0, 0, 0));
        txtDienTichKhuCanHo.setLabelText("Diện tích khu căn hộ");
        txtDienTichKhuCanHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienTichKhuCanHoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDienTichKhuCanHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 383, 40));

        txtTongDienTichSan.setBackground(new java.awt.Color(255, 255, 255));
        txtTongDienTichSan.setForeground(new java.awt.Color(0, 0, 0));
        txtTongDienTichSan.setLabelText("Tổng diện tích sàn");
        txtTongDienTichSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongDienTichSanActionPerformed(evt);
            }
        });
        getContentPane().add(txtTongDienTichSan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 383, 40));

        txtMatDo.setBackground(new java.awt.Color(255, 255, 255));
        txtMatDo.setForeground(new java.awt.Color(0, 0, 0));
        txtMatDo.setLabelText("Mật độ");
        txtMatDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatDoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMatDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 383, 40));

        txtDienTichKhuThuongMai.setBackground(new java.awt.Color(255, 255, 255));
        txtDienTichKhuThuongMai.setForeground(new java.awt.Color(0, 0, 0));
        txtDienTichKhuThuongMai.setLabelText("Diện tích khu thương mại");
        txtDienTichKhuThuongMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDienTichKhuThuongMaiActionPerformed(evt);
            }
        });
        getContentPane().add(txtDienTichKhuThuongMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 383, 40));

        txtPhapLy.setBackground(new java.awt.Color(255, 255, 255));
        txtPhapLy.setForeground(new java.awt.Color(0, 0, 0));
        txtPhapLy.setLabelText("Pháp lý");
        txtPhapLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhapLyActionPerformed(evt);
            }
        });
        getContentPane().add(txtPhapLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 383, 40));

        txtTongVonDauTu.setBackground(new java.awt.Color(255, 255, 255));
        txtTongVonDauTu.setForeground(new java.awt.Color(0, 0, 0));
        txtTongVonDauTu.setLabelText("Tổng vốn đầu tư");
        txtTongVonDauTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongVonDauTuActionPerformed(evt);
            }
        });
        getContentPane().add(txtTongVonDauTu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 383, 40));

        txtTieuChuanBanGiao.setBackground(new java.awt.Color(255, 255, 255));
        txtTieuChuanBanGiao.setForeground(new java.awt.Color(0, 0, 0));
        txtTieuChuanBanGiao.setLabelText("Tiêu chuẩn bàn giao");
        txtTieuChuanBanGiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTieuChuanBanGiaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTieuChuanBanGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 383, 40));

        txtKienTrucThietKe.setBackground(new java.awt.Color(255, 255, 255));
        txtKienTrucThietKe.setForeground(new java.awt.Color(0, 0, 0));
        txtKienTrucThietKe.setLabelText("Kiến trúc thiết kế");
        txtKienTrucThietKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKienTrucThietKeActionPerformed(evt);
            }
        });
        getContentPane().add(txtKienTrucThietKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 383, 40));

        txtDonViTVKiThuat.setBackground(new java.awt.Color(255, 255, 255));
        txtDonViTVKiThuat.setForeground(new java.awt.Color(0, 0, 0));
        txtDonViTVKiThuat.setLabelText("Đơn vị tư vấn kĩ thuật");
        txtDonViTVKiThuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViTVKiThuatActionPerformed(evt);
            }
        });
        getContentPane().add(txtDonViTVKiThuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 383, 40));

        txtQuyMo.setBackground(new java.awt.Color(255, 255, 255));
        txtQuyMo.setForeground(new java.awt.Color(0, 0, 0));
        txtQuyMo.setLabelText("Quy mô");
        txtQuyMo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuyMoActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuyMo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 383, 40));

        txtThoiGianKhoiCong.setBackground(new java.awt.Color(255, 255, 255));
        txtThoiGianKhoiCong.setForeground(new java.awt.Color(0, 0, 0));
        txtThoiGianKhoiCong.setLabelText("Thời gian khởi công");
        txtThoiGianKhoiCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianKhoiCongActionPerformed(evt);
            }
        });
        getContentPane().add(txtThoiGianKhoiCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 383, 40));

        txtThoiGianHoanThien.setBackground(new java.awt.Color(255, 255, 255));
        txtThoiGianHoanThien.setForeground(new java.awt.Color(0, 0, 0));
        txtThoiGianHoanThien.setLabelText("Thời gian hoàn thiện");
        txtThoiGianHoanThien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianHoanThienActionPerformed(evt);
            }
        });
        getContentPane().add(txtThoiGianHoanThien, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 383, 40));

        txtThoiGianBanGiao.setBackground(new java.awt.Color(255, 255, 255));
        txtThoiGianBanGiao.setForeground(new java.awt.Color(0, 0, 0));
        txtThoiGianBanGiao.setLabelText("Thời gian bàn giao");
        txtThoiGianBanGiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianBanGiaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtThoiGianBanGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 383, 40));

        txtNVPhuTrach.setBackground(new java.awt.Color(255, 255, 255));
        txtNVPhuTrach.setForeground(new java.awt.Color(0, 0, 0));
        txtNVPhuTrach.setLabelText("Mã nhân viên phụ trách");
        txtNVPhuTrach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNVPhuTrachActionPerformed(evt);
            }
        });
        getContentPane().add(txtNVPhuTrach, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 383, 40));

        txtChuDauTu.setBackground(new java.awt.Color(255, 255, 255));
        txtChuDauTu.setForeground(new java.awt.Color(0, 0, 0));
        txtChuDauTu.setLabelText("Chủ đầu tư");
        txtChuDauTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChuDauTuActionPerformed(evt);
            }
        });
        getContentPane().add(txtChuDauTu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 383, 40));

        txtLoaiHinhSanPham.setBackground(new java.awt.Color(255, 255, 255));
        txtLoaiHinhSanPham.setForeground(new java.awt.Color(0, 0, 0));
        txtLoaiHinhSanPham.setLabelText("Loại hình sản phẩm");
        txtLoaiHinhSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoaiHinhSanPhamActionPerformed(evt);
            }
        });
        getContentPane().add(txtLoaiHinhSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 383, 40));

        txtSoLuongSanPham.setBackground(new java.awt.Color(255, 255, 255));
        txtSoLuongSanPham.setForeground(new java.awt.Color(0, 0, 0));
        txtSoLuongSanPham.setLabelText("Số lượng sản phẩm");
        txtSoLuongSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongSanPhamActionPerformed(evt);
            }
        });
        getContentPane().add(txtSoLuongSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 383, 40));

        btnClear.setBackground(new java.awt.Color(204, 204, 204));
        btnClear.setRoundBottonLeft(40);
        btnClear.setRoundBottonRight(40);
        btnClear.setRoundTopLeft(40);
        btnClear.setRoundTopRight(40);

        lblClear.setBackground(new java.awt.Color(51, 51, 51));
        lblClear.setForeground(new java.awt.Color(0, 0, 0));
        lblClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-clear-symbol-30.png"))); // NOI18N
        lblClear.setText("  Xóa ");
        lblClear.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblClearMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnClearLayout = new javax.swing.GroupLayout(btnClear);
        btnClear.setLayout(btnClearLayout);
        btnClearLayout.setHorizontalGroup(
            btnClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClear, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnClearLayout.setVerticalGroup(
            btnClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 596, -1, -1));

        btnHuy.setBackground(new java.awt.Color(204, 204, 204));
        btnHuy.setRoundBottonLeft(40);
        btnHuy.setRoundBottonRight(40);
        btnHuy.setRoundTopLeft(40);
        btnHuy.setRoundTopRight(40);

        lblHuy.setBackground(new java.awt.Color(51, 51, 51));
        lblHuy.setForeground(new java.awt.Color(0, 0, 0));
        lblHuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-close-30.png"))); // NOI18N
        lblHuy.setText("Hủy");
        lblHuy.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHuyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHuyMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnHuyLayout = new javax.swing.GroupLayout(btnHuy);
        btnHuy.setLayout(btnHuyLayout);
        btnHuyLayout.setHorizontalGroup(
            btnHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHuy, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnHuyLayout.setVerticalGroup(
            btnHuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHuyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 596, -1, -1));

        btnHoanTat.setBackground(new java.awt.Color(204, 204, 204));
        btnHoanTat.setRoundBottonLeft(40);
        btnHoanTat.setRoundBottonRight(40);
        btnHoanTat.setRoundTopLeft(40);
        btnHoanTat.setRoundTopRight(40);

        lblHoanTat.setBackground(new java.awt.Color(51, 51, 51));
        lblHoanTat.setForeground(new java.awt.Color(0, 0, 0));
        lblHoanTat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHoanTat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-favorite-database-24.png"))); // NOI18N
        lblHoanTat.setText("Hoàn tất");
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

        getContentPane().add(btnHoanTat, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 596, -1, 42));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThemHinh.setBackground(new java.awt.Color(204, 204, 204));
        btnThemHinh.setRoundBottonLeft(40);
        btnThemHinh.setRoundBottonRight(40);
        btnThemHinh.setRoundTopLeft(40);
        btnThemHinh.setRoundTopRight(40);

        lblThemHinh.setBackground(new java.awt.Color(51, 51, 51));
        lblThemHinh.setForeground(new java.awt.Color(0, 0, 0));
        lblThemHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThemHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-plus-math-30.png"))); // NOI18N
        lblThemHinh.setText("Thêm hình");
        lblThemHinh.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblThemHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemHinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThemHinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThemHinhMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnThemHinhLayout = new javax.swing.GroupLayout(btnThemHinh);
        btnThemHinh.setLayout(btnThemHinhLayout);
        btnThemHinhLayout.setHorizontalGroup(
            btnThemHinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThemHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnThemHinhLayout.setVerticalGroup(
            btnThemHinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemHinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThemHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnXoaHinh.setBackground(new java.awt.Color(204, 204, 204));
        btnXoaHinh.setRoundBottonLeft(40);
        btnXoaHinh.setRoundBottonRight(40);
        btnXoaHinh.setRoundTopLeft(40);
        btnXoaHinh.setRoundTopRight(40);

        lblXoaHinh.setBackground(new java.awt.Color(51, 51, 51));
        lblXoaHinh.setForeground(new java.awt.Color(0, 0, 0));
        lblXoaHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXoaHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/icons8-remove-30.png"))); // NOI18N
        lblXoaHinh.setText("Xóa hình");
        lblXoaHinh.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblXoaHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXoaHinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblXoaHinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblXoaHinhMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnXoaHinhLayout = new javax.swing.GroupLayout(btnXoaHinh);
        btnXoaHinh.setLayout(btnXoaHinhLayout);
        btnXoaHinhLayout.setHorizontalGroup(
            btnXoaHinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblXoaHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        btnXoaHinhLayout.setVerticalGroup(
            btnXoaHinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnXoaHinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblXoaHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1044, Short.MAX_VALUE)
                .addComponent(btnThemHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoaHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(285, 285, 285))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:
        btnNext.setIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\icon\\icons8-circled-right-64.png"));
        Next();
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
        // TODO add your handling code here:
        btnNext.setIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\icon\\icons8-next-page-1-64.png"));
    }//GEN-LAST:event_btnNextMouseEntered

    private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
        // TODO add your handling code here:
        btnNext.setIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\icon\\icons8-next-page-64.png"));
    }//GEN-LAST:event_btnNextMouseExited

    private void btnPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseClicked
        // TODO add your handling code her
        btnPrevious.setIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\icon\\icons8-go-back-64.png"));
        Previous();
    }//GEN-LAST:event_btnPreviousMouseClicked

    private void btnPreviousMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseEntered
        // TODO add your handling code here:
        btnPrevious.setIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\icon\\icons8-back-to-1-64.png"));
    }//GEN-LAST:event_btnPreviousMouseEntered

    private void btnPreviousMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseExited
        // TODO add your handling code here:
        btnPrevious.setIcon(new ImageIcon("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\images\\icon\\icons8-back-to-64.png"));
    }//GEN-LAST:event_btnPreviousMouseExited

    private void txaDiaChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txaDiaChiMouseClicked
        // TODO add your handling code here:
        txaDiaChi.setText(null);
    }//GEN-LAST:event_txaDiaChiMouseClicked

    private void txtTongDienTichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongDienTichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongDienTichActionPerformed

    private void txtMaDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDAActionPerformed

    private void txtTenDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDaActionPerformed

    private void txtDienTichKhuCanHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienTichKhuCanHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDienTichKhuCanHoActionPerformed

    private void txtTongDienTichSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongDienTichSanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongDienTichSanActionPerformed

    private void txtMatDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatDoActionPerformed

    private void txtDienTichKhuThuongMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienTichKhuThuongMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDienTichKhuThuongMaiActionPerformed

    private void txtPhapLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhapLyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhapLyActionPerformed

    private void txtTongVonDauTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongVonDauTuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongVonDauTuActionPerformed

    private void txtTieuChuanBanGiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTieuChuanBanGiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTieuChuanBanGiaoActionPerformed

    private void txtKienTrucThietKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKienTrucThietKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKienTrucThietKeActionPerformed

    private void txtDonViTVKiThuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViTVKiThuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViTVKiThuatActionPerformed

    private void txtQuyMoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuyMoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuyMoActionPerformed

    private void txtThoiGianKhoiCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianKhoiCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianKhoiCongActionPerformed

    private void txtThoiGianHoanThienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianHoanThienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianHoanThienActionPerformed

    private void txtThoiGianBanGiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianBanGiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianBanGiaoActionPerformed

    private void txtNVPhuTrachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNVPhuTrachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNVPhuTrachActionPerformed

    private void txtChuDauTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChuDauTuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChuDauTuActionPerformed

    private void txtLoaiHinhSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoaiHinhSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoaiHinhSanPhamActionPerformed

    private void txtSoLuongSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongSanPhamActionPerformed

    private void lblClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseClicked
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_lblClearMouseClicked

    private void lblClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseEntered
        // TODO add your handling code here:
        btnClear.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblClearMouseEntered

    private void lblClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseExited
        // TODO add your handling code here:
        btnClear.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblClearMouseExited

    private void lblHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblHuyMouseClicked

    private void lblHuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyMouseEntered
        // TODO add your handling code here:
        btnHuy.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblHuyMouseEntered

    private void lblHuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHuyMouseExited
        // TODO add your handling code here:
        btnHuy.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblHuyMouseExited

    private void lblHoanTatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoanTatMouseClicked
        // TODO add your handling code here:
        UpdateDUAn();
    }//GEN-LAST:event_lblHoanTatMouseClicked

    private void lblHoanTatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoanTatMouseEntered
        // TODO add your handling code here:
        btnHoanTat.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblHoanTatMouseEntered

    private void lblHoanTatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoanTatMouseExited
        // TODO add your handling code here:
        btnHoanTat.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblHoanTatMouseExited

    private void lblXoaHinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXoaHinhMouseExited
        // TODO add your handling code here:
        btnXoaHinh.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblXoaHinhMouseExited

    private void lblXoaHinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXoaHinhMouseEntered
        // TODO add your handling code here:
        btnXoaHinh.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblXoaHinhMouseEntered

    private void lblXoaHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXoaHinhMouseClicked
        // TODO add your handling code here:
        RemoveImage();
    }//GEN-LAST:event_lblXoaHinhMouseClicked

    private void lblThemHinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemHinhMouseExited
        // TODO add your handling code here:
        btnThemHinh.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblThemHinhMouseExited

    private void lblThemHinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemHinhMouseEntered
        // TODO add your handling code here:
        btnThemHinh.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblThemHinhMouseEntered

    private void lblThemHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemHinhMouseClicked
        // TODO add your handling code here:
        if (MsgBox.confirm(this, "Bạn đang chọn hình cho 1 tòa nhà?")) {
            Toa = MsgBox.promt(this, "Mời bạn nhập Tòa: ");
            chonAnh();
            addImage(file, "Hình Tòa " + this.Toa);
        } else {
            chonAnh();
            addImage(file, "Hình dự án " + da.getTenDA());
        }
    }//GEN-LAST:event_lblThemHinhMouseClicked

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
            java.util.logging.Logger.getLogger(EditProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProjectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.qlbatdongsan.utils.PanelRound btnClear;
    private com.mycompany.qlbatdongsan.utils.PanelRound btnHoanTat;
    private com.mycompany.qlbatdongsan.utils.PanelRound btnHuy;
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPrevious;
    private com.mycompany.qlbatdongsan.utils.PanelRound btnThemHinh;
    private com.mycompany.qlbatdongsan.utils.PanelRound btnXoaHinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClear;
    private javax.swing.JLabel lblHoanTat;
    private javax.swing.JLabel lblHuy;
    private javax.swing.JLabel lblImageDa;
    private javax.swing.JLabel lblThemHinh;
    private javax.swing.JLabel lblXoaHinh;
    private javax.swing.JTextArea txaDiaChi;
    private com.mycompany.qlbatdongsan.utils.TextField txtChuDauTu;
    private com.mycompany.qlbatdongsan.utils.TextField txtDienTichKhuCanHo;
    private com.mycompany.qlbatdongsan.utils.TextField txtDienTichKhuThuongMai;
    private com.mycompany.qlbatdongsan.utils.TextField txtDonViTVKiThuat;
    private com.mycompany.qlbatdongsan.utils.TextField txtKienTrucThietKe;
    private com.mycompany.qlbatdongsan.utils.TextField txtLoaiHinhSanPham;
    private com.mycompany.qlbatdongsan.utils.TextField txtMaDA;
    private com.mycompany.qlbatdongsan.utils.TextField txtMatDo;
    private com.mycompany.qlbatdongsan.utils.TextField txtNVPhuTrach;
    private com.mycompany.qlbatdongsan.utils.TextField txtPhapLy;
    private com.mycompany.qlbatdongsan.utils.TextField txtQuyMo;
    private com.mycompany.qlbatdongsan.utils.TextField txtSoLuongSanPham;
    private com.mycompany.qlbatdongsan.utils.TextField txtTenDa;
    private com.mycompany.qlbatdongsan.utils.TextField txtThoiGianBanGiao;
    private com.mycompany.qlbatdongsan.utils.TextField txtThoiGianHoanThien;
    private com.mycompany.qlbatdongsan.utils.TextField txtThoiGianKhoiCong;
    private com.mycompany.qlbatdongsan.utils.TextField txtTieuChuanBanGiao;
    private com.mycompany.qlbatdongsan.utils.TextField txtTongDienTich;
    private com.mycompany.qlbatdongsan.utils.TextField txtTongDienTichSan;
    private com.mycompany.qlbatdongsan.utils.TextField txtTongVonDauTu;
    // End of variables declaration//GEN-END:variables
}
