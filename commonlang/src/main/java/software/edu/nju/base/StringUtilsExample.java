package software.edu.nju.base;

import org.apache.commons.lang3.StringUtils;

/**
 * Using the StringUtils in apache commons lang library
 * Created by Xie on 2015/12/30.
 */
public class StringUtilsExample {

    public static void main(String[] args) {
        isEmpty("");
        isBlank("hi");
        trim(" hi, everyone!");
        equals("hello", new String("hello"));
    }

    private static void println(CharSequence charSequence) {
        System.out.println(charSequence);
    }

    /**
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * @param charSequence
     */
    private static void isEmpty(CharSequence charSequence) {
        println("Judge the string " + charSequence + " is empty " + StringUtils.isEmpty(charSequence));
    }

    /**
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * @param charSequence
     */
    private static void isBlank(CharSequence charSequence) {
        println("Judge the string " + charSequence + " is blank " + StringUtils.isBlank(charSequence));
    }

    /**
     * StringUtils.trim(null)          = null
     * StringUtils.trim("")            = ""
     * StringUtils.trim("     ")       = ""
     * StringUtils.trim("abc")         = "abc"
     * StringUtils.trim("    abc    ") = "abc"
     * @param string
     */
    private static void trim(String string) {
        println("Trim the string |" + string + "|" + StringUtils.trim(string));
    }

    /**
     * StringUtils.equals(null, null)   = true
     * StringUtils.equals(null, "abc")  = false
     * StringUtils.equals("abc", null)  = false
     * StringUtils.equals("abc", "abc") = true
     * StringUtils.equals("abc", "ABC") = false
     * @param sequence1
     * @param sequence2
     */
    private static void equals(CharSequence sequence1, CharSequence sequence2) {
        println("The two char sequences are equals " + StringUtils.equals(sequence1, sequence2));
    }
}
