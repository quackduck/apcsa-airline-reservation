/*
 * FlightDate.java
 * by w p osborne
 * 4/4/2022
 */


// Following imports could be replaced with
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class FlightDate {
   // instance variables
   private LocalDateTime dateTime;
   
   // class constant
   private static final Month[] MONTH = {Month.JANUARY, Month.FEBRUARY, Month.MARCH,
      Month.APRIL, Month.MAY, Month.JUNE, Month.JULY, Month.AUGUST, 
      Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER };
   private static final String[] MONTH_NAME = {"January", "February", "March",
      "April", "May", "June", "July", "August", "September", "October",
      "November", "December" };
   private static final String[] DAYS_OF_WEEK = {"Monday", "Tuesday", "Wednesday",
      "Thursday", "Friday", "Saturday", "Sunday" };
   
   // Constructors
   public FlightDate(int year, int month, int day, int hour, int minute){
      
      dateTime =  LocalDateTime.of(year, MONTH[month - 1], day, 
                  hour, minute);
   }
   
   // Accessors
   public int getYear(){
      return dateTime.getYear();
   }
   public int getMonthAsInt(){
      return dateTime.getMonthValue();
   }
   public String getMonthAsString(){
      return MONTH_NAME[dateTime.getMonthValue() - 1];
   }
   public int getDay(){
      return dateTime.getDayOfMonth();
   }
   
   // Monday is 1, Sunday is 7
   public int getDayOfWeekAsInt(){
      return dateTime.getDayOfWeek().getValue();
   }
   // remember names of days starts at index 0
   public String getDayOfWeekAsString(){
      return DAYS_OF_WEEK[getDayOfWeekAsInt() - 1];
   }

   public int getHour24(){
      return dateTime.getHour();
   }
   public boolean getHourAM(){
      if(dateTime.getHour() < 12){
         return true;
      }
      return false;
   }
   
   public int getMinutes(){
      return dateTime.getMinute();
   }
   public String getAMPM(){
      if(dateTime.getHour() < 12){
         return "AM";
      }
      return "PM";
   }
   public int getHour12(){
      int hour = dateTime.getHour();
      if(hour > 12){
         return hour - 12;
      }
      return hour;
   }
   
   public String getDatePretty(){
      String str = getMonthAsString();
      str += " " + getDay();
      str += ", " + getYear();
      return str;
   }
   public String getTimePretty(){
      String str = "";
      if(getHour12() < 10){
         str += "0";
      }
      str += Integer.toString(getHour12()) + ":";
      if(getMinutes() < 10){
         str += "0";
      }
      return str + getMinutes() + " " + getAMPM();
   }
   
   public LocalDateTime getLocalDateTimeObject(){
      return dateTime;
   }
   
   // Compare to another FlightDate object.
   public int getDifferenceHours(LocalDateTime otherDT){
      return (int)getTime(otherDT)[0];
   }
   public int getDifferenceMinutes(LocalDateTime otherDT){
      return (int)getTime(otherDT)[1];
   }
   
   public String getTimeDifferencePretty(LocalDateTime otherDT){
      // Approach derived from stackoverflow
      long[] results = getTime(otherDT);
      return "Hours: " + results[0] + ", Minutes: " + results[1];
   }
   
   private long[] getTime(LocalDateTime end) {
      long seconds = Duration.between(dateTime, end).getSeconds();
      long hours = seconds / (60 * 60); // seconds / hour
      long minutes = ((seconds % (60 * 60)) / 60);

      return new long[]{hours, minutes};
   }
   
   // Formats are constants called from the DateTimeFormatter class. To use
   // in client import java.time.DateTimeFormatter then call as follows:
   // DateTimeFormatter.ISO_LOCAL_DATE_TIME
   // Many other formats are available
   public String formattedDateTime(DateTimeFormatter format){
      return dateTime.format(format);
   }
   
   // toString
   public String toString(){
      return dateTime.toString();
   }
}
