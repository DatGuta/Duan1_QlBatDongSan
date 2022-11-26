
package com.mycompany.qlbatdongsan.Entity;

import java.util.Date;


public class ChuyenNhuong {
    private int maCN;
    private String soHopDong;
    private String khachHang;
    private String maSanPham;
    private Double giaBan;
    private Float chietKhau;
    private Double cong;
    private Double phiMoiGioi;
    private Date thoiHan;
    private Date ngayNhap;

    public int getMaCN() {
        return maCN;
    }

    public void setMaCN(int maCN) {
        this.maCN = maCN;
    }

    public String getSoHopDong() {
        return soHopDong;
    }

    public void setSoHopDong(String soHopDong) {
        this.soHopDong = soHopDong;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Float getChietKhau() {
        return chietKhau;
    }

    public void setChiecKhau(Float chietKhau) {
        this.chietKhau = chietKhau;
    }

    public Double getCong() {
        return cong;
    }

    public void setCong(Double cong) {
        this.cong = cong;
    }

    public Double getPhiMoiGioi() {
        return phiMoiGioi;
    }

    public void setPhiMoiGioi(Double phiMoiGioi) {
        this.phiMoiGioi = phiMoiGioi;
    }

    public Date getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Date thoiHan) {
        this.thoiHan = thoiHan;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public ChuyenNhuong(int maCN, String soHopDong, String khachHang, String maSanPham, Double giaBan, Float chietKhau, Double cong, Double phiMoiGioi, Date thoiHan, Date ngayNhap) {
        this.maCN = maCN;
        this.soHopDong = soHopDong;
        this.khachHang = khachHang;
        this.maSanPham = maSanPham;
        this.giaBan = giaBan;
        this.chietKhau = chietKhau;
        this.cong = cong;
        this.phiMoiGioi = phiMoiGioi;
        this.thoiHan = thoiHan;
        this.ngayNhap = ngayNhap;
    }

    public ChuyenNhuong() {
    }
    
}
