package main.java.multithreading.MonitorLock.sharedResource;

public class SharedResourceMain {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            try{
                Thread.sleep(10000);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            sharedResource.addItem();
        });
        Thread consumerThread = new Thread(sharedResource::updateItem);

        producerThread.start();
        consumerThread.start();

    }
}
