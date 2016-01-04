package nju.software.common.codec;

import org.apache.commons.codec.binary.Base32;

import java.io.Serializable;

/**
 * Created by Xie on 2016/1/2.
 */
public class CodecBase {

    public static void main(String[] args) {
        Base32 base32 = new Base32();
        byte[] base = new byte[]{'B', 'A', 'C'};
        System.out.println(base[0] + "" + base[1] + "" + base[2]);
        byte[] from = base32.encode(base);
        System.out.println(from[0] + "" + from[1] + "" + from[2]);
        byte[] to = base32.decode(from);
        System.out.println(to[0] + "" + to[1] + "" + to[2]);
    }
}

class Student implements Serializable {
    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}