package nutrilog;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {
    
    private int number;
    private Person patient;
    private int foodAmount;
    private String foodUnits;
    private boolean urine;
    private boolean stool;
    private String weight;
    private Date eventDate;
    private String eventTime;
    
    
    public Event() {
        number = 0;
        patient = null;
        foodAmount = 0;
        foodUnits = "";
        urine = false;
        stool = false;
        weight = "";
        eventDate = new Date();
    }
    
    public void setNumber(int in){
        this.number = in;
    }
    
    public void setPatient(Person in){
        this.patient = in;
    }
    
    public void setFoodAmount(int in){
        this.foodAmount = in;
    }
    
    public void setFoodUnits(String in){
        this.foodUnits = in;
    }
    
    public void findUrine(){
        this.urine = true;
    }
    
    public void findStool(){
        this.stool = true;
    }
    
    public void setWeight(int lbs, int oz){
        this.weight = (lbs + " pounds, " + oz + " ounces");
    }
    
    public void setWeight(String in){
        this.weight = in;
    }
    
    public void setEventDate(Date in){
        this.eventDate = in;
    }
    
    public void setEventTime(String in){
        this.eventTime = in;
    }
    
    public int getNumber(){
        return number;
    }
    
    public Person getPatient(){
        return patient;
    }
    
    public int getFoodAmount(){
        return foodAmount;
    }
    
    public String getFoodUnits(){
        return foodUnits;
    }
    
    public boolean getUrine(){
        return urine;
    }
    
    public boolean getStool(){
        return stool;
    }
    
    public String getWeight(){
        return weight;
    }
    
    public Date getEventDate(){
        return eventDate;
    }
    
    public String getEventTime(){
        return eventTime;
    }

}