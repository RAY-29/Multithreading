package main.java.multithreading.ConditionLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSharedResource {

    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer(){
        try{
            lock.lock();
            System.out.println("Produce Lock acquired by : " + Thread.currentThread().getName());
            while(isAvailable){
                // already available, thread needs to wait to consume
                System.out.println("Produce thread is waiting : " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Produce lock release by : " + Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void consumer(){
        try{
//            Thread.sleep(2000);
            lock.lock();
            System.out.println("Consume lock acquired by : " + Thread.currentThread().getName());
            while(!isAvailable){
                System.out.println("Consumer thread is waiting : "+ Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Consumer lock release by : " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
