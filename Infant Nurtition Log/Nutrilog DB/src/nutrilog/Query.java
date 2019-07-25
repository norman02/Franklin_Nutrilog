package nutrilog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query extends DB_Controller {
    Connection conn = super.conn;
    Statement stmt = null;

    
    public String patientByName(String lastName) {
        try {
            stmt = conn.createStatement();
            String sql =""
                    + "SELECT"
                    + "Person.FirstName, Patient.LastName"
                    + "FROM"
                    + "person"
                    + "LEFT JOIN"
                    + "patient ON Person.LastName = Patient.LastName";
            ResultSet rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return lastName;
    }
    public boolean patientByID() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return true;
    }
    public boolean eventById() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return true;
    }
    public boolean eventByName() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return true;
    }

}
