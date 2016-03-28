package io.zipcoder.domain;

/**
 * Created by johnb on 3/28/16.
 */
public class YelpLocation {
    private String[] address;
    private String city;
    private YelpCoordinate coordinate;
    private String country_code;
    private String cross_streets;
    private String[] display_address;
    private double geo_accuracy;
    private String[] neighborhoods;
    private long postal_code;
    private String state_code;

    public YelpCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(YelpCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCross_streets() {
        return cross_streets;
    }

    public void setCross_streets(String cross_streets) {
        this.cross_streets = cross_streets;
    }

    public String[] getDisplay_address() {
        return display_address;
    }

    public void setDisplay_address(String[] display_address) {
        this.display_address = display_address;
    }

    public double getGeo_accuracy() {
        return geo_accuracy;
    }

    public void setGeo_accuracy(double geo_accuracy) {
        this.geo_accuracy = geo_accuracy;
    }

    public String[] getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(String[] neighborhodds) {
        this.neighborhoods = neighborhodds;
    }

    public long getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(long postal_code) {
        this.postal_code = postal_code;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
