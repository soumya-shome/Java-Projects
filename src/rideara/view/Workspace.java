package rideara.view;

import java.time.*;
import java.time.format.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rideara.controller.Station;
import rideara.controller.User;
import rideara.controller.controller;

public final class Workspace extends javax.swing.JFrame {
    User user;
    Station stat;
    private final controller cont;
    private int wallet;
    public Workspace(User user) {
        initComponents();
        this.cont=controller.getController();
        this.user=user;
        this.stat=this.cont.Stations();
        setName();
        setWallet();
        setStations(); 
        setTable();
        setLocationRelativeTo(null);
    }

    void setName(){
        name.setText(this.user.getName());
        lastname.setText(this.user.getLastName());
        usrname.setText(this.user.getUserName());
        cPane.setSelectedIndex(1);
    }
    
    void setWallet(){
        this.wallet=Integer.parseInt(this.cont.baln(this.user.getUserName()));
        wbal.setText(String.valueOf(this.wallet));
    }
    
    void setStations(){
        String[] st=this.stat.getStation();
        for(int i=0;i<st.length;i++){
            pickup.addItem(st[i]);
            destination.addItem(st[i]);
        }
    }
    
    void setTable(){
        DefaultTableModel model=(DefaultTableModel) rides_t.getModel();
        String[] cols={"From", "To", "Total Time","Total Fare"};
        String[][] data={
            {"No Data"},
            {"from1","To1","Tot_321","Fare_123"}
        };
        
        model.setDataVector(data,cols);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        ride_s = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        bProfile = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cPMain = new javax.swing.JPanel();
        cPane = new javax.swing.JTabbedPane();
        profile = new javax.swing.JPanel();
        Wallet = new javax.swing.JPanel();
        cBalance = new javax.swing.JLabel();
        wbal = new javax.swing.JLabel();
        rechargeText = new javax.swing.JLabel();
        _50 = new javax.swing.JButton();
        _100 = new javax.swing.JButton();
        _150 = new javax.swing.JButton();
        Profile = new javax.swing.JPanel();
        fName = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        Lname = new javax.swing.JLabel();
        uName = new javax.swing.JLabel();
        usrname = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        Brides = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pickup = new javax.swing.JComboBox<>();
        From = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pick = new javax.swing.JLabel();
        dest = new javax.swing.JLabel();
        destination = new javax.swing.JComboBox<>();
        bookr = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        r_status = new javax.swing.JLabel();
        rides = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rides_t = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rideara");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jSplitPane1.setDividerSize(1);

        bProfile.setText("Profile");
        bProfile.setMaximumSize(new java.awt.Dimension(60, 20));
        bProfile.setMinimumSize(new java.awt.Dimension(60, 20));
        bProfile.setPreferredSize(new java.awt.Dimension(60, 60));
        bProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProfileActionPerformed(evt);
            }
        });

        jButton2.setText("Book a Ride");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("My Rides");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(bProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        jButton2.getAccessibleContext().setAccessibleName("Book a\n Ride");

        jSplitPane1.setLeftComponent(jPanel3);

        Wallet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Wallet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14))); // NOI18N

        cBalance.setText("Current Balance :");

        wbal.setText(" ");

        rechargeText.setText("Recharge with :");

        _50.setText("50");

        _100.setText("100");

        _150.setText("150");

        javax.swing.GroupLayout WalletLayout = new javax.swing.GroupLayout(Wallet);
        Wallet.setLayout(WalletLayout);
        WalletLayout.setHorizontalGroup(
            WalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WalletLayout.createSequentialGroup()
                .addGroup(WalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WalletLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(rechargeText))
                    .addGroup(WalletLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cBalance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wbal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(WalletLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(_50, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_100, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_150, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        WalletLayout.setVerticalGroup(
            WalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WalletLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(WalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wbal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(rechargeText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_150, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        Profile.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14))); // NOI18N

        fName.setText("First Name : ");

        Lname.setText("Last Name :");

        uName.setText("Username : ");

        Logout.setText("LogOut");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Logout))
                    .addGroup(ProfileLayout.createSequentialGroup()
                        .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Lname)
                            .addComponent(uName)
                            .addComponent(fName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usrname, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usrname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Wallet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addComponent(Profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Wallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 215, Short.MAX_VALUE))
        );

        cPane.addTab("Profile", profile);

        jLabel2.setText("Pick-up :");

        jLabel8.setText("Destination :");

        pickup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        pickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickupActionPerformed(evt);
            }
        });

        From.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "To be added later" }));
        From.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FromActionPerformed(evt);
            }
        });

        jLabel1.setText("Pickup Time:");

        destination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        destination.setToolTipText("");
        destination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationActionPerformed(evt);
            }
        });

        bookr.setText("Book Ride");
        bookr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookrActionPerformed(evt);
            }
        });

        ride_s.add(jRadioButton1);
        jRadioButton1.setText("Ride Now");

        ride_s.add(jRadioButton2);
        jRadioButton2.setText("Schedule Ride");

        javax.swing.GroupLayout BridesLayout = new javax.swing.GroupLayout(Brides);
        Brides.setLayout(BridesLayout);
        BridesLayout.setHorizontalGroup(
            BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BridesLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BridesLayout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BridesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(From, 0, 124, Short.MAX_VALUE))
                            .addComponent(jRadioButton2)))
                    .addGroup(BridesLayout.createSequentialGroup()
                        .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BridesLayout.createSequentialGroup()
                                .addComponent(bookr, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_status, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BridesLayout.createSequentialGroup()
                                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addGap(5, 5, 5)
                                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pickup, 0, 70, Short.MAX_VALUE)
                                    .addComponent(destination, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dest, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(pick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        BridesLayout.setVerticalGroup(
            BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BridesLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pickup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pick, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dest, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(From, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(BridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BridesLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(bookr, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BridesLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(r_status, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(362, Short.MAX_VALUE))
        );

        cPane.addTab("Book Ride", Brides);

        rides_t.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "To", "Total Time", "Total Fare"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rides_t);
        if (rides_t.getColumnModel().getColumnCount() > 0) {
            rides_t.getColumnModel().getColumn(0).setResizable(false);
            rides_t.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout ridesLayout = new javax.swing.GroupLayout(rides);
        rides.setLayout(ridesLayout);
        ridesLayout.setHorizontalGroup(
            ridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        ridesLayout.setVerticalGroup(
            ridesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ridesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 199, Short.MAX_VALUE))
        );

        cPane.addTab("My Ride", rides);

        javax.swing.GroupLayout cPMainLayout = new javax.swing.GroupLayout(cPMain);
        cPMain.setLayout(cPMainLayout);
        cPMainLayout.setHorizontalGroup(
            cPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cPane)
        );
        cPMainLayout.setVerticalGroup(
            cPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jSplitPane1.setRightComponent(cPMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cPane.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cPane.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProfileActionPerformed
        cPane.setSelectedIndex(0);
    }//GEN-LAST:event_bProfileActionPerformed

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        Login login=new Login();
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_LogoutMouseClicked

    private void pickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickupActionPerformed
        String s1=pickup.getSelectedItem().toString();
        pick.setText(s1);
    }//GEN-LAST:event_pickupActionPerformed

    private void destinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationActionPerformed
        String s2=destination.getSelectedItem().toString();
        String s=pick.getText();
        if(s!=null && s.equalsIgnoreCase(s2))
            JOptionPane.showMessageDialog(null, "Destination and Pickup cannot be same !!!!","Error", JOptionPane.WARNING_MESSAGE);
        else
            dest.setText(s2);
    }//GEN-LAST:event_destinationActionPerformed

    private void bookrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookrActionPerformed
        if(this.wallet<=50){
            JOptionPane.showMessageDialog(null, "Balance Low !!!!","Error", JOptionPane.WARNING_MESSAGE);
        }else{
            String p=pick.getText();
            String d=dest.getText();
            LocalTime myObj = LocalTime.now();
            String p_time=myObj.getHour()+":"+myObj.getMinute();
            boolean e=this.cont.setRide(this.user.getUserName(), p, d, p_time);
            if (e)
                r_status.setText("Ride Booked");
            else
                JOptionPane.showMessageDialog(null,"Booking Failed !!","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bookrActionPerformed

    private void FromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FromActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Brides;
    private javax.swing.JComboBox<String> From;
    private javax.swing.JLabel Lname;
    private javax.swing.JLabel Logout;
    private javax.swing.JPanel Profile;
    private javax.swing.JPanel Wallet;
    private javax.swing.JButton _100;
    private javax.swing.JButton _150;
    private javax.swing.JButton _50;
    private javax.swing.JButton bProfile;
    private javax.swing.JButton bookr;
    private javax.swing.JLabel cBalance;
    private javax.swing.JPanel cPMain;
    private javax.swing.JTabbedPane cPane;
    private javax.swing.JLabel dest;
    private javax.swing.JComboBox<String> destination;
    private javax.swing.JLabel fName;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel name;
    private javax.swing.JLabel pick;
    private javax.swing.JComboBox<String> pickup;
    private javax.swing.JPanel profile;
    private javax.swing.JLabel r_status;
    private javax.swing.JLabel rechargeText;
    private javax.swing.ButtonGroup ride_s;
    private javax.swing.JPanel rides;
    private javax.swing.JTable rides_t;
    private javax.swing.JLabel uName;
    private javax.swing.JLabel usrname;
    private javax.swing.JLabel wbal;
    // End of variables declaration//GEN-END:variables
}
