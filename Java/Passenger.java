package lk.iit.level6.concurrent.coursework;

import java.util.Random;

public class Passenger implements Runnable {

    private final TicketingMachine ticketingMachine;
    private final Ticket ticket;


    public Passenger(TicketingMachine ticketingMachine, Ticket ticket) {
        this.ticketingMachine = ticketingMachine;
        this.ticket = ticket;

    }


    @Override
    public void run() {
        //create a random number
        Random random = new Random();

        ticketingMachine.printTicket( this.ticket);
        System.out.println("Passenger " + this.ticket.getPassengerData().getPassengerName() + " got " + ticket);

        try {
            Thread.sleep(random.nextInt(100)+1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}



