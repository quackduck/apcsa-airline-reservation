// TestPassenger.java
// by Alvin Liu
// 5/19/2022
// Period 3

package AirlineReservation;

import java.util.*;

public class TestPassenger {

   public static void main(String[] args) {
   
      ArrayList<Passenger> passengers = new ArrayList<Passenger>();
      
      Scanner s = new Scanner(System.in);
      
      String selection = "";
      
      while (!selection.equals("Q")) {
         System.out.println("Menu options:");
         System.out.println("A: Print passengers");
         System.out.println("B: Add passenger");
         System.out.println("C: Remove passenger");
         System.out.println("Q: Quit");
         
         System.out.print("Enter A, B, C, or Q: ");
         selection = s.next();
         selection = selection.toUpperCase();
         System.out.println();
         
         if (selection.equals("A")) {
            for (Passenger p: passengers) {
               System.out.println(p);
            }
         } else if (selection.equals("B")) {
            System.out.println("Enter passenger first name: ");
            String firstName = s.next();
            System.out.println("Enter passenger last name: ");
            String lastName = s.next();
            passengers.add(new Passenger(firstName, lastName));
         } else if (selection.equals("C")) {
            System.out.println("Enter first name of passenger to be removed: ");
            String firstName = s.next();
            System.out.println("Enter last name of passenger to be removed: ");
            String lastName = s.next();
            for (int i = 0; i < passengers.size(); i++) {
               if (passengers.get(i).getFirstName().equals(firstName) && passengers.get(i).getLastName().equals(lastName)) {
                  passengers.remove(i);
                  break;
               }
            }
         }
      }
   }

}
