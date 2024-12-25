package main.java.multithreading.monitorLock;

public class MonitorThread1Runnable implements Runnable {

    MonitorLockExample monitorLockExample;

    public MonitorThread1Runnable(MonitorLockExample monitorLockExample) {
        this.monitorLockExample = monitorLockExample;
    }

    @Override
    public void run() {
        this.monitorLockExample.task1();
    }
}
