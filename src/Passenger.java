// Passenger.java
// by Ishan Goel, Alvin Liu
// 5/19/2022
// Period 3

package AirlineReservation;

public class Passenger {
    // fields
    private String firstName; 
    private String lastName;
    private int flightNum;
    
    // constructor
    public Passenger(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    // accessors
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nFlight number: " + flightNum;
    }
    
    // mutators
    public void setFirstName(String first) {
        firstName = first;
    }
    public void setLastName(String last) {
        lastName = last;
    }
    public void setFlightNum(int num) {
        flightNum = num;
    }
}

