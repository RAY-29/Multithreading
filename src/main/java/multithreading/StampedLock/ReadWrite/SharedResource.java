package main.java.multithreading.StampedLock.ReadWrite;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    boolean isAvailable = false;

    StampedLock lock = new StampedLock();

    public void producer(){
        long stamp = lock.readLock();
        try{
            System.out.println("Read Lock Acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlockRead(stamp);
            System.out.println("Read Lock Released by " + Thread.currentThread().getName());
        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        try{
            System.out.println("Write Lock Acquired by " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Write Lock Released by " + Thread.currentThread().getName());
        }

    }
}
