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
                    + "Person.gender, person.dob "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "patient USING (lastname) "
                    + "WHERE lastName = '"
                    +  lastName +"';";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                do {
                    sb.append(rs.getString(1)+del);
                    sb.append(rs.getString(2)+del);
                    sb.append(rs.getString(3)+del);
                    sb.append(rs.getString(4)+del);
                    sb.append(rs.getString(5)+del);

  
                } while (rs.next());
            }
            resultString = sb.toString();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return (resultString);
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
                    + "event.FoodUnit, event.stool, event.urine, event.weight, "
                    + "event.eventdate "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "Event USING(ID) "
                    + "WHERE person.id = '"
                    +  id +"';";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                do {
                    sb.append(rs.getString(1)+del);
                    sb.append(rs.getString(2)+del);
                    sb.append(rs.getString(3)+del);
                    sb.append(rs.getString(4)+del);
                    sb.append(rs.getString(5)+del);
                    sb.append(rs.getString(6)+del);
                    sb.append(rs.getString(7)+del);
                    sb.append(rs.getString(8)+del);
                   
                } while (rs.next());
            }
            resultString = sb.toString();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        
        
        return (resultString);
    }
    public String eventByName(String lastName) {
        try {
            
            String sql =""
                    + "SELECT "
                    + "Person.ID, Person.lastname, event.EventName,"
                    + "event.FoodUnit, event.stool, event.urine, event.weight, "
                    + "event.eventdate "
                    + "FROM "
                    + "person "
                    + "LEFT JOIN "
                    + "Event USING(ID) "
                    + "WHERE person.LastName = '"
                    +  lastName +"';";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                do {
                    sb.append(rs.getString(1)+del);
                    sb.append(rs.getString(2)+del);
                    sb.append(rs.getString(3)+del);
                    sb.append(rs.getString(4)+del);
                    sb.append(rs.getString(5)+del);
                    sb.append(rs.getString(6)+del);
                    sb.append(rs.getString(7)+del);
                    sb.append(rs.getString(8)+del);
                   
                } while (rs.next());
            }
            resultString = sb.toString();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        
        
        return (resultString);
    }

}
