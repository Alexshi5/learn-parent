package javaf1.chapter3;

/**
 * author Alex
 * date 2018/4/7
 * description
 */
class Num {
    int val;

    public Num() {
    }

    public Num(int val) {
        this.val = val;
    }
}

public class Example3 {
    public static void main(String[] args) {
        Num num1 = new Num(20);
        Num num2 = new Num(20);
        System.out.println(num1.equals(num2));//false，这是由于Num类没有重写equals方法，java默认是比较引用

    }
}
