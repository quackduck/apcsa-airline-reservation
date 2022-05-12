public class Airport {

   private String airport;
   private String city;
   private String state;
   
   public Airport(String airport, String city, String state) {
      this.airport = airport;
      this.city = city;
      this.state = state;
   }
   
   public String toString() {
      String str = "Airport: " + airport + "/nCity: " + city + "/nState: " + state; 
      return str;
   }

}
