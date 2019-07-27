package nutrilog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the database controller class: DB_Controller 
 * @author John Norman
 * @version 2019-7-27
 */
public class DB_ControllerTest {
    /**
     * A test case for DB_Controller class
     */
    protected DB_Controller d;
    /**
     * Used to set up and tear down the database used in testing
     */
    protected DB_Setup data;
    /**
     * Before each test create a new database, initialized with 
     * appropriate tables.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        d = new DB_Controller();
        data = new DB_Setup();
        data.create();
        data.init(); 
    }
    /**
     * After each test delete the database that was created in setup. 
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        data.dropDatabase();
    }
    /**
     * Test the default constructor.
     */
    @Test
    public void testDB_Controller() {
        assertNotNull(d);
    }
    /**
     * Test the default connection method. The specified URL method is required
     * for the dropDatabase() function so is tested by that method's test.
     */
    @Test
    public void testConnect() {
        assertNotNull(d.connect());
    }
    /**
     * Test the close method.
     */
    @Test
    public void testClose() {
        assertTrue(d.close());
    }
}
