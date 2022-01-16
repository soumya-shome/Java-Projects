package ims;

import ims.database.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Booking extends javax.swing.JFrame {

    String UserID;
    
    ClientDb ob;
    Details obj;
    ResultSet rs=null;
    ArrayList<String> shid= new ArrayList<>();
    ArrayList<String> shname= new ArrayList<>();
    ArrayList<String> pid= new ArrayList<>();
    ArrayList<String> pname= new ArrayList<>();
    public Booking(String id){
        UserID=id;
        initComponents();
        setLocationRelativeTo(null);
        ob=new ClientDb();
        obj=new Details();
        addShID();
        addPID();
        t_cid.setText(UserID);
    }

    final void addShID(){
        rs=obj.getShID();
        try {
            while(rs.next()){
                t_shid.addItem(rs.getString("name"));
                shid.add(rs.getString("sh_id"));
                shname.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppToWare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    final void addPID(){
        rs=obj.getPID();
        try {
            while(rs.next()){
                t_pid.addItem(rs.getString("name"));
                pid.add(rs.getString("p_id"));
                pname.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppToWare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    final void getCount(){
        String sh_id=this.shid.get(shname.indexOf(t_shid.getSelectedItem().toString()));
        String p_id=this.pid.get(pname.indexOf(t_pid.getSelectedItem().toString()));
        msg.setText(ob.getShCount(sh_id,p_id));
    }
    
    public void refreshData(){
        t_pqt.setText("");
        t_cid.setText("");
        t_cname.setText("");
        t_cph.setText("");
        t_pqt.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        t_cid = new javax.swing.JTextField();
        t_cname = new javax.swing.JTextField();
        bshow = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bclose = new javax.swing.JButton();
        t_shid = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_cph = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ttable = new javax.swing.JTable();
        bbook = new javax.swing.JButton();
        t_pid = new javax.swing.JComboBox<>();
        t_pqt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t_date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        llabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 400));
        setResizable(false);

        t_cid.setEditable(false);

        bshow.setText("Show");
        bshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bshowActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantity :");

        bclose.setText("Close");
        bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcloseActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Booking Details :");

        jLabel1.setText("User ID :");

        jLabel2.setText("Name :");

        jLabel3.setText("Phone No. :");

        jLabel4.setText("Product ID :");

        ttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ttable);

        bbook.setText("Book");
        bbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbookActionPerformed(evt);
            }
        });

        t_pqt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                t_pqtMouseEntered(evt);
            }
        });

        jLabel7.setText("Shop ID :");

        jLabel8.setText("Purchase Date :");

        llabel.setText("Available :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bbook)
                                .addGap(2, 2, 2)
                                .addComponent(bshow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bclose))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(llabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(t_date, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(t_cid)
                                        .addComponent(t_cname)
                                        .addComponent(t_cph)
                                        .addComponent(t_pid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(t_pqt, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(t_shid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(t_cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(t_cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(t_cph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(t_pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_shid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(t_pqt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(llabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bbook)
                            .addComponent(bshow)
                            .addComponent(bclose))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(63, 63, 63))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbookActionPerformed
        if(Integer.parseInt(t_pqt.getText())<=Integer.parseInt(msg.getText()))
        {
            String uid=t_cid.getText();
            String uname=t_cname.getText();
            String uph=t_cph.getText();
            String pid=this.pid.get(pname.indexOf((t_pid.getSelectedItem().toString())));
            String pqty=t_pqt.getText();
            String shid=this.shid.get(shname.indexOf((t_shid.getSelectedItem().toString())));
            SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
            String tdate=sd.format(t_date.getDate());
            ob.saveBook(uid,uname,uph,pid,pqty,shid,tdate);
            ttable.setModel(DbUtils.resultSetToTableModel(ob.getData(UserID)));
        }
        else
            JOptionPane.showMessageDialog(null, "Not Enough Stock Available !!","Error", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_bbookActionPerformed

    private void bshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bshowActionPerformed
        ttable.setModel(DbUtils.resultSetToTableModel(ob.getData(UserID)));
    }//GEN-LAST:event_bshowActionPerformed

    private void bcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcloseActionPerformed
        dispose();
        new CDashboard(UserID).setVisible(true);
    }//GEN-LAST:event_bcloseActionPerformed

    private void t_pqtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_pqtMouseEntered
        getCount();
    }//GEN-LAST:event_t_pqtMouseEntered

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
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbook;
    private javax.swing.JButton bclose;
    private javax.swing.JButton bshow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel llabel;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField t_cid;
    private javax.swing.JTextField t_cname;
    private javax.swing.JTextField t_cph;
    private com.toedter.calendar.JDateChooser t_date;
    private javax.swing.JComboBox<String> t_pid;
    private javax.swing.JTextField t_pqt;
    private javax.swing.JComboBox<String> t_shid;
    private javax.swing.JTable ttable;
    // End of variables declaration//GEN-END:variables
}
