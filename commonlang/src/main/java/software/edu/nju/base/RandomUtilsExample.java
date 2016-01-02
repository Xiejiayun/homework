package software.edu.nju.base;

import org.apache.commons.lang3.RandomUtils;

/**
 * Using the RandomUtils in apache commons lang library
 * Created by Xie on 2015/12/30.
 */
public class RandomUtilsExample extends BaseExample {

    public static void main(String[] args) {
        println(String.valueOf(RandomUtils.nextBytes(10)));
        println(String.valueOf(RandomUtils.nextInt(10, 18)));
        println(String.valueOf(RandomUtils.nextLong(10, 18)));
        println(String.valueOf(RandomUtils.nextFloat(10, 18)));
        println(String.valueOf(RandomUtils.nextDouble(10, 18)));
        println(String.valueOf(RandomUtils.nextBytes(5)));
        println(String.valueOf(RandomUtils.nextInt(4, 2)));
    }


}
