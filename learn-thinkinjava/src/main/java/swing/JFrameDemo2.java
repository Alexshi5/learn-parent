package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * author Alex
 * date 2019/4/5
 * description
 */
public class JFrameDemo2 extends WindowAdapter implements ActionListener {
    private JTextField textField;
    private boolean flag = true;

    public static void main(String[] args) {
        new JFrameDemo2().example();
    }

    public void example(){
        JFrame frame = new JFrame("演示窗口");
        JPanel panel = new JPanel(new BorderLayout());
        JButton button = new JButton("演示按钮");
        this.textField = new JTextField();

        button.addActionListener(this);
        panel.add(button,BorderLayout.CENTER);
        panel.add(textField,BorderLayout.SOUTH);
        frame.getContentPane().add(panel,BorderLayout.CENTER);
        frame.addWindowListener(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = "测试文本一";
        String str2 = "测试文本二";
        if(flag){
            textField.setText(str1);
            flag = false;
        }else {
            textField.setText(str2);
            flag = true;
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
