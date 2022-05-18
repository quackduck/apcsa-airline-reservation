/*
 * TestPassenger.java
 * by w p osborne
 * 4/5/2022
 */
package ARS;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class TestPassenger {
   
   // class constant
   private static final String FILENAME = "Passenger.dat";
   
   public static void main(String[] args){
      ArrayList<Passenger> passengers = new ArrayList<Passenger>();
      
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
               Passenger newPassenger = getNewPassenger(kbReader);
               if(newPassenger != null){
                  passengers.add(newPassenger);
                  System.out.println("Success adding new passenger.");
               }
               break;
            case 'F':
               findPassenger(passengers, kbReader);
               break;
            case 'D':
               break;
            case 'C':
               break;
            case 'P':
               printPassengers(passengers);
               break;
            case 'S':
               boolean result = saveToFile(passengers);
               if(result){
                  System.out.println("Save is successful.");
               } else {
                  System.out.println("Error saving.");
               }
               break;
            case 'L':
               passengers = readFromFile();
               System.out.println("Loaded List of " + passengers.size() +
                       " passengers.");
               break;
         }
      } while(choice != 'Q');
      
      printPassengers(passengers);
      
      System.out.println("Thanks for testing");
   }
   
   // Find passengers
   private static void findPassenger(ArrayList<Passenger> passengers, 
           Scanner kb){
      System.out.println();
      System.out.println("Search by\n  A for last name\n  B for ID number");
      int action = getCharacter("AB", kb);
      ArrayList<Passenger> found = new ArrayList<Passenger>();
      if(action == 'A'){
         System.out.print("Enter last name: ");
         String lastName = kb.nextLine();
         for(Passenger p: passengers){
            if(lastName.equalsIgnoreCase(p.getLastName())){
               found.add(p);
            }
         }
      } else {
         System.out.print("Enter passenger ID number: ");
         int number = kb.nextInt();
         for(Passenger p: passengers){
            if(number == p.getID()){
               found.add(p);
            }
         }
      }
      System.out.println();
      if(found.size() == 0){
         System.out.println("Passenger not found.");
      } else {
         for(Passenger p: found){
            System.out.println(p);
         }
      }
   }
   // Read passengers from a file
   private static ArrayList<Passenger> readFromFile(){
      ArrayList<Passenger> myList = null;
      try{
         FileInputStream readData = new FileInputStream(FILENAME);
         ObjectInputStream readStream = new ObjectInputStream(readData);
         
         myList = (ArrayList<Passenger>) readStream.readObject();
         readStream.close();
      } catch (Exception e){
         e.printStackTrace();
         myList = new ArrayList<Passenger>();
      }
      return myList;
   }
   
   // Save passengers to a file
   private static boolean saveToFile(ArrayList<Passenger> list){
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
   private static Passenger getNewPassenger(Scanner kb){
      String lastName;
      String firstName;
      boolean joinMileageClub;
      
      System.out.print("Enter last name: ");
      lastName = kb.nextLine();
      System.out.print("Enter first name: ");
      firstName = kb.nextLine();
      System.out.print("Join mileage club? ");
      char choice = getCharacter("YN", kb);
      if(choice == 'Y'){
         joinMileageClub = true;
      } else {
         joinMileageClub = false;
      }
      
      Passenger newPassenger = 
              new Passenger(lastName, firstName, joinMileageClub);
      return newPassenger;
   }
   
   private static void printPassengers(ArrayList<Passenger> a){
      System.out.println();
      for(Passenger p: a){
         System.out.println(p);
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
      System.out.println("   A = add new passenger");
      System.out.println("   F = find a passenger");
      System.out.println("   D = delete a passenger");
      System.out.println("   C = change passenger affinity status");
      System.out.println();
      System.out.println("   P = Print all passengers");
      System.out.println();
      System.out.println("   S = save passenger list to file");
      System.out.println("   L = load passenger list from file");
      System.out.println();
      System.out.println("   Q = quit");
      System.out.println();
   }
}
