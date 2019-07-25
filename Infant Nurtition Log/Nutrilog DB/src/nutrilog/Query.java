package nutrilog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query extends DB_Controller {
    Connection conn = super.connect();


    
    public String patientByName(String lastName) {
        String first = null;
        String last = null;
        StringBuilder sb = new StringBuilder();
        try {
            
            String sql =""
                    + "SELECT "
                    + "PersonID, Person.FirstName, Patient.LastName "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "patient ON Person.LastName = Patient.LastName";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String del = ", ";
//                sb.append(rs.getInt("Person.ID"));
                sb.append(first = rs.getString("Person.FirstName"));
                sb.append(del);
                sb.append(last = rs.getString("Patient.LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        String resultString =sb.toString();
        return (resultString );
    }
    public boolean patientByID() {
//        try {
//            stmt = conn.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            close();
//        }
        return true;
    }
    public boolean eventById() {
//        try {
//            stmt = conn.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            close();
//        }
        return true;
    }
    public boolean eventByName() {
//        try {
//            stmt = conn.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            close();
//        }
        return true;
    }

}
