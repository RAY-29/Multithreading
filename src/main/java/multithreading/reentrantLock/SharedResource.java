package main.java.multithreading.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = false;

    public void producer(ReentrantLock rLock) {
        try{
            rLock.lock();
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Lock released by " + Thread.currentThread().getName());
            rLock.unlock();
        }
    }
}
