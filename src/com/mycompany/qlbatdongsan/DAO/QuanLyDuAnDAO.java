package com.mycompany.qlbatdongsan.DAO;



import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDuAnDAO extends QLBDSDAO<QuanLyDuAn, String>{
    final String INSERT_SQL = "INSERT INTO QuanLyDuAn VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE QuanLyDuAn SET ngayDang = ?, tenDA = ?, diaChi = ?, tongDienTich = ?, tongDienTichSan=?, dienTichKhuCanHo=?, dienTichKhuThuongMai=?, matDo=?, tongVonDauTu=?, phapLy=?, tieuChuanBanGiao=?, donViTuVanKT=?, kienTrucThietKe=?, quyMo=?, khoiCong=?, hoanThien=?, banGiao=?, maNVPhuTrach=?, chuDauTu=?, loaiHinhSanPham=?, soLuongSanPham=?  WHERE maDA = ?";
    final String DELETE_SQL = "DELETE FROM QuanLyDuAn WHERE maDA = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM QuanLyDuAn";
    final String SELECT_BY_ID_SQL = "SELECT *FROM QuanLyDuAn WHERE maDA = ?";

    @Override
    public void insert(QuanLyDuAn entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaDA(), entity.getNgayDang(), entity.getTenDA(), entity.getDiaChi(),entity.getTongDienTich(),entity.getTongDienTichSan(),entity.getTongDienTichCanHo(),entity.getTongdienTichKhuThuongMai(),entity.getMatDo(),entity.getTongVonDauTu(),entity.getPhapLy(),entity.getTieuChuanBanGia(),entity.getDonViTuVanKT(),entity.getQuyMo(),entity.getKhoiCong(),entity.getHoanThien(),entity.getBanGiao(),entity.getMaNVPhuTrach(),entity.getChuDauTu(),entity.getLoaiHinhSP(),entity.getSoLuongSanPham());
    }

    @Override
    public void update(QuanLyDuAn entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getNgayDang(), entity.getTenDA(), entity.getDiaChi(),entity.getTongDienTich(),entity.getTongDienTichSan(),entity.getTongDienTichCanHo(),entity.getTongdienTichKhuThuongMai(),entity.getMatDo(),entity.getTongVonDauTu(),entity.getPhapLy(),entity.getTieuChuanBanGia(),entity.getDonViTuVanKT(),entity.getKienTrucThietKe(),entity.getQuyMo(),entity.getKhoiCong(),entity.getHoanThien(),entity.getBanGiao(),entity.getMaNVPhuTrach(),entity.getChuDauTu(),entity.getLoaiHinhSP(),entity.getSoLuongSanPham(),entity.getMaDA());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<QuanLyDuAn> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public QuanLyDuAn selectById(String id) {
        List<QuanLyDuAn> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QuanLyDuAn> selectBySql(String sql, Object... args) {
        List<QuanLyDuAn> list = new ArrayList<QuanLyDuAn>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                QuanLyDuAn entity = new QuanLyDuAn();
                entity.setMaDA(rs.getString("maDa"));
                entity.setNgayDang(rs.getDate("ngayDang"));
                entity.setTenDA(rs.getString("tenDA"));
                entity.setDiaChi(rs.getString("diaChi"));
                entity.setBanGiao(rs.getString("banGiao"));
                entity.setChuDauTu(rs.getString("chuDauTu"));
                entity.setDonViTuVanKT(rs.getString("donViTuVanKT"));
                entity.setHoanThien(rs.getString("hoanThien"));
                entity.setKhoiCong(rs.getString("khoiCong"));
                entity.setKienTrucThietKe(rs.getString("kienTrucThietKe"));
                entity.setMaNVPhuTrach(rs.getString("maNVPhuTrach"));
                entity.setMatDo(rs.getDouble("matDo"));
                entity.setPhapLy(rs.getString("phapLy"));
                entity.setTieuChuanBanGiao(rs.getString("tieuChuanBanGiao"));
                entity.setTongDienTich(rs.getDouble("tongDienTich"));
                entity.setTongDienTichSan(rs.getDouble("tongDienTichSan"));
                entity.setTongDienTichCanHo(rs.getDouble("dienTichKhuCanHo"));
                entity.setTongdienTichKhuThuongMai(rs.getDouble("dienTichKhuThuongMai"));
                entity.setTongVonDauTu(rs.getDouble("tongVonDauTu"));
                entity.setQuyMo(rs.getString("quyMo"));
                entity.setLoaiHinhSP(rs.getString("loaiHinhSanPham"));
                entity.setSoLuongSanPham(rs.getString("soLuongSanPham"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
