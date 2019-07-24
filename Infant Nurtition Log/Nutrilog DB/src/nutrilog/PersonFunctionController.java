package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class controls the UPDATE function for the Person table
 * @author John Norman
 *
 */
public class PersonFunctionController extends DB_Controller  {
    /**
     * Establish connection to database
     */
    Connection conn = super.connect();
    /**
     * Prepare statment
     */
    PreparedStatement stmt = null;
   

    /**
     * Inserts a row into the person table
     * @param ID: unique identification number #Phone or #ssn
     * @param first: Persons first name
     * @param last: Person's last name
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
     * @param id unique id number ie phone or ssn
     * @param firstName
     * @param lastName
     * @param gender F, M, or O. 
     * @param dob Date of birth format 'yyyy/mm/dd'
     * @return boolean successful update t/f
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


    /**
     * @param Id unique id number ie phone or ssn
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @return boolean update successful?
     */
    public boolean addUser(int Id, String firstName, String lastName,
            String userName, String password) {
        String sql = "INSERT INTO Person(id, FirstName, LastName"
                + ", UserName, Password, user)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            System.out.println("Inserting data into person...");
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, userName);
            stmt.setString(5, password);
            stmt.setInt(6, 1);
            stmt.executeUpdate();
            System.out.println("data successfully inserted");
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
