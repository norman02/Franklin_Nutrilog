package nutrilog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * The event function controllers updates the event table in the Nutrilog
 * database.
 * @author John Norman
 * @version 2019-7-27
 *
 */
public class EventFunctionController extends DB_Controller {
    /**
     * String used to hold SQL commands
     */
    String sql;
    /**
     * starting value for the event number
     */
    int number = 100000;
    /**
     * A connection to the database
     */
    Connection conn = super.connect();
    /**
     * A prepared statement used for SQL queries
     */
    PreparedStatement stmt;    
    /**
     * Inserts a feeding event into the event table
     * @param id - patient id number
     * @param date - date of the feeding
     * @param unit - amount of food given in milliliters
     * @return boolean representing successful insertion
     */
    boolean logFeeding(int id, String date, double unit) {       
        try {
            sql = "     INSERT INTO Event"
                    +   "(EventNum, EventName, EventDate, FoodUnit, id)"
                    +   "VALUES" 
                    +   "(?, ?, ?, ?, ?)"
                    ;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, number);
            stmt.setString(2, "Feeding");
            stmt.setString(3, date);
            stmt.setDouble(4, unit);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            number++;
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        return false;
    }
    /**
     * Inserts a changing event into event table
     * @param id - patient id number
     * @param date - date of changing
     * @param urine - boolean representing if urine present
     * @param stool - boolean representing if stool present
     * @return boolean representing if insert successful
     */
    boolean logChanging(int id, String date, boolean urine, boolean stool) {
        try {
            sql = "INSERT INTO Event("
                    + "id, EventNum, EventName, EventDate, urine, stool)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, number);
            stmt.setString(3, "Changed");
            stmt.setString(4, date);
            stmt.setBoolean(5, urine);
            stmt.setBoolean(6, stool);
            stmt.executeUpdate();
            number++;
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Insert a weighing event into event table
     * @param id - patient id number
     * @param date - date of weighing
     * @param weight - patient weight in kilograms
     * @return boolean representing if insert successful 
     */
    boolean logWeight(int id, String date, double weight) {
        try {
            sql = "INSERT INTO Event("
                    + "id, EventNum, EventName, EventDate, weight)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, number);
            stmt.setString(3, "weight");
            stmt.setString(4, date);
            stmt.setDouble(5, weight);
            stmt.executeUpdate();
            number++;
            return true;
        } catch (SQLException e) {            
            e.printStackTrace();
        } 
        return false;
    }
}
