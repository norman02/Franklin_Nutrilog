package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Allows for updating the tables in the database dealing with people
 * @author John Norman
 *
 */
public class PersonFunctionController extends DB_Controller  {
    Connection conn = super.connect();
    PreparedStatement stmt = null;
   

    /**
     * Inserts a row into the person table
     * @param ID
     * @param first
     * @param last
     * @return insert successful true/false
     */
    public boolean insertPerson(int ID, String first, String last) {
        
        
        try {
            String sql = "INSERT INTO Person(id, FirstName, LastName)" + 
                    "VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ID);
            stmt.setString(2, first);
            stmt.setString(3, last);
            
            stmt.executeUpdate();

            // rows affected
            //System.out.println(row); //1
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return false;
    }


    public boolean addPatient(int id, String firstName, 
            String lastName, String gender, String dob) {
        try {
                String sql = "INSERT INTO Person("
                        + "id, FirstName, LastName, gender, dob)" + 
                        "VALUES (?, ?, ?, ?, ?)";
                        
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setString(2, firstName);
                stmt.setString(3, lastName);
                stmt.setString(4, gender);
                stmt.setString(5, dob);                
                stmt.executeUpdate();

                // rows affected
                //System.out.println(row); //1
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
           
            return false;
    }


   
   
    
  
    
}
