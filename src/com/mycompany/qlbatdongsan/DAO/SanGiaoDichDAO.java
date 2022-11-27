package com.mycompany.qlbatdongsan.DAO;


import DAO.QLBDSDAO;
import com.mycompany.qlbatdongsan.utils.JdbcHelper;
import com.mycompany.qlbatdongsan.Entity.SanGiaoDich;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanGiaoDichDAO extends QLBDSDAO<SanGiaoDich, Integer> {

    final String INSERT_SQL = "INSERT INTO SANGIAODICH (maSGD, sanGiaoDich, Sdt, diaChi, nguoiLienHe, chucVu, SdtNLH, nhanVienQuanLy, nhanVienTao, ngayTao) VALUES (?,?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE SANGIAODICH SET sanGiaoDich = ?, Sdt = ?, diaChi = ?, nguoiLienHe = ?, chucVu = ?, SdtNLH = ?, nhanVienQuanLy = ?, nhanVienTao = ?, ngayTao = ? WHERE maSGD = ?";
    final String DELETE_SQL = "DELETE FROM SANGIAODICH WHERE maSGD = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SANGIAODICH";
    final String SELECT_BY_ID_SQL = "SELECT *FROM SANGIAODICH WHERE maSGD = ?";

    @Override
    public void insert(SanGiaoDich entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaSGD(), entity.getSanGiaoDich(), entity.getSdt(), entity.getDiaChi(), entity.getNguoiLienHe(), entity.getChucVu(),
                entity.getSdtNguoiLienHe(), entity.getNvQuanLy(), entity.getNvTao(), entity.getNgayTao());
    }

    @Override
    public void update(SanGiaoDich entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getSanGiaoDich(), entity.getSdt(), entity.getDiaChi(), entity.getNguoiLienHe(), entity.getChucVu(),
                entity.getSdtNguoiLienHe(), entity.getNvQuanLy(), entity.getNvTao(), entity.getNgayTao(), entity.getMaSGD());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SanGiaoDich> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanGiaoDich selectById(Integer id) {
        List<SanGiaoDich> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanGiaoDich> selectBySql(String sql, Object... args) {
        List<SanGiaoDich> list = new ArrayList<SanGiaoDich>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                SanGiaoDich entity = new SanGiaoDich();
                entity.setMaSGD(rs.getInt("maSGD"));
                entity.setSanGiaoDich(rs.getString("sanGiaoDich"));
                entity.setSdt(rs.getString("Sdt"));
                entity.setDiaChi(rs.getString("diaChi"));
                entity.setNguoiLienHe(rs.getString("nguoiLienHe"));
                entity.setChucVu(rs.getString("chucVu"));
                entity.setSdtNguoiLienHe(rs.getString("SdtNLH"));
                entity.setNvQuanLy(rs.getString("nhanVienQuanLy"));
                entity.setNvTao(rs.getString("nhanVienTao"));
                entity.setNgayTao(rs.getDate("ngayTao"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
