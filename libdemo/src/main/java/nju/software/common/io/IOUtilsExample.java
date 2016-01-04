package nju.software.common.io;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Xie on 2016/1/2.
 */
public class IOUtilsExample {

    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new URL("http://www.baidu.com").openStream();
            System.out.println(IOUtils.toString(in));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
}
