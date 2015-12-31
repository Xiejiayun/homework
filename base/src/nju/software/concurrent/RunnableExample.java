package nju.software.concurrent;

/**
 * A simple counter example using Runnable
 * Created by Xie on 2015/12/31.
 */
public class RunnableExample implements Runnable{

    public static int count = 10;
    @Override
    public void run() {
        while (count > 0)
            System.out.println(count--);
    }

    public static void main(String[] args) {
        RunnableExample runnableExample = new RunnableExample();
        Thread thread = new Thread(runnableExample);
        thread.start();
    }
}
