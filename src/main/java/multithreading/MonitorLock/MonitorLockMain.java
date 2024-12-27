package main.java.multithreading.MonitorLock;

public class MonitorLockMain {

    public static void main(String[] args) {

        /*
        Thread using Runnable Interface
         */
        MonitorLockExample monitorLockExample = new MonitorLockExample();
        MonitorThread1Runnable monitorThread1Runnable = new MonitorThread1Runnable(monitorLockExample);
        Thread t1 = new Thread(monitorThread1Runnable);

        /*
        Using Method Reference/Lambda
        Thread t = new Thread(() -> {monitorLockExample.task2();})
         */
        Thread t2 = new Thread(monitorLockExample::task2);
        Thread t3 = new Thread(monitorLockExample::task3);

        t1.start();
        t2.start();
        t3.start();

        /*
        Output :
        Thread-2: inside task3
        Thread-0: inside task1
        Thread-1: inside task2 before synchronized
        Thread-0: completed task1
        Thread-1: inside task2 synchronized
         */
    }
}
