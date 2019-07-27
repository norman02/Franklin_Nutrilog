package nutrilog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DB_ControllerTest {
    DB_Controller d;
    DB_Setup data;

    @Before
    public void setUp() throws Exception {
        d = new DB_Controller();
        data = new DB_Setup();
        data.create();
        data.init();
        
    }

    @After
    public void tearDown() throws Exception {
        data.dropDatabase();
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
