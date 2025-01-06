package main.java.multithreading.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {

    AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }

    public int getIncrement(){
        return counter.get();
    }


}
