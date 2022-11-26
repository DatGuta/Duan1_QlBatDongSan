
package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.Entity.ChinhSachBanHang;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.HopDong;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HopDongDAO extends QLBDSDAO<HopDong, String>{
   final String INSERT_SQL = "INSERT INTO HopDong ("
           + "soHopDong, STT, ngayKy, dienTich, donGia, thanhTien, soPhieu, maSPDA, trangThai, maKH) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HopDong SET "
            + "STT = ?, ngayKy = ?, dienTich = ?, donGia = ?, thanhTien = ?, soPhieu = ?, maSPDA = ?, trangThai = ?, maKH WHERE soHopDong = ?";
    final String DELETE_SQL = "DELETE FROM HopDong WHERE soHopDong = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM HopDong";
    final String SELECT_BY_ID_SQL = "SELECT *FROM HopDong WHERE soHopDong = ?";

    @Override
    public void insert(HopDong entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSoHopDong(), entity.getSTT(), entity.getNgayKy(), entity.getDienTich(), entity.getDonGia(), entity.getThanhTien(),
                entity.getSoPhieu(), entity.getMaSPDA(), entity.getTrangThai(), entity.getMaKH());
    }

    @Override
    public void update(HopDong entity) {
        JdbcHelper.update(UPDATE_SQL,  entity.getSTT(), entity.getNgayKy(), entity.getDienTich(), entity.getDonGia(), entity.getThanhTien(),
                entity.getSoPhieu(), entity.getMaSPDA(), entity.getTrangThai(), entity.getMaKH(), entity.getSoHopDong());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HopDong> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HopDong selectById(String id) {
        List<HopDong> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HopDong> selectBySql(String sql, Object... args) {
        List<HopDong> list = new ArrayList<HopDong>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HopDong entity = new HopDong();
                entity.setSoHopDong(rs.getString("soHopDong"));
                entity.setSTT(rs.getInt("STT"));
                entity.setNgayKy(rs.getDate("ngayKy"));
                entity.setDienTich(rs.getFloat("dienTich"));
                entity.setDonGia(rs.getDouble("donGia"));
                entity.setThanhTien(rs.getDouble("thanhTien"));
                entity.setSoPhieu(rs.getString("soPhieu"));
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setTrangThai(rs.getString("trangThai"));
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
