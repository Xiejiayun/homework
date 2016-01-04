package nju.software.common.codec;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

/**
 * Created by Xie on 2016/1/2.
 */
public class DigestUtilsExample {

    public static void main(String[] args) {
        MessageDigest messageDigest = DigestUtils.getMd5Digest();
        byte[] base = new byte[]{'B', 'A', 'C'};
        System.out.println(base.length + " " + base[0] + "" + base[1] + "" + base[2]);
        base = messageDigest.digest(base);
        System.out.println(base.length + " " + base[0] + "" + base[1] + "" + base[2]);
    }
}
