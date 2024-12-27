package main.java.multithreading.MonitorLock.sharedResource;

public class SharedResource {

    private boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
        System.out.println("Producer Thread Calling Notify All Method");
        notifyAll();
    }

    public synchronized void updateItem() {
        /*
        'while' is used instead of 'if' block because of https://en.wikipedia.org/wiki/Spurious_wakeup
         */
        System.out.println("Consumer Thread Inside Consume Item Method");
        while(!isItemPresent){
            try {
                System.out.println("Consumer Thread is waiting");
                wait(); // release monitor lock
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        isItemPresent = false;
        System.out.println("Consumer Thread Consumed Method");

    }
}
