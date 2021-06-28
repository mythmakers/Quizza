/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class StudentTest extends javax.swing.JFrame {

    String testname,rollNo,subject;
    String q,op1,op2,op3,op4,correct;
    int qno=1,num,marks=0;
    boolean online,bool=true;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    StudentHome sh;
    
    int column = 0;
    //TableColumn col = questiontable.getColumnModel().getColumn(column);
    //col.setCellRenderer(new MyTableCellRenderer());
    /**
     * Creates new form StudentTest
     */
    public StudentTest() {
       initComponents();
       setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public StudentTest(String testname,String rollNo,String subject,boolean online,StudentHome sh)
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Frame f = new Frame();
        JOptionPane.showMessageDialog(f, "Your Test has been started", "Test", INFORMATION_MESSAGE);
        //JOptionPane.showInputDialog("enter password");
        this.testname = testname;
        this.rollNo = rollNo;
        this.subject = subject;
        this.online = online;
        this.sh = sh;
        testName.setText(testname);
        String query;
        DefaultTableModel model = (DefaultTableModel)questiontable.getModel();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+subject+"","root","");
            
            st = con.createStatement();
            if(online)
                query = "SELECT Number_of_Questions from `"+subject+"`.`online_test` where Test_Name='"+testname+"'";
            else
                query = "SELECT Number_of_Questions from `"+subject+"`.`test` where Test_Name='"+testname+"'";
            rs = st.executeQuery(query);
            if(rs.next())
            {
                num = rs.getInt(1);
            }
            String[] row = new String[1];
            for(int i=1;i<=num;i++)
            {
                row[0]="question "+i;
                model.addRow(row);
            }
            questionl.setText("Question "+qno+" out of "+num+" :");
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
        start(qno);
    }

    public void start(int qno)
    {
        JRadioButton[] buttons = new JRadioButton[]{option1,option2,option3,option4};
        for(JRadioButton btn : buttons)
        {
            btn.setEnabled(true);
        }
        if(qno<=num)
        {
            skipquestion.setEnabled(true);
            nextquestion.setEnabled(true);
        }
        options.clearSelection();
        questionl.setText("Question "+qno+" out of "+num+" :");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+subject+"","root","");
            
            st = con.createStatement();
            String query = "SELECT * FROM `"+subject+"`.`"+testname+"` WHERE Q_No='"+qno+"'";
            
            rs = st.executeQuery(query);
            if(rs.next())
            {
                q = rs.getString(2);
                op1 = rs.getString(3);
                op2 = rs.getString(4);
                op3 = rs.getString(5);
                op4 = rs.getString(6);
                correct = rs.getString(7);
            }
            
            question.setText(q);
            option1.setText(op1);
            option2.setText(op2);
            option3.setText(op3);
            option4.setText(op4);
            if(online)
                rs = st.executeQuery("SELECT `Selected_Answer` FROM `studentresult`.`online_"+testname+"_"+rollNo+"` WHERE Question_No='"+qno+"'");
            else
                rs = st.executeQuery("SELECT `Selected_Answer` FROM `studentresult`.`"+testname+"_"+rollNo+"` WHERE Question_No='"+qno+"'");
            if(rs.next())
            {
                String answer = rs.getString(1);
                if(answer.equals(op1))
                    option1.doClick();
                else if(answer.equals(op2))
                    option2.doClick();
                else if(answer.equals(op3))
                    option3.doClick();
                else if(answer.equals(op4))
                    option4.doClick();
                //System.out.println(answer+" "+op1+" "+op2+" "+op3+" "+op4);
                for(JRadioButton btn : buttons)
                {
                    btn.setEnabled(false);
                }
                nextquestion.setEnabled(false);
                skipquestion.setEnabled(false);
            }
            else{
                for(JRadioButton btn : buttons)
                {
                    btn.setEnabled(true);
                }
                nextquestion.setEnabled(true);
                skipquestion.setEnabled(true);
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
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        options = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        testName = new javax.swing.JLabel();
        questionl = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        nextquestion = new javax.swing.JButton();
        skipquestion = new javax.swing.JButton();
        time = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        questiontable = new javax.swing.JTable();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(540, 300));
        setPreferredSize(new java.awt.Dimension(600, 600));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        testName.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        testName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        testName.setText("Test Name");
        testName.setAlignmentX(5.0F);

        questionl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionl.setText("Question n out of num :");

        question.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        question.setText("question");

        option1.setBackground(new java.awt.Color(102, 204, 255));
        options.add(option1);
        option1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        option1.setText("option1");

        option3.setBackground(new java.awt.Color(102, 204, 255));
        options.add(option3);
        option3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        option3.setText("option3");

        option4.setBackground(new java.awt.Color(102, 204, 255));
        options.add(option4);
        option4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        option4.setText("option4");

        option2.setBackground(new java.awt.Color(102, 204, 255));
        options.add(option2);
        option2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        option2.setText("option2");

        nextquestion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nextquestion.setText("Submit Question");
        nextquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextquestionActionPerformed(evt);
            }
        });

        skipquestion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        skipquestion.setText("Skip Question");
        skipquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipquestionActionPerformed(evt);
            }
        });

        time.setText("Time");
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });

        questiontable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Questions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        questiontable.setColumnSelectionAllowed(true);
        questiontable.getTableHeader().setReorderingAllowed(false);
        questiontable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                questiontableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(questiontable);
        questiontable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (questiontable.getColumnModel().getColumnCount() > 0) {
            questiontable.getColumnModel().getColumn(0).setResizable(false);
        }

        submit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        submit.setText("Submit Test");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(option3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(option2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nextquestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(skipquestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(submit))
                    .addComponent(testName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(testName)
                        .addGap(67, 67, 67)
                        .addComponent(questionl)
                        .addGap(18, 18, 18)
                        .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(option1)
                            .addComponent(option2))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(option3)
                            .addComponent(option4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextquestion)
                            .addComponent(skipquestion)
                            .addComponent(submit)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(38, 38, 38))
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

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed

        
    }//GEN-LAST:event_timeActionPerformed

    private void questiontableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questiontableMousePressed
        qno = questiontable.getSelectedRow()+1;
        start(qno);
        //questiontable.setRowSelectionInterval(0, 0);
        questiontable.setSelectionBackground(Color.yellow);
        questiontable.setSelectionForeground(Color.red);
    }//GEN-LAST:event_questiontableMousePressed

    
    private void nextquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextquestionActionPerformed
        String query,ans = null;
        byte mark=0;
        
        if(!(option1.isSelected() || option2.isSelected() || option3.isSelected() || option4.isSelected()))
        {
            Frame f = new Frame();
            JOptionPane.showMessageDialog(f, "Select an option");
        }
        else
        {
            if(qno>=num)
            {
                nextquestion.setEnabled(false);
            }
            if(option1.isSelected())
                ans = option1.getText();
            else if(option2.isSelected())
                ans = option2.getText();
            else if(option3.isSelected())
                ans = option3.getText();
            else if(option4.isSelected())
                ans = option4.getText();
            
            if(ans.equals(correct))
            {
                mark=1;
                marks++;
            }
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentresult","root","");
            
                st = con.createStatement();
                if(online)
                    query = "INSERT INTO `studentresult`.`online_"+testname+"_"+rollNo+"` values('"+qno+"','"+ans+"','"+mark+"')";
                else
                    query = "INSERT INTO `studentresult`.`"+testname+"_"+rollNo+"` values('"+qno+"','"+ans+"','"+mark+"')";
            
                int i = st.executeUpdate(query);
                
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
            
            qno++;
            if(qno<=num)
                start(qno);
        }
    }//GEN-LAST:event_nextquestionActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String query;
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentresult","root","");
            
            st = con.createStatement();
            if(online)
                query = "INSERT INTO `studentresult`.`online_"+testname+"` values('"+rollNo+"','"+marks+"','"+date+"')";
            else
                query = "INSERT INTO `studentresult`.`"+testname+"` values('"+rollNo+"','"+marks+"','"+date+"')";
            
            int i = st.executeUpdate(query);
                
            con.close();
            JOptionPane.showMessageDialog(new JFrame(), "You Scored : "+marks+" marks", "Marks", JOptionPane.INFORMATION_MESSAGE);
            if(bool){
            sh.setVisible(true);
            this.setVisible(false);
            bool=false;
            }
        }
        catch (ClassNotFoundException e)
        {
             System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void skipquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipquestionActionPerformed
        if(qno>=num)
            skipquestion.setEnabled(false);
        qno++;
        if(qno<=num)
            start(qno);
    }//GEN-LAST:event_skipquestionActionPerformed

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
            java.util.logging.Logger.getLogger(StudentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextquestion;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.ButtonGroup options;
    private javax.swing.JLabel question;
    private javax.swing.JLabel questionl;
    private javax.swing.JTable questiontable;
    private javax.swing.JButton skipquestion;
    private javax.swing.JButton submit;
    private javax.swing.JLabel testName;
    private javax.swing.JButton time;
    // End of variables declaration//GEN-END:variables

}