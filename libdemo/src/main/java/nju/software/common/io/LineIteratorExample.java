package nju.software.common.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

/**
 * Created by Xie on 2016/1/2.
 */
public class LineIteratorExample {

    public static void main(String[] args) {
        LineIterator it = null;
        try {
            it = FileUtils.lineIterator(new File("README.md"), "UTF-8");
            while (it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            LineIterator.closeQuietly(it);
        }
    }

}
