package nju.software.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Xie on 2015/12/31.
 */
public class LinkedBlockingQueueExample {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> boundedQueue = new LinkedBlockingQueue<>(1);
        LinkedBlockingQueue<Integer> unboundedQueue = new LinkedBlockingQueue<>();
        try {
//            boundedQueue.put(1);
            boundedQueue.put(2);
//            boundedQueue.add(1);
//            boundedQueue.add(2);
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
