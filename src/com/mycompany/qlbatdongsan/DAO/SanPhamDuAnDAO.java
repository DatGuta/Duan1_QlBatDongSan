package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.SanPhamDuAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDuAnDAO extends QLBDSDAO<SanPhamDuAn, String> {

    final String INSERT_SQL = "INSERT INTO SanPhamDuAn (maSPDA, maDA, tenDA, diaChi, dienTich, soGiayPhep, ngayCap, noiCap, loaiDA, maNVPhuTrach, ngayDang, maSGD,trangThai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE SanPhamDuAn SET  maDA=?, tenDA=?, diaChi=?, dienTich=?, soGiayPhep=?, ngayCap=?, noiCap=?, loaiDA=?, maNVPhuTrach=?, ngayDang=?, maSGD=?,trangThai=? WHERE maSPDA = ?";
    final String DELETE_SQL = "DELETE FROM SanPhamDuAn WHERE maSPDA = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SanPhamDuAn";
    final String SELECT_BY_ID_SQL = "SELECT *FROM SanPhamDuAn WHERE maSPDA = ?";

    @Override
    public void insert(SanPhamDuAn entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaSPDA(), entity.getMaDA(), entity.getTenDA(), entity.getDiaChi(), entity.getDienTich(), entity.getSoGiayPhep(), entity.getNgayCap(),
                entity.getNoiCap(), entity.getLoaiDA(), entity.getMaNVPhuTrach(), entity.getNgayDang(), entity.getMaSGD(),entity.getTrangThai());
    }

    @Override
    public void update(SanPhamDuAn entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaDA(), entity.getTenDA(), entity.getDiaChi(), entity.getDienTich(), entity.getSoGiayPhep(), entity.getNgayCap(),
                entity.getNoiCap(), entity.getLoaiDA(), entity.getMaNVPhuTrach(), entity.getNgayDang(), entity.getMaSGD(),entity.getTrangThai(), entity.getMaSPDA());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPhamDuAn> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPhamDuAn selectById(String id) {
        List<SanPhamDuAn> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPhamDuAn> selectBySql(String sql, Object... args) {
        List<SanPhamDuAn> list = new ArrayList<SanPhamDuAn>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SanPhamDuAn entity = new SanPhamDuAn();
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setMaDA(rs.getString("maDa"));
                entity.setTenDA(rs.getString("tenDA"));
                entity.setDiaChi(rs.getString("diaChi"));
                entity.setDienTich(rs.getFloat("dienTich"));
                entity.setSoGiayPhep(rs.getInt("soGiayPhep"));
                entity.setNgayCap(rs.getDate("ngayCap"));
                entity.setNoiCap(rs.getString("noiCap"));
                entity.setLoaiDA(rs.getString("loaiDA"));
                entity.setMaNVPhuTrach(rs.getString("maNVPhuTrach"));
                entity.setNgayDang(rs.getDate("ngayDang"));
                entity.setMaSGD(rs.getInt("maSGD"));
                entity.setTrangThai(rs.getString("trangThai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
