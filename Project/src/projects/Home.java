/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author san
 */
public class Home extends javax.swing.JFrame {

    String username,subject,chatName;
    ClientGroup tc = new ClientGroup();
    ClientChat sn = new ClientChat();
    Notice n = new Notice();
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        notice1.setVisible(false);
        notice1.doClick();
    }
    public Home(String username,String subject,String name)
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.username = username;
        this.subject = subject;
        n.name = name;
        notice1.setVisible(false);
        notice1.doClick();
        searchChat();
    }
    
    public Home(String username,String subject)
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.username = username;
        this.subject = subject;
        notice1.setVisible(false);
        notice1.doClick();
        searchChat();
    }
    
    void searchChat()
    {
        srch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(srch.getText().equals("Search...")){
                srch.setForeground(Color.black);
                srch.setText("");}
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(srch.getText().trim().equals("")){
                srch.setForeground(Color.GRAY);
                srch.setText("Search...");}
            }
        });
        srch.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int ch = e.getKeyChar();
                if(ch==KeyEvent.VK_ENTER)
                {
                    String searchChat = srch.getText();
                    boolean ctrue = false;
                    int i;
                    for(i=0;(i<chattb.getRowCount());i++)
                    {
                        if(searchChat.trim().equalsIgnoreCase(chattb.getModel().getValueAt(i, 0).toString())){
                            ctrue = true;
                            break;
                        }
                    }
                    if(ctrue)
                        chattb.setRowSelectionInterval(i, i);
                    else
                    {
                        if(searchChat.equals("Search test..."))
                            searchChat = "";
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Person named "+searchChat+" does not found!", "Oops", JOptionPane.OK_OPTION);
                    }
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPopUp = new javax.swing.JPopupMenu();
        profile = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        user = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        groupPanel = new javax.swing.JPanel();
        grpChat = new javax.swing.JLabel();
        chatPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chattb = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        srch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        viewprevtest = new javax.swing.JButton();
        viewcurrtest = new javax.swing.JButton();
        createcurrtest = new javax.swing.JButton();
        createnewtest = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        noticepanel1 = new javax.swing.JPanel();
        notice1 = new javax.swing.JButton();

        profile.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        profile.setText("Profile");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        userPopUp.add(profile);

        Logout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        userPopUp.add(Logout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(540, 300));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projects/Users-Name-icon.png"))); // NOI18N
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setOpaque(true);

        jSeparator4.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator4.setOpaque(true);

        groupPanel.setPreferredSize(new java.awt.Dimension(512, 500));

        grpChat.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        grpChat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grpChat.setText("Start Subject Group Chat");
        grpChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grpChatMousePressed(evt);
            }
        });

        javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
        groupPanel.setLayout(groupPanelLayout);
        groupPanelLayout.setHorizontalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(grpChat, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
        );
        groupPanelLayout.setVerticalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(grpChat, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        chattb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"name1"},
                {"name2"},
                {"name3"},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        chattb.setIntercellSpacing(new java.awt.Dimension(10, 1));
        chattb.setRequestFocusEnabled(false);
        chattb.setRowHeight(25);
        chattb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chattbMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(chattb);
        if (chattb.getColumnModel().getColumnCount() > 0) {
            chattb.getColumnModel().getColumn(0).setResizable(false);
        }

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);

        srch.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        srch.setForeground(new java.awt.Color(102, 102, 102));
        srch.setText("Search...");
        srch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                srchFocusGained(evt);
            }
        });
        srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("International Institute of Professional Studies");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quizza");

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        viewprevtest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewprevtest.setText("View Previous Tests");
        viewprevtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewprevtestActionPerformed(evt);
            }
        });

        viewcurrtest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewcurrtest.setText("View Current Test");
        viewcurrtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcurrtestActionPerformed(evt);
            }
        });

        createcurrtest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createcurrtest.setText("Create Current Test");
        createcurrtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createcurrtestActionPerformed(evt);
            }
        });

        createnewtest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createnewtest.setText("Create New Test");
        createnewtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createnewtestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewcurrtest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewprevtest, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createnewtest, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createcurrtest))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewprevtest)
                    .addComponent(createnewtest))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createcurrtest)
                    .addComponent(viewcurrtest))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("View Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        noticepanel1.setBackground(new java.awt.Color(0, 51, 102));
        noticepanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        notice1.setText("Notice");
        notice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notice1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout noticepanel1Layout = new javax.swing.GroupLayout(noticepanel1);
        noticepanel1.setLayout(noticepanel1Layout);
        noticepanel1Layout.setHorizontalGroup(
            noticepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noticepanel1Layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(notice1)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        noticepanel1Layout.setVerticalGroup(
            noticepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noticepanel1Layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(notice1)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(noticepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(77, 77, 77)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(161, 161, 161)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(noticepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(srch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        new TeacherLogin().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LogoutActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        userPopUp.show(jPanel1, user.getX()-38, user.getY()+42);
        //userPopUp.show(this, 535, 65);
    }//GEN-LAST:event_userActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        new Profile(username,subject).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_profileActionPerformed

    private void createnewtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createnewtestActionPerformed
        new CreateNewTest(username,subject,false).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createnewtestActionPerformed

    private void viewprevtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewprevtestActionPerformed
        new ViewPreviousTest(username,subject,false).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewprevtestActionPerformed

    private void createcurrtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createcurrtestActionPerformed
        new CreateNewTest(username,subject,true).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createcurrtestActionPerformed

    private void viewcurrtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcurrtestActionPerformed
        new ViewPreviousTest(username,subject,true).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewcurrtestActionPerformed

    private void srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srchActionPerformed

    private void srchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_srchFocusGained
        srch.selectAll();
    }//GEN-LAST:event_srchFocusGained

    private void grpChatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grpChatMousePressed
        grpChat.setVisible(false);
        new ClientGroup(tc);
        tc.subject="UNIX";
        groupPanel.add(tc);
        tc.setVisible(true);
        javax.swing.plaf.basic.BasicInternalFrameUI ifu = (javax.swing.plaf.basic.BasicInternalFrameUI) tc.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
    }//GEN-LAST:event_grpChatMousePressed

    private void chattbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chattbMousePressed
        int row = chattb.getSelectedRow();
        chatName = chattb.getModel().getValueAt(row, 0).toString();
        new ClientChat(sn);
        sn.chatname = chatName;
        chatPanel.add(sn);
        sn.setVisible(true);
        javax.swing.plaf.basic.BasicInternalFrameUI ifu = (javax.swing.plaf.basic.BasicInternalFrameUI) sn.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
    }//GEN-LAST:event_chattbMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ViewPreviousTest(username,subject,true,true).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void notice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notice1ActionPerformed
        new Notice(n);
        n.forteacher();
        noticepanel1.add(n);
        n.setVisible(true);
        javax.swing.plaf.basic.BasicInternalFrameUI ifu = (javax.swing.plaf.basic.BasicInternalFrameUI) n.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
    }//GEN-LAST:event_notice1ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Logout;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JTable chattb;
    private javax.swing.JButton createcurrtest;
    private javax.swing.JButton createnewtest;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JLabel grpChat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton notice;
    private javax.swing.JButton notice1;
    private javax.swing.JPanel noticepanel;
    private javax.swing.JPanel noticepanel1;
    private javax.swing.JMenuItem profile;
    private javax.swing.JTextField srch;
    private javax.swing.JButton user;
    private javax.swing.JPopupMenu userPopUp;
    private javax.swing.JButton viewcurrtest;
    private javax.swing.JButton viewprevtest;
    // End of variables declaration//GEN-END:variables

}
