package com.mengfei.pojo;

/**
 * author Alex
 * date 2018/11/24
 * description 一个演示使用的人实体类
 */
public class Person {
    private String name;
    private String sex;
    private Integer age;
    private String phone;

    public Person(String name, String sex, Integer age, String phone) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
