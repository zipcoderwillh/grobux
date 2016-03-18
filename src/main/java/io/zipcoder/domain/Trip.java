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
    private Long id;

    @Column(name="TRIP_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name="USER")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public User getUsers() {
        return user;
    }

    public void setUsers(User users) {
        this.user = users;
    }
    */

}