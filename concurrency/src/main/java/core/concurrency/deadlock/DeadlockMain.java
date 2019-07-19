package core.concurrency.deadlock;

public class DeadlockMain {

    public static void main(String[] args) throws InterruptedException {
        DeadLockingSample deadLockingSample = new DeadLockingSample();

        Thread t1 = new Thread(deadLockingSample::operation1);
        t1.start();
        Thread t2 = new Thread(deadLockingSample::operation2);
        t2.start();

        t1.join();
        t2.join();
    }
}
