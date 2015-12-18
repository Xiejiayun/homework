package nju.software.util;

/**
 * StringUtil provides some common and useful functions about String
 * Created by Xie on 2015/12/18.
 */
public class StringUtil {

    /**
     * distinguish whether the string is null or ""(after trim function)
     * @param str string object
     * @return true or false
     */
    public static boolean isBlank(String str) {
        if (str == null || str.trim() == "")
            return true;
        return false;
    }

    /**
     * distinguish whether the two strings equal or not
     * @param str1 first string object
     * @param str2 second string object
     * @return  true or false
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        if (str1.length() != str2.length())
            return false;
        return str1.equals(str2);
    }
}
