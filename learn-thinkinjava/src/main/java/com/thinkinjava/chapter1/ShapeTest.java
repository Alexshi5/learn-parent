package com.thinkinjava.chapter1;

import org.junit.Test;

/**
 * 测试类
 */
public class ShapeTest {
    @Test
    public void test() {
        Line line = new Line();
        Triangle triangle = new Triangle();
        doSomething(line);//this is Line
        doSomething(triangle);//this is triangle
    }

    public void doSomething(Shape shape) {
        shape.draw();
    }
}
