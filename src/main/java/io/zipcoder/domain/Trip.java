package io.zipcoder.domain;

import com.fasterxml.jackson.annotation.*;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by willhorton on 3/2/16.
 */

@Entity
public class Trip {

    @Id
    @GeneratedValue
    @Column(name="TRIP_ID")
    private Long tripId;

    @Column(name="TRIP_NAME")
    private String name;

    @ManyToMany
    @JoinTable(name="user_trip", joinColumns = @JoinColumn(name="TRIP_ID"), inverseJoinColumns = @JoinColumn(name="USERNAME"))
    private Set<User> users;

    public Long getId() {
        return tripId;
    }

    public void setId(Long id) {
        this.tripId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}