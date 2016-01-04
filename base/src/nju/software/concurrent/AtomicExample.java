package nju.software.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Xie on 2016/1/1.
 */
public class AtomicExample {
    private static AtomicInteger atoInt = new AtomicInteger();
    private static int sycInt = 0;

    private static CountDownLatch latch = null;

    public static int getNextAtomic() {
        return atoInt.incrementAndGet();
    }

    public static synchronized int getNext() {
        return ++sycInt;
    }

    public static void main(String[] args) throws InterruptedException {
        latch = new CountDownLatch(50);
        long begin = System.nanoTime();
        for (int i = 0; i < 50; i++) {
            new Thread(new Task(false)).start();
        }
        latch.await();
        long end = System.nanoTime();
        System.out.println("Synchronized time" + (end - begin));
        latch = new CountDownLatch(50);
        begin = System.nanoTime();
        for (int i = 0; i < 50; i++) {
            new Thread(new Task(true)).start();
        }
        latch.await();
        end = System.nanoTime();
        System.out.println("Atomic time" + (end - begin));
    }

    static class Task implements Runnable {

        private boolean isAtomic;

        public Task(boolean isAtomic) {
            this.isAtomic = isAtomic;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                if (isAtomic) {
                    getNextAtomic();
                } else {
                    getNext();
                }
            }
            latch.countDown();
        }
    }
}
