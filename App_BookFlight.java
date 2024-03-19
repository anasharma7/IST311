import java.util.ArrayList;

public class App_BookFlight {

    private ArrayList<Flight> flights;
    private ArrayList<Booking> bookings;

    public App_BookFlight(ArrayList<Flight> flights, ArrayList<Booking> bookings) {
        this.flights = flights;
        this.bookings = bookings;
    }

    public ArrayList<Itinerary> generateMultipleRoutes(Airport origAirport, Airport destAirport, int date) {
        ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
        ArrayList<Flight> flights1 = getFlights(origAirport, destAirport, date, new ArrayList<Flight>());
        for (Flight flight1 : flights1) {
            Itinerary itinerary1 = new Itinerary(new Booking(new Traveller(), date, origAirport, destAirport), new ArrayList<Flight>());
            itinerary1.getFlights().add(flight1);
            itineraries.add(itinerary1);
            ArrayList<Flight> flights2 = getFlights(flight1.getDestAirport(), destAirport, date, itinerary1.getFlights());
            for (Flight flight2 : flights2) {
                Itinerary itinerary2 = new Itinerary(new Booking(new Traveller(), date, origAirport, destAirport), new ArrayList<Flight>());
                itinerary2.getFlights().addAll(itinerary1.getFlights());
                itinerary2.getFlights().add(flight2);
                itineraries.add(itinerary2);
            }
        }
        return itineraries;
    }

    public Booking bookTicket(Airport origAirport, Airport destAirport, int date) {
        ArrayList<Itinerary> itineraries = generateMultipleRoutes(origAirport, destAirport, date);
        if (itineraries.size() == 0) {
            return null;
        }
        Itinerary bestItinerary = itineraries.get(0);
        for (Itinerary itinerary : itineraries) {
            if (itinerary.getTotalDuration() < bestItinerary.getTotalDuration()) {
                bestItinerary = itinerary;
            }
        }
        double fare = bestItinerary.getTotalDuration() / 60.0 * 100.0;
        Booking booking = bestItinerary.getBooking();
        booking.setFare(fare);
        bookings.add(booking);
        return booking;
    }

    private ArrayList<Flight> getFlights(Airport origAirport, Airport destAirport, int date, ArrayList<Flight> excludeFlights) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (Flight flight : this.flights) {
            if (!excludeFlights.contains(flight) && flight.getOrigAirport().equals(origAirport) && flight.getDestAirport().equals(destAirport) && flight.getFlightDate() == date) {
                flights.add(flight);
            }
        }
        return flights;
    }
}
