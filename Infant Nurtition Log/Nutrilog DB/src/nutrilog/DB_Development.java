package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class for testing and development of function controllers
 * 
 * @author John Norman
 * 
 *          
 * 
 * 
 */
public class DB_Development extends DB_Controller {
    Connection cn = super.connect();
    
    static DB_Setup setup = new DB_Setup();
    static PersonFunctionController pfc; 
    static EventFunctionController efc;
    static int PersonId;
    static String FirstName;
    static String LastName ;
    static int patientId;
    static String gender;
    static String dob;
    static String UserName;
    static String Password;
    static String feeding;
    static String changing;
    static String weighing;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        pfc = new PersonFunctionController();
        efc = new EventFunctionController();
        
        
        setup = new DB_Setup();
        PersonId = 10001;
        FirstName = "Maxine";
        LastName = "Powers";
        patientId = 3000;
        gender = "F";
        dob = "1999-12-31";
        UserName = "MaxPower";
        Password = "1337!P@s5w0rd!";
        setup.dropDatabase();
        setup.create();
        setup.init();
        pfc.addPatient(patientId, FirstName, LastName,
                gender, dob);
        pfc.addUser(PersonId, FirstName, LastName,
                UserName, Password);
        double unit = 40.2;
        efc.logFeeding(PersonId, dob, unit );
        efc.logChanging(PersonId, dob, false, true);
        efc.logWeight(PersonId, dob, unit);
        System.out.println("Nutrilog initialized");
     // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/Nutrilog_Data";

        // Database credentials
        final String USER = "root";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;
       
            //query to display all records from table Patient
            String q="Select * from Event";
            
            
            try {
                //to execute query
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Open a connection
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement smt = conn.createStatement();
                ResultSet rs=smt.executeQuery(q);
                
                //to print the resultset on console
                if(rs.next()){ 
                    do{
                    System.out.println(
                            rs.getString(1)
                            +","+rs.getString(2)+
                            ","+rs.getString(3)
                            +","
                            +rs.getString(4)+","
                            +rs.getString(5)
                            +rs.getString(6)+","
                            +rs.getString(7)+","
                            +rs.getString(8)+","
                            );
                    }while(rs.next());
                }
                else{
                    System.out.println("Record Not Found...");
                }
                conn.close();
            } catch (SQLException | ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     

    }
   
    
}
