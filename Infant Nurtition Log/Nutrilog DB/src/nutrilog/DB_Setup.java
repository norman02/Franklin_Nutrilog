package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Setup{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn;
    Statement stmt;

    /**
     * Initializes the Nutrilog database
     * @return 
     * 
     * @throws SQLException
     */
    boolean init(){
        try {
            String sql;
            conn = connect("jdbc:mysql://localhost/Nutrilog_Data",USER,PASS);
            // Execute a query
            stmt = conn.createStatement();
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
            
            sql = "CREATE TABLE AppUser(" + "    ID INTEGER NOT NULL,"
                    + "    UserName VARCHAR(255) NOT NULL,"
                    + "    Password VARCHAR(255) NOT NULL"

//                    + "    PRIMARY KEY (ID),"
//                    + "    FOREIGN KEY (ID) REFERENCES Person(Id)" 
                    + ")"
                    ;
            stmt.executeUpdate(sql);
           
            // Create Patient table
            
            sql = "CREATE TABLE Patient("
                    + "    ID INTEGER NOT NULL,"
                    + "    Weight FLOAT "
//                    + "    PRIMARY KEY (ID),\r\n"
//                    + "    FOREIGN KEY (ID) REFERENCES Person (ID)\r\n"
                    + ")";
            stmt.executeUpdate(sql);
            
            // Create Event table
            
            sql = "CREATE TABLE Event(\r\n"
                    + "    EventNum INTEGER NOT NULL,\r\n"
                    + "    ID INTEGER NOT NULL,\r\n"
                    + "    EventName VARCHAR(255) NOT NULL,\r\n"
                    + "    FoodUnit FLOAT,\r\n" + "    Urine BOOLEAN,\r\n"
                    + "    Stool BOOLEAN,\r\n" + "    Weight FLOAT,\r\n"
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
     * @return 
     * 
     * @throws SQLException
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
     * Deletes Nutrilog_Data to create a fresh test run
     * @return 
     * 
     * @throws SQLException
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
}//