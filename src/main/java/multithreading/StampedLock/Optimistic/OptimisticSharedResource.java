package main.java.multithreading.StampedLock.Optimistic;

import java.util.concurrent.locks.StampedLock;

public class OptimisticSharedResource {

    int a = 10;

    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.tryOptimisticRead(); // this is not putting any lock,
        // so we will not release lock in finally block
        try {
            System.out.println("Optimistic Lock Acquired by " + Thread.currentThread().getName());
            a = 11;
            Thread.sleep(3000);
            if(lock.validate(stamp)) {
                System.out.println("Updated value successfully");
            }
            else{
                System.out.println("Something went wrong, rolling back");
                a = 10;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        System.out.println("Write Lock Acquired by " + Thread.currentThread().getName());
        try {
            System.out.println("Performing work");
            a = 9;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock Released by " + Thread.currentThread().getName());
        }
    }
}
