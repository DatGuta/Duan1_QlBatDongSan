package com.mycompany.qlbatdongsan.Entity;



import java.util.Date;

public class NhanVien {

    private String maNV;
    private String maQR;
    private int maSGD;
    private String hoTen;
    private Date ngaySinh;
    private String sdt;
    private String soNoiBo;
    private String chucDanh;
    private String matKhau;
    private String maQuanLy;
    private Boolean gioiTinh;
    private Boolean lockCheckBox;
     
    @Override
    public String toString() {
        return this.hoTen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaQR() {
        return maQR;
    }

    public void setMaQR(String maQR) {
        this.maQR = maQR;
    }

    public int getMaSGD() {
        return maSGD;
    }

    public void setMaSGD(int maSGD) {
        this.maSGD = maSGD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSoNoiBo() {
        return soNoiBo;
    }

    public void setSoNoiBo(String soNoiBo) {
        this.soNoiBo = soNoiBo;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(String maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Boolean getLockCheckBox() {
        return lockCheckBox;
    }

    public void setLockCheckBox(Boolean lockCheckBox) {
        this.lockCheckBox = lockCheckBox;
    }
    
}
