package software.edu.nju.base;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

/**
 * Using the ArrayUtils in apache commons lang library
 * Created by Xie on 2015/12/30.
 */
public class ArrayUtilsExample extends BaseExample{

    public static void main(String[] args) {

        Integer [] arr1 = { 1, 2, 3};
        Integer [][] arr2 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        Object[][] arr3 = {{ "key1", new Integer(1) }, { "key2", new Integer(2) }, { "key3", new Integer(3) },{ "key4", new Integer(4) }};

        arr1 = ArrayUtils.add(arr1, 6);
        ArrayUtils.reverse(arr1);

        println(ArrayUtils.toString(arr1));
        println(ArrayUtils.toString(arr2));

        Map map = ArrayUtils.toMap(arr3);
        println(map.get("key1"));
    }

}
