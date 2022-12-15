/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.CongNoDAO;
import com.mycompany.qlbatdongsan.Entity.CongNo;
import com.mycompany.qlbatdongsan.utils.MsgBox;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;


/**
 *
 * @author HO VAN DAT
 */
public class DebtFrame extends javax.swing.JPanel {

    DefaultTableModel model;
    ArrayList<CongNo> arr = new ArrayList<CongNo>();
    CongNoDAO dao = new CongNoDAO();

    /**
     * Creates new form DebtFrame
     */
    public DebtFrame() {
        initComponents();
        initTableCongNo();
        initTablePhieuThu();
        fillToTableCongNo();
    }
//     private void initTableCongNo() {
//        model = new DefaultTableModel();
//        Object[] column = {"Khách hàng","Mã giao dịch","Căn hộ","Tương ứng","Thuế VAT","Phải thu","Đã thu","Còn lại","Lãi nộp chậm","Chiết khấu","Cộng"};
//        model.setColumnIdentifiers(column);
//        model.setRowCount(0);
//        tblCongNo.setModel(model);
//    }

    private void initTableCongNo() {
        model = new DefaultTableModel();
        Object[] column = {"Số công nợ", "Mã khách hàng", "Họ tên", "Mã giao dịch", "Căn hộ", "Tương ứng", "Thuế VAT", "Phải thu", "Đã thu", "Còn lại", "Lãi nộp chậm", "Chiết khấu", "Cộng"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblCongNo.setModel(model);
    }

    private void initTablePhieuThu() {
        model = new DefaultTableModel();
        Object[] column = {"Số phiếu", "Ngày thu", "TK nợ", "TK có", "Số tiền(VNĐ)", "Người nộp", "Địa chỉ", "Diễn giải", "Nhân viên"};
        model.setColumnIdentifiers(column);
        model.setRowCount(0);
        tblPhieuThu.setModel(model);
    }

    public void fillToTableCongNo() {
        DefaultTableModel model = (DefaultTableModel) tblCongNo.getModel();
        model.setRowCount(0);
        try {
            List<CongNo> list = dao.selectAll();
            for (CongNo nh : list) {
                Object[] row = {
                    nh.getSoCongNo(),
                    nh.getMaKH(),
                    nh.getHoTen(),
                    nh.getMaGD(),
                    nh.getTenDA(),
                    nh.getTamUng(),
                    nh.getThueVat(),
                    nh.getPhaiThu(),
                    nh.getDaThu(),
                    nh.getConLai(),
                    nh.getLaiNopCham(),
                    nh.getChietKhau(),
                    nh.getCong()
                };
                arr.add(nh);
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboTGBatDau = new javax.swing.JComboBox<>();
        cboTGKetThuc = new javax.swing.JComboBox<>();
        btnNhacNo = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCongNo = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieuThu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        cboTGBatDau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboTGKetThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNhacNo.setText("Nhắc nợ");
        btnNhacNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhacNoActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        tblCongNo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCongNo);

        tblPhieuThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblPhieuThu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1328, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1328, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Phiếu thu", jPanel1);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CÔNG NỢ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cboTGBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cboTGKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnNhacNo)
                        .addGap(18, 18, 18)
                        .addComponent(btnExport)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(573, 573, 573)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTGBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTGKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport)
                    .addComponent(btnNhacNo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhacNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhacNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhacNoActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDateTime now = LocalDateTime.now();
        try {
              XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("danhsach");
            //
            XSSFFont font = sheet.getWorkbook().createFont();
            font.setFontName("Times New Roman");
            font.setBold(true);
            font.setFontHeightInPoints((short) 14); // font size
            font.setColor(IndexedColors.WHITE.getIndex()); // text color
            //
            CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            cellStyle.setFont(font);
            cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setBorderBottom(BorderStyle.THIN);
            // // căn chỉnh ngang dọc

            XSSFCellStyle centerStyle = wordkbook.createCellStyle();
            centerStyle.setAlignment(HorizontalAlignment.CENTER);
            centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            
            /// gộp
            Row row = sheet.createRow(2);
            Cell cell = row.createCell(0);
            cell.setCellValue("DANH SÁCH CÔNG NỢ    " + dtf.format(now));
            cell.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 12));

            row = sheet.createRow(3); // từ dòng 3
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Số công nợ");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("MÃ KH");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Họ tên");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Mã giao dịch");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Căn hộ");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Tương ứng");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Thuế VAT");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Phải thu");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Đã thu");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Còn lại");

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("lãi nộp chậm");

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Chiết khấu");

            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("Công");

            for (int i = 0; i < arr.size(); i++) {
                row = sheet.createRow(4 + i); // từ dòng 5

                cell = row.createCell(0, CellType.STRING); // cột 0
                cell.setCellValue(arr.get(i).getSoCongNo());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(arr.get(i).getMaKH());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(arr.get(i).getHoTen());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(arr.get(i).getMaGD());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(arr.get(i).getTenDA());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(arr.get(i).getTamUng());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(arr.get(i).getThueVat());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(arr.get(i).getPhaiThu());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(arr.get(i).getDaThu());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(arr.get(i).getConLai());

                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(arr.get(i).getLaiNopCham());

                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(arr.get(i).getChietKhau());

                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue(arr.get(i).getCong());

            }

            File f = new File("D:\\DuAn_1\\Duan1_QlBatDongSan\\src\\com\\mycompany\\qlbatdongsan\\files\\CongNo" + dtf.format(now) + ".xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                wordkbook.write(fis);
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            MsgBox.alert(this, "Đã xuất file thành công!");

        } catch (Exception ex) {
            ex.printStackTrace();
            MsgBox.alert(this, "Đã xảy ra lỗi khi xuất file!");
        }
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnNhacNo;
    private javax.swing.JComboBox<String> cboTGBatDau;
    private javax.swing.JComboBox<String> cboTGKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCongNo;
    private javax.swing.JTable tblPhieuThu;
    // End of variables declaration//GEN-END:variables
}
