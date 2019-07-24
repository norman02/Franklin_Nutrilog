package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EventFunctionController extends DB_Controller {
    String sql;
    int number = 2;
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
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    boolean logChanging(int id, String date, boolean urine, boolean stool) {
        try {
            stmt = conn.prepareStatement(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close();
        }
        return false;
    }
    boolean logWeight() {
        return true;
    }

}
