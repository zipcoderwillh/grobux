package io.zipcoder.domain;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by johnb on 3/2/16.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name="USERNAME", unique=true)
    private String userName;
    @NotNull
    @Column(name="PASSWORD")
    private String password;
    @Column(name="CAPITOL_ONE_ID")
    private String capitolOneID;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;

    @ManyToMany
    @JoinTable(name="USER_TRIPS")
    private Set<Trip> trips;

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCapitolOneID() {
        return capitolOneID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User() {

    }
}