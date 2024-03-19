import java.util.Date;

public class Booking {
    private Traveller traveller;
    private Date travelDate;
    private Airport origAirport;
    private Airport destAirport;

    public Booking(Traveller traveller, Date travelDate, Airport origAirport, Airport destAirport) {
        this.traveller = traveller;
        this.travelDate = travelDate;
        this.origAirport = origAirport;
        this.destAirport = destAirport;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
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
}
