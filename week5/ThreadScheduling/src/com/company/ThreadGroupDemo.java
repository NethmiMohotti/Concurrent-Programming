package com.company;

public class ThreadGroupDemo {
    public static void main(String[] args) {

        //main thread - thread 1
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        System.out.println("Name of the main thread group: "+Thread.currentThread().getThreadGroup().getName());
        //main thread group 1
        System.out.println("Thread group parent name: "+ Thread.currentThread().getThreadGroup().getParent().getName());

        //Thread group 2
        //this thread group is created in the main thread the main thread, so the thread runs in the main
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup1");
        System.out.println("Thread group name: "+ myThreadGroup.getName());
        System.out.println("Thread group parent: "+ myThreadGroup.getParent().getName());


        //Thread 2
        Thread t1 = new Thread(myThreadGroup, new MyTask(), "Thread #1");
        t1.start();
        //to which the  ThreadGroup this t1 belongs to and why?
        System.out.println("Thread name: "+ t1.getName());
        //because we did not specify a thread group for t1 the Threadgroup of t1 is main
        System.out.println("Thread group name: "+ t1.getThreadGroup().getName());

        //thread group - 3
        //myThreadGroup3 belongs to myThreadGroup1
        ThreadGroup myThreadGroup3 = new ThreadGroup(myThreadGroup, "MyThreadGroup3");
        System.out.println("Thread group name: "+ myThreadGroup3.getName());
        System.out.println("Thread group parent: "+ myThreadGroup3.getParent().getName());

        //Thread 3
        Thread t3 = new Thread(myThreadGroup3, new MyTask(), "Thread #3");
        t3.start();
        System.out.println("Thread name: "+ t3.getName());
        System.out.println("Thread group name: "+ t3.getThreadGroup().getName());

    }
}
