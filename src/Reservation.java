/*
 * Reservation.java
 * by Nikki Benabbas
 * 5/17/2022
 * p3
 */


import java.util.ArrayList;

public class Reservation {
   private ArrayList <Passenger> passengers;
   private Flight flight;
   private int reservationNumber;

   public Reservation(ArrayList <Passenger> passengers, Flight flight, int reservationNumber) {
      this.passengers = passengers;
      this.flight = flight;
      this.reservationNumber = reservationNumber;
   }
     
   public ArrayList <Passenger> getPassengersList() {
      return passengers;
   }

   public Flight getFlight() {
      return flight;
   }

   public int getReservationNumber() {
      return reservationNumber;
   }
}
