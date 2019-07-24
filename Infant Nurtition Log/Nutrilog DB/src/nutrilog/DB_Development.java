package nutrilog;

import java.sql.SQLException;

/**
 * A class for testing and development of function controllers
 * 
 * @author John Norman
 * 
 *          
 * 
 * 
 */
public class DB_Development {
    static DB_Setup setup = new DB_Setup();
    PersonFunctionController pfc;    
    static int PersonId;
    static String FirstName;
    static String LastName ;
    static int patientId;
    static String gender;
    static String dob;
    static String UserName;
    static String Password;
    /**
     * @param args
     */
    public static void main(String[] args) {
        PersonFunctionController pfc = new PersonFunctionController();
        pfc = new PersonFunctionController();
        setup = new DB_Setup();
        PersonId = 10001;
        FirstName = "Maxine";
        LastName = "Powers";
        patientId = 3000;
        gender = "F";
        dob = "1999-12-31";
        UserName = "MaxPower";
        Password = "1337!P@s5w0rd!";
        try {
            setup.dropDatabase();
            setup.create();
            setup.init();
            
            pfc.addUser(PersonId, FirstName, LastName,
                    UserName, Password);
           
      
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
