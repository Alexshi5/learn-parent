package java8;

import org.junit.Test;

import java.util.function.*;

/**
 * Java8的函数式编程
 */
public class FunctionProgramming {
    //参考于：https://my.oschina.net/thinwonton/blog/2991303

    /**
     * 接口：interface Supplier<T> 提供者
     * 定义一个Lambda表达式，无输入，生产(返回)一个T类型的值
     */
    @Test
    public void example1(){
        //返回Integer类型的值
        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get()); //打印：10

        //返回异常类的对象
        Supplier<Exception> exceptionSupplier = () -> new Exception("异常");
        System.out.println(exceptionSupplier.get().getMessage()); //打印：异常
    }

    /**
     * 接口：interface Consumer<T> 消费者
     * 定义一个Lambda表达式，消费(输入)一个T类型的值，无返回
     */
    @Test
    public void example2(){
        //accept 接收参数并调用接口的方法
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(15); //打印：15

        //andThen 先调用原Consumer，再调用andThen方法中指定的Consumer
        Consumer<Integer> secondConsumer = y -> System.out.println(y + y);
        consumer.andThen(secondConsumer).accept(10); //打印： 10 20
    }

    /**
     * 接口：interface Function<T,R> 函数
     * 定义一个Lambda表达式，输入一个T类型的参数，返回一个R类型的值
     */
    @Test
    public void example3(){
        //apply 传入一个T类型的值，返回一个R类型的值
        Function<Integer, Double> function = x -> x + 10.5;
        System.out.println(function.apply(10)); //打印：20.5

        //两个Function
        Function<String, String> fun1 = str1 -> {
            System.out.println("fun1");
            return str1 + "1";
        };
        Function<String, String> fun2 = str2 -> {
            System.out.println("fun2");
            return str2 + "2";
        };

        //compose 先执行compose中的函数，再把返回值当作参数执行原函数
        String str1 = fun1.compose(fun2).apply("张三");
        System.out.println(str1); //打印：fun2 fun1 张三21

        //andThen 先执行原函数，再把原函数的返回值当作参数执行andThen中的函数
        String str2 = fun1.andThen(fun2).apply("张三");
        System.out.println(str2); //打印： fun1 fun2 张三12
    }

    /**
     * 接口：interface Predicate<T> 断言
     * 定义一个Lambda表达式，输入一个T类型的参数，返回一个true/false
     */
    @Test
    public void example4(){
        //test 测试输入的参数是否满足定义的lambda表达式
        Predicate<String> pre1 = s -> "test".equals(s);
        System.out.println(pre1.test("test")); //打印：true
        System.out.println(pre1.test("test_")); //打印：false

        //and 原Predicate接口和and方法中指定的Predicate接口要同时为true，结果才为true，同逻辑运算符&&一样
        Predicate<String> pre2 = s -> s.length() == 4;
        System.out.println(pre1.and(pre2).test("test")); //打印：true
        System.out.println(pre1.and(pre2).test("ssss")); //打印：false

        //or 原Predicate接口和or方法中指定的Predicate接口有一个为true，结果就为true，同逻辑运算符||一样
        System.out.println(pre1.or(pre2).test("ssss")); //打印：true

        //negate 对结果取反再输出
        System.out.println(pre1.negate().test("test")); //打印：false
    }

    /**
     * 基本数据类型的函数式接口：double int long boolean
     * double int long都有四个接口，boolean只有一个BooleanSupplier
     */
    @Test
    public void example5(){
        //生产一个double类型的返回值
        DoubleSupplier doubleSupplier = () -> {
          return 10.5 + 'a'; //a的ascii编码为97
        };
        System.out.println(doubleSupplier.getAsDouble()); //打印：107.5

        //消费一个double类型的值
        DoubleConsumer doubleConsumer = x -> {
            System.out.println(x + "000");
        };
        doubleConsumer.accept(10); //打印：10.0000 double类型默认小数点后面有一位

        //消费一个double类型的值再返回一个T类型的值
        DoubleFunction<String> doubleFunction = x -> {
            return x + "000";
        };
        System.out.println(doubleFunction.apply(10)); //打印：10.0000

        //消费一个double类型的值进行断言
        DoublePredicate doublePredicate = x -> {
            return x>1;
        };
        System.out.println(doublePredicate.test(10)); //打印：true
    }

    //内部类
    class Student{
        private String name;
        private Integer age;
        public Student(){}

        public Student(String name, Integer age) {
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
    }

    /**
     * 一元函数式接口
     */
    @Test
    public void example6(){
        //引用类型的一元函数式接口
        UnaryOperator<Student> unaryOperator = x -> {
            return new Student(x.getName(),20);
        };
        Student stu = unaryOperator.apply(new Student("张三", 15));
        System.out.println(stu.getName() + "今年" + stu.getAge() + "岁"); //打印：张三今年20岁

        //基本类型的一元函数式接口：int long double
        IntUnaryOperator intUnaryOperator = x -> {
            return x * x;
        };
        System.out.println(intUnaryOperator.applyAsInt(10)); //打印：100
    }

    /**
     * 用于类型转换的一元函数式接口
     */
    @Test
    public void example7(){
        //引用数据类型转基本数据类型
        ToIntFunction<Student> toIntFunction = x -> {
            return x.getAge();
        };
        System.out.println(toIntFunction.applyAsInt(new Student("张三",15))); //打印：15

        //基本数据类型转其他基本数据类型：int long double
        IntToDoubleFunction intToDoubleFunction = x -> {
            return x;
        };
        System.out.println(intToDoubleFunction.applyAsDouble(10));//打印：10.0
    }

    /**
     * 同类型输入参数的二元函数式接口
     */
    @Test
    public void example8(){
        //引用类型
        BinaryOperator<Student> binaryOperator = (x,y) -> {
            return new Student(x.getName(),y.getAge());
        };
        Student stu = binaryOperator.apply(new Student("张三", 15), new Student("李四", 20));
        System.out.println(stu.getName() + "今年" + stu.getAge() + "岁"); //打印：张三今年20岁

        //基本数据类型：int double long
        IntBinaryOperator intBinaryOperator = (x,y) -> {
            return Math.max(x,y);
        };
        System.out.println(intBinaryOperator.applyAsInt(10,20)); //打印：20
    }

    /**
     * 混合类型输入参数的二元函数式接口
     */
    @Test
    public void example9(){
        ObjIntConsumer<Student> objIntConsumer = (x,y) ->{
            System.out.println(x.getName() + "今年" + y + "岁"); //打印：张三今年20岁
        };
        objIntConsumer.accept(new Student("张三",20),30);
    }

    /**
     * 用于类型转换的二元函数式接口
     */
    @Test
    public void example10(){
        //引用数据类型到基本数据类型
        ToIntBiFunction<Student, Integer> toIntBiFunction = (x,y) -> {
            return x.getAge() + y;
        };
        Student stu = new Student("张三", 20);
        int age = toIntBiFunction.applyAsInt(stu, 10);
        System.out.println(stu.getName() + "10年后" + age + "岁"); //打印：张三10年后30岁
    }
}
