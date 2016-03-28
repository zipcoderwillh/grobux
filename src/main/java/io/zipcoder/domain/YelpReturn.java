package io.zipcoder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)


public class YelpReturn {


    private YelpBusinesses[] businesses;
    private long total;


    public long getTotal(){
        return total;
    }
    public void setTotal(long total){
        this.total = total;
    }

    public YelpBusinesses[] getBusinesses() {
        return businesses;
    }

    public void setBusinesses(YelpBusinesses[] businesses) {
        this.businesses = businesses;
    }

}
