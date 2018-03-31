package javaf1.chapter2;

import org.junit.Test;

/**
 * author Alex
 * date 2018/3/31
 * description
 */
public class SimpleExample3 {
    public int example1(String s) {
        return s.length() * 2;
    }

    @Test
    public void test() {
        SimpleExample3 example3 = new SimpleExample3();
        int i = example3.example1("张三");
        System.out.println(i);
    }

    public void example2() {
        System.out.println("李四");
    }
}
