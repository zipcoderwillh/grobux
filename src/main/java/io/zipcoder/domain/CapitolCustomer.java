package io.zipcoder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created by johnb on 3/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class CapitolCustomer {

    private String _id;
    private String first_name,last_name;

    public String get_id() {
        return _id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
