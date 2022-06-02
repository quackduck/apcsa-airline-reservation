/*
 * TestFlightDate.java
 * 5/10/2022
 * by Shriya Sateesh
 * Period 3
 */

import java.time.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class TestFlightDate {
  public static void main(String[] args) {

    // Part A
    ArrayList<FlightDate> list = new ArrayList<FlightDate>();
    list.add(new FlightDate(2004, 12, 7, 17, 10));
    list.add(new FlightDate(2006, 8, 4, 9, 30));

    // Part B
    System.out.println("Printed Objects: ");
    for (FlightDate a : list) {
      System.out.println(a.toString());
    }

    // Part C
    System.out.println();
    System.out.println("Formatted Date Time: ");
    for (FlightDate a : list) {
      System.out.println(a.formattedDateTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    // Part D
    System.out.println();
    System.out.println("Pretty Format: ");
    for (FlightDate a : list) {
      System.out.println("Date: " + a.getDatePretty());
      System.out.println("Time: " + a.getTimePretty());
    }

    // Part E
    System.out.println();
    LocalDateTime fd1DT = list.get(0).getLocalDateTimeObject();
    LocalDateTime fd2DT = list.get(1).getLocalDateTimeObject();
    System.out.println("Hours difference: " + list.get(0).getDifferenceHours(fd2DT));
    System.out.println("Minutes difference: " + list.get(0).getDifferenceMinutes(fd2DT));
    System.out.println("Total time difference -> " + list.get(0).getTimeDifferencePretty(fd2DT));

    // Part F
    System.out.println();
    System.out.println("Day of the week as an int: " + list.get(0).getDayOfWeekAsInt());
    System.out.println("Day of the week as a String: " + list.get(0).getDayOfWeekAsString());

  }
}
