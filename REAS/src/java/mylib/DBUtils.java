
package mylib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {   
    private static final String DB_NAME = "AuctionSystem";
    private static final String DB_USER_NAME = "SA";
    private static final String DB_PASSWORD = "12345";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection cn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        cn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return cn;
    }
    
    // check connection to database
//    public static void main(String[] args) {
//        // Main method for testing the database connection
//        try {
//            // Attempt to get a database connection
//            Connection connection = getConnection();
//
//            // Check if the connection is successful
//            if (connection != null) {
//                System.out.println("Connected to the database successfully!");
//
//                // Close the connection when done
//                connection.close();
//            } else {
//                System.out.println("Failed to connect to the database.");
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            // Handle exceptions
//            e.printStackTrace();
//        }
//    }
}
