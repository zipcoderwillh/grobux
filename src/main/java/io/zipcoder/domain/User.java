package io.zipcoder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by willhorton on 3/2/16.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id;

    @Column(name="USER_NAME")
    private String name;

}
