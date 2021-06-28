/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class ViewPreviousTest extends javax.swing.JFrame {
    
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;

    String username,testname,subject;
    boolean online,result=false;
    int size;
    String tab[][];
    
    JTextField jf;
    JButton jb,back;
    
    /**
     * Creates new form ViewPreviousTest
     */
    public ViewPreviousTest() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public ViewPreviousTest(String username,String subject,boolean online)
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf = new JTextField("Search test...");
        jb = new JButton("Search");
        back = new JButton("");
        update.setText("Update");
        addSearch();
        this.username = username;
        this.subject = subject;
        
        subjectLabel.setText(subject.toUpperCase());
        this.online = online;
        viewpass.setVisible(false);
        chgpass.setVisible(false);
        if(online){
            viewpass.setVisible(true);
            chgpass.setVisible(true);
        }
        show_test();
    }
    public ViewPreviousTest(String username,String subject,boolean result,boolean online)
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf = new JTextField("Search test...");
        jb = new JButton("Search");
        back = new JButton("");
        update.setText("View Result");
        addSearch();
        this.username = username;
        this.subject = subject;
        this.online = online;
        subjectLabel.setText(subject.toUpperCase());
        this.result = result;
        viewpass.setVisible(false);
        chgpass.setVisible(false);
        delete.setVisible(false);
        edit.setVisible(false);
        show_test();
    }
    
    public void addSearch()
    {
        back.setIcon(new ImageIcon(getClass().getResource("Go-back-icon.png")));
        back.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            backActionPerformed(evt);
        }
        });
        jf.setFont(new java.awt.Font("Times New Roman", 0, 22));
        jf.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(jf.getText().equals("Search test..."))
                {
                    jf.setForeground(new java.awt.Color(0, 0, 0));
                    jf.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(jf.getText().trim().equals(""))
                {
                    jf.setForeground(new java.awt.Color(0, 204, 204));
                    jf.setText("Search test...");
                }
            }
        });
        jf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int ch = e.getKeyChar();
                if(ch==KeyEvent.VK_ENTER)
                {
                    jb.doClick();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        jb.setFont(new java.awt.Font("Times New Roman", 0, 22));
        menubar.add(back);
        menubar.add(jf);
        menubar.add(jb);
        jb.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jbActionPerformed(evt);
        }
        });
    }
    
    public void backActionPerformed(java.awt.event.ActionEvent evt)
    {
        new Home(username,subject).setVisible(true);
        this.setVisible(false);
    }
    
    public ArrayList<User> test()
    {
        String query;
        ArrayList<User> test = new ArrayList<>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver Loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizza","root","");
            //System.out.println("Connected");

            st = con.createStatement();
            if(online){
                query = "SELECT * FROM `"+subject+"`.`online_test`";
            }
            else{
                query = "SELECT * FROM `"+subject+"`.`test`";
            }
            rs = st.executeQuery(query);
            User user;
            
                while(rs.next())
                {
                    user = new User(rs.getString("Test_Name"),rs.getInt("Number_of_Questions"));
                    test.add(user);
                }
            con.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return test;
    }
    
    public void show_test()
    {
        //table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ArrayList<User> list = test();
        size = list.size();
        Object[] row;
        DefaultTableModel model = (DefaultTableModel)table2.getModel();
        
            tab = new String[size][2];
            row = new Object[2];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getTest();
            row[1]=list.get(i).getQuestions();
            //if(online)
              //  row[2]=list.get(i).getTestPass();
            model.addRow(row);
        }
        
            for(int r=0;r<size;r++)
            {
                for(int c=0;c<2;c++)
                {
                    tab[r][c] = table2.getModel().getValueAt(r, c).toString();
                }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        edit = new javax.swing.JButton();
        update = new javax.swing.JButton();
        viewpass = new javax.swing.JButton();
        chgpass = new javax.swing.JButton();
        subjectLabel = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(540, 300));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test", "Questions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setResizable(false);
            table2.getColumnModel().getColumn(1).setResizable(false);
        }

        edit.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        viewpass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        viewpass.setText("View Password");
        viewpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpassActionPerformed(evt);
            }
        });

        chgpass.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        chgpass.setText("Change Passsword");
        chgpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chgpassActionPerformed(evt);
            }
        });

        subjectLabel.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        subjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subjectLabel.setText("Subject");

        delete.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subjectLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewpass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(chgpass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(update)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(subjectLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewpass)
                    .addComponent(chgpass)
                    .addComponent(edit)
                    .addComponent(update)
                    .addComponent(delete))
                .addContainerGap())
        );

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try
        {
            int row = table2.getSelectedRow();
            testname = table2.getModel().getValueAt(row, 0).toString();
            if(online)
                new PreviousTest(testname,username,subject,true).setVisible(true);
            else
                new PreviousTest(testname,username,subject,false).setVisible(true);
            this.setVisible(false);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Select a Test First","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(result)
        {
            try
            {
                int row = table2.getSelectedRow();
                testname = table2.getModel().getValueAt(row, 0).toString();
                new ResultTest(testname,username,subject,true,true).setVisible(true);
                this.setVisible(false);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Select a Test First","Error",JOptionPane.ERROR_MESSAGE);
            }   
        }
        else{
        boolean b=true;
        String query,query1,query2;
        String testPass="";
        for(int r=0;r<size;r++)
        {
            String value = table2.getModel().getValueAt(r, 0).toString();
            if(!value.equals(tab[r][0]))
            {
                
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizza","root","");

                    st = con.createStatement();
                    query1 = "RENAME TABLE `"+subject+"`.`"+tab[r][0]+"` TO `"+value+"`";
                    query2 = "RENAME TABLE `studentresult`.`"+tab[r][0]+"` TO `"+value+"`";
                    if(online){
                        rs = st.executeQuery("SELECT password FROM `"+subject+"`.`online_test` WHERE `Test_Name`='"+tab[r][0]+"'");
                        if(rs.next())
                            testPass = rs.getString(1);
                        query = "UPDATE `"+subject+"`.`online_test` SET `Test_Name`='"+value+"',"+
                                    "`Number_of_Questions`='"+table2.getModel().getValueAt(r, 1)+"',"+
                                    " `password`='"+testPass+"' WHERE `Test_Name`='"+tab[r][0]+"'";
                    }
                    else{
                        query = "UPDATE `"+subject+"`.`test` SET `Test_Name`='"+value+"',"+
                                    "`Number_of_Questions`='"+table2.getModel().getValueAt(r, 1)+"' WHERE `Test_Name`='"+tab[r][0]+"'";
                    }
                    st.execute(query1);
                    st.execute(query2);
                    st.executeUpdate(query);
                    tab[r][0] = value;
                    con.close();
                }
                catch (ClassNotFoundException e)
                {
                    System.out.println(e);
                }
                catch(MySQLSyntaxErrorException e)
                {
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    String es = sw.toString();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, es.substring(es.indexOf(':')+2, es.indexOf('\n')).replaceAll("Table", "Test"));
                    b=false;
                    table2.getModel().setValueAt(tab[r][0], r, 0);
                }
                catch(SQLException e)
                {
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Could Not Update");
                }
            }
        }
        if(b)
        {
            new Home(username,subject).setVisible(true);
            this.setVisible(false);
        }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void viewpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpassActionPerformed
        String testPass="";
        try
        {
            int row = table2.getSelectedRow();
            testname = table2.getModel().getValueAt(row, 0).toString();
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizza","root","");

            st = con.createStatement();
            rs = st.executeQuery("SELECT password FROM `"+subject+"`.`online_test` WHERE `Test_Name`='"+testname+"'");
            if(rs.next())
                testPass = rs.getString(1);
            con.close();
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Password : "+testPass, "Password", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Select a Test First","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewpassActionPerformed

    private void chgpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chgpassActionPerformed
        String testPass="",newPass="";
        try
        {
            int row = table2.getSelectedRow();
            testname = table2.getModel().getValueAt(row, 0).toString();
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizza","root","");

            st = con.createStatement();
            rs = st.executeQuery("SELECT password FROM `"+subject+"`.`online_test` WHERE `Test_Name`='"+testname+"'");
            if(rs.next())
            {
                testPass = rs.getString(1);
            }
            JFrame f = new JFrame();
            newPass = JOptionPane.showInputDialog(f, "Current Password : "+testPass+"\nEnter New Password :", "Change Password", JOptionPane.INFORMATION_MESSAGE);
            if(newPass==null)
                throw new ChgPassException("Cancel is pressed");
            else if(newPass.trim().equals(""))
            {
                JOptionPane.showMessageDialog(f, "Enter Something");
                throw new ChgPassException("Enter Something");
            }
            st.executeUpdate("UPDATE `"+subject+"`.`online_test` SET `Test_Name`='"+testname+"',"+
                                    "`Number_of_Questions`='"+table2.getModel().getValueAt(row, 1)+"',"+
                                    " `password`='"+newPass+"' WHERE `Test_Name`='"+testname+"'");
            JOptionPane.showMessageDialog(f, "Password Changed Successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
            con.close();
        }
        catch(ChgPassException e)
        {
            System.out.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Select a Test First","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_chgpassActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try
        {
            int row = table2.getSelectedRow();
            testname = table2.getModel().getValueAt(row, 0).toString();
            JFrame f1 = new JFrame();
            int i = JOptionPane.showConfirmDialog(f1, "Are you sure want to delete this test?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
            if(i==0)
            {
                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizza","root","");

                st = con.createStatement();
            
                st.executeUpdate("DROP TABLE `"+subject+"`.`"+testname+"`");
                if(online)
                {
                st.executeUpdate("DELETE FROM `"+subject+"`.`online_test` WHERE `Test_Name`='"+testname+"'");
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Test Deleted.!","Deleted",JOptionPane.INFORMATION_MESSAGE);
                new ViewPreviousTest(username,subject,true).setVisible(true);
                this.setVisible(false);
                }
                else
                {
                    st.executeUpdate("DELETE FROM `"+subject+"`.`test` WHERE `Test_Name`='"+testname+"'");
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Test Deleted.!","Deleted",JOptionPane.INFORMATION_MESSAGE);
                    new ViewPreviousTest(username,subject,false).setVisible(true);
                    this.setVisible(false);
                }
                con.close();
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Select a Test First","Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_deleteActionPerformed

    public void jbActionPerformed(java.awt.event.ActionEvent evt)
    {
        String srchtest = jf.getText();
        boolean strue = false;
        int i;
        for(i=0; i<size; i++)
        {
            if(srchtest.equals(tab[i][0]))
            {
                strue = true;
                break;
            }
        }
        if(strue)
        {
            table2.setRowSelectionInterval(i, i);
        }
        else
        {
            if(srchtest.equals("Search test..."))
                srchtest = "";
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Test "+srchtest+" does not found!", "Oops", JOptionPane.OK_OPTION);
        }
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
            java.util.logging.Logger.getLogger(ViewPreviousTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPreviousTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPreviousTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPreviousTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPreviousTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chgpass;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JTable table2;
    private javax.swing.JButton update;
    private javax.swing.JButton viewpass;
    // End of variables declaration//GEN-END:variables
}

class ChgPassException extends Exception{
    public ChgPassException(String s)
    {
        super(s);
    }
}