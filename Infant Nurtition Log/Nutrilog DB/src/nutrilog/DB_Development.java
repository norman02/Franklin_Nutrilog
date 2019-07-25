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

    }
}
