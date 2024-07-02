package ReaderWriterLock;

import java.util.Random;

public class Wife implements Runnable {

    private BankAccount account;

    public Wife(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run(){
        Random random = new Random();
        for(int i=0; i<10; i++){
            double amount = 1000;
            account.deposit(100);

        }

    }

}
