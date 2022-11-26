
package com.mycompany.qlbatdongsan.DAO;
import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.Entity.ChuyenNhuong;

import com.mycompany.qlbatdongsan.Entity.ChinhSachBanHang;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ChuyenNhuongDAO extends QLBDSDAO<ChuyenNhuong, Integer > {
    final String INSERT_SQL = "INSERT INTO ChuyenNhuong (maCN, soHopDong, khachHang, maSanPham, giaBan, chietKhau, cong, phiMoiGioi, thoiHan"
            + "ngayNhap) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ChuyenNhuong SET soHopDong = ?, khachHang = ?, maSanPham = ?, giaBan = ?, chietKhau = ?, cong = ?, phiMoiGioi = ?, thoiHan = ?"
            + "ngayNhap = ?  WHERE maCN = ?";
    final String DELETE_SQL = "DELETE FROM ChuyenNhuong WHERE maCN = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM ChuyenNhuong";
    final String SELECT_BY_ID_SQL = "SELECT *FROM ChuyenNhuong WHERE maCN = ?";

    @Override
    public void insert(ChuyenNhuong entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaCN(), entity.getSoHopDong(), entity.getKhachHang(), entity.getMaSanPham(), entity.getGiaBan(), entity.getChietKhau(),
                entity.getCong(), entity.getPhiMoiGioi(), entity.getThoiHan(), entity.getNgayNhap());
    }

    @Override
    public void update(ChuyenNhuong entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSoHopDong(), entity.getKhachHang(), entity.getMaSanPham(), entity.getGiaBan(), entity.getChietKhau(),
                entity.getCong(), entity.getPhiMoiGioi(), entity.getThoiHan(), entity.getNgayNhap(), entity.getMaCN());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ChuyenNhuong> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChuyenNhuong selectById(Integer id) {
        List<ChuyenNhuong> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenNhuong> selectBySql(String sql, Object... args) {
        List<ChuyenNhuong> list = new ArrayList<ChuyenNhuong>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChuyenNhuong entity = new ChuyenNhuong();
                entity.setMaCN(rs.getInt("maCN"));
                entity.setSoHopDong(rs.getString("soHopDong"));
                entity.setKhachHang(rs.getString("khachHang"));
                entity.setMaSanPham(rs.getString("maSanPham"));
                entity.setGiaBan(rs.getDouble("giaBan"));
                entity.setChiecKhau(rs.getFloat("chietKhau"));
                entity.setCong(rs.getDouble("cong"));
                entity.setPhiMoiGioi(rs.getDouble("phiMoiGioi"));
                entity.setThoiHan(rs.getDate("thoiHan"));
                entity.setNgayNhap(rs.getDate("ngayNhap"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
