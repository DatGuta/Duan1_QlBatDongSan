package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.Mail;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MailDAO extends QLBDSDAO<Mail, Integer> {
    final String INSERT_SQL = "INSERT INTO Mail (maEmail, maNV, emailNguoiThan, noiDung, Email) VALUES (?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Mail SET maNV = ?, emailNguoiThan = ?, noiDung = ?, Email = ? WHERE maEmail = ?";
    final String DELETE_SQL = "DELETE FROM Mail WHERE maEmail = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Mail";
    final String SELECT_BY_ID_SQL = "SELECT *FROM Mail WHERE maEmail = ?";

    @Override
    public void insert(Mail entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaEmail(), entity.getMaNV(), entity.getEmailNguoiNhan(), entity.getNoiDung(), entity.getEmail());
    }

    @Override
    public void update(Mail entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaNV(), entity.getEmailNguoiNhan(), entity.getNoiDung(), entity.getEmail(), entity.getMaEmail());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Mail> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Mail selectById(Integer id) {
        List<Mail> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Mail> selectBySql(String sql, Object... args) {
        List<Mail> list = new ArrayList<Mail>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Mail entity = new Mail();
                entity.setMaEmail(rs.getInt("maEmail"));
                entity.setMaNV(rs.getString("maNV"));
                entity.setEmailNguoiNhan(rs.getString("emailNguoiThan"));
                entity.setNoiDung(rs.getString("noiDung"));
                entity.setEmail(rs.getString("email")); 
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
