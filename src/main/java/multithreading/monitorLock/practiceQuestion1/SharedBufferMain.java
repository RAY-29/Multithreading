package main.java.multithreading.monitorLock.practiceQuestion1;

public class SharedBufferMain {

    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(3);

        // creating producer thread
        Thread producer = new Thread(() -> {
            try{
                for(int i = 0; i<6; i++){
                    sharedBuffer.produce(i);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // creating consumer thread
        Thread consumer = new Thread(() -> {
            try{
                for(int i = 0; i<6; i++){
                    sharedBuffer.consume();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
