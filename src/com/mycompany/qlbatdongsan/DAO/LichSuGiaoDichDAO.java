package com.mycompany.qlbatdongsan.DAO;




import com.mycompany.qlbatdongsan.Entity.LichSuGiaoDich;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.LichSuGiaoDich;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LichSuGiaoDichDAO extends QLBDSDAO<LichSuGiaoDich, String> {
    final String INSERT_SQL = "INSERT INTO LichSuGiaoDich  VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE LichSuGiaoDich SET ngayGD = ?, maGD = ?, loaiGD = ?, maSPDA = ?, dienTich = ?, thanhTien = ?, dienGiai= ?"
            + ", nhanVien = ?, sanGiaoDich = ?, maKH WHERE maLSGD = ?";
    final String DELETE_SQL = "DELETE FROM LichSuGiaoDich WHERE maLSGD = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM LichSuGiaoDich";
    final String SELECT_BY_ID_SQL = "SELECT *FROM LichSuGiaoDich WHERE maLSGD = ?";
    final String SELECT_BY_maKH_SQL = "SELECT *FROM LichSuGiaoDich WHERE maKH = ?";

    @Override
    public void insert(LichSuGiaoDich entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaLSGD(), entity.getNgayGD(), entity.getSoGD(), entity.getLoaiGD(), entity.getMaSPDA(), entity.getDienTich(), entity.getThanhTien(),
                entity.getDienGiai(), entity.getNhanVien(), entity.getSanGiaoDich());
    }

    @Override
    public void update(LichSuGiaoDich entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getNgayGD(), entity.getSoGD(), entity.getLoaiGD(), entity.getMaSPDA(), entity.getDienTich(), entity.getThanhTien(),
                entity.getDienGiai(), entity.getNhanVien(), entity.getSanGiaoDich(),entity.getMaLSGD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<LichSuGiaoDich> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LichSuGiaoDich selectById(String id) {
        List<LichSuGiaoDich> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<LichSuGiaoDich> selectBymaKH(String id) {
        List<LichSuGiaoDich> list = selectBySql(SELECT_BY_maKH_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<LichSuGiaoDich> selectBySql(String sql, Object... args) {
        List<LichSuGiaoDich> list = new ArrayList<LichSuGiaoDich>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                LichSuGiaoDich entity = new LichSuGiaoDich();
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setNgayGD(rs.getDate("ngayGD"));
                entity.setSoGD(rs.getString("maGD"));
                entity.setLoaiGD(rs.getString("loaiGD"));
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setDienTich(rs.getFloat("dienTich"));
                entity.setThanhTien(rs.getDouble("thanhTien"));
                entity.setDienGiai(rs.getString("dienGiai"));
                entity.setNhanVien(rs.getString("nhanVien"));
                entity.setSanGiaoDich(rs.getString("sanGiaoDich"));
                entity.setMaKH(rs.getString("maKH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
