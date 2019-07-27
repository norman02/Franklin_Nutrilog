package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Setup {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    /**
     * Initializes the Nutrilog database
     * 
     * @throws SQLException
     */
    void init() throws SQLException {
        String sql;
        conn = connect("jdbc:mysql://localhost/Nutrilog_Data", USER, PASS);
        // Execute a query
        System.out.println("Creating tables in Nutrilog_Data...");
        stmt = conn.createStatement();
        // Create Person Table
        System.out.println("Creating Person in Nutrilog_Data...");
        sql = "CREATE TABLE Person(" + "    ID INTEGER NOT NULL,"
                + "    FirstName VARCHAR(255)NOT NULL,"
                + "    LastName VARCHAR(255) NOT NULL,"
                + "    Gender CHAR," 
                + "    DOB DATE,"
                + "    patient BOOLEAN DEFAULT 0,"
                + "    user BOOLEAN DEFAULT 0,"
                + "    Weight FLOAT,"    
                + "    PRIMARY KEY(ID)" + ")";
        stmt.executeUpdate(sql);
        System.out.println(
                "Succesfully created Person in " + "Nutrilog_Data...");
        // Create Application User table
        System.out.println("Creating AppUser in Nutrilog_Data...");
        sql = "CREATE TABLE AppUser(" + "    ID INTEGER NOT NULL,"
                + "    UserName VARCHAR(255) NOT NULL,"
                + "    Password VARCHAR(255) NOT NULL,"
                + "    PRIMARY KEY (ID),"
                + "    FOREIGN KEY (ID) REFERENCES Person(Id)" + ")";
        stmt.executeUpdate(sql);
        System.out.println(
                "Succesfully created AppUser in " + "Nutrilog_Data...");
        // Create Patient table
        System.out.println("Creating Patient in Nutrilog_Data...");
        sql = "CREATE TABLE Patient(\r\n" + "    ID INTEGER NOT NULL,\r\n"
                + "    Weight FLOAT,\r\n" + "    PRIMARY KEY (ID),\r\n"
                + "    FOREIGN KEY (ID) REFERENCES Person (ID)\r\n" + ")";
        stmt.executeUpdate(sql);
        System.out.println(
                "Succesfully Created Patient in " + "Nutrilog_Data...");
        // Create Event table
        System.out.println("Creating Event in Nutrilog_Data...");
        sql = "CREATE TABLE Event(\r\n"
                + "    EventNum INTEGER NOT NULL,\r\n"
                + "    ID INTEGER NOT NULL,\r\n"
                + "    EventName VARCHAR(255) NOT NULL,\r\n"
                + "    FoodUnit FLOAT,\r\n" + "    Urine BOOLEAN,\r\n"
                + "    Stool BOOLEAN,\r\n" + "    Weight FLOAT,\r\n"
                + "    EventDate DATE NOT NULL,\r\n"
                + "    PRIMARY KEY (EventNum),\r\n"
                + "    FOREIGN KEY (ID) REFERENCES Patient(ID)\r\n" + ")";
        stmt.executeUpdate(sql);
        System.out.println(
                "Succesfully Created Event in " + "Nutrilog_Data...");
        close();

    }

    /**
     * Creates the database Nutrilog_Data
     * 
     * @throws SQLException
     */
    void create() throws SQLException {

        conn = connect(DB_URL, USER, PASS);
        // Execute a query
        System.out.println("Creating database...");
        stmt = conn.createStatement();

        String sql = "CREATE DATABASE NUTRILOG_DATA";
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully...");
        close();

    }

    /**
     * Deletes Nutrilog_Data to create a fresh test run
     * 
     * @throws SQLException
     */
    void dropDatabase() throws SQLException {

        conn = connect(DB_URL, USER, PASS);
        // Execute a query
        System.out.println("Deleting database...");
        stmt = conn.createStatement();

        String sql = "DROP DATABASE Nutrilog_Data";
        stmt.executeUpdate(sql);
        System.out.println("Database deleted successfully...");

        // close resources
        close();

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
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}//