package nutrilog;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    
    private int id;
    private String firstName;
    private String lastName;
    private char gender;
    private Date dob;
    private String tob;
    private String birthWeight;
    
    public Person() {
        firstName = "";
        lastName = "";
        gender = 'X';
        dob = new Date();
    }
    
    public void setId(int in) {
        this.id = in;
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
    
    public void setTOB(String in) {
        this.tob = in;
    }
    
    public void setBirthWeight(int lbs, int oz){
        this.birthWeight = (lbs + " pounds, " + oz + " ounces");
    }
    
    public void setBirthWeight(String in){
        this.birthWeight = in;
    }
    
    public int getId() {
        return id;
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
    
    public Date getDob() {
        return dob;
    }
    
    public String getTob() {
        return tob;
    }
    
    public String getBirthWeight() {
        return birthWeight;
    }
    
}