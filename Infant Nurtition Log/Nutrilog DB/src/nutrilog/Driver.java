package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class for testing and development of function controllers
 * @author norman
 * 
 * !!!CURRENTLY THIS CODE ONLY WORKS WITH A FRESH DATABASE.!!!
 * 
 * 
 */
public class Driver {
    public static void main(String[] args) 
    {
        personController();
    }
    
    /**
     * 
     */
    static void personController() {
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://localhost/nutrilogdb";

    //  Database credentials
    final String USER = "root";
    final String PASS = "";
    
    
    Connection conn = null;
    Statement stmt = null;
    try{
        //Register JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        
        //Execute a query
        System.out.println("Inserting records into the table...");
        stmt = conn.createStatement();
        
        String sql = "INSERT INTO Person " +
                     "VALUES (100, 'Zara', 'Ali', 'F', '2018-09-01');";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Person " +
                     "VALUES (101, 'Mahnaz', 'Fatma', 'F', '2018-09-01');";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Person " +
                     "VALUES (102, 'Zaid', 'Khan', 'F', '2018-09-01');";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Person " +
                     "VALUES(103, 'Sumit', 'Mittal', 'F', '2018-09-01');";
        stmt.executeUpdate(sql);
        System.out.println("Inserted records into the table...");

        sql = "SELECT id, FirstName, LastName FROM Person;";
        ResultSet rs = stmt.executeQuery(sql);

        
        while(rs.next()){
           //Retrieve by column name
           int id  = rs.getInt("id");
           //int age = rs.getInt("age");
           String first = rs.getString("FirstName");
           String last = rs.getString("LastName");

           //Display values
           System.out.print("ID: " + id);
           //System.out.print(", Age: " + age);
           System.out.print(", First: " + first);
           System.out.println(", Last: " + last);
       }
       //STEP 6: Clean-up environment
       
       stmt.close();
       conn.close();
    }catch(SQLException se){
       //Handle errors for JDBC
       se.printStackTrace();
    }catch(Exception e){
       //Handle errors for Class.forName
       e.printStackTrace();
    }finally{
       //finally block used to close resources
       try{
          if(stmt!=null)
             stmt.close();
       }catch(SQLException se2){
       }// nothing we can do
       try{
          if(conn!=null)
             conn.close();
       }catch(SQLException se){
          se.printStackTrace();
       }//end finally try
    }//end try
    System.out.println("Goodbye!");
 }//end main
    
}
