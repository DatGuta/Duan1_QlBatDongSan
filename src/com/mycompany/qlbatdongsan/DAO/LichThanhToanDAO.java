package com.mycompany.qlbatdongsan.DAO;



import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.LichSuThanhToan;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LichThanhToanDAO extends QLBDSDAO<LichSuThanhToan, String> {
    final String INSERT_SQL = "INSERT INTO LichSuThanhToan (maTT, ngayTT, tyLeTT, kieuTT, tamUng, thueVat, daThu, conLai, dienGiai, maSPDA, maKH) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE LichSuThanhToan SET ngayTT = ?, tyLeTT = ?, kieuTT = ?, tamUng = ?, thueVat = ?, daThu = ?, conLai = ?, dienGiai = ?, maSPDA = ? , maKH = ? WHERE  maTT = ?";
    final String DELETE_SQL = "DELETE FROM LichSuThanhToan WHERE maTT = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM LichSuThanhToan";
    final String SELECT_BY_ID_SQL = "SELECT *FROM LichSuThanhToan WHERE maTT = ?";
    final String SELECT_BY_maKH_SQL = "SELECT *FROM LichSuThanhToan WHERE maKH = ?";

    @Override
    public void insert(LichSuThanhToan entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaTT(), entity.getNgayTT(), entity.getTyLeTT(), entity.getKieuTT(), entity.getTamUng(), entity.getThueVAT(),
                entity.getDaThu(), entity.getConLai(), entity.getDienGiai(), entity.getMaSPDA() ,entity.getMaKH());
    }

    @Override
    public void update(LichSuThanhToan entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getNgayTT(), entity.getTyLeTT(), entity.getKieuTT(), entity.getTamUng(), entity.getThueVAT(),
                entity.getDaThu(), entity.getConLai(), entity.getDienGiai(), entity.getMaSPDA() ,entity.getMaKH(), entity.getMaTT());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<LichSuThanhToan> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LichSuThanhToan selectById(String id) {
        List<LichSuThanhToan> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<LichSuThanhToan> selectBymaKH(String id) {
        List<LichSuThanhToan> list = selectBySql(SELECT_BY_maKH_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    @Override
    public List<LichSuThanhToan> selectBySql(String sql, Object... args) {
        List<LichSuThanhToan> list = new ArrayList<LichSuThanhToan>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                LichSuThanhToan entity = new LichSuThanhToan();
                entity.setMaTT(rs.getString("maTT"));
                entity.setNgayTT(rs.getDate("ngayTT"));
                entity.setTyLeTT(rs.getFloat("tyLeTT"));
                entity.setKieuTT(rs.getString("kieuTT"));
                entity.setTamUng(rs.getFloat("tamUng"));
                entity.setThueVAT(rs.getFloat("thueVat"));
                entity.setDaThu(rs.getFloat("daThu"));
                entity.setConLai(rs.getFloat("conLai"));
                entity.setDienGiai(rs.getString("dienGiai"));
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setMaKH(rs.getString("maKh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
