package ReaderWriterLock;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(Thread.currentThread().getName()); //current thread

        BankAccount account= new BankAccount(12345,1000);
        Husband husband = new Husband(account, "HusbandThread");
        Wife wife = new Wife(account);
        BankManager bankManager = new BankManager(account);

        Thread wifeThread = new Thread(wife, "WifeThread");
        Thread bankManagerThread = new Thread(bankManager, "BankManagerThread");
        Thread husbandThread = new Thread(husband, "HusbandThread");

        husband.start();
        wifeThread.start();
        bankManagerThread.start();


    }
}