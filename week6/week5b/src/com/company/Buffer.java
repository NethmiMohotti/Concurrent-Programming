package com.company;

public class Buffer {
    private int data;
    private boolean empty;

    public Buffer(int data, boolean empty) {
        this.data = 0;
        this.empty = true;
    }

    public synchronized int get() {
        while (empty) {
            //wait for the data to be filled by the producer
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return data;
    }

    public synchronized void put(int data) {
        while (!empty) {
            //wait for the data to be consumed by the consumer
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                //System.out.println("InterruptedException caught");
            }
        }
        receive(data);//will not try to acquire lock, but it will act as a reentrant lock
        empty = false;
        this.data = data;
        notifyAll();
    }

    public synchronized void receive(int data) {

    }





}
