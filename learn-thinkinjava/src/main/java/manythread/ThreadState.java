package manythread;

/**
 * author Alex
 * date 2019/3/1
 * description 线程状态的测试
 */
public class ThreadState {
    public static void main(String[] args) throws Exception{
        ThreadState test = new ThreadState();
        //test.newToRunnable();
        //test.runnableToTerminated();
        //test.runnableToBlockedOrTimedWaiting();
        test.runnableToWaiting();
    }

    //状态RUNNABLE到WAITING的状态转化
    private void runnableToWaiting() throws Exception{
        //无限等待使用Object中的wait方法完成，直到有其他线程进行唤醒操作
        //两个线程执行不同的操作，关联的两个线程使用同样的锁，只能使用锁对象的wait()和notify()
        final Object obj = new Object();
        Thread t1 = new Thread("张三"){
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        System.out.println("1.调用wait方法，线程" + Thread.currentThread().getName() + "开始进入无限等待");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("5.线程已经被唤醒，无限等待结束");
                    //张三获取到锁进入RUNNABLE状态
                    System.out.println("6." + Thread.currentThread().getName() + Thread.currentThread().getState());
                }
            }
        };
        t1.start();

        Thread.sleep(3000);
        System.out.println("2." + t1.getName() + t1.getState());

        Thread.sleep(3000);
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("3.开始唤醒线程张三");
                    //将唤醒所有与锁对象关联的线程
                    obj.notify();
                    //此时线程张三被唤醒但没获取到锁，所以进入BLOCKED状态
                    System.out.println("4." + t1.getName() + t1.getState());
                }
            }
        }.start();

        Thread.sleep(3000);
        System.out.println("7." + t1.getName() + t1.getState());
    }

    //状态RUNNABLE到BLOCKED和TIMED_WAITING的状态转化
    private void runnableToBlockedOrTimedWaiting() throws Exception{
        Object obj = new Object();
        Thread thread1 = new MyThreadSyn1("张三",obj);
        Thread thread2 = new MyThreadSyn2("李四",obj);
        thread1.start();
        thread2.start();

        System.out.println("1."+ thread1.getName() + thread1.getState());
        System.out.println("2."+ thread2.getName() + thread2.getState());
        //主线程休眠2秒钟，让业务线程执行，当执行到休眠5秒的时间观察线程状态变化
        Thread.sleep(2000);
        System.out.println("5." + thread1.getName() + thread1.getState());
        System.out.println("6." + thread2.getName() + thread2.getState());
    }

    //状态RUNNABLE到TERMINATED的转化
    private void runnableToTerminated()throws Exception{
        Thread thread = new Thread(new MyThread(),"张三");
        thread.start();
        System.out.println("当前线程状态为：" + thread.getState());

        //让主线程休眠5秒钟，不去跟新建的线程抢CPU运行时
        Thread.sleep(5000);
        System.out.println("当前线程状态为：" + thread.getState());
    }

    //状态NEW到RUNNABLE的转化
    private void newToRunnable(){
        Thread thread = new Thread(new MyThread(),"张三");
        System.out.println("当前线程状态为：" + thread.getState());
        thread.start();
        System.out.println("当前线程状态为：" + thread.getState());
    }
}

//自定义线程1，业务中包含同步锁
class MyThreadSyn1 extends Thread{
    private Object obj;
    //构造方法除了传一个名字之外，还要传两个线程共同使用的锁对象
    MyThreadSyn1(String name, Object obj){
        super(name);
        this.obj = obj;
    }
    @Override
    public void run(){
        synchronized (obj){
            System.out.println("3." + Thread.currentThread().getName()+"线程开始执行业务逻辑");
            System.out.println("4." + Thread.currentThread().getName() + Thread.currentThread().getState());
            try {
                //当前线程休眠5秒钟
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("7." + Thread.currentThread().getName()+"线程的业务逻辑执行完毕");
        }
    }
}

//自定义线程2，业务中包含同步锁
class MyThreadSyn2 extends Thread{
    private Object obj;
    //构造方法除了传一个名字之外，还要传两个线程共同使用的锁对象
    MyThreadSyn2(String name, Object obj){
        super(name);
        this.obj = obj;
    }
    @Override
    public void run(){
        synchronized (obj){
            System.out.println("8." + Thread.currentThread().getName()+"线程开始执行业务逻辑");
            System.out.println("9." + Thread.currentThread().getName() + Thread.currentThread().getState());
            try {
                //当前线程休眠5秒钟
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("10." + Thread.currentThread().getName()+"线程的业务逻辑执行完毕");
        }
    }
}

//实现了Runnable接口的自定义线程
class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("自定义线程正在执行中。。。");
    }
}
