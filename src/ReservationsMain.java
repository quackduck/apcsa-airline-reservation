import java.io.*;
import java.util.*;

class ReservationsMain {

    private static ArrayList<Airport> airports = new ArrayList<Airport>();
    private static ArrayList<Flight> flights = new ArrayList<Flight>();

    public static void main(String[] args) {

        load();

        Scanner input = new Scanner(System.in);

        // all the messages above as a string

        String optionsMsg = "\nPlease select an option:\n" +
                "0. Print this menu\n" +
                "1. Add an Airport\n" +
                "2. Add a Flight\n" +
                "3. Make a Reservation\n" +
                "4. Print all Flights\n" +
                "5. Print all Passengers\n" +
                "6. Print all Airports\n" +
                "7. Get flight details by flight number\n" +
                "8. Quit\n";

        System.out.println("Welcome to the Flight Reservation System!\n" + optionsMsg);

        int choice = 0;
        while (choice != 8) {
            save();
            System.out.print("\u001b[31m$  ");
            choice = input.nextInt();
            System.out.print("\u001b[0m");
            switch (choice) {
                case 0:
                    System.out.println(optionsMsg);
                    break;
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
                    System.out.println("Airport added:\n" + airport);
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

                    if (originAirport == null) {
                        System.out.println("Origin airport not found.");
                        break;
                    }

                    Airport destinationAirport = null;
                    for (Airport a : airports) {
                        if (a.getAirport().equals(destination)) {
                            destinationAirport = a;
                        }
                    }

                    if (destinationAirport == null) {
                        System.out.println("Destination airport not found.");
                        break;
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
                    Flight fl = null;
                    for (Flight f : flights) {
                        if (f.getID() == flightNum) {
                            fl = f;
                            // print the flight and passenger

                            f.addPassenger(passenger);
                        }
                    }

                    if (fl == null) {
                        System.out.println("Flight not found.");
                        break;
                    }

                    System.out.println("Passenger added to flight:\n" + fl);
                    break;
                case 4:
                    for (Flight f : flights) {
                        System.out.println(f);
                    }
                    break;
                case 5:
                    for (Flight f : flights) {
                        System.out.println("Flight " + f.getID() + ": " + f.getPassengers());
                    }
                    break;
                case 6:
                    for (Airport a : airports) {
                        System.out.println(a);
                    }
                    break;
                case 7:
                    System.out.print("Please enter the flight number: ");
                    int fnum = input.nextInt();
                    for (Flight f : flights) {
                        if (f.getID() == fnum) {
                            System.out.println(f);
                        }
                    }
                    break;
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
        return new FlightDate(year, month, day, hour, minute);
    }

    private static void save() {
        // use java serialization to save the data to files

        // save the airports
        try {
            FileOutputStream fos = new FileOutputStream("airports.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(airports);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving airports " + e);
        }

        // save the flights
        try {
            FileOutputStream fos = new FileOutputStream("flights.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flights);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving flights " + e);
        }

    }

    private static void load() {
        // use java serialization to load the data from files

        // load the airports
        try {
            FileInputStream fis = new FileInputStream("airports.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            airports = (ArrayList<Airport>) ois.readObject();
            ois.close();
        } catch (java.io.FileNotFoundException e) {

        } catch (Exception e) {
            System.out.println("Error loading airports " + e);
        }

        // load the flights
        try {
            FileInputStream fis = new FileInputStream("flights.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            flights = (ArrayList<Flight>) ois.readObject();
            ois.close();
        } catch (java.io.FileNotFoundException e) {

        } catch (Exception e) {
            System.out.println("Error loading flights " + e);
        }
    }
}