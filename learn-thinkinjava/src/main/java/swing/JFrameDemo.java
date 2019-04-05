package swing;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

/**
 * author Alex
 * date 2019/4/5
 * description
 */
public class JFrameDemo {
    public static void main(String[] args) {
        JFrameDemo demo = new JFrameDemo();
        demo.example3();
        //demo.example2();
        //demo.example1();
    }

    @Test
    public void example3(){
        JFrame frame = new JFrame("演示窗口3");
        JPanel panel = new JPanel(new BorderLayout());
        JButton button = new JButton("演示按钮3");

        //将按钮组件添加进内容窗格中
        panel.add(button,BorderLayout.CENTER);
        //为内容窗格设置背景颜色
        panel.setBackground(Color.BLUE);
        //将内容窗格添加到窗口容器中并设置内容窗格在窗口的南侧
        frame.getContentPane().add(panel,BorderLayout.SOUTH);

        //设置窗口容器的背景颜色
        frame.setBackground(Color.red);
        frame.setSize(500,300);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Test
    public void example2(){
        //创建顶层窗口容器
        JFrame frame = new JFrame("演示窗口2");
        JButton button = new JButton("演示按钮2");
        //创建一个新的内容窗格，并为该内容窗格设置新的布局管理器
        JPanel panel = new JPanel(new BorderLayout());
        //将按钮组件添加到内容窗格中
        panel.add(button, BorderLayout.CENTER);
        //将内容窗格添加到窗口容器中
        frame.setContentPane(panel);
        //设置窗口自适应
        frame.pack();
        //设置窗口可见
        frame.setVisible(true);
        //设置退出时关闭窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Test
    public void example1(){
        JFrame frame = new JFrame("演示窗口1");
        JButton button = new JButton("演示按钮1");
        //获取窗口容器
        Container container = frame.getContentPane();
        //将按钮添加到窗口容器中并居中
        container.add(button,BorderLayout.CENTER);
        //将窗口设置为自适应
        frame.pack();
        //将窗口设置为可见
        frame.setVisible(true);
        //设置退出时关闭窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
