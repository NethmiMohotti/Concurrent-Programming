package com.company;

public class ThreadGroupDemo2 {

    public static void main(String[] args) {
        ThreadGroup[] threadGroup = new ThreadGroup[6];
        Thread[] threadArray = new Thread[7];
        threadArray[0] = Thread.currentThread();
        threadGroup[0]=threadArray[0].getThreadGroup();

        threadGroup[1] = new ThreadGroup("MyThreadGroup A");
        threadGroup[2] = new ThreadGroup("MyThreadGroup B");
        threadGroup[3] = new ThreadGroup("MyThreadGroup C");
        threadGroup[4] = new ThreadGroup("MyThreadGroup D");
        threadGroup[5] = new ThreadGroup("MyThreadGroup E");

        threadArray[1] = new Thread(threadGroup[1],new MyTask(),"Thread 2");
        threadArray[2] = new Thread(threadGroup[2],new MyTask(),"Thread 3");
        threadArray[3] = new Thread(threadGroup[3],new MyTask(),"Thread 4");
        threadArray[4] = new Thread(threadGroup[4],new MyTask(),"Thread 5");
        threadArray[5] = new Thread(threadGroup[5],new MyTask(),"Thread 6");
        threadArray[6] = new Thread(threadGroup[5],new MyTask(),"Thread 7");


        System.out.println("Active count of the thread before start: "+Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("Active count of the groups before start: "+Thread.currentThread().getThreadGroup().activeGroupCount());


//        for(Thread t:threadArray){
//            t.start();
//        }
        for (int i = 1; i < threadArray.length; i++) {
            if (i%2==0)
                threadArray[i].setPriority(Thread.MAX_PRIORITY);
            threadArray[i].start();
            System.out.println(threadArray[i].getThreadGroup().getName()+ ""+threadArray[i].getName()+ " priority: "+threadArray[i].getPriority());
        }
        threadGroup[2].setMaxPriority(Thread.NORM_PRIORITY);

        for (int i = 1; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName()+ " priority: "+threadArray[i].getPriority());
        }


        System.out.println("Active count of the thread after start: "+Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("Active count of the group after start: "+Thread.currentThread().getThreadGroup().activeGroupCount());

        Thread[] threadArray1 = new Thread[Thread.currentThread().getThreadGroup().activeGroupCount()*2];
        Thread.currentThread().getThreadGroup().enumerate(threadArray1);

        ThreadGroup[] threadGroup2 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()*2];
        Thread.currentThread().getThreadGroup().enumerate(threadGroup2);

        for (Thread tread1:threadArray1) {
            if (tread1!=null)
            System.out.println("Enumerated thread name: "+tread1.getName());
        }

        for (ThreadGroup threadGroup1:threadGroup2) {
            if (threadGroup1!=null)
            System.out.println("Enumerated thread group name: "+threadGroup1.getName());
        }
    }
}
