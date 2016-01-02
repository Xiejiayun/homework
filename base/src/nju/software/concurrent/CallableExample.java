package nju.software.concurrent;

import java.util.concurrent.Callable;

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
    }

    @Override
    public Integer call() throws Exception {
        return count--;
    }


}
