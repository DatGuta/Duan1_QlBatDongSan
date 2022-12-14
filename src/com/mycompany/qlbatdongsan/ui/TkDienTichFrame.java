/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.DAO.ThongKeDAO;
import com.mycompany.qlbatdongsan.Entity.TKDienTich;
import java.awt.Color;
import java.util.List;
import raven.chart.ModelChart;

/**
 *
 * @author HO VAN DAT
 */
public class TkDienTichFrame extends javax.swing.JPanel {

    ThongKeDAO dao = new ThongKeDAO();
    List<TKDienTich> lists = dao.selectAllDT();

    /**
     * Creates new form TkDienTich
     */
    public TkDienTichFrame() {
        initComponents();
        chart.setTitle("Chart Data");
        chart.addLegend("Tổng diện tích ", Color.decode("#7b4397"), Color.decode("#dc2430"));
        setData();
    }

    public void setData() {
        for (int i = lists.size() - 1; i >= 0; i--) {
            TKDienTich da = lists.get(i);
            chart.addData(new ModelChart(da.getLoaiDA(), new double[]{da.getTongDT()}));
            chart.start();
        }
        System.out.println(lists.get(0).getLoaiDA());
    }

    ;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chart = new raven.chart.CurveLineChart();

        jPanel1.setBackground(new java.awt.Color(34, 59, 68));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setForeground(new java.awt.Color(17, 38, 47));
        jPanel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.chart.CurveLineChart chart;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
