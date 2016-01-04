package nju.software.concurrent.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A simple example about Lock
 * Created by Xie on 2015/12/31.
 */
public class LockExample {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 12, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
//        executor.execute(new Counter());
    }

}

