package nutrilog;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonFunctionControllerTest {
    PersonFunctionController pfc;
    DB_Setup setup;
    int PersonId;
    String FirstName;
    String LastName ;
    int patientId;
    char gender;
    String dob;

    @Before
    public void setUp() throws Exception {
        pfc = new PersonFunctionController();
        setup = new DB_Setup();
        PersonId = 10001;
        FirstName = "Maxine";
        LastName = "Powers";
        int patientId = 3000;
        char gender = 'F';
        String dob = "1999-12-31";
        try {
            setup.dropDatabase();
            setup.create();
            setup.init();    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
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
        assertTrue(pfc.addPatient());
    }
    
   
    

}
