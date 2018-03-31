package javaweb.f1.chapter1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @date 2018/3/24
 * @description
 */
public class JavaNewCharacter {
    //泛型实例化简写
    public static void main(String[] args) {
        Map<String, Map<String, List<Object>>> map1 = new HashMap<String, Map<String, List<Object>>>();
        Map<String, Map<String, List<Object>>> map2 = new HashMap<>();
    }

    //简化try-catch-finally块管理可关闭的资源
    //未简化之前
    public void character2() {
        String file = "D:\\GitRepositories\\learn-parent\\learn-javaweb\\javaweb-g2\\test.txt";
        String charset = "utf-8";
        //将写字符转换成字节流
        FileOutputStream outputStream = null;
        OutputStreamWriter writer = null;
        try {
            outputStream = new FileOutputStream(file);
            writer = new OutputStreamWriter(outputStream, charset);
            writer.write("这是一段用来测试的文本，测试字符流到字节流的转换！");
        } catch (IOException e) {
            throw new RuntimeException("文件写入失败");
        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("输出流关闭失败");
            }
        }
    }

    //简化之后
    public void character3() {
        String file = "D:\\GitRepositories\\learn-parent\\learn-javaweb\\javaweb-g2\\test.txt";
        String charset = "utf-8";
        //将写字符转换成字节流
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);
            writer.write("这是一段用来测试的文本，测试字符流到字节流的转换！");
        } catch (IOException e) {
            throw new RuntimeException("文件写入失败");
        }
    }

    //捕捉多个异常
    public void character4() {
        /*try {
            //代码块
        } catch (MyException | YourException e) {
            //异常处理
        }*/
    }

    //lambda表达式
    public void character5() {
        //简化之前
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //代码块
            }
        });

        //简化之后
        Thread thread2 = new Thread(() -> {
            //代码块
        });

        //也可以这样写
        Thread thread3 = new Thread(this::dosomething);
    }

    public void dosomething() {
        //代码块
    }
}
