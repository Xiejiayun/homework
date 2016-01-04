package nju.software.common.io;

import org.apache.commons.io.FilenameUtils;

/**
 * Created by Xie on 2016/1/2.
 */
public class FilenameUtilExample {

    public static void main(String[] args) {
        String filename = "C:/commons/io/../lang/project.xml";
        String normalized = FilenameUtils.normalize(filename);
        System.out.println(normalized);
    }

}
