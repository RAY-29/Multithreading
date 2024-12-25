package main.java.multithreading;

public class Multithreading implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
