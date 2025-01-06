package main.java.multithreading.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SemaphoreSharedResource {

    boolean isAvailable = false;

    Semaphore semaphore = new Semaphore(2);
    // permits : number of threads that can acquire thread at a time

    public void producer(){
        try{
            semaphore.acquire();
            System.out.println("Producer Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Producer Lock released by : " + Thread.currentThread().getName());
            semaphore.release();
        }
    }
}
