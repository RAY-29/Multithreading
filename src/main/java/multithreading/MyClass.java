package main.java.multithreading;

public class MyClass extends Thread {

    @Override
    public void run() {
        System.out.println("MyClass is running " + Thread.currentThread().getName());
    }
}
