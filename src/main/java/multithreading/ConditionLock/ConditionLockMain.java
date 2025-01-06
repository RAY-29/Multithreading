package main.java.multithreading.ConditionLock;

public class ConditionLockMain {

    public static void main(String[] args) {
        ConditionSharedResource conditionSharedResource  = new ConditionSharedResource();

        Thread t1 = new Thread( () ->{
            for(int i=0; i<2; i++){
                conditionSharedResource.producer();
            }
        });

        Thread t2 = new Thread( () -> {
            for(int i =0; i<2; i++){
                conditionSharedResource.consumer();
            }
        });


        t1.start();
        t2.start();
    }
}
