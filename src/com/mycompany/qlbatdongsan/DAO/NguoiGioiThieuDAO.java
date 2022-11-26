package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.NguoiGioiThieu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NguoiGioiThieuDAO extends QLBDSDAO<NguoiGioiThieu, Integer> {
    final String INSERT_SQL = "INSERT INTO NguoiGioiThieu (maGT, hoTen, SdtCoDinh, SdtDiDong, Email, diaChiLienLac, diaChiThuongTru, gioiTinh, ngaySinh, maKH) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NguoiGioiThieu SET hoTen = ?, SdtCoDinh = ?, SdtDiDong = ?, Email = ?, diaChiLienLac = ?, diaChiThuongTru = ?, gioiTinh = ?, ngaySinh = ?, maKH = ? WHERE maGT = ?";
    final String DELETE_SQL = "DELETE FROM NguoiGioiThieu WHERE maGT = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NguoiGioiThieu";
    final String SELECT_BY_ID_SQL = "SELECT *FROM NguoiGioiThieu WHERE maGT = ?";

    @Override
    public void insert(NguoiGioiThieu entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaGT(), entity.getHoTen(), entity.getSdtCoDinh(), entity.getSdtDiDong(), entity.getEmail(), entity.getDiaChiLienLac(),
                entity.getDiaChiThuongTru(), entity.getGioiTinh(), entity.getNgaySinh(), entity.getMaKH());
    }

    @Override
    public void update(NguoiGioiThieu entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getHoTen(), entity.getSdtCoDinh(), entity.getSdtDiDong(), entity.getEmail(), entity.getDiaChiLienLac(),
                entity.getDiaChiThuongTru(), entity.getGioiTinh(), entity.getNgaySinh(), entity.getMaKH(),entity.getMaGT());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NguoiGioiThieu> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NguoiGioiThieu selectById(Integer id) {
        List<NguoiGioiThieu> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiGioiThieu> selectBySql(String sql, Object... args) {
        List<NguoiGioiThieu> list = new ArrayList<NguoiGioiThieu>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiGioiThieu entity = new NguoiGioiThieu();
                entity.setMaGT(rs.getInt("maGT"));
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
