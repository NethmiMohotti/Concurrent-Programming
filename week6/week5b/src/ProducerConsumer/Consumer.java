package ProducerConsumer;

public class Consumer implements Runnable{
    private final Buffer buffer;
    //private final int numberOfItems;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
        //this.numberOfItems = numberOfItems;
    }

    @Override
    public void run() {
        while(true){
            int item = buffer.get();
            System.out.println("Consumed: " + item);

            if (item == 4){
                break;
            }
        }
    }

}
