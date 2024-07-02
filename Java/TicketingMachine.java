package lk.iit.level6.concurrent.coursework;

public interface TicketingMachine {

    /*int FULL_PAPER_TRAY = 250;
    int SHEET_PER_PACK = 50;
    int MIN_TONER_LEVEL = 10;
    int FULL_TONER_LEVEL = 500;*/

    int FULL_PAPER_TRAY = 20;
    int FULL_TONER_LEVEL = 10;


    void printTicket(Ticket ticket);

    int getPaperCheck();
    int getTonerCheck();

}
