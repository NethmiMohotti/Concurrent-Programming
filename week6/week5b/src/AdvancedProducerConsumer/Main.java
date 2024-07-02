package AdvancedProducerConsumer;

import ProducerConsumer.Buffer;
import ProducerConsumer.Consumer;
import ProducerConsumer.Producer;

public class Main {

    public static void main(String[] args) {

        // write your code here
        Buffer buffer = new Buffer();

        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);
        Producer producer3 = new Producer(buffer);
        Producer producer4 = new Producer(buffer);

        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        Consumer consumer3 = new Consumer(buffer);
        Consumer consumer4 = new Consumer(buffer);

        Thread producerThread = new Thread(producer1, "Producer1");
        Thread producerThread2 = new Thread(producer2, "Producer2");
        Thread producerThread3 = new Thread(producer3, "Producer3");
        Thread producerThread4 = new Thread(producer4, "Producer4");

        Thread consumerThread = new Thread(consumer1, "Consumer1");
        Thread consumerThread2 = new Thread(consumer2, "Consumer2");
        Thread consumerThread3 = new Thread(consumer3, "Consumer3");
        Thread consumerThread4 = new Thread(consumer4, "Consumer4");

        producerThread.start();
        producerThread2.start();
        producerThread3.start();
        producerThread4.start();

        consumerThread.start();
        consumerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
    }
}

