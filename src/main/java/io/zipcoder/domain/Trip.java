package io.zipcoder.domain;

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

    @OneToOne
    @JoinColumn(name="USER")
    private User user;

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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}