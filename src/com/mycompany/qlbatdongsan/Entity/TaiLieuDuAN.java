
package com.mycompany.qlbatdongsan.Entity;

import java.util.Date;

public class TaiLieuDuAN {
    private String kyHieu;
    private String tenTaiLieu;
    private String dienGiai;
    private String nhanVien;
    private Date ngayCapNhat;
    private String maSPDA;
    private String maKH;
    private String maDA;
    private String hinh;
    
     @Override
    public String toString() {
        return this.tenTaiLieu;
    }
    public TaiLieuDuAN(String kyHieu, String tenTaiLieu, String dienGiai, String nhanVien, Date ngayCapNhat, String maSPDA, String maKH, String maDA, String hinh) {
        this.kyHieu = kyHieu;
        this.tenTaiLieu = tenTaiLieu;
        this.dienGiai = dienGiai;
        this.nhanVien = nhanVien;
        this.ngayCapNhat = ngayCapNhat;
        this.maSPDA = maSPDA;
        this.maKH = maKH;
        this.maDA = maDA;
        this.hinh = hinh;
    }

    public TaiLieuDuAN() {
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public String getTenTaiLieu() {
        return tenTaiLieu;
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu = tenTaiLieu;
    }

    public String getDienGiai() {
        return dienGiai;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    public String getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(String nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getMaSPDA() {
        return maSPDA;
    }

    public void setMaSPDA(String maSPDA) {
        this.maSPDA = maSPDA;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaDA() {
        return maDA;
    }

    public void setMaDA(String maDA) {
        this.maDA = maDA;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

   
    
}
