package nju.software.concurrent;

/**
 * A simple counter example using Thread
 * Created by Xie on 2015/12/18.
 */
public class ThreadExample extends Thread{

    private static int count = 10;
    @Override
    public void run() {
        while (count > 0)
        System.out.println(count--);
    }

    public static void main(String[] args) {
        Thread counter = new ThreadExample();
        counter.start();
    }

}
