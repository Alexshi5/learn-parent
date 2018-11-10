package com.thinkinjava.chapter7;

public class FinalFiled {

    private static final Student stu = new Student();

    public static void main(String[] args) {
        stu.setAge(10);
        System.out.println(stu.getAge());
        stu.setAge(20);
        System.out.println(stu.getAge());
    }

}

class Student{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
