public class Airport {
    private String airportID;
    private String airportName;

    public Airport(String airportID, String airportName) {
        this.airportID = airportID;
        this.airportName = airportName;
    }

    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
