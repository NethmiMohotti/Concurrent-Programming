package ReaderWriterLock;

import java.util.Random;

public class Husband extends Thread {

    private BankAccount account;

    public Husband(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run(){
        Random random = new Random();
        for(int i=0; i<10; i++){
            double amount = 1000;
            account.withdraw(100);
        }
    }
}