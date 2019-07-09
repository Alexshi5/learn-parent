package java8;

import org.junit.Test;

import java.util.Optional;

/**
 * Java8的Optional类的使用
 */
public class OptionalExample {
    //参考于：https://my.oschina.net/thinwonton/blog/2992379

    /**
     * Optional的初始化
     * Optional的构造方法是私有的，所有只能通过静态方法去初始化
     */
    @Test
    public void example1(){
        //of 为指定的类型值创建一个Optional，如果给定的值为null则会报空指针异常
        Optional<String> optional = Optional.of("Hello Optional");
        System.out.println(optional.get()); //打印：Hello Optional

        //ofNullable 为指定的类型值创建一个Optional，它与of的区别在于可以传null，当值为null时则创建一个空的Optional
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o instanceof Optional); //打印：true

        //empty 获取Optional的静态初始化空对象，单例实现，全局唯一
        Optional<Object> empty = Optional.empty();
        System.out.println(o == empty); //打印：true
    }

    /**
     * Optional的isPresent方法：如果值存在返回true，否则返回false
     */
    @Test
    public void example2(){
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.isPresent()); //打印：false

        Optional<String> optional = Optional.ofNullable("Hello Optional");
        System.out.println(optional.isPresent()); //打印：true
    }

    /**
     * Optional的get方法：如果值存在则返回，否则抛出NoSuchElementException异常
     */
    @Test
    public void example3(){
        Optional<String> optional = Optional.ofNullable("Hello Optional");
        System.out.println(optional.get()); //打印：Hello Optional

        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.get()); //抛出：NoSuchElementException异常
    }

    /**
     * Optional的ifPresent方法：如果有值则调用Consumer，否则不做处理
     */
    @Test
    public void example4(){
        Optional<String> optional = Optional.ofNullable("Hello Optional");
        optional.ifPresent(x -> System.out.println(x)); //简化前
        optional.ifPresent(System.out::println); //简化后
        optional.ifPresent(this::doSomething); //自定义
        //打印结果均为：Hello Optional
    }
    private void doSomething(String s){
        System.out.println(s);
    }

    /**
     * Optional的orElse方法：如果有值则返回，否则返回其他指定的值
     */
    @Test
    public void example5(){
        System.out.println(Optional.empty().orElse("备胎")); //打印：备胎
        System.out.println(Optional.of("张三").orElse("备胎")); //打印：张三
    }

    /**
     * Optional的orElseGet方法：如果有值则返回值，否则返回supplier的接口实现生成默认值
     */
    @Test
    public void example6(){
        System.out.println(Optional.empty().orElseGet(() -> "备胎")); //打印：备胎
        System.out.println(Optional.of("张三").orElseGet(() -> "备胎")); //打印：张三
    }

    /**
     * Optional的orElseThrow方法：如果没有值则抛出一个异常
     */
    @Test
    public void example7(){
        try {
            System.out.println(Optional.empty().orElseThrow(() -> new Exception("操作异常")));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Optional的map方法：
     * 传入参数mapper如果为null，则抛出空指针异常。
     * mapper不为空则检查Optional是否为空，为空则返回空Optional
     * Optional不为空时则执行mapper参数的function方法得到mapper返回值
     * mapper返回值为空则返回空Optional，否则创建包含mapper返回值的Optional进行返回
     *
     * 与之类似的是flatMap方法：它与map的区别是mapper的返回值必须为Optional，调用结束时不会再对mapper返回值进行Optional封装
     */
    @Test
    public void example8(){
        //map
        Optional<String> optional = Optional.ofNullable(100)
                .map(fun1 -> fun1.toString())
                .map( x -> x + "100");
        System.out.println(optional.orElse("default")); //打印：100100

        //flatMap
        Optional<String> optional1 = Optional.ofNullable(100)
                .flatMap(z -> Optional.ofNullable(z.toString()))
                .flatMap(t -> Optional.ofNullable(t + "100"));
        System.out.println(optional1.orElse("default")); //打印：100100
    }

    /**
     * Optional的filter方法：
     * 如果有值并且满足断言条件则返回包含该值的Optional，否则返回空的Optional
     */
    @Test
    public void example9(){
        Optional<String> optional1 = Optional.ofNullable("test")
                .filter(s -> s.equals("test"));
        System.out.println(optional1.isPresent()); //打印：true

        Optional<String> optional2 = Optional.ofNullable("test")
                .filter(s -> s.equals("test"))
                .filter(t -> t.length() > 5);
        System.out.println(optional2.isPresent()); //打印：false
    }
}
