/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

/**
 *
 * @author HO VAN DAT
 */
public class GreetFrame extends javax.swing.JPanel {

    /**
     * Creates new form GreetFrame
     */
    public GreetFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        AnhNen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1340, 720));
        setPreferredSize(new java.awt.Dimension(1340, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Barlow Condensed Light", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Chúc bạn có 1 ngày làm việc tốt lành <3");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 680, 60));

        AnhNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlbatdongsan/images/icon/pexels-lukas-1419923.jpg"))); // NOI18N
        add(AnhNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 620));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnhNen;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
