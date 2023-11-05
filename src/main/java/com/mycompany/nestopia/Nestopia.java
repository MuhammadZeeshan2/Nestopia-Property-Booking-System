/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nestopia;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Nestopia {

    private Connection connection; // Store the database connection in a private field

    // Constructor to establish the database connection
    public Nestopia() {
        String url = "jdbc:mysql://localhost:3306/nestopia?zeroDateTimeBehavior=CONVERT_TO_NULL&user=root&password=";

        String user = "root"; // Your MySQL username
        String password = ""; // Your MySQL password

        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(url, user, password);

            // If the connection is successful, print a success message
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    // Method to get the database connection
    public Connection getDatabaseConnection() {
        return connection;
    }
        // Method to close the database connection
    public void closeDatabaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection: " + e.getMessage());
        }
    }

    
    
      // Method to validate user credentials
    public boolean validateCredentials(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM useraccounts WHERE Username = ? AND Password = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                isValid = true; // Valid credentials
            }
        } catch (SQLException e) {
            System.err.println("Error validating credentials: " + e.getMessage());
        }
        
        return isValid;
    }
    

    public static void main(String[] args) {
        Nestopia nestopia = new Nestopia(); // Create an instance of Nestopia to establish the connection
//       this.dispose();
        LoginScreen loginscreen =new   LoginScreen();
        loginscreen.setVisible(true);
        


      

        // You can use nestopia.getDatabaseConnection() to obtain the connection in other classes.
    }
}
