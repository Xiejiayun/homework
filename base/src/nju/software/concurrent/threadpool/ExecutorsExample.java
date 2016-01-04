package nju.software.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * Created by Xie on 2016/1/1.
 */
public class ExecutorsExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            BlockingQueue<Task> queue = new ArrayBlockingQueue<>(5);
            queue.add(new Task("task1", 1));
            queue.add(new Task("task2", 2));
            queue.add(new Task("task3", 3));
            queue.add(new Task("task4", 4));
            queue.add(new Task("task5", 5));
            executor.invokeAll(queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Task implements Callable<Integer> {

    private String str;
    private int count;

    public Task(String str, int count) {
        this.str = str;
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(this.str + " " + count + " in thread");
        return count;
    }
}
