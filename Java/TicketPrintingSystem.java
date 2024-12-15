package lk.iit.level6.concurrent.coursework;

import java.math.BigDecimal;

public class TicketPrintingSystem {

        public static void main(String[] args) {

                PassengerInfo passengerInfo = new PassengerInfo("John", "0763205931", "john@gmail.com");
                PassengerInfo passengerInfo1 = new PassengerInfo("Kate", "079272708", "kate@gmail.com");
                PassengerInfo passengerInfo2 = new PassengerInfo("Dave", "0771234567", "dave@gmail.com");
                PassengerInfo passengerInfo3 = new PassengerInfo("Monica", "0715226256", "monica@gmail.com");
                PassengerInfo passengerInfo4 = new PassengerInfo("Joey", "0771234567", "joey@gmail.com");


                TravelInfo travelInfo = new TravelInfo("Colombo", "Panadura");
                TravelInfo travelInfo2 = new TravelInfo("Galle", "Colombo");
                TravelInfo travelInfo3 = new TravelInfo("Matara", "Galle");


                Ticket ticket = new Ticket(1, new BigDecimal(1000), passengerInfo, travelInfo);
                Ticket ticket2 = new Ticket(2, new BigDecimal(2000), passengerInfo1, travelInfo2);
                Ticket ticket3 = new Ticket(3, new BigDecimal(3000), passengerInfo2, travelInfo3);
                Ticket ticket4 = new Ticket(4, new BigDecimal(2000), passengerInfo3, travelInfo3);
                Ticket ticket5 = new Ticket(5, new BigDecimal(3000), passengerInfo4, travelInfo);

                TicketingMachine ticketingMachine = new MachineService(10, 10);


                Passenger passenger = new Passenger(ticketingMachine, ticket);
                Passenger passenger2 = new Passenger(ticketingMachine, ticket2);
                Passenger passenger3 = new Passenger(ticketingMachine, ticket3);
                Passenger passenger4 = new Passenger(ticketingMachine, ticket4);
                Passenger passenger5 = new Passenger(ticketingMachine, ticket5);

                TicketTonerTechnician ticketTonerTechnician = new TicketTonerTechnician("Toner Technician", (TicketingMachineService) ticketingMachine);
                TicketPaperTechnician ticketPaperTechnician = new TicketPaperTechnician("Paper Technician", (TicketingMachineService) ticketingMachine);

                Thread passengerThread = new Thread(passenger, "John");
                Thread passengerThread2 = new Thread(passenger2, "Kate");
                Thread passengerThread3 = new Thread(passenger3, "Dave");
Thread passengerThread4 = new Thread(passenger4, "Monica");
Thread passengerThread5 = new Thread(passenger5, "Joey");

                Thread tonerTechnicianThread = new Thread(ticketTonerTechnician, "Toner Technician");
                Thread paperTechnicianThread = new Thread(ticketPaperTechnician, "Paper Technician");

                tonerTechnicianThread.start();
                paperTechnicianThread.start();

                passengerThread.start();
                passengerThread2.start();
                passengerThread3.start();
                passengerThread4.start();
                passengerThread5.start();



        }
}
