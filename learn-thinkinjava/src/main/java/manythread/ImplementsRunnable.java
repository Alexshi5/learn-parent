package manythread;

/**
 * author Alex
 * date 2019/3/1
 * description 第二种多线程的创建方法：实现Runnable接口
 */
public class ImplementsRunnable {
    public static void main(String[] args) {
        //创建任务线程
        MyThread3 mt = new MyThread3();

        //创建执行任务的线程
        Thread thread1 = new Thread(mt, "张三");
        Thread thread2 = new Thread(mt, "李四");

        thread1.start();
        thread2.start();
    }
}

//实现Runnable接口的线程
class MyThread3 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<500;i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
