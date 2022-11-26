
package com.mycompany.qlbatdongsan.Entity;

import java.util.Date;

public class LichSuLamViec {
    private String maLSLV;
    private int STT;
    private String tieuDe;
    private String maNV;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String maKH;

    public String getMaLSLV() {
        return maLSLV;
    }

    public void setMaLSLV(String maLSLV) {
        this.maLSLV = maLSLV;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    
}
