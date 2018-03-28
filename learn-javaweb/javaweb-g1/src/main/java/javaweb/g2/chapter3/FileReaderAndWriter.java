package javaweb.g2.chapter3;

import org.junit.Test;

import java.io.*;

/**
 * @author Alex
 * @date 2018/3/24
 * @description
 */
public class FileReaderAndWriter {
    @Test
    public void test(){
        FileReaderAndWriter writer=new FileReaderAndWriter();
        System.out.println(writer);
    }
    public static void main(String[] args) {
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
        //读取字节转换成字符
        FileInputStream inputStream = null;
        InputStreamReader reader = null;
        try {
            inputStream = new FileInputStream(file);
            reader = new InputStreamReader(inputStream, charset);
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[100];
            int length = 0;
            while ((length = reader.read(chars)) != -1) {
                buffer.append(chars, 0, length);
            }
            System.out.println(buffer.toString());
        } catch (IOException e) {
            throw new RuntimeException("文件读取失败");
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("输入流关闭失败");
            }
        }

    }

}
