package nju.software.concurrent.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * A simple example about LinkedBlockingQueue
 * Created by Xie on 2015/12/31.
 */
public class LinkedBlockingQueueExample {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> boundedQueue = new LinkedBlockingQueue<>(1);
        LinkedBlockingQueue<Integer> unboundedQueue = new LinkedBlockingQueue<>();
        try {
            boundedQueue.put(1);
            //if put the second value, the program will block
            //boundedQueue.put(2);
            //if add two values into the bounded queue, an exception will be thrown
            //boundedQueue.add(1);
            //boundedQueue.add(2);

            //we can put,add as many values in unboundedQueue
            unboundedQueue.put(1);
            unboundedQueue.put(2);
            unboundedQueue.put(3);
            System.out.println(unboundedQueue.take());
            System.out.println(unboundedQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
