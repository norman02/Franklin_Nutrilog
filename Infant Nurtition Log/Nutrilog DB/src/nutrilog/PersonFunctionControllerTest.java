package nutrilog;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Modifies the Person table in the Nutrilog_Data database
 * @author John Norman
 *
 */
public class PersonFunctionControllerTest {
    PersonFunctionController pfc;
    DB_Setup setup;
    int PersonId;
    String FirstName;
    String LastName ;
    int patientId;
    String gender;
    String dob;
    String UserName;
    String Password;

    @Before
    public void setUp(){
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
        setup.dropDatabase();
        setup.create();
        setup.init();
        
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(pfc);       
    }
    @Test
    public void testInsertPerson() {
        assertTrue(pfc.insertPerson(PersonId, FirstName, LastName));
    }
    @Test
    public void testAddPatient() {
        assertTrue(pfc.addPatient(
                PersonId, FirstName, LastName, gender, dob));
    }
    @Test 
    public void testAddUser() {
        assertTrue(pfc.addUser(PersonId, FirstName, LastName,
                UserName, Password));
    }
    
   
    

}
