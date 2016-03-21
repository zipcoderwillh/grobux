package io.zipcoder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by nicholaswebb on 3/18/16.
 */
@Entity
@Table(name = "SIGHTSEEING")
public class Sightseeing {

    @Id
    @GeneratedValue
    @Column(name="SIGHTSEEING_ID", unique = true)
    private Integer sightSeeingID;
    @NotNull
    @Column(name="SIGHTSEEING_NAME")
    private String sightseeingName;
    @NotNull
    @Column(name="SIGHTSEEING_PRICE")
    private double sightseeingPrice;

    public Integer getSightSeeingID(){
        return sightSeeingID;
    }
    public String getSightseeingName(){
        return sightseeingName;
    }
    public double getSightseeingPrice(){
        return sightseeingPrice;
    }

    public void setSightseeingName( String sightseeingName){
        this.sightseeingName = sightseeingName;
    }
    public void setSightseeingPrice(double sightseeingPrice){
        this.sightseeingPrice = sightseeingPrice;
    }





}
