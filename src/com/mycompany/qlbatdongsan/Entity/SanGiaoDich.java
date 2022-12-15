
package com.mycompany.qlbatdongsan.Entity;

import java.util.Date;

public class SanGiaoDich {
    private int maSGD;
    private String sanGiaoDich;
    private String sdt;
    private String diaChi;
    private String nvQuanLy;
    private String nvTao;
    private Date ngayTao;

    public int getMaSGD() {
        return maSGD;
    }

    public void setMaSGD(int maSGD) {
        this.maSGD = maSGD;
    }

    public String getSanGiaoDich() {
        return sanGiaoDich;
    }

    public void setSanGiaoDich(String sanGiaoDich) {
        this.sanGiaoDich = sanGiaoDich;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
    public String getNvQuanLy() {
        return nvQuanLy;
    }

    public void setNvQuanLy(String nvQuanLy) {
        this.nvQuanLy = nvQuanLy;
    }

    public String getNvTao() {
        return nvTao;
    }

    public void setNvTao(String nvTao) {
        this.nvTao = nvTao;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
}

