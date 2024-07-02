package AdvancedProducerConsumer;

import ProducerConsumer.Buffer;

public class Consumer implements Runnable{
    //private final ProducerConsumer.Buffer buffer;
    //private final int numberOfItems;
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
        //this.numberOfItems = numberOfItems;
    }

    @Override
    public void run() {
        while(true){
            int item = buffer.get();
            System.out.println(Thread.currentThread().getName()+ "Consumed: " + item);

//            if (item == 4){
//                break;
//            }
        }
    }

}
