/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.nestopia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khaisarmeliala
 */
public class ClientScreen extends javax.swing.JFrame {
private Nestopia nestopia;
     /* Creates new form ClientScreen
     */
    public ClientScreen() {
        initComponents();
        nestopia = new Nestopia(); 
        populateclientinfoTable();
        
    }
private void populateclientinfoTable() {
    try {
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");
      //  Connection conn = nestopia.getDatabaseConnection();
       String query = "SELECT ClientName, ContactPhone FROM Clients";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) clientinfotable.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            String name = rs.getString("ClientName");
            String phone = rs.getString("ContactPhone");
            model.addRow(new Object[]{name, phone});
        }

//        conn.close();
    } catch (SQLException ex) {
        // Handle any errors here
        ex.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NameClientInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PhoneNumberClientInput = new javax.swing.JTextField();
        ApplyClientButton = new javax.swing.JButton();
        DeleteClientButton = new javax.swing.JButton();
        BackClientButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        clientinfotable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        SearchClientButton = new javax.swing.JButton();
        SearchClientInput = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Fahkwang", 0, 18)); // NOI18N
        jLabel3.setText("Home Register");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name ");

        NameClientInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameClientInputActionPerformed(evt);
            }
        });

        jLabel2.setText("Phone Number ");

        PhoneNumberClientInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneNumberClientInputActionPerformed(evt);
            }
        });

        ApplyClientButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        ApplyClientButton.setText("Apply");
        ApplyClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyClientButtonActionPerformed(evt);
            }
        });

        DeleteClientButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        DeleteClientButton.setText("Delete");
        DeleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClientButtonActionPerformed(evt);
            }
        });

        BackClientButton.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        BackClientButton.setText("Back");
        BackClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClientButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBar(null);

        clientinfotable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Phone Number"
            }
        ));
        clientinfotable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(clientinfotable);
        if (clientinfotable.getColumnModel().getColumnCount() > 0) {
            clientinfotable.getColumnModel().getColumn(0).setResizable(false);
            clientinfotable.getColumnModel().getColumn(1).setResizable(false);
        }

        jScrollPane3.setViewportView(jScrollPane2);

        jLabel4.setFont(new java.awt.Font("Fahkwang", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Client Register");

        SearchClientButton.setBackground(new java.awt.Color(153, 153, 153));
        SearchClientButton.setText("Search");
        SearchClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchClientButtonActionPerformed(evt);
            }
        });

        SearchClientInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchClientInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameClientInput, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(PhoneNumberClientInput))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DeleteClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ApplyClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BackClientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchClientInput)
                        .addGap(18, 18, 18)
                        .addComponent(SearchClientButton)
                        .addGap(278, 278, 278))
                    .addComponent(jLabel4)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameClientInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(PhoneNumberClientInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ApplyClientButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteClientButton)
                        .addGap(4, 4, 4)
                        .addComponent(BackClientButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchClientInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchClientButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApplyClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyClientButtonActionPerformed
        // TODO add your handling code here:
                                              
    String name = NameClientInput.getText();
    String phoneNumber = PhoneNumberClientInput.getText();

    try {
        // Replace this with your database connection logic
        Connection conn = nestopia.getDatabaseConnection();
      //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Clients (ClientName ,ContactPhone) VALUES (?, ?)");
        stmt.setString(1, name);
        stmt.setString(2, phoneNumber);
 
        int rowsAffected = stmt.executeUpdate();


        if (rowsAffected > 0) {
                     populateclientinfoTable();
            JOptionPane.showMessageDialog(this, "Data inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Refresh the clientinfotable to display the updated data
  this.dispose();  
               
  
  BookingScreen.dummymain2(name, phoneNumber);
//BookingScreen bookingscreen = new BookingScreen();
//bookingscreen.setVisible(true);
//bookingscreen.getClientNameBookingScreen().setText(name);
//bookingscreen.getPhoneNumberBookingInput().setText(phoneNumber);






             NameClientInput.setText("");
            PhoneNumberClientInput.setText("");  

   
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Close the statement (not the connection)
        stmt.close();
    } catch (SQLException ex) {
        // Handle any SQL errors here
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while inserting data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


//    BookingScreen bookingscreen = new BookingScreen(name,  phoneNumber );
//    bookingscreen.setVisible(true);
        
        

        
        
        
    }//GEN-LAST:event_ApplyClientButtonActionPerformed

    private void NameClientInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameClientInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameClientInputActionPerformed

    private void PhoneNumberClientInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNumberClientInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneNumberClientInputActionPerformed

    private void SearchClientInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchClientInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchClientInputActionPerformed

    private void SearchClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchClientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchClientButtonActionPerformed

    private void DeleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClientButtonActionPerformed
        // TODO add your handling code here:
int selectedRow = clientinfotable.getSelectedRow();
    if (selectedRow == -1) {
        // If no row is selected, show an error message
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        DefaultTableModel model = (DefaultTableModel) clientinfotable.getModel();
        String name = (String) model.getValueAt(selectedRow, 0);
        String phoneNumber = (String) model.getValueAt(selectedRow, 1);

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Clients WHERE ClientName = ? AND ContactPhone = ?");
        stmt.setString(1, name);
        stmt.setString(2, phoneNumber);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Row deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete row.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Close the statement and the connection
        stmt.close();
        conn.close();
    } catch (SQLException ex) {
        // Handle any SQL errors here
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while deleting data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_DeleteClientButtonActionPerformed

    private void BackClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClientButtonActionPerformed
        // TODO add your handling code here:
                this.dispose();
        HomeScreen homescreen = new HomeScreen();
        homescreen.setVisible(true);
        
        
    }//GEN-LAST:event_BackClientButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientScreen().setVisible(true);
     
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyClientButton;
    private javax.swing.JButton BackClientButton;
    private javax.swing.JButton DeleteClientButton;
    private javax.swing.JTextField NameClientInput;
    private javax.swing.JTextField PhoneNumberClientInput;
    private javax.swing.JButton SearchClientButton;
    private javax.swing.JTextField SearchClientInput;
    private javax.swing.JTable clientinfotable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
