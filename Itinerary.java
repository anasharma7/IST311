import java.util.ArrayList;

public class Itinerary {
    private Booking booking;
    private ArrayList<Flight> flights;

    public Itinerary(Booking booking, ArrayList<Flight> flights) {
        this.booking = booking;
        this.flights = flights;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public double getTotalFare() {
        double totalFare = 0;
        for (Flight flight : flights) {
            totalFare += (flight.getDuration() / 60.0) * 100.0;
        }
        return totalFare;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Itinerary:\n");
        sb.append("Booking: ").append(booking).append("\n");
        sb.append("Flights:\n");
        for (Flight flight : flights) {
            sb.append(flight).append("\n");
        }
        sb.append("Total fare: $").append(String.format("%.2f", getTotalFare()));
        return sb.toString();
    }
}
