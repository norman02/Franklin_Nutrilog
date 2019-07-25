package nutrilog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueryTest {
    Query q;
    DB_Setup data;
    PersonFunctionController pfc;
    int id;
    String firstName;
    String lastName;
    String gender;
    String dob;
    String UserName;
    String password;
    double weight;
    
    
    

    @Before
    public void setUp() throws Exception {
        id = 9000;
        firstName = "Maxine";
        lastName = "Pane";
        gender = "F";
        dob = "1997/03/04";
        UserName = "max";
        password = "password";

        
        
        q = new Query();
        data = new DB_Setup();
        data.create();
        data.init();
        pfc = new PersonFunctionController();
        pfc.addPatient(id, firstName, lastName, gender, dob);
        pfc.addUser(90001, firstName, lastName, UserName, password);
              
    }
    

    @After
    public void tearDown() throws Exception {
        data.dropDatabase();
    }
    @Test
    public void testPeople() {
        assertNotNull(q);
    }
    @Test
    public void testPatientByName() {
        String result = q.patientByName(lastName);
        String s = Integer.toString(id);
        assertTrue(result.contains(firstName));
        assertTrue(result.contains(lastName));
//        assertTrue(result.contains(s));
//        assertTrue(result.contains(gender));
//        assertTrue(result.contains(dob));
//        assertTrue(result.contains(UserName));
//        assertTrue(result.contains(password));
    }

    @Test
    public void testPeopleByID() {
        assertTrue(q.patientByID());
    }

    @Test
    public void testEventById() {
        assertTrue(q.eventById());
    }

    @Test
    public void testEventByName() {
        assertTrue(q.eventByName());
    }

}
