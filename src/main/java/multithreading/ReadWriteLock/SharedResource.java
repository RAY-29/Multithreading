package main.java.multithreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    boolean isAvailable = true;

    public void producer(ReadWriteLock readWriteLock){
        try {
            readWriteLock.readLock().lock();
            System.out.println("Read Lock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Read Lock released by : " + Thread.currentThread().getName());
            readWriteLock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock readWriteLock){
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Write Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Write Lock released by : " + Thread.currentThread().getName());
            readWriteLock.writeLock().unlock();
        }
    }
}
