package manythread;

/**
 * author Alex
 * date 2019/3/16
 * description 测试join()的使用方法
 * 原则1：当为join()时会调用wait(0)阻塞join()，即阻塞调用join()方法的线程（前提是该线程是存活的），
 * 当任务线程执行结束后wait(0)被自动唤醒不再阻塞join()
 *
 * 原则2：当为join(1000)时会调用wait(1000)来阻塞join()，等待时间结束再继续执行join()，
 * 由于wait(1000)方法执行结束后，join()方法还有一行代码要执行，如果任务线程有同步锁的话，
 * 那么join将会尝试获取锁，如果获取不到锁则会阻塞在那里直到获取到锁
 *
 * 可以参考：https://www.cnblogs.com/xudilei/p/6867045.html
 */
public class ThreadExample1 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {//任务线程
            try {
                System.out.println("3." + Thread.currentThread().getState() + "_" + System.currentTimeMillis());
                Thread.sleep(2000);
            }catch (Exception e){
                e.getStackTrace();
            }
            System.out.println("4.张");
            System.out.println("5." + Thread.currentThread().getState());
        });
        System.out.println("1." + thread.getState());
        thread.start();

        try{
            System.out.println("2." + thread.getState() + "_" + System.currentTimeMillis());
            thread.join(2000);
            System.out.println("6." + thread.getState());
        }catch (Exception e){
            e.getStackTrace();
        }
        System.out.println("7.三");
    }
}
