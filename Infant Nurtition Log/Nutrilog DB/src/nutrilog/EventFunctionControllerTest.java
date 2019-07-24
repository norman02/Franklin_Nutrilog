package nutrilog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventFunctionControllerTest {
    EventFunctionController event;
    int ID;
    String date;
    double unit;

    @Before
    public void setUp() throws Exception {
        event = new EventFunctionController();
        ID = 4441;
        date = "2018/04/04";
    }

    @After
    public void tearDown() throws Exception {
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
        assertTrue(event.logChanging());
    }

    @Test
    public void testLogWeight() {
        assertTrue(event.logWeight());
    }

}
