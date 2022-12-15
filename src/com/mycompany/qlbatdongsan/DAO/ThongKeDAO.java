/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlbatdongsan.DAO;

import com.mycompany.qlbatdongsan.Entity.TKDienTich;
import com.mycompany.qlbatdongsan.Entity.TKDuAn;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


/**
 *
 * @author HO VAN DAT
 */
public class ThongKeDAO {
    public List<TKDuAn> selectBySql(String sql, Object... args) {
        List<TKDuAn> list = new ArrayList<>();
        try {
            ResultSet rs = com.mycompany.qlbatdongsan.utils.JdbcHelper.query(sql, args);
            while (rs.next()) {
                TKDuAn entity = new TKDuAn();
                entity.setTenDA(rs.getString("tenDA"));
                entity.setPhaiThu(rs.getFloat("phaiThu"));
                entity.setConLai(rs.getFloat("phaiThu"));
                entity.setTuonUng(rs.getFloat("tuongUng"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public List<TKDuAn> selectAll() {
        String sql = "{CALL sp_TKDuAn}";
        List<TKDuAn> list = selectBySql(sql);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    public List<TKDienTich> selectBySqlDT(String sql, Object... args) {
        List<TKDienTich> list = new ArrayList<>();
        try {
            ResultSet rs = com.mycompany.qlbatdongsan.utils.JdbcHelper.query(sql, args);
            while (rs.next()) {
                TKDienTich entity = new TKDienTich();
                entity.setLoaiDA(rs.getString("sanPham"));
                entity.setTongDT(rs.getFloat("tongDT"));
   
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public List<TKDienTich> selectAllDT() {
        String sql = "{CALL sp_TKDienTich}";
        List<TKDienTich> list = selectBySqlDT(sql);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
//    public List<TKDuAn> getTKDuAn(){
//        String sql = "{CALL sp_TKDuAn}";
//        String[] cols = {"tenDA", "tuongUng", "phaiThu", "conLai"};
//        return this.getListOfArray(sql, cols);
//    }
//    
//     public List<Object[]> getTKDienTich(){
//        String sql = "{CALL sp_TKDienTich}";
//        String[] cols = {"sanPham", "tongDT"};
//        return this.getListOfArray(sql, cols);
//    }
}
