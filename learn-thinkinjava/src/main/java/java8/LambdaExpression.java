package java8;

import org.junit.Test;

import java.util.function.*;

/**
 * Java8的Lambda表达式
 * Lambda是Java8的一个语法糖，它其实是匿名函数，通过约定好怎么传入参数，怎么返回参数，由编译器负责参数类型的猜测并执行结果。
 */
public class LambdaExpression {
    //参考于：https://my.oschina.net/thinwonton/blog/2991303

    /**
     * Lambda表达式的基本语法
     */
    @Test
    public void example1(){
        //语法格式
        //(parameters) -> expression
        //(parameters) -> { statements; }
        //即"->"操作符将Lambda表达式分为两个部分：左侧为参数列表，右侧为Lambda体。
        //每一个Lambda表达的返回值都是一个函数式编程的接口
    }

    /**
     * 无参数，无返回
     */
    @Test
    public void example2(){
        Runnable hello_lambda1 = () -> System.out.println("Hello Lambda");
        hello_lambda1.run();
        //或
        Runnable hello_lambda2 = () -> {
            System.out.println("Hello Lambda");
        };
        hello_lambda2.run();
    }

    /**
     * 无参数，有返回
     */
    @Test
    public void example3(){
        Supplier<Integer> supplier1 = () -> 10;
        System.out.println(supplier1.get());
        //或
        Supplier supplier2 = () -> {
            return 10;
        };
        System.out.println(supplier2.get());
    }

    /**
     * 有一个参数，无返回
     */
    @Test
    public void example4(){
        Consumer<String> consumer1 = x -> System.out.println(x);
        consumer1.accept("Hello Lambda");
        //或
        Consumer<String> consumer2 = (x) -> System.out.println(x);
        consumer2.accept("Hello Lambda");
        //或
        Consumer<String> consumer3 = x -> {
            System.out.println(x);
        };
        consumer3.accept("Hello Lambda");
    }

    /**
     * 有一个参数，有返回值
     */
    @Test
    public void example5(){
        IntFunction<Integer> intFunction1 = x -> x + 10;
        System.out.println(intFunction1.apply(10));
        //或
        IntFunction<Integer> intFunction2 = (x) -> {
            return x + 10;
        };
        System.out.println(intFunction2.apply(10));
    }

    /**
     * 有多个参数，无返回值
     */
    @Test
    public void example7(){
        ObjIntConsumer<Integer> objIntConsumer = (x,y) -> {
            System.out.println(x + y);
        };
        objIntConsumer.accept(10,20);
        //或
        BiConsumer<Integer,Integer> biConsumer = (Integer x, Integer y) -> {
            System.out.println(x + y);
        };
        biConsumer.accept(10,20);
    }

    /**
     * 有多个参数，有返回值
     */
    @Test
    public void example6(){
        IntBinaryOperator intBinaryOperator = (x,y) -> {
          return x > y ? x : y;
        };
        System.out.println(intBinaryOperator.applyAsInt(10,20));
        //或
        BinaryOperator<Integer> binaryOperator = (Integer x, Integer y) -> {
            return x > y ? x : y;
        };
        System.out.println(binaryOperator.apply(10,20));
    }
}
