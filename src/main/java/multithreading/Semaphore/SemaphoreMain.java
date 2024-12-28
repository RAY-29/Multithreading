package main.java.multithreading.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        SemaphoreSharedResource semaphoreSharedResource = new SemaphoreSharedResource();

        Thread t1 = new Thread(semaphoreSharedResource::producer, "t1");
        Thread t2 = new Thread(semaphoreSharedResource::producer, "t2");
        Thread t3 = new Thread(semaphoreSharedResource::producer, "t3");
        Thread t4 = new Thread(semaphoreSharedResource::producer, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
