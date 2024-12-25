package main.java.multithreading;

public class Main {

    public static void main(String[] args) {
        System.out.println("Going Inside Main Method " + Thread.currentThread().getName());
        Multithreading mt = new Multithreading();
        Thread thread = new Thread(mt);
        thread.start();
        System.out.println("Calling Extends Thread Class");
        MyClass myClass = new MyClass();
        myClass.start();
        System.out.println("Finish Main Method " + Thread.currentThread().getName());
    }
}
