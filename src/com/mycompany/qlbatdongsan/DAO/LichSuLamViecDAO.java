package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.LichSuLamViec;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LichSuLamViecDAO extends QLBDSDAO<LichSuLamViec, String> {

    final String INSERT_SQL = "INSERT INTO LichSuLamViec (maLSLV, STT, tieuDe, maNV, ngayBatDau, ngayKetThuc, maKH) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE LichSuLamViec SET STT, tieuDe, maNV, ngayBatDau, ngayKetThuc, maKH WHERE maLSLV = ?";
    final String DELETE_SQL = "DELETE FROM LichSuLamViec WHERE maLSLV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM LichSuLamViec";
    final String SELECT_BY_ID_SQL = "SELECT *FROM LichSuLamViec WHERE maLSLV = ?";

    @Override
    public void insert(LichSuLamViec entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaLSLV(), entity.getSTT(), entity.getMaNV(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getMaKH());
    }

    @Override
    public void update(LichSuLamViec entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSTT(), entity.getMaNV(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getMaKH(), entity.getMaLSLV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<LichSuLamViec> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LichSuLamViec selectById(String id) {
        List<LichSuLamViec> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LichSuLamViec> selectBySql(String sql, Object... args) {
        List<LichSuLamViec> list = new ArrayList<LichSuLamViec>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                LichSuLamViec entity = new LichSuLamViec();
                entity.setMaLSLV(rs.getString("maLSLV"));
                entity.setSTT(rs.getInt("STT"));
                entity.setTieuDe(rs.getString("tieuDe"));
                entity.setMaNV(rs.getString("maNV"));
                entity.setNgayBatDau(rs.getDate("ngayBatDau"));
                entity.setNgayKetThuc(rs.getDate("ngayKetThuc"));
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
