package io.zipcoder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by nicholaswebb on 3/21/16.
 */
@Entity
@Table(name="TRAVEL")
public class Travel {

    @Id
    @GeneratedValue
    @Column(name="TRAVEL_ID", unique = true)
    private int travelID;
    @NotNull
    @Column(name="TRAVEL_NAME")
    private String travelName;
    @NotNull
    @Column(name="STARTING_LOCATION")
    private String startingLocation;
    @NotNull
    @Column(name="ENDING_LOCATION")
    private String endingLocation;
    @NotNull
    @Column(name="DEPARTURE_DATE")
    private String departureDate;
    @NotNull
    @Column(name="ARRIVAL_DATE")
    private String arrivalDate;
}
