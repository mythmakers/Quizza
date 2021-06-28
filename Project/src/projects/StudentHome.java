/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class StudentHome extends javax.swing.JFrame {

    String rollNo,grpsub,chatName;
    ClientGroup sc = new ClientGroup();
    ClientChat sn = new ClientChat();
    Notice n = new Notice();
    StudentLogin login;
    /**
     * Creates new form StudentHome
     */
    public StudentHome() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        searchChat();
        notice.setVisible(false);
        notice.doClick();
    }

    public StudentHome(String rollNo,StudentLogin login,String name)
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.rollNo = rollNo;
        this.login = login;
        searchChat();
        sn.name = name;
        sc.name = name;
        n.name = name;
        notice.setVisible(false);
        notice.doClick();
    }
    
    public StudentHome(String rollNo,ClientGroup sc)
    {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.rollNo = rollNo;
        this.sc = sc;
        notice.setVisible(false);
        notice.doClick();
    }

    public void searchChat(){
        srch1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(srch1.getText().equals("Search...")){
                srch1.setForeground(Color.black);
                srch1.setText("");}
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(srch1.getText().trim().equals("")){
                srch1.setForeground(Color.GRAY);
                srch1.setText("Search...");}
            }
        });
        srch1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int ch = e.getKeyChar();
                if(ch==KeyEvent.VK_ENTER)
                {
                    String searchChat = srch1.getText();
                    boolean ctrue = false;
                    int i;
                    for(i=0;(i<grouptb1.getRowCount());i++)
                    {
                        if(searchChat.trim().equalsIgnoreCase(grouptb1.getModel().getValueAt(i, 0).toString())){
                            ctrue = true;
                            break;
                        }
                    }
                    if(ctrue)
                        grouptb1.setRowSelectionInterval(i, i);
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
        srch2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(srch2.getText().equals("Search...")){
                srch2.setForeground(Color.black);
                srch2.setText("");}
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(srch2.getText().trim().equals("")){
                srch2.setForeground(Color.GRAY);
                srch2.setText("Search...");}
            }
        });
        srch2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int ch = e.getKeyChar();
                if(ch==KeyEvent.VK_ENTER)
                {
                    String searchChat = srch2.getText();
                    boolean ctrue = false;
                    int i;
                    for(i=0;(i<grouptb.getRowCount());i++)
                    {
                        if(searchChat.trim().equalsIgnoreCase(grouptb.getModel().getValueAt(i, 0).toString())){
                            ctrue = true;
                            break;
                        }
                    }
                    if(ctrue)
                        grouptb.setRowSelectionInterval(i, i);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        user = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grouptb = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        grouptb1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        srch1 = new javax.swing.JTextField();
        srch2 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        groupPanel = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        chatPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        sub = new javax.swing.JComboBox<>();
        ongoingtest = new javax.swing.JButton();
        studentviewprevtest = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        noticepanel = new javax.swing.JPanel();
        notice = new javax.swing.JButton();

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
        setPreferredSize(new java.awt.Dimension(600, 600));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 700));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projects/Users-Name-icon.png"))); // NOI18N
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        grouptb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"UNIX"},
                {"SAD"},
                {"CG"}
            },
            new String [] {
                "Group Chats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grouptb.setRowHeight(25);
        grouptb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grouptbMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(grouptb);
        if (grouptb.getColumnModel().getColumnCount() > 0) {
            grouptb.getColumnModel().getColumn(0).setResizable(false);
        }

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jSeparator1.setOpaque(true);

        grouptb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"name1"},
                {"name2"},
                {"name3"}
            },
            new String [] {
                "Chats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grouptb1.setIntercellSpacing(new java.awt.Dimension(10, 1));
        grouptb1.setRowHeight(25);
        grouptb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grouptb1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(grouptb1);
        if (grouptb1.getColumnModel().getColumnCount() > 0) {
            grouptb1.getColumnModel().getColumn(0).setResizable(false);
        }

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        srch1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        srch1.setForeground(new java.awt.Color(102, 102, 102));
        srch1.setText("Search...");
        srch1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                srch1FocusGained(evt);
            }
        });

        srch2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        srch2.setForeground(new java.awt.Color(102, 102, 102));
        srch2.setText("Search...");
        srch2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                srch2FocusGained(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setOpaque(true);

        groupPanel.setBackground(new java.awt.Color(153, 153, 255));
        groupPanel.setPreferredSize(new java.awt.Dimension(512, 500));

        javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
        groupPanel.setLayout(groupPanelLayout);
        groupPanelLayout.setHorizontalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        groupPanelLayout.setVerticalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jSeparator4.setBackground(new java.awt.Color(0, 102, 102));
        jSeparator4.setOpaque(true);

        chatPanel.setBackground(new java.awt.Color(153, 153, 255));

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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("International Institute of Professional Studies");

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        sub.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "subject", "computer graphics", "human computer interaction", "system analysis and design", "unix" }));

        ongoingtest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ongoingtest.setText("On Going Test");
        ongoingtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ongoingtestActionPerformed(evt);
            }
        });

        studentviewprevtest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentviewprevtest.setText("Previous Test");
        studentviewprevtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentviewprevtestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ongoingtest, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(studentviewprevtest, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentviewprevtest)
                    .addComponent(ongoingtest))
                .addContainerGap(332, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quizza");

        noticepanel.setBackground(new java.awt.Color(0, 51, 102));
        noticepanel.setPreferredSize(new java.awt.Dimension(400, 500));

        notice.setText("Notice");
        notice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noticeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout noticepanelLayout = new javax.swing.GroupLayout(noticepanel);
        noticepanel.setLayout(noticepanelLayout);
        noticepanelLayout.setHorizontalGroup(
            noticepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noticepanelLayout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(notice)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        noticepanelLayout.setVerticalGroup(
            noticepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noticepanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(srch1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srch2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(noticepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(srch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(srch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noticepanel, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane3.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1287, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        new StudentProfile(rollNo,sc).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_profileActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LogoutActionPerformed

    private void grouptb1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grouptb1MousePressed
        int row = grouptb1.getSelectedRow();
        chatName = grouptb1.getModel().getValueAt(row, 0).toString();
        new ClientChat(sn);
        sn.chatname = chatName;
        chatPanel.add(sn);
        sn.setVisible(true);
        javax.swing.plaf.basic.BasicInternalFrameUI ifu = (javax.swing.plaf.basic.BasicInternalFrameUI) sn.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
    }//GEN-LAST:event_grouptb1MousePressed

    private void grouptbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grouptbMousePressed
        int row = grouptb.getSelectedRow();
        grpsub = grouptb.getModel().getValueAt(row, 0).toString();
        new ClientGroup(sc);
        sc.subject = grpsub;
        groupPanel.add(sc);
        sc.setVisible(true);
        javax.swing.plaf.basic.BasicInternalFrameUI ifu = (javax.swing.plaf.basic.BasicInternalFrameUI) sc.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
    }//GEN-LAST:event_grouptbMousePressed

    private void ongoingtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ongoingtestActionPerformed
        if(!sub.getSelectedItem().toString().contentEquals("subject"))
        {
            String subject = sub.getSelectedItem().toString();
            sub.setSelectedIndex(0);
            new StudentViewPreviousTest(rollNo,subject,true,sc,this).setVisible(true);
            this.setVisible(false);
        }
        else
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Select Subject");
        }
    }//GEN-LAST:event_ongoingtestActionPerformed

    private void studentviewprevtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentviewprevtestActionPerformed
        if(!sub.getSelectedItem().toString().contentEquals("subject"))
        {
            String subject = sub.getSelectedItem().toString();
            sub.setSelectedIndex(0);
            new StudentViewPreviousTest(rollNo,subject,false,sc,this).setVisible(true);
            this.setVisible(false);
        }
        else
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Select Subject");
        }
    }//GEN-LAST:event_studentviewprevtestActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        userPopUp.show(jPanel2, user.getX()-40, user.getY()+42);
    }//GEN-LAST:event_userActionPerformed

    private void srch2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_srch2FocusGained
        srch2.selectAll();
    }//GEN-LAST:event_srch2FocusGained

    private void srch1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_srch1FocusGained
        srch1.selectAll();
    }//GEN-LAST:event_srch1FocusGained

    private void noticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noticeActionPerformed
        new Notice(n);
        n.forstudent();
        noticepanel.add(n);
        n.setVisible(true);
        javax.swing.plaf.basic.BasicInternalFrameUI ifu = (javax.swing.plaf.basic.BasicInternalFrameUI) n.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ifu).setNorthPane(null);
    }//GEN-LAST:event_noticeActionPerformed

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
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Logout;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JTable grouptb;
    private javax.swing.JTable grouptb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton notice;
    private javax.swing.JPanel noticepanel;
    private javax.swing.JButton ongoingtest;
    private javax.swing.JMenuItem profile;
    private javax.swing.JTextField srch1;
    private javax.swing.JTextField srch2;
    private javax.swing.JButton studentviewprevtest;
    private javax.swing.JComboBox<String> sub;
    private javax.swing.JButton user;
    private javax.swing.JPopupMenu userPopUp;
    // End of variables declaration//GEN-END:variables
}
