package Action.SuperMarket;

import Config.*;
import lan.pojo.Supermarket;
import lan.service.SupermarketService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperMarketDeleteAction implements ActionListener{


    public static JFrame menuFrame;
    private SupermarketService supermarketService = new SupermarketService();

    @Override
    public void actionPerformed(ActionEvent e){

        menuFrame = new MinorFrame("删除商场信息");

        JPanel menuPanel = new MainPanel();
        menuPanel.setSize(300,200);

        JTextField deleteID = new JTextField("请输入要删除的商场的id");
        deleteID.setBounds(75,20,150,25);
        Neo_Button btn = new Neo_Button("提交",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.println("start supermarket deleting");
                    supermarketService.deleteById(deleteID.getText());
                    System.out.println("close supermarket deleting");
                    menuFrame.dispose();
                }catch (Exception E){}

            }
        });
        btn.setBounds(100,70,100,50);
        btn.setFocusPainted(false);

        menuPanel.add(deleteID);
        menuPanel.add(btn);

        menuFrame.setContentPane(menuPanel);
        menuFrame.setLocationRelativeTo(null);


    }

    public static void getJFrame(JFrame jFrame) {
        menuFrame = jFrame;
    }

}
