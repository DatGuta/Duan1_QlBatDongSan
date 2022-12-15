package com.mycompany.qlbatdongsan.DAO;


import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.SanPhamDuAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDuAnDAO extends QLBDSDAO<SanPhamDuAn, String> {

    final String INSERT_SQL = "INSERT INTO SanPhamDuAn  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE SanPhamDuAn SET  maDA=?, tenSanPham=?, dienTich=?, PhongBepKhach=?, PhongNgu=?, WC=?, Gia=?, LoaiSP=?, TrangThai=?, TienNghi=?, ChuSoHuu=?, TGSoHuu=?, SoTang=?, ThuocTang=?, DonViPhanPhoi=?, Toa=? WHERE maSPDA = ?";
    final String DELETE_SQL = "DELETE FROM SanPhamDuAn WHERE maSPDA = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SanPhamDuAn";
    final String SELECT_BY_ID_SQL = "SELECT *FROM SanPhamDuAn WHERE maSPDA = ?";
    final String SELECT_BY_MA_DA_SQL = "SELECT *FROM SanPhamDuAn WHERE maDA = ?";
    final String SELECT_BY_MA_SGD_SQL = "SELECT *FROM SanPhamDuAn WHERE maSGD = ?";
    final String SELECT_BY_MA_TOA_SQL = "SELECT *FROM SanPhamDuAn WHERE Toa = ? and maDA=?";
    
    @Override
    public void insert(SanPhamDuAn entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaSPDA(),entity.getMaDA(),entity.getTenSP(),entity.getDienTich(),entity.getPhongBepKhach(),entity.getPhongNgu(),entity.getWC(),entity.getGia(),entity.getLoaiSP(),entity.getTrangThai(),entity.getTienNghi(),entity.getChuSoHuu(),entity.getTgSoHuu(),entity.getSoTang(),entity.getThuocTang(),entity.getDonViPhanPhoi(),entity.getToa());
    }

    @Override
    public void update(SanPhamDuAn entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMaDA(),entity.getTenSP(),entity.getDienTich(),entity.getPhongBepKhach(),entity.getPhongNgu(),entity.getWC(),entity.getGia(),entity.getLoaiSP(),entity.getTrangThai(),entity.getTienNghi(),entity.getChuSoHuu(),entity.getTgSoHuu(),entity.getSoTang(),entity.getThuocTang(),entity.getDonViPhanPhoi(),entity.getToa(), entity.getMaSPDA());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPhamDuAn> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPhamDuAn selectById(String id) {
        List<SanPhamDuAn> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<SanPhamDuAn> selectByMaSGD(String id) {
        List<SanPhamDuAn> list = selectBySql(SELECT_BY_MA_SGD_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    public List<SanPhamDuAn> selectByMaDA(String id) {
        List<SanPhamDuAn> list = selectBySql(SELECT_BY_MA_DA_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    public List<SanPhamDuAn> selectByMaToa(String id,String maDA) {
        List<SanPhamDuAn> list = selectBySql(SELECT_BY_MA_TOA_SQL, id, maDA);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<SanPhamDuAn> selectBySql(String sql, Object... args) {
        List<SanPhamDuAn> list = new ArrayList<SanPhamDuAn>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SanPhamDuAn entity = new SanPhamDuAn();
                entity.setMaSPDA(rs.getString("maSPDA"));
                entity.setMaDA(rs.getString("maDA"));
                entity.setTenSP(rs.getString("tenSanPham"));
                entity.setDienTich(rs.getDouble("dienTich"));
                entity.setPhongBepKhach(rs.getInt("PhongBepKhach"));
                entity.setPhongNgu(rs.getInt("PhongNgu"));
                entity.setWC(rs.getInt("WC"));
                entity.setGia(rs.getDouble("Gia"));
                entity.setLoaiSP(rs.getString("LoaiSP"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setTienNghi(rs.getString("TienNghi"));
                entity.setChuSoHuu(rs.getString("ChuSoHuu"));
                entity.setTgSoHuu(rs.getString("TGSoHuu"));
                entity.setSoTang(rs.getInt("SoTang"));
                entity.setThuocTang(rs.getInt("ThuocTang"));
                entity.setDonViPhanPhoi(rs.getInt("DonViPhanPhoi"));
                entity.setToa(rs.getString("Toa"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
