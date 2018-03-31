package javaf1.chapter2;

import org.junit.Test;

/**
 * author Alex
 * date 2018/3/31
 * description
 */
public class SimpleExample2 {
    boolean b;
    char c;
    byte be;
    short s;
    int i;
    long l;
    float f;
    double d;

    @Test
    public void example() {
        System.out.println(b);
        System.out.println(c);
        System.out.println(be);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
    }

    public int example1(String s) {
        return s.length() * 2;
    }
}
