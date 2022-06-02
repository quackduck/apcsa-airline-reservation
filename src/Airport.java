/*
 * Airport.java
 * by Nikki Benabbas
 * 5/17/2022
 * p3
 */

import java.util.ArrayList;

public class Airport {

    private String airport;
    private String city;
    private String state;
    private double GMTOffset;

    public Airport(String airport, String city, String state, double GMTOffset) {
        this.airport = airport;
        this.city = city;
        this.state = state;
        this.GMTOffset = GMTOffset;
    }

    public String getAirport() {
        return airport;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public double getGMTOffset() {
        return GMTOffset;
    }

    public String toString() {
        return "Airport: " + airport + " City: " + city + " State: " + state + " GMT Offset: " + GMTOffset;
    }

}
