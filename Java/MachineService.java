package lk.iit.level6.concurrent.coursework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MachineService implements TicketingMachineService {

    private int paperCheck;
    private int tonerCheck;

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition tonerAvailable = reentrantLock.newCondition();
    private final Condition paperAvailable = reentrantLock.newCondition();
    private final Condition noResource = reentrantLock.newCondition();


    public MachineService(int paperCheck, int tonerCheck){
        this.paperCheck = paperCheck;
        this.tonerCheck = tonerCheck;
    }


     private void printTicket() {
        tonerCheck -= 1;
        paperCheck -= 1;
    }

    @Override
    public void refillMachineToner() {
        reentrantLock.lock();
        try {
            while (tonerCheck + TONER_REFILL_COUNT > TicketingMachine.FULL_TONER_LEVEL) {
                System.out.println("Ticket machine have toner cartridge to print ticket");
                tonerAvailable.await();
            }
            tonerCheck += TONER_REFILL_COUNT;
            System.out.println(Thread.currentThread().getName() + " filled the Toner cartridge in the Ticket machine");
            noResource.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


    }

    @Override
    public void refillMachinePaper() {
        try {
            reentrantLock.lock();

            while ((paperCheck + PAPER_REFILL_COUNT) > TicketingMachine.FULL_PAPER_TRAY) {
                UtilityFile.writeToFile("Ticket machine have enough paper");
                //System.out.println("Ticket machine have enough paper");
                paperAvailable.await();
            }
            paperCheck += PAPER_REFILL_COUNT;
            UtilityFile.writeToFile(Thread.currentThread().getName() + " filled paper to the ticket machine");
            //System.out.println(Thread.currentThread().getName() + " filled paper to the ticket machine");
            noResource.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }


    @Override
    public void printTicket(Ticket ticket) {
        try {
            reentrantLock.lock();
            while (!(paperCheck > 0 && tonerCheck >= 1)) {
                UtilityFile.writeToFile("Ticket machine doesn't have enough resources"+ "\n");
                //System.out.println("Ticket machine doesn't have enough resources"+ "\n");
                noResource.await();
            }
            UtilityFile.writeToFile("Printing the ticket... \n" + ticket.toString());
            //System.out.println("Printing the ticket... \n" + ticket.toString());
            paperCheck -= 1;
            tonerCheck -= 1;
            UtilityFile.writeToFile("Ticket printed by " + Thread.currentThread().getName() + "\n" +
                    " Ticket : " + ticket.toString() + " for " + ticket.getPassengerData().getPassengerName());
            /*System.out.println("Ticket printed by " + Thread.currentThread().getName() + "\n" +
                     " Ticket : " + ticket.toString() + " for " + ticket.getPassengerData().getPassengerName());*/
            System.out.println();
            paperAvailable.signalAll();
            tonerAvailable.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }


    @Override
    public int getPaperCheck() {
        return paperCheck;
    }

    @Override
    public int getTonerCheck() {
        return tonerCheck;
    }



}
