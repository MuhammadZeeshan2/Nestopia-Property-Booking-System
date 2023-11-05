/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.nestopia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khaisarmeliala
 */
public class BookingScreen extends javax.swing.JFrame {


//    /**
//     * Creates new form BookingScreen
//     */

     public static  String name;
    public static String phoneNumber;
    public static  String selectedProperty;
    
        private void populatePropertyMenu() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");
            String query = "SELECT * FROM Properties";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
      
            // Clear existing items
            PropertyMenu.removeAllItems();
      PropertyMenu.addItem("Select the property");
            // Populate the property menu
            while (rs.next()) {
                String propertyName = rs.getString("PropertyName");
                //String propertyAddress = rs.getString("Address");
                PropertyMenu.addItem(propertyName);
//                 PropertyMenu.addItem(propertyAddress);
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Rest of the class

    public BookingScreen() {
        initComponents();
        populateBookingInfoTable();
        populatePropertyMenu();
        System.out.println("inside 1 ");
    }

    public BookingScreen(String Clientname, String phoneNumber) {
        initComponents();
        System.out.println("inside 2 ");
         this.name = Clientname;
         this.phoneNumber = phoneNumber;
         ClientNameBookingScreen.setText(name);
         PhoneNumberBookingInput.setText(phoneNumber);
         
//        System.out.println(Clientname);
//        System.out.println(phoneNumber);
//      System.out.println(name);
//      System.out.println(phoneNumber);
        populateBookingInfoTable();
        populatePropertyMenu();
    }


    public static void dummymain(){
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
            new BookingScreen().setVisible(true);
        }
        
        });
    }
     public static void dummymain2(String name, String phoneNumber){
        java.awt.EventQueue.invokeLater(new Runnable() {
          @Override
          public void run() {
//              System.out.println("name:"+Clientname);
//            System.out.println("phone number :"+phoneNumber);
                 System.out.println("name:"+name);
            System.out.println("phone number :"+phoneNumber);
           new BookingScreen(name, phoneNumber).setVisible(true);
        }
        
        });
    }
    
private void populateBookingInfoTable() {
    
    
    
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");
        String query = "SELECT cl.ClientName, cl.ContactPhone, bk.CheckinDate, bk.CheckoutDate, bk.RentalPrice, bk.TotalRevenue " +
                       "FROM Bookings bk " +
                       "JOIN Clients cl ON bk.ClientID = cl.ClientID";
              // String query = "SELECT * from bookings";
        
         
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
//         String Propertiesquery = "SELECT * FROM Properties";
//        PreparedStatement propertiespst = conn.prepareStatement(Propertiesquery);
//        ResultSet result = propertiespst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) BookinfoTable.getModel();
        model.setRowCount(0);

        while (rs.next()) {
;
            String clientName = ClientNameBookingScreen.getText();
            String contactPhone = PhoneNumberBookingInput.getText();
            String selectedProperty = (String) PropertyMenu.getSelectedItem();
            
            
            String checkinDate = rs.getString("CheckinDate");
            String checkoutDate = rs.getString("CheckoutDate");
            String rentalPrice = rs.getString("RentalPrice");
            String totalRevenue = rs.getString("TotalRevenue");
            

            model.addRow(new Object[]{clientName, contactPhone,selectedProperty, checkinDate, checkoutDate, rentalPrice, totalRevenue});
        }

        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    
    
    
// Add this method to your BookingScreen class

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        ClientNameBookingScreen = new javax.swing.JTextField();
        PhoneNumberBookingInput = new javax.swing.JTextField();
        DayRentedBookingInput = new javax.swing.JTextField();
        DayReturnedBookingInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TotalRevenueBookingInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ApplyBookingButton = new javax.swing.JButton();
        DeleteBookingButton = new javax.swing.JButton();
        BackBookingButton = new javax.swing.JButton();
        SearchBookingButton = new javax.swing.JButton();
        SearchBookingInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PropertyMenu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookinfoTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Fahkwang", 0, 30)); // NOI18N
        jLabel1.setText("Booking Screen");

        ClientNameBookingScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientNameBookingScreenActionPerformed(evt);
            }
        });

        PhoneNumberBookingInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneNumberBookingInputActionPerformed(evt);
            }
        });

        DayRentedBookingInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayRentedBookingInputActionPerformed(evt);
            }
        });

        DayReturnedBookingInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayReturnedBookingInputActionPerformed(evt);
            }
        });

        jLabel2.setText("Client Name");

        jLabel3.setText("Phone Number");

        jLabel4.setText("Day Rented");

        jLabel5.setText("Day Returned");

        TotalRevenueBookingInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalRevenueBookingInputActionPerformed(evt);
            }
        });

        jLabel6.setText("Total Price ");

        ApplyBookingButton.setText("Apply");
        ApplyBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyBookingButtonActionPerformed(evt);
            }
        });

        DeleteBookingButton.setText("Delete");
        DeleteBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBookingButtonActionPerformed(evt);
            }
        });

        BackBookingButton.setText("Back");
        BackBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBookingButtonActionPerformed(evt);
            }
        });

        SearchBookingButton.setBackground(java.awt.SystemColor.scrollbar);
        SearchBookingButton.setText("Search");
        SearchBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBookingButtonActionPerformed(evt);
            }
        });

        SearchBookingInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBookingInputActionPerformed(evt);
            }
        });

        jLabel7.setText("Select property");

        BookinfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Client Name", "Phone Number", "Property Name", "Day Rented", "Day Returned", "Price (per day)", "Revenue", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BookinfoTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(BookinfoTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ApplyBookingButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DeleteBookingButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BackBookingButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(40, 40, 40)
                                    .addComponent(ClientNameBookingScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DayRentedBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7))
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PhoneNumberBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PropertyMenu, 0, 102, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(32, 32, 32)
                                .addComponent(DayReturnedBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(47, 47, 47)
                                .addComponent(TotalRevenueBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchBookingButton)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchBookingButton))
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ClientNameBookingScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PhoneNumberBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(PropertyMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(DayRentedBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DayReturnedBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TotalRevenueBookingInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addComponent(ApplyBookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteBookingButton)
                        .addGap(18, 18, 18)
                        .addComponent(BackBookingButton)
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int getClientID(String clientName, String phoneNumber) {
    int clientID = -1; // Set a default value for the client ID in case no match is found

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");
        String query = "SELECT ClientID FROM Clients WHERE ClientName = ? AND ContactPhone = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, clientName);
        pst.setString(2, phoneNumber);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            clientID = rs.getInt("ClientID");
        }

        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return clientID;
}

    
    
    
    
    
    private void ApplyBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyBookingButtonActionPerformed

  try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");

        String clientName = ClientNameBookingScreen.getText();
        String phoneNumber = PhoneNumberBookingInput.getText();
        
        int clientID = getClientID(clientName, phoneNumber);
        System.out.println("Client Id: " + clientID);

        String selectedProperty = (String) PropertyMenu.getSelectedItem();
        String dayRented = DayRentedBookingInput.getText();
        String dayReturned = DayReturnedBookingInput.getText();
        String totalRentalprice = TotalRevenueBookingInput.getText(); // Assuming TotalRevenueBookingInput is a text field

        String newQuery = "INSERT INTO Bookings (CheckinDate, CheckoutDate, RentalPrice, ClientID) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(newQuery);
        pst.setString(1, dayRented);
        pst.setString(2, dayReturned);
        pst.setBigDecimal(3, new BigDecimal(totalRentalprice)); // Assuming RentalPrice is fetched from the UI
        pst.setInt(4, clientID); // Insert the retrieved client ID

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            populateBookingInfoTable();
            JOptionPane.showMessageDialog(this, "Data inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Refresh the table with the updated data
            
            ClientNameBookingScreen.setText("");
            PhoneNumberBookingInput.setText("");
            PropertyMenu.addItem("Select the property");
            DayRentedBookingInput.setText("");
            DayReturnedBookingInput.setText("");
            TotalRevenueBookingInput.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to insert data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while inserting data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }



        
    }//GEN-LAST:event_ApplyBookingButtonActionPerformed

    private void DeleteBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBookingButtonActionPerformed
                                                  
                                                   
    int selectedRow = BookinfoTable.getSelectedRow();
    if (selectedRow == -1) {
        // If no row is selected, show an error message
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        DefaultTableModel model = (DefaultTableModel) BookinfoTable.getModel();
        String clientName = (String) model.getValueAt(selectedRow, 0);
        String contactPhone = (String) model.getValueAt(selectedRow, 1);

        // Replace this with your database connection logic
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=");
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Clients WHERE ClientName = ? AND ContactPhone = ?");
        stmt.setString(1, clientName);
        stmt.setString(2, contactPhone);

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




        
        
    }//GEN-LAST:event_DeleteBookingButtonActionPerformed

    private void BackBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBookingButtonActionPerformed
        // TODO add your handling code here:
                this.dispose();
        HomeScreen homescreen = new HomeScreen();
        homescreen.setVisible(true);
        
        
    }//GEN-LAST:event_BackBookingButtonActionPerformed

    private void SearchBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBookingButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBookingButtonActionPerformed

    private void SearchBookingInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBookingInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBookingInputActionPerformed

    private void TotalRevenueBookingInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalRevenueBookingInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalRevenueBookingInputActionPerformed

    private void DayReturnedBookingInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayReturnedBookingInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayReturnedBookingInputActionPerformed

    private void DayRentedBookingInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayRentedBookingInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayRentedBookingInputActionPerformed

    private void PhoneNumberBookingInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNumberBookingInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneNumberBookingInputActionPerformed

    private void ClientNameBookingScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientNameBookingScreenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientNameBookingScreenActionPerformed

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
            java.util.logging.Logger.getLogger(BookingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
            new BookingScreen().setVisible(true);
               dummymain(); 
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyBookingButton;
    private javax.swing.JButton BackBookingButton;
    private javax.swing.JTable BookinfoTable;
    private javax.swing.JTextField ClientNameBookingScreen;
    private javax.swing.JTextField DayRentedBookingInput;
    private javax.swing.JTextField DayReturnedBookingInput;
    private javax.swing.JButton DeleteBookingButton;
    private javax.swing.JTextField PhoneNumberBookingInput;
    private javax.swing.JComboBox<String> PropertyMenu;
    private javax.swing.JButton SearchBookingButton;
    private javax.swing.JTextField SearchBookingInput;
    private javax.swing.JTextField TotalRevenueBookingInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
