package nju.software.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A simple example about Lock
 * Created by Xie on 2015/12/31.
 */
public class LockExample {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private static Map<String, String> map = new HashMap<String, String>();
    private static CountDownLatch latch = new CountDownLatch(102);
    private static CyclicBarrier barrier = new CyclicBarrier(102);
    private static volatile  int count = 1;


    public static void main(String[] args) {
        costTime(100, 2);
        costTime(51, 51);
        costTime(2, 100);
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    private static void costTime(int readThread, int writeThread) {
        latch = new CountDownLatch(102);
        barrier = new CyclicBarrier(102);
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < readThread; i++) {
            new Thread(new ReadThread()).start();
        }

        for (int i = 0; i < writeThread; i++) {
            new Thread(new WriteThread()).start();
        }
        try {
            latch.await();
            long endTime = System.currentTimeMillis();
            System.out.println("The " + count++ + "'s test costs " + (endTime - beginTime) + " millionseconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ReadThread implements Runnable {

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                readLock.lock();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
            latch.countDown();
        }

    }

    static class WriteThread implements Runnable {

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                writeLock.lock();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
            latch.countDown();
        }

    }

}

