import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private String flightID;
    private LocalDate flightDate;
    private Airport origAirport;
    private Airport destAirport;
    private LocalTime startTime;
    private int durationInMinutes;

    public Flight(String flightID, LocalDate flightDate, Airport origAirport, Airport destAirport,
                  LocalTime startTime, int durationInMinutes) {
        this.flightID = flightID;
        this.flightDate = flightDate;
        this.origAirport = origAirport;
        this.destAirport = destAirport;
        this.startTime = startTime;
        this.durationInMinutes = durationInMinutes;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public Airport getOrigAirport() {
        return origAirport;
    }

    public void setOrigAirport(Airport origAirport) {
        this.origAirport = origAirport;
    }

    public Airport getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(Airport destAirport) {
        this.destAirport = destAirport;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
