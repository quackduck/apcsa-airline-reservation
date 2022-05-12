public class Passenger {
    private String firstName; 
    private String lastName;
    
    public Passenger(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String toString() {
        return firstName + " " + lastName;
    }
}

