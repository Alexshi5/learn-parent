package com.thinkinjava.chapter3;

import java.io.*;

/**
 * author Alex
 * date 2018/5/29
 * description 将文件复制到同级的另一个目录下
 */
public class Example13 {
    public static void main(String[] args) {
        File record = new File("D:\\Test\\Record\\test.txt");
        File bakDir = new File("D:\\Test\\RecordBak");
        Example13.copyFile(bakDir, record);
    }

    public static void copyFile(File bakDir, File record) {
        System.out.println("正在准备复制文件......");
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        int length = 0;
        byte[] bytes = new byte[1024];
        if (!bakDir.exists()) {
            bakDir.mkdir();
        }
        try {
            System.out.println("将要复制的文件名为：" + record.getName());
            inputStream = new FileInputStream(record);
            outputStream = new FileOutputStream(bakDir + File.separator + record.getName());
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
            System.out.println(record.getName() + "文件复制完成！");
        } catch (IOException e) {
            throw new RuntimeException("复制文件出现异常！");
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                    System.out.println("输入流已关闭！");
                }
            } catch (Exception e1) {
                throw new RuntimeException("输入流关闭异常！");
            }

            try {
                if (null != outputStream) {
                    outputStream.close();
                    System.out.println("输出流已关闭！");
                }
            } catch (Exception e2) {
                throw new RuntimeException("输出流关闭异常！");
            }
        }
    }

}
