package Action;

import Config.MainFrame;
import Config.MainPanel;
import Config.Neo_Button;
import lan.pojo.Supermarket;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SuperMarketInsertAction implements ActionListener {

    public static JFrame menuFrame;

    @Override
    public void actionPerformed(ActionEvent e){

        System.out.println("insert market info");
        menuFrame = new MainFrame("添加商场信息");
        menuFrame.setSize(300,200);
        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField supermarketId = new JTextField("请输入id");
        supermarketId.setBounds(50,20,100,25);
        JTextField supermarketName = new JTextField("请输入商场名");
        supermarketName.setBounds(50,50,100,25);
        JTextField address = new JTextField("请输入地址");
        address.setBounds(50,80,100,25);
        JTextField contactNumber = new JTextField("请输入联系方式");
        contactNumber.setBounds(50,110,100,25);

        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start insert");
                    Supermarket neo_supermarket = new Supermarket(supermarketId.getText(), supermarketName.getText(), address.getText(), contactNumber.getText());
                    SupermarketService.insert(neo_supermarket);
                    System.out.println("close insert");
                    menuFrame.dispose();
                }catch (Exception E){}

            }
        });
        btn.setBounds(180,50,100,50);
        btn.setFocusPainted(false);

        menuPanel.add(supermarketId);
        menuPanel.add(supermarketName);
        menuPanel.add(address);
        menuPanel.add(contactNumber);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);


    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
