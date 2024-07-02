package ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer {
    private int data;
    private boolean empty;

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition full = reentrantLock.newCondition();
    private Condition notFull = reentrantLock.newCondition();

    public Buffer() {
        this.data = 0;
        this.empty = true;
    }

    public int get() {
        try {
            reentrantLock.lock();
            while (empty) {
                //wait for the data to be filled by the producer
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = true;
            notFull.signalAll();
            //consume the data from the buffer
            return data;
            //reentrantLock.unlock(); //anything that comes after a return statement is unreachable
        } finally {
            reentrantLock.unlock();
        }

        /*while (empty) {
            //wait for the data to be filled by the producer
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notFull.signalAll();
        //consume the data from the buffer
        reentrantLock.unlock();
        return data;
        //reentrantLock.unlock(); //anything that comes after a return statement is unreachable
         */

    }

    public void put(int data) {
        try {
            reentrantLock.lock();
            while (!empty) {
                //wait for the data to be consumed by the consumer
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = false;
            //produce the data and put it in the buffer
            this.data = data;
            full.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean isEmpty() {
        return empty;
    }
}
