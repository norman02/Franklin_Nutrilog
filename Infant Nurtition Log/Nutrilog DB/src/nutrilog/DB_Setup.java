package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Setup extends DB_Controller{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = super.connect();
    Statement stmt = super.stmt;

    /**
     * Initializes the Nutrilog database
     * @return 
     * 
     * @throws SQLException
     */
    boolean init(){
        try {
            String sql;
//            conn = connect("jdbc:mysql://localhost/Nutrilog_Data", USER,
//                    PASS);
            // Execute a query
            stmt = conn.createStatement();
            // Create Person Table
            System.out
                    .println("Creating table person in Nutrilog_data...");
            sql = "CREATE TABLE Person(" 
                    + "    ID INTEGER NOT NULL,"
                    + "    FirstName VARCHAR(255)NOT NULL,"
                    + "    LastName VARCHAR(255) NOT NULL,"
                    + "    Gender CHAR," 
                    + "    DOB DATE,"
                    + "    patient BOOLEAN DEFAULT 0,"
                    + "    UserName VARCHAR(255),"
                    + "    Password VARCHAR(255),"
                    + "    user BOOLEAN DEFAULT 0," 
                    + "    Weight FLOAT,"
                    + "    PRIMARY KEY(ID)" 
                    + ")";
            stmt.executeUpdate(sql);
            System.out.println(
                    "Succesfully created person in Nutrilog_data");
            // Create Application User table
            System.out
                    .println("Creating table AppUser in Nutrilog_data...");
            sql = "CREATE TABLE AppUser(" + "    ID INTEGER NOT NULL,"
                    + "    UserName VARCHAR(255) NOT NULL,"
                    + "    Password VARCHAR(255) NOT NULL,"
                    + "    PRIMARY KEY (ID),"
                    + "    FOREIGN KEY (ID) REFERENCES Person(Id)" + ")";
            stmt.executeUpdate(sql);
            System.out.println(
                    "Succesfully created AppUser in Nutrilog_data");
            // Create Patient table
            System.out
                    .println("Creating table Patient in Nutrilog_data...");
            sql = "CREATE TABLE Patient(\r\n"
                    + "    ID INTEGER NOT NULL,\r\n"
                    + "    Weight FLOAT,\r\n" + "    PRIMARY KEY (ID),\r\n"
                    + "    FOREIGN KEY (ID) REFERENCES Person (ID)\r\n"
                    + ")";
            stmt.executeUpdate(sql);
            System.out.println(
                    "Succesfully created Patient in Nutrilog_data");
            // Create Event table
            System.out.println("Creating table Event in Nutrilog_data...");
            sql = "CREATE TABLE Event(\r\n"
                    + "    EventNum INTEGER NOT NULL,\r\n"
                    + "    ID INTEGER NOT NULL,\r\n"
                    + "    EventName VARCHAR(255) NOT NULL,\r\n"
                    + "    FoodUnit FLOAT,\r\n" + "    Urine BOOLEAN,\r\n"
                    + "    Stool BOOLEAN,\r\n" + "    Weight FLOAT,\r\n"
                    + "    EventDate DATE NOT NULL,\r\n"
                    + "    PRIMARY KEY (EventNum),\r\n"
                    + "    FOREIGN KEY (ID) REFERENCES Patient(ID)\r\n"
                    + ")";
            stmt.executeUpdate(sql);
            System.out.println(
                    "Succesfully created Event in Nutrilog_data");
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
    boolean create(){
        try {
//            System.out.println("Connecting to the database...");
//            conn = connect(DB_URL, USER, PASS);
//            System.out.println("Succesfully connected to database");
            // Execute a query
            stmt = conn.createStatement();
            System.out.println("Creating databas Nutrilog_data...");
            String sql = "CREATE DATABASE NUTRILOG_DATA";
            stmt.executeUpdate(sql);
            System.out.println("Succesfully created Nutrilog_data");
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
     * Deletes Nutrilog_Data to create a fresh test run
     * @return 
     * 
     * @throws SQLException
     */
    boolean dropDatabase(){
        try {
//            System.out.println("Connecting to the database...");
//            conn = connect(DB_URL, USER, PASS);
            System.out.println("Succesfully connected to database");
            // Execute a query
            stmt = conn.createStatement();
            String sql = "DROP DATABASE Nutrilog_Data";
            System.out.println("deleting database 'Nutrilog_data'...");
            stmt.executeUpdate(sql);
            System.out.println("database deleted");
            return true;
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally {
         // close resources
            close();
        }
        return false;
        

    }

//    private void close() {
//        System.out.println("Closing connection...");
//        try {
//            if (stmt != null)
//                conn.close();
//        } catch (SQLException se) {
//        } // do nothing
//        try {
//            if (conn != null)
//                conn.close();
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } // end close resources
//        System.out.println("connection closed");
//    }

//    private Connection connect(String url, String user, String password) {
//
//        try {
//            // Register JDBC driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // Open a connection
//            
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
}//