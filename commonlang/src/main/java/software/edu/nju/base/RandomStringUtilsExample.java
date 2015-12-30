package software.edu.nju.base;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Using the RandomStringUtils in apache commons lang library
 * Created by Xie on 2015/12/30.
 */
public class RandomStringUtilsExample extends BaseExample{

    public static void main(String[] args) {
        println(RandomStringUtils.random(10));
        println(RandomStringUtils.random(20));
        println(RandomStringUtils.random(30));
        println(RandomStringUtils.randomAscii(10));
        println(RandomStringUtils.randomAlphabetic(10));
        println(RandomStringUtils.randomAlphanumeric(10));
        println(RandomStringUtils.randomNumeric(10));
    }
}
