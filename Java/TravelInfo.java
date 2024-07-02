package lk.iit.level6.concurrent.coursework;

public class TravelInfo {

    private String destination;
    private String departureLocation;

    public TravelInfo(String destination, String departureLocation) {
        this.destination = destination;
        this.departureLocation = departureLocation;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }


    @Override
    public String toString() {
        return " TravelInfo { " +
                "\n" +"   Destination = " + destination +
                "\n" +"   Departure Location = " + departureLocation +
                " }"+ "\n";
    }
}
