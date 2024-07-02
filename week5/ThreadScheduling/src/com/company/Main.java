package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Thread priority: "+ Thread.currentThread().getPriority());
         Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        Thread t1 = new Thread(new MyTask(), "Thread1");
        Thread t2 = new Thread(new MyTask(), "Thread2");

        System.out.println("Current state of t1: " + t1.getState());
        System.out.println("Current state of t2: " + t2.getState());
        System.out.println("Current state of Thread: "+ Thread.currentThread().getState());

        t1.setPriority(Thread.MIN_PRIORITY);
        //all the threads are running in the foreground threads unless it is a foreground thread
        t1.setDaemon(true); //background thread
        t1.start();
//        try{
//            t1.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

        t2.setPriority(Thread.MAX_PRIORITY);
        t2.setDaemon(true); //background thread
        t2.start();

        System.out.println("Current state after starting of t1: " + t1.getState());
        System.out.println("Current state after starting of t2: " + t2.getState());
        //System.out.println("Current  state of Thread after starting: "+ Thread.currentThread().getState());

//        try{
//            Thread.sleep(5000);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//            //System.out.println("Sleep");
//        }

        System.out.println("Current state after sleep of t1: " + t1.getState());
        System.out.println("Current state after sleep of t2: " + t2.getState());
        //System.out.println("Current state of Thread after sleeping: "+ Thread.currentThread().getState());
    }
}
