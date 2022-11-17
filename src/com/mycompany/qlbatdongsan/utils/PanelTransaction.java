/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbatdongsan.utils;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author HO VAN DAT
 */
public class PanelTransaction extends javax.swing.JPanel {

    private JLayeredPane body;

    public PanelTransaction() {
        initComponents();
        setOpaque(false);
        setLayout(new MigLayout("fill", "0[fill]0", "0[fill]0"));
        body = new JLayeredPane();
        body.setLayout(new CardLayout());
        add(body);

    }

    public void display(Component form) {
        body.removeAll();
        body.add(form);
        body.repaint();
        body.revalidate();
        form.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
