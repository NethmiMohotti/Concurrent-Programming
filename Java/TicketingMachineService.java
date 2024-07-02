package lk.iit.level6.concurrent.coursework;

public interface TicketingMachineService extends TicketingMachine {
 int PAPER_REFILL_COUNT = 5;
    int TONER_REFILL_COUNT = 4;

 void refillMachineToner();
 void refillMachinePaper();

}
