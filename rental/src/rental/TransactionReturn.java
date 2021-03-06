/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;

import static java.lang.Math.abs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Log;
import model.TransactionDetail;
import model.User;
import repository.LogRepository;
import repository.TransactionRepository;

/**
 *
 * @author setiawanhu
 */
public class TransactionReturn extends javax.swing.JFrame {
    private User authUser;
    private ArrayList<model.Transaction> transactions;
    private int activeIndex = 0;
    /**
     * Creates new form TransactionReturn
     */
    public TransactionReturn() {
        initComponents();
        transactions = new ArrayList<>();
        getTransactions();
    }
    
    public TransactionReturn(User authUser){
        initComponents();
        transactions = new ArrayList<>();
        this.authUser = authUser;
        getTransactions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameDetail = new javax.swing.JFrame();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        btnReturnNovel = new javax.swing.JToggleButton();
        txtTransactionDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTransactionId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMember = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransactions = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        frameDetail.setBackground(new java.awt.Color(236, 233, 221));
        frameDetail.setSize(new java.awt.Dimension(919, 600));
        frameDetail.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                frameDetailWindowClosing(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("MyriadSetPro-Semibold Semi-Bold", 1, 36)); // NOI18N
        jLabel10.setText("Transaction Detail");

        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Novel ID", "Novel Title", "Novel Author", "Return Date", "Fine", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetail);

        btnReturnNovel.setText("Return Selected Record");
        btnReturnNovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnNovelActionPerformed(evt);
            }
        });

        txtTransactionDate.setEditable(false);
        txtTransactionDate.setBackground(new java.awt.Color(203, 203, 203));

        jLabel4.setText("Transaction Date:");

        txtTransactionId.setEditable(false);
        txtTransactionId.setBackground(new java.awt.Color(203, 203, 203));

        jLabel1.setText("Transaction ID:");

        txtMember.setEditable(false);
        txtMember.setBackground(new java.awt.Color(203, 203, 203));

        jLabel2.setText("Member:");

        txtUser.setEditable(false);
        txtUser.setBackground(new java.awt.Color(203, 203, 203));

        jLabel3.setText("Cashier:");

        javax.swing.GroupLayout frameDetailLayout = new javax.swing.GroupLayout(frameDetail.getContentPane());
        frameDetail.getContentPane().setLayout(frameDetailLayout);
        frameDetailLayout.setHorizontalGroup(
            frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameDetailLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameDetailLayout.createSequentialGroup()
                        .addGroup(frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(frameDetailLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTransactionId, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameDetailLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameDetailLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameDetailLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTransactionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReturnNovel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        frameDetailLayout.setVerticalGroup(
            frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameDetailLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(frameDetailLayout.createSequentialGroup()
                        .addGroup(frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTransactionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(frameDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTransactionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturnNovel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(236, 233, 221));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("MyriadSetPro-Semibold Semi-Bold", 1, 36)); // NOI18N
        jLabel11.setText("Return Transaction");

        tblTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member", "Cashier", "Status", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransactionsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTransactions);

        btnSearch.setText("Search");

        jLabel5.setText("Transaction ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnSearch)
                    .addComponent(jLabel5)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTransactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransactionsMouseClicked
        int index = tblTransactions.getSelectedRow();
        showTransaction(index);
    }//GEN-LAST:event_tblTransactionsMouseClicked

    private void btnReturnNovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnNovelActionPerformed
        returnNovel();
    }//GEN-LAST:event_btnReturnNovelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
        new Home(authUser).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void frameDetailWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_frameDetailWindowClosing
        getTransactions();
    }//GEN-LAST:event_frameDetailWindowClosing

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
            java.util.logging.Logger.getLogger(TransactionReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionReturn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionReturn().setVisible(true);
            }
        });
    }
    
    /**
     * Retrieve all transactions from storage
     * 
     */
    private void getTransactions(){
        //Retrieve the transactions to the list
        transactions = TransactionRepository.findAllWhereNotCompleted();
        
        //Populate the jtable
        DefaultTableModel model = (DefaultTableModel) tblTransactions.getModel();
        model.setRowCount(0);
        
        Object[] row = new Object[4];
        for (int i = 0; i < transactions.size(); i++){
            row[0] = transactions.get(i).getMember().getName();
            row[1] = transactions.get(i).getUser().getName();
            row[2] = transactions.get(i).getStatus();
            
            Date date = null;
            try{
                date = new SimpleDateFormat("yyyy-MM-dd").parse(transactions.get(i).getCreatedAt());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            row[3] = dateFormat.format(date);
            
            model.addRow(row);
        }
    }
    
    /**
     * Show transaction information if a record is being selected
     * 
     * @param index int
     */
    private void showTransaction(int index){
        activeIndex = index;
        model.Transaction transaction = transactions.get(index);
        
        txtTransactionId.setText(String.valueOf(transaction.getId()));
        txtMember.setText(transaction.getMember().getName());
        txtUser.setText(transaction.getUser().getName());
        Date date = null;
        try{
            date = new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getCreatedAt());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            txtTransactionDate.setText(dateFormat.format(date));
        } catch (Exception e){
            System.out.println(e.getMessage());
            txtTransactionDate.setText("");
        }
        
        DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
        model.setRowCount(0);
        
        ArrayList<TransactionDetail> details = transaction.getTransactionDetails();
        Object[] row = new Object[6];
        for(int i = 0; i < details.size(); i++){
            row[0] = details.get(i).getNovel().getId();
            row[1] = details.get(i).getNovel().getTitle();
            row[2] = details.get(i).getNovel().getAuthor();
            
            date = null;
            try{
                date = new SimpleDateFormat("yyyy-MM-dd").parse(details.get(i).getReturnDate());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
                row[3] = dateFormat.format(date);
            } catch (Exception e){
                System.out.println(e.getMessage());
                row[3] = "";
            }
            
            row[4] = details.get(i).getFine();
            row[5] = false;
            
            model.addRow(row);
        }
        
        frameDetail.setVisible(true);
    }
    
    /**
     * Update returned novel to the storage
     * 
     */
    private void returnNovel(){
        model.Transaction transaction = transactions.get(activeIndex);
        int rowCount = tblDetail.getRowCount();
        //is the selected record exist flag
        boolean isExist = false;
        
        if(transaction.getStatus().equals("finished")){
            JOptionPane.showMessageDialog(null, "Transaction is already finished", "Transaction", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(rowCount == 0){
            JOptionPane.showMessageDialog(null, "The table is empty", "Transaction", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //Generate temporary detail array list
        ArrayList<TransactionDetail> tempDetails = new ArrayList<>();
        for(TransactionDetail detail: transaction.getTransactionDetails()){
            tempDetails.add(detail);
        }
        
        for(int i = 0; i < rowCount; i++){
            Boolean isSelected = Boolean.valueOf(tblDetail.getValueAt(i, 5).toString());
            
            if(isSelected){
                isExist = true;
                
                if(tempDetails.get(i).getNovel().getStatus().equals("available")){
                    JOptionPane.showMessageDialog(null, "Novel already returned", "Transaction", JOptionPane.INFORMATION_MESSAGE);
                    
                    //revert the previous changed novel status
                    for(int j = i-1; j >= 0; j--){
                        tempDetails.get(j).getNovel().setStatus("borrowed");
                    }
                    
                    return;
                }
                
                tempDetails.get(i).getNovel().setStatus("available");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                
                Date now = new Date();
                tempDetails.get(i).setReturnDate(dateFormat.format(now));
                
                Date borrow = null;
                try {
                    borrow = dateFormat.parse(transaction.getCreatedAt());
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
                
                if(isFined(now, borrow)){
                    tempDetails.get(i).setFine(5000);
                }
            }
        }
        
        if(!isExist){
            JOptionPane.showMessageDialog(null, "No record choosen", "Transaction", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(isFinished(tempDetails)){
            transaction.setStatus("finished");
            
            JOptionPane.showMessageDialog(null, "The transaction finished", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(TransactionRepository.update(transaction.getId(), transaction)){
            LogRepository.create(new Log(0, authUser.getId(), "Peminjaman", "Return"));
            
            transaction.setTransactionDetails(tempDetails);
            JOptionPane.showMessageDialog(null, "Novel return success", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }
        
        showTransaction(activeIndex);
    }
    
    /**
     * Determined whether the returned book is fined
     * 
     * @param now Date
     * @param borrow Date
     * @return boolean
     */
    private boolean isFined(Date now, Date borrow){
        int daysApart = (int)((now.getTime() - borrow.getTime()) / (1000*60*60*24l));
        
        //more than 7 days appart
        if (abs(daysApart) > 7) 
            return true;
        else //less than 7 days appart
            return false;
    }
    
    /**
     * Determined whether the transaction si finished 
     * 
     * @param transaction
     * @return 
     */
    private boolean isFinished(ArrayList<TransactionDetail> details){
        for(int i = 0; i < details.size(); i++){
            if(details.get(i).getReturnDate() == null)
                return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnReturnNovel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JFrame frameDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTable tblTransactions;
    private javax.swing.JTextField txtMember;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTransactionDate;
    private javax.swing.JTextField txtTransactionId;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
