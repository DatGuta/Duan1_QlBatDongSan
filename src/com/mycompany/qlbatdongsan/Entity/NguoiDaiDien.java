
package com.mycompany.qlbatdongsan.Entity;

import java.util.Date;

public class NguoiDaiDien {
    private String maDD;
    private String hoTen;
    private String sdtCoDinh;
    private String sdtDiDong;
    private String Email;
    private String diaChiLienLac;
    private String diaChiThuongTru;
    private Boolean gioiTinh;
    private Date ngaySinh;
    private String maKH;

    public String getMaDD() {
        return maDD;
    }

    public void setMaDD(String maDD) {
        this.maDD = maDD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdtCoDinh() {
        return sdtCoDinh;
    }

    public void setSdtCoDinh(String sdtCoDinh) {
        this.sdtCoDinh = sdtCoDinh;
    }

    public String getSdtDiDong() {
        return sdtDiDong;
    }

    public void setSdtDiDong(String sdtDiDong) {
        this.sdtDiDong = sdtDiDong;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChiLienLac() {
        return diaChiLienLac;
    }

    public void setDiaChiLienLac(String diaChiLienLac) {
        this.diaChiLienLac = diaChiLienLac;
    }

    public String getDiaChiThuongTru() {
        return diaChiThuongTru;
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    
}
