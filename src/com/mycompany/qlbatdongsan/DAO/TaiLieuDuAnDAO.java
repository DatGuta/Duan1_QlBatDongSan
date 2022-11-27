package com.mycompany.qlbatdongsan.DAO;

import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.TaiLieuDuAN;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaiLieuDuAnDAO extends QLBDSDAO<TaiLieuDuAN, String> {

    final String INSERT_SQL = "INSERT INTO TaiLieuDuAN (tenTaiLieu, dienGiai, ngayCapNhat, maSPDA,maNV,maKH,hinh,maDA) VALUES (?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE TaiLieuDuAN SET tenTaiLieu = ?, dienGiai = ?, ngayCapNhat = ?, maSPDA = ?, maKH = ?, hinh = ?, maDA=? WHERE kyHieu = ?";
    final String DELETE_SQL = "DELETE FROM TaiLieuDuAN WHERE kyHieu = ?";
    final String DELETE_SQL_Name_Image = "DELETE FROM TaiLieuDuAN WHERE hinh = ? and maDA  ?";
    final String SELECT_ALL_SQL = "SELECT * FROM TaiLieuDuAN";
    final String SELECT_BY_ID_SQL = "SELECT *FROM TaiLieuDuAN WHERE kyHieu = ?";
    final String SELECT_BY_ID_DA_SQL = "SELECT *FROM TaiLieuDuAN WHERE maDA = ?";
    final String SELECT_BY_ID_SPDA_SQL = "SELECT *FROM TaiLieuDuAN WHERE maSPDA = ?";

    @Override
    public void insert(TaiLieuDuAN entity) {
        JdbcHelper.update(INSERT_SQL, entity.getTenTaiLieu(), entity.getDienGiai(), entity.getNgayCapNhat(), entity.getMaSPDA(), entity.getNhanVien(), entity.getMaKH(), entity.getHinh(), entity.getMaDA());
    }

    @Override
    public void update(TaiLieuDuAN entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenTaiLieu(), entity.getDienGiai(), entity.getNhanVien(), entity.getNgayCapNhat(), entity.getMaSPDA(), entity.getMaKH(), entity.getHinh(), entity.getMaDA(), entity.getKyHieu());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    public void deleteImage(String nameImage, String id) {
        JdbcHelper.update(DELETE_SQL_Name_Image, nameImage, id);
    }

    @Override
    public List<TaiLieuDuAN> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TaiLieuDuAN selectById(String id) {
        List<TaiLieuDuAN> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<TaiLieuDuAN> selectByIdmaDA(String id) {
        List<TaiLieuDuAN> list = selectBySql(SELECT_BY_ID_DA_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    public List<TaiLieuDuAN> selectByIdmaSPDA(String id) {
        List<TaiLieuDuAN> list = selectBySql(SELECT_BY_ID_SPDA_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<TaiLieuDuAN> selectBySql(String sql, Object... args) {
        List<TaiLieuDuAN> list = new ArrayList<TaiLieuDuAN>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                TaiLieuDuAN entity = new TaiLieuDuAN();
                entity.setKyHieu(rs.getString("kyHieu"));
                entity.setTenTaiLieu(rs.getString("tenTaiLieu"));
                entity.setDienGiai(rs.getString("dienGiai"));
                entity.setNgayCapNhat(rs.getDate("ngayCapNhat"));
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setMaKH(rs.getString("maKH"));
                entity.setHinh(rs.getString("hinh"));
                entity.setMaDA(rs.getString("maDA"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
