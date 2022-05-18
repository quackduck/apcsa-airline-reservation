/*
 * TestFlight.java
 * 5/12/2022
 * by Shriya Sateesh
 * used code by w p osborne
 */
package ARS;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class TestFlight {
   
   // class constant
   private static final String FILENAME = "Flight.dat";
   
   public static void main(String[] args){
      ArrayList<Flight> flights = new ArrayList<Flight>();
      
      Scanner kbReader = new Scanner(System.in);

      // show main menu
      // showMainMenu();
      // get user choice
      char choice;
      do{
         showMainMenu();
         choice = getCharacter("AFDCPSLQ", kbReader);
         System.out.println("You entered " + choice);
         switch (choice) {
            case 'A':
               Flight newFlight = getNewFlight(kbReader);
               if(newFlight != null){
                  flights.add(newFlight);
                  System.out.println("Success adding new flight.");
               }
               break;
            case 'F':
               findFlights(flights, kbReader);
               break;
            case 'D':
               break;
            case 'C':
               break;
            case 'P':
               printFlights(flights);
               break;
            case 'S':
               boolean result = saveToFile(flights);
               if(result){
                  System.out.println("Save is successful.");
               } else {
                  System.out.println("Error saving.");
               }
               break;
            case 'L':
               flights = readFromFile();
               System.out.println("Loaded List of " + flights.size() +
                       " flights.");
               break;
         }
      } while(choice != 'Q');
      
      printFlights(flights);
      
      System.out.println("Thanks for testing");
   }
   
   // Find passengers
   private static void findFlights(ArrayList<Flight> flights, 
           Scanner kb){
      System.out.println();
      System.out.println("Search by\n  A for departure and arrival location\n  B for departure and arrival time\n C for Flight ID Number");
      int action = getCharacter("ABC", kb);
      ArrayList<Flight> found = new ArrayList<Flight>();
      if(action == 'A'){
          // creating new airport object - departure
         System.out.println("Enter departure airport name: ");
         String depName = kb.nextLine();
         System.out.println("Enter departure city name: ");
         String depCity = kb.nextLine();
         System.out.println("Enter departure state name: ");
         String depState = kb.nextLine();
         System.out.println("Enter departure GMT offset: ");
         String depGMT = kb.nextLine();
         Airport dep = new Airport(depName, depCity, depState, depGMT);
         
         // creating new Airport object - arrival
         System.out.println("Enter arrival airport name: ");
         String arrName = kb.nextLine();
         System.out.println("Enter arrival city name: ");
         String arrCity = kb.nextLine();
         System.out.println("Enter arrival state name: ");
         String arrState = kb.nextLine();
         System.out.println("Enter arrival GMT offset: ");
         String arrGMT = kb.nextLine();
         Airport arr = new Airport(arrName, arrCity, arrState, arrGMT);
         
         for(Flight f: flights){
            if(dep.equals(f.getDepartureLocation()) && arr.equals(f.getArrivalLocation())){
               found.add(f);
            }
         }
      } else if (action == 'B'){
         System.out.print("Enter Flight ID number: ");
         int number = kb.nextInt();
         for(Flight f: flights){
            if(number == f.getID()){
               found.add(f);
            }
         }
      } else {
         // creating new FlightDate object - departure
         System.out.println("Enter departure year (4-digits): ");
         int depYear = kb.nextInt();
         System.out.println("Enter departure month (integer): ");
         int depMonth = kb.nextInt();
         System.out.println("Enter departure date (integer): ");
         int depDay = kb.nextInt();
         System.out.println("Enter departure hour (integer from 1-24): ");
         int depHour = kb.nextInt();
         System.out.println("Enter departure minute (integer from (0-59): ");
         int depMinute = kb.nextInt();
         FlightDate departure = new FlightDate(depYear, depMonth, depDay, depHour, depMinute);
         
         // creating new FlightDate object - arrival
         System.out.println("Enter arrival year (4-digits): ");
         int arrYear = kb.nextInt();
         System.out.println("Enter arrival month (integer): ");
         int arrMonth = kb.nextInt();
         System.out.println("Enter arrival date (integer): ");
         int arrDay = kb.nextInt();
         System.out.println("Enter arrival hour (integer from 1-24): ");
         int arrHour = kb.nextInt();
         System.out.println("Enter arrival minute (integer from (0-59): ");
         int arrMinute = kb.nextInt();
         FlightDate arrival = new FlightDate(arrYear, arrMonth, arrDay, arrHour, arrMinute);
                 
         for(Flight f: flights){
            if(departure.equals(f.getDepartureDate()) && arrival.equals(f.getArrivalDate())){
               found.add(f);
            }
         }
      }
          
      System.out.println();
      if(found.size() == 0){
         System.out.println("Passenger not found.");
      } else {
         for(Flight f: found){
            System.out.println(f);
         }
      }
   }
   // Read passengers from a file
   private static ArrayList<Flight> readFromFile(){
      ArrayList<Flight> myList = null;
      try{
         FileInputStream readData = new FileInputStream(FILENAME);
         ObjectInputStream readStream = new ObjectInputStream(readData);
         
         myList = (ArrayList<Flight>) readStream.readObject();
         readStream.close();
      } catch (Exception e){
         e.printStackTrace();
         myList = new ArrayList<Flight>();
      }
      return myList;
   }
   
   // Save passengers to a file
   private static boolean saveToFile(ArrayList<Flight> list){
      File oldFile = new File(FILENAME);
      if(oldFile.exists()){
         int index = FILENAME.indexOf('.');
         String backupName = FILENAME.substring(0, index);
         backupName += "_BAKUP.dat";
         oldFile.renameTo(new File(backupName));
      }
      boolean success = false;
      try {
         FileOutputStream writeData = new FileOutputStream(FILENAME);
         ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

         writeStream.writeObject(list);
         writeStream.flush();
         writeStream.close();
         success = true;
      } catch (IOException e){
         e.printStackTrace();
      }
      return success;
   }
   private static Flight getNewFlight(Scanner kb){
      // creating new airport object - departure
         System.out.println("Enter departure airport name: ");
         String depName = kb.nextLine();
         System.out.println("Enter departure city name: ");
         String depCity = kb.nextLine();
         System.out.println("Enter departure state name: ");
         String depState = kb.nextLine();
         System.out.println("Enter departure GMT offset: ");
         String depGMT = kb.nextLine();
         Airport depAir = new Airport(depName, depCity, depState, depGMT);
         
         // creating new Airport object - arrival
         System.out.println("Enter arrival airport name: ");
         String arrName = kb.nextLine();
         System.out.println("Enter arrival city name: ");
         String arrCity = kb.nextLine();
         System.out.println("Enter arrival state name: ");
         String arrState = kb.nextLine();
         System.out.println("Enter arrival GMT offset: ");
         String arrGMT = kb.nextLine();
         Airport arrAir = new Airport(arrName, arrCity, arrState, arrGMT);
         
         // creating new FlightDate object - departure
         System.out.println("Enter departure year (4-digits): ");
         int depYear = kb.nextInt();
         System.out.println("Enter departure month (integer): ");
         int depMonth = kb.nextInt();
         System.out.println("Enter departure date (integer): ");
         int depDay = kb.nextInt();
         System.out.println("Enter departure hour (integer from 1-24): ");
         int depHour = kb.nextInt();
         System.out.println("Enter departure minute (integer from (0-59): ");
         int depMinute = kb.nextInt();
         FlightDate depTime = new FlightDate(depYear, depMonth, depDay, depHour, depMinute);
         
         // creating new FlightDate object - arrival
         System.out.println("Enter arrival year (4-digits): ");
         int arrYear = kb.nextInt();
         System.out.println("Enter arrival month (integer): ");
         int arrMonth = kb.nextInt();
         System.out.println("Enter arrival date (integer): ");
         int arrDay = kb.nextInt();
         System.out.println("Enter arrival hour (integer from 1-24): ");
         int arrHour = kb.nextInt();
         System.out.println("Enter arrival minute (integer from (0-59): ");
         int arrMinute = kb.nextInt();
         FlightDate arrTime = new FlightDate(arrYear, arrMonth, arrDay, arrHour, arrMinute);
         
         System.out.println("Enter flight ID Number: ");
         int flightID = kb.nextInt();
         System.out.println("Enter flight capacity (number of seats): ");
         int capacity = kb.nextInt();
      
      Flight newFlight = 
              new Flight(depAir, arrAir, flightID, depTime, arrTime, capacity);
      return newFlight;
   }
   
   private static void printFlights(ArrayList<Flight> a){
      System.out.println();
      for(Flight f: a){
         System.out.println(f);
      }
      System.out.println();
   }
   
   private static char getCharacter(String prompt, Scanner kb){
      char choice;
      do{
         System.out.print("Enter ");
         for(int i = 0; i < prompt.length() - 1; i++){
            System.out.print(prompt.charAt(i) + ", ");
         }
         System.out.print(prompt.charAt(prompt.length() - 1) + ": ");
         String str = kb.nextLine();
         if(str.length() > 0){
            str = str.toUpperCase();
            choice = str.charAt(0);
         } else {
            choice = ' ';
         }
      } while(!checkChoice(prompt, choice));
      return choice;
   }
   
   private static boolean checkChoice(String prompt, char choice){
      for(int i = 0; i < prompt.length(); i++){
         if(choice == prompt.charAt(i)){
            return true;
         }
      }
      return false;
   }
   
   private static void showMainMenu(){
      System.out.println();
      System.out.println("Please choose from the following:");
      System.out.println("   A = add new flight");
      System.out.println("   F = find a flight");
      System.out.println("   D = cancel a flight");
      System.out.println("   C = change location or times");
      System.out.println();
      System.out.println("   P = Print all flights");
      System.out.println();
      System.out.println("   S = save flight list to file");
      System.out.println("   L = load flight list from file");
      System.out.println();
      System.out.println("   Q = quit");
      System.out.println();
   }
}

