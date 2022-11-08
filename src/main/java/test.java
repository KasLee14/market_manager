

import lan.pojo.Supermarket;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class test {

    public static void main(String[] args) {
        JFrame f=new JFrame("文本框加入面板");
        JPanel jp = new JPanel();
        JTextField jt = new JTextField(10);

        f.setBounds(400,400,500,500); //设置窗口位置大小
        jp.setSize(200,200);                //设置面板大小
        jt.setSize(100,100);                //设置文本框大小

        jp.add(jt);                         //将文本框加入到面板
        f.add(jp);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
