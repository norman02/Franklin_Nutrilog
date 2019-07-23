package nutrilog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class for testing and development of function controllers
 * 
 * @author norman
 * 
 *          
 * 
 * 
 */
public class DB_Development {
    static DB_Setup setup = new DB_Setup();

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            setup.dropDatabase();
            setup.create();
            setup.init();
      
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
