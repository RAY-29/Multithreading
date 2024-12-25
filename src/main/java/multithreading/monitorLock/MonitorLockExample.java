package main.java.multithreading.monitorLock;

public class MonitorLockExample {

    public synchronized void task1() {
        try{
            System.out.println(Thread.currentThread().getName() + ": inside task1");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + ": completed task1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void task2() {
        System.out.println(Thread.currentThread().getName() + ": inside task2 before synchronized");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": inside task2 synchronized");
        }
    }

    public void task3() {
        System.out.println(Thread.currentThread().getName() + ": inside task3");
    }
}
