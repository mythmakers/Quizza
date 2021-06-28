/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author lenovo
 */
public class Notice extends javax.swing.JInternalFrame implements Runnable{

    String name;
    BufferedWriter writer;
    BufferedReader reader;
    static Notice onee;
    
    public Notice(Notice onee)
    {
        this.onee = onee;
        main(null);
    }
    
    public Notice() {
        initComponents();
        notice_area.setEditable(false);
        try{
            Socket socketClient = new Socket("127.0.0.1",8083);
            writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        }catch(Exception e){}
    }
    
    public void forstudent()
    {
        notice_text.setVisible(false);
        post.setVisible(false);
    }
    
    public void forteacher()
    {
        notice_text.setVisible(true);
        post.setVisible(true);
    }
    
    public void printNotice(String msgin,String sender,String date)
    {
        StyledDocument doc = notice_area.getStyledDocument();
        Style style = notice_area.addStyle("test style", null);
        
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(style, Color.BLACK);
        StyleConstants.setBackground(style, Color.LIGHT_GRAY);
        try{doc.insertString(doc.getLength(), msgin+"\n", style);
            doc.setParagraphAttributes(doc.getLength()+1, 1, style, false);}
        catch(BadLocationException e){}
        
        StyleConstants.setBackground(style, Color.WHITE);
        StyleConstants.setForeground(style, Color.black);
        StyleConstants.setBold(style, true);
        try{doc.insertString(doc.getLength(), "Posted by "+sender, style);}
        catch(BadLocationException e){}
        StyleConstants.setFontSize(style, 14);
        StyleConstants.setBold(style, false);
        try{doc.insertString(doc.getLength(), "\n"+date+"\n\n", style);}
        catch(BadLocationException e){}
    }
    
    public void run()
    {
        try{
            String data = reader.readLine();
            while(data != null)
            {
                String msg = data.substring(data.indexOf(':')+1, data.length());
                String sender = data.substring(0, data.indexOf(':'));
                Date date = new Date();
                String[] d = date.toString().split("\\s+");
                    String dt = d[0]+" "+d[1]+" "+d[2]+" at "+d[3];
                    printNotice(msg,sender,dt);
                data = reader.readLine();
            }
        }catch(Exception e){System.out.println(e);}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        notice_text = new javax.swing.JTextField();
        post = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        notice_area = new javax.swing.JTextPane();

        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notice", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24))); // NOI18N

        notice_text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        notice_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notice_textKeyTyped(evt);
            }
        });

        post.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        post.setText("Post");
        post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postActionPerformed(evt);
            }
        });

        notice_area.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(notice_area);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(notice_text, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notice_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(post))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notice_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notice_textKeyTyped
        int ch = evt.getKeyChar();
        if(ch==KeyEvent.VK_ENTER)
        {
            post.doClick();
        }
    }//GEN-LAST:event_notice_textKeyTyped

    private void postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postActionPerformed
        if(!notice_text.getText().trim().equals("")){
        String str = notice_text.getText();
        try{
            writer.write(name+":"+str);
            writer.write("\n");
            writer.flush();
        }catch(Exception e){System.out.println(e);}
        notice_text.setText("");
        }
    }//GEN-LAST:event_postActionPerformed
    public static void main(String[] args) {
        Thread t1 = new Thread(onee);
        t1.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane notice_area;
    private javax.swing.JTextField notice_text;
    private javax.swing.JButton post;
    // End of variables declaration//GEN-END:variables

    
}