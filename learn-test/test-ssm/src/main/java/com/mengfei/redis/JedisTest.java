package com.mengfei.redis;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * author Alex
 * date 2018/10/19
 * description 用于测试redis
 */
@Component
public class JedisTest {
    //@Resource
    private JedisConnectionFactory jedisConnectionFactory;


    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
    }

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-test.xml");
        //HelloWorldTest test = (HelloWorldTest) context.getBean("helloWorldTest");
        //test.doSay();
    }

    @Test
    //将151中的数据修改后添加到本地redis中
    public void example7() throws Exception{
        Jedis jedis = new Jedis("10.224.169.151", 6379);
        //Jedis jedis2 = new Jedis("localhost", 6379);
        Jedis jedis2 = new Jedis("10.224.169.132", 6379);
        Set<String> keys = jedis.keys("carWarn*");//6
        //Set<String> keys = jedis.keys("carblack*");//4
        int count = 0;
        for (String key : keys) {
            if(count>10000){
                break;
            }
            byte[] bytes= jedis.get(key.getBytes());
            if(null != bytes && bytes.length>0){
                String newKey = key.replaceAll("#","@@@");
                String[] arr = newKey.split("#");
                if(arr.length>6){
                    continue;
                }else {
                    System.out.println(newKey);
                    jedis2.set(newKey.getBytes(),bytes);
                    count++;
                }
            }
        }
        jedis.close();
        System.out.println("修改成功，连接已关闭！");
        //System.in.read();
    }

    @Test
    public void example6() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-test-redis.xml");
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) context.getBean("jedisConnectionFactory");
        Field jedisField = ReflectionUtils.findField(JedisConnection.class, "jedis");
        ReflectionUtils.makeAccessible(jedisField);
        System.out.println(jedisConnectionFactory.getConnection());
        Jedis jedis = (Jedis) ReflectionUtils.getField(jedisField, jedisConnectionFactory.getConnection());
        String result = jedis.set("test-key", "Hello world-", "NX", "EX", 100);
        System.out.println(result);
        //代码执行后,返回字符串”OK”或者”null”,表示是否设值成功。
    }

    @Test
    //删除本地redis中的数据
    public void example4() {
        Jedis jedis = new Jedis("10.224.169.132", 6379);
        Set<String> tips = jedis.keys("carblack*");
        for (String str : tips) {
            System.out.println(str);
            jedis.del(str);
        }
        jedis.close();
        System.out.println("删除成功，连接已关闭！");
    }

    @Test
    //普通的存取对象的JSON字符串
    public void example1() {
        Jedis jedis = new Jedis("localhost", 6379);
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(20);

        Student student1 = new Student();
        student1.setName("李四");
        student1.setAge(30);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);

        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put("stu", student);
        studentMap.put("stu1", student1);
        System.out.println("准备向redis中写入数据");
        jedis.set("test1", JSON.toJSONString(studentMap));
        jedis.close();
        System.out.println("redis关闭成功！");
    }

    //序列化
    @Test
    public void example2() {
        Jedis jedis = new Jedis("localhost", 6379);
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(20);
        System.out.println("准备向redis中写入数据");
        jedis.set("test2".getBytes(), serialize(student));
        jedis.close();
        System.out.println("redis关闭成功！");
    }

    //反序列化
    @Test
    public void example3() {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("准备从redis中获取数据");
        byte[] bytes = jedis.get("test2".getBytes());
        Object obj = this.unserizlize(bytes);
        System.out.println(obj.toString());
        jedis.close();
        System.out.println("redis关闭成功！");
    }

    //序列化
    public byte[] serialize(Object obj) {
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;
        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt = bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public Object unserizlize(byte[] byt) {
        ObjectInputStream oii = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(byt);
        try {
            oii = new ObjectInputStream(bis);
            Object obj = oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }


        return null;
    }
}
