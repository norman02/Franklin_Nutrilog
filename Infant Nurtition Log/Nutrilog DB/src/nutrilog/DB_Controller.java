package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The database controller establishes a connection to the 
 * Nutrilog database
 * @author John Norman
 *
 */
public class DB_Controller {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Nutrilog_Data";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;
    
    DB_Controller(){
        //Default
    }
    /**
     * Establishes a connection to the database
     * @return the connection
     */
    Connection connect() {

        System.out.println("DB_Controller.connect() is connecting to the "
                + "database...");
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
        System.out.println("Connection succesful");
        return conn;
    }
    Connection connect(String url) {
        String db_url = url;

        System.out.println("DB_Controller.connect() is connecting to the "
                + "database...");
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(db_url, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
        System.out.println("Connection succesful");
        return conn;
    }
    boolean close() {
        System.out.println("DB_Controller.Close is closing connection...");
        try {
            
            if (stmt != null)
                stmt.close();
        } catch (SQLException se) {
        } // do nothing
        try {
            if (conn != null)
                conn.close();
            System.out.println("connection closed");
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
        } // end close resources
        return false;
    }

}

