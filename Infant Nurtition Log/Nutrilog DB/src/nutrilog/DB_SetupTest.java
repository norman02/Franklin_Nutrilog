package nutrilog;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DB_SetupTest {
    DB_Setup db;

    @Before
    public void setUp() throws Exception {
        db = new DB_Setup();
        db.create();
    }

    @After
    public void tearDown() throws Exception {
        db.dropDatabase();
    }
    @Test
    public void testDefaultConstructor() {
        assertNotNull(db);
    }
    @Test
    public void testInit() {
        
        assertTrue(db.init());
    }

    @Test
    public void testCreate() {
       db.dropDatabase();
       assertTrue(db.create());
    }

    @Test
    public void testDropDatabase() {
        assertTrue(db.dropDatabase());
    }

}
