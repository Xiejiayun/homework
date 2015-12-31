package nju.software.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * A simple producer & consumer example using Blocking Queue
 * In reference to http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html
 * Created by Xie on 2015/12/31.
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(6);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer implements Runnable {

    BlockingQueue<Integer> blockingQueue;
    int count = 0;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            while(blockingQueue != null && blockingQueue.remainingCapacity() > 0) {
                try {
                    System.out.println("input into the blocking queue " + count);
                    blockingQueue.add(count++);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    BlockingQueue<Integer> blockingQueue = null;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("I am in consumer");
        while (true) {
            while (blockingQueue != null && !blockingQueue.isEmpty()) {
                try {
                    System.out.println("take from the blocking queue "+blockingQueue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
