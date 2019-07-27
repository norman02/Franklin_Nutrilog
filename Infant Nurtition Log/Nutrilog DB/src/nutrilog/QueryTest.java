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
    boolean stool;
    boolean urine;

    
    
    

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
        stool = false;
        urine = true;

        
        
        
        data = new DB_Setup();
        data.create();
        data.init();
        q = new Query();
        pfc = new PersonFunctionController();
        pfc.addPatient(id, firstName, lastName, gender, dob);
        pfc.addPatient(id2, firstName2, lastName2, gender2, dob2);
        
        efc = new EventFunctionController();
        efc.logFeeding(id, dob, unit );

        efc.logChanging(id2, dob2, stool, urine);
        efc.logChanging(id, dob, stool, urine);
        efc.logWeight(id, dob, unit);

              
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
        
        pfc.addPatient(2234, "Davey", "Jones", "O", "1920-12-12");
        pfc.addPatient(2277, "Martha", "Jones", "F", "1958-12-12");
        String target = "2234, Davey, Jones, O, 1920-12-12, "
                + "2277, Martha, Jones, F, 1958-12-12, "
                + "9000, Jessica, Jones, F, 1992-03-04, " ;
        String result = q.patientByName(lastName);
        System.out.println("Target string is...");
        System.out.println(target);
        System.out.println("Result string is...");
        System.out.println(result);
        
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
        String target = "9000, Jones, Feeding, 22.6, null, null, null"
                + ", 1992-03-04, 9000, Jones, Changed, null, 1, 0, null"
                + ", 1992-03-04, 9000, Jones, weight, null, null, null, 22.6"
                + ", 1992-03-04, ";
        String result = q.eventById(id);
        assertEquals(target,result);
              
    }

    @Test
    public void testEventByNameArray() {
        String target = "9000, Jones, Feeding, 22.6, null, null, null"
                + ", 1992-03-04, 9000, Jones, Changed, null, 1, 0, null"
                + ", 1992-03-04, 9000, Jones, weight, null, null, null, 22.6"
                + ", 1992-03-04, ";
        String result = q.eventByName(lastName);
        assertEquals(target, result);
              
    }

}
