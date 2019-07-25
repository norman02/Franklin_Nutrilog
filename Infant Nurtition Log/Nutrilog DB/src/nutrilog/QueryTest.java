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
    String del = ", ";
    static EventFunctionController efc;
    static double unit;

    
    
    

    @Before
    public void setUp() throws Exception {
        id = 9000;
        firstName = "Jessica";
        lastName = "Jones";
        gender = "F";
        dob = "1992-03-04";
        UserName = "Jewel";
        password = "?1337P@55w()rd!";
        id2 = 7000;
        firstName2 = "Luke";
        lastName2 = "Cage";
        gender2 = "M";
        dob2 = "1987-07-14";
        UserName2 = "LCage";
        password2 = "Jessica";
        unit = 22.6;

        
        
        
        data = new DB_Setup();
        data.create();
        data.init();
        q = new Query();
        pfc = new PersonFunctionController();
        pfc.addPatient(id, firstName, lastName, gender, dob);
        pfc.addPatient(id2, firstName2, lastName2, gender2, dob2);
        
        efc = new EventFunctionController();
        efc.logFeeding(id, dob, unit );
        efc.logChanging(id2, dob2, false, true);
//        efc.logWeight(id, dob, unit);

              
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
        String target = its + del + firstName + del + lastName + 
                del + gender + del + dob;    
        assertTrue(target.equals(result));
        
        
    }
    @Test
    public void testPatientByID() {
     // Test with second person
        String result2 = q.patientByID(id2);
        String its2 = Integer.toString(id2);
        String target2 = its2 + del + firstName2 + del + lastName2 + 
                del + gender2 + del + dob2;
        assertTrue(target2.equals(result2));        
    }

    @Test
    public void testEventById() {
        String result = q.eventById(id);
        String its = Integer.toString(id);
        String target = its + del + lastName + del + "Feeding" + del + unit;
        System.out.println("Target string is: " + target);
        System.out.println("Result string is: " + result);
        assertTrue(target.equals(result));       
    }
    @Test
    public void testEventByIdArray() {
        //TODO make 2 dimensional test       
    }

    @Test
    public void testEventByName() {
        String result = q.eventByName(lastName2);
        String its = Integer.toString(id2);
        String target = its + del + lastName2 + del + "Changed";
        System.out.println("Target string is: " + target);
        System.out.println("Result string is: " + result);
        assertTrue(target.equals(result));       
    }

    @Test
    public void testEventByNameArray() {
        //TODO
    }

}
