/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.qlbatdongsan.ui;

import com.mycompany.qlbatdongsan.utils.Auth;
import com.mycompany.qlbatdongsan.utils.MsgBox;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HO VAN DAT
 */
public class NewEmailFrame extends javax.swing.JFrame {

    static String[] Cc = null;
    static String[] Bcc = null;
    private String pass;

    /**
     * Creates new form NewEmailFrame
     */
    public NewEmailFrame() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(this.getX() + 1100, this.getY() + 390, this.getWidth(), this.getHeight());
    }

    public void send(String to, String sub, String[] Cc, String[] Bcc, String msg, final String user, final String pass) {
        Properties pros = new Properties();
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.post", "587");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.ssl.protocols", "TLSv1.2");
        pros.setProperty("mail.smtp.ssl.enable", "true");
//        pros.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(pros, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            int counter = 0;
            if (Cc.length==0) {
                InternetAddress[] recipientAddress = new InternetAddress[Cc.length];
                for (String recipient : Cc) {
                    recipientAddress[counter] = new InternetAddress(recipient.trim());
                    counter++;
                }
                message.setRecipients(Message.RecipientType.CC, recipientAddress);
            }
            if (Bcc.length==0) {
                InternetAddress[] recipientAddressBCC = new InternetAddress[Bcc.length];
                for (String recipient : Bcc) {
                    recipientAddressBCC[counter] = new InternetAddress(recipient.trim());
                    counter++;
                }

                message.setRecipients(Message.RecipientType.BCC, recipientAddressBCC);
            }
            message.setSubject(sub);
            message.setText(msg, "text/html");
            Transport.send(message,message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SendMail() {
        Cc = txtCC.getText().split(",");
        Bcc = txtBCC.getText().split(",");
        try {
            send(txtNguoiNhan.getText(), txtTieuDe.getText(), Cc, Bcc, txaNoiDung.getText(), Auth.user.getEmail(), pass);
            MsgBox.alert(this, "Gữi Mail thành công!");
        } catch (Exception e) {
            
            MsgBox.alert(this, "Gữi mail thất bại");
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

        txtTieuDe = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaNoiDung = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnBCC = new javax.swing.JButton();
        btnCC = new javax.swing.JButton();
        txtCC = new javax.swing.JTextField();
        lblCC = new javax.swing.JLabel();
        lblBCC = new javax.swing.JLabel();
        txtBCC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNguoiNhan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTieuDe.setText("Tiêu đề");
        txtTieuDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTieuDeMouseClicked(evt);
            }
        });

        txaNoiDung.setColumns(20);
        txaNoiDung.setRows(5);
        jScrollPane1.setViewportView(txaNoiDung);

        jLabel4.setText("Nội dung");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Thư mới");

        jButton1.setText("Gữi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBCC.setText("Bcc");

        btnCC.setText("Cc");
        btnCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCCActionPerformed(evt);
            }
        });

        lblCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCC.setText("Cc");
        lblCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCCMouseClicked(evt);
            }
        });

        lblBCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBCC.setText("Bcc");
        lblBCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBCCMouseClicked(evt);
            }
        });

        jLabel8.setText("Đến:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblBCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                                            .addGap(27, 27, 27))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(txtNguoiNhan)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnCC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnBCC, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBCC, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jLabel4))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBCC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCC))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBCC)
                    .addComponent(txtBCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pass = MsgBox.promt(this, "Mời nhập mật khẩu");
        System.out.println(Auth.user.getEmail()+ pass);
        SendMail();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTieuDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTieuDeMouseClicked
        // TODO add your handling code here:
        txtTieuDe.setText(null);
    }//GEN-LAST:event_txtTieuDeMouseClicked

    private void lblCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCCMouseClicked
        // TODO add your handling code here:
        System.out.println("Hiện thành công!");
    }//GEN-LAST:event_lblCCMouseClicked

    private void lblBCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBCCMouseClicked
        // TODO add your handling code here:
        BCCandCC bbBCCandCC = new BCCandCC();
        bbBCCandCC.setVisible(true);

    }//GEN-LAST:event_lblBCCMouseClicked

    private void btnCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCCActionPerformed
        // TODO add your handling code here:
        BCCandCC bbBCCandCC = new BCCandCC();
        bbBCCandCC.setVisible(true);
    }//GEN-LAST:event_btnCCActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewEmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewEmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewEmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewEmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewEmailFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBCC;
    private javax.swing.JButton btnCC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBCC;
    private javax.swing.JLabel lblCC;
    private javax.swing.JTextArea txaNoiDung;
    private javax.swing.JTextField txtBCC;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtNguoiNhan;
    private javax.swing.JTextField txtTieuDe;
    // End of variables declaration//GEN-END:variables
}
