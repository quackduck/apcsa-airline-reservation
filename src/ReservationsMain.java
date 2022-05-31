import java.util.*;

class ReservationsMain {
    public static void main(String[] args) {
        // on startup
        ArrayList<Airport> airports = new ArrayList<Airport>();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        
        // running from a text menu

        // text based menu
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to the Flight Reservation System!");
        System.out.println("Please select an option:");
        System.out.println("1. Add an Airport");
        System.out.println("2. Add a Flight");
        System.out.println("3. Add a Passenger");
        System.out.println("4. Print all Flights");
        System.out.println("5. Print all Passengers");
        System.out.println("6. Print all Airports");
        System.out.println("7. Print passengers by flight number");
        System.out.println("8. Quit");

        int choice = input.nextInt();
        while (choice != 8) {
            switch (choice) {
                case 1:
                    System.out.print("Please enter the name of the airport: ");
                    String airportName = input.next();
                    System.out.print("Please enter the city of the airport: ");
                    String city = input.next();
                    System.out.print("Please enter the state: ");
                    String state = input.next();

                    System.out.print("Please enter the gmt offset: ");
                    double gmtOffset = input.nextDouble();

                    Airport airport = new Airport(airportName, city, state, gmtOffset);
                    airports.add(airport);
                    System.out.print("Airport added!");
                    break;
                case 2:
                    System.out.print("Please enter the flight number: ");
                    int flightNumber = input.nextInt();
                    System.out.print("Please enter the origin airport: ");
                    String origin = input.next();
                    System.out.print("Please enter the destination airport: ");
                    String destination = input.next();
                    System.out.print("Please enter the departure date: ");
                    String departureDate = input.next();
                    System.out.print("Please enter the arrival date: ");
                    String arrivalDate = input.next();

                    // get a capacity
                    System.out.print("Please enter the capacity of the flight: ");
                    int capacity = input.nextInt();

                    // find the airport by name
                    Airport originAirport = null;
                    for (Airport airport : airports) {
                        if (airport.getName().equals(origin)) {
                            originAirport = airport;
                        }
                    }

                    Airport destinationAirport = null;
                    for (Airport airport : airports) {
                        if (airport.getName().equals(destination)) {
                            destinationAirport = airport;
                        }
                    }

                    Flight flight = new Flight(originAirport, destinationAirport, flightNumber, departureDate, arrivalDate, capacity);
                    flights.add(flight);
                    System.out.println("Flight added!");
                    break;
                case 3:
                    System.out.print("Please enter the first name: ");
                    String firstName = input.next();
                    System.out.print("Please enter the last name: ");
                    String lastName = input.next();
                    Passenger passenger = new Passenger(firstName, lastName);
                    passengers.add(passenger);
                    System.out.println("Passenger added!");
                    break;
                case 4:
                    for (Flight flight : flights) {
                        System.out.println(flight);
                    }
                    break;
                case 5:
                    for (Passenger passenger : passengers) {
                        System.out.println(passenger);
                    }
                    break;
                case 6:
                    for (Airport airport : airports) {
                        System.out.println(airport);
                    }
                    break;
                case 7:
                    System.out.println("Please enter the flight number:");
                    int flightNum = input.nextInt();
                    for (Flight f : flights) {
                        if (f.getID() == flightNum) {
                            System.out.println(f);
                        }
                    }
                    break;
            }
        }

    }
}
