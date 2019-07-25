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
    int id2;
    String firstName2;
    String lastName2;
    String gender2;
    String dob2;
    String UserName2;
    String password2;
    double weight2;
    
    
    

    @Before
    public void setUp() throws Exception {
        id = 9000;
        firstName = "Jessica";
        lastName = "Jones";
        gender = "F";
        dob = "1992/03/04";
        UserName = "Jewel";
        password = "?1337P@55w()rd!";
        id2 = 7000;
        firstName2 = "Luke";
        lastName2 = "Cage";
        gender2 = "M";
        dob2 = "1987/07/14";
        UserName2 = "LCage";
        password2 = "Jessica";

        
        
        
        data = new DB_Setup();
        data.create();
        data.init();
        q = new Query();
        pfc = new PersonFunctionController();
        pfc.addPatient(id, firstName, lastName, gender, dob);
        pfc.addPatient(id2, firstName2, lastName2, gender2, dob2);
//        pfc.addUser(90001, firstName, "poe", UserName, password);
              
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
        String its = Integer.toString(id);
        String del = ", ";
        String target = its + del + firstName + del + lastName + 
                del + gender + del + dob;
        System.out.println("Target string is");
        System.out.println(target);
        assertTrue(target.equals(result));

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
