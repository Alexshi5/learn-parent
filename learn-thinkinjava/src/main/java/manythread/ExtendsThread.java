package manythread;

/**
 * author Alex
 * date 2019/3/1
 * description 第一种多线程的创建方法：继承Thread类
 */
public class ExtendsThread {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("张三");
        MyThread2 thread2 = new MyThread2("李四");

        //在没有调用start()方法之前thread1和thread2都处于新建状态
        thread1.start();
        thread2.start();

        for(int i = 0;i<500;i++){
            System.out.println("主线程" + i);
        }
    }
}

//线程张三
class MyThread1 extends Thread{
    MyThread1(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0;i< 500;i++){
            System.out.println(this.getName() + i);
        }
    }
}

//线程李四
class MyThread2 extends Thread{
    MyThread2(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0;i< 500;i++){
            System.out.println(this.getName() + i);
        }
    }
}
