package AdvancedProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private Queue<Integer> data;
    //private boolean empty;
    public static final int MAX_SIZE = 5;

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition full = reentrantLock.newCondition();
    private Condition notFull = reentrantLock.newCondition();

    public Buffer() {
        this.data = new LinkedList<Integer>();
        //this.empty = true;
    }

    public int get() {
        try {
            reentrantLock.lock();
            while (data.size() == 0) {
                //wait for the data to be filled by the producer
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //empty = true;
            full.signalAll();
            //consume the data from the buffer
            //return data;
            return data.poll();
            //reentrantLock.unlock(); //anything that comes after a return statement is unreachable
        } finally {
            reentrantLock.unlock();
        }

    }

    public void put(int data) {
        try {
            reentrantLock.lock();
            while (this.data.size() == MAX_SIZE) {
                //wait for the data to be consumed by the consumer
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //empty = false;
            //produce the data and put it in the buffer
            notFull.signalAll();
            this.data.add(data);
            full.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

//    public boolean isEmpty() {
//        return empty;
//    }
}
