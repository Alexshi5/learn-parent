package com.mengfei.redis;

import java.io.Serializable;

/**
 * author Alex
 * date 2018/8/2
 * description
 */
public class Student implements Serializable{

    private static final long serialVersionUID = -8137026281341716330L;
    private String name;
    private Integer age;

    Student(){

    }

    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
