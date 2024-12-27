package main.java.multithreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMain {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource obj1 = new SharedResource();

        Thread t1 = new Thread(() -> {
            obj1.producer(lock);
        });

        SharedResource obj2 = new SharedResource();
        Thread t2 = new Thread(() -> {
            obj2.producer(lock);
        });

        SharedResource obj3 = new SharedResource();
        Thread t3 = new Thread(() -> {
            obj3.consumer(lock);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
