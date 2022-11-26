
package com.mycompany.qlbatdongsan.Entity;

import java.util.Date;


public class HopDong {
    private String soHopDong;
    private int STT;
    private Date ngayKy;
    private Float dienTich;
    private Double donGia;
    private Double thanhTien;
    private String soPhieu;
    private String maSPDA;
    private String trangThai;
    private String maKH;

    public String getSoHopDong() {
        return soHopDong;
    }

    public void setSoHopDong(String soHopDong) {
        this.soHopDong = soHopDong;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public Date getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(Date ngayKy) {
        this.ngayKy = ngayKy;
    }

    public Float getDienTich() {
        return dienTich;
    }

    public void setDienTich(Float dienTich) {
        this.dienTich = dienTich;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getMaSPDA() {
        return maSPDA;
    }

    public void setMaSPDA(String maSPDA) {
        this.maSPDA = maSPDA;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public HopDong(String soHopDong, int STT, Date ngayKy, Float dienTich, Double donGia, Double thanhTien, String soPhieu, String maSPDA, String trangThai, String maKH) {
        this.soHopDong = soHopDong;
        this.STT = STT;
        this.ngayKy = ngayKy;
        this.dienTich = dienTich;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.soPhieu = soPhieu;
        this.maSPDA = maSPDA;
        this.trangThai = trangThai;
        this.maKH = maKH;
    }

    public HopDong() {
    }
    
}
