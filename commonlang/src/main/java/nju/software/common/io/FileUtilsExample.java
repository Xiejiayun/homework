package nju.software.common.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Xie on 2016/1/2.
 */
public class FileUtilsExample {

    public static void main(String[] args) {
        File file = new File("README.md");
        try {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            for (String s : lines) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
