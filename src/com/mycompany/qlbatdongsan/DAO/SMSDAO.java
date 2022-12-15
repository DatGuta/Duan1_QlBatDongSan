package com.mycompany.qlbatdongsan.DAO;


import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.SMS;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SMSDAO extends QLBDSDAO<SMS, String> {

    final String INSERT_SQL = "INSERT INTO SMS (Sdt, maNV, sdtNguoiThan, ngayGui, noiDung) VALUES (?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE SMS SET maNV =? , sdtNguoiThan =?, ngayGui =?, noiDung =? WHERE Sdt = ?";
    final String DELETE_SQL = "DELETE FROM SMS WHERE Sdt = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SMS";
    final String SELECT_BY_ID_SQL = "SELECT *FROM SMS WHERE Sdt = ?";

    @Override
    public void insert(SMS entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSdt(), entity.getMaNV(), entity.getSdtNguoiThan(), entity.getNgayGui(), entity.getNoiDung());
    }

    @Override
    public void update(SMS entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMaNV(), entity.getSdtNguoiThan(), entity.getNgayGui(), entity.getNoiDung() ,entity.getSdt());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SMS> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SMS selectById(String id) {
        List<SMS> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SMS> selectBySql(String sql, Object... args) {
        List<SMS> list = new ArrayList<SMS>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SMS entity = new SMS();
                entity.setSdt(rs.getString("Sdt"));
                entity.setMaNV(rs.getString("maNV"));
                entity.setSdtNguoiThan(rs.getString("sdtNguoiThan"));
                entity.setNgayGui(rs.getDate("ngayGui"));
                entity.setNoiDung(rs.getString("noiDung"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
