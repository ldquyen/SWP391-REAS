
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
    
    
    String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME + ";characterEncoding=UTF-8";
    
    cn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
    return cn;
}
}