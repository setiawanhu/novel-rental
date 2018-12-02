/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;

import model.User;

public class Home extends javax.swing.JFrame {
    private User authUser;
    
    /**
     * Creates new form home
     */
    public Home(){
        initComponents();
    }
    
    public Home(User authUser){
        initComponents();
        this.authUser = authUser;
        checkAuthorization();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        left_SidePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnMember = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnHome = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnUser = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnNovel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnGenre = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnLog = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        home_page = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        mdNovel_page = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        mdMember_page = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        mdGenre_page = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(153, 153, 153));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left_SidePanel.setBackground(new java.awt.Color(0, 153, 255));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Haettenschweiler", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RentalNovel");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        btnMember.setBackground(new java.awt.Color(102, 255, 255));
        btnMember.setForeground(new java.awt.Color(255, 255, 255));
        btnMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMemberMouseClicked(evt);
            }
        });
        btnMember.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Master Data Member");
        btnMember.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, 30));

        btnHome.setBackground(new java.awt.Color(102, 255, 255));
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
        });
        btnHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Transaction");
        btnHome.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 30));

        btnUser.setBackground(new java.awt.Color(102, 255, 255));
        btnUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserMouseClicked(evt);
            }
        });
        btnUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Master Data User");
        btnUser.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 30));

        btnHistory.setBackground(new java.awt.Color(102, 255, 255));
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoryMouseClicked(evt);
            }
        });
        btnHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Transaction History");
        btnHistory.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 30));

        btnNovel.setBackground(new java.awt.Color(102, 255, 255));
        btnNovel.setForeground(new java.awt.Color(255, 255, 255));
        btnNovel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNovelMousePressed(evt);
            }
        });
        btnNovel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Master Data Novel");
        btnNovel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, 30));

        btnGenre.setBackground(new java.awt.Color(102, 255, 255));
        btnGenre.setForeground(new java.awt.Color(255, 255, 255));
        btnGenre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnGenreMousePressed(evt);
            }
        });
        btnGenre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Master Data Genre");
        btnGenre.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, 30));

        btnLog.setBackground(new java.awt.Color(102, 255, 255));
        btnLog.setForeground(new java.awt.Color(255, 255, 255));
        btnLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogMouseClicked(evt);
            }
        });
        btnLog.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Logs");
        btnLog.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 30));

        btnReturn.setBackground(new java.awt.Color(102, 255, 255));
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReturnMouseClicked(evt);
            }
        });
        btnReturn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Novel Return");
        btnReturn.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 30));

        javax.swing.GroupLayout left_SidePanelLayout = new javax.swing.GroupLayout(left_SidePanel);
        left_SidePanel.setLayout(left_SidePanelLayout);
        left_SidePanelLayout.setHorizontalGroup(
            left_SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_SidePanelLayout.createSequentialGroup()
                .addGroup(left_SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(left_SidePanelLayout.createSequentialGroup()
                        .addGroup(left_SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(left_SidePanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4))
                            .addGroup(left_SidePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(left_SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNovel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(left_SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMember, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left_SidePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(left_SidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        left_SidePanelLayout.setVerticalGroup(
            left_SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_SidePanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNovel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMember, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        background.add(left_SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 670));

        header.setBackground(new java.awt.Color(255, 255, 255));

        btnLogout.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OnClick(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(555, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 630, 40));

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_page.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Haettenschweiler", 0, 72)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Rental Novel");

        javax.swing.GroupLayout home_pageLayout = new javax.swing.GroupLayout(home_page);
        home_page.setLayout(home_pageLayout);
        home_pageLayout.setHorizontalGroup(
            home_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_pageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(163, 163, 163))
        );
        home_pageLayout.setVerticalGroup(
            home_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_pageLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );

        main.add(home_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 590));

        mdNovel_page.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Haettenschweiler", 0, 72)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Master Data Member");

        javax.swing.GroupLayout mdNovel_pageLayout = new javax.swing.GroupLayout(mdNovel_page);
        mdNovel_page.setLayout(mdNovel_pageLayout);
        mdNovel_pageLayout.setHorizontalGroup(
            mdNovel_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mdNovel_pageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(73, 73, 73))
        );
        mdNovel_pageLayout.setVerticalGroup(
            mdNovel_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mdNovel_pageLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        main.add(mdNovel_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 520));

        mdMember_page.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Haettenschweiler", 0, 72)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Master Data Novel");

        javax.swing.GroupLayout mdMember_pageLayout = new javax.swing.GroupLayout(mdMember_page);
        mdMember_page.setLayout(mdMember_pageLayout);
        mdMember_pageLayout.setHorizontalGroup(
            mdMember_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mdMember_pageLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mdMember_pageLayout.setVerticalGroup(
            mdMember_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mdMember_pageLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        main.add(mdMember_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 520));

        mdGenre_page.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Haettenschweiler", 0, 72)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Master Data Genre");

        javax.swing.GroupLayout mdGenre_pageLayout = new javax.swing.GroupLayout(mdGenre_page);
        mdGenre_page.setLayout(mdGenre_pageLayout);
        mdGenre_pageLayout.setHorizontalGroup(
            mdGenre_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mdGenre_pageLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mdGenre_pageLayout.setVerticalGroup(
            mdGenre_pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mdGenre_pageLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
        );

        main.add(mdGenre_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 520));

        background.add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 630, 590));

        footer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("| 2018 RentalNovel");

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("| About Us");

        lblName.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 153, 255));
        lblName.setText("Name");

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(8, 8, 8))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(lblName))
                .addContainerGap())
        );

        background.add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 630, 630, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OnClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OnClick
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_OnClick

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        //
    }//GEN-LAST:event_jLabel4MousePressed

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        dispose();
        new Transaction(authUser).setVisible(true);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseClicked
        dispose();
        new TransactionHistory(authUser).setVisible(true);
    }//GEN-LAST:event_btnHistoryMouseClicked

    private void btnUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseClicked
        dispose();
        new MasterUser(authUser).setVisible(true);
    }//GEN-LAST:event_btnUserMouseClicked

    private void btnNovelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovelMousePressed
        dispose();
        new MasterNovel(authUser).setVisible(true);
    }//GEN-LAST:event_btnNovelMousePressed

    private void btnGenreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenreMousePressed
        dispose();
        new MasterGenre(authUser).setVisible(true);
    }//GEN-LAST:event_btnGenreMousePressed

    private void btnMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMemberMouseClicked
        dispose();
        new MasterMember(authUser).setVisible(true);
    }//GEN-LAST:event_btnMemberMouseClicked

    private void btnLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogMouseClicked
        dispose();
        new MasterLog(authUser).setVisible(true);
    }//GEN-LAST:event_btnLogMouseClicked

    private void btnReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseClicked
        dispose();
        new TransactionReturn(authUser).setVisible(true);
    }//GEN-LAST:event_btnReturnMouseClicked

    /**
     * Checking the user's type
     * 
     */
    private void checkAuthorization(){
        lblName.setText("Hello, " + authUser.getName());
        
        if(authUser.getRole().equals("Pegawai")){
            btnUser.setVisible(false);
            btnLog.setVisible(false);
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel btnGenre;
    private javax.swing.JPanel btnHistory;
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnLog;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JPanel btnMember;
    private javax.swing.JPanel btnNovel;
    private javax.swing.JPanel btnReturn;
    private javax.swing.JPanel btnUser;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JPanel home_page;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel left_SidePanel;
    private javax.swing.JPanel main;
    private javax.swing.JPanel mdGenre_page;
    private javax.swing.JPanel mdMember_page;
    private javax.swing.JPanel mdNovel_page;
    // End of variables declaration//GEN-END:variables
}
