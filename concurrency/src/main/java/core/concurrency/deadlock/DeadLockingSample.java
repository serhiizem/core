package core.concurrency.deadlock;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class DeadLockingSample {

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    private final CountDownLatch latch1 = new CountDownLatch(1);
    private final CountDownLatch latch2 = new CountDownLatch(1);

    public void operation1() {
        synchronized (monitor1) {
            latch1.countDown();
            System.out.println("Inside operation1");
            operation2();
        }
    }

    @SneakyThrows
    public void operation2() {
        latch1.await();
        synchronized (monitor2) {
            System.out.println("Inside operation2");
            operation3();
        }
    }

    public void operation3() {
        synchronized (monitor1) {
            System.out.println("Inside operation3");
        }
    }
}
