public class Airport {

   private String airport;
   private String city;
   private String state;
   private double GMTOffset;
   
   public Airport(String airport, String city, String state, double GMTOffset) {
      this.airport = airport;
      this.city = city;
      this.state = state;
      this.GMTOffset = GMTOffset;
   }
   
   public String toString() {
      String str = "Airport: " + airport + "\nCity: " + city + "\nState: " + state + "\nGMT Offset: " + GMTOffset; 
      return str;
   }

}
