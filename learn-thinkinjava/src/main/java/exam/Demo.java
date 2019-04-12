package exam;

import java.util.Vector;

/**
 * author Alex
 * date 2019/4/5
 * description
 */
public class Demo {
    private int txx = 1;
    public static void main(String[] args) throws Exception{
        Demo demo = new Demo();
        demo.example5();

        //demo.example4();
        //demo.example3();
        //System.out.println(demo.getNum1());
        //demo.example2();
        //demo.example1();
        //System.out.println(demo.getNum(100));
    }

    private void example6(){
        
    }

    private void example5(){
        Vector vector = new Vector();
        vector.add("test");
        vector.add("is");
        boolean test = vector.contains("test");
        System.out.println(test);
        System.out.println(vector);
        vector.remove("test");
        System.out.println(vector);
    }

    private void example4()throws Exception{
        int k = 3,sum = 0,x;
        for(int i = 1;i<=k;i++){
            x=1;
            for(int j=1;j<=i;j++){
                x=x*j;
            }
                sum +=x;

        }
        System.out.println(sum);
    }

    //测试局部变量屏蔽成员变量
    private void example3(){
        int txx = 3;
        System.out.println(this.txx);
    }

    private int getNum1(){
        int a = 2,b = 9,d;
        double c = 1.6;
        d = (int)(a * b - c);
        return d;
    }

    private void example2(){
        boolean a,b,c;
        a = false;b = true;c = false;
        a = a||c&&c;
        b = a&&(b||c);
        c = b&&a&&c;
        System.out.println(a + "==" + b + "==" + c);
    }

    private void example1(){
        int a = 1,b = 3,c = 6,d;
        d = (a + b * 3) % c >> 1;
        System.out.println(d);
    }

    //计算整数n的位数
    private int getNum(int n){
        int x = 0;
        do{
            n /= 10;
            x++;
        }while (n > 0);
        return x;
    }
}
