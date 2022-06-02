import java.util.*;

class ReservationsMain {
    public static void main(String[] args) {
        // on startup
        ArrayList<Airport> airports = new ArrayList<Airport>();
        ArrayList<Flight> flights = new ArrayList<Flight>();

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Flight Reservation System!\n");
        System.out.println("Please select an option:");
        System.out.println("1. Add an Airport");
        System.out.println("2. Add a Flight");
        System.out.println("3. Make a Reservation");
        System.out.println("4. Print all Flights");
        System.out.println("5. Print all Passengers");
        System.out.println("6. Print all Airports");
        System.out.println("7. Print passengers by flight number");
        System.out.println("8. Quit");

        int choice = 0;
        while (choice != 8) {
            System.out.print(">  ");
            choice = input.nextInt();
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
                    System.out.println("Airport added!");
                    break;
                case 2:
                    System.out.print("Please enter the flight number: ");
                    int flightNumber = input.nextInt();
                    System.out.print("Please enter the origin airport: ");
                    String origin = input.next();
                    System.out.print("Please enter the destination airport: ");
                    String destination = input.next();

                    // get a capacity
                    System.out.print("Please enter the capacity of the flight: ");
                    int capacity = input.nextInt();

                    // find the airport by name
                    Airport originAirport = null;
                    for (Airport a : airports) {
                        if (a.getAirport().equals(origin)) {
                            originAirport = a;
                        }
                    }

                    Airport destinationAirport = null;
                    for (Airport a : airports) {
                        if (a.getAirport().equals(destination)) {
                            destinationAirport = a;
                        }
                    }

                    Flight flight = new Flight(originAirport, destinationAirport, flightNumber,
                            getDate("departure", input), getDate("arrival", input),
                            capacity);
                    flights.add(flight);
                    System.out.println("Flight added!");
                    break;
                case 3:
                    System.out.print("Please enter the first name: ");
                    String firstName = input.next();
                    System.out.print("Please enter the last name: ");
                    String lastName = input.next();
                    Passenger passenger = new Passenger(firstName, lastName);

                    // get the flight number
                    System.out.print("Please enter the flight number: ");
                    int flightNum = input.nextInt();

                    // TODO. add this passenger to the flight
                    for (Flight f : flights) {
                        if (f.getID() == flightNum) {
                            f.addPassenger(passenger);
                        }
                    }

                    System.out.println("Passenger added!");
                    break;
                case 4:
                    for (Flight f : flights) {
                        System.out.println(f);
                    }
                    break;
                case 5:
                    // for (Flight f : flights) {
                    // System.out.println();
                    // }
                    // for (Passenger p : passengers) {
                    // System.out.println(p);
                    // }
                    // break;
                case 6:
                    for (Airport a : airports) {
                        System.out.println(a);
                    }
                    break;
                // case 7:
                // System.out.println("Please enter the flight number:");
                // int flightNum = input.nextInt();
                // for (Reservation f : res) {
                // if (f.getID() == flightNum) {
                // System.out.println(f);
                // }
                // }
                // break;
            }
        }
    }

    private static FlightDate getDate(String kind, Scanner input) {
        System.out.print("Please enter the " + kind + " date month (eg. 6): ");
        int month = input.nextInt();
        System.out.print("Please enter the " + kind + " date day (eg. 1): ");
        int day = input.nextInt();
        System.out.print("Please enter the " + kind + " date year (eg. 2020): ");
        int year = input.nextInt();
        System.out.print("Please enter the " + kind + " time hour (eg. 12): ");
        int hour = input.nextInt();
        System.out.print("Please enter the " + kind + " time minute (eg. 30): ");
        int minute = input.nextInt();
        return new FlightDate(month, day, year, hour, minute);
    }
}