package nutrilog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query extends DB_Controller {
    Connection conn = super.connect();
    String del = ", ";
    String resultString = "UNEXPECTED FAILURE";


    
    public String patientByName(String lastName) {

        
        try {
            
            String sql =""
                    + "SELECT "
                    + "Person.ID, Person.FirstName, Person.lastname, "
                    + "Person.gender, person.dob, Patient.LastName "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "patient patient USING (lastname) "
                    + "WHERE lastName = '"
                    +  lastName +"';";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {

                
                int temp = rs.getInt("id");
                String id = Integer.toString(temp);
                String first = rs.getString("FirstName");
                String last = rs.getString("LastName");
                String gender = rs.getString("gender");
                String DOB = rs.getString("dob");
                
                
                
                resultString =id + del+ first + del + last + del
                        + gender + del + DOB;
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        
        return (resultString );
    }
    public String patientByID(int id) {

        
        try {
            
            String sql =""
                    + "SELECT "
                    + "Person.ID, Person.FirstName, Person.lastname, "
                    + "Person.gender, person.dob, Patient.LastName "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "patient patient USING (lastname) "
                    + "WHERE person.id = '"
                    +  id +"';";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {

                
                int temp = rs.getInt("id");
                String ID = Integer.toString(temp);
                String first = rs.getString("FirstName");
                String last = rs.getString("LastName");
                String gender = rs.getString("gender");
                String DOB = rs.getString("dob");
                
                
                
                resultString =id + del+ first + del + last + del
                        + gender + del + DOB;
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        
        return (resultString );
    }
    public String eventById(int id) {
        

        
        try {
            
            String sql =""
                    + "SELECT "
                    + "Person.ID, Person.lastname, event.EventName,"
                    + "event.FoodUnit  "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "Event USING(ID) "
                    + "WHERE person.id = '"
                    +  id +"';";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String ID = Integer.toString(rs.getInt("id"));               
                String last = rs.getString("LastName");
                String eName = rs.getString("EventName"); 
                String unit = Double.toString(rs.getDouble("FoodUnit"));
                
                resultString = ID + del + last + del + eName + del + unit ;
                }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        
        return (resultString );
    }
    public String eventByName(String lastName) {

        
        try {
            
            String sql =""
                    + "SELECT "
                    + "Person.ID, Person.lastname, event.EventName,"
                    + "event.FoodUnit  "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "Event USING(ID) "
                    + "WHERE person.lastname = '"
                    +  lastName +"';";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String ID = Integer.toString(rs.getInt("id"));               
                String last = rs.getString("LastName");
                String eName = rs.getString("EventName"); 
                String unit = Double.toString(rs.getDouble("FoodUnit"));
                
                resultString = ID + del + last + del + eName;
                }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        
        return (resultString );
    }

}
