package main.java.multithreading.StampedLock.Optimistic;


public class OptimisticMain {

    public static void main(String[] args) {
        OptimisticSharedResource shared = new OptimisticSharedResource();

        Thread th1 = new Thread(shared::producer);

        Thread th2 = new Thread(shared::consumer);

        th1.start();
        th2.start();
    }
}
