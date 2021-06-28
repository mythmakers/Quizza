/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author lenovo
 */
public class StudentServer extends javax.swing.JFrame {

    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dout;
    
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
    String name="Student";
    static boolean bool1=false;
    /**
     * Creates new form StudentServer
     */
    public StudentServer() {
        initComponents();
        msg_area.setEditable(false);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chat","root","");
            st = con.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 450));

        jLabel1.setText("Student");

        msg_text.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        msg_send.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        msg_send.setText("Send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(msg_area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg_text, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_send))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msg_send))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static boolean isSocketAlive(String add,int port)
    {
        boolean isAlive = false;
        SocketAddress sa = new InetSocketAddress(add,port);
        Socket socket = new Socket();
        int timeout = 1;
        try{
            socket.connect(sa,timeout);
            socket.close();
            isAlive = true;
        }catch(SocketTimeoutException e){System.out.println(e);}
        catch(IOException e){System.out.println(e);}
        return isAlive;
    }
    
    /*public static void alive()
    {
        Thread t = new Thread()
        {
            public void run()
            {
                for(;;)
                {
                    try{
                        if(!bool1)
                            if(isSocketAlive("127.0.0.1",8081))
                                bool1=true;
                            else
                                bool1=false;
                        sleep(1000);
                    }
                    catch(Exception e)
                    {System.out.println(e);}
                }
            }
        };
        t.start();
    }*/
    
    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        String msg = "";
        if(!msg_text.getText().trim().equals("")){
        try{
            try{
                msg = msg_text.getText();
                dout.writeUTF(msg);
                printmymsg(msg);
                //msg_area.setText(msg_area.getText()+"\nClient : "+msg);
                msg_text.setText("");
            }
            catch(Exception e)
            {
                printmymsg(msg);
                msg_text.setText("");
                System.out.println("hell21 "+e);
            }
            String query = "Insert INTO grpchat1 values('"+msg+"','"+name+"')";
            int i = st.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_msg_sendActionPerformed

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
    
    public static void printothermsg(String msgin)
    {
        StyledDocument doc = msg_area.getStyledDocument();
        Style style = msg_area.addStyle("test style", null);
        
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(style, Color.red);
        StyleConstants.setBackground(style, Color.LIGHT_GRAY);
        try{doc.insertString(doc.getLength(), "Teacher : ", style);
            doc.setParagraphAttributes(doc.getLength()+1, 1, style, false);}
        catch(BadLocationException e){}
        
        StyleConstants.setForeground(style, Color.black);
        try{doc.insertString(doc.getLength(), msgin+"\n", style);}
        catch(BadLocationException e){}
    }
    
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
            java.util.logging.Logger.getLogger(StudentServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentServer().setVisible(true);
            }
        });
        
        //int port=8081;
        do{
        try
        {
            String msgin = "";
                s = new Socket("127.0.0.1",8084);  //ip of server + port no.
                dis = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                bool1=true;
            //alive();
            
            while(!msgin.equals("exit"))
            {
                msgin = dis.readUTF();
                printothermsg(msgin);
                //msg_area.setText(msg_area.getText()+"\nServer : "+msgin);
            }
        }
        catch(Exception e)
        {
            bool1=true;
            //JFrame f = new JFrame();
            //JOptionPane.showMessageDialog(f, "Another User is not connected to the server.\nYou can send message, User will see it later.", "No Direct Connection", JOptionPane.PLAIN_MESSAGE);
        }
        }while(bool1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextPane msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration//GEN-END:variables
}