package nju.software.util;

/**
 * Created by Xie on 2015/12/19.
 */
public class PrintUtil {

    public static void print(Object obj) {
        if (obj == null)
            return;
        System.out.println(obj.toString());
    }

    public static void print(Object[] objs) {
        if (objs == null)
            return;
        for (Object obj : objs) {
            System.out.print(obj.toString() + " ");
        }
        System.out.println();
    }
}
