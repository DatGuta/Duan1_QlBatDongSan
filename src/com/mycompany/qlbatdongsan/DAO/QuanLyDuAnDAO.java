package com.mycompany.qlbatdongsan.DAO;



import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.QuanLyDuAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDuAnDAO extends QLBDSDAO<QuanLyDuAn, String>{
    final String INSERT_SQL = "INSERT INTO QuanLyDuAn (maDA, ngayDang, tenDA, diaChi, dienTich, soGiayPhep, ngayCap, noiCap, loaiDA, maNVPhuTrach) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE QuanLyDuAn SET ngayDang = ?, tenDA = ?, diaChi = ?, dienTich = ?, soGiayPhep = ?, ngayCap = ?, noiCap = ?, loaiDA = ?, maNVPhuTrach = ? WHERE maDA = ?";
    final String DELETE_SQL = "DELETE FROM QuanLyDuAn WHERE maDA = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM QuanLyDuAn";
    final String SELECT_BY_ID_SQL = "SELECT *FROM QuanLyDuAn WHERE maDA = ?";

    @Override
    public void insert(QuanLyDuAn entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaDA(), entity.getNgayDang(), entity.getTenDA(), entity.getDiaChi(),entity.getDienTich(), entity.getSoGiayPhep(), entity.getNgayCap(), entity.getNoiCap(),
                entity.getLoaiDA(), entity.getMaNVPhuTrach());
    }

    @Override
    public void update(QuanLyDuAn entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getNgayDang(), entity.getTenDA(), entity.getDiaChi(), entity.getSoGiayPhep(), entity.getNgayCap(), entity.getNoiCap(),
                entity.getLoaiDA(), entity.getMaNVPhuTrach(), entity.getMaDA());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<QuanLyDuAn> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public QuanLyDuAn selectById(String id) {
        List<QuanLyDuAn> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QuanLyDuAn> selectBySql(String sql, Object... args) {
        List<QuanLyDuAn> list = new ArrayList<QuanLyDuAn>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                QuanLyDuAn entity = new QuanLyDuAn();
                entity.setMaDA(rs.getString("maDa"));
                entity.setNgayDang(rs.getDate("ngayDang"));
                entity.setTenDA(rs.getString("tenDA"));
                entity.setDiaChi(rs.getString("diaChi"));
                entity.setDienTich(rs.getFloat("dienTich"));
                entity.setSoGiayPhep(rs.getInt("soGiayPhep"));
                entity.setNgayCap(rs.getDate("ngayCap"));
                entity.setNoiCap(rs.getString("noiCap"));
                entity.setLoaiDA(rs.getString("loaiDA"));
                entity.setMaNVPhuTrach(rs.getString("maNVPhuTrach"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
