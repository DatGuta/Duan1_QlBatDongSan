package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.Entity.NguoiDaiDien;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NguoiDaiDienDAO extends QLBDSDAO<NguoiDaiDien, Integer>{
     final String INSERT_SQL = "INSERT INTO NguoiDaiDien (maDD, hoTen, SdtCoDinh, SdtDiDong, Email, diaChiLienLac, diaChiThuongTru, gioiTinh, ngaySinh) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NguoiDaiDien SET hoTen = ?, SdtCoDinh = ?, SdtDiDong = ?, Email = ?, diaChiLienLac = ?, diaChiThuongTru = ?, gioiTinh = ?, ngaySinh = ? WHERE soHieu = ?";
    final String DELETE_SQL = "DELETE FROM NguoiDaiDien WHERE maDD = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NguoiDaiDien";
    final String SELECT_BY_ID_SQL = "SELECT *FROM NguoiDaiDien WHERE maDD = ?";

    @Override
    public void insert(NguoiDaiDien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaDD(), entity.getHoTen(), entity.getSdtCoDinh(), entity.getSdtDiDong(), entity.getEmail(), entity.getDiaChiLienLac(),
                entity.getDiaChiThuongTru(), entity.getGioiTinh(), entity.getNgaySinh(), entity.getMaKH());
    }

    @Override
    public void update(NguoiDaiDien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getHoTen(), entity.getSdtCoDinh(), entity.getSdtDiDong(), entity.getEmail(), entity.getDiaChiLienLac(),
                entity.getDiaChiThuongTru(), entity.getGioiTinh(), entity.getNgaySinh(), entity.getMaKH(), entity.getMaDD());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NguoiDaiDien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiDaiDien selectById(Integer id) {
        List<NguoiDaiDien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiDaiDien> selectBySql(String sql, Object... args) {
        List<NguoiDaiDien> list = new ArrayList<NguoiDaiDien>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiDaiDien entity = new NguoiDaiDien();
                entity.setMaDD(rs.getInt("maDD"));
                entity.setHoTen(rs.getString("hoTen"));
                entity.setSdtCoDinh(rs.getString("SdtCoDinh"));
                entity.setSdtDiDong(rs.getString("SdtDiDong"));
                entity.setEmail(rs.getString("email"));
                entity.setDiaChiLienLac(rs.getString("diaChiLienLac"));
                entity.setDiaChiThuongTru(rs.getString("diaChiThuongTru"));
                entity.setGioiTinh(rs.getBoolean("gioiTinh"));
                entity.setNgaySinh(rs.getDate("ngaySinh"));
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
