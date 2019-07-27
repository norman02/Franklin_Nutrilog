package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NutriLogDB {

    public static int addPerson(Person person) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO Person(FirstName, LastName, Gender, DOB)" + 
                    "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getGender());
            ps.setDate(4, new java.sql.Date(person.getDOB().getTime()));
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}