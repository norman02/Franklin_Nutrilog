package nutrilog;

import static org.junit.Assert.assertTrue;

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
    static String LastName;
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
        setup.dropDatabase();
        setup.create();
        setup.init();       
        System.out.println("Nutrilog initialized");
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/Nutrilog_Data";

        // Database credentials
        final String USER = "root";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;
        
        //BEGIN WTF
        testPatientByNameWTF();
        //END WTF
        
    }
    static void testPatientByNameWTF() {
        Query q = new Query();
        String result = q.patientByName("Jones");
        pfc.addPatient(2234, "Davey", "Jones", "O", "1920-12-12");
        pfc.addPatient(2277, "Martha", "Jones", "F", "1958-12-12");
        String target = "9000, Jessica, Jones, F, 1992-03-04, Jones,"
                + " 2277, Martha, Jones, F, 1958-12-12"
                + "2234, Davey, Jones, O, 1920-12-12" ;
        System.out.println("Target string is...");
        System.out.println(target);
        System.out.println("Result string is...");
        System.out.println(result);
        
        
        }

}
