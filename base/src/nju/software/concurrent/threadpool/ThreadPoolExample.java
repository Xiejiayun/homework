package nju.software.concurrent.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple example using Thread Pool to manager threads
 * Created by Xie on 2015/12/31.
 */
public class ThreadPoolExample {

    static long begintime;
    final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
    final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 600, 30,
            TimeUnit.SECONDS, queue, Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    final AtomicInteger completedTask = new AtomicInteger(0);
    final AtomicInteger rejectedTask = new AtomicInteger(0);
    int count = 10;

    public static void main(String[] args) {
        begintime = System.currentTimeMillis();
        ThreadPoolExample demo = new ThreadPoolExample();
        demo.start();
        System.out.println(demo.completedTask.get() + " " + demo.rejectedTask.get());
    }

    public void start() {
        CountDownLatch latch = new CountDownLatch(count);
        CyclicBarrier barrier = new CyclicBarrier(count);
        for (int i = 0; i < count; i++) {
            new Thread(new TestThread(latch, barrier)).start();
        }
        try {
            latch.await();
            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class TestThread implements Runnable {
        private CountDownLatch latch;
        private CyclicBarrier barrier;

        public TestThread(CountDownLatch latch, CyclicBarrier barrier) {
            super();
            this.latch = latch;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + "barrier waiting");
                barrier.await();
                System.out.println(this.toString() + "barrier starting");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                executor.execute(new Task(latch));
            } catch (RejectedExecutionException e) {
                latch.countDown();
                System.out.println("Rejected task count " + rejectedTask.incrementAndGet());
            }
        }

    }

    class Task implements Runnable {
        CountDownLatch latch;

        public Task(CountDownLatch latch) {
            super();
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Completed task count " + completedTask.incrementAndGet());
            latch.countDown();
        }
    }
}
