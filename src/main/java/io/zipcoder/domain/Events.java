package io.zipcoder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by nicholaswebb on 3/21/16.
 */
@Entity
@Table(name="EVENTS")
public class Events {

    @Id
    @GeneratedValue
    @Column(name="EVENT_ID", unique = true)
    private int eventID;
    @NotNull
    @Column(name="EVENT_NAME")
    private String eventName;
    @NotNull
    @Column(name="EVENT_PRICE")
    private double eventPrice;

    public int getEventID(){
        return eventID;
    }
    public String getEventName(){
        return eventName;
    }
    public double getEventPrice(){
        return eventPrice;
    }

    public void setEventID(int eventID){
        this.eventID = eventID;
    }
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    public void setEventPrice(double eventPrice){
        this.eventPrice = eventPrice;
    }

}
