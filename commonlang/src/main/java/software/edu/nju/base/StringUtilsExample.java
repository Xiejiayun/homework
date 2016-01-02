package software.edu.nju.base;

import org.apache.commons.lang3.StringUtils;

/**
 * Using the StringUtils in apache commons lang library
 * Created by Xie on 2015/12/30.
 */
public class StringUtilsExample extends BaseExample {

    public static void main(String[] args) {
        isEmpty("");
        isBlank("hi");
        trim(" hi, everyone!");
        equals("hello", new String("hello"));
        split(" hello xjy");
        String[] strs = new String[]{"hi1", "hi2", "hi3", "hi4", "hi5", "hi6"};
        join(strs);
    }

    /**
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     *
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
     *
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
     *
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
     *
     * @param sequence1
     * @param sequence2
     */
    private static void equals(CharSequence sequence1, CharSequence sequence2) {
        println("The two char sequences are equals " + StringUtils.equals(sequence1, sequence2));
    }

    /**
     * StringUtils.split(null)       = null
     * StringUtils.split("")         = []
     * StringUtils.split("abc def")  = ["abc", "def"]
     * StringUtils.split("abc  def") = ["abc", "def"]
     * StringUtils.split(" abc ")    = ["abc"]
     *
     * @param string
     */
    private static void split(String string) {
        String[] strs = StringUtils.split(string);
        for (String s : strs) {
            print(s + "/");
        }
        println("");
    }

    /**
     * StringUtils.join(null, *)                = null
     * StringUtils.join([], *)                  = ""
     * StringUtils.join([null], *)              = ""
     * StringUtils.join(["a", "b", "c"], "--")  = "a--b--c"
     * StringUtils.join(["a", "b", "c"], null)  = "abc"
     * StringUtils.join(["a", "b", "c"], "")    = "abc"
     * StringUtils.join([null, "", "a"], ',')   = ",,a"
     *
     * @param strs
     */
    private static void join(String[] strs) {
        String s = StringUtils.join(strs, ",");
        println(s);
    }
}
