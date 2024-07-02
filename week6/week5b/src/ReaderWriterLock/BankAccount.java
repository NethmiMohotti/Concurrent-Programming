package ReaderWriterLock;

import java.util.concurrent.locks.ReentrantLock;

//monitor class/passive class
public class BankAccount {
    private int AccountNo;
    private double balance;

    private ReentrantLock lock = new ReentrantLock(true);

    public BankAccount(int accountNo, double balance) {
        AccountNo = accountNo;
        this.balance = balance;
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public double getBalance() {
        
        return balance;
    }

    public void deposit(double amount) {
        lock.lock();
        try{
            balance += amount;
            System.out.println(Thread.currentThread().getName()+" "+getBalance());
        }finally {
            lock.unlock();
        }

    }

    public void withdraw(double amount) {
        lock.lock();
        try{
            if(balance<amount){
                throw new IllegalArgumentException("Insufficient fund");
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+" "+getBalance());
        }finally {
            lock.unlock();
        }
    }

}
