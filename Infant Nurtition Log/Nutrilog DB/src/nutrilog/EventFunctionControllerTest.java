package nutrilog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventFunctionControllerTest {
    DB_Setup db;
    EventFunctionController event;
    PersonFunctionController pfc;
    int ID;
    String date;
    double unit;
    String firstName;
    String lastName;
    String gender;
    boolean urine;
    boolean stool;

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
        
        pfc.addPatient(ID, firstName, lastName, gender, date);
    }

    @After
    public void tearDown() throws Exception {
        db.dropDatabase();
    }
    @Test
    public void testDefaultConstructor() {
        assertNotNull(event);
    }

    @Test
    public void testLogFeeding() {
        assertTrue(event.logFeeding(ID, date, unit));
    }

    @Test
    public void testLogChanging() {
        
        assertTrue(event.logChanging(ID, date, urine, stool));
    }

    @Test
    public void testLogWeight() {
        assertTrue(event.logWeight());
    }

}
