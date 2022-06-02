// Passenger.java
// by Ishan Goel, Alvin Liu
// 5/19/2022
// Period 3

public class Passenger implements java.io.Serializable {
    // fields
    private String firstName;
    private String lastName;

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
        return firstName + " " + lastName;
    }

    // mutators
    public void setFirstName(String first) {
        firstName = first;
    }

    public void setLastName(String last) {
        lastName = last;
    }
}
