package ReaderWriterLock;

public class BankManager implements Runnable{
        private BankAccount account;

        public BankManager(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run(){
            for(int i=0; i<10; i++){
                System.out.println("Manager: "+account.getBalance());
            }

        }
}
