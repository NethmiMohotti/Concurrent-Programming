package ProducerConsumer;

public class Producer implements Runnable{
    private final Buffer buffer;
    //private final int numberOfItems;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
        //this.numberOfItems = numberOfItems;
    }

    @Override
       public void run() {
            for (int i = 0; i < 100; i++) {
                buffer.put(i);
                System.out.println("Produced: " + i);
            }
        }
}
