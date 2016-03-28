package io.zipcoder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)



/**
 * Created by nicholaswebb on 3/28/16.
 */
public class YelpBusinesses {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
