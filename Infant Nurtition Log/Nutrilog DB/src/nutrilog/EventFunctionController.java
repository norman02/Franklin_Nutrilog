package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EventFunctionController extends DB_Controller {
    String sql;
    int number = 100000;
    Connection conn = super.connect();
    PreparedStatement stmt;
    
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
