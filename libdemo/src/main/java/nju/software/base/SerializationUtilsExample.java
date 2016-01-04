package nju.software.base;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/**
 * Created by Xie on 2016/1/2.
 */
public class SerializationUtilsExample {
    public static void main(String[] args) {
        byte[] from = SerializationUtils.serialize(new Student("Jack", 22));
        Student jack = SerializationUtils.deserialize(from);
        System.out.println(jack);
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