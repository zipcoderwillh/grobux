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

    @OneToMany(cascade=CascadeType.ALL)
    //@JoinColumn(name="TRIP_ID")
    private Set<User> users;

    /*
    @OneToMany
    @JoinColumn(name="TRIP_ID")
    private Set<User> expenses;
    */

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

    public Set getUsers() {
        return users;
    }

    public void setUsers(Set users) {
        this.users = users;
    }

    /*
    public Set getExpenses() {
        return expenses;
    }

    public void setExpenses(Set expenses) {
        this.expenses = expenses;
    }
    */

}
