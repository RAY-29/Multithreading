package main.java.multithreading.monitorLock.practiceQuestion1;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private final Queue<Integer> sharedBuffer;

    private final int maxSize;

    private int counter;

    public SharedBuffer(int maxSize) {
        sharedBuffer = new LinkedList<>();
        this.counter = 0;
        this.maxSize = maxSize;
    }

    public synchronized void produce(int item) throws Exception {
        while(counter == maxSize) {
            System.out.println("Buffer is full, Producer is waiting for Consumer");
            wait();
        }
        sharedBuffer.add(item);
        counter++;
        System.out.println("Produced : " + item);
        notify();
    }

    public synchronized int consume() throws Exception {
        while(counter==0){
            System.out.println("Buffer is Empty, Consumer is waiting for Producer");
            wait();
        }
        int item = sharedBuffer.poll();
        counter--;
        System.out.println("Consumed : " + item);
        notify();
        return item;
    }
}
