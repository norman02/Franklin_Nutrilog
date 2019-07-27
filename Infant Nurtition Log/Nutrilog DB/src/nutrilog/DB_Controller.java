package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The database controller controls the connection to the Nutrilog database. 
 * @author John Norman
 * @version 2019-7-27
 *
 */
public class DB_Controller {
    // JDBC driver name and database URL
    /**
     * Path to Java Database Connection driver
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * Path to the Nutrilog database
     */
    static final String DB_URL = "jdbc:mysql://localhost/Nutrilog_Data";
    /**
     * Username for database
     */
    static final String USER = "root";
    /**
     * User password for database
     */
    static final String PASS = "";
    /**
     * A connection to the database
     */
    Connection conn = null;
    /**
     * A statement for use in executing SQL queries. 
     */
    Statement stmt = null;
    /**
     * Establish the connection to the Nutrilog database
     * @return the connection
     */
    Connection connect() {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * Overload for connection method allows for a new URL to be used in 
     * the connection. 
     * @param url - new path to the database
     * @return the connection
     */
    Connection connect(String url) {
        String db_url = url;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            conn = DriverManager.getConnection(db_url, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * Closes the resources used, the connection and the statement invoked in 
     * the connect methods. 
     * @return A boolean representing if the resources are successfully closed.
     */
    boolean close() {
        try {        
            if (stmt != null)
                stmt.close();
        } catch (SQLException se) {
        } // do nothing
        try {
            if (conn != null)
                conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
        } // end close resources
        return false;
    }
}

