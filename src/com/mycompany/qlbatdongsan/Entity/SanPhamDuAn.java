package com.mycompany.qlbatdongsan.Entity;

public class SanPhamDuAn {

    private String maSPDA;
    private String maDA;
    private String tenSP;
    private double dienTich;
    private int PhongBepKhach;
    private int PhongNgu;
    private int WC;
    private double Gia;
    private String LoaiSP;
    private String trangThai;
    private String tienNghi;
    private String chuSoHuu;
    private String tgSoHuu;
    private int SoTang;
    private int thuocTang;
    private int DonViPhanPhoi;
    private String Toa;

    public SanPhamDuAn(String maSPDA, String maDA, String tenSP, double dienTich, int PhongBepKhach, int PhongNgu, int WC, double Gia, String LoaiSP, String trangThai, String tienNghi, String chuSoHuu, String tgSoHuu, int SoTang, int thuocTang, int DonViPhanPhoi, String Toa) {
        this.maSPDA = maSPDA;
        this.maDA = maDA;
        this.tenSP = tenSP;
        this.dienTich = dienTich;
        this.PhongBepKhach = PhongBepKhach;
        this.PhongNgu = PhongNgu;
        this.WC = WC;
        this.Gia = Gia;
        this.LoaiSP = LoaiSP;
        this.trangThai = trangThai;
        this.tienNghi = tienNghi;
        this.chuSoHuu = chuSoHuu;
        this.tgSoHuu = tgSoHuu;
        this.SoTang = SoTang;
        this.thuocTang = thuocTang;
        this.DonViPhanPhoi = DonViPhanPhoi;
        this.Toa = Toa;
    }

    public SanPhamDuAn() {
    }

    public String getMaSPDA() {
        return maSPDA;
    }

    public void setMaSPDA(String maSPDA) {
        this.maSPDA = maSPDA;
    }

    public String getMaDA() {
        return maDA;
    }

    public void setMaDA(String maDA) {
        this.maDA = maDA;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getPhongBepKhach() {
        return PhongBepKhach;
    }

    public void setPhongBepKhach(int PhongBepKhach) {
        this.PhongBepKhach = PhongBepKhach;
    }

    public int getPhongNgu() {
        return PhongNgu;
    }

    public void setPhongNgu(int PhongNgu) {
        this.PhongNgu = PhongNgu;
    }

    public int getWC() {
        return WC;
    }

    public void setWC(int WC) {
        this.WC = WC;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTienNghi() {
        return tienNghi;
    }

    public void setTienNghi(String tienNghi) {
        this.tienNghi = tienNghi;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    public String getTgSoHuu() {
        return tgSoHuu;
    }

    public void setTgSoHuu(String tgSoHuu) {
        this.tgSoHuu = tgSoHuu;
    }

    public int getSoTang() {
        return SoTang;
    }

    public void setSoTang(int SoTang) {
        this.SoTang = SoTang;
    }

    public int getThuocTang() {
        return thuocTang;
    }

    public void setThuocTang(int thuocTang) {
        this.thuocTang = thuocTang;
    }

    public int getDonViPhanPhoi() {
        return DonViPhanPhoi;
    }

    public void setDonViPhanPhoi(int DonViPhanPhoi) {
        this.DonViPhanPhoi = DonViPhanPhoi;
    }

    public String getToa() {
        return Toa;
    }

    public void setToa(String Toa) {
        this.Toa = Toa;
    }

}
