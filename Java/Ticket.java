package lk.iit.level6.concurrent.coursework;

import java.math.BigDecimal;

public class Ticket {

    private int ticketId;
    private BigDecimal ticketPrice;
    private PassengerInfo passengerData;
    private TravelInfo locationDetails;

    public Ticket(int ticketId, BigDecimal ticketPrice, PassengerInfo passengerData, TravelInfo travelInfo) {
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.passengerData = passengerData;
        this.locationDetails = travelInfo;
    }


    public int getTicketId() {
        return ticketId;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public PassengerInfo getPassengerData() {
        return passengerData;
    }

    public TravelInfo getLocationDetails() {
        return locationDetails;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "\n TicketId=" + ticketId +
                "\n TicketPrice=" + ticketPrice +
                "\n PassengerInfo=" + passengerData +
                "\n TravelInfo=" + locationDetails + '}';
    }


}


