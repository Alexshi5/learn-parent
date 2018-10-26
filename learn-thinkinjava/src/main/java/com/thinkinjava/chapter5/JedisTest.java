package com.thinkinjava.chapter5;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Alex
 * date 2018/10/19
 * description 用于测试redis
 */
public class JedisTest {

    @Test
    public void example4(){

    }

    @Test
    //普通的存取对象的JSON字符串
    public void example1(){
        Jedis jedis = new Jedis("localhost",6379);
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(20);

        Student student1 = new Student();
        student1.setName("李四");
        student1.setAge(30);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);

        Map<String,Student> studentMap = new HashMap<>();
        studentMap.put("stu",student);
        studentMap.put("stu1",student1);
        System.out.println("准备向redis中写入数据");
        jedis.set("test1", JSON.toJSONString(studentMap));
        jedis.close();
        System.out.println("redis关闭成功！");
    }

    @Test
    public void example2(){
        Jedis jedis = new Jedis("localhost",6379);
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(20);
        System.out.println("准备向redis中写入数据");
        jedis.set("test2".getBytes(), serialize(student));
        jedis.close();
        System.out.println("redis关闭成功！");
    }

    @Test
    public void example3(){
        Jedis jedis = new Jedis("localhost",6379);
        System.out.println("准备从redis中获取数据");
        byte[] bytes = jedis.get("test2".getBytes());
        Object obj = this.unserizlize(bytes);
        System.out.println(obj.toString());
        jedis.close();
        System.out.println("redis关闭成功！");
    }

    //序列化
    public byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }


        return null;
    }
}
