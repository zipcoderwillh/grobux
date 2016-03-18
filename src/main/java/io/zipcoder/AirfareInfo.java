package io.zipcoder;

/**
 * Created by nicholaswebb on 3/2/16.
 */
public class AirfareInfo {


    int adults;
    int children;
    String departLocation;
    String destination;
    String departureDate;
    String returnDate;
    double price;
    /*
    public AirfareInfo(int adults, int children, String destination, String departureDate, String returnDate, double price){
        this.children = children;
        this.adults = adults;
        this.departureDate = departureDate;
        this.destination = destination;
        this.returnDate = returnDate;
        this.price = price;
    }
    */
    public int getAdults(){
        return adults;
    }
    public int getChildren(){
        return children;
    }
    public double getPrice(){
        return price;
    }
    public String getDestination(){
        return destination;
    }
    public String getDepartureDate(){
        return departureDate;
    }
    public String getReturnDate(){
        return returnDate;
    }
    public String getDepartLocation(){
        return departLocation;
    }
    public void setAdults(int adults){
        this.adults = adults;
    }
    public void setChildren(int children){
        this.children = children;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setDepartureDate(String departureDate){
        this.departureDate = departureDate;
    }
    public void setReturnDate(String returnDate){
        this.returnDate = returnDate;
    }
    public void setDepartLocation(String departLocation){
        this.departLocation = departLocation;
    }


}
