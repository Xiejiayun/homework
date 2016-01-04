package nju.software.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A simple example using Thread Pool to manager threads
 * Created by Xie on 2015/12/31.
 */
public class ThreadPoolExample {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.SECONDS, blockingQueue);
        executor.execute(new Counter(1));
        executor.execute(new Counter(1));
        executor.execute(new Counter(1));
        executor.execute(new Counter(1));
        executor.execute(new Counter(1));
        executor.execute(new Counter(1));
        executor.execute(new Counter(1));
    }



}
class Counter implements Runnable {

    int counter;

    public Counter(int c) {
        this.counter = c;
    }

    @Override
    public void run() {
        for (int i=0; i<10000; i++)
        System.out.println(Thread.currentThread().getName() +  counter++);
    }
}
