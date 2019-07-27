package nutrilog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Creates initializes and deletes the database Nutrilog_Data
 * @author John Norman
 * @version 2019-7-27
 *
 */
public class DB_Setup{
    // TODO abstract this
    /**
     * Path for the JDBC Driver
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * Path to the local host
     */
    static final String DB_URL = "jdbc:mysql://localhost/";
    /**
     * Username for the database
     */
    static final String USER = "root";
    /**
     * User password for the database
     */
    static final String PASS = "";
    /**
     * A connection to the database
     */
    Connection conn;
    /**
     * A statement for SQL queries
     */
    Statement stmt;
    /**
     * Initializes the Nutrilog database. Creating the tables and 
     * assigning key constraints.
     * @return boolean representing if the database is successfully initialized
     */
    boolean init(){
        try {
            String sql;
            conn = connect("jdbc:mysql://localhost/Nutrilog_Data",USER,PASS);
            // Execute a query
            stmt = conn.createStatement();
            // Key restraints disabled for development TOODO: restore keys
            // Create Person Table
            sql = "CREATE TABLE Person(" 
                    + "    ID INTEGER NOT NULL,"
                    + "    FirstName VARCHAR(255)NOT NULL,"
                    + "    LastName VARCHAR(255) NOT NULL,"
                    + "    Gender CHAR," 
                    + "    DOB DATE,"
                    + "    Weight FLOAT,"
                    + "    PRIMARY KEY(ID)" 
                    + ")";
            stmt.executeUpdate(sql);            
            // Create Application User table           
            sql = "CREATE TABLE AppUser(" + "    ID INTEGER NOT NULL, "
                    + "    UserName VARCHAR(255) NOT NULL, "
                    + "    Password VARCHAR(255) NOT NULL "
//                    + "    PRIMARY KEY (ID),"
//                    + "    FOREIGN KEY (ID) REFERENCES Person(Id)" 
                    + ")"
                    ;
            stmt.executeUpdate(sql);          
            // Create Patient table            
            sql = "CREATE TABLE Patient("
                    + "    ID INTEGER NOT NULL, "
                    + "    LastName VARCHAR(255), "
                    + "    Weight FLOAT, "
                    + "    PRIMARY KEY (ID)"
//                    + "    FOREIGN KEY (ID) REFERENCES Person (ID)\r\n"
                    + ")";
            stmt.executeUpdate(sql);          
            // Create Event table            
            sql = "CREATE TABLE Event(\r\n"
                    + "    EventNum INTEGER NOT NULL,\r\n"
                    + "    ID INTEGER NOT NULL,\r\n"
                    + "    EventName VARCHAR(255) NOT NULL,\r\n"
                    + "    FoodUnit FLOAT,\r\n" 
                    + "    Urine BOOLEAN,\r\n"
                    + "    Stool BOOLEAN,\r\n" 
                    + "    Weight FLOAT,\r\n"
                    + "    EventDate DATE NOT NULL,\r\n"
                    + "    PRIMARY KEY (EventNum)\r\n"
 //                   + "    ,FOREIGN KEY (ID) REFERENCES Patient(ID)\r\n"
                    + ")";
            stmt.executeUpdate(sql);            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //close resources
            close();
        }
        return false;
    }
    /**
     * Creates the database Nutrilog_Data
     * @return boolean representing if database is successfully created
     */
    boolean create() {
        try {         
            conn = connect(DB_URL, USER, PASS);            
            // Execute a query
            stmt = conn.createStatement();            
            String sql = "CREATE DATABASE NUTRILOG_DATA";
            stmt.executeUpdate(sql);            
            return true;
        } catch (SQLException e) {            
            e.printStackTrace();
        } finally {
            // close resources
            try {                
                conn.close();               
            } catch (SQLException e) {                
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * Deletes database Nutrilog_Data
     * @return boolean representing deletion successful 
     */
    boolean dropDatabase(){
        try {            
            conn = connect(DB_URL, USER, PASS);            
            // Execute a query
            stmt = conn.createStatement();
            String sql = "DROP DATABASE Nutrilog_Data";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {            
            e.printStackTrace();
        } finally {
         // close resources
            close();
        }
        return false;
    }
    /**
     * Closes the connect and statment
     */
    private void close() {        
        try {
            if (stmt != null)
                conn.close();
        } catch (SQLException se) {
        } // do nothing
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } // end close resources        
    }
    /**
     * Creates a connection to the database
     * @param url - path to the database
     * @param user - username
     * @param password
     * @return the connection
     */
    private Connection connect(String url, String user, String password) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}