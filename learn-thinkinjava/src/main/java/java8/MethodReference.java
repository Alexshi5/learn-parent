package java8;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Java8的方法引用(双冒号操作符)
 */
public class MethodReference {

    /**
     * 什么是方法引用？
     * 简单来说就是一个Lambda表达式，方法引用提供了一种引用而不执行方法的方式，运行时，方法引用会创建一个函数式接口的实例。
     */
    @Test
    public void example1(){

        //使用Lambda表达式
        Consumer<String> consumer1 = x -> System.out.println(x);
        consumer1.accept("Lambda表达式");

        //使用方法引用
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("方法引用::");
    }

    /**
     * 方法引用的五种方式
     */
    @Test
    public void example2(){
        //1.引用对象的实例方法   对象::实例方法名
        //2.引用类的静态方法     类::静态方法名
        //3.引用类的实例方法     类::实例方法名
        //4.引用构造方法        类::new
        //5.数组引用           类型::new
    }

    /**
     * 引用对象的实例方法
     */
    @Test
    public void example3(){
        Human human = new Human("小白",20);

        //使用Lambda表达式
        Supplier<String> supplier1 = () -> human.getName();
        System.out.println(supplier1.get());

        //使用方法引用
        Supplier<String> supplier2 = human::getName;
        System.out.println(supplier2.get());
    }

    /**
     * 引用类的静态方法
     */
    @Test
    public void example4(){
        //使用Lambda表达式
        Supplier<String> supplier1 = () -> Human.getNationality();
        System.out.println(supplier1.get());

        //使用方法引用
        Supplier<String> supplier2 = Human::getNationality;
        System.out.println(supplier2.get());
    }

    /**
     * 引用类的实例方法名
     */
    @Test
    public void example5(){
        Human human = new Human("小白",20);

        //使用Lambda表达式
        Function<Human, String> function1 = p -> p.getName();
        System.out.println(function1.apply(human));

        //使用方法引用
        Function<Human, String> function2 = Human::getName;
        System.out.println(function2.apply(human));
    }

    /**
     * 引用构造方法
     */
    @Test
    public void example6(){

        //使用Lambda表达式
        Supplier<Human> supplier1 = () -> new Human();
        System.out.println(supplier1.get() instanceof Human); //true

        //使用方法引用
        Supplier<Human> supplier2 = Human::new;
        System.out.println(supplier2.get() instanceof Human); //true
    }

    /**
     * 引用数组
     */
    @Test
    public void example7(){
        //使用Lambda表达式
        Function<Integer, String[]> function1 = x -> new String[]{x.toString()};
        System.out.println(function1.apply(10) instanceof String[]); //true

        //使用方法引用
        Function<Integer, String[]> function2 = String[]::new;
        System.out.println(function2.apply(10) instanceof String[]); //true
    }
}

class Human{
    private String name;
    private int age;

    public Human(){ }
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static String getNationality(){
        return "中国";
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
