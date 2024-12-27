package main.java.multithreading.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMain {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        SharedResource obj1 = new SharedResource();
        Thread thread1 = new Thread(() -> {
            obj1.producer(lock);
        });

        SharedResource obj2 = new SharedResource();
        Thread thread2 = new Thread(() -> {
            obj2.producer(lock);
        });

        thread2.start();
        thread1.start();

    }
}
