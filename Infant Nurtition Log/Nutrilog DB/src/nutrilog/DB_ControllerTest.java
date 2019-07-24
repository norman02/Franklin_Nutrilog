package nutrilog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DB_ControllerTest {
    DB_Controller d;

    @Before
    public void setUp() throws Exception {
        d = new DB_Controller();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDB_Controller() {
        assertNotNull(d);
    }

    @Test
    public void testConnect() {
        assertNotNull(d.connect());
    }

    @Test
    public void testClose() {
        assertTrue(d.close());
    }

}
