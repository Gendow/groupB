package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class LoadDriver {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        

Connection conn = null;
String username = "groupb";
String pass = "pcroom66";
String host = "jdbc:mysql://db4free.net:3306/disapp";

try {
    conn = DriverManager
	          .getConnection(host, username, pass);
    System.out.println("It works!");


    // Do something with the Connection

  
} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}
    }
}