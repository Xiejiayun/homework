package nju.software.base;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * Created by Xie on 2016/1/2.
 */
public class DateUtilsExample {
    public static void main(String[] args) {
        System.out.println(DateUtils.isSameDay(new Date(2015, 2, 16), new Date(2015, 2, 16)));
        System.out.println(DateUtils.addDays(new Date(2015, 2, 16), 100));
        System.out.println(DateUtils.toCalendar(new Date(2015, 2, 26)));
    }

}
