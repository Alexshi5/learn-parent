package manythread;

/**
 * author Alex
 * date 2019/3/16
 * description 测试多线程数组的执行
 */
public class ThreadExample2 {
    public static void main(String[] args) {
        char[] characters = {'张','三','丰'};
        Thread[] threads = new Thread[3];
        for(int i=0;i<3;i++){
            threads[i] = new Thread(() -> {
                for(char c:characters){
                    System.out.print(c);
                }
                System.out.print("\t");
            });
        }

        for(Thread thread:threads){
            thread.start();
        }
    }
}
