package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

/**
 * Class controls the UPDATE function for the Person, Patient and User
 *  tables. Contains methods to add patients, users, or simply persons.
 * @author John Norman
 * @Version 2019/7/26
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
    public boolean insertPerson(String first, String last, String gender, Date dob) {
        
        
        try {
            String sql = "INSERT INTO Person(FirstName, LastName, Gender, DOB)" + 
                    "VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, first);
            stmt.setString(2, last);
            stmt.
            stmt.setString(3, gender);
            stmt.setInt(4, ID);
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
                
                
                        
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setString(2, firstName);
                stmt.setString(3, lastName);
                stmt.setString(4, gender);
                stmt.setString(5, dob);                
                stmt.executeUpdate();
                
                String sql2= ""
                        + "INSERT INTO patient(ID, LastName)"
                        + "VALUES (?, ?)";
                
                stmt = conn.prepareStatement(sql2);
                stmt.setInt(1, id);
                stmt.setString(2, lastName);
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
        String sql = ""
                + "INSERT INTO Person(id, FirstName, LastName)"
                + "VALUES (?, ?, ?);";
               
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.executeUpdate();
            String sql2 = ""
            + "INSERT INTO AppUser(id, username, password)"
            + "VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql2);
            stmt.setInt(1, Id);
            stmt.setString(2, userName);
            stmt.setString(3, password);

            stmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
