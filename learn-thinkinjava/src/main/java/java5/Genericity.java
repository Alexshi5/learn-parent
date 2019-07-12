package java5;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Java5的泛型使用详解
 * 参考于：https://blog.csdn.net/s10461/article/details/53941091
 */
public class Genericity {

    /**
     * 什么是泛型？
     */
    @Test
    public void example1(){
        //泛型，即参数化类型。就是将类型原来的具体的类型参数化(类型形参)，类似于方法中的变量参数，然后在使用时传入具体的类型(类型实参)。
        //泛型可以分为泛型类、泛型接口、泛型方法。
        //泛型只在编译阶段有效，当编译完成时会将泛型相关的信息去掉，并且在对象进入或离开方法的边界处添加类型检查和类型转换的方法，也就是说泛型信息不会进入到运行阶段。
    }

    /**
     * 泛型类的使用
     */
    @Test
    public void example2(){
        //指定泛型实参
        GenericityClass<Integer> demo = new GenericityClass<>(10); //根据类型实参进行限制，这里不能传入除Integer类型以外的其它类型
        Integer value = demo.getValue();
        System.out.println(value);

        //不指定泛型实参
        GenericityClass demo1 = new GenericityClass(10); //没有限制，可以是任意类型
        Object value1 = demo1.getValue();
        System.out.println(value1);

        //泛型通配符
        GenericityCommonSymbol symbol = new GenericityCommonSymbol(demo);
    }

    /**
     * 泛型接口的使用
     */
    @Test
    public void example3(){
        //实现泛型接口，未传入类型实参。如果Generator1不加<T>会编译报错
        class Generator1<T> implements GenericityInterface<T>{
            @Override
            public T value() {
                return null;
            }
        }

        //实现泛型接口，传入类型实参
        class Generator2 implements GenericityInterface<String>{
            @Override
            public String value() {
                return "泛型接口测试";
            }
        }
    }

    /**
     * 泛型方法的使用
     */
    @Test
    public void example4(){
        //普通类中的泛型方法
        Integer integer = this.genericityMethod(10);
        System.out.println(integer);

        String s = this.genericityMethod2(new SecureRandom());
        System.out.println(s);

        //泛型类中的泛型方法
        GenericityMethod genericityMethod = new GenericityMethod();
        String value = genericityMethod.getValue("张三", 20);
        System.out.println(value);

        //泛型类中的静态方法使用泛型
        String valueStatic = GenericityMethod.getValueStatic("张三", 20);
        System.out.println(valueStatic);
    }

    //private与T之间的<T>是为了声明该方法是泛型方法，<T>后面的T是为了返回一个T类型(也可以返回其他类型)，方法中的T则是使用T类型入参
    private <T> T genericityMethod(T t){
        return t;
    }
    //返回String类型的泛型方法，T类型继承自Random，则方法中的T类型可以接受Random以及Random所有的子类
    private <T extends Random> String genericityMethod2(T t){
        return String.valueOf(t.nextInt());
    }
}

/**
 * 泛型类
 */
class GenericityClass<T>{ //此处可以写成任意标识，在使用泛型时再指定T的具体类型

    private T value; //属性为T类型

    GenericityClass(T value){ //构造方法入参为T类型
        this.value = value;
    }

    public T getValue() { //get方法返回值为T类型
        return value;
    }
}

/**
 * 泛型通配符
 */
class GenericityCommonSymbol{

    //这里的?是类型实参，不是类型形参，代表的是未知类型。当然这里也可以使用Object，但Object需要作类型强转容易出错，而?不需要。
    GenericityCommonSymbol(GenericityClass<?> genericityClass){
        System.out.println(genericityClass.getValue());
    }
}

/**
 * 泛型类中的泛型方法
 */
class GenericityMethod<T>{

    public <E> String getValue(T t, E e){ //T为泛型类的泛型，E为泛型方法中的泛型
        return t.toString() + e.toString();
    }

    public static <T,E> String getValueStatic(T t,E e){ //此处的T不是泛型类的T，而是静态方法的泛型T。静态方法不能使用泛型类的泛型，必须声明自己的泛型。
        return t.toString() + e.toString();
    }
}
