package com.mycompany.qlbatdongsan.DAO;


import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.Mails;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MailDAO extends QLBDSDAO<Mails, Integer> {
    final String INSERT_SQL = "INSERT INTO Mail (soMail, maNV, emailNguoiNhan, noiDung,thoiGian,loaiThu,tieuDe) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE Mail SET maNV = ?, emailNguoiNhan = ?, noiDung = ?, thoiGian=?, loaiThu=?, tieuDe=?  WHERE soMail = ?";
    final String DELETE_SQL = "DELETE FROM Mail WHERE soMail = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM Mail";
    final String SELECT_BY_ID_SQL = "SELECT *FROM Mail WHERE soMail = ?";
    final String SELECT_BY_LOAI_Thu_SQL = "SELECT *FROM Mail WHERE loaiMail = ?";

    @Override
    public void insert(Mails entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaEmail(), entity.getMaNV(), entity.getEmailNguoiNhan(), entity.getNoiDung(),entity.getThoiGian(),entity.getLoaiThu(),entity.getTieuDe());
    }

    @Override
    public void update(Mails entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaNV(), entity.getEmailNguoiNhan(), entity.getNoiDung(),entity.getThoiGian(),entity.getLoaiThu(),entity.getTieuDe(), entity.getMaEmail());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Mails> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Mails selectById(Integer id) {
        List<Mails> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<Mails> selectByLoaiThu(String id) {
        List<Mails> list = selectBySql(SELECT_BY_LOAI_Thu_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Mails> selectBySql(String sql, Object... args) {
        List<Mails> list = new ArrayList<Mails>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Mails entity = new Mails();
                entity.setMaEmail(rs.getInt("soMail"));
                entity.setMaNV(rs.getString("maNV"));
                entity.setEmailNguoiNhan(rs.getString("emailNguoiNhan"));
                entity.setNoiDung(rs.getString("noiDung"));
                entity.setThoiGian(rs.getDate("thoiGian"));
                entity.setLoaiThu(rs.getString("loaiMail"));
                entity.setTieuDe(rs.getString("tieuDe"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
