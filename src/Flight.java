// Flight.java
// By Tamir M.
// 3/24/2022
// Period 3

package ARS;

public class Flight {
    private Airport departureLocation;
    private Airport arrivalLocation;
    private int flightIDNumber;
    private FlightDate departureDate;
    private FlightDate arrivalDate;
    private int capacity;
    
    public Flight(Airport departureLocation, Airport arrivalLocation, int flightIDNumber, FlightDate departureDate, FlightDate arrivalDate, int capacity) {
      this.departureLocation = departureLocation;
      this.arrivalLocation = arrivalLocation;
      this.flightIDNumber = flightIDNumber;
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
      this.capacity = capacity;
    }
    
    public Airport getDepartureLocation(){
      return departureLocation;
    }
    
    public Airport getArrivalLocation(){
      return arrivalLocation;
    }
    
    public int getID(){
      return flightIDNumber;
    }
    
    public FlightDate getDepartureDate(){
      return departureDate;
    }
    
    public FlightDate getArrivalDate(){
      return arrivalDate;
    }
    
    public int getCapacity(){
      return capacity;
    }
}
