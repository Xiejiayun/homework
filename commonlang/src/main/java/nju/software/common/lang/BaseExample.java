package nju.software.common.lang;

/**
 * Provide some common functions like print
 * Created by Xie on 2015/12/30.
 */
public class BaseExample {

    protected static void println(CharSequence charSequence) {
        System.out.println(charSequence);
    }

    protected static void print(CharSequence charSequence) {
        System.out.print(charSequence);
    }

    protected static void println(String string) {
        System.out.println(string);
    }

    protected static void print(String string) {
        System.out.print(string);
    }

    protected static void print(Object object) {
        System.out.print(object.toString());
    }

    protected static void println(Object object) {
        System.out.println(object.toString());
    }

    protected static void print(Object[] arr) {
        System.out.print(arr.toString());
    }

    protected static void println(Object[] arr) {
        System.out.print(arr.toString());
    }
}
