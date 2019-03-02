package manythread;

/**
 * author Alex
 * date 2019/3/1
 * description 使用同步锁解决线程安全的问题：模拟火车网上售票业务
 */
public class SynBlockThread {
    public static void main(String[] args) {
        //创建卖票任务对象
        Ticket ticket = new Ticket();

        //三个售票窗口
        Thread thread1 = new Thread(ticket,"窗口一");
        Thread thread2 = new Thread(ticket,"窗口二");
        Thread thread3 = new Thread(ticket,"窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//业务线程
class Ticket implements Runnable{
    //火车票的总数
    private int num = 100;
    //锁对象
    private final Object obj = new Object();

    @Override
    public void run() {
        while (true){//无限循环代表售票业务一直存在
            synchronized (obj){//添加同步锁，使用obj对象作为对象锁
                if(num > 0){//只有票的总数大于0才能进行售票
                    try {
                        //休眠50毫秒，模拟出票时间
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前总票数：" + num-- + "，" + Thread.currentThread().getName() + "开始售票");
                }
            }
        }
    }
}
