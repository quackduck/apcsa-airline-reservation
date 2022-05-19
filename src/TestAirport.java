/*
 * TestAirport.java
 * by Nikki Benabbas
 * 5/12/2022
 * p3
 */

package AirlineReservation;

import java.io.*;
import java.util.Scanner;

public class TestAirport {
    public static void main(String[] args) throws IOException{
        // create
        Airport a = new Airport("SEATAC", "Seattle", "WA", 8.2);
        File myFile = new File("airport.txt");
        
        // find
        if(myFile.exists()) {
            System.out.println("File found.");
        } else {
            System.out.println("File not found.");
        }
        System.out.println();
        
        // delete
        if(myFile.delete()) {
            System.out.println("File deleted.");    
        } else {
            System.out.println("Failed to delete file.");
        }
        System.out.println();
            
        // write to disc file
        PrintStream writer = new PrintStream(myFile);
        writer.println(a.toString());
        
        // load from disc file
        Scanner fileReader = new Scanner(myFile);
        while(fileReader.hasNext()) {
            System.out.println(fileReader.next());
        }
        
    }
    
}
