public class Main {
    public static void main(String[] args) {
        // Create an instance of the App_BookFlight class
        App_BookFlight app = new App_BookFlight();

        // Generate multiple routes
        ArrayList<Itinerary> routes = app.generateMultipleRoutes("JFK", "LAX", 20230504);

        // Book a ticket using the first route
        app.bookTicket(routes.get(0));
    }
}
