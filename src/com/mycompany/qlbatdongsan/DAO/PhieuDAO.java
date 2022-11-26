package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.Phieu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhieuDAO extends QLBDSDAO<Phieu, String> {

    final String INSERT_SQL = "INSERT INTO Phieu (maPhieu, ngayCoc, maSPDA, donGia, dienTich, soLoCoc, thanhTien, tienCoc, maNV, maKH, loaiPhieu) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Phieu SET ngayCoc = ?, maSPDA = ?, donGia = ?, dienTich = ?, soLoCoc = ?, thanhTien = ?, tienCoc = ?, maNV = ?, maKH = ?, loaiPhieu = ? WHERE maPhieu = ?";
    final String DELETE_SQL = "DELETE FROM Phieu WHERE maPhieu = ?" ;
    final String SELECT_ALL_SQL = "SELECT * FROM Phieu";
    final String SELECT_BY_ID_SQL = "SELECT *FROM Phieu WHERE maPhieu = ?";

    @Override
    public void insert(Phieu entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaPhieu(), entity.getNgayCoc(), entity.getMaSPDA(), entity.getDonGia(), entity.getDienTich(), entity.getSoLoCoc(),
                entity.getThanhTien(), entity.getTienCoc(), entity.getMaNV(), entity.getMaKH(), entity.getLoaiPhieu());
    }

    @Override
    public void update(Phieu entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getNgayCoc(), entity.getMaSPDA(), entity.getDonGia(), entity.getDienTich(), entity.getSoLoCoc(),
                entity.getThanhTien(), entity.getTienCoc(), entity.getMaNV(), entity.getMaKH(), entity.getLoaiPhieu(), entity.getMaPhieu());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Phieu> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Phieu selectById(String id) {
        List<Phieu> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Phieu> selectBySql(String sql, Object... args) {
        List<Phieu> list = new ArrayList<Phieu>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Phieu entity = new Phieu();
                entity.setMaPhieu(rs.getString("maPhieu"));
                entity.setNgayCoc(rs.getDate("ngayCoc"));
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setDonGia(rs.getDouble("donGia"));
                entity.setDienTich(rs.getFloat("dienTich"));
                entity.setSoLoCoc(rs.getInt("soLoCoc"));
                entity.setThanhTien(rs.getDouble("thanhTien"));
                entity.setTienCoc(rs.getDouble("tienCoc"));
                entity.setMaNV(rs.getString("maNV"));
                entity.setMaKH(rs.getString("maKH"));
                entity.setLoaiPhieu(rs.getString("loaiPhieu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
