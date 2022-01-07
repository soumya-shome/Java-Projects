
package ims;

import ims.database.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class WareToShow extends javax.swing.JFrame {

    SWShDb ob;
    Details obj;
    ResultSet rs=null;
    ArrayList<String> shid= new ArrayList<>();
    ArrayList<String> shname= new ArrayList<>();
    ArrayList<String> pid= new ArrayList<>();
    ArrayList<String> pname= new ArrayList<>();
    ArrayList<String> wid= new ArrayList<>();
    ArrayList<String> wname= new ArrayList<>();
    
    final void addShID() {
        rs=obj.getShID();
        try {
            while(rs.next()){
                tshid.addItem(rs.getString("name"));
                shid.add(rs.getString("sh_id"));
                shname.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppToWare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    final void addWID() {
        rs=obj.getWID();
        try {
            while(rs.next()){
                twid.addItem(rs.getString("name"));
                wid.add(rs.getString("w_id"));
                wname.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppToWare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    final void addPID() {
        rs=obj.getPID();
        try {
            while(rs.next()){
                tpid.addItem(rs.getString("name"));
                pid.add(rs.getString("p_id"));
                pname.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppToWare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    final void getCount(){
        String w_id=this.wid.get(wname.indexOf(twid.getSelectedItem().toString()));
        String p_id=this.pid.get(pname.indexOf(tpid.getSelectedItem().toString()));
        lpqt.setText(ob.getCount(w_id,p_id));
    }
    
    public WareToShow() {
        initComponents();
        setLocationRelativeTo(null);
        ob=new SWShDb();
        obj=new Details();
        addShID();
        addWID();
        addPID();
        getCount();
        //tpqt.setValue(10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        bshow = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bclose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ttable = new javax.swing.JTable();
        tdate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        bsave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tpid = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tshid = new javax.swing.JComboBox<>();
        twid = new javax.swing.JComboBox<>();
        tpqt = new javax.swing.JTextField();
        lpqt = new javax.swing.JLabel();
        llabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(670, 300));
        setResizable(false);

        jLabel3.setText("Product Quantity :");

        bshow.setText("Show");
        bshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bshowActionPerformed(evt);
            }
        });

        jLabel4.setText("Showroom ID :");

        bclose.setText("Close");
        bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcloseActionPerformed(evt);
            }
        });

        ttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ttable);

        jLabel6.setText("Dispatch Date :");

        bsave.setText("Save");
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Warehouse to Showroom :");

        jLabel1.setText("Warehouse ID :");

        jLabel2.setText("Product ID :");

        tpqt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tpqtMouseEntered(evt);
            }
        });

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
                        .addComponent(bsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bshow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bclose)
                        .addGap(0, 463, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tdate, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tpid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tshid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(twid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tpqt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(llabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lpqt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(twid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tpqt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lpqt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(llabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tshid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsave)
                    .addComponent(bshow)
                    .addComponent(bclose))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcloseActionPerformed
        dispose();
        new ADashboard().setVisible(true);
    }//GEN-LAST:event_bcloseActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        String sh_name=tshid.getSelectedItem().toString();
        String sh_id=this.shid.get(this.shname.indexOf(sh_name));
        String p_name=tpid.getSelectedItem().toString();
        String p_id=this.pid.get(pname.indexOf(p_name));
        String p_qty=tpqt.getText();
        String w_name=twid.getSelectedItem().toString();
        String w_id=this.wid.get(wname.indexOf(w_name));
        SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
        String ddate=sd.format(tdate.getDate());
        String label1="Please Confirm: \nWarehouse: "+w_name+"\nProduct: "+p_name+"\nProduct Qty: "+p_qty+"\nShowroom: "+sh_name+"\nDisp. Date: "+ddate;
        
        if(Integer.parseInt(lpqt.getText())>Integer.parseInt(p_qty)) {
            int input = JOptionPane.showConfirmDialog(null, label1);
            if(input==0){
                ob.saveW2Sh(w_id,p_id,p_qty,sh_id,ddate);
                ttable.setModel(DbUtils.resultSetToTableModel(ob.getW2Sh()));
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Not Enough Stock Available !!","Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bsaveActionPerformed

    private void bshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bshowActionPerformed
        ttable.setModel(DbUtils.resultSetToTableModel(ob.getW2Sh()));
    }//GEN-LAST:event_bshowActionPerformed

    private void tpqtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpqtMouseEntered
        getCount();
    }//GEN-LAST:event_tpqtMouseEntered

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
            java.util.logging.Logger.getLogger(WareToShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WareToShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WareToShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WareToShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WareToShow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bclose;
    private javax.swing.JButton bsave;
    private javax.swing.JButton bshow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel llabel;
    private javax.swing.JLabel lpqt;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JComboBox<String> tpid;
    private javax.swing.JTextField tpqt;
    private javax.swing.JComboBox<String> tshid;
    private javax.swing.JTable ttable;
    private javax.swing.JComboBox<String> twid;
    // End of variables declaration//GEN-END:variables
}
