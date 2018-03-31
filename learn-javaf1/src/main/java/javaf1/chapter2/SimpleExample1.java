package javaf1.chapter2;

import org.junit.Test;

/**
 * author Alex
 * date 2018/3/31
 * description
 */
public class SimpleExample1 {
    int i;
    double d;

    @Test
    public void example4() {
        SimpleExample1 example = new SimpleExample1();
        example.i = 10;//引用一个对象的成员
        System.out.println(example.i + "==" + d);//10==0.0
    }
}
