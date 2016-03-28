package io.zipcoder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by nicholaswebb on 3/21/16.
 */
@Entity
@Table(name="OTHER")
public class Other {
    @Id
    @GeneratedValue
    @Column(name="OTHER_ID", unique = true)
    private int otherID;
    @NotNull
    @Column(name ="OTHER_NAME")
    private String otherName;
    @NotNull
    @Column(name="OTHER_PRICE")
    private double otherPrice;

    public int getOtherID(){
        return otherID;
    }
    public String getOtherName(){
        return otherName;
    }
    public double getOtherPrice(){
        return otherPrice;
    }
    public void setOtherID(int otherID){
        this.otherID = otherID;
    }
    public void setOtherName(String otherName){
        this.otherName = otherName;
    }
    public void setOtherPrice(double otherPrice){
        this.otherPrice = otherPrice;
    }
}
