package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


    /**
     * Adds a patient to the database
     * @param id
     * @param firstName
     * @param lastName
     * @param gender
     * @param dob
     * @return boolean successful t/f
     */
    public boolean addPatient(int id, String firstName, 
            String lastName, String gender, String dob) {
        try {
                String sql = "INSERT INTO Person("
                        + "id, FirstName, LastName, gender, dob)" + 
                        "VALUES (?, ?, ?, ?, ?)";
                
                String sql2 = "UPDATE Person "
                             + "SET patient = 1 "
                             + " WHERE ID = ?";
                        
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setString(2, firstName);
                stmt.setString(3, lastName);
                stmt.setString(4, gender);
                stmt.setString(5, dob);                
                stmt.executeUpdate();
                
                
                stmt = conn.prepareStatement(sql2);
                stmt.setInt(1, id);
                stmt.executeUpdate();

                // rows affected
                //System.out.println(row); //1
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
           
            return false;
    }


    public boolean addUser(int Id, String firstName, String lastName,
            String userName, String password) {
        String sql = 
                "INSERT INTO Person(id, FirstName, LastName)" + 
                "VALUES (001, 'Maxine', 'Powers');" + 
                "INSERT INTO AppUser (ID, Username, Password)" + 
                "VALUES (001, 'MaxPower', 'strong');";
        try {
            stmt = conn.prepareStatement(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
