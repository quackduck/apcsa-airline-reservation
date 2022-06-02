// Flight.java
// By Tamir M.
// 3/24/2022
// Period 3

import java.util.*;

public class Flight {
  private Airport departureLocation;
  private Airport arrivalLocation;
  private int flightIDNumber;
  private FlightDate departureDate;
  private FlightDate arrivalDate;
  private int capacity;
  private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

  public Flight(Airport departureLocation, Airport arrivalLocation, int flightIDNumber, FlightDate departureDate,
      FlightDate arrivalDate, int capacity) {
    this.departureLocation = departureLocation;
    this.arrivalLocation = arrivalLocation;
    this.flightIDNumber = flightIDNumber;
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
    this.capacity = capacity;
  }

  public Airport getDepartureLocation() {
    return departureLocation;
  }

  public Airport getArrivalLocation() {
    return arrivalLocation;
  }

  public int getID() {
    return flightIDNumber;
  }

  public FlightDate getDepartureDate() {
    return departureDate;
  }

  public FlightDate getArrivalDate() {
    return arrivalDate;
  }

  public int getCapacity() {
    return capacity;
  }

  public void addPassenger(Passenger passenger) {
    passengers.add(passenger);
  }

  public ArrayList<Passenger> getPassengers() {
    return passengers;
  }

  public String toString() {
    return "Flight Number: " + flightIDNumber
        + "\nDeparture on " + departureDate.getDatePretty() + " from " + departureLocation.toString() + " "
        + "\nto arrival on " + arrivalDate.getDatePretty() + " at " + arrivalLocation.toString()
        + "\n" + "Capacity: " + capacity + "\n" + "Passengers: " + passengers;
  }
}
