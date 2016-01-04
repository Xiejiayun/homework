package nju.software.base;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by Xie on 2016/1/1.
 */
public class NumberUtilsExample {

    public static void main(String[] args) {
        System.out.println(NumberUtils.compare(1, 2));
        System.out.println(NumberUtils.compare(1, 0));
        System.out.println(NumberUtils.compare(1, 1));
        System.out.println(NumberUtils.createBigDecimal("123123123123123123123.12312312321"));
        System.out.println(NumberUtils.isNumber("123"));
        System.out.println(NumberUtils.isDigits("123"));
        System.out.println(NumberUtils.isDigits("123.1"));

    }

}
