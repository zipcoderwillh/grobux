package io.zipcoder.domain;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
/**
 * Created by johnb on 3/2/16.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id;
    @Column(name="USERNAME", unique=true)
    private String userName;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="CAPITOL_ONE_ID")
    private String capitolOneID;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;

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

}
