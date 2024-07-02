package lk.iit.level6.concurrent.coursework;

import java.util.Random;

public class TicketPaperTechnician implements Runnable{

    public static final int REPEAT_COUNT = 3;
    private final TicketingMachineService machine;
    private final String name;

    public TicketPaperTechnician(String name, TicketingMachineService machine) {
        this.name = name;
        this.machine = machine;
    }

    @Override
    public void run() {

        Random random = new Random();

        for (int i = 0; i < REPEAT_COUNT; i++) {

            if(machine.getPaperCheck() < 2){
                machine.refillMachinePaper();
            }

            try {
                Thread.sleep(random.nextInt(100)+1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }



    }

    public String getName() {
        return name;
    }
}
