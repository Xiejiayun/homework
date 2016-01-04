package nju.software.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * A simple counter example using Callable with return value
 * Created by Xie on 2015/12/31.
 */
public class CallableExample implements Callable<Integer> {

    private static int count = 10;

    public static void main(String[] args) {

        CallableExample callableExample = new CallableExample();
        try {
            Integer i;
            while ((i = callableExample.call()) != null && (i > 0)) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //using FutureTask to get the result whenever the thread finished
        FutureTask<Integer> future = new FutureTask<Integer>(new CallableExample());
        new Thread(future).start();
        try {
            Thread.sleep(500);
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        return count--;
    }


}
