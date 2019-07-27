package nutrilog;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    
    private String firstName;
    private String lastName;
    private char gender;
    private Date dob;
    
    public Person() {
        firstName = "";
        lastName = "";
        gender = 'X';
        dob = new Date();
    }
    
    public void setFirstName(String in) {
        this.firstName = in;
    }
    
    public void setLastName(String in) {
        this.lastName = in;
    }
    
    public void setGender(char in) {
        this.gender = in;
    }
    
    public void setDOB(Date in) {
        this.dob = in;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getGender() {
        return String.valueOf(gender);
    }
    
    public Date getDOB() {
        return dob;
    }
}