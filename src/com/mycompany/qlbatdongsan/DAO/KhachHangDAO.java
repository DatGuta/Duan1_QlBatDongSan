package com.mycompany.qlbatdongsan.DAO;



import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.KhachHang;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO extends QLBDSDAO<KhachHang, String>{
    final String INSERT_SQL = "INSERT INTO KhachHang (maKH, STT, danhXung, hoTenDem, ten, ngaySinh, Sdt, diaChiLienLac, diaChiThuongTru, Email, maThue, loai, CCCD, gioiTinh) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhachHang SET STT = ?, danhXung= ?, hoTenDem = ?, ten = ?, ngaySinh = ?, Sdt = ?, diaChiLienLac = ?, diaChiThuongTru= ? , Email = ?, maThue = ?, loai = ?, CCCD = ?,"
            + " gioiTinh = ? WHERE maKH = ?";
    final String DELETE_SQL = "DELETE FROM KhachHang WHERE maKH = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    final String SELECT_BY_ID_SQL = "SELECT *FROM KhachHang WHERE maKH = ?";
    final String SELECT_BY_NAME="select top 7 hoTenDem+' '+ten as 'hoTenDem', coalesce((select top 1 StoryID from story where hoTenDem+' '+ten = StoryName),'') as Story from KHACHHANG where hoTenDem+' '+ten like ?  group by hoTenDem+' '+ten  order by Story desc";

    @Override
    public void insert(KhachHang entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaKH(), entity.getSTT(), entity.getDanhXung(), entity.getHoTenDem(), entity.getTen(), entity.getNgaySinh(),
                entity.getSdt(), entity.getDiaChiLienLac(), entity.getDiaChiThuongTru(), entity.getEmail(), entity.getMaThue(), entity.getLoai(),
                entity.getCCCD(), entity.getGioiTinh());
    }

    @Override
    public void update(KhachHang entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSTT(), entity.getDanhXung(), entity.getHoTenDem(), entity.getTen(), entity.getNgaySinh(),
                entity.getSdt(), entity.getDiaChiLienLac(), entity.getDiaChiThuongTru(), entity.getEmail(), entity.getMaThue(), entity.getLoai(),
                entity.getCCCD(), entity.getGioiTinh(), entity.getMaKH());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
     public KhachHang selectByName(String name) {
        List<KhachHang> list = selectBySql(SELECT_BY_NAME, "%"+name+"%");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("maKH"));
                entity.setSTT(rs.getInt("STT"));
                entity.setDanhXung(rs.getString("danhXung"));
                entity.setHoTenDem(rs.getString("hoTenDem"));
                entity.setTen(rs.getString("ten"));
                entity.setNgaySinh(rs.getDate("ngaySinh"));
                entity.setSdt(rs.getString("Sdt"));
                entity.setDiaChiLienLac(rs.getString("diaChiLienLac"));
                entity.setDiaChiThuongTru(rs.getString("diaChiThuongTru"));
                entity.setEmail(rs.getString("Email"));
                entity.setMaThue(rs.getString("maThue"));
                entity.setLoai(rs.getString("loai"));
                entity.setCCCD(rs.getString("CCCD"));
                entity.setGioiTinh(rs.getBoolean("gioiTinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
