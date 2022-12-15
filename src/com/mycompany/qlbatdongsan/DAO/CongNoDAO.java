/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlbatdongsan.DAO;

import com.mycompany.qlbatdongsan.Entity.CongNo;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author HO VAN DAT
 */
public class CongNoDAO extends QLBDSDAO<CongNo, String>{
    final String INSERT_SQL = "INSERT INTO CongNo (soCongNo, maKH, hoTen, maGD, tenDA, tamUng, thueVat, phaiThu, daThu, conLai, laiNopCham, chietKhau, cong) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE CongNo SET maKH =?, hoTen =?, maGD = ?, tenDA = ?, tamUng = ?, thueVat =?, phaiThu = ?, daThu =?"
            + ", conLai =?, laiNopCham = ?, chietKhau = ?, cong WHERE soCongNo = ?";
    final String DELETE_SQL = "DELETE FROM CongNo WHERE soCongNo = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM CongNo";
    final String SELECT_BY_ID_SQL = "SELECT *FROM CongNo WHERE soCongNo = ?";

    @Override
    public void insert(CongNo entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSoCongNo(), entity.getMaKH(), entity.getHoTen(), entity.getMaGD(), entity.getTenDA(), entity.getTamUng(),
                entity.getThueVat(), entity.getPhaiThu(), entity.getDaThu(), entity.getConLai(), entity.getLaiNopCham(), entity.getChietKhau(),
                entity.getCong());
    }

    @Override
    public void update(CongNo entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaKH(), entity.getHoTen(), entity.getMaGD(), entity.getTenDA(), entity.getTamUng(),
                entity.getThueVat(), entity.getPhaiThu(), entity.getDaThu(), entity.getConLai(), entity.getLaiNopCham(), entity.getChietKhau(),
                entity.getCong(), entity.getSoCongNo());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<CongNo> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public CongNo selectById(String id) {
        List<CongNo> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CongNo> selectBySql(String sql, Object... args) {
        List<CongNo> list = new ArrayList<CongNo>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                CongNo entity = new CongNo();
                entity.setSoCongNo(rs.getInt("soCongNo"));
                entity.setMaKH(rs.getString("maKH"));
                entity.setHoTen(rs.getString("hoTen"));
                entity.setMaGD(rs.getString("maGD"));
                entity.setTenDA(rs.getString("tenDA"));
                entity.setTamUng(rs.getFloat("tuongUng"));
                entity.setThueVat(rs.getFloat("thueVat"));
                entity.setPhaiThu(rs.getFloat("phaiThu"));
                entity.setDaThu(rs.getFloat("daThu"));
                entity.setConLai(rs.getFloat("conLai"));
                entity.setLaiNopCham(rs.getInt("laiNopCham"));
                entity.setChietKhau(rs.getFloat("chietKhau"));
                entity.setCong(rs.getFloat("cong"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
