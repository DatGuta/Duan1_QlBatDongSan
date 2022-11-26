package com.mycompany.qlbatdongsan.DAO;



import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.Entity.NhanVien;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends QLBDSDAO<NhanVien, String> {

    final String INSERT_SQL = "INSERT INTO NhanVien (maNV, maQR, maSGD, hoTen, ngaySinh, Sdt, soNoiBo, chucDanh, matKhau, maQuanLy, gioiTinh, lockCheckBox) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NhanVien SET maQR = ?, maSGD = ?, hoTen = ?, ngaySinh =?, Sdt = ?, soNoiBo = ?, chucDanh = ?, matKhau = ?, maQuanLy = ?, gioiTinh = ?, lockCheckBox = ? WHERE maNV = ?";
    final String DELETE_SQL = "DELETE FROM NhanVien WHERE maNV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL = "SELECT *FROM NhanVien WHERE maNV = ?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaNV(), entity.getMaQR(), entity.getMaSGD(), entity.getHoTen(), entity.getNgaySinh(), entity.getSdt(),
                entity.getSoNoiBo(), entity.getChucDanh(), entity.getMatKhau(), entity.getMaQuanLy(), entity.getGioiTinh(), entity.getLockCheckBox());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaQR(), entity.getMaSGD(), entity.getHoTen(), entity.getNgaySinh(), entity.getSdt(),
                entity.getSoNoiBo(), entity.getChucDanh(), entity.getMatKhau(), entity.getMaQuanLy(), entity.getGioiTinh(), entity.getLockCheckBox(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("maNV"));
                entity.setMaQR(rs.getString("maQR"));
                entity.setMaSGD(rs.getInt("maSGD"));
                entity.setHoTen(rs.getString("hoTen"));
                entity.setNgaySinh(rs.getDate("ngaySinh"));
                entity.setSdt(rs.getString("Sdt"));
                entity.setSoNoiBo(rs.getString("soNoiBo"));
                entity.setChucDanh(rs.getString("chucDanh"));
                entity.setMatKhau(rs.getString("matKhau"));
                entity.setMaQuanLy(rs.getString("maQuanLy"));
                entity.setGioiTinh(rs.getBoolean("gioiTinh"));
                entity.setLockCheckBox(rs.getBoolean("lockCheckBox"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
