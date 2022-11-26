package com.mycompany.qlbatdongsan.DAO;

import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.Entity.ChinhSachBanHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
public class ChinhSachBanHangDAO extends QLBDSDAO<ChinhSachBanHang, String> {

    final String INSERT_SQL = "INSERT INTO ChinhSachBanHang (soHieu, ngayBatDau, ngayKetThuc, loaiChinhSach, soLuong, dieuKien, "
            + "chietKhau , tienThuongPhat, dienGiai, maSPDA) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ChinhSachBanHang SET ngayBatDau = ?, ngayKetThuc = ?, loaiChinhSach = ?, soLuong = ?, dieuKien = ?, "
            + "chietKhau = ?, tienThuongPhat = ?, dienGiai = ?, maSPDA = ? WHERE soHieu = ?";
    final String DELETE_SQL = "DELETE FROM ChinhSachBanHang WHERE soHieu = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM ChinhSachBanHang";
    final String SELECT_BY_ID_SQL = "SELECT *FROM ChinhSachBanHang WHERE soHieu = ?";

    @Override
    public void insert(ChinhSachBanHang entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSoHieu(), entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getLoaiChinhSach(), entity.getSoLuong(),
                entity.getSoLuong(), entity.getDieuKien(), entity.getChietKhau(), entity.getTienThuongPhat(), entity.getDienGiai(), entity.getMaSPDA());
    }

    @Override
    public void update(ChinhSachBanHang entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getNgayBatDau(), entity.getNgayKetThuc(), entity.getLoaiChinhSach(), entity.getSoLuong(),
                entity.getSoLuong(), entity.getDieuKien(), entity.getChietKhau(), entity.getTienThuongPhat(), entity.getDienGiai(), entity.getMaSPDA(),
                entity.getSoHieu());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ChinhSachBanHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChinhSachBanHang selectById(String id) {
        List<ChinhSachBanHang> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChinhSachBanHang> selectBySql(String sql, Object... args) {
        List<ChinhSachBanHang> list = new ArrayList<ChinhSachBanHang>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChinhSachBanHang entity = new ChinhSachBanHang();
                entity.setSoHieu(rs.getString("soHieu"));
                entity.setNgayBatDau(rs.getDate("ngayBatDau"));
                entity.setNgayKetThuc(rs.getDate("ngayKetThuc"));
                entity.setLoaiChinhSach(rs.getString("loaiChinhSach"));
                entity.setSoLuong(rs.getFloat("soLuong"));
                entity.setDieuKien(rs.getString("dieuKien"));
                entity.setChietKhau(rs.getFloat("chietKhau"));
                entity.setTienThuongPhat(rs.getFloat("tienThuongPhat"));
                entity.setDienGiai(rs.getString("dienGiai"));
                entity.setMaSPDA(rs.getString("maSPDA"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
