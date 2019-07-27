package nutrilog;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Test class for the EventFunctionController class
 * @author John Norman
 * @version 2019-7-27
 *
 */
public class EventFunctionControllerTest {
    /**
     * Used to setup, initialize and delete the database
     */
    DB_Setup db;
    /**
     * A test instance of the EventFunction Controller
     */
    EventFunctionController event;
    /**
     * Used to add test data to the database
     */
    PersonFunctionController pfc;
    /**
     * Test variable for id number
     */
    int ID;
    /**
     * test variable for date
     */
    String date;
    /**
     * Test variable for units of food
     */
    double unit;
    /**
     * test variable for first name
     */
    String firstName;
    /**
     * test variable for last name
     */
    String lastName;
    /**
     * test variable for gender
     */
    String gender;
    /**
     * test variable for urine
     */
    boolean urine;
    /**
     * test variable for stool
     */
    boolean stool;
    /**
     * test variable for weight
     */
    double weight;
    /**
     * Before each test create a new database with fresh test data
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        db = new DB_Setup();
        db.create();
        db.init();
        event = new EventFunctionController();
        pfc = new PersonFunctionController();
        ID = 4441;
        date = "2018/04/04";
        unit = 40.6;
        firstName = "Tom";
        lastName = "Hanks";
        gender = "M";
        urine = true;
        stool = false;
        weight = 87.6;
        pfc.addPatient(ID, firstName, lastName, gender, date);
    }
    /**
     * delete the database after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        db.dropDatabase();
    }
    /**
     * Test default constructor
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(event);
    }
    /**
     * test the logFeeding() method
     */
    @Test
    public void testLogFeeding() {
        //TODO test with query
        assertTrue(event.logFeeding(ID, date, unit));
    }
    /**
     * Test the logChanging() method
     */
    @Test
    public void testLogChanging() { 
      //TODO test with query
        assertTrue(event.logChanging(ID, date, urine, stool));
    }
    /**
     * Test the logWeight() method
     */
    @Test
    public void testLogWeight() {
      //TODO test with query
        //TODO test patient weight updated
        assertTrue(event.logWeight(ID, date, weight));
    }
}
