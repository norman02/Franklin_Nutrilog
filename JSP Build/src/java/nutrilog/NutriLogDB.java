package nutrilog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NutriLogDB {

    public static int addPerson(Person person) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO Person(FirstName, LastName, Gender, DOB, TOB, BirthWeight)" + 
                    "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getGender());
            ps.setDate(4, new java.sql.Date(person.getDob().getTime()));
            ps.setString(5, person.getTob());
            ps.setString(6, person.getBirthWeight());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Person searchByNumber(String search) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Person person = new Person();
        String sql = "SELECT * FROM person WHERE Person.id = " + search;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                person.setId(rs.getInt("ID"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                char gender = rs.getString("Gender").charAt(0);
                person.setGender(gender);
                Date date = rs.getDate("DOB");
                person.setDOB(date);
                person.setTOB(rs.getString("TOB"));
                person.setBirthWeight(rs.getString("BirthWeight"));
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return person;
    }
    
    public static List<Person> searchByName(String search) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE Person.lastName = '" + search + "'";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("ID"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                char gender = rs.getString("Gender").charAt(0);
                person.setGender(gender);
                Date date = rs.getDate("DOB");
                person.setDOB(date);
                people.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return people;
    }
    
    public static int addEvent(Event event) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO Event(ID, FoodAmount, FoodUnits, Urine, Stool, Weight, EventDate, EventTime)" + 
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, event.getPatient().getId());
            ps.setInt(2, event.getFoodAmount());
            ps.setString(3, event.getFoodUnits());
            ps.setBoolean(4, event.getUrine());
            ps.setBoolean(5, event.getStool());
            ps.setString(6, event.getWeight());
            ps.setDate(7, new java.sql.Date(event.getEventDate().getTime()));
            ps.setString(8, event.getEventTime());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Event> getPatientInfo(String searchValue) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Event> dataSet = new ArrayList<>();
        Event lastFed = new Event();
        Event lastChanged = new Event();
        Event lastWeighed = new Event();
        
        String sql = "SELECT * FROM Event WHERE ID = " + searchValue;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getInt("FoodAmount"));
                if (rs.getInt("FoodAmount") > 0) {
                    lastFed.setEventDate(rs.getDate("EventDate"));
                    lastFed.setEventTime(rs.getString("EventTime"));
                    lastFed.setFoodAmount(rs.getInt("FoodAmount"));
                    lastFed.setFoodUnits(rs.getString("FoodUnits"));
                }
            }
            dataSet.add(lastFed);
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                if (rs.getBoolean("Urine") || rs.getBoolean("Stool"))
                    lastChanged.setEventDate(rs.getDate("EventDate"));
                    lastChanged.setEventTime(rs.getString("EventTime"));
            }
            dataSet.add(lastChanged);
            rs = ps.executeQuery(sql);
            while(rs.next()) {
                if (!rs.getString("Weight").equals("")) {
                    lastWeighed.setEventDate(rs.getDate("EventDate"));
                    lastWeighed.setWeight(rs.getString("Weight"));
                }
            }
            dataSet.add(lastWeighed);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return dataSet;
    }
}