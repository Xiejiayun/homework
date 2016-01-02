package nju.software;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * Created by Xie on 2016/1/2.
 */
public class DataRange {

    public static void main(String[] args) {
        Date memory = DateUtils.addDays(new Date(2015, 9, 25), 100);
        System.out.println(memory.getYear()+ " "+memory.getMonth() + " " + memory.getDay());
    }

}
