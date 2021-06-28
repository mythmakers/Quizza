/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.*;

public class ClientChat extends javax.swing.JInternalFrame implements Runnable{

    String chatname="1",name;
    BufferedWriter writer;
    BufferedReader reader;
    static ClientChat one;
    public ClientChat(ClientChat one)
    {
        this.one = one;
        main(null);
    }
    public ClientChat() {
        initComponents();
        msg_area.setEditable(false);
        try{
            Socket socketClient = new Socket("127.0.0.1",8084);
            writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        }catch(Exception e){}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        msg_send = new javax.swing.JButton();
        msg_text = new javax.swing.JTextField();
        sub = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextPane();
        close = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(512, 500));

        msg_send.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        msg_send.setText("Send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        msg_text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });
        msg_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                msg_textKeyTyped(evt);
            }
        });

        sub.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        sub.setText("Name");

        jScrollPane1.setViewportView(msg_area);

        close.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        close.setText("X");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(msg_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_send))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub)
                    .addComponent(close))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_send)
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_textActionPerformed

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        if(!msg_text.getText().trim().equals("")){
        String str = msg_text.getText();
        try{
            writer.write(name+":"+str);
            writer.write("\n");
            writer.flush();
        }catch(Exception e){System.out.println(e);}
        msg_text.setText("");
        }
    }//GEN-LAST:event_msg_sendActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void msg_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_textKeyTyped
        int ch = evt.getKeyChar();
        if(ch==KeyEvent.VK_ENTER)
        {
            msg_send.doClick();
        }
    }//GEN-LAST:event_msg_textKeyTyped

    public void printmymsg(String msg)
    {
        StyledDocument doc = msg_area.getStyledDocument();
        Style style = msg_area.addStyle("test style", null);
        
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(style, Color.blue);
        StyleConstants.setBackground(style, Color.cyan);
        try{doc.insertString(doc.getLength(), "", style);
            doc.setParagraphAttributes(doc.getLength()+1, 1, style, false);}
        catch(BadLocationException e){}
        
        StyleConstants.setForeground(style, Color.black);
        try{doc.insertString(doc.getLength(), msg+"\n", style);}
        catch(BadLocationException e){}
    }
    
    public void printothermsg(String msgin,String sender)
    {
        StyledDocument doc = msg_area.getStyledDocument();
        Style style = msg_area.addStyle("test style", null);
        
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(style, Color.red);
        StyleConstants.setBackground(style, Color.LIGHT_GRAY);
        try{doc.insertString(doc.getLength(), sender+" : ", style);
            doc.setParagraphAttributes(doc.getLength()+1, 1, style, false);}
        catch(BadLocationException e){}
        
        StyleConstants.setForeground(style, Color.black);
        try{doc.insertString(doc.getLength(), msgin+"\n", style);}
        catch(BadLocationException e){}
    }
    
    public void run()
    {
        sub.setText(chatname);
        try{
            String data = reader.readLine();
            while(data != null)
            {
                String msg = data.substring(data.indexOf(':')+1, data.length());
                String sender = data.substring(0, data.indexOf(':'));
                //System.out.println(sender+" 123 "+msg);
                if(sender.equals(name))
                    printmymsg(msg);
                else{
                    printothermsg(msg,sender);
                    /*if(!this.isVisible()){
                        JFrame f = new JFrame();
                        int w = JOptionPane.showConfirmDialog(f, "You Got a message from '"+sender+"'\nShow message?", "New Message", JOptionPane.OK_CANCEL_OPTION);
                        if(w==0)
                            this.setVisible(true);
                    }*/
                }
                data = reader.readLine();
                //msg_area.append(msg+"\n");
            }
        }catch(Exception e){System.out.println(e);}
    }

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
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                one.setVisible(true);
            }
        });
        //TeacherClient one = new Client();
        //one.setVisible(true);
        Thread t1 = new Thread(one);
        t1.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    private javax.swing.JLabel sub;
    // End of variables declaration//GEN-END:variables
}
