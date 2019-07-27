package nutrilog;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * A JUnit test class for the DB_Setup class
 * @author John Norman
 * @version 2019-7-27
 */
public class DB_SetupTest {
    /**
     * Instantiate a test case for DB_Setup
     */
    DB_Setup db;
    /**
     * Before each test create a new database
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        db = new DB_Setup();
        db.create();
    }
    /**
     * After each test delete the database
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        db.dropDatabase();
    }
    /**
     * Test the default constructor method is not null
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(db);
    }
    /**
     * Test the init() method returns true on a successful initialization
     * TODO Test False
     */
    @Test
    public void testInit() {        
        assertTrue(db.init());
    }
    /**
     * Test the Create() method returns true on a successful creation
     * TODO Test False
     */
    @Test
    public void testCreate() {
       db.dropDatabase();
       assertTrue(db.create());
    }
    /**
     * Test that DropDatabase() returns true on a successful deletion
     * TODO test False
     */
    @Test
    public void testDropDatabase() {
        assertTrue(db.dropDatabase());
    }
}
