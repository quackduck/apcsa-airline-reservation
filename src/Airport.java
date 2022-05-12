public class Airport {

   private String airport;
   private String city;
   private String state;
   
   public Airport(String airport, String city, String state) {
      this.airport = airport;
      this.city = city;
      this.state = state;
   }
   
   public void toString() {
      System.out.println("Airport: " + airport);
      System.out.println("City: " + city);
      System.out.println("State: " + state);
   }

}
