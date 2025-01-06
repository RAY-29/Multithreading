package main.java.multithreading.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread( () -> {
            for(int i=0; i<200; i++){
                resource.increment();
            }
        });

        Thread t2 = new Thread( () -> {
            for(int i=200; i<400; i++){
                resource.increment();
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try{
            assert resource.getIncrement() == 400;
        } catch (AssertionError e) {
            throw new AssertionError("Increment not working as expected");
        }
    }
}
