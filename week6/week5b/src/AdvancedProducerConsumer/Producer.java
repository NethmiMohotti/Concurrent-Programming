package AdvancedProducerConsumer;

import ProducerConsumer.Buffer;

public class Producer implements Runnable{
    //private final ProducerConsumer.Buffer buffer;
    //private final int numberOfItems;
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
        //this.numberOfItems = numberOfItems;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.put(i);
            System.out.println(Thread.currentThread().getName()+"Produced: " + i);
        }
    }
}
