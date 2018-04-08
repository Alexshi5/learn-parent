package javaf1.chapter3;

public class AssignAction1 {
    public static void main(String[] args) {
        Number num1 = new Number();
        Number num2 = new Number();
        num1.a = 10;
        num2.a = 20;
        System.out.println(num1.a + "==" + num2.a);//10==20

        num1 = num2;
        System.out.println(num1.a + "==" + num2.a);//20==20
        System.out.println(num1 == num2);//true，num1和num2都指向原本num2指向的对象

        num1.a = 25;
        System.out.println(num1.a + "==" + num2.a);//25==25，num1和num2指向的对象相同，所以这里是一样的
    }
}
